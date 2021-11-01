package com.revature.controllers;

import javax.servlet.http.HttpSession;

import com.revature.models.User;

public interface UserController {
	
	User createSession(HttpSession session, User user);
	
	void invalidateSession(HttpSession session);
	
	User validateSession(HttpSession session);
	
	void updateUserPassword(HttpSession session, User user);
	
	void updateUserEmail(HttpSession session, User user);
	

	User createUser(User user, HttpSession session);
	
	

}
