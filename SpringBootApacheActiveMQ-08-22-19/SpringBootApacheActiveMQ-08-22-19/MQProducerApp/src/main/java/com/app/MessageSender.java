package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
@Component
public class MessageSender implements CommandLineRunner {
	@Autowired
	private JmsTemplate jt;

	public void run(String... args)	throws Exception {
		jt.send("my-test-ab", 
				s->s.createTextMessage("Hello  MQ"));
		System.out.println("done");
		System.exit(0);
	}

}



