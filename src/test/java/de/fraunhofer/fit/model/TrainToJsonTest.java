package de.fraunhofer.fit.model;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.google.gson.Gson;

import de.fraunhofer.fit.train.mock.TrainMock;
import de.fraunhofer.fit.train.model.TrainWrapper;
import de.fraunhofer.fit.train.model_v1.Train;



public class TrainToJsonTest {
	
	TrainMock trainMock = new TrainMock();
	
	@Test
	public void trainToJson() throws NoSuchAlgorithmException, IOException {
		Train train = trainMock.getTrain();
		Gson gson = new Gson();
		String result = gson.toJson(train);
		System.out.println(result);
		
	}
	
//	@Test
//	public void trainToXML() throws NoSuchAlgorithmException, IOException {
//		Train train = trainMock.getTrain();
//		XStream xstream = new XStream();
//		String xml = xstream.toXML(train);
//		System.out.println(xml);
//		
//	}
///
	//@Test
//	public void trainParserTest() throws Exception {
//		// create JAXB context and instantiate marshaller
//		//=============== XML
//		JAXBContext context = JAXBContext.newInstance(Datacite.class);
//		Marshaller marshaller = context.createMarshaller();
//		marshaller.marshal(trainMock.getDatacite(), System.out);
//		//==
//		context = JAXBContext.newInstance(Train.class);
//		marshaller = context.createMarshaller();
//		marshaller.marshal(trainMock.getTrain(), System.out);
//		System.out.println("\n");
//		//=============== JSON
//		Gson gson = new Gson();
//		String result1 = gson.toJson(trainMock.getDatacite());
//		String result2= gson.toJson(trainMock.getTrain());
//		System.out.println(result1+" "+result2);
//	}

}
