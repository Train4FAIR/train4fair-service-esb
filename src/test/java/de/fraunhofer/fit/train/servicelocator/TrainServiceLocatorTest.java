package de.fraunhofer.fit.train.servicelocator;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.JAXBException;

import org.json.JSONException;
import org.json.JSONObject;
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

import de.fraunhofer.fit.train.config.AppConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {AppConfig.class})
@ComponentScan({"de.fraunhofer.fit.train"})
@EntityScan("de.fraunhofer.fit.train")
@SpringBootApplication
public class TrainServiceLocatorTest {
	
	@Autowired TrainServiceLocator trainServiceLocator;
	
	@Test
	public void getEnvServiceLocatorNotNullTest() {
	
		Assert.assertNotNull(trainServiceLocator);
	
	}
	
	@Test
	public void getEnvTest() throws IOException, JSONException {
	
		JSONObject env = trainServiceLocator.locateEnvironment("TEST", "MONGO_MS", "admin");
		Assert.assertNotNull(env);
		System.out.println(env);
		System.out.println(env.get("host"));
		System.out.println(env.get("port"));
	
	}

	
		

}
