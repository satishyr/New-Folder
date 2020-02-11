package com.app.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelMqRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		//from("file:D:/source").to("jms:queue:oneab");
		from("jms:queue:indata").to("file:D:/source?fileName=info.txt");
	}
}





