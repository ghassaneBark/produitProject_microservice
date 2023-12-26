package com.mproduits;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "mes-configs")
@Data
@RefreshScope
public class ApplicationPropertiesConfiguration {
	
	private int limitDeProduits;

}
