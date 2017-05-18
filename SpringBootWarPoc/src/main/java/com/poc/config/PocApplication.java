package com.poc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = { "com.poc" })
@Import({ SwaggerConfig.class })
public class PocApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(PocApplication.class);
		sa.run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PocApplication.class);
	}

//	@Bean
//	public String applicationName() {
//		return "springboot-war-poc";
//	}
}

//public class PocApplication extends SpringBootServletInitializer {
//@Override
//protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//  return application.sources(PocApplication.class);
//}
//}

//public class PocApplication {
//
//    public static void main(String[] args) {
//		SpringApplication.run(PocApplication.class, args);
//	}
//    
//}