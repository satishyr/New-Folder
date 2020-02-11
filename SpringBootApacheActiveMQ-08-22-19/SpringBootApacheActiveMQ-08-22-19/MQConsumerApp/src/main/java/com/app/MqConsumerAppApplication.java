package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class MqConsumerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqConsumerAppApplication.class, args);
	}

}
