package com.poc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan({ "com.poc" })
@Import({ SwaggerConfig.class })
public class PocApplication {
	
	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(PocApplication.class);
		sa.run(args);
	}

	@Bean
	public String applicationName() {
		return "springboot-maven-poc";
	}
}
