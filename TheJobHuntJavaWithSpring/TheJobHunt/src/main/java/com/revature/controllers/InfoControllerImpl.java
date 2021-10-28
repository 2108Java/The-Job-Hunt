package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
public class InfoControllerImpl implements InfoController {

	
	@Autowired
	private InfoServicesImpl infoService;
	
	private Information info = new Information();
	
	@GetMapping(value = "/test")
	public Information getTest() {

	this.info.setFirstName("Faker");
	this.info.setLastName("McFake");
	this.info.setStreet("123 Oak");
	this.info.setCity("Metro City");
	this.info.setState("OR");
	this.info.setZip(97500);
	return this.info;
	}
	
	
	@Override
	@GetMapping(value = "/more")
	public Information getUserInfo(HttpSession session) {
		User u = (User) session.getAttribute("user");
		this.info = infoService.getInfoByUser(u);
		System.out.println(this.info);
		return this.info;
		
	}

	
	
	@Override
	@PostMapping(value = "/info")
	public Information changeAllUserInfo(HttpSession session, @RequestBody Information changedInfo) { //do I need List<K,V> as arg datatype? or will it auto-marshal?
		changedInfo.setUsers((User) session.getAttribute("user"));
		System.out.println(changedInfo);
		return infoService.saveUserInfo(changedInfo);
		
	}

	
	
	@Override
	@PutMapping(value = "/info")
	public Information changeSomeInfo( @RequestBody Information changedInfo) {
		
		if(changedInfo.getFirstName() != null) {
		return infoService.updateFirstName(changedInfo);
			}
		
		if(changedInfo.getLastName() != null) {
			return infoService.updateLastName(changedInfo);
			}
		
		if(changedInfo.getStreet() != null) {
			return infoService.updateStreet(changedInfo);
			}
	
		if(changedInfo.getCity() != null) {
			return infoService.updateCity(changedInfo);
			}
		
		if(changedInfo.getState() != null) {
			return infoService.updateState(changedInfo);
			}
	
//		if(changedInfo.getZip()  null) { // we may need to change the datatype of ZipCode from int to String, because int will likely delete prefix zeros ... 
//			return infoService.updateZipCode(changedInfo);
//			}
		return changedInfo;
	}
}