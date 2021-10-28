package com.revature.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;

import com.revature.models.Information;
import com.revature.models.User;

public interface InfoController {
		
	public Information changeAllUserInfo(HttpSession session, Information changedInfo);
	public Information getUserInfo(HttpSession session);
	public Information changeSomeInfo(HttpSession session, Information changedInfo);
}