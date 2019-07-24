//package de.fraunhofer.fit.train.facade;
//
//import java.io.IOException;
//import java.security.NoSuchAlgorithmException;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import de.fraunhofer.fit.train.config.AppConfig;
//import de.fraunhofer.fit.train.mock.TrainMock;
//import de.fraunhofer.fit.train.model_v1.Train;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ContextConfiguration(classes = {AppConfig.class})
//@ComponentScan({"de.fraunhofer.fit.train"})
//@EntityScan("de.fraunhofer.fit.train")
//@SpringBootApplication
//public class ServiceFacadeTest {
//	
//	@Autowired ServiceFacade facade;
//	
//	@Autowired TrainMock trainMock;
//	
//	
//	@Test
//	public void targetNotNull() {
//		Assert.assertNotNull(facade);
//	}
//	
//	@Test
//	public void trainMockNotNull() {
//		Assert.assertNotNull(trainMock);
//	}
//	
//	
//	@Test
//	public void targetInsert() throws NoSuchAlgorithmException, IOException {
//		Train train = new Train();
//		Train mock = trainMock.getTrain(train);
//		Train trainAfterInsert = facade.insertTrain(mock);
//	}
//	
//
//
//	
//}
