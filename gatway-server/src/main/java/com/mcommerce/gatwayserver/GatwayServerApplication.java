package com.mcommerce.gatwayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient

public class GatwayServerApplication {

//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("microservice-produit", r -> r.path("/produit/**").filters(f -> f.stripPrefix(1)).uri("lb://microservice-produit"))
//				.build();
//	}

	public static void main(String[] args) {
		SpringApplication.run(GatwayServerApplication.class, args);
	}

}
