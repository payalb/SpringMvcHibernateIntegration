package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	/*@RequestMapping("/login")
	public String getIndexPage() {
		return "index";
	}*/

	@RequestMapping("/welcome")
	public String getWelcomePage() {
		return "welcome";
	}
	
	@RequestMapping("/form")
	public String getformPage() {
		return "form";
	}
}
