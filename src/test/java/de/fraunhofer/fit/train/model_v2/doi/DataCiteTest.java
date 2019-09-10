package de.fraunhofer.fit.train.model_v2.doi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicHttpResponse;
import org.junit.Test;

import ch.qos.logback.core.util.ContentTypeUtil;

public class DataCiteTest {

	private static final String OK = "OK";

	private static final String APPLICATION_VND_API_JSON = "application/vnd.api+json";

	private static final String UTF_8 = "UTF-8";

	private static final String TEMPLATE_LOCATION = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/my_draft_doi.json";
	
	private static final String TEMPLATE_LOCATION_XML = "/Users/jbjares/workspaces/TrainmodelHelper/TrainModel/src/main/resources/content/my_draft_doiXML.xml";
	
	private static final String TEMPLATE_FROM_DRAFT_TO_REGISTERED = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/change_draft_to_rester_doi.json";
	
	private static final String COMMAND_LINE = "curl -X POST -H \"Content-Type: application/vnd.api+json\" --user DEV.FIT:Nahan@123 -d @my_draft_doi.json https://api.test.datacite.org/dois -iv";
	
	private static final String COMMAND_LINE2 = "curl -X POST -H \"Content-Type: application/vnd.api+json\" --user DEV.FIT:Nahan@123 -d "+"\"/content/my_draft_doi.json\""+" https://api.test.datacite.org/dois -iv";

	
	@Test
	public void getDraftDOI() throws Exception {
		String command = "COMMAND_LINE2";
		Process process = Runtime.getRuntime().exec(command);
		process.getInputStream();
		
//	    String password = "Nahan@123";
//	    String username = "DEV.FIT";
//	CurlExecutor.execute(username, password, TEMPLATE_LOCATION);
	}
	
	//@Test
	public void getDOI() throws Exception {
		//https://api.datacite.org/dois
		   String hostname = "api.test.datacite.org";
		    String password = "Nahan@123";
		    String username = "DEV.FIT";
		   
		    UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username, password);
		    System.out.println("User: "+creds.getUserPrincipal().getName());
		    System.out.println("Password: "+creds.getPassword());
		   
		    String authString = username + ":" + password;
		    System.out.println("auth string: " + authString);
		    byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
		    String authStringEnc = new String(authEncBytes);
		    System.out.println("Base64 encoded auth string: " + authStringEnc);
		   
		    URI uri = new URIBuilder()
		            .setScheme("https")
		            .setHost(hostname)
		            .setPath("/dois")
		            .build();

		    
            HttpEntity entity = MultipartEntityBuilder.create()
                    .setCharset(Charset.forName(UTF_8))
                    .setContentType(ContentType.create(APPLICATION_VND_API_JSON))
                    .addBinaryBody(TEMPLATE_LOCATION, FileUtils.readFileToByteArray(new File(TEMPLATE_LOCATION)))
                    .build();
            
            
//            HttpPost post = new HttpPost(uri);
//		    post.addHeader("Content-Type", "application/vnd.api+json");
//		    post.addHeader("--user","DEV.FIT:Nahan@123");
//		    post.addHeader("-d",TEMPLATE_LOCATION);
//		    //post.setEntity(entity);
//		    System.out.println(post.getURI());
//		    HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
//            HttpStatus.SC_OK, OK);
//
//            System.out.println(response.getProtocolVersion());
//            System.out.println(response.getStatusLine().getStatusCode());
//            System.out.println(response.getStatusLine().getReasonPhrase());
//            System.out.println(response.getStatusLine().toString());
   

            InputStreamEntity reqEntity = new InputStreamEntity(
                    new FileInputStream(new File(TEMPLATE_LOCATION)), -1, ContentType.create(APPLICATION_VND_API_JSON));
            reqEntity.setChunked(true);
            reqEntity.setContentType(APPLICATION_VND_API_JSON);
            reqEntity.setContentEncoding(UTF_8);
            
