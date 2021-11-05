package com.search.sequence.commutebuddy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*
 * extending to SpringBootServletIntitializer, it has to run on external tomcat server 
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
		return app.sources(Application.class);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}