package com.mexpedition.microserviceexpedition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
public class MicroserviceExpeditionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceExpeditionApplication.class, args);
	}
	
	@Bean
    public Logger logger() {
        return LoggerFactory.getLogger("com.ecommerce.microcommerce"); // Spécifiez le nom de votre logger
    }

}
