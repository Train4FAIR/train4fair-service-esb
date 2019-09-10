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
import org.springframework.core.env.Environment;

import de.fraunhofer.fit.train.servicelocator.TrainServiceLocator;



@ComponentScan({"de.fraunhofer.fit.train"})
@EntityScan("de.fraunhofer.fit.train")
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class Application extends SpringBootServletInitializer {
	

	
	  @Autowired
	  private Environment env;

	  @Autowired 
	  private TrainServiceLocator trainServiceLocator;
	
    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public UndertowServletWebServerFactory embeddedServletContainerFactory() {
    	UndertowServletWebServerFactory factory = 
          new UndertowServletWebServerFactory();
         
        factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
            @Override
            public void customize(io.undertow.Undertow.Builder builder) {
        		String name = env.getProperty("env.ms.name");
        		String type = env.getProperty("env.ms.type");
        		String token = env.getProperty("env.ms.token");
        		
        		JSONObject env;
        		try {
        			env = trainServiceLocator.locateEnvironment(name,type,token);
        			builder.addHttpListener(Integer.parseInt(env.getString("port")), env.getString("host"));
        			//return new MongoClient(env.getString("host"), Integer.parseInt(env.getString("port")));
        		} catch (IOException e) {
        			throw new RuntimeException("Error reading the db properties through service locator on AppConfig class");
        		}
                
            }
        });
         
        return factory;
    }
    
//    @Bean
//    public void servletContainer() throws LifecycleException  {
//    	
//    	/**
//    	 * server:
//  servlet:
//    context-path: /RepositoryService
//  port: 9091
//  address: 0.0.0.0
//    	 */
//    	
//    	TomcatServletWebServerFactory tomcatContainerFactory
//        = new TomcatServletWebServerFactory();
//    	
//    	
//        
////        Tomcat tomcat = new Tomcat();
////        tomcat.setPort(9990);
////        StandardHost host = new StandardHost();
////        //host.setAppBase();
////        tomcat.setHostname("127.0.0.1");
////        tomcat.setHost(host);
////        tomcat.start();
//        
//    }
}

