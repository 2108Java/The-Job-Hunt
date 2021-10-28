package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Jobs;
import com.revature.models.User;
import com.revature.services.SavedJobsServices;
@RestController
@RequestMapping("/jobs")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
public class SavedJobsControllerImpl implements SavedJobsController {

	@Autowired
	private SavedJobsServices jobService;
	
	@Override
	@GetMapping(value = "/getJob")
	public Jobs selectSingleJob(HttpSession session, @RequestBody Jobs job) {
		User user = (User) session.getAttribute("user");
		
		if (user!=null) {
			return jobService.selectJob(job.getId());
		}else {
			return null;
		}
		
	}

	@Override
	@GetMapping(value = "/getAllJobs")
	public List<Jobs> allTheJobs(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user != null) {
			return jobService.selectAllJobs(user);
		}else {
			return null;
		}
	}

	@Override
	@PostMapping(value ="/addJob")
	public boolean addJob(HttpSession session,@RequestBody Jobs job) {
		User user = (User) session.getAttribute("user");
		if(user != null) {
			job.setUsers(user);
			return jobService.createJob(job);
		}else {
			return false;
		}
		
		
	}

	@Override
	@PutMapping(value="/updateJob")
	public void updateAppliedJob(HttpSession session, @RequestBody Jobs job) {
		User user = (User) session.getAttribute("user");
		if(user != null) {
		jobService.updateAppliedJobs(job);
		}

	}

	@Override
	@DeleteMapping(value= "/deleteJob")
	public void deleteJob(HttpSession session, @RequestBody Jobs job) {
		User user = (User) session.getAttribute("user");
		if(user != null) {
		jobService.deleteJob(job);
		}
	}

}
