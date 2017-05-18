package com.poc.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("*")
                .allowedMethods("POST, GET, PUT, OPTIONS, DELETE")
                .allowedHeaders("Origin", "Accept", "Content-Type")
                .maxAge(3600)
                .allowCredentials(false).maxAge(3600);
    }
}
