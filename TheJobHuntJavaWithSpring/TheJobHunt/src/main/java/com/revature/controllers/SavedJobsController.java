package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.models.Jobs;

public interface SavedJobsController {
	
	
	public Jobs selectSingleJob(HttpSession session, Jobs job);
	
	public List<Jobs> allTheJobs(HttpSession session);
	
	public boolean addJob(HttpSession session, Jobs job);
	
	public void updateAppliedJob(Jobs job);
	
	public void deleteJob(Jobs job);
	
	

}
