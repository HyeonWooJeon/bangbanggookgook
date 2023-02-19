package com.care.KorTravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class KorTravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(KorTravelApplication.class, args);
	}

}
