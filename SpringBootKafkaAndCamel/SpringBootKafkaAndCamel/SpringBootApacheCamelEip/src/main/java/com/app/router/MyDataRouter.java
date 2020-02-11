package com.app.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyDataRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		
		from("file:D:/source")
		.choice()
		.when(body().startsWith("java")).to("file:D:/desti?fileName=a.txt")       
		.when(body().startsWith("xml")).to("file:D:/desti?fileName=b.txt")
		.when(body().startsWith("json")).to("file:D:/desti?fileName=c.txt")
		.otherwise().to("file:D:/desti?fileName=d.txt");
		
		
		
		
		
		
		
		
	}
}
