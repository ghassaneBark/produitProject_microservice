package com.clientui.clientui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfig 
{
	 @Bean
	    public BasicAuthRequestInterceptor  basicAuthRequestInterceptor() {
		 BasicAuthRequestInterceptor interceptor = new BasicAuthRequestInterceptor("utilisateur","utilisateur");
		return interceptor;
	    }
}