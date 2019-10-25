package de.fraunhofer.fit.train.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtil {
	
	//private static final String PROP_FILE_PATH = "/Users/jbjares/workspaces/TrainmodelHelper/train-microservices-esb/src/main/resources/phtMessageBroker.properties";

	//private static final String PROP_FILE_PATH = "/resources/phtMessageBroker.properties";
	
	private static final String PROP_FILE_PATH = "phtMessageBroker.properties";
	
	public static String getPropertyFromFile(String filename, String key) {
		if(filename==null || "".equals(filename)) {
			filename = PROP_FILE_PATH;
		}
		
		String result = "";
        try (InputStream input = PropertiesUtil.class.getClassLoader().getResourceAsStream(PROP_FILE_PATH)) {

            Properties prop = new Properties();

            if (input == null) {
            	throw new RuntimeException("Fail to find pht properties file!!!");
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            result = prop.getProperty(key); 

        } catch (IOException ex) {
        	throw new RuntimeException("Fail to find pht properties file!!!",ex);
        }
        
        return result;
		
	}

	//TODO create test case
//    public static void main(String[] args) {
//
//    	System.out.println(PropertiesUtil.getPropertyFromFile(null,"env.servicediscovery.host"));
//    	System.out.println(PropertiesUtil.getPropertyFromFile(null,"env.servicediscovery.port"));
//    }
//	

	
}
