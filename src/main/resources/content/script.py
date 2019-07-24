#!/usr/bin/env python
# coding: utf-8



import json
import csv
import string
import requests
import pandas as pd
import numpy as np
import sys
import re




# Parse CQL expression so that CQL evaluation engine can resolve them
def parseCQL(input_cql_file):
	with open(input_cql_file, "r+") as f:
		old = f.read()
		old = old.replace('\\"', '"')
		old = old.replace('\\\\/', '/')
		old = old.replace('\\\\"', "'")
		old = old[0:len(old) - 1]		
		f.close()	
	return old	


# Send HTTP POST request to FHIR server and get FHIR resource bundle in JSON format
def getData(URL, body, file_name):
	headers = {'Content-Type': 'application/json'}
	result = requests.post(URL, data = json.dumps(body))
	
	with open(file_name, 'w') as outfile:
		json.dump(result.text, outfile, ensure_ascii = False)
		outfile.close()
		
	print('A JSON file has been retreived and saved!')	



# Preprocessed unstructured JSON data
def preprocessData(json_file_name, preprocess_json_file_name, temp_csv_file_name):	
    
    with open(json_file_name, "r+") as f:
        old = f.read()
        old = old.replace('\\"', '"')
        old = old.replace('\\\\/', '/')
        old = old.replace('\\\\"', "'")
        old = old[1:len(old)-1]

        f.close()

        with open(preprocess_json_file_name, "w") as f:
            f.write(old)
            f.close()
        f = open(preprocess_json_file_name)
        data = json.load(f)

        f.close()  
        with open(temp_csv_file_name, 'w', newline='') as csvfile:
            fieldnames = ['Patient id', 'Weight', 'Height', 'Name', 'DOB', 'Gender']
            writer = csv.DictWriter(csvfile, fieldnames = fieldnames)
            writer.writeheader() 
            for item in data[0]['result']: 
                #print(item['valueQuantity'])
                pid = item['id']#.strip('smart-')
                print(pid)
                try:
                    name = item['name'][0]['given'][0] + " " + item['name'][0]['given'][1] + " " + item['name'][0]['family']
                except:
                    name = 'null'
            
                if  re.search('\d+-\d\d-\d+',item['birthDate']):
                          birthDate=item['birthDate']
                else:
                          birthDate = '0-0-0'
                        
                if(re.search('(female|male)',item['gender'])):    
                         gender = item['gender']
                else:
                        gender ='null'

                if re.search("\d+.\d+ kg",str(data[5]['result'])):
                    weight = 0
                    for witem in data[5]['result']: 
                        
                        if witem['subject']['reference'] != ("Patient/" + pid):
                                weight = 'null'
                        else:
                                weight = witem['valueQuantity']['value']
                                break
                else:
                        weight = 'null' 
                
                if re.search("\d+.\d+ cm",str(data[6]['result'])):       
                    
                         height = 0
                         for hitem in data[6]['result']:
                                if hitem['subject']['reference'] != ("Patient/" + pid):
                                        height = 'null' 
                                else:
                                        height = hitem['valueQuantity']['value']
                                        break
                else: 
                        height = 'null'
                 
                writer.writerow({'Patient id': pid, 'Weight': weight, 'Height': height, 'Name': name, 'DOB': birthDate, 'Gender':gender })


# Use the preprocessed data to compute something. It shows BMI calculation
def computeBMI(temp_csv_file, BMI_file): 
	PID = []
	weight = []
	height = []

	with open(temp_csv_file) as csvDataFile:
		csvReader = csv.reader(csvDataFile)
		next(csvReader)
    
		for row in csvReader:
			PID.append(row[0])
			height.append(float(row[2])/100)
			weight.append(float(row[1]))
        
		PID_arr = np.asarray(PID)
		weight_arr = np.asarray(weight)
		height_arr = np.asarray(height)

		BMI = []
		for i in range(0, len(height_arr)):    
			if 0 < weight_arr[i] and 0 < height_arr[i] < 2.72:
				BMI_calc = round(weight_arr[i] / height_arr[i] ** 2, 1)
				BMI.append(BMI_calc)   
			else:
				raise ValueError('Invalid height or weight')
       
		body_mass_index = BMI
		BMI_arr = np.asarray(body_mass_index)

		bmiDF = pd.DataFrame({'BMI':BMI_arr})
		pidDF = pd.DataFrame({'PID':PID_arr})

		pidDF.reset_index(drop=True, inplace=True)
		bmiDF.reset_index(drop=True, inplace=True)

		finalDF = pd.concat([pidDF, bmiDF], axis=1)

		#print(finalDF)
		finalDF.to_csv(BMI_file, sep = ',', encoding = 'utf-8', index = False)
		print('BMI file has been generated!')


