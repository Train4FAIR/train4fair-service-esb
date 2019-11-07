package de.fraunhofer.fit.train.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Ignore;
import org.junit.Test;

import de.fraunhofer.fit.train.util.PropertiesUtil;
import junit.framework.Assert;

public class LandingPageTest {
	
	private static final String OK = "OK";
	
	
	
	@Test
	public void getLandingpageFromresourceContentLocal() {
		String page = PropertiesUtil.getResourceFile("content/landingpage.template");
		page = page.replace("||experimentname_var||", "train name")
				.replace("||experimentdescription_var||", "train description")
				.replace("||experimentidentifier_var||",
						"https://doi.org/" + "prefix" + "/"
								+ "suffix")
				.replace("||experimentdataciteendpoint_var||", "experiment_endpoint")
				.replace("||experimentversion_var||", "train version")
				.replace("||experimentmetadata_var||", "metadata url")
				.replace("||experimentresources_var||", "resources url")
				.replace("||experimentplatformendpoint_var||", "train flow url")
				.replace("||experimentrestapi_var||", "experiment api");
		
		System.out.println(page);
	}
	
	
	@Ignore
	@Test
	public void getLandingpageTemplate() throws URISyntaxException, ClientProtocolException, IOException {
		
		   String url = "http://167.172.175.112:9997/webdav/documentation/data/media/static/files/templates/landingpage.template";
		    String username = "admin";
		    String password = "admin";
		   
		    UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username,password);
		    System.out.println("User: "+creds.getUserPrincipal().getName());
		    System.out.println("Password: "+creds.getPassword());
		    //==
		    
		    HttpGet request = new HttpGet(url);
		    String auth = username + ":" + password;
		    byte[] encodedAuth = Base64.encodeBase64(
		      auth.getBytes(StandardCharsets.ISO_8859_1));
		    String authHeader = "Basic " + new String(encodedAuth);
		    request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
		     
		    HttpClient client = HttpClientBuilder.create().build();
		    HttpResponse response = client.execute(request);
		     
		    int statusCode = response.getStatusLine().getStatusCode();
		    Assert.assertEquals(HttpStatus.SC_OK, statusCode);
		    //assertThat(statusCode, equalTo(HttpStatus.SC_OK));
		    
		    //==
		    
//		    URI uri = new URIBuilder()
//		            .setScheme(hostname)
//		            .build();
//		    
//		 HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,HttpStatus.SC_OK, OK);
//
//         response =  Request.Get(uri)
//		    	    .connectTimeout(10000)
//		    	    .socketTimeout(10000)
//		    	    .execute()
//		    	    .returnResponse();
//
//		    	int status = response.getStatusLine().getStatusCode();
//		    	byte[] serializedObject = EntityUtils.toByteArray(response.getEntity());
//		    	System.out.println("============>>   ");
//		    	System.out.println(TrainUtil.ByteArrayToString(serializedObject));
//		    	System.out.println(status);
		
	}

}
