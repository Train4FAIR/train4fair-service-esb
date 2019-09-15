package de.fraunhofer.fit.train.facade;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

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
import de.fraunhofer.fit.train.mock.TrainMock;
import de.fraunhofer.fit.train.model_v1.Train;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {AppConfig.class})
@ComponentScan({"de.fraunhofer.fit.train"})
@EntityScan("de.fraunhofer.fit.train")
@SpringBootApplication
public class ServiceFacadeTest {
	
	@Autowired ServiceFacade facade;
	
	@Autowired TrainMock trainMock;
	
	private static final String CANCER_SQL_QUERY_NODE_GENERATED_BASE64 = "U0VMRUNUIGNhbmNlciBGUk9NIGRpc2Vhc2U7";
	
	
	@Test
	public void targetNotNull() {
		Assert.assertNotNull(facade);
	}
	
	@Test
	public void trainMockNotNull() {
		Assert.assertNotNull(trainMock);
	}
	
	
	@Test
	public void targetInsert() throws NoSuchAlgorithmException, IOException {
		Train train = trainMock.getTrain();
		Train trainAfterInsert = facade.saveTrainBasic(train);
		Assert.assertNotNull(trainAfterInsert);
	}
	
	@SuppressWarnings("resource")
	@Test
	public void compareCancerSqlStreamBetweenNoderedAndJavaTest() throws NoSuchAlgorithmException, IOException {

	    String contentByte=readFile("/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/CancerSqlQuery.sql");
	    byte[] bytesEncoder = 
	    Base64.getEncoder().encode(contentByte.getBytes(StandardCharsets.UTF_8));
	    //Data received by you at server end(base64 encoded data as string)
	    contentByte = new String(bytesEncoder);
	    System.out.println("===>  bytesEncoder "+new String(bytesEncoder));
	    System.out.println("===>  CANCER_SQL_QUERY_NODE_GENERATED_BASE64 "+CANCER_SQL_QUERY_NODE_GENERATED_BASE64);
	    Assert.assertEquals(bytesEncoder,CANCER_SQL_QUERY_NODE_GENERATED_BASE64);
        
	}
	

	@SuppressWarnings("resource")
	@Test
	public void decodeBigXmlFileDataApplicationOctetStreamBase64Test() throws NoSuchAlgorithmException, IOException {

	    String contentByte=readFile("/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/datacite_doi_findable.xml");
	    byte[] bytesEncoder = 
	    Base64.getEncoder().encode(contentByte.getBytes(StandardCharsets.UTF_8));
	    //Data received by you at server end(base64 encoded data as string)
	    contentByte = new String(bytesEncoder);

	    System.out.println(new String(bytesEncoder));
		try {
	        File file = File.createTempFile("BigXMLFile",".xml", new File("/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/") );
	         byte[] bytesDecoder = Base64.getDecoder().decode(contentByte.getBytes(StandardCharsets.UTF_8));
	         Files.write(file.toPath(), bytesDecoder);
		}catch(Exception e){
			throw new RuntimeException("Error!",e);
		}

        
	}
	
	@SuppressWarnings("resource")
	@Test
	public void decodeSmallFileDataApplicationOctetStreamBase64Test() throws NoSuchAlgorithmException, IOException {

	    String contentByte=readFile("/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/input2.cql");;
	    byte[] bytesEncoder = 
	    Base64.getEncoder().encode(contentByte.getBytes(StandardCharsets.UTF_8));
	    //Data received by you at server end(base64 encoded data as string)
	    contentByte = new String(bytesEncoder);

		try {
	        File file = File.createTempFile("input2",".cql", new File("/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/") );
	         byte[] bytesDecoder = Base64.getDecoder().decode(contentByte.getBytes(StandardCharsets.UTF_8));
	         Files.write(file.toPath(), bytesDecoder);
	         System.out.println(bytesDecoder);
		}catch(Exception e){
			throw new RuntimeException("Error!",e);
		}

        
	}
	
