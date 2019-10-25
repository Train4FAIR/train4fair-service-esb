package de.fraunhofer.fit.train.servicelocator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import de.fraunhofer.fit.train.util.PropertiesUtil;

@EnableAspectJAutoProxy
@Service
public class TrainServiceLocator {
	
	//TODO remove it
	//private static final String SERVICE_DISCOVERY_URL = "http://menzel.informatik.rwth-aachen.de:8881/ServiceDiscovery/train/service/discovery";

	public JSONObject locateEnvironment(String env,String type, String token) throws IOException {
		
		
		//String url = SERVICE_DISCOVERY_URL+"/"+env+"/"+type+"/"+token;
		StringBuilder urlsb = new StringBuilder();
		
		urlsb.append(PropertiesUtil.getPropertyFromFile(null,"env.servicediscovery.protocol"));
		urlsb.append(PropertiesUtil.getPropertyFromFile(null,"env.servicediscovery.host"));
		urlsb.append(":");
		urlsb.append(PropertiesUtil.getPropertyFromFile(null,"env.servicediscovery.port"));
		urlsb.append(PropertiesUtil.getPropertyFromFile(null,"env.servicelocator.app.context"));
		urlsb.append(PropertiesUtil.getPropertyFromFile(null,"env.servicediscovery.service.context"));
		urlsb.append("/");
		urlsb.append(env);
		urlsb.append("/");
		urlsb.append(type);
		urlsb.append("/");
		urlsb.append(token);
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
