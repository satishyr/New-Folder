package com.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {
	@Value("${my-tpc-name}")
	private String topic;
	
	@Autowired
	private KafkaTemplate<String, String> kt;
	
	public void send(String message) {
		System.out.println("message sent from producer");
		kt.send(topic,message);
	}
}




