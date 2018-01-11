package com.ravi.poc.cloud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * SwaggerConfig class used for API documentation and provides html page.
 *
 * @author Ravi Engineering Team
 * @CopyRight (C) All rights reserved to Ravi POC World. It's Illegal to reproduce this code.
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Ravi POC World")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ravi.poc.cloud.controller"))
                .build()
                .useDefaultResponseMessages(true)
                .tags(new Tag("POC For Micro Service API Service", "All customer service end points"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Ravi POC Micro Service")
                .description("Ravi POC Micro Service API provides functionality for managing "
                        + "(create, retrieve, update, delete) for customer using gradle.")
                .contact(new Contact("Ravi POC World",null,"ravinder.nancherla@gmail.com"))
                .version("2.0")
                .build();
    }
}
