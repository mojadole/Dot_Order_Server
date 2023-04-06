package com.dotorder.DotOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class DotOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DotOrderApplication.class, args);
	}

}