#Encapsulate the above functions: CQL parsing, querying FHIR server, 
#getting the data, preprocessing the data and finally computing BMI
def main(input_cql_file, terminologyServiceUri, dataServiceUri, cqlEngineURL):	
	cqlCode = parseCQL(input_cql_file)
	
    #Generating JSON body for HTTP POST request to FHIR server
	queryBody = {
		"code": cqlCode,
		"terminologyServiceUri": terminologyServiceUri,
		"dataServiceUri": dataServiceUri,
		'Content-Type': 'application/json'
	}

	body = 	{
	"code":"library PhenotypeLibrary version '0.0.1' \n\nusing FHIR version '3.0.0' \n\nvalueset \"Weight\": 'vs-weight' \nvalueset \"Height\": 'vs-height' \nvalueset \"Chest pain\": 'vs-chest-pain' \nvalueset \"Heart Rate\": 'vs-heart-rate' \n\ncontext Patient \n\ndefine InDemographic: \n  InclusionCriteria \n\ndefine InclusionCriteria: \n  exists ([Condition: \"Chest pain\"]) \n  and  exists ( \n    [Observation: \"Heart Rate\"] //O \n      //where O.valueQuantity.value > 23 \n  ) \n  and  AgeInYears() > 15 \n  \ndefine Weights: \n  Last ( \n    [Observation: \"Weight\"] O \n      sort by effective.value\n  ) \n\ndefine Heights: \n  Last ( \n    [Observation: \"Height\"] O \n      sort by effective.value\n  ) \n\n",
	"terminologyServiceUri":"http://fhir-server.com:8080/baseDstu3/",
	"dataServiceUri":"http://fhir-server.com:8080/baseDstu3/",
		"cqlEngineURL":"http://cql-engine.com:8082/cql/evaluate/"
	}    

	#print(queryBody)
	json_to_save = "data.json" # Change the path
	print(str(queryBody))
          
	json_object = getData(cqlEngineURL, queryBody, json_to_save)
	
	input_json_file_name = json_to_save
	preprocess_json_file = "temp.json" # Change the path
	temp_csv_file = "test.csv" # Change the path
	
	preprocessData(input_json_file_name, preprocess_json_file, temp_csv_file)
	
	input_phenotype = temp_csv_file	
	BMI_file = "BMI1.csv" # # Change the path
		
	computeBMI(temp_csv_file = input_phenotype, BMI_file = BMI_file)



#Provide the URL to CQL evaluation engine
cqlEngineURL = "http://cql-engine.com:8082/cql/evaluate/",
"\n",
"#Provide the URL to FHIR server\n",
dataServiceUri = "http://fhir-server.com:8080/baseDstu3/",
"\n",
"# A FHIR terminology service is simply a set of functions built on the definitions provided by a collection of CodeSystem, \n",
"# ValueSet and ConceptMap resources, with additional inherently known terminologies providing support. \n",
"#The terminology service builds on the basic principles for using terminologies in FHIR, \n",
"# which comes with the support of Terminology Service Capability Statement Implementers should be familiar with:\n",
"    # -- Using codes in FHIR\n",
"    # -- The CodeSystem resource\n",
"    # -- The ValueSet resource\n",
"    # -- The ConceptMap resource\n",
"# It's mostly a RESTful Terminology Server"

terminologyServiceUri = "http://fhir-server.com:8080/baseDstu3/" # Holds our CodeSystem/ValueSet/ConceptMap resources"

# A FHIR terminology service is simply a set of functions built on the definitions provided by a collection of CodeSystem, 
# ValueSet and ConceptMap resources, with additional inherently known terminologies providing support. 
#The terminology service builds on the basic principles for using terminologies in FHIR, 
# which comes with the support of Terminology Service Capability Statement Implementers should be familiar with:
    # -- Using codes in FHIR
    # -- The CodeSystem resource
    # -- The ValueSet resource
    # -- The ConceptMap resource
# It's mostly a RESTful Terminology Server  
##menzel.informatik.rwth-aachen.de
terminologyServiceUri = "http://menzel.informatik.rwth-aachen.de:8082/cql/evaluate/" # Holds our CodeSystem/ValueSet/ConceptMap resources

# An example of CodeSystem bundle
'''
{
  "resourceType": "Bundle",
  "type": "transaction",
  "entry": [
    {
      "resource": {
        "resourceType": "CodeSystem",
        "id": "loinc",
        "url": "http://loinc.org",
        "name": "CodeSystem LOINC",
        "status": "draft",
        "concept": []
      }
    },
    {
      "resource": {
        "resourceType": "CodeSystem",
        "id": "snomed-ct",
        "url": "http://snomed.info/sct",
        "name": "CodeSystem SNOMED-CT",
        "status": "draft",
        "concept": []
      }
    }
  ]
}
'''
# An example of a FHIR resource for condition ValueSet 
'''
{
      "resource": {
        "resourceType": "ValueSet",
        "id": "vs-chest-pain",
        "title": "Chest pain",
        "compose": {
          "include": [
            {
              "system": "http://snomed.info/sct",
              "concept": [
                [
                  {
                    "code": "29857009",
                    "display": "Chest pain",
                    "system": "http://snomed.info/sct"
                  }
                ]
              ]
            }
          ]
        }
      }
    }
'''
# An example of a FHIR resource for observation ValueSet    
'''
    {
      "resource": {
        "resourceType": "ValueSet",
        "id": "vs-weight",
        "title": "Weight",
        "compose": {
          "include": [
            {
              "system": "http://loinc.org",
              "concept": [
                [
                  {
                    "code": "3141-9",
                    "display": "weight"
                  }
                ]
              ]
            }
          ]
        }
      }
    }    
'''
input_cql_file = 'input2.cql' # Change the path
CQL = parseCQL(input_cql_file) 

main(input_cql_file = input_cql_file, cqlEngineURL = cqlEngineURL, dataServiceUri = dataServiceUri, terminologyServiceUri = terminologyServiceUri)



