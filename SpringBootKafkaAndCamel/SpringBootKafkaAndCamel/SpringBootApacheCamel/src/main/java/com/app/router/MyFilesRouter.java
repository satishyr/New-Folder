package com.app.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFilesRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("file:D:\\source")
		.to("file:D:\\desti");
	}
}
