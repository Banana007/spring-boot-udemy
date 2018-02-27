package com.mycompany.springbootudemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.mycompany.springbootudemy.backend.persistence.domain.backend")
public class SpringBootUdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUdemyApplication.class, args);
	}
}
