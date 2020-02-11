package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudLbcModelAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudLbcModelAppApplication.class, args);
	}

}
