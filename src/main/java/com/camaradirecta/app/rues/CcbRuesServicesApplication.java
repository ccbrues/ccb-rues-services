package com.camaradirecta.app.rues;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class CcbRuesServicesApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		try {
			SpringApplication.run(CcbRuesServicesApplication.class, args);
		} catch (Exception e) {
			System.out.println("<<<E R R O R >>>" + e);
		}
		
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CcbRuesServicesApplication.class);
	}
	
	

}
