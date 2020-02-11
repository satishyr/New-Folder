package com.app.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@RequestMapping("/user")
	public Principal showUser(Principal p) {
		return p;
	}
	
	@RequestMapping("/home")
	public String showData() {
		return "Hello";
	}
}