	@SuppressWarnings("resource")
	@Test
	public void decodeLargeImageFileDataApplicationOctetStreamBase64Test() throws NoSuchAlgorithmException, IOException {

		String contentByte=readFile("/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/bonecoNeve_lu.jpeg");
	    byte[] bytesEncoder = 
	    Base64.getEncoder().encode(contentByte.getBytes(StandardCharsets.UTF_8));
	    //Data received by you at server end(base64 encoded data as string)
	    contentByte = new String(bytesEncoder);

		try {
	        File file = File.createTempFile("bonecoNeve_lu",".jpeg", new File("/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/") );
	         byte[] bytesDecoder = Base64.getDecoder().decode(contentByte.getBytes(StandardCharsets.UTF_8));
	         Files.write(file.toPath(), bytesDecoder);
	         System.out.println(bytesDecoder);
		}catch(Exception e){
			throw new RuntimeException("Error!",e);
		}

        
	}
	
	@SuppressWarnings("resource")
	@Test
	public void decodeSmallFileDataApplicationOctetStreamBase64Test2() throws NoSuchAlgorithmException, IOException {

		String filePath = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/";

		try {

	        /* Encode a file and write the encoded output to a text file. */
	        encode(filePath+"input2.cql", filePath+"input2_encoded.txt", IS_CHUNKED);

	        /* Decode a file and write the decoded file to file system */
	        decode(filePath+"input2_encoded.txt", filePath+"input2_decoded.cql");
		}catch(Exception e){
			throw new RuntimeException("Error!",e);
		}

        
	}
	
	@SuppressWarnings("resource")
	@Test
	public void decodeMediumPDFFileDataApplicationOctetStreamBase64Test() throws NoSuchAlgorithmException, IOException {

		String filePath = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/";

		try {

	        /* Encode a file and write the encoded output to a text file. */
	        encode(filePath+"trainInstanceObj.pdf", filePath+"trainInstanceObj_encoded.txt", IS_CHUNKED);

	        /* Decode a file and write the decoded file to file system */
	        decode(filePath+"trainInstanceObj_encoded.txt", filePath+"trainInstanceObj_decoded.pdf");
		}catch(Exception e){
			throw new RuntimeException("Error!",e);
		}

        
	}


	
	@SuppressWarnings("resource")
	@Test
	public void decodeLargeImageFileDataApplicationOctetStreamBase64Test2() throws NoSuchAlgorithmException, IOException {

		String filePath = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/";
		try {
	        /* Encode a file and write the encoded output to a text file. */
	        encode(filePath+"bonecoNeve_lu.jpeg", filePath+"bonecoNeve_encoded.txt", IS_CHUNKED);

	        /* Decode a file and write the decoded file to file system */
	        decode(filePath+"bonecoNeve_encoded.txt", filePath+"bonecoNeve_decoded.jpeg");
		}catch(Exception e){
			throw new RuntimeException("Error!",e);
		}

        
	}
	
	

	private String readFile(String file) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    try {
	        while((line = reader.readLine()) != null) {
	            stringBuilder.append(line);
	            stringBuilder.append(ls);
	        }

	        return stringBuilder.toString();
	    } finally {
	        reader.close();
	    }
	}
	
	//==
	
    private static final boolean IS_CHUNKED = true;


    /**
     * This method converts the content of a source file into Base64 encoded data and saves that to a target file.
     * If isChunked parameter is set to true, there is a hard wrap of the output  encoded text.
     */
    private static void encode(String sourceFile, String targetFile, boolean isChunked) throws Exception {

        byte[] base64EncodedData = org.apache.commons.codec.binary.Base64.encodeBase64(loadFileAsBytesArray(sourceFile), isChunked);

        writeByteArraysToFile(targetFile, base64EncodedData);
    }

    public static void decode(String sourceFile, String targetFile) throws Exception {

        byte[] decodedBytes = org.apache.commons.codec.binary.Base64.decodeBase64(loadFileAsBytesArray(sourceFile));

        writeByteArraysToFile(targetFile, decodedBytes);
    }

    /**
     * This method loads a file from file system and returns the byte array of the content.
     * 
     * @param fileName
     * @return
     * @throws Exception
     */
    public static byte[] loadFileAsBytesArray(String fileName) throws Exception {

        File file = new File(fileName);
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        reader.close();
        return bytes;

    }

    /**
     * This method writes byte array content into a file.
     * 
     * @param fileName
     * @param content
     * @throws IOException
     */
    public static void writeByteArraysToFile(String fileName, byte[] content) throws IOException {

        File file = new File(fileName);
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
        writer.write(content);
        writer.flush();
        writer.close();

    }
	
}
