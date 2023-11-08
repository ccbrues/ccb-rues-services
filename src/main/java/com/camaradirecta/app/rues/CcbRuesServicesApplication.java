package com.camaradirecta.app.rues;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableAsync
public class CcbRuesServicesApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(CcbRuesServicesApplication.class, args);
		} catch (Exception e) {
			System.out.println("<<<E R R O R >>>" + e);
		}
		
	}

}
