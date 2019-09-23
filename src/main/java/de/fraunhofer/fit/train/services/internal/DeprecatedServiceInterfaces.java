package de.fraunhofer.fit.train.services.internal;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.Gson;

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

//@EnableAspectJAutoProxy
//@RestController
//@Service
public class DeprecatedServiceInterfaces {

	
    //@Autowired
    private ServiceFacade facade;

//    @Autowired
//    private MongoOperations mongoOperations;

//  @PostMapping(value = "/train/ship", produces = MediaType.APPLICATION_JSON_VALUE)
//  public String getResult(@RequestBody String bmiFlow) throws Exception {
//      Gson gson = new Gson();
//      Train train = gson.fromJson(bmiFlow, Train.class);
//      if (train.getInternalId() != null) {
//          train.set_id(new ObjectId(train.getInternalId()));
//      }
//      // String doi = facade.getDOI();
//      // String flow = facade.getFlow();
//      // train.setFlow(flow);
//      // Boolean uploadToDataCite = facade.uploadToDataCite(train);
//      // train = facade.addFilesToWebDav(train);
//      Result result = facade.getResult(train);
//      train.getWagons()[0].setResult(result);
//      Train savedTrain = facade.saveUpdateTrain(train);
//      return gson.toJson(facade.getResult(savedTrain));
//  }
    // ===================================================================================================================
    
    //@PostMapping(value = "/train/add/artifacts/webdav/{trainId}", produces = MediaType.APPLICATION_JSON_VALUE)
    //!!!
    Train addArtifactsToWebDav(@PathVariable String trainId) throws Exception {
        Train trainn = facade.findTrainByInternalId(trainId);
        Artifacts[] artifactsArr = facade.findArtifactsByInternalId(trainId);
        System.out.println("length: "+(trainn.getWagons().length-1));
        for(int i=0;i<=trainn.getWagons().length-1;i++) {
            Artifacts artifacts = artifactsArr[i];
            artifacts = facade.sendToDav(artifacts, trainId);
        }
        
        return trainn;
    }
    // ===================================================================================================================
//  @PostMapping(value = "/train/add/artifacts/webdav/{trainId}", produces = MediaType.APPLICATION_JSON_VALUE)
//  Train addArtifactsToWebDav(@PathVariable String trainId) throws Exception {
//      Train trainn = facade.findTrainById(trainId);
//
//      for (int i = 0; i < trainn.getWagons().length; i++) {
//          Wagons wagons = trainn.getWagons()[i];
//
//          if ((wagons == null) || (!wagons.getInternalId().equals(trainId))) {
//              continue;
//          }
//
//          for (int j = 0; j < trainn.getWagons()[i].getResources().length; j++) {
//              Resources resources = trainn.getWagons()[i].getResources()[j];
//
//              if ((resources == null) || (!resources.getInternalId().equals(trainId))) {
//                  continue;
//              }
//              // ===========================================
//              if (resources.getArtifacts() == null || resources.getArtifacts().length == 0) {
//                  continue;
//              }
//
//              List<Artifacts> artifactsList = new ArrayList<Artifacts>();
//
//              if (resources.getArtifacts() != null && resources.getArtifacts().length > 0) {
//                  System.out.println("==========================================");
//                  for (Artifacts artifact : resources.getArtifacts()) {
//                      Artifacts artifacts = facade.sendToDav(artifact, trainId);
//                      artifactsList.add(artifacts);
//                  }
//                  System.out.println("==========================================");
//                  resources.setArtifacts(artifactsList.toArray(new Artifacts[artifactsList.size()]));
//                  trainn.getWagons()[i].getResources()[j].setArtifacts(resources.getArtifacts());
//                  // ===========================================
//                  trainn = facade.saveTrainBasic(trainn);
//                  // ===========================================
//                  continue;
//              }
//
//              // ===========================================
//          }
//
//      }
//
//      return facade.findTrainById(trainId);
//
//  }
    // ===================================================================================================================
    // ===================================================================================================================

