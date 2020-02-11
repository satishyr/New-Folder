package com.app;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Test3Application {

	public static void main(String[] args) {
		SpringApplication.run(Test3Application.class, args);
	}

}
