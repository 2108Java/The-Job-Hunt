package com.revature.services;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.controllers.UserController;
import com.revature.models.User;

@RestController
public class UserControllerImpl implements UserController {

	private UserServices userService;
	@Override
	@PostMapping(value ="/login")
	public void createSession(HttpSession session, User user) {
		
		if(userService.loginUser(user)) {
			session.setAttribute("user", user);
		}
	}

	@Override
	@GetMapping(value ="/logout")
	public void invalidateSession(HttpSession session) {
		session.invalidate();

	}

	@Override
	@GetMapping(value ="/checkUser")
	public void validateSession(HttpSession session) {
		// TODO Auto-generated method stub

	}

	@Override
	@PutMapping(value="/updateUser")
	public void updateUser(HttpSession session, User user) {
		
		if(session.getAttribute("user") != null) {
			userService.updateUserEmail(user);
			userService.updateUserPassword(user);
		}
		
	}

	@Override
	@PostMapping(value="/createUser")
	public void createUser(User user) {
		
		userService.insertUser(user);
		
	}

}
