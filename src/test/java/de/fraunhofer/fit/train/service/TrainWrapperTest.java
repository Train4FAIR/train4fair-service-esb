package de.fraunhofer.fit.train.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import de.fraunhofer.fit.train.config.AppConfig;
import de.fraunhofer.fit.train.facade.ServiceFacade;
import de.fraunhofer.fit.train.model_v1.Artifacts;
import de.fraunhofer.fit.train.model_v1.Resources;
import de.fraunhofer.fit.train.model_v1.Train;
import de.fraunhofer.fit.train.model_v1.Wagons;
import de.fraunhofer.fit.train.model_v2.nodered.ResourcesMetadataNoderedNODE;
import de.fraunhofer.fit.train.model_v2.nodered.TrainMetadataNoderedNODE;
import de.fraunhofer.fit.train.model_v2.nodered.WagonsMetadataNoderedNODE;
import de.fraunhofer.fit.train.util.TrainUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { AppConfig.class })
@ComponentScan({ "de.fraunhofer.fit.train" })
@EntityScan("de.fraunhofer.fit.train")
@SpringBootApplication
public class TrainWrapperTest {

	@Autowired
	private ServiceFacade facade;

	@Autowired
	private TrainUtil trainUtil;

	private static final String TRAIN_NODE_INPUT_FILE = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/insertTrainAndTrainNodeTest.json";

	private static final String TRAIN_INPUT_FILE = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/insertTrainTest.json";

	private static final String WAGON_NODE_INPUT_FILE = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/insertWagonAndWagonNodeTest.json";

	private static final String WAGON_INPUT_FILE = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/insertWagonTest.json";

	private static final String RESOURCE_INPUT_FILE = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/insertResourceTest.json";

	private static final String RESOURCE_NODE_INPUT_FILE = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/insertResourceAndResourceNodeTest.json";

	private static final String ARTIFACT_INPUT_FILE = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/insertArtifactTest.json";

	private static final String ARTIFACT_NODE_INPUT_FILE = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/insertArtifactAndArtifactNodeTest.json";

	private static final String INTERNAL_ID_TEST = "5d85a4deca90827e9e05fc6a";

	private static final String INTERNAL_VERSION_ID_TEST = "5d85a4deca90827e9e05fc6b5d85a4deca90827e9e05fc6c_21.09.2019";

//	private static final String WAGON_INTERNAL_ID = "5d9161609141a4193f92278f";
//	
//	private static final String WAGON_CORR_OBJ_ID = "5d9161689141a4193f922795";
//	
	
	@Autowired private MongoOperations mongoOps;
	
	
	@Test
	public void findWagon() throws Exception {
		Assert.assertNotNull(mongoOps);
		Query query = new Query();
		query.addCriteria(Criteria.where("correlationObjectId").is("5d916cc99141a41da602157f"))
		.addCriteria(Criteria.where("internalId").is("5d916cc89141a41da602157b"));
		
		TrainMetadataNoderedNODE trainNode = null;
		List<TrainMetadataNoderedNODE> trainList = mongoOps.find(query, TrainMetadataNoderedNODE.class);
		if(!trainList.isEmpty()) {
			trainNode = trainList.get(0);
		}
		
		query = new Query();
		query.addCriteria(Criteria.where("internalId").is("5d916cc89141a41da602157b")
				.and("parentWireId").is("d2e2c769.548e18"));
		List<WagonsMetadataNoderedNODE> wagonNodeList = mongoOps.find(query, WagonsMetadataNoderedNODE.class);
		
		List<Wagons> wagonsResultList = new ArrayList<Wagons>();

		for(WagonsMetadataNoderedNODE wagonNode:wagonNodeList) {
			query = new Query();
			query.addCriteria(Criteria.where("internalId").is(wagonNode.getInternalId())
					.and("correlationObjectId").is(wagonNode.getCorrelationObjectId()));
			List<Wagons> wagonsList = mongoOps.find(query, Wagons.class);
			wagonsResultList.addAll(wagonsList);
		}
		
		System.out.println(wagonsResultList);
	}
	
