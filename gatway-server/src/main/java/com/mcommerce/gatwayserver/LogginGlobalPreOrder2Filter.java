package com.mcommerce.gatwayserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LogginGlobalPreOrder2Filter  implements GlobalFilter,Ordered{

	final Logger logger =
		      LoggerFactory.getLogger(LogginGlobalPreOrder2Filter.class);
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		logger.info("Global Pre Filter 2 Executed");
		 return chain.filter(exchange)
		          .then(Mono.fromRunnable(() -> {
		              logger.info("Last Post Global 2 Filter");
		            }));
	}
	@Override
	public int getOrder() {
		return 1;
	}
	
	
}
