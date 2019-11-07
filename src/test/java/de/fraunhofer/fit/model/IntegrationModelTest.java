package de.fraunhofer.fit.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;

import de.fraunhofer.fit.train.model.IntegrationInput;
import de.fraunhofer.fit.train.model.IntegrationInputProperties;
import de.fraunhofer.fit.train.model.IntegrationInputWagon;
import de.fraunhofer.fit.train.model.IntegrationOutput;
import de.fraunhofer.fit.train.model.IntegrationOutputResult;
import de.fraunhofer.fit.train.model.IntegrationOutputWagon;


public class IntegrationModelTest {
	
	
	@Test
	public void parseOutputToJsonTest() {
		IntegrationOutput integrationOutput1 = new IntegrationOutput();
		integrationOutput1.setCorrelationId("06643hdv-dvrv344-frvrvrv-44598776");
		integrationOutput1.setTrainId("5d85a4deca90827e9e05fc6a");
		
		List<IntegrationOutputWagon> integrationOutputWagonList = new ArrayList<IntegrationOutputWagon>();
		IntegrationOutputWagon integrationOutputWagon1 = new IntegrationOutputWagon();
		IntegrationOutputWagon integrationOutputWagon2 = new IntegrationOutputWagon();
		IntegrationOutputWagon integrationOutputWagon3 = new IntegrationOutputWagon();
		integrationOutputWagon1.setWagonId("3456789976545678");
		integrationOutputWagon2.setWagonId("3456789976545678");
		integrationOutputWagon3.setWagonId("3456789976545678");
		//integrationOutputWagon1.setIntegrationOutputResult(integrationOutputResult);
		List<IntegrationOutputResult> integrationOutputResult = new ArrayList<IntegrationOutputResult>();
		IntegrationOutputResult integrationOutputResult1 = new IntegrationOutputResult();
		IntegrationOutputResult integrationOutputResult2 = new IntegrationOutputResult();
		IntegrationOutputResult integrationOutputResult3 = new IntegrationOutputResult();
		integrationOutputResult1.setDescription("mean");
		integrationOutputResult1.setMimetype("double/text");
		integrationOutputResult1.setRepositoryImageId("byuiffgfgdbt54-ecvevevev-54666hj");
		integrationOutputResult1.setResult("20.76778".getBytes());
		integrationOutputResult1.setStatusCode("200");
		integrationOutputResult2.setDescription("total");
		integrationOutputResult2.setMimetype("double/text");
		integrationOutputResult2.setRepositoryImageId("343535-e32535cveve346vev-54646666hj64");
		integrationOutputResult2.setResult("407.6778,00".getBytes());
		integrationOutputResult2.setStatusCode("200");
		integrationOutputResult3.setStatusCode("500");
		integrationOutputResult3.setDescription("Internal Server Error");
		
		integrationOutputResult.add(integrationOutputResult1);
		integrationOutputResult.add(integrationOutputResult2);
		integrationOutputResult.add(integrationOutputResult3);
		
		integrationOutputWagon1.setIntegrationOutputResult(integrationOutputResult.toArray(new IntegrationOutputResult[integrationOutputResult.size()]));
		integrationOutputWagon2.setIntegrationOutputResult(integrationOutputResult.toArray(new IntegrationOutputResult[integrationOutputResult.size()]));
		integrationOutputWagon3.setIntegrationOutputResult(integrationOutputResult.toArray(new IntegrationOutputResult[integrationOutputResult.size()]));
		
		integrationOutputWagonList.add(integrationOutputWagon1);
		integrationOutputWagonList.add(integrationOutputWagon2);
		integrationOutputWagonList.add(integrationOutputWagon3);
		integrationOutput1.setIntegrationOutputWagon(integrationOutputWagonList.toArray(new IntegrationOutputWagon[integrationOutputWagonList.size()]));

		Gson gson = new Gson();
		String jsonFormat = gson.toJson(integrationOutput1);
		System.out.println(jsonFormat);
	}
	
