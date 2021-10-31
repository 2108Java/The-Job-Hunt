package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repo.UserDao;

@Service("UserService")
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserDao userDao;


	@Override
	public User userExists(User user) {

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
	public boolean insertUser(User user) {
		boolean success = false;
		
		if(userDao.save(user).getId()>0) {
			success= true;
		}
		
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
