package com.poc.rest.springboot;

import com.poc.rest.springboot.utils.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan({
        "com.poc.rest.springboot.domain",
        "com.poc.rest.springboot.service",
        "com.poc.rest.springboot.controller"
})
@Import({
        SwaggerConfig.class
})
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(CustomerApplication.class);
        sa.run(args);
    }

    @Bean
    public String applicationName() {
        return "rest-springboot";
    }
}