    //@PostMapping(value = "/train/add/core", produces = MediaType.APPLICATION_JSON_VALUE)
    public Train saveTrainCore(@RequestBody String trainStr) throws Exception {
        Gson gson = new Gson();
        Train train = gson.fromJson(trainStr, Train.class);
        if (train.getInternalId() != null) {
            train.set_id(new ObjectId(train.getInternalId()));
        }

        return facade.saveUpdateTrain(train);
    }

    //@PostMapping(value = "train/save/{trainId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Train saveDatacite(@RequestBody String trainStr, @PathVariable String trainId) throws Exception {
        Gson gson = new Gson();
        Train train = gson.fromJson(trainStr, Train.class);
        if (train.getInternalId() != null) {
            train.set_id(new ObjectId(train.getInternalId()));
        }

        Wagons[] wagons = facade.findWagonsById(trainId);

        return facade.saveUpdateTrain(train);
    }

    //@PostMapping(value = "/train", produces = MediaType.APPLICATION_JSON_VALUE)
    Train saveTrain(@RequestBody Train train) throws NoSuchAlgorithmException, IOException {
        return facade.saveUpdateTrain(train);
    }

    //@PutMapping(value = "/train", produces = MediaType.APPLICATION_JSON_VALUE)
    Train updateTrain(@RequestBody Train train) throws NoSuchAlgorithmException, IOException {
        return facade.saveUpdateTrain(train);
    }

    // TODO: [Important] Do the documentation =======================
    //@GetMapping(value = "/train/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Wagons[] getWagonsByTrainId(@PathVariable String id) throws Exception {
        Train train = facade.findTrainByInternalId(id);
        return train.getWagons();
    }

    // TODO: [Important] Do the documentation =======================
    //@PostMapping(value = "/train/add/{trainId}", produces = MediaType.APPLICATION_JSON_VALUE)
    //!!!
    Train saveTrainAndDataciteFirstFlow(@RequestBody String trainStr, @PathVariable String trainId)
            throws NoSuchAlgorithmException, IOException {
        Train train = facade.saveTrain(trainStr);
        return train;
    }

    // TODO: [Important] Do the documentation =======================
    //@PostMapping(value = "train/add/artifact/train/{trainId}", produces = MediaType.APPLICATION_JSON_VALUE)
    //!!!
    Train addArtifact(@RequestBody String artifactStr, @PathVariable String trainId) throws Exception {

        Gson gson = new Gson();
        Artifacts artifacts = gson.fromJson(artifactStr, Artifacts.class);
        artifacts.setResourceId(trainId);
        artifacts.setInternalId(trainId);
        artifacts = facade.saveArtifact(artifacts);
        Train trainn = facade.findTrainByInternalId(trainId);

        for (int i = 0; i < trainn.getWagons().length; i++) {
            Wagons wagons = trainn.getWagons()[i];

            if ((wagons == null) || (!wagons.getInternalId().equals(trainId))) {
                continue;
            }
            
            System.out.println("==> "+trainn.getWagons()[i].getResources().length);

            for (int j = 0; j < trainn.getWagons()[i].getResources().length; j++) {
                Resources resources = trainn.getWagons()[i].getResources()[j];
                
//              System.out.println("============================");
//              System.out.println("wagon: "+trainn.getWagons()[i].getName());
//              System.out.println("resources: "+resources.getName());
//              System.out.println("i == "+i+" j == "+j);
//              System.out.println("============================");
                if ((resources == null) || (!resources.getInternalId().equals(trainId))) {
                    continue;
                }
                // ===========================================
                System.out.println(((i==0 && j==0) || (i==1 && j==0) || (i==2 && j==0)));
                System.out.println(resources.getArtifacts() == null || resources.getArtifacts().length == 0);
                
                if ((resources.getArtifacts() == null || resources.getArtifacts().length == 0) 
                        && ((i==0 && j==0) || (i==1 && j==0) || (i==2 && j==0))) {
                    
                    //wagons.setResources(new Resources[] { resource });
                    resources.setArtifacts(new Artifacts[] {artifacts});
                    trainn.getWagons()[i].setResources(new Resources[] {resources});
                    // ===========================================
                    facade.saveWagon(trainn.getWagons()[i]);
                    trainn = facade.saveTrainBasic(trainn);
                    // ===========================================
                    continue;

                }
                

                
//              if ((resources.getArtifacts() == null || resources.getArtifacts().length == 0) 
//                      && ((i==0 && j==0) || (i==1 && j==0) || (i==2 && j==0))) {
//                      System.out.println("i == "+i+" j == "+j);
//                  resources.setArtifacts(new Artifacts[] { artifacts});
//                  trainn.getWagons()[i].getResources()[j].setArtifacts(resources.getArtifacts());
//                  // ===========================================
//                  facade.saveResource(trainn.getWagons()[i].getResources()[j]);
//                  System.out.println("obj: "+ trainn.getWagons()[i].getResources()[j]);
//                  trainn = facade.saveTrainBasic(trainn);
//                  // ===========================================
//                  continue;
//
//              }

//              List<Artifacts> artifactsList = new ArrayList<Artifacts>();
//
//              if (resources.getArtifacts() != null && resources.getArtifacts().length > 0) {
//                  artifactsList.addAll(Arrays.asList(resources.getArtifacts()));
//                  artifactsList.add(artifacts);
//                  // artifactsList.add(facade.getlandpage(trainId));
//                  resources.setArtifacts(artifactsList.toArray(new Artifacts[artifactsList.size()]));
//                  trainn.getWagons()[i].getResources()[j].setArtifacts(resources.getArtifacts());
//                  // ===========================================
//                  facade.saveResource(trainn.getWagons()[i].getResources()[j]);
//                  trainn = facade.saveTrainBasic(trainn);
//                  // ===========================================
//                  continue;
//              }

                // ===========================================
            }

        }
        Train result = facade.findTrainByInternalId(trainId);
        return result;
    }
    // ==================================================================

    // TODO: [Important] Do the documentation =======================
    //@PostMapping(value = "/train/add/resource/train/{trainId}", produces = MediaType.APPLICATION_JSON_VALUE)
    //!!!
    Resources addResource(@RequestBody String resourceStr, @PathVariable String trainId) throws Exception {

        Gson gson = new Gson();
        Resources resource = gson.fromJson(resourceStr, Resources.class);
        resource.setWagonId(trainId);
        resource.setInternalId(trainId);
        resource = facade.saveResources(resource);
        Train trainn = facade.findTrainByInternalId(trainId);

        // ===========================================

        for (int i = 0; i < trainn.getWagons().length; i++) {
            Wagons wagons = trainn.getWagons()[i];

            if ((wagons == null) || (!wagons.getInternalId().equals(trainId))) {
                continue;
            }

            if (wagons.getResources() == null || wagons.getResources().length == 0) {
                wagons.setResources(new Resources[] { resource });
                trainn.getWagons()[i].setResources(wagons.getResources());
                // ===========================================
                facade.saveWagon(trainn.getWagons()[i]);
                facade.saveResource(resource);
                trainn = facade.saveTrainBasic(trainn);
                // ===========================================
                continue;
            }

//          List<Resources> resourcesList = new ArrayList<Resources>();

//          if (wagons.getResources().length>=i &&) {
//              resourcesList.addAll(Arrays.asList(wagons.getResources()));
//              resourcesList.add(resource);
//              wagons.setResources(resourcesList.toArray(new Resources[resourcesList.size()]));
//              trainn.getWagons()[i].setResources(wagons.getResources());
//              // ===========================================
//              facade.saveWagon(trainn.getWagons()[i]);
//              facade.saveResource(resource);
//              trainn = facade.saveTrainBasic(trainn);
//              // ===========================================
//              continue;
//          }

        }

        return resource;
    }

    // ==================================================================

    // TODO: [Important] Do the documentation =======================
    //@PostMapping(value = "/train/add/wagon/train/{trainId}", produces = MediaType.APPLICATION_JSON_VALUE)
    //!!!
    Wagons addWagon(@RequestBody String wagonStr, @PathVariable String trainId) throws Exception {
        Gson gson = new Gson();
        Wagons wagon = gson.fromJson(wagonStr, Wagons.class);

        Train train = facade.findTrainByInternalId(trainId);
        wagon.setTrainId(trainId);
        if (wagon.getInternalId() != null) {
            wagon.set_id(new ObjectId(wagon.getInternalId()));
        }
        wagon.setTrainId(trainId);
        wagon.setInternalId(trainId);
        wagon = facade.saveWagon(wagon);
        Wagons[] wagonsArr = facade.findWagonsById(trainId);

        train.setWagons(wagonsArr);

        train = facade.saveTrainBasic(train);

        return wagon;
    }
    // ==================================================================


    //@GetMapping(value = "/train/InternalId", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getInternalId() {
        return facade.getInternalId();
    }

    //@GetMapping(value = "/train/InternalPointer", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getInternalPointer() {
        return facade.getInternalPointer();
    }

    //@GetMapping(value = "/train/InternalVersion", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getInternalVersion() {
        return facade.getInternalVersion();
    }

    //@GetMapping(value = "/train/helper/ArchitectureEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArchitectureOCIEnum> getArchitectureEnumValues() {
        return facade.getArchitectureEnumValues();
    }

    //@GetMapping(value = "/train/helper/OsEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OsOciEnum> getOsEnumValues() {
        return facade.getOsEnumValues();
    }

    //@GetMapping(value = "/train/helper/StationProfileEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StationProfileEnum> getStationProfileEnumValues() {
        return facade.getStationProfileEnumValues();
    }

    //@GetMapping(value = "/train/helper/ContributorTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContributorTypeDataciteEnum> getContributorTypeEnumValues() {
        return facade.getContributorTypeEnumValues();
    }

    //@GetMapping(value = "/train/helper/DateTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DateTypeDataciteEnum> getDateTypeEnumValues() {
        return facade.getDateTypeEnumValues();
    }

    //@GetMapping(value = "/train/helper/DescriptionTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DescriptionTypeDataciteEnum> getDescriptionTypeEnumValues() {
        return facade.getDescriptionTypeEnumValues();
    }

    //@GetMapping(value = "/train/helper/FunderIdentifierTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FunderIdentifierTypeDataciteEnum> getFunderIdentifierTypeEnumValues() {
        return facade.getFunderIdentifierTypeEnumValues();
    }

    //@GetMapping(value = "/train/helper/IdentifierTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IdentifierTypeDataciteEnum> getIdentifierTypeEnumValues() {
        return facade.getIdentifierTypeEnumValues();
    }

    //@GetMapping(value = "/train/helper/LanguageEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LanguageDataciteEnum> getLanguageEnumValues() {
        return facade.getLanguageEnumValues();
    }

    //@GetMapping(value = "/train/helper/NameIdentifierSchemeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NameIdentifierSchemeDataciteEnum> getNameIdentifierSchemeEnumValues() {
        return facade.getNameIdentifierSchemeEnumValues();
    }

    //@GetMapping(value = "/train/helper/NameTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NameTypeDataciteEnum> getNameTypeEnumValues() {
        return facade.getNameTypeEnumValues();
    }

    //@GetMapping(value = "/train/helper/RelatedIdentifierTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RelatedIdentifierTypeDataciteEnum> getRelatedIdentifierTypeEnumValues() {
        return facade.getRelatedIdentifierTypeEnumValues();
    }

    //@GetMapping(value = "/train/helper/RelationTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RelationTypeDataciteEnum> getRelationTypeEnumValues() {
        return facade.getRelationTypeEnumValues();
    }

    //@GetMapping(value = "/train/helper/ResourceTypeGeneralEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ResourceTypeGeneralDataciteEnum> getResourceTypeGeneralEnumValues() {
        return facade.getResourceTypeGeneralEnumValues();
    }

    //@GetMapping(value = "/train/helper/TitleTypeEnumValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TitleTypeDataciteEnum> getTitleTypeEnumValues() {
        return facade.getTitleTypeEnumValues();
    }
}
