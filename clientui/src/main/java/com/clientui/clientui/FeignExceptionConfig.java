package com.clientui.clientui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.clientui.clientui.exception.CustomErrorDecoder;

@Configuration
public class FeignExceptionConfig {
	
	 @Bean
	   public CustomErrorDecoder mCustomErrorDecoder(){
	       return new CustomErrorDecoder();
	   }

}