            System.out.println("uri ========>>>  "+uri);
            System.out.println(
            Request.Post(uri)
            .body(reqEntity)
            .execute().toString()); 
	}
	//@Test
	public void getDraftDOI2() throws Exception {
		//https://api.datacite.org/dois
		   String hostname = "https://api.test.datacite.org/dois";
		    String password = "Nahan@123";
		    String username = "DEV.FIT";
		   
		    UsernamePasswordCredentials creds = new UsernamePasswordCredentials(hostname, password);
		    System.out.println("User: "+creds.getUserPrincipal().getName());
		    System.out.println("Password: "+creds.getPassword());
		   
		    String authString = hostname + ":" + "123";
		    System.out.println("auth string: " + authString);
		    byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
		    String authStringEnc = new String(authEncBytes);
		    System.out.println("Base64 encoded auth string: " + authStringEnc);
		   
		    URI uri = new URIBuilder()
		            .setScheme("https")
		            .setHost("api.test.datacite.org")
		            .setPath("/dois")
		            //.setParameter("username", username).build();
		            .build();

		    
            HttpEntity entity = MultipartEntityBuilder.create()
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .setCharset(Charset.forName(UTF_8))
                    .addBinaryBody("my_draft_doiXML.XML", new File(TEMPLATE_LOCATION_XML))
                    .addBinaryBody("@my_draft_doiXML.xml", FileUtils.readFileToByteArray(new File(TEMPLATE_LOCATION_XML)), ContentType.create(APPLICATION_VND_API_JSON), "my_draft_doi.json")
                    .build();
            
		    HttpPost post = new HttpPost(uri);
		    post.addHeader("Content-Type", "application/vnd.api+json");
		    post.addHeader("--user","DEV.FIT:Nahan@123");
		    post.addHeader("-d","@my_draft_doiXML.xml");
		    post.setEntity(entity);
		    System.out.println(post.getURI());
		    HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
		            HttpStatus.SC_OK, OK);

		            System.out.println(response.getProtocolVersion());
		            System.out.println(response.getStatusLine().getStatusCode());
		            System.out.println(response.getStatusLine().getReasonPhrase());
		            System.out.println(response.getStatusLine().toString());
		   

		            InputStreamEntity reqEntity = new InputStreamEntity(
		                    new FileInputStream(new File(TEMPLATE_LOCATION)), -1, ContentType.APPLICATION_OCTET_STREAM);
		            reqEntity.setChunked(true);
		            
		            
		            System.out.println(
		            Request.Get(uri)
		            .connectTimeout(1000)
		            .socketTimeout(1000)
		            .execute().returnContent().asString()); 
	}
	
	//@Test
	public void getDraftDOI0001() throws Exception {
		//https://api.datacite.org/dois
		   String hostname = "https://api.test.datacite.org/dois";
		    String password = "Nahan@123";
		    String username = "DEV.FIT";
		   
		    UsernamePasswordCredentials creds = new UsernamePasswordCredentials("DEV.FIT", "Nahan@123");
		    System.out.println("User: "+creds.getUserPrincipal().getName());
		    System.out.println("Password: "+creds.getPassword());
		   
		    String authString = hostname + ":" + password;
		    System.out.println("auth string: " + authString);
		    byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
		    String authStringEnc = new String(authEncBytes);
		    System.out.println("Base64 encoded auth string: " + authStringEnc);
		   
		    URI uri = new URIBuilder()
		            .setScheme("https")
		            .setHost("api.test.datacite.org")
		            .setPath("/dois/10.20408/3gsp-ye99")
		            .setParameter("username", username).build();
		    //CloseableHttpClient httpclient = HttpClients.createDefault();
		    HttpGet httpGet = new HttpGet(uri);
		    System.out.println("========>>>  "+httpGet.getURI());
		    HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
		            HttpStatus.SC_OK, OK);

		            System.out.println(response.getProtocolVersion());
		            System.out.println(response.getStatusLine().getStatusCode());
		            System.out.println(response.getStatusLine().getReasonPhrase());
		            System.out.println(response.getStatusLine().toString());
		            
		            
		            
		            HttpEntity entity = MultipartEntityBuilder.create()
		                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
		                    .setCharset(Charset.forName(UTF_8))
		                    .addBinaryBody("@change_draft_to_rester_doi.json", FileUtils.readFileToByteArray(new File(TEMPLATE_FROM_DRAFT_TO_REGISTERED)), ContentType.create(APPLICATION_VND_API_JSON), "change_draft_to_rester_doi.json")
		                    .build();
		   
		            System.out.println("uri ========>>>  "+uri);
		            //System.out.println(
		            Request.Post(uri)
		            .connectTimeout(1000)
		            .socketTimeout(1000)
		            .body(entity)
		            .execute().toString();//); 
	}
	
	//@Test
	public void autogeneratedoi() throws URISyntaxException, ClientProtocolException, IOException {
		
		   String hostname = "https://api.test.datacite.org/dois";
		    String username = "DEV.FIT";
		    String password = "Nahan@123";
		   
		    UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username,password);
		    System.out.println("User: "+creds.getUserPrincipal().getName());
		    System.out.println("Password: "+creds.getPassword());
		    
		    
		    URI uri = new URIBuilder()
		            .setScheme(hostname)
		            .setHost("api.test.datacite.org")
		            .setPath("/dois/10.20408/")
		            .setParameter("username", username)
		            .setParameter("password", password)
		            .build();
		    
		    //CloseableHttpClient httpclient = HttpClients.createDefault();
		    HttpGet post = new HttpGet(uri);
		    HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
		            HttpStatus.SC_OK, OK);
		    
//            HttpEntity entity = MultipartEntityBuilder.create()
//                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
//                    .setCharset(Charset.forName(UTF_8))
//                    .addBinaryBody("@change_draft_to_rester_doi.json", new File(TEMPLATE_FROM_DRAFT_TO_REGISTERED))
//                    .build();
//
            response =  Request.Post(uri)
		    	    .connectTimeout(10000)
		    	    .socketTimeout(10000)
		    	    //.body(entity)
		    	    .execute()
		    	    .returnResponse();
//
//		    	int status = response.getStatusLine().getStatusCode();
//		    	byte[] serializedObject = EntityUtils.toByteArray(response.getEntity());
//		    	System.out.println("============>>   ");
//		    	System.out.println(TrainUtil.ByteArrayToString(serializedObject));
//		    	System.out.println(status);
//		
	}


}
