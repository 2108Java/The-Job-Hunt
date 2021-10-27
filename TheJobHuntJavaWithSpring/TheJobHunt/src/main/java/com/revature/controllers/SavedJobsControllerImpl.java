package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Jobs;
import com.revature.models.User;
import com.revature.services.SavedJobsServices;
@RestController
public class SavedJobsControllerImpl implements SavedJobsController {

	@Autowired
	private SavedJobsServices jobService;
	
	@Override
	@GetMapping(value = "/getJob")
	public Jobs selectSingleJob(HttpSession session, @RequestBody Jobs job) {
		
		System.out.println(job);
		
		return jobService.selectJob(job.getId());
	}

	@Override
	@GetMapping(value = "/getAllJobs")
	public List<Jobs> allTheJobs(HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		return jobService.selectAllJobs(user);
	}

	@Override
	@PostMapping(value ="/addJob")
	public boolean addJob(HttpSession session,@RequestBody Jobs job) {
	
		System.out.println(job);
		return jobService.createJob(job);
	}

	@Override
	@PutMapping(value="/updateJob")
	public void updateAppliedJob(@RequestBody Jobs job) {
		jobService.updateAppliedJobs(job);

	}

	@Override
	@DeleteMapping(value= "/deleteJob")
	public void deleteJob(@RequestBody Jobs job) {
		
		jobService.deleteJob(job);

	}

}
