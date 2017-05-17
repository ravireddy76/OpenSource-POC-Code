package com.poc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.poc"})
public class PocApplication {

    public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}
    
}


//public class PocApplication extends SpringBootServletInitializer {
//@Override
//protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//  return application.sources(PocApplication.class);
//}
//}