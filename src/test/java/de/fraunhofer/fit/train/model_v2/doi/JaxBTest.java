//package de.fraunhofer.fit.train.model_v2.doi;
//
//import java.io.IOException;
//import java.security.NoSuchAlgorithmException;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//
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
//import com.google.gson.Gson;
//
//import de.fraunhofer.fit.train.config.AppConfig;
//import de.fraunhofer.fit.train.mock.TrainDataciteMock;
//import de.fraunhofer.fit.train.model.TrainWrapper;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ContextConfiguration(classes = {AppConfig.class})
//@ComponentScan({"de.fraunhofer.fit.train"})
//@EntityScan("de.fraunhofer.fit.train")
//@SpringBootApplication
//public class JaxBTest {
//	
//		
//	//@Autowired ServiceFacade facade;
//	
//	@Autowired TrainDataciteMock trainDataciteMock;
//
//	@Test
//	public void marshallerTrainObject() throws JAXBException, NoSuchAlgorithmException, IOException {
//
//		
//
//		// create JAXB context and instantiate marshaller
//		//=============== XML
//		TrainWrapper tw = trainDataciteMock.getExecutionTestTrain();
//		JAXBContext context = JAXBContext.newInstance(TrainWrapper.class);
//		Marshaller marshaller = context.createMarshaller();
//		marshaller.marshal(tw, System.out);
//		System.out.println("\n");
//		//=============== JSON
//		Gson gson = new Gson();
//		String result = gson.toJson(tw);
//		System.out.println(result);
//		
//	}
//
//}
