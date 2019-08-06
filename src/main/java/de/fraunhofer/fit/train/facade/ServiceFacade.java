package de.fraunhofer.fit.train.facade;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicHttpResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.fraunhofer.fit.train.model_v1.Artifacts;
import de.fraunhofer.fit.train.model_v1.Resources;
import de.fraunhofer.fit.train.model_v1.Result;
import de.fraunhofer.fit.train.model_v1.Train;
import de.fraunhofer.fit.train.model_v1.Wagons;
import de.fraunhofer.fit.train.model_v2.autogenerated.InternalId;
import de.fraunhofer.fit.train.model_v2.autogenerated.InternalPointer;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Datacite;
import de.fraunhofer.fit.train.model_v2.doi.datacite.Identifier;
import de.fraunhofer.fit.train.model_v2.doi.datacite.RelatedIdentifier;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.ArchitectureOCIEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.ContributorTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.DateTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.DescriptionTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.FunderIdentifierTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.IdentifierTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.LanguageDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.NameIdentifierSchemeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.NameTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.OsOciEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.RelatedIdentifierTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.RelationTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.ResourceTypeGeneralDataciteEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.StationProfileEnum;
import de.fraunhofer.fit.train.model_v2.doi.datacitie.helper.TitleTypeDataciteEnum;
import de.fraunhofer.fit.train.model_v2.station.StationProfiles;
import de.fraunhofer.fit.train.persistence.IArtifactRepository;
import de.fraunhofer.fit.train.persistence.IInternalIdRepository;
import de.fraunhofer.fit.train.persistence.IInternalPointerRepository;
import de.fraunhofer.fit.train.persistence.IResourceRepository;
import de.fraunhofer.fit.train.persistence.ITrainRepository;
import de.fraunhofer.fit.train.persistence.IWagonRepository;

@EnableAspectJAutoProxy
@Service
public class ServiceFacade {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired  
	private ITrainRepository trainRepository;
	
	@Autowired
	private IInternalIdRepository internalIdRepository; 

	@Autowired
	private IInternalPointerRepository internalPointerRepository;
	
	@Autowired
	private IWagonRepository wagonRepository;
	
	@Autowired
	private IResourceRepository resourceRepository;
	
	
	@Autowired
	private IArtifactRepository  artifactRepository;
	
	public String getInternalId() {
		InternalId internalId = internalIdRepository.save(new InternalId());
		return internalId.get_id().toString();
	}

	public String getInternalPointer() {
		InternalPointer internalPointer = internalPointerRepository.save(new InternalPointer());
		return internalPointer.get_id().toString();
	}
	
