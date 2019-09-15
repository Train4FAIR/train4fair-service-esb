package de.fraunhofer.fit.train.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import de.fraunhofer.fit.train.config.AppConfig;
import de.fraunhofer.fit.train.facade.ServiceFacade;
import de.fraunhofer.fit.train.model_v1.Resources;
import de.fraunhofer.fit.train.model_v1.Train;
import de.fraunhofer.fit.train.model_v1.Wagons;
import de.fraunhofer.fit.train.util.TrainUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { AppConfig.class })
@ComponentScan({ "de.fraunhofer.fit.train" })
@EntityScan("de.fraunhofer.fit.train")
@SpringBootApplication
public class NodeRedServiceInputTest {

	@Autowired
	private ServiceFacade facade;

	private static final String TRAINJS_FIRSTCALL_JSON_FILE_LOCATION = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/Trainjs_FirstCall_Input.json";
	
	private static final String DIABETES_WAGONJS_SECONDCALL_JSON_FILE_LOCATION = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/Wagonjs_SecondCall_Input_DiabetesWagon.json";
	private static final String HEPATITIS_WAGONJS_SECONDCALL_JSON_FILE_LOCATION = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/Wagonjs_SecondCall_Input_HepatitisWagon.json";
	private static final String CANCER_WAGONJS_SECONDCALL_JSON_FILE_LOCATION = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/Wagonjs_SecondCall_Input_CancerWagon.json";
	
	private static final String DIABETES_RESOURCEJS_THIRDCALL_JSON_FILE_LOCATION = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/Resourcejs_ThirdCall_Input_DiabetesResource.json";
	private static final String HEPATITIS_RESOURCEJS_THIRDCALL_JSON_FILE_LOCATION = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/Resourcejs_ThirdCall_Input_HepatitisResource.json";
	private static final String CANCER_RESOURCEJS_THIRDCALL_JSON_FILE_LOCATION = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/Resourcejs_ThirdCall_Input_CancerResource.json";
	
	

	private static final String INTERNAL_ID_TEST = "5d7d70689141a41759ed6dd6";

	@Test
	public void nodeRedWorkFlowTest() throws ClientProtocolException, NoSuchAlgorithmException, IOException {
		executeTrainJsFirstCall();
		executeWagonJsSecondCall();
		executeResourceJsThirdCall();
	}
	
	
	//1
	public void executeTrainJsFirstCall()
			throws ClientProtocolException, IOException, NoSuchAlgorithmException {

		Train train = facade.findTrainById(INTERNAL_ID_TEST);
		if (train != null) {
			facade.deleteTrainById(INTERNAL_ID_TEST);
		}
		train = facade.findTrainById(INTERNAL_ID_TEST);
		Assert.assertNull(train);

		String content = TrainUtil.readFileToStr(TRAINJS_FIRSTCALL_JSON_FILE_LOCATION);
		CloseableHttpClient client = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost("http://127.0.0.1:9091/RepositoryService/train/add/" + INTERNAL_ID_TEST);

		String json = content;
		StringEntity entity = new StringEntity(json);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		CloseableHttpResponse response = client.execute(httpPost);
		assertEquals(200, response.getStatusLine().getStatusCode());
		client.close();

		train = facade.findTrainById(INTERNAL_ID_TEST);
		Assert.assertNotNull(train);
	}
	
