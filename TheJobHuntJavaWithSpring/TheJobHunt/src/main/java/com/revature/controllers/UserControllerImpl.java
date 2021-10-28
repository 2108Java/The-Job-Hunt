package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserServices;

@RestController
public class UserControllerImpl implements UserController {
	@Autowired
	private UserServices userService;
	
	@Override
	@PostMapping(value ="/login")
	public User createSession(HttpSession session, @RequestBody User user) {
		if(userService.loginUser(user)) {
			session.setAttribute("user", user);
		}
		return user;
	}

	@Override
	@GetMapping(value ="/logout")
	public void invalidateSession(HttpSession session) {
		session.invalidate();

	}

	@Override
	@GetMapping(value ="/checkUser")
	public User validateSession(HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		return user;
	}

	@Override
	@PutMapping(value="/updateUser")
	public void updateUser(HttpSession session, @RequestBody User user) {
		
		if(session.getAttribute("user") != null) {
			
			session.setAttribute("user", user);
			System.out.println(user);
			userService.updateUserEmail(user);
			userService.updateUserPassword(user);
		}
		
	}

	@Override
	@PostMapping(value="/createUser")
	public void createUser(@RequestBody User user) {
		
		userService.insertUser(user);
		
	}

}
