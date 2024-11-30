package com.camaradirecta.app.rues.config;

import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GeneralConfig {
	
	private static final String VERSION_ARTIFACT = "1.1.1.20241130";
	
	static { MDC.put("Version-artifact", VERSION_ARTIFACT); }

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}
