package com.revature.services;

import com.revature.models.User;

public interface UserServices {

	boolean authenticate(User user);
	
	User userExists(User user);
	
	User loginUser(User user);
	
	User insertUser(User user);
	
	boolean updateUserEmail(User user);
	
	boolean updateUserPassword(User user);
	
	

}
