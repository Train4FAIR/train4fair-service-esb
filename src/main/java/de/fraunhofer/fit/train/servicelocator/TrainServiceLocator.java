package de.fraunhofer.fit.train.servicelocator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.StandardServletEnvironment;

import de.fraunhofer.fit.train.properties.ServiceLocatorEnvProperties;
import de.fraunhofer.fit.train.util.PropertiesUtil;

@EnableAspectJAutoProxy
@Service
public class TrainServiceLocator {
	
	
	@Autowired ServiceLocatorEnvProperties serviceLocatorEnvProperties;
	
	public JSONObject locateEnvironment(String env,String type, String token) throws ParseException, IOException, JSONException {
		StringBuilder urlsb = new StringBuilder();
		
		System.out.println("===> "+serviceLocatorEnvProperties.getHost());
		urlsb.append(serviceLocatorEnvProperties.getProtocol());
		urlsb.append(serviceLocatorEnvProperties.getHost());
		urlsb.append(":");
		urlsb.append(serviceLocatorEnvProperties.getPort());
		urlsb.append(serviceLocatorEnvProperties.getAppContext());
		urlsb.append(serviceLocatorEnvProperties.getServiceContext());
		urlsb.append("/");
		urlsb.append(env);
		urlsb.append("/");
		urlsb.append(type);
		urlsb.append("/");
		urlsb.append(token);
		String url = urlsb.toString();
		System.out.println("===> url_srv_loc: "+url);
		
        HttpGet request = new HttpGet(url);

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
        throw new RuntimeException("Fail to obtain content of url: "+url);
	}
	
	@Deprecated
	public JSONObject locateEnvironment_deprecated(String env,String type, String token) throws IOException {
		
		StringBuilder urlsb = new StringBuilder();
		
		System.out.println("===> "+serviceLocatorEnvProperties.getHost());
		urlsb.append(serviceLocatorEnvProperties.getProtocol());
		urlsb.append(serviceLocatorEnvProperties.getHost());
		urlsb.append(":");
		urlsb.append(serviceLocatorEnvProperties.getPort());
		urlsb.append(serviceLocatorEnvProperties.getAppContext());
		urlsb.append(serviceLocatorEnvProperties.getServiceContext());
		urlsb.append("/");
		urlsb.append(env);
		urlsb.append("/");
		urlsb.append(type);
		urlsb.append("/");
		urlsb.append(token);
		System.out.println("===> url_srv_loc: "+urlsb.toString());
		StringBuilder sb = new StringBuilder();
		System.out.println("===> StringBuilder sb = new StringBuilder();");
		HttpClient client = new DefaultHttpClient();
		System.out.println("===> HttpClient client = new DefaultHttpClient();");
		HttpGet request = new HttpGet(urlsb.toString());
		System.out.println("===> HttpGet request = new HttpGet(urlsb.toString());");
		HttpResponse response = client.execute(request);
		System.out.println("===> HttpResponse response = client.execute(request);");

		// Get the response
		BufferedReader rd = new BufferedReader
		    (new InputStreamReader(
		    response.getEntity().getContent()));
		System.out.println("===> response.getEntity().getContent()));");

		String line = "";
		while ((line = rd.readLine()) != null) {
			System.out.println("===> line = rd.readLine()): "+line);
			sb.append(line);
		}
		System.out.println("===> sb.toString(): "+sb.toString());
		JSONObject envJsonObject = new JSONObject(sb.toString());
		System.out.println("===> JSONObject envJsonObject = new JSONObject(sb.toString()): "+envJsonObject);
		return envJsonObject;
		
	}

}
