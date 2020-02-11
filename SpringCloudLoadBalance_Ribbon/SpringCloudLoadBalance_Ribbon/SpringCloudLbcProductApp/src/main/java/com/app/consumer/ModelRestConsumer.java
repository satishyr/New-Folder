package com.app.consumer;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ModelRestConsumer {

	@Autowired
	private LoadBalancerClient lbc;
	
	public String getInfo() {
		System.out.println(lbc.getClass().getName());
		ServiceInstance si=lbc.choose("MODEL-PROD");
		URI u=si.getUri();
		return new RestTemplate()
				.getForEntity(u+"/model/info",
						String.class)
				.getBody();
		
	}
	
	public String getOne() {
		return new RestTemplate()
				.getForEntity(
						lbc.choose("MODEL-PROD")
						.getUri()+"/model/one",
						String.class)
				.getBody();
	}
	
	
	public String getAll() {
		return new RestTemplate()
				.getForEntity(
						lbc.choose("MODEL-PROD")
						.getUri()+"/model/all",
						String.class)
				.getBody();
	}
	
	
	
}
