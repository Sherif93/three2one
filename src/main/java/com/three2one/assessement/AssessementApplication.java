package com.three2one.assessement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AssessementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessementApplication.class, args);
	}

}
