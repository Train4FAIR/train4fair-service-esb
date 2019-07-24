package de.fraunhofer.fit.train.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"de.fraunhofer.fit.train"})
@EntityScan("de.fraunhofer.fit.train")
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class Application extends SpringBootServletInitializer {
	

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(Application.class, args);
    }
}

