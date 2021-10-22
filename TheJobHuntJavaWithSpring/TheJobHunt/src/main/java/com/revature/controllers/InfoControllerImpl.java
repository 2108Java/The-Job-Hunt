package com.revature.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("FoodController")
@RequestMapping("/api/")
public class InfoControllerImpl implements InfoController {

	@Override
	@GetMapping("/hello")
	public String testMethod() {
		// TODO Auto-generated method stub
		return "Hello";
	}

}
