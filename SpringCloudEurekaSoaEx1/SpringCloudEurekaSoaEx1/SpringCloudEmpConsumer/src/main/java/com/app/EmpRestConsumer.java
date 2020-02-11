package com.app;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class EmpRestConsumer {
	@Autowired
	private DiscoveryClient client;
	
	@GetMapping("/msg")
	public String getMsg() {
		//get all service instances using Service Id 
		List<ServiceInstance> list=client.getInstances("EMP-PRODUCER");
		//read one service instance
		ServiceInstance si=list.get(0);
		//read URI(java.net)
		URI uri=si.getUri();
		//Construct URL
		String URL=uri+"/emp/show";
		
		//make request
		RestTemplate rt=new RestTemplate();
		ResponseEntity<String> resp=rt.getForEntity(URL, String.class);
		
		//read final message(entity)
		String msg=resp.getBody();
		
		return "CONSUMER:"+msg;
	}
	
	
}
