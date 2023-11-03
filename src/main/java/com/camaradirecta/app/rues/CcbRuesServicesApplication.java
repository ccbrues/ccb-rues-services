package com.camaradirecta.app.rues;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CcbRuesServicesApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(CcbRuesServicesApplication.class, args);
		} catch (Exception e) {
			System.out.println("<<<E R R O R >>>" + e);
		}
		
	}

}
