package com.app.controller.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Model;

@RestController
@RequestMapping("/model")
public class ModelRestController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/info")
	public String info() {
		return "from Model Prod:"+port;
	}
	@GetMapping("/one")
	public Model getObject() {
		return new Model(10, "MR1", "LOW");
	}
	@GetMapping("/all")
	public List<Model> getAll() {
		return Arrays.asList(
				new Model(10, "MR1", "LOW"),
				new Model(11, "MR2", "HGH"),
				new Model(12, "MR3", "MDM"),
				new Model(13, "MR4", "LOW")
				);
	}
	
	
	
	
	
	
}
