package com.jsp.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jsp")
public class MyConfig {
	
	@Bean
	public EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("nish");
	}
}
