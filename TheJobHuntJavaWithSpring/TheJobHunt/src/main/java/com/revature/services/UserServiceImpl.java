package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repo.UserDao;

@Service("UserService")
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserDao userDao;
//	private static User user= new User(1,"fakeEmail@gmail.com","fake", null);;
//	
//	private static User intializeUser() {
//		
//		return user;
//	}
//	private static User createUser(User newUser) {
//		user = newUser;
//		
//		return user;
//	}
	
	@Override
	public boolean authenticate(User user) {
			
		
		return false;
	}

	@Override
	public User userExists(User user) {
		
//		return intializeUser();
		User userExists = userDao.getByUserEmail(user.getUserEmail());
		if(userExists!=null)
			return userExists;
		else {
			return null;
		}
	}

	@Override
	public User loginUser(User user) {
		
		boolean success= false;
		User testUser = userExists(user);
		
		if (testUser!=null) {
			if(user.getUserPassword().equals(testUser.getUserPassword())) {
				success = true;
			}
		}
		if(success) {
			return testUser;
		}else {
			return null;
		}
		
	}
 
	@Override
	public User insertUser(User user) {
	
		
//		createUser(user);
		user = userDao.save(user);

		
		return user;
	}

	@Override
	public boolean updateUserEmail(User user) {

//		this.user.setUserEmail(user.getUserEmail());
		userDao.updateEmail(user.getUserEmail(), user.getId());
		return false;
	}

	@Override
	public boolean updateUserPassword(User user) {
		
		userDao.updatePassword(user.getUserPassword(), user.getId());
//		this.user.setUserPassword(user.getUserPassword());
		
		return false;
	}

}
