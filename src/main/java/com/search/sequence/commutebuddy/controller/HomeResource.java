package com.search.sequence.commutebuddy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class HomeResource {

	

	@GetMapping("/")
	public String home() {
		return ("<h1>Welcome home</h1>");
	}
	
	
	@GetMapping("/user")
	public String user() {
		return ("Welcome user. THis is fist demo");
	}
	
	@GetMapping("/admin/new") 
	public String admin() {
		return ("<h1>Welcome Admin</h1>");
		
	}
}