	//2
	public void executeWagonJsSecondCall()
			throws ClientProtocolException, IOException, NoSuchAlgorithmException {
		
		facade.deleteAllWagons();
		Wagons[] wagons = facade.findWagonsById(INTERNAL_ID_TEST);
		Assert.assertEquals(0, wagons.length);;

		String diabetesWagonJsonContent = TrainUtil.readFileToStr(DIABETES_WAGONJS_SECONDCALL_JSON_FILE_LOCATION);
		String hepatitisWagonJsonContent = TrainUtil.readFileToStr(HEPATITIS_WAGONJS_SECONDCALL_JSON_FILE_LOCATION);
		String cancerWagonJsonContent = TrainUtil.readFileToStr(CANCER_WAGONJS_SECONDCALL_JSON_FILE_LOCATION);

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:9091/RepositoryService/train/add/wagon/train/" + INTERNAL_ID_TEST);
		StringEntity entity = new StringEntity(diabetesWagonJsonContent);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		CloseableHttpResponse response = client.execute(httpPost);
		assertEquals(200, response.getStatusLine().getStatusCode());
		client.close();

		Train train = facade.findTrainById(INTERNAL_ID_TEST);
		Assert.assertNotNull(train);
		
		Assert.assertEquals(1,train.getWagons().length);
		
		
		client = HttpClients.createDefault();
		httpPost = new HttpPost("http://127.0.0.1:9091/RepositoryService/train/add/wagon/train/" + INTERNAL_ID_TEST);
		entity = new StringEntity(hepatitisWagonJsonContent);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		response = client.execute(httpPost);
		assertEquals(200, response.getStatusLine().getStatusCode());
		client.close();

		train = facade.findTrainById(INTERNAL_ID_TEST);
		Assert.assertNotNull(train);
		
		Assert.assertEquals(2,train.getWagons().length);
		
		
		client = HttpClients.createDefault();
		httpPost = new HttpPost("http://127.0.0.1:9091/RepositoryService/train/add/wagon/train/" + INTERNAL_ID_TEST);
		entity = new StringEntity(cancerWagonJsonContent);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		response = client.execute(httpPost);
		assertEquals(200, response.getStatusLine().getStatusCode());
		client.close();

		train = facade.findTrainById(INTERNAL_ID_TEST);
		Assert.assertNotNull(train);
		
		Assert.assertEquals(3,train.getWagons().length);
	}
	
	//3
	public void executeResourceJsThirdCall()
			throws ClientProtocolException, IOException, NoSuchAlgorithmException {
		
		facade.deleteAllResources();
		Resources[] resources = facade.findResourcesById(INTERNAL_ID_TEST);
		Assert.assertEquals(0, resources.length);
		

		

		String diabetesResourceJsonContent = TrainUtil.readFileToStr(DIABETES_RESOURCEJS_THIRDCALL_JSON_FILE_LOCATION);
		String hepatitisResourceJsonContent = TrainUtil.readFileToStr(HEPATITIS_RESOURCEJS_THIRDCALL_JSON_FILE_LOCATION);
		String cancerResourceJsonContent = TrainUtil.readFileToStr(CANCER_RESOURCEJS_THIRDCALL_JSON_FILE_LOCATION);

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:9091/RepositoryService/train/add/resource/train/" + INTERNAL_ID_TEST);
		StringEntity entity = new StringEntity(diabetesResourceJsonContent);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		CloseableHttpResponse response = client.execute(httpPost);
		assertEquals(200, response.getStatusLine().getStatusCode());
		client.close();

		Train train = facade.findTrainById(INTERNAL_ID_TEST);
		Assert.assertNotNull(train);
		
		Assert.assertEquals(1,train.getWagons().length);
		
		
		client = HttpClients.createDefault();
		httpPost = new HttpPost("http://127.0.0.1:9091/RepositoryService/train/add/resource/train/" + INTERNAL_ID_TEST);
		entity = new StringEntity(hepatitisResourceJsonContent);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		response = client.execute(httpPost);
		assertEquals(200, response.getStatusLine().getStatusCode());
		client.close();

		train = facade.findTrainById(INTERNAL_ID_TEST);
		Assert.assertNotNull(train);
		
		Assert.assertEquals(2,train.getWagons().length);
		
		
		client = HttpClients.createDefault();
		httpPost = new HttpPost("http://127.0.0.1:9091/RepositoryService/train/add/resource/train/" + INTERNAL_ID_TEST);
		entity = new StringEntity(cancerResourceJsonContent);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		response = client.execute(httpPost);
		assertEquals(200, response.getStatusLine().getStatusCode());
		client.close();

		train = facade.findTrainById(INTERNAL_ID_TEST);
		Assert.assertNotNull(train);
		
		Assert.assertEquals(3,train.getWagons().length);
	}

}
