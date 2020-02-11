package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.Product;
import com.app.service.ProductService;
import com.app.util.EmailUtil;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	private ProductService service;
	@Autowired 
	private EmailUtil mailUtil;
	
	//1. Show Product Form with Backing Object
	@RequestMapping("/reg")
	public String showReg(Model map) {
		//Form Backing Object
		Product p=new Product();
		map.addAttribute("product",p);
		return "Register";
	}
	
	//2. Read Form Data on click submit
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(
			@ModelAttribute Product product,
			@RequestParam MultipartFile fileOb,
			Model map)
	{
		//call service layer
		Integer id=service.saveProduct(product);
		
		//send email
		mailUtil.send(product.getEmail(), "Product added", "Hello User", fileOb);
		
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
	
	//5. Show Edit Page
	@RequestMapping("/edit")
	public String showEdit(
			@RequestParam Integer id
			,Model map) {
		//load object from DB
		Product p=service.getProductById(id);
		//FORM BACKING OBJECT
		map.addAttribute("product",p);
		map.addAttribute("Mode", "EDIT");
		return "Register";
	}
	
	
	
}



