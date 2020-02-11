package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.producer.Producer;
import com.app.store.MessageStorage;

@RestController
public class KafkaRestController {
	@Autowired
	private Producer producer;
	
	@Autowired
	private MessageStorage storage;
	
	@RequestMapping("/send")
	public String readInMessage(@RequestParam String message) {
		producer.sendMessage(message);
		return "message sent!!";
	}
	
	@RequestMapping("/view")
	public String viewOutMessage() {
		return storage.getAll();
	}
	
	
	
	
	
}
