package com.mycompany.springbootudemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.mycompany.springbootudemy.backend.persistence.repositories")
public class SpringBootUdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUdemyApplication.class, args);
	}
}
