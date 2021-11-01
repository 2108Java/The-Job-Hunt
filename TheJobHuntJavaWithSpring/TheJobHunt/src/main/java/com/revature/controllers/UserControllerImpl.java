package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserServices;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
public class UserControllerImpl implements UserController {
	@Autowired
	private UserServices userService;
	
	@Override
	@PostMapping(value ="/login")
	public User createSession(HttpSession session, @RequestBody User user) {
		User loginUser = userService.loginUser(user);
		if(loginUser!=null) {
			session.setAttribute("user", loginUser);
		}
		return loginUser;
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
	@PutMapping(value="/updateUserPassword")
	public void updateUserPassword(HttpSession session, @RequestBody User user) {
		User oldUser = (User) session.getAttribute("user");
		if(session.getAttribute("user") != null) {	
			user.setId(oldUser.getId());
			user.setUserEmail(oldUser.getUserEmail());
			userService.updateUserPassword(user);
			session.setAttribute("user", user);
		}
		
	}

	@Override
	@PutMapping(value="/updateUserEmail")
	public void updateUserEmail(HttpSession session, User user) {
		User oldUser = (User) session.getAttribute("user");
		if(session.getAttribute("user") != null) {
			user.setId(oldUser.getId());
			user.setUserPassword(oldUser.getUserPassword());
			userService.updateUserEmail(user);
			session.setAttribute("user", user);
		}
		
	}
	@Override
	@PostMapping(value="/createUser")
	public User createUser(@RequestBody User user, HttpSession session) {
		System.out.println(user);
		user = userService.insertUser(user);
		session.setAttribute("user", user);
		System.out.println(session.getAttribute("user"));
		return user;
	}



}
