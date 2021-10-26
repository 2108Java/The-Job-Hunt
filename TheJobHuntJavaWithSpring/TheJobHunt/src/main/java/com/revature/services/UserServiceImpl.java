package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repo.UserDao;

@Service("UserService")
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserDao userDao;
	private static User user= new User(1,"fakeEmail@gmail.com","fake", null);;
	
	private static User intializeUser() {
		
		return user;
	}
	private static User createUser(User newUser) {
		user = newUser;
		
		return user;
	}
	
	@Override
	public boolean authenticate(User user) {
			
		
		return false;
	}

	@Override
	public User userExists(User user) {
		
		return intializeUser();
		
//		if(userDao.findbyEmail(user.getUserEmail())==1)
//			return user;
//		else {
//			return null;
//		}
	}

	@Override
	public boolean loginUser(User user) {
		
		boolean success= false;
		User testUser = userExists(user);
		
		if (testUser!=null) {
			if(user.getUserEmail().equals(testUser.getUserEmail())) {
				success = true;
			}
		}
		
		return success;
	}

	@Override
	public boolean insertUser(User user) {
		boolean success = false;
		
		createUser(user);
		success = true;
		
//		if(userDao.save(user).getId()>0) {
//			success= true;
//		}
		
		return success;
	}

	@Override
	public boolean updateUserEmail(User user) {
		userDao.updateEmail(user.getUserEmail(), user.getId());
		return false;
	}

	@Override
	public boolean updateUserPassword(User user) {
		
		userDao.updatePassword(user.getUserPassword(), user.getId());
		
		
		return false;
	}

}