	public String getInternalVersion() {
		InternalId internalId = internalIdRepository.save(new InternalId());
		String internalIdStr = internalId.get_id().toString();
		InternalPointer internalPointer = internalPointerRepository.save(new InternalPointer());
		String internalPointerStr = internalPointer.get_id().toString();
		return internalIdStr+internalPointerStr+"_"+(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
	}
	
	public List<ArchitectureOCIEnum> getArchitectureEnumValues(){
		List<ArchitectureOCIEnum> enumValues = Arrays.asList(ArchitectureOCIEnum.values());
		return enumValues;
	}
	
	public List<OsOciEnum> getOsEnumValues(){
		List<OsOciEnum> enumValues = Arrays.asList(OsOciEnum.values());
		return enumValues;
	}

	public List<StationProfileEnum> getStationProfileEnumValues(){
		List<StationProfileEnum> enumValues = Arrays.asList(StationProfileEnum.values());
		return enumValues;
	}
	
	public List<ContributorTypeDataciteEnum> getContributorTypeEnumValues(){
		List<ContributorTypeDataciteEnum> enumValues = Arrays.asList(ContributorTypeDataciteEnum.values());
		return enumValues;
	}
	
	public List<DateTypeDataciteEnum> getDateTypeEnumValues(){
		List<DateTypeDataciteEnum> enumValues = Arrays.asList(DateTypeDataciteEnum.values());
		return enumValues;
	}
	
	public List<DescriptionTypeDataciteEnum> getDescriptionTypeEnumValues(){
		List<DescriptionTypeDataciteEnum> enumValues = Arrays.asList(DescriptionTypeDataciteEnum.values());
		return enumValues;
	}
	
	public List<FunderIdentifierTypeDataciteEnum> getFunderIdentifierTypeEnumValues(){
		List<FunderIdentifierTypeDataciteEnum> enumValues = Arrays.asList(FunderIdentifierTypeDataciteEnum.values());
		return enumValues;
	}
	
	public List<IdentifierTypeDataciteEnum> getIdentifierTypeEnumValues(){
		List<IdentifierTypeDataciteEnum> enumValues = Arrays.asList(IdentifierTypeDataciteEnum.values());
		return enumValues;
	}
	
	public List<LanguageDataciteEnum> getLanguageEnumValues(){
		List<LanguageDataciteEnum> enumValues = Arrays.asList(LanguageDataciteEnum.values());
		return enumValues;
	}
	
	public List<NameIdentifierSchemeDataciteEnum> getNameIdentifierSchemeEnumValues(){
		List<NameIdentifierSchemeDataciteEnum> enumValues = Arrays.asList(NameIdentifierSchemeDataciteEnum.values());
		return enumValues;
	}
	
	public List<NameTypeDataciteEnum> getNameTypeEnumValues(){
		List<NameTypeDataciteEnum> enumValues = Arrays.asList(NameTypeDataciteEnum.values());
		return enumValues;
	}
	
	public List<RelatedIdentifierTypeDataciteEnum> getRelatedIdentifierTypeEnumValues(){
		List<RelatedIdentifierTypeDataciteEnum> enumValues = Arrays.asList(RelatedIdentifierTypeDataciteEnum.values());
		return enumValues;
	}
	
	
	public List<RelationTypeDataciteEnum> getRelationTypeEnumValues(){
		List<RelationTypeDataciteEnum> enumValues = Arrays.asList(RelationTypeDataciteEnum.values());
		return enumValues;
	}
	
	public List<ResourceTypeGeneralDataciteEnum> getResourceTypeGeneralEnumValues(){
		List<ResourceTypeGeneralDataciteEnum> enumValues = Arrays.asList(ResourceTypeGeneralDataciteEnum.values());
		return enumValues;
	}
	
	public List<TitleTypeDataciteEnum> getTitleTypeEnumValues(){
		List<TitleTypeDataciteEnum> enumValues = Arrays.asList(TitleTypeDataciteEnum.values());
		return enumValues;
	}
	
	public Train saveUpdateTrain(Train train) throws IOException, NoSuchAlgorithmException{
		return trainRepository.save(train);
	}

	public Resources saveUpdateResource(Resources resources) throws IOException, NoSuchAlgorithmException{
		return resourceRepository.save(resources);
	}
	

	public Train addFilesToWebDav(Train train) throws Exception {
		
//		for(int i=0;i<train.getWagon().length;i++) {
//			
//			Wagon wagon = train.getWagon()[i];
//			for(int j=0;j<wagon.getResources().length;j++) {
//				
//				Resource resource = wagon.getResources()[j];
//				
//				for(int k=0;k<resource.getArtifact().length;k++) {
//					
//					Artifact artifact = resource.getArtifact()[k];
//					String webdavURL = doUpload(artifact,train);
//					artifact.setFileUrl(webdavURL);
//					artifact.setFiledata(null);
//				}
//				
//			}
//			
//		}
		return train;
	}
	
	//private String doUpload(Artifacts[] artifact,Train train) throws Exception {
		
		//Sardine sardine = SardineFactory.begin("root", "root");
		//String filePath = "/Users/jbjares/workspaces/TrainDORepository/tmp/"+train.getInternalId()+"/"+artifact.getFilename();
		//String webdavdir = "https://frauhofer.fit.trainmodel-webdav/"+train.getInternalId()+"/";
//		sardine.createDirectory(webdavdir);
//		FileUtils.writeStringToFile(new File(filePath),artifact.getFiledata());
//		byte[] data = FileUtils.readFileToByteArray(new File(filePath));
//		sardine.put(webdavdir+artifact.getFilename(), data);
//
//		//== set checksum File
//		artifact.setChecksum(TrainUtil.getChecksum(new File(filePath)));
//		String  filePathCheckSum = "/Users/jbjares/workspaces/TrainDORepository/tmp/"+train.getInternalId()+"/"+artifact.getFilename()+".checksum";
//		FileUtils.writeStringToFile(new File(filePathCheckSum),artifact.getChecksum());
//		byte[] dataChecksum = FileUtils.readFileToByteArray(new File(filePathCheckSum));
//		sardine.put(webdavdir+"/"+artifact.getFilename()+".checksum", dataChecksum);
//		
//		//clean
//		File tmpFolder = new File(filePathCheckSum);
//		TrainUtil.deleteDirectoryRecursionJava6(tmpFolder);
		
		//return webdavdir+"/"+artifact.getName().replace(".", "_");
		
	//}
	public Artifacts getlandpage(String trainId) throws Exception {
		Train train = findTrainById(trainId);

		String landpage = customlandpage(train,trainId);
		Artifacts artifact = new Artifacts();
		artifact.setDescription("land page");
		artifact.setFilename("welcome.html");
		artifact.setFormat(StandardCharsets.UTF_8.toString());
		artifact.setInternalId(trainId);
		artifact.setName("welcome.html");
		artifact.setFiledata(landpage);
		//Artifacts artifacts = facade.sendToDav(artifact, trainId);
		
//		RelatedIdentifier relatedIdentifier = new RelatedIdentifier();
//		relatedIdentifier.setContent(artifacts.getFileUrl());
//		relatedIdentifier.setRelatedIdentifierType("URL");
//		if(train.getDatacite().getRelatedIdentifiers()!=null && train.getDatacite().getRelatedIdentifiers().getRelatedIdentifier()!=null) {
//			train.getDatacite().getRelatedIdentifiers().getRelatedIdentifier()
//			[train.getDatacite().getRelatedIdentifiers().getRelatedIdentifier().length+1] = relatedIdentifier;
//		}
		
		return artifact;
	}
	public Artifacts sendToDav(Artifacts artifacts, String trainId) throws IOException {

		Sardine sardine = SardineFactory.begin("", "");
		String filePath = "/tmp/webdav";
		String webdavdir = "http://menzel.informatik.rwth-aachen.de:9999";
		String url = webdavdir+"/"+trainId;
		if(trainId.equals(artifacts.getInternalId())) {
			Boolean existURL = sardine.exists(url);
			if(!existURL) {
				sardine.createDirectory(url);
			}
		}

		
		//FileUtils.writeStringToFile(new File(filePath),artifacts.getFiledata());
		//byte[] data = FileUtils.readFileToByteArray(new File(filePath));
		//sardine.put(url+"/"+artifacts.getName().trim(), data);
		sardine.copy(url+"/"+artifacts.getName().trim(), artifacts.getFiledata());
		
		artifacts.setFiledata(null);
		artifacts.setFileUrl(url);

		sardine.shutdown();
		return artifacts;
	}





	public Wagons findWagonById(String id) {
		return wagonRepository.findById(id).get();	
	}
	
	public Resources findResourceById(String id) {
		return resourceRepository.findById(id).get();	
	}
	
	public Train findTrainById(String id) {
		return trainRepository.findById(id).get();
	}

	
	public  Train getTrainById(String id) throws Exception {

		Optional<Train> opt = null;
			
				List<Train> result = trainRepository.findOneByQuery("internalId",id);

				if(result==null) {
					result = trainRepository.findOneBySmampleQuery("internalId",id);
				}
				
				if(result==null) {
					result = trainRepository.findOneBySimpleQuery("internalId",id);
				}

				if(result==null) {
					result = trainRepository.findOneByRegexQuery("internalId",id);
				}
				
				//
				Train caller = null;
				if(!result.isEmpty() && result.get(0)!=null) {
					caller = trainRepository.findOneByQuery("internalId",id).get(0);			
				}
				if(caller!=null && caller.get_id()!=null && !"".equals(caller.get_id().get().toString())) {
					opt = trainRepository.findById(caller.get_id().get().toString());
				}else {
					throw new RuntimeException("ERROR: searching for: "+id);
				}
				
			
		return opt.get();
		
		
	}
	

	
	
	
	public  Train getTrainByDescription(String description) throws Exception {
		Field[] fields = Train.class.getDeclaredFields();
		List<String> selectedFields = new ArrayList<String>();
		Optional<Train> opt = null;
		for(Field field:fields) {
			if("".equals(field) ||field==null) {
				continue;
			}
			selectedFields.add(field.getName());
		}
		
			
				List<Train> result = trainRepository.findOneByQuery("description",description);

				if(result==null) {
					result = trainRepository.findOneBySmampleQuery("description",description);
				}
				
				if(result==null) {
					result = trainRepository.findOneBySimpleQuery("description",description);
				}

				if(result==null) {
					result = trainRepository.findOneByRegexQuery("description",description);
				}
				
				//
				Train caller = null;
				if(!result.isEmpty() && result.get(0)!=null) {
					caller = trainRepository.findOneByQuery("description",description).get(0);			
				}
				if(caller!=null && caller.get_id()!=null && !"".equals(caller.get_id().get().toString())) {
					opt = trainRepository.findById(caller.get_id().get().toString());
				}else {
					throw new RuntimeException("ERROR: searching for: "+description);
				}
				
			
		return opt.get();
		
		
	}
	


	//TODO Implement it!
//	private Train addInternalIDs(Train train) {
//		String trainID = train.get_id().get().toString();
//		train.setInternalPointer(trainID);
//		train.setInternalId(trainID);
//		
//		for(TrainArtifact artifact: resource.getFiles()) {
//			String artifactId = artifact.get_id().get().toString();
//			artifactId = resourceInternalID+artifactId;
//			artifact.setJsonPointer(artifactId);
//			artifact.setInternalId(artifactId);
//			artifact.setDavUrl("http://localhost:9999/"+artifactId+"/"+artifact.getFilename());
//			artifactRepository.save(artifact);
//		}
//
//		return train;
//	}
	
	public Result getResult(Train train) {
		Result result = new Result();
		
		
		StationProfiles stationProfiles1 = new StationProfiles();
		stationProfiles1.setStationProfiles(new String[] {"Obesity", "Obesity", "Obesity"});
		
		StationProfiles stationProfiles2 = new StationProfiles();
		stationProfiles1.setStationProfiles(new String[] {"Obesity", "Obesity", "Diabetes"});
		
		StationProfiles stationProfiles3 = new StationProfiles();
		stationProfiles1.setStationProfiles(new String[] {"Diabetes", "Diabetes", "Diabetes"});
		
		StationProfiles stationProfiles4 = new StationProfiles();
		stationProfiles1.setStationProfiles(new String[] {"Obesity", "Diabetes", "Diabetes"});
		
		StationProfiles stationProfiles5 = new StationProfiles();
		stationProfiles1.setStationProfiles(new String[] {"Obesity", "Diabetes", "Diabetes"});
		
		StationProfiles stationProfiles6 = new StationProfiles();
		stationProfiles1.setStationProfiles(new String[] {"Obesity", "Cancer", "Cancer"});
		
		StationProfiles stationProfiles7 = new StationProfiles();
		stationProfiles1.setStationProfiles(new String[] {"Cancer", "Cancer", "Cancer"});
		
		StationProfiles stationProfiles8 = new StationProfiles();
		stationProfiles1.setStationProfiles(new String[] {"Obesity", "Diabetes", "Cancer"});

		
		
		//
		if(stationProfiles1.getStationProfiles()[0].equals("Obesity".toLowerCase())&&stationProfiles1.getStationProfiles()[1].equals("Obesity".toLowerCase())&&stationProfiles1.getStationProfiles()[2].equals("Obesity".toLowerCase())) {
			
			result.setCohortSizeAfterEliminatingPatientswithNOAgeData("Cohort size after eliminating patients with no age data: 99");
			result.setMeanAgeCohortResult("Mean age in cohort: 45.693222111678111");
			result.setPatientCohortFor("Patient cohort for Obesity, Obesity, Obesity");
			result.setRetrievedCohortSize("Retrieved cohort size 990");
		}
		
		//
		if(stationProfiles1.getStationProfiles()[0].equals("Obesity".toLowerCase())&&stationProfiles1.getStationProfiles()[1].equals("Obesity".toLowerCase())&&stationProfiles1.getStationProfiles()[2].equals("Diabetes".toLowerCase())) {
			
			result.setCohortSizeAfterEliminatingPatientswithNOAgeData("Cohort size after eliminating patients with no age data: 101");
			result.setMeanAgeCohortResult("Mean age in cohort: 37.992222567222333");
			result.setPatientCohortFor("Patient cohort for Obesity, Obesity, Diabetes");
			result.setRetrievedCohortSize("Retrieved cohort size 666");
		}
		
		//
		if(stationProfiles1.getStationProfiles()[0].equals("Obesity".toLowerCase())&&stationProfiles1.getStationProfiles()[1].equals("Diabetes".toLowerCase())&&stationProfiles1.getStationProfiles()[2].equals("Diabetes".toLowerCase())) {
			
			result.setCohortSizeAfterEliminatingPatientswithNOAgeData("Cohort size after eliminating patients with no age data: 788");
			result.setMeanAgeCohortResult("Mean age in cohort: 9.897145111752190");
			result.setPatientCohortFor("Patient cohort for Obesity, Diabetes, Diabetes");
			result.setRetrievedCohortSize("Retrieved cohort size 692");
		}
		
		//
		if(stationProfiles1.getStationProfiles()[0].equals("Diabetes".toLowerCase())&&stationProfiles1.getStationProfiles()[1].equals("Diabetes".toLowerCase())&&stationProfiles1.getStationProfiles()[2].equals("Diabetes".toLowerCase())) {
			
			result.setCohortSizeAfterEliminatingPatientswithNOAgeData("Cohort size after eliminating patients with no age data: 496");
			result.setMeanAgeCohortResult("Mean age in cohort: 8.777123111789444");
			result.setPatientCohortFor("Patient cohort for Diabetes, Diabetes, Diabetes");
			result.setRetrievedCohortSize("Retrieved cohort size 450");
		}

		//
		if(stationProfiles1.getStationProfiles()[0].equals("Obesity".toLowerCase())&&stationProfiles1.getStationProfiles()[1].equals("Obesity".toLowerCase())&&stationProfiles1.getStationProfiles()[2].equals("Cancer".toLowerCase())) {
			
			result.setCohortSizeAfterEliminatingPatientswithNOAgeData("Cohort size after eliminating patients with no age data: 380");
			result.setMeanAgeCohortResult("Mean age in cohort: 48.331118333222334");
			result.setPatientCohortFor("Patient cohort for Obesity, Obesity, Cancer");
			result.setRetrievedCohortSize("Retrieved cohort size 980");
		}
		
		if(stationProfiles1.getStationProfiles()[0].equals("Obesity".toLowerCase())&&stationProfiles1.getStationProfiles()[1].equals("Cancer".toLowerCase())&&stationProfiles1.getStationProfiles()[2].equals("Cancer".toLowerCase())) {
			
			result.setCohortSizeAfterEliminatingPatientswithNOAgeData("Cohort size after eliminating patients with no age data: 103");
			result.setMeanAgeCohortResult("Mean age in cohort: 8.987458333301234");
			result.setPatientCohortFor("Patient cohort for Obesity, Cancer, Cancer");
			result.setRetrievedCohortSize("Retrieved cohort size 801");
		}
		
		if(stationProfiles1.getStationProfiles()[0].equals("Cancer".toLowerCase())&&stationProfiles1.getStationProfiles()[1].equals("Cancer".toLowerCase())&&stationProfiles1.getStationProfiles()[2].equals("Cancer".toLowerCase())) {
			
			result.setCohortSizeAfterEliminatingPatientswithNOAgeData("Cohort size after eliminating patients with no age data: 180");
			result.setMeanAgeCohortResult("Mean age in cohort: 33.190458339993334");
			result.setPatientCohortFor("Patient cohort for Cancer, Cancer, Cancer");
			result.setRetrievedCohortSize("Retrieved cohort size 1200");
		}
		
		if(stationProfiles1.getStationProfiles()[0].equals("Obesity".toLowerCase())&&stationProfiles1.getStationProfiles()[1].equals("Diabetes".toLowerCase())&&stationProfiles1.getStationProfiles()[2].equals("Cancer".toLowerCase())) {
			
			result.setCohortSizeAfterEliminatingPatientswithNOAgeData("Cohort size after eliminating patients with no age data: 200");
			result.setMeanAgeCohortResult("Mean age in cohort: 22.123458333333334");
			result.setPatientCohortFor("Patient cohort for Obesity, Diabetes, Cancer");
			result.setRetrievedCohortSize("Retrieved cohort size 820");
		}else {
			
			result.setCohortSizeAfterEliminatingPatientswithNOAgeData("Cohort size after eliminating patients with no age data: 576");
			result.setMeanAgeCohortResult("Mean age in cohort: 11.536458333333334");
			result.setPatientCohortFor("Patient cohort to find the BMI, age based.");
			result.setRetrievedCohortSize("Retrieved cohort size 580");
			
		}

        
        return result;

	}

	public String getFlow() throws Exception {
		
		String flow =  "[\n" + 
				"    {\n" + 
				"        \"id\": \"e3be62f1.a8031\",\n" + 
				"        \"type\": \"tab\",\n" + 
				"        \"label\": \"Flow 1\",\n" + 
				"        \"disabled\": false,\n" + 
				"        \"info\": \"\"\n" + 
				"    },\n" + 
				"    {\n" + 
				"        \"id\": \"63bd3b38.7d5084\",\n" + 
				"        \"type\": \"Train\",\n" + 
				"        \"z\": \"e3be62f1.a8031\",\n" + 
				"        \"name\": \"BMI TRAIN\",\n" + 
				"        \"description\": \"BMI TRAI DESCRIPTION\",\n" + 
				"        \"sourceRepository\": \"\",\n" + 
				"        \"userToken\": \"\",\n" + 
				"        \"internalId\": \"\",\n" + 
				"        \"internalVersion\": \"\",\n" + 
				"        \"internalPointer\": \"\",\n" + 
				"        \"language\": \"\",\n" + 
				"        \"version\": \"\",\n" + 
				"        \"publicationYear\": \"\",\n" + 
				"        \"publisher\": \"\",\n" + 
				"        \"identifierType\": \"\",\n" + 
				"        \"identifierContent\": \"\",\n" + 
				"        \"creatorAffiliation\": \"\",\n" + 
				"        \"creatorGivenName\": \"\",\n" + 
				"        \"creatorFamilyName\": \"\",\n" + 
				"        \"nameType\": \"\",\n" + 
				"        \"creatorContent\": \"\",\n" + 
				"        \"creatorNameIdentifierScheme\": \"\",\n" + 
				"        \"creatorSchemeURI\": \"\",\n" + 
				"        \"nameIdentifierContent\": \"\",\n" + 
				"        \"subjectSchemeURI\": \"\",\n" + 
				"        \"subjectContent\": \"\",\n" + 
				"        \"subjectScheme\": \"\",\n" + 
				"        \"dateType\": \"\",\n" + 
				"        \"dateInformation\": \"\",\n" + 
				"        \"dateContent\": \"\",\n" + 
				"        \"format\": \"\",\n" + 
				"        \"rightsURI\": \"\",\n" + 
				"        \"rightsContent\": \"\",\n" + 
				"        \"titleContent\": \"\",\n" + 
				"        \"titleType\": \"\",\n" + 
				"        \"descriptionType\": \"\",\n" + 
				"        \"descriptionContent\": \"\",\n" + 
				"        \"contributorAffiliation\": \"\",\n" + 
				"        \"contributorGivenName\": \"\",\n" + 
				"        \"contributorFamilyName\": \"\",\n" + 
				"        \"contributorType\": \"\",\n" + 
				"        \"contributorName\": \"\",\n" + 
				"        \"contributorNameIdentifierScheme\": \"\",\n" + 
				"        \"contributorSchemeURI\": \"\",\n" + 
				"        \"contributorContent\": \"\",\n" + 
				"        \"funderName\": \"\",\n" + 
				"        \"awardNumber\": \"\",\n" + 
				"        \"awardTitle\": \"\",\n" + 
				"        \"funderIdentifierType\": \"\",\n" + 
				"        \"fundingReferenceContent\": \"\",\n" + 
				"        \"resourceTypeGeneral\": \"\",\n" + 
				"        \"resourceTypeContent\": \"\",\n" + 
				"        \"x\": 90,\n" + 
				"        \"y\": 120,\n" + 
				"        \"wires\": [\n" + 
				"            [\n" + 
				"                \"d609c877.f68a98\"\n" + 
				"            ]\n" + 
				"        ]\n" + 
				"    },\n" + 
				"    {\n" + 
				"        \"id\": \"ce0e9515.cda1f8\",\n" + 
				"        \"type\": \"debug\",\n" + 
				"        \"z\": \"e3be62f1.a8031\",\n" + 
				"        \"name\": \"\",\n" + 
				"        \"active\": true,\n" + 
				"        \"tosidebar\": true,\n" + 
				"        \"console\": true,\n" + 
				"        \"tostatus\": false,\n" + 
				"        \"complete\": \"message\",\n" + 
				"        \"targetType\": \"msg\",\n" + 
				"        \"x\": 900,\n" + 
				"        \"y\": 200,\n" + 
				"        \"wires\": []\n" + 
				"    },\n" + 
				"    {\n" + 
				"        \"id\": \"d609c877.f68a98\",\n" + 
				"        \"type\": \"Wagon\",\n" + 
				"        \"z\": \"e3be62f1.a8031\",\n" + 
				"        \"name\": \"Test Wagon\",\n" + 
				"        \"description\": \"Wagon Description\",\n" + 
				"        \"stationProfile1\": \"Obesity\",\n" + 
				"        \"stationProfile2\": \"Diabetes\",\n" + 
				"        \"stationProfile3\": \"Cancer\",\n" + 
				"        \"x\": 190,\n" + 
				"        \"y\": 60,\n" + 
				"        \"wires\": [\n" + 
				"            [\n" + 
				"                \"3c6001c4.83abbe\"\n" + 
				"            ]\n" + 
				"        ]\n" + 
				"    },\n" + 
				"    {\n" + 
				"        \"id\": \"3c6001c4.83abbe\",\n" + 
				"        \"type\": \"Resource\",\n" + 
				"        \"z\": \"e3be62f1.a8031\",\n" + 
				"        \"name\": \"\",\n" + 
				"        \"description\": \"\",\n" + 
				"        \"created\": \"\",\n" + 
				"        \"author\": \"\",\n" + 
				"        \"architecture\": \"PPC64LE\",\n" + 
				"        \"os\": \"DRAGONFLY\",\n" + 
				"        \"user\": \"\",\n" + 
				"        \"port\": \"\",\n" + 
				"        \"protocol\": \"\",\n" + 
				"        \"env\": \"\",\n" + 
				"        \"entrypoint\": \"2c43508e-4ac4-4562-a13f-5e1549818761\",\n" + 
				"        \"cmd\": \"\",\n" + 
				"        \"volumes\": \"\",\n" + 
				"        \"x\": 180,\n" + 
				"        \"y\": 200,\n" + 
				"        \"wires\": [\n" + 
				"            [\n" + 
				"                \"255ba140.b14b7e\"\n" + 
				"            ]\n" + 
				"        ]\n" + 
				"    },\n" + 
				"    {\n" + 
				"        \"id\": \"255ba140.b14b7e\",\n" + 
				"        \"type\": \"Artifact\",\n" + 
				"        \"z\": \"e3be62f1.a8031\",\n" + 
				"        \"name\": \"build.sh\",\n" + 
				"        \"filename\": \"\",\n" + 
				"        \"filedata\": \"data:text/x-sh;base64,IyEvYmluL2Jhc2gKZG9ja2VyIHJtaSBqYmphcmVzL3BodG9uZmhpcgpkb2NrZXIgYnVpbGQgLXQgamJqYXJlcy9waHRvbmZoaXIgLi8KCmRvY2tlciBwdXNoIGpiamFyZXMvcGh0b25maGlyCg==\",\n" + 
				"        \"format\": \"utf8\",\n" + 
				"        \"x\": 400,\n" + 
				"        \"y\": 80,\n" + 
				"        \"wires\": [\n" + 
				"            [\n" + 
				"                \"11623aaf.220db5\"\n" + 
				"            ]\n" + 
				"        ]\n" + 
				"    },\n" + 
				"    {\n" + 
				"        \"id\": \"11623aaf.220db5\",\n" + 
				"        \"type\": \"Dispatcher\",\n" + 
				"        \"z\": \"e3be62f1.a8031\",\n" + 
				"        \"dispatchername\": \"\",\n" + 
				"        \"dispatcherdescription\": \"\",\n" + 
				"        \"dispatcherinternalid\": \"\",\n" + 
				"        \"dispatcherinternalversion\": \"\",\n" + 
				"        \"dispatcherjsonpointer\": \"\",\n" + 
				"        \"x\": 630,\n" + 
				"        \"y\": 180,\n" + 
				"        \"wires\": [\n" + 
				"            [\n" + 
				"                \"ce0e9515.cda1f8\"\n" + 
				"            ]\n" + 
				"        ]\n" + 
				"    }\n" + 
				"]";
		
		return flow;
	}

	//TODO Do it.
	public String getDOI() {
		//getDraftDOI();
		return "";
	}

	//TODO Do it.
	public Boolean uploadToDataCite(Train train) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean uploadFilesToFilesRepository(Train train) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static final String OK = "OK";

	private static final String APPLICATION_VND_API_JSON = "application/vnd.api+json";

	private static final String UTF_8 = "UTF-8";

	private static final String TEMPLATE_LOCATION = "/Users/jbjares/workspaces/TrainmodelHelper/TrainModel/src/main/resources/content/my_draft_doi.json";
	
	private static final String TEMPLATE_FROM_DRAFT_TO_REGISTERED = "/Users/jbjares/workspaces/TrainmodelHelper/TrainModel/src/main/resources/content/change_draft_to_rester_doi.json";

	
	public void getDraftDOI() throws Exception {
		//https://api.datacite.org/dois
		   String hostname = "https://api.test.datacite.org/dois";
		    String password = "Nahan@123";
		    String username = "DEV.FIT";
		   
		    UsernamePasswordCredentials creds = new UsernamePasswordCredentials(hostname, password);
		    System.out.println("User: "+creds.getUserPrincipal().getName());
		    System.out.println("Password: "+creds.getPassword());
		   
		    String authString = hostname + ":" + password;
		    System.out.println("auth string: " + authString);
		    byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
		    String authStringEnc = new String(authEncBytes);
		    System.out.println("Base64 encoded auth string: " + authStringEnc);
		   
		    URI uri = new URIBuilder()
		            .setScheme("https")
		            .setHost("api.test.datacite.org")
		            .setPath("/dois")
		            .setParameter("username", username).build();

		    
            HttpEntity entity = MultipartEntityBuilder.create()
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .setCharset(Charset.forName(UTF_8))
                    .addBinaryBody("my_draft_doi.json", new File(TEMPLATE_LOCATION))
                    //.addBinaryBody("@my_draft_doi.json", FileUtils.readFileToByteArray(new File(TEMPLATE_LOCATION)), ContentType.create(APPLICATION_VND_API_JSON), "my_draft_doi.json")
                    .build();
            
		    HttpPost post = new HttpPost(uri);
		    post.addHeader("Content-Type", "application/vnd.api+json");
		    post.addHeader("--user","DEV.FIT:Nahan@123");
		    post.addHeader("-d","@my_draft_doi.json");
		    post.setEntity(entity);
		    System.out.println(post.getURI());
		    HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
		            HttpStatus.SC_OK, OK);

		            System.out.println(response.getProtocolVersion());
		            System.out.println(response.getStatusLine().getStatusCode());
		            System.out.println(response.getStatusLine().getReasonPhrase());
		            System.out.println(response.getStatusLine().toString());
		   

		            InputStreamEntity reqEntity = new InputStreamEntity(
		                    new FileInputStream(new File(TEMPLATE_LOCATION)), -1, ContentType.APPLICATION_OCTET_STREAM);
		            reqEntity.setChunked(true);
		            
		            
		            System.out.println(
		            Request.Get(uri)
		            .connectTimeout(1000)
		            .socketTimeout(1000)
		            .execute().returnContent().asString()); 
	}


	
	public Train saveTrainBasic(Train train) {
		return trainRepository.save(train);
	}
	
