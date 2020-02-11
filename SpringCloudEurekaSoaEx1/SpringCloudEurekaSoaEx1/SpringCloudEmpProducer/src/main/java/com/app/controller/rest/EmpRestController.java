package com.app.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmpRestController {

	@GetMapping("/show")
	public String showMsg() {
		return "Hello from Producer";
	}
	
	
	
}
