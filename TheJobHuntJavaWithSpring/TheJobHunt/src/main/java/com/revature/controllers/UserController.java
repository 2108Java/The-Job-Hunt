package com.revature.controllers;

import javax.servlet.http.HttpSession;

import com.revature.models.User;

public interface UserController {
	
	User createSession(HttpSession session, User user);
	
	void invalidateSession(HttpSession session);
	
	User validateSession(HttpSession session);
	
	void updateUser(HttpSession session, User user);
	
	void createUser(User user);
	
	

}
