package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
	
	
	@Override
	@GetMapping(value = "/myInfo")
	public Information getUserInfo(HttpSession session) {
		User u = (User) session.getAttribute("user");
		System.out.println(u);
		this.info = infoService.getInfoByUser(u);
		System.out.println(this.info);
		return this.info;
		
	}

	
	
	@Override
	@PostMapping(value = "/myInfo")
	public Information changeAllUserInfo(HttpSession session, @RequestBody Information changedInfo) { //do I need List<K,V> as arg datatype? or will it auto-marshal?
		changedInfo.setUsers((User) session.getAttribute("user"));
		System.out.println(changedInfo);
		return infoService.saveUserInfo(changedInfo);
		
	}

	
	
	@Override
	@Transactional
	@PutMapping(value = "/myInfo")
	public Information changeSomeInfo(HttpSession session, @RequestBody Information changedInfo) {
		
		User u = (User) session.getAttribute("user");
		System.out.println(u);
		
		changedInfo.setUsers(u);
		
		if(changedInfo.getFirstName() != null) {
			infoService.updateFirstName(changedInfo);
			}
		
		if(changedInfo.getLastName() != null) {
			infoService.updateLastName(changedInfo);
			}
		
		if(changedInfo.getStreet() != null) {
			infoService.updateStreet(changedInfo);
			}
	
		if(changedInfo.getCity() != null) {
			infoService.updateCity(changedInfo);
			}
		
		if(changedInfo.getState() != null) {
			infoService.updateState(changedInfo);
			}
	
		if(changedInfo.getZip() != 0 && changedInfo.getZip() < 99999) {
			infoService.updateZipCode(changedInfo);
			}
		
		return getUserInfo(session);
	}
}