package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BackendCmApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCmApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate resttemplate() {
		return new RestTemplate();
	}


}
