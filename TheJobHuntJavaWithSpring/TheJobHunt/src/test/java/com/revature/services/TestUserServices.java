package com.revature.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import com.revature.models.User;

public class TestUserServices {
	
	private static User user = new User();
	
	private UserServices userServices;
	
	@Test
	public void testAuthenticate() {
		
		
//		(userServices.authenticate(user));
	}
	
	@Test
	public void testUserExists() {
		
	}
	
	@Test
	public void testInsertUser() {
		
		userServices.insertUser(user);
	}
	
	@Test
	public void testUpdateUserPassword() {
		
	}

	@Test
	public void testLoginUser() {
		
	}
	
	@Test
	public void testUpdateUserEmail() {
		
	}
}
