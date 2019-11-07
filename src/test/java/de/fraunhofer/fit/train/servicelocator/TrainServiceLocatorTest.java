package de.fraunhofer.fit.train.servicelocator;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.JAXBException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { AppConfig.class })
@ComponentScan({ "de.fraunhofer.fit.train" })
@EntityScan("de.fraunhofer.fit.train")
@SpringBootApplication
public class TrainServiceLocatorTest {

	@Autowired
	TrainServiceLocator trainServiceLocator;

	@Test
	public void getEnvServiceLocatorNotNullTest() {

		Assert.assertNotNull(trainServiceLocator);

	}

	@Ignore
	@Test
	public void getEnvTest() throws IOException, JSONException {

		JSONObject env = trainServiceLocator.locateEnvironment("TEST", "MONGO_MS", "admin");
		Assert.assertNotNull(env);
		System.out.println(env);

	}

	@Test
	public void getEnvMSTest() throws IOException, JSONException {

		System.out.println(locateEnvironment());
		System.out.println("===============================");
		System.out.println(getServerContentsJson());
		System.out.println("===============================");
		getSrvContent();

	}
	
	public JSONObject getSrvContent() throws ParseException, IOException, JSONException {

        HttpGet request = new HttpGet("http://train.platform.de:8881/ServiceDiscovery/train/service/discovery/TEST/WEBDAV_METADATA/admin");

        // add request headers
        request.addHeader(HttpHeaders.USER_AGENT, "jbjares");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getProtocolVersion());              // HTTP/1.1
            System.out.println(response.getStatusLine().getStatusCode());   // 200
            System.out.println(response.getStatusLine().getReasonPhrase()); // OK
            System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
				JSONObject envJsonObject = new JSONObject(result);
				return envJsonObject;
            }

        }
        throw new RuntimeException("Fail to obtain ");
	}

	private JSONObject getServerContentsJson() throws IOException, JSONException {
		HttpClient httpclient = new DefaultHttpClient();

		String responseString = null;
		HttpResponse response = null;
		try {
			response = httpclient.execute(new HttpGet(
					"http://train.platform.de:8881/ServiceDiscovery/train/service/discovery/TEST/WEBDAV_METADATA/admin"));

			StatusLine statusline = response.getStatusLine();

			if (statusline.getStatusCode() == HttpStatus.SC_OK) {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				response.getEntity().writeTo(out);
				responseString = out.toString();
				out.close();
				JSONObject envJsonObject = new JSONObject(responseString);
				return envJsonObject;
			} else {
				responseString = statusline.getReasonPhrase();
			}
		} catch (IOException e) {
			throw new IOException(e.getMessage(), e);
			// OR:
			// responseString = "Could not reach server, please try again";
		} finally {
			if (response != null) {
				response.getEntity().consumeContent();
			}
		}
		JSONObject envJsonObject = new JSONObject(responseString);
		return envJsonObject;
	}

	public JSONObject locateEnvironment() throws IOException, JSONException {

		StringBuilder sb = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://train.platform.de:8881/ServiceDiscovery/train/service/discovery/TEST/WEBDAV_METADATA/admin");
		HttpResponse response = client.execute(request);

		// Get the response
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		String line = "";
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		JSONObject envJsonObject = new JSONObject(sb.toString());
		return envJsonObject;

	}
}