	public Train saveTrainAndDataciteFirstFlow(String trainStr) {
		Gson gson = new GsonBuilder().
				excludeFieldsWithoutExposeAnnotation().create();
		Train train = gson.fromJson(trainStr, Train.class);
		if(train.getInternalId()!=null) {
			train.set_id(new ObjectId(train.getInternalId()));
		}
		return trainRepository.save(train);
	}

	public Wagons addWagon(Wagons wagon) {
		return wagonRepository.save(wagon);
	}
	
	public Resources addResources(Resources resources) {
		return resourceRepository.save(resources);
	}

	//TODO [Important] Do the Documentation. ==============
	public Wagons[] findWagonsById(String trainId) {
		List<Wagons> wagons = new ArrayList<Wagons>();
		
		for(Wagons wagon : wagonRepository.findAll()) {
			if(wagon.getTrainId().equals(trainId)) {
				wagons.add(wagon);
			}
		}
		return wagons.toArray(new Wagons[wagons.size()]);
	}
	//=======================================================

	public Wagons[] addWagonsArr(String trainId) {
		List<Wagons> wagons = new ArrayList<Wagons>();
		
		for(Wagons wagon : wagonRepository.findAll()) {
			if(wagon.getTrainId().equals(trainId)) {
				wagon.setResources(addResourcesArr(trainId));
				wagons.add(wagon);
			}
		}
		return wagons.toArray(new Wagons[wagons.size()]);
	}
	
