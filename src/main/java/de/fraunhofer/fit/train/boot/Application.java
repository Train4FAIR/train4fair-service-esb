package de.fraunhofer.fit.train.boot;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import de.fraunhofer.fit.train.properties.ServiceLocatorEnvProperties;
import de.fraunhofer.fit.train.servicelocator.TrainServiceLocator;

@ComponentScan({ "de.fraunhofer.fit.train" })
@EntityScan("de.fraunhofer.fit.train")
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class Application extends SpringBootServletInitializer {

	@Autowired
	ServiceLocatorEnvProperties serviceLocatorEnvProperties;

//	@Autowired
//	private TrainServiceLocator trainServiceLocator;

	public static void main(String[] args) throws Exception {
		// System.getProperties().put( "server.port", 9091 );
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public UndertowServletWebServerFactory embeddedServletContainerFactory() {
		UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();

		factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
			@Override
			public void customize(io.undertow.Undertow.Builder builder) {
//				String name = env.getProperty("env.ms.name");
//				String type = env.getProperty("env.ms.type");
//				String token = env.getProperty("env.ms.token");

				String name = serviceLocatorEnvProperties.getEnvMsName();
				String type = serviceLocatorEnvProperties.getEnvMsType();
				String token = serviceLocatorEnvProperties.getEnvMsToken();

				System.out.println("getEnvMsName: " + name);
				System.out.println("getEnvMsType: " + type);
				System.out.println("getEnvMsToken: " + token);

//				JSONObject env;
//				try {
//					env = trainServiceLocator.locateEnvironment(name, type, token);

//					System.out.println("===> name: " + name);
//					System.out.println("===> type: " + type);
//					System.out.println("===> token: " + token);

					int port = Integer.parseInt(serviceLocatorEnvProperties.getEsbServerPort());
					String host = serviceLocatorEnvProperties.getEsbServerHost();

					System.out.println("===> host: " + host);
					System.out.println("===> port: " + port);

					builder.addHttpListener(port, host);
//				} catch (IOException e) {
//					throw new RuntimeException(
//							"Error reading the db properties through service locator on AppConfig class", e);
//				}

			}
		});

		return factory;
	}

}
