package com.tripeme.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.tripeme.api.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class ApiApplication	 {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
	

}
