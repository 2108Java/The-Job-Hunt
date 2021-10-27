package com.revature.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Data;


import com.revature.models.Information;
import com.revature.models.User;
import com.revature.services.InfoServicesImpl;


@RestController("InfoController")
@RequestMapping(value = "/info")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
public class InfoControllerImpl implements InfoController {

	
	@Autowired
	private InfoServicesImpl infoService;

	

	@Override
	@GetMapping(value = "/info/{id}")	//@Path - necessary?
	public Information getUserInfo( @PathVariable("id") int id, @RequestBody User user) {
		
		return null;
	}

	
	@Override
	@PostMapping(value = "/info/{id}")
	public Information changeAllUserInfo( @PathVariable("id") int id, @RequestBody Map<String,String> changedInfo, HttpSession httpsession) { //do I need List<K,V> as arg datatype? or will it auto-marshal?
		Information userChanges = new Information(
				id,
				httpsession.getAttribute("user"),
				changedInfo.get("firstName"),
				changedInfo.get("lastName"),
				changedInfo.get("street"),
				changedInfo.get("city"),
				changedInfo.get("state"),
				changedInfo.get("zip")
				);
		return infoService.saveUserInfo(userChanges);
	}

	
	
	@Override
	@PutMapping(value = "/info/{id}")
	public Information changeSomeInfo( @PathVariable("id") int id, @RequestBody Map<String,String> changedInfo) {
		changedInfo.get("street") //etc
		return infoService. ;
	}

	
	
}