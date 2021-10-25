package com.revature.controllers;

import javax.servlet.http.HttpSession;

import com.revature.models.User;

public interface UserController {
	
	void createSession(HttpSession session, User user);
	
	void invalidateSession(HttpSession session);
	
	void validateSession(HttpSession session);
	
	void updateUser(HttpSession session, User user);
	
	void createUser(User user);
	
	

}
