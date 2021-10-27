package com.revature.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

import com.revature.models.Information;
import com.revature.models.User;

public interface InfoController {
		
	public Information getUserInfo(User user);
	public Information changeAllUserInfo(User user, Information changedInfo);
	public Information changeSomeInfo(Information changedInfo);
}