	public Resources[] addResourcesArr(String trainId) {
		List<Resources> resourcesList = new ArrayList<Resources>();
		List<Artifacts> artifactListList = new ArrayList<Artifacts>();
		
		for(Resources resource : resourceRepository.findAll()) {
			if(resource!=null && resource.getWagonId()!=null && resource.getWagonId().equals(trainId)) {
				for(Artifacts artifact : artifactRepository.findAll()) {
					resource.setArtifacts(addArtifactsArr(trainId));
					artifactListList.add(artifact);
					//resource.setArtifacts(artifactListList.toArray(new Artifacts[artifactListList.size()]));
				}
				resourcesList.add(resource);
			}
		}
		return resourcesList.toArray(new Resources[resourcesList.size()]);
	}

	public Artifacts[] addArtifactsArr(String trainId) {
		List<Artifacts> artifactsList = new ArrayList<Artifacts>();
		
		for(Artifacts artifact : artifactRepository.findAll()) {
			artifact.setResourceId(trainId);
			if(artifact.getResourceId().equals(trainId)) {
				artifactsList.add(artifact);
			}
		}
		return artifactsList.toArray(new Artifacts[artifactsList.size()]);
	}

	public void saveArtifacts(Artifacts[] artifact) {
		for(int i = 0; i>=artifact.length;i++) {
			artifactRepository.save(artifact[i]);
		}
		
	}

