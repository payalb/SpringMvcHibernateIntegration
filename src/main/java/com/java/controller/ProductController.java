package com.java.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dao.ProductRepository;
import com.java.dto.Product;

@Controller
public class ProductController {
	
	@Autowired ProductRepository rep;
	
	@GetMapping("/products")
	public String getProducts(Model model) {
		model.addAttribute("products", rep.getProducts());
		return "product";
	}

	@GetMapping("/addproduct")
	public String getProductAddPage() {
		return "addProduct";
	}
	
	@PostMapping("/addproduct")
	public String saveProduct(@ModelAttribute Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "addProduct";
		}
		product.setCreateiondate(LocalDateTime.now());
		rep.saveProduct(product);
		return "redirect:products";
	}
	
	@GetMapping("/deleteproduct")
	public String deleteProduct(int id) {
		rep.deleteProduct(id);
		return "redirect:products";
	}
	
	@GetMapping("/updateproduct")
	public String updateProduct(@ModelAttribute Product product, BindingResult result) {
		rep.updateProduct(product);
		return "addProduct";
	}
	/*@InitBinder
	public void init(WebDataBinder binder) {
		binder.s
	}*/
}
