package de.fraunhofer.fit.train.model_v2.nodered;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;

import de.fraunhofer.fit.train.config.AppConfig;
import de.fraunhofer.fit.train.facade.ServiceFacade;
import de.fraunhofer.fit.train.util.TrainUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { AppConfig.class })
@ComponentScan({ "de.fraunhofer.fit.train" })
@EntityScan("de.fraunhofer.fit.train")
@SpringBootApplication
public class MetadataParserTest {
	
	@Autowired
	private ServiceFacade facade;
	
	public static final String TRAIN_INTERNAL_ID = "5d7d70689141a41759ed6dd6";
	
	public static final String TRAIN_INTERNAL_VERSION = "5d7d70689141a41759ed6dd75d7d70689141a41759ed6dd8_15.09.2019";
	
	public static final String TRAIN_INTERNAL_POINTER = "5d7d70689141a41759ed6dd9";
	
	
	private static final String TRAIN_NODERED_METADATA = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/trainNoderedMetadata.json";
	
	private static final String WAGON_NODERED_METADATA = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/wagonNoderedMetadata.json";

	private static final String RESOURCES_NODERED_METADATA = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/resourceNoderedMetadata.json";
	
	private static final String ARTIFACTS_NODERED_METADATA = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/artifactsNoderedMetadata.json";
	
	
	
	@Test
	public void parseTrainMetadataToPOJOTest() throws Exception {
		facade.deleteAllNoderedMetadataTrain();
		TrainMetadataNoderedNODE newTrainNode = facade.findFirstNoderedMetadataTrainByInternalId(TRAIN_INTERNAL_ID);
		Assert.assertNull(newTrainNode);
		
		String content = TrainUtil.readFileToStr(TRAIN_NODERED_METADATA);
		Gson gson = new Gson();
		TrainMetadataNoderedNODE trainNode = gson.fromJson(content, TrainMetadataNoderedNODE.class);
		Assert.assertNotNull(trainNode);
		trainNode.setInternalId(TRAIN_INTERNAL_ID);
		trainNode.setInternalVersion(TRAIN_INTERNAL_VERSION);
		trainNode.setInternalPointer(TRAIN_INTERNAL_POINTER);
		System.out.println(trainNode);
		newTrainNode = facade.saveNoderedMetadataTrain(trainNode);
		Assert.assertNotNull(newTrainNode);
		Assert.assertEquals(TRAIN_INTERNAL_ID, newTrainNode.getInternalId());

		
	}
	
	@Test
	public void parseWagonMetadataToPOJOTest() throws IOException {
		facade.deleteAllNoderedMetadataWagon();
		WagonsMetadataNoderedNODE newTrainNode = facade.findNoderedMetadataWagonByInternalId(TRAIN_INTERNAL_ID);
		Assert.assertNull(newTrainNode);
		
		String content = TrainUtil.readFileToStr(WAGON_NODERED_METADATA);
		Gson gson = new Gson();
		WagonsMetadataNoderedNODE trainNode = gson.fromJson(content, WagonsMetadataNoderedNODE.class);
		Assert.assertNotNull(trainNode);
		trainNode.setInternalId(TRAIN_INTERNAL_ID);
		trainNode.setInternalVersion(TRAIN_INTERNAL_VERSION);
		trainNode.setInternalPointer(TRAIN_INTERNAL_POINTER);
		System.out.println(trainNode);
		newTrainNode = facade.saveNoderedMetadataWagon(trainNode);
		Assert.assertNotNull(newTrainNode);
		Assert.assertEquals(TRAIN_INTERNAL_ID, newTrainNode.getInternalId());
		
	}
	
	@Test
	public void parseResoucesMetadataToPOJOTest() throws IOException {
		facade.deleteAllNoderedMetadataResources();
		ResourcesMetadataNoderedNODE newTrainNode = facade.findNoderedMetadataResourcesByInternalId(TRAIN_INTERNAL_ID);
		Assert.assertNull(newTrainNode);
		
		String content = TrainUtil.readFileToStr(RESOURCES_NODERED_METADATA);
		Gson gson = new Gson();
		ResourcesMetadataNoderedNODE trainNode = gson.fromJson(content, ResourcesMetadataNoderedNODE.class);
		Assert.assertNotNull(trainNode);
		trainNode.setInternalId(TRAIN_INTERNAL_ID);
		trainNode.setInternalVersion(TRAIN_INTERNAL_VERSION);
		trainNode.setInternalPointer(TRAIN_INTERNAL_POINTER);
		System.out.println(trainNode);
		newTrainNode = facade.saveNoderedMetadataResources(trainNode);
		Assert.assertNotNull(newTrainNode);
		Assert.assertEquals(TRAIN_INTERNAL_ID, newTrainNode.getInternalId());
		
	}

	
	//ARTIFACTS_NODERED_METADATA
	@Test
	public void parseArtifactsMetadataToPOJOTest() throws IOException {
		facade.deleteAllNoderedMetadataResources();
		ArtifactsMetadataNoderedNODE newTrainNode = facade.findNoderedMetadataArtifactsByInternalId(TRAIN_INTERNAL_ID);
		Assert.assertNull(newTrainNode);
		
		String[] contentArr = TrainUtil.readFileToStr(ARTIFACTS_NODERED_METADATA).split("%");
		
		Assert.assertEquals(5, contentArr.length);
		
		for(int i = 0; i < contentArr.length; i++) {
			System.out.println(contentArr.length);
			System.out.println(i);
			String content = contentArr[i];
			
			Gson gson = new Gson();
			ArtifactsMetadataNoderedNODE trainNode = gson.fromJson(content, ArtifactsMetadataNoderedNODE.class);
			Assert.assertNotNull(trainNode);
			trainNode.setInternalId(TRAIN_INTERNAL_ID);
			trainNode.setInternalVersion(TRAIN_INTERNAL_VERSION);
			trainNode.setInternalPointer(TRAIN_INTERNAL_POINTER);
			System.out.println(trainNode);
			newTrainNode = facade.saveNoderedMetadataArtifacts(trainNode);
			Assert.assertNotNull(newTrainNode);
			Assert.assertEquals(TRAIN_INTERNAL_ID, newTrainNode.getInternalId());
		}

		
	}

}
