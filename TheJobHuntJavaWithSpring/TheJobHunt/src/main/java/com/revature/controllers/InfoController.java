package com.revature.controllers;

import javax.servlet.http.HttpSession;
import com.revature.models.Information;

public interface InfoController {
		
	public Information changeAllUserInfo(HttpSession session, Information changedInfo);
	public Information getUserInfo(HttpSession session);
	public Information changeSomeInfo(HttpSession session, Information changedInfo);
}