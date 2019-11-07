package de.fraunhofer.fit.train.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "de.fraunhofer.fit.train" })
@EntityScan("de.fraunhofer.fit.train")
@SpringBootApplication(exclude = { MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
public class Application extends SpringBootServletInitializer {

//	@Autowired
//	ServiceLocatorEnvProperties serviceLocatorEnvProperties;

//	@Autowired
//	private TrainServiceLocator trainServiceLocator;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public UndertowServletWebServerFactory embeddedServletContainerFactory() {
//		UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
//
//		factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
//			@Override
//			public void customize(io.undertow.Undertow.Builder builder) {
//
//
//				String name = serviceLocatorEnvProperties.getEnvMsName();
//				String type = serviceLocatorEnvProperties.getEnvMsType();
//				String token = serviceLocatorEnvProperties.getEnvMsToken();
//
//				System.out.println("getEnvMsName: " + name);
//				System.out.println("getEnvMsType: " + type);
//				System.out.println("getEnvMsToken: " + token);
//
//
//				int port = Integer.parseInt(serviceLocatorEnvProperties.getEsbServerPort());
//				String host = serviceLocatorEnvProperties.getEsbServerHost();
//
//				System.out.println("===> host: " + host);
//				System.out.println("===> port: " + port);
//
//				builder.addHttpListener(port, host);
//
//			}
//		});
//
//		return factory;
//	}

}
