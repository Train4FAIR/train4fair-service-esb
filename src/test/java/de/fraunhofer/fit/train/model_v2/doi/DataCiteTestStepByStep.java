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
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import de.fraunhofer.fit.train.util.TrainUtil;

public class DataCiteTestStepByStep {

	private static final String OK = "OK";

	private static final String APPLICATION_VND_API_JSON = "application/vnd.api+json";

	private static final String UTF_8 = "UTF-8";

	private static final String TEMPLATE_LOCATION = "/Users/jbjares/workspaces/TrainmodelHelper/TrainModel/src/main/resources/content/my_draft_doi.json";
	
	private static final String TEMPLATE_LOCATION_XML = "/Users/jbjares/workspaces/TrainmodelHelper/TrainModel/src/main/resources/content/my_draft_doiXML.xml";
	
	private static final String TEMPLATE_FROM_DRAFT_TO_REGISTERED = "/Users/jbjares/workspaces/TrainmodelHelper/train-model-service/src/main/resources/content/change_draft_to_rester_doi.json";

	
	
	//@Test
	public void getDraftDOI() throws Exception {
		//https://api.datacite.org/dois
		   String hostname = "https://api.test.datacite.org/dois";
		    String password = "Nahan@123";
		    String username = "DEV.FIT";
		   
		    UsernamePasswordCredentials creds = new UsernamePasswordCredentials(hostname, password);
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
		            .setPath("/dois")
		            .setParameter("username", username).build();

		    
            HttpEntity entity = MultipartEntityBuilder.create()
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .setCharset(Charset.forName(UTF_8))
                    .addBinaryBody("my_draft_doi.json", new File(TEMPLATE_LOCATION))
                    //.addBinaryBody("@my_draft_doi.json", FileUtils.readFileToByteArray(new File(TEMPLATE_LOCATION)), ContentType.create(APPLICATION_VND_API_JSON), "my_draft_doi.json")
                    .build();
            
	}



}
