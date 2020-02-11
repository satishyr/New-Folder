package com.app.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Dept;

@RestController
@RequestMapping("/dept")
public class DeptRestController {
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/show")
	public String showData() {
		return "FROM SHOW METHOD:"+port;
	}
	
	@GetMapping("/read")
	public String readId(
			@RequestParam("sid")String sid) {
		return "FROM READ METHOD:"+sid;
	}
	
	@GetMapping("/ob")
	public Dept getDept() {
		return new Dept(102,"SATHYA","DEV");
	}
	
	@GetMapping("/all")
	public List<Dept> getAllDept() {
		return Arrays.asList(
				new Dept(101,"SATHYA","DEV"),
				new Dept(102,"AAA","QA"),
				new Dept(103,"BBB","DEV")
				);
	}
	
}



