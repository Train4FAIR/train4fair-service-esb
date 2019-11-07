package de.fraunhofer.fit.train.services.internal;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.fraunhofer.fit.train.facade.ServiceFacade;
import de.fraunhofer.fit.train.model_v1.Artifacts;
import de.fraunhofer.fit.train.model_v1.Resources;
import de.fraunhofer.fit.train.model_v1.Train;
import de.fraunhofer.fit.train.model_v1.Wagons;
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
import de.fraunhofer.fit.train.model_v2.nodered.ArtifactsMetadataNoderedNODE;
import de.fraunhofer.fit.train.model_v2.nodered.ResourcesMetadataNoderedNODE;
import de.fraunhofer.fit.train.model_v2.nodered.TrainMetadataNoderedNODE;
import de.fraunhofer.fit.train.model_v2.nodered.WagonsMetadataNoderedNODE;
import de.fraunhofer.fit.train.util.TrainUtil;

@EnableAspectJAutoProxy
@RestController
@Service
public class InternalServiceInterfaces {

	@Autowired
	private ServiceFacade facade;

	@Autowired
	private TrainUtil trainUtil;

	// TODO: [Important] Do the documentation =======================
	@PostMapping(value = "/train/add/", produces = MediaType.APPLICATION_JSON_VALUE)
	// !!!+
	Train saveTrain(@RequestBody String input) throws NoSuchAlgorithmException, IOException {

		if (input == null || "".equals(input)) {
			throw new RuntimeException("failed to save the new Train. Probrably the Train Object is Null.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		Train train = gson.fromJson(input, Train.class);
		train = facade.saveTrainAsObj(train);
		train.setCorrelationObjectId(train.get_id().toString());
		train = facade.saveTrainAsObj(train);

		System.out.println("train.get_id().toString(): " + train.get_id().toString());
		System.out.println("train.getInternalId(): " + train.getInternalId());
		System.out.println("train.getCorrelationObjectId(): " + train.getCorrelationObjectId());
		return train;
	}

	// TODO: [Important] Do the documentation =======================
	@PostMapping(value = "/trainNode/add/{internalId}/{internalVersion}")
	// !!!+
	void saveTrainNode(@RequestBody String input, @PathVariable String internalId, @PathVariable String internalVersion)
			throws NoSuchAlgorithmException, IOException {

		if (input == null || "".equals(input)) {
			throw new RuntimeException("failed to save the new Train. Probrably The TrainNode Object is Null.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		TrainMetadataNoderedNODE trainNode = gson.fromJson(input, TrainMetadataNoderedNODE.class);
		// trainNode.setInternalId(internalId);
		trainNode.set_wire(trainUtil.convertTwoDimensionsArrIntoStr(trainNode.getWires(), internalId));
		// trainNode.setInternalVersion(internalVersion);
		trainNode = facade.saveNoderedMetadataTrain(trainNode);
	}
	// ==

	// == Wagon
	// TODO: [Important] Do the documentation =======================
	@PostMapping(value = "/wagon/add/{internalId}/", produces = MediaType.APPLICATION_JSON_VALUE)
	// !!!+
	Wagons saveWagon(@RequestBody String input, @PathVariable String internalId)
			throws NoSuchAlgorithmException, IOException {

		if (input == null || "".equals(input)) {
			throw new RuntimeException("failed to save the new Train. Probrably The Train Objects are Null.");
		}

		Gson gson = new Gson();
		Wagons wagon = gson.fromJson(input, Wagons.class);
		// wagon.setInternalId(internalId);
		wagon.setTrainId(internalId);

		// TODO: Create a Logging and Exception Framework to handler similar scenarios
		if (wagon.getInternalPointer() == null || "".equals(wagon.getInternalPointer())) {
			// throw new RuntimeException("failed to save the new Train. Probrably The Train
			// Objects are Null or doesn't have any associated Resource.");
			System.out.println(
					"failed to save the new Train. Probrably The Train Objects are Null or doesn't have any associated Resource.");
			return wagon;
		}

		// TODO Review!!!
//    	WagonsMetadataNoderedNODE[] wagonNodeArr = facade.findWagonNodeByInternalId(internalId);
//		if(wagonNodeArr!=null || wagonNodeArr.length>0) {
//			return wagon;
//		}
//		
//		for(WagonsMetadataNoderedNODE wagonNode:wagonNodeArr) {
//			System.out.println("wagonNode.getCorrelationObjectId(): "+wagonNode.getCorrelationObjectId());
//			System.out.println("wagon.getCorrelationObjectId(): "+wagon.getCorrelationObjectId());
//			
//			System.out.println("wagonNode.getInternalId(): "+wagonNode.getInternalId());
//			System.out.println("wagon.getInternalId(): "+wagonNode.getInternalId());
//		}

		Wagons wagons = facade.saveWagon(wagon);
		wagons.setCorrelationObjectId(wagons.get_id().toString());
		wagons = facade.saveWagon(wagon);
		return wagons;
	}

	// TODO: [Important] Do the documentation =======================
	@PostMapping(value = "/wagonNode/add/{internalId}/{internalVersion}", produces = MediaType.APPLICATION_JSON_VALUE)
	// !!!+
	void saveWagonNode(@RequestBody String input, @PathVariable String internalId, @PathVariable String internalVersion)
			throws NoSuchAlgorithmException, IOException {

		if (input == null || "".equals(input)) {
			throw new RuntimeException("failed to save the new Train. Probrably The TrainNode Objects are Null.");
		}

		Gson gson = new Gson();
		WagonsMetadataNoderedNODE wagonNode = gson.fromJson(input, WagonsMetadataNoderedNODE.class);
		// wagonNode.setInternalId(internalId);
		// String internalPointer =
		// trainUtil.convertTwoDimensionsArrIntoStr(wagonNode.getWires(),internalId);
		// wagonNode.setInternalPointer(internalPointer);
		// wagonNode.setInternalVersion(internalVersion);

		// TODO create an error message framework
		if (wagonNode.getParentWireId() == null || wagonNode.getParentWireId().length == 0) {
			return;
		}

		wagonNode = facade.saveNoderedMetadataWagon(wagonNode);
		System.out.println("wagonNode => " + wagonNode);

	}
	// ==

	// == Wagon
	// TODO: [Important] Do the documentation =======================
	@PostMapping(value = "/resource/add/{internalId}/", produces = MediaType.APPLICATION_JSON_VALUE)
	// !!!+
	Resources saveResource(@RequestBody String input, @PathVariable String internalId)
			throws NoSuchAlgorithmException, IOException {

		if (input == null || "".equals(input)) {
			throw new RuntimeException("failed to save the new Resource. Probrably The Train Objects are Null.");
		}

		Gson gson = new Gson();
		Resources resource = gson.fromJson(input, Resources.class);
		// resource.setInternalId(internalId);
		resource.setWagonId(internalId);

		Resources result = facade.saveResource(resource);
		result.setCorrelationObjectId(result.get_id().toString());
		result = facade.saveResource(resource);
		return result;
	}

	// TODO: [Important] Do the documentation =======================
	@PostMapping(value = "/resourceNode/add/{internalId}/{internalVersion}", produces = MediaType.APPLICATION_JSON_VALUE)
	// !!!+
	void saveResourceNode(@RequestBody String input, @PathVariable String internalId,
			@PathVariable String internalVersion) throws NoSuchAlgorithmException, IOException {

		if (input == null || "".equals(input)) {
			throw new RuntimeException("failed to save the new Resource. Probrably the Resource Objects are Null.");
		}

		Gson gson = new Gson();
		ResourcesMetadataNoderedNODE resourceNode = gson.fromJson(input, ResourcesMetadataNoderedNODE.class);
		// resourceNode.setInternalId(internalId);
		// resourceNode.setInternalPointer(internalId);
		// resourceNode.setInternalVersion(internalVersion);
		facade.saveNoderedMetadataResources(resourceNode);

	}
	// ==

	// == Artifacts
	// TODO: [Important] Do the documentation =======================
	@PostMapping(value = "/artifact/add/{internalId}/", produces = MediaType.APPLICATION_JSON_VALUE)
	// !!!+
	Artifacts saveArtifacts(@RequestBody String input, @PathVariable String internalId)
			throws NoSuchAlgorithmException, IOException {

		if (input == null || "".equals(input)) {
			throw new RuntimeException("failed to save the new Resource. Probrably The Train Objects are Null.");
		}
		Gson gson = new Gson();
		Artifacts artifactInput = gson.fromJson(input, Artifacts.class);
		// Artifacts[] artifactsArr = facade.findArtifactsByInternalId(internalId);

		if (artifactInput == null) {
			return null;
		}

		// artifactInput.setInternalId(internalId);
		// artifactInput.setResourceId(internalId);

		Artifacts result = facade.saveArtifacts(artifactInput);
		result.setCorrelationObjectId(result.get_id().toString());
		result = facade.saveArtifacts(artifactInput);
		return result;
	}

	// TODO: [Important] Do the documentation =======================
	@PostMapping(value = "/artifactNode/add/{internalId}/{internalVersion}", produces = MediaType.APPLICATION_JSON_VALUE)
	// !!!+
	void saveArtifactNode(@RequestBody String input, @PathVariable String internalId,
			@PathVariable String internalVersion) throws NoSuchAlgorithmException, IOException {

		if (input == null || "".equals(input)) {
			throw new RuntimeException("failed to save the new Resource. Probrably the Resource Objects are Null.");
		}

		Gson gson = new Gson();
		ArtifactsMetadataNoderedNODE artifactNode = gson.fromJson(input, ArtifactsMetadataNoderedNODE.class);
//		artifactNode.setInternalId(internalId);
//		artifactNode.setInternalPointer(internalId);
//		artifactNode.setInternalVersion(internalVersion);
		facade.saveNoderedMetadataArtifacts(artifactNode);

	}
	// ==

	// == ExecuteNode: Train Wrapper
	// TODO: [Important] Do the documentation =======================
	@PostMapping(value = "/train/wrapper/{internalId}/{internalVersion}", produces = MediaType.APPLICATION_JSON_VALUE)
	// !!!+
	Train executeWrapper(@RequestBody String input, @PathVariable String internalId, @PathVariable String internalVersion)
			throws NoSuchAlgorithmException, IOException {

		if (input == null || "".equals(input)) {
			throw new RuntimeException(
					"failed to proceed with th execution. Please verify your input parameter it's probably empty or null.");
		}

		Train train = facade.wrapperTheTrainObjects(internalId);
		train = facade.wrapperTheWagonObjects(internalId);
		train = facade.wrapperTheResourcesObjects(internalId);
		// train = facade.saveUpdateTrain(train);

		return train;
	}

	// TODO: [Important] Do the documentation =======================
	@PostMapping(value = "/train/webdav/{internalId}/{wagonId}/", produces = MediaType.APPLICATION_JSON_VALUE)
	//!!!+
	Boolean executeAddArtifactsToWebDav(@RequestBody String input, @PathVariable String internalId,
			@PathVariable String wagonId) throws NoSuchAlgorithmException, IOException {

		if (input == null || "".equals(input)) {
			throw new RuntimeException("failed to save the new Resource. Probrably the Resource Objects are Null.");
		}

		//Train trainn = facade.findTrainByInternalId(internalId);
		//Artifacts[] artifactsArr = facade.findArtifactsByInternalId(internalId);
		Artifacts[] artifactsArr = facade.findArtifactsByInternalIdAndWagonInternalId(internalId,wagonId);
		if(artifactsArr==null) {
			return Boolean.FALSE;
		}
		for (int i = 0; i < artifactsArr.length; i++) {
			Artifacts artifacts = artifactsArr[i];
			if ((artifacts.getFileUrl() != null || !"".equals(artifacts.getFileUrl()))
					&& artifacts.getFiledata() == null || "".equals(artifacts.getFiledata())) {
				continue;
			}
			
			//System.out.println("i :"+i);
			//System.out.println("artifacts.getFilename() :"+artifacts.getFilename());
			artifacts = facade.sendToDav(artifacts, internalId, wagonId);
			if (artifacts == null) {
				continue;
			}
			facade.saveArtifact(artifacts);
			//facade.sendLandPageToDav(internalId);
		}
		facade.sendLandPageToDav(internalId);
		return Boolean.TRUE;

	}

	@GetMapping(value = "/train/InternalTrainId", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getInternalTrainId() {
		return facade.getInternalId();
	}

	@GetMapping(value = "/train/InternalWagonId", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getInternalWagonId() {
		return facade.getInternalId();
	}

	@GetMapping(value = "/train/InternalPointer", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getInternalPointer() {
		return facade.getInternalPointer();
	}

	@GetMapping(value = "/train/InternalVersion/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getInternalVersion() {
		return facade.getInternalVersion();
	}

	@GetMapping(value = "/train/helper/ArchitectureEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ArchitectureOCIEnum> getArchitectureEnumValues() {
		return facade.getArchitectureEnumValues();
	}

	@GetMapping(value = "/train/helper/OsEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OsOciEnum> getOsEnumValues() {
		return facade.getOsEnumValues();
	}

	@GetMapping(value = "/train/helper/StationProfileEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StationProfileEnum> getStationProfileEnumValues() {
		return facade.getStationProfileEnumValues();
	}

	@GetMapping(value = "/train/helper/ContributorTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ContributorTypeDataciteEnum> getContributorTypeEnumValues() {
		return facade.getContributorTypeEnumValues();
	}

	@GetMapping(value = "/train/helper/DateTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DateTypeDataciteEnum> getDateTypeEnumValues() {
		return facade.getDateTypeEnumValues();
	}

	@GetMapping(value = "/train/helper/DescriptionTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DescriptionTypeDataciteEnum> getDescriptionTypeEnumValues() {
		return facade.getDescriptionTypeEnumValues();
	}

	@GetMapping(value = "/train/helper/FunderIdentifierTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FunderIdentifierTypeDataciteEnum> getFunderIdentifierTypeEnumValues() {
		return facade.getFunderIdentifierTypeEnumValues();
	}

	@GetMapping(value = "/train/helper/IdentifierTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<IdentifierTypeDataciteEnum> getIdentifierTypeEnumValues() {
		return facade.getIdentifierTypeEnumValues();
	}

	@GetMapping(value = "/train/helper/LanguageEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LanguageDataciteEnum> getLanguageEnumValues() {
		return facade.getLanguageEnumValues();
	}

	@GetMapping(value = "/train/helper/NameIdentifierSchemeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<NameIdentifierSchemeDataciteEnum> getNameIdentifierSchemeEnumValues() {
		return facade.getNameIdentifierSchemeEnumValues();
	}

	@GetMapping(value = "/train/helper/NameTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<NameTypeDataciteEnum> getNameTypeEnumValues() {
		return facade.getNameTypeEnumValues();
	}

	@GetMapping(value = "/train/helper/RelatedIdentifierTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RelatedIdentifierTypeDataciteEnum> getRelatedIdentifierTypeEnumValues() {
		return facade.getRelatedIdentifierTypeEnumValues();
	}

	@GetMapping(value = "/train/helper/RelationTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RelationTypeDataciteEnum> getRelationTypeEnumValues() {
		return facade.getRelationTypeEnumValues();
	}

	@GetMapping(value = "/train/helper/ResourceTypeGeneralEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ResourceTypeGeneralDataciteEnum> getResourceTypeGeneralEnumValues() {
		return facade.getResourceTypeGeneralEnumValues();
	}

	@GetMapping(value = "/train/helper/TitleTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TitleTypeDataciteEnum> getTitleTypeEnumValues() {
		return facade.getTitleTypeEnumValues();
	}
}
