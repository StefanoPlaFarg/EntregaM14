package com.application.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.application.controller") 
@ComponentScan(basePackages = "com.application.service") 
@ComponentScan(basePackages = "com.application.repository")
@ComponentScan(basePackages = "com.application.domain") 
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

}
