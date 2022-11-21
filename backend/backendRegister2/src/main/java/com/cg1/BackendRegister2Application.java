package com.cg1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BackendRegister2Application {

	public static void main(String[] args) {
		SpringApplication.run(BackendRegister2Application.class, args);
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate resttemplate() {
		return new RestTemplate();
	}

}