	@Ignore
	@Test
	public void findWagonByInternalAndCorrelationID() throws Exception {
		Assert.assertNotNull(mongoOps);
		Query query = new Query();
		query.addCriteria(Criteria.where("correlationObjectId").is("5d9161689141a4193f922795"))
		.addCriteria(Criteria.where("internalId").is("5d9161609141a4193f92278f"));
		List<Wagons> wagons = mongoOps.find(query, Wagons.class);
		if(!wagons.isEmpty()) {
			System.out.println(wagons.get(0).get_id().toString());
		}
//		Assert.assertNotEquals(Collections.EMPTY_LIST,wagons);
//		for(Wagons wagon:wagons) {
//			System.out.println(wagon.get_id().toString());
//		}
	}
	
	@Ignore
	@Test
	public void nodeRedWorkFlowTest() throws Exception {

//		executeAddTrain();
//		executeAddTrainNode();
		executeAddWagon();
//		executeAddWagonNode();
//		executeAddResource();
//		executeAdResourceNode();
//		executeAdArtifactNode();
//		executeAddArtifact();
	}

	// 1
	public void executeAddTrain() throws ClientProtocolException, IOException, NoSuchAlgorithmException {

		Train train = facade.findTrainByInternalId(INTERNAL_ID_TEST);
		facade.deleteTrainById(INTERNAL_ID_TEST);
		train = facade.findTrainByInternalId(INTERNAL_ID_TEST);
		Assert.assertNull(train);

		String content = TrainUtil.readFileToStr(TRAIN_INPUT_FILE);
		CloseableHttpClient client = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost("http://127.0.0.1:9091/RepositoryService/train/add/");

		String json = content;
		StringEntity entity = new StringEntity(json);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		CloseableHttpResponse response = client.execute(httpPost);
		assertEquals(200, response.getStatusLine().getStatusCode());
		client.close();

		train = facade.findTrainByInternalId(INTERNAL_ID_TEST);
		Assert.assertNotNull(train);
	}

	// 2
	public void executeAddWagon()
			throws ClientProtocolException, IOException, NoSuchAlgorithmException {

		Wagons wagon = facade.findFirstWagonsById(INTERNAL_ID_TEST);
		facade.deleteAllWagons();
		wagon = facade.findFirstWagonsById(INTERNAL_ID_TEST);
		Assert.assertNull(wagon);

        WagonsMetadataNoderedNODE[] wagonNodeArrArr = facade.findWagonsArrByInternalId(INTERNAL_ID_TEST);
        TrainMetadataNoderedNODE trainNode = facade.findFirstNoderedMetadataTrainByInternalId(INTERNAL_ID_TEST);
        Wagons wagonsResult = null;
        for(int i = 0; i<wagonNodeArrArr.length;i++) {
        	WagonsMetadataNoderedNODE wagonNodeArr = wagonNodeArrArr[i];
        	String wireStrByWagon = wagonNodeArrArr[i].get_wire();
        	System.out.println(wireStrByWagon);
	    }
    		

//		String content = TrainUtil.readFileToStr(WAGON_INPUT_FILE);
//		CloseableHttpClient client = HttpClients.createDefault();
//
//		HttpPost httpPost = new HttpPost("http://127.0.0.1:9091/RepositoryService/wagon/add/" + INTERNAL_ID_TEST+"/");
//
//		StringEntity entity = new StringEntity(content);
//		httpPost.setEntity(entity);
//		httpPost.setHeader("Accept", "application/json");
//		httpPost.setHeader("Content-type", "application/json");
//
//		CloseableHttpResponse response = client.execute(httpPost);
//		assertEquals(200, response.getStatusLine().getStatusCode());
//		client.close();
//
//		wagon = facade.findFirstWagonsById(INTERNAL_ID_TEST);
//		Assert.assertNotNull(wagon);
	}

	public void executeAddWagonNode() throws Exception {

		WagonsMetadataNoderedNODE wagonNode = facade.findNoderedMetadataWagonByInternalId(INTERNAL_ID_TEST);
		facade.deleteAllNoderedMetadataTrain();
		wagonNode = facade.findNoderedMetadataWagonByInternalId(INTERNAL_ID_TEST);
		Assert.assertNull(wagonNode);

		String content = TrainUtil.readFileToStr(WAGON_NODE_INPUT_FILE);
		CloseableHttpClient client = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost("http://127.0.0.1:9091/RepositoryService/wagonNode/add/" + INTERNAL_ID_TEST
				+ "/" + INTERNAL_VERSION_ID_TEST);

		StringEntity entity = new StringEntity(content);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		CloseableHttpResponse response = client.execute(httpPost);
		assertEquals(200, response.getStatusLine().getStatusCode());
		client.close();

	}

