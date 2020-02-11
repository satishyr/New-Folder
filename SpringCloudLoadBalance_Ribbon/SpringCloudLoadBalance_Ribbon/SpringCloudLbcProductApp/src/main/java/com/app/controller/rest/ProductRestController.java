package com.app.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.consumer.ModelRestConsumer;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	@Autowired
	private ModelRestConsumer modelconsumer;
	
	@GetMapping("/show")
	public String showInfo() {
		String info=modelconsumer.getInfo();
		return "From Product::"+info;
	}
	
	@GetMapping("/one")
	public String showOne() {
		String one=modelconsumer.getOne();
		return "FROM PRODUCT:"+one;
	}
	@GetMapping("/all")
	public String showAll() {
		String all=modelconsumer.getAll();
		return "FROM PRODUCT:"+all;
	}
	
	
	
	
	
	
}
