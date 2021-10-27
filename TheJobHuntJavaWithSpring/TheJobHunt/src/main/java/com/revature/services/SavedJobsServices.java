package com.revature.services;

import java.util.List;

import com.revature.models.Jobs;
import com.revature.models.User;

public interface SavedJobsServices {

	
	boolean createJob(Jobs job);
	
	void updateAppliedJobs(Jobs job);
	
	Jobs selectJob(int id);
	
	void deleteJob(Jobs job);
	
	List<Jobs> selectAllJobs(User user);
}
