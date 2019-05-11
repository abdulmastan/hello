package com.liquidhub.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.liquidhub.batch.repository.BatchRepositoryImpl;
import com.liquidhub.batch.service.BatchServiceImpl;

@SpringBootApplication
@PropertySource("classpath:errormessages.properties")
@Import({ BatchServiceImpl.class, BatchRepositoryImpl.class })
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}