	@Ignore
	@Test
	public void parseInputToJsonTest() {
		IntegrationInput input = new IntegrationInput();
		input.setCorrelationId("06643hdv-dvrv344-frvrvrv-44598776");
		input.setTrainId("5d85a4deca90827e9e05fc6a");
		List<IntegrationInputWagon> integrationInputWagonList = new ArrayList<IntegrationInputWagon>();
		
		//==Wagon 1
		IntegrationInputWagon integrationInputWagon1 = new IntegrationInputWagon();
		integrationInputWagon1.setWagonId("5d85a4deca569586776e05fc6a");
		List<String> artifactsList = new ArrayList<String>();
		artifactsList.add("http://menzel.informatik.rwth-aachen.de:9999/5d80e888a13813ba54f7b154/CancerSqlQuery.sql");
		artifactsList.add("http://menzel.informatik.rwth-aachen.de:9999/5d80e888a13813ba54f7b154/DiabetesSparqlQuery.rq");
		artifactsList.add("http://menzel.informatik.rwth-aachen.de:9999/5d80e888a13813ba54f7b154/HepatitisFihrQuery.sh");
		integrationInputWagon1.setArtifacts(artifactsList.toArray(new String[artifactsList.size()]));
		List<IntegrationInputProperties> integrationInputPropertiesList = new ArrayList<IntegrationInputProperties>();
		IntegrationInputProperties integrationInputProperties1 = new IntegrationInputProperties();
		integrationInputProperties1.setKey("check_rare_disease");
		integrationInputProperties1.setValue("true");
		IntegrationInputProperties integrationInputProperties2 = new IntegrationInputProperties();
		integrationInputProperties2.setKey("disease_severity");
		integrationInputProperties2.setValue("high");
		IntegrationInputProperties integrationInputProperties3 = new IntegrationInputProperties();
		integrationInputProperties3.setKey("cut_value");
		integrationInputProperties3.setValue("10000");
		integrationInputPropertiesList.add(integrationInputProperties1);
		integrationInputPropertiesList.add(integrationInputProperties2);
		integrationInputPropertiesList.add(integrationInputProperties3);
		integrationInputWagon1.setProperties(integrationInputPropertiesList.toArray(new IntegrationInputProperties[integrationInputPropertiesList.size()]));
		List<String> stationsList = new ArrayList<String>();
		stationsList.add("stn_777");
		stationsList.add("stn_333");
		stationsList.add("stn_101");
		integrationInputWagon1.setStations(stationsList.toArray(new String[stationsList.size()]));
		integrationInputWagonList.add(integrationInputWagon1);
		
		//==Wagon 2
		IntegrationInputWagon integrationInputWagon2 = new IntegrationInputWagon();
		integrationInputWagon2.setWagonId("56659767980976087");
		artifactsList = new ArrayList<String>();
		artifactsList.add("http://menzel.informatik.rwth-aachen.de:9999/5d8cb2fac923bbde11e0a499/WedDavTestqQuery1.sql");
		artifactsList.add("http://menzel.informatik.rwth-aachen.de:9999/5d8cb2fac923bbde11e0a499/WedDavTestqQuery2.sql");
		artifactsList.add("http://menzel.informatik.rwth-aachen.de:9999/5d8cb2fac923bbde11e0a499/WedDavTestqQuery3.sql");
		artifactsList.add("http://menzel.informatik.rwth-aachen.de:9999/5d8cb2fac923bbde11e0a499/WedDavTestqQuery4.sql");
		artifactsList.add("http://menzel.informatik.rwth-aachen.de:9999/5d8cb2fac923bbde11e0a499/WedDavTestqQuery5.sql");

		integrationInputWagon2.setArtifacts(artifactsList.toArray(new String[artifactsList.size()]));
		integrationInputPropertiesList = new ArrayList<IntegrationInputProperties>();
		integrationInputProperties1 = new IntegrationInputProperties();
		integrationInputProperties1.setKey("aggregate");
		integrationInputProperties1.setValue("true");
		integrationInputProperties2 = new IntegrationInputProperties();
		integrationInputProperties2.setKey("calculate_mean");
		integrationInputProperties2.setValue("true");
		integrationInputProperties3 = new IntegrationInputProperties();
		integrationInputProperties3.setKey("mean_method");
		integrationInputProperties3.setValue("print(statistics.mean(${result_data}))");
		integrationInputPropertiesList.add(integrationInputProperties1);
		integrationInputPropertiesList.add(integrationInputProperties2);
		integrationInputPropertiesList.add(integrationInputProperties3);
		integrationInputWagon2.setProperties(integrationInputPropertiesList.toArray(new IntegrationInputProperties[integrationInputPropertiesList.size()]));
		stationsList = new ArrayList<String>();
		stationsList.add("stn_303");
		stationsList.add("stn_101");
		stationsList.add("stn_999");
		integrationInputWagon2.setStations(stationsList.toArray(new String[stationsList.size()]));
		integrationInputWagonList.add(integrationInputWagon2);
		input.setIntegrationInputWagon(integrationInputWagonList.toArray(new IntegrationInputWagon[integrationInputWagonList.size()]));
		
		Gson gson = new Gson();
		String jsonFormat = gson.toJson(input);
		System.out.println(jsonFormat);
		
	}

}