	public Resources saveResource(Resources resource) {
		return resourceRepository.save(resource);
	}

	public Wagons saveWagon(Wagons wagon) {
		return wagonRepository.save(wagon);
		
	}

	public Iterable<Resources> saveResourcesAll(Resources[] resources) {
		return resourceRepository.saveAll(Arrays.asList(resources));
	}

	public Iterable<Wagons> saveWagonsAll(Wagons[] wagons) {
		return wagonRepository.saveAll(Arrays.asList(wagons));
	}
	
	private String getTemplate() {
		String result = "<!-- https://support.datacite.org/docs/how-do-i-expose-my-datasets-to-google-dataset-search -->\n" + 
				"<javascript>\n" + 
				"$(document).ready(function() {\n" + 
				"  var identifier = \"https://doi.org/||doi_var||\"; //for example 10.5284/1015681\n" + 
				"  if (identifier === undefined) {\n" + 
				"    return;\n" + 
				"  }\n" + 
				"  var doi = new URL(identifier);\n" + 
				"  var url = \"https://data.datacite.org\";\n" + 
				"  url += '/application/vnd.schemaorg.ld+json/' + doi.pathname;\n" + 
				"\n" + 
				"  $.ajax({\n" + 
				"    url: url,\n" + 
				"    dataType: 'text', // don't convert JSON to Javascript object\n" + 
				"    success: function(data) {\n" + 
				"      $('<script>')\n" + 
				"         .attr('type', 'application/ld+json')\n" + 
				"         .text(data)\n" + 
				"         .appendTo('head');\n" + 
				"    },\n" + 
				"    error: function (error) {\n" + 
				"      console.log(error.responseJSON);\n" + 
				"    }\n" + 
				"  });\n" + 
				"});\n" + 
				"</javascript>\n" + 
				"\n" + 
				"<!doctype html>\n" + 
				"<html>\n" + 
				"  <head>\n" + 
				"    <title>Welcome, this is the land page of the Train experiment named as: ||experimentname_var||</title>\n" + 
				"  </head>\n" + 
				"  <body>\n" + 
				"    <p>This page was auto generated by the Train Platform Project to give you a brief introduction about the ||experimentname_var|| experiment\n" + 
				"     as well as to allow the you access to the ||experimentname_var|| experiment in run time through the Train Modelling Tool. \n" + 
				"     where you can test this project in a runtime environment as well you can create your own experiments after to obtain the properly grants.\n" + 
				"     <br/>\n" + 
				"     <strong>||experimentname_var||</strong> \n" + 
				"     <p>The ||experimentname_var|| project aims to:\n" + 
				"     ||projectdescription_var||</p>\n" + 
				"     <br/>\n" + 
				"     If you are interested to in this experiment or in the platform, please <a href = \"mailto: joao.bosco.jares.alves.chaves@fit.fraunhofer.de\">e-mail us</a>.\n" + 
				"    \n" + 
				"  </body>\n" + 
				"</html>";
		
		return result;
	}
/**
 * {0} = ${doi_var}-
 * {1} = ${experimentname_var}-
 * {2} = ${experimentname_var}-
 * {3} = ${experimentname_var}-
 * {4} = ${experimentname_var}-
 * {5} = ${experimentname_var}-
 * {6} = ${projectdescription_var}
 * @param train
 * @param trainId
 * @return
 * @throws IOException
 */
	public  String customlandpage(Train train,String trainId) throws IOException {
	    //File file = new File("src/main/resources/content/lanpageAsTemplate.txt");
	    //String landpage = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
	    String page = getTemplate();
	    return page.replace("||doi_var||", train.getDatacite().getIdentifier().getContent()==null?"8780980/87878098":"1230980/87871238")
	    .replace("||experimentname_var||", train.getName()==null?"BMI Train":"Train 4 BMI")
	    .replace("||projectdescription_var||", train.getDescription()==null?"BMI Description":"Description about BMI Train");
	}


//	public static void main(String[] args) throws IOException {
//		Train train = new Train();
//		Datacite datacite = new Datacite();
//		Identifier id = new Identifier();
//		id.setContent("0123/98765");
//		datacite.setIdentifier(id);
//		train.setDatacite(datacite);
//		train.setName("BMI Experiment");
//		train.setDescription("This project aims to calculate the BMI of the Aachen population");
//		System.out.println(customlandpage(train,"234567890"));
//	}

	

}
