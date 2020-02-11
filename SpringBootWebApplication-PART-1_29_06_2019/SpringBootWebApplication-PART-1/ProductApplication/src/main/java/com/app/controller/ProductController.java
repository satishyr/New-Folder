package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Product;
import com.app.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService service;
	
	//1. Show Product Form with Backing Object
	@RequestMapping("/reg")
	public String showReg(Model map) {
		//Form Backing Object
		map.addAttribute("product", new Product());
		return "Register";
	}
	
	//2. Read Form Data on click submit
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(
			@ModelAttribute Product product,
			Model map)
	{
		//call service layer
		Integer id=service.saveProduct(product);
		map.addAttribute("message", "Product '"+id+"' created!!");
		//clean Form Backing Object
		map.addAttribute("product", new Product());
		return "Register";
	}
	
	
	//3. Fetch all Rows from DB to UI
	@RequestMapping("/all")
	public String showAll(Model map) {
		//fetch all rows from DB
		List<Product> obs=service.getAllProducts();
		//send to UI
		map.addAttribute("list", obs);
		return "Data";
	}
	
	//4. Delete row based on ID
	@RequestMapping("/delete")
	public String remove(@RequestParam Integer id) {
		//delete row based on ID
		service.deleteProduct(id);
		//response.sendRedirect
		return "redirect:all";
	}
	
}



