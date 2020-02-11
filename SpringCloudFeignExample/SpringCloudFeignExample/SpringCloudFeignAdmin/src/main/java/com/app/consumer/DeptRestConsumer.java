package com.app.consumer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Dept;

@FeignClient("DEPT-SERVICE")
public interface DeptRestConsumer {

	@GetMapping("/dept/show")
	public String showDatas();
	@GetMapping("/dept/read")
	public String readId(@RequestParam("sid")String sid);
	
	@GetMapping("/dept/ob")
	public Dept getDept();
	@GetMapping("/dept/all")
	public List<Dept> getAllDept(); 
	
}




