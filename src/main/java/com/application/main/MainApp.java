package com.application.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.application.controller") 
@ComponentScan(basePackages = "com.application.service") 
@EnableJpaRepositories(basePackages = "com.application.repository")
@EntityScan(basePackages = "com.application.domain")
@ComponentScan(basePackages = "com.application.domain") 
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

}
