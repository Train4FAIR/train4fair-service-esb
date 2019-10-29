package de.fraunhofer.fit.train.servicelocator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
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
	
	public JSONObject locateEnvironment(String env,String type, String token) throws IOException {
		
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
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(urlsb.toString());
		HttpResponse response = client.execute(request);

		// Get the response
		BufferedReader rd = new BufferedReader
		    (new InputStreamReader(
		    response.getEntity().getContent()));

		String line = "";
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		
		JSONObject envJsonObject = new JSONObject(sb.toString());
		return envJsonObject;
		
	}

}
