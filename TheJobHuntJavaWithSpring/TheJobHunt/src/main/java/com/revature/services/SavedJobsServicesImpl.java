package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Jobs;
import com.revature.models.User;
import com.revature.repo.SavedJobsDao;

@Service("jobsService")
public class SavedJobsServicesImpl implements SavedJobsServices {

	@Autowired
	private SavedJobsDao jobsDao;
	
	private static final Logger loggy = Logger.getLogger(SavedJobsServices.class);
	
	@Override
	public boolean createJob(Jobs job) {
		
		job.setId(-1);
		
		boolean success = false;
		
		loggy.info("creating job in database");
		
		if(jobsDao.save(job)!=null) {
			success= true;
		}
		
		return success;
		
	}

	@Override
	public void updateAppliedJobs(Jobs job) {
		loggy.info("update job applied for");
		jobsDao.updateAppliedFor(job.isAppliedFor(), job.getId());

	}

	@Override
	public Jobs selectJob(int id) {
		loggy.info("selecting an individual job");
		return jobsDao.getById(id);
	}

	@Override
	public void deleteJob(Jobs job) {
		loggy.info("deleting a job from database");
		jobsDao.delete(job);
	}

	@Override
	public List<Jobs> selectAllJobs(User user) {
		loggy.info("get all the jobs for the user");
		return jobsDao.findByUsers(user);
	}

}
