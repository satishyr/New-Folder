package com.app.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.app.store.MessageStorage;

@Component
public class Consumer {
	@Autowired
	private MessageStorage storage;
	
	@KafkaListener(topics="${my.app.topicname}",groupId="groupId")
	public void consume(String message) {
		storage.put(message);
	}
}