	// 3
	public void executeAddResource() throws ClientProtocolException, IOException, NoSuchAlgorithmException {

		Resources resource = facade.findFirstResourcesByInternalId(INTERNAL_ID_TEST);
		facade.deleteAllResources();
		resource = facade.findFirstResourcesByInternalId(INTERNAL_ID_TEST);
		Assert.assertNull(resource);

		String content = TrainUtil.readFileToStr(RESOURCE_INPUT_FILE);
		CloseableHttpClient client = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost(
				"http://127.0.0.1:9091/RepositoryService/resource/add/" + INTERNAL_ID_TEST + "/");

		StringEntity entity = new StringEntity(content);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		CloseableHttpResponse response = client.execute(httpPost);
		assertEquals(200, response.getStatusLine().getStatusCode());
		client.close();

	}

	public void executeAdResourceNode() throws Exception {

		ResourcesMetadataNoderedNODE resourceNode = facade.findNoderedMetadataResourcesByInternalId(INTERNAL_ID_TEST);
		facade.deleteAllNoderedMetadataTrain();
		resourceNode = facade.findNoderedMetadataResourcesByInternalId(INTERNAL_ID_TEST);
		Assert.assertNull(resourceNode);

		String content = TrainUtil.readFileToStr(RESOURCE_NODE_INPUT_FILE);
		CloseableHttpClient client = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost("http://127.0.0.1:9091/RepositoryService/resourceNode/add/" + INTERNAL_ID_TEST
				+ "/" + INTERNAL_VERSION_ID_TEST);

		StringEntity entity = new StringEntity(content);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		CloseableHttpResponse response = client.execute(httpPost);
		assertEquals(200, response.getStatusLine().getStatusCode());
		client.close();

	}

	// 3
	public void executeAddArtifact() throws ClientProtocolException, IOException, NoSuchAlgorithmException {

		Artifacts artifact = facade.findFirstArtifactByInternalId(INTERNAL_ID_TEST);
		facade.deleteAllArtifacts();
		artifact = facade.findFirstArtifactByInternalId(INTERNAL_ID_TEST);
		Assert.assertNull(artifact);

		String content = TrainUtil.readFileToStr(ARTIFACT_INPUT_FILE);
		String[] contentArr = content.split("%");

		for (int i = 0; i < contentArr.length; i++) {
			String json = contentArr[i];
			CloseableHttpClient client = HttpClients.createDefault();

			HttpPost httpPost = new HttpPost(
					"http://127.0.0.1:9091/RepositoryService/artifact/add/" + INTERNAL_ID_TEST + "/");

			StringEntity entity = new StringEntity(json);
			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");

			CloseableHttpResponse response = client.execute(httpPost);
			assertEquals(200, response.getStatusLine().getStatusCode());
			client.close();
		}

	}

	public void executeAdArtifactNode() throws Exception {

		ResourcesMetadataNoderedNODE resourceNode = facade.findNoderedMetadataResourcesByInternalId(INTERNAL_ID_TEST);
		facade.deleteAllNoderedMetadataTrain();
		resourceNode = facade.findNoderedMetadataResourcesByInternalId(INTERNAL_ID_TEST);
		Assert.assertNull(resourceNode);

		String content = TrainUtil.readFileToStr(ARTIFACT_NODE_INPUT_FILE);
		String[] contentArr = content.split("%");

		for (int i = 0; i < contentArr.length; i++) {
			String json = contentArr[i];

			CloseableHttpClient client = HttpClients.createDefault();

			HttpPost httpPost = new HttpPost("http://127.0.0.1:9091/RepositoryService/artifactNode/add/"
					+ INTERNAL_ID_TEST + "/" + INTERNAL_VERSION_ID_TEST);

			StringEntity entity = new StringEntity(json);
			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");

			CloseableHttpResponse response = client.execute(httpPost);
			assertEquals(200, response.getStatusLine().getStatusCode());
			client.close();
		}

	}
}
