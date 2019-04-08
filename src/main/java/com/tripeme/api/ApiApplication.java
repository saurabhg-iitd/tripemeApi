package com.tripeme.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.tripeme.api.property.AwsProperties;
import com.tripeme.api.property.FileStorageProperties;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties({
    AwsProperties.class,FileStorageProperties.class
})
public class ApiApplication	 {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
	@Bean
	public Docket swaggerEmployeeApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	            .apis(RequestHandlerSelectors.basePackage("com.tripeme.api.controller"))
	            .paths(PathSelectors.any())
	        .build()
	        .apiInfo(new ApiInfoBuilder().version("1.0").title("10 Journeys API").description("Documentation 10 Journeys API v1.0").build());
	}
	
	

}
