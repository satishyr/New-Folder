package com.app;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReadMessageService {

	@JmsListener(destination = "my-test-ab")
	public void readMsg(Message m) {
		TextMessage tm=(TextMessage)m;
		try {
			System.out.println("From Consumer:"+tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}





