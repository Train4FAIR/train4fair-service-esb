package de.fraunhofer.fit.train.config;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

import de.fraunhofer.fit.train.properties.ServiceLocatorEnvProperties;
import de.fraunhofer.fit.train.servicelocator.TrainServiceLocator;

@EnableMongoRepositories(value = { "de.fraunhofer.fit.train.persistence" })
@PropertySource("file:src/main/resources/phtMessageBroker.properties")
@PropertySource("file:src/main/resources/log4j.properties")
@Configuration(value = "file:src/main/resources/application.yml")
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class AppConfig extends AbstractMongoConfiguration {

	@Autowired
	ServiceLocatorEnvProperties serviceLocatorEnvProperties;

//	@Autowired
//	TrainServiceLocator trainServiceLocator;

	@Override
	protected String getDatabaseName() {
		return serviceLocatorEnvProperties.getEnvDbName();
	}

	@Override
	protected String getMappingBasePackage() {
		return "de.fraunhofer.fit.train";
	}

	@Override
	public MongoClient mongoClient() {
//		String name = env.getProperty("env.db.name");
//		String type = env.getProperty("env.db.type");
//		String token = env.getProperty("env.db.token");
		
		
		String name = serviceLocatorEnvProperties.getEnvDbName();
		String type = serviceLocatorEnvProperties.getEnvDbType();
		String token = serviceLocatorEnvProperties.getEnvDBToken();
		
		System.out.println("getEnvDbName: "+name);
		System.out.println("getEnvDbType: "+type);
		System.out.println("getEnvDBToken: "+token);

//		JSONObject env;
//		try {
//			env = trainServiceLocator.locateEnvironment(name, type, token);
			int port = Integer.parseInt(serviceLocatorEnvProperties.getEsbDBPort());
			String host = serviceLocatorEnvProperties.getEsbDBHost();
			
			System.out.println("mongo host: "+host);
			System.out.println("mongo port: "+port);
			return new MongoClient(host,port);
//		} catch (IOException e) {
//			throw new RuntimeException("Error reading the db properties through service locator on AppConfig class");
//		}

	}

}
