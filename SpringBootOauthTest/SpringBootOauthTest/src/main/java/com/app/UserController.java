package com.app;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/user")
	public Principal getData(Principal p) {
		System.out.println(p.getClass().getName());
		return p;
	}
	
	@GetMapping("/msg")
	public String showMsg() {
		return "Hello";
	}
}
