package com.revature.repo;

import com.revature.models.User;

public interface UserDao {

	
	/*
	 * insert user
update password
update email
﻿select user
	 */

	boolean insertUser(User u);
	boolean updatePassword(User u);
	boolean updateEmail(User u);
	User selectUser(User u);
	
}
