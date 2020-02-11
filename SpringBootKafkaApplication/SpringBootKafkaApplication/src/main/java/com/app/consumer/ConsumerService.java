package com.app.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.app.persist.MessageStorage;

@Component
public class ConsumerService {

	@Autowired
	private MessageStorage ms;
	
	@KafkaListener(topics="${my-tpc-name}",groupId="group-id")
	public void readMessage(String message) {
		System.out.println("consumer is executed");
		ms.save(message);
	}
}



