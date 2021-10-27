package com.revature.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Information;
import com.revature.models.User;
import com.revature.services.InfoServicesImpl;


@RestController("InfoController")
@RequestMapping(value = "/info")
public class InfoControllerImpl implements InfoController {

	
	@Autowired
	private InfoServicesImpl infoService;

	

	@Override
	@GetMapping(value = "/info/{id}")	//@Path - necessary?
	public Information getUserInfo(@RequestBody User user) { 
		
		return null;
	}

	
	@Override
	@PostMapping(value = "/info/{id}")
	public Information changeAllUserInfo(@RequestBody Map<String,String> newInfo) { //do I need List<K,V> as arg datatype? or will it auto-marshal?

		return null;
	}

	
	@Override
	@PutMapping(value = "/info/{id}")
	public Information changeSomeInfo(@RequestBody Map<String,String> newInfo) {

		return null;
	}

	
	
}