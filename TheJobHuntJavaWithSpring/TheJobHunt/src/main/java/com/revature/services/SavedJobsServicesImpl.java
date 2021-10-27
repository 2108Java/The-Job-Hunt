package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Jobs;
import com.revature.models.User;
import com.revature.repo.SavedJobsDao;

@Service("jobsService")
public class SavedJobsServicesImpl implements SavedJobsServices {

	@Autowired
	private SavedJobsDao jobsDao;
	
	@Override
	public boolean createJob(Jobs job) {
		
		job.setId(-1);
		
		boolean success = false;
		
		
		
		if(jobsDao.save(job).getId()>0) {
			success= true;
		}
		
		return success;
		
	}

	@Override
	public void updateAppliedJobs(Jobs job) {
		
		jobsDao.updateAppliedFor(job.isAppliedFor(), job.getId());

	}

	@Override
	public Jobs selectJob(int id) {
		
		return jobsDao.getById(id);
	}

	@Override
	public void deleteJob(Jobs job) {
		
		jobsDao.delete(job);
	}

	@Override
	public List<Jobs> selectAllJobs(User user) {

		return jobsDao.findByUsers(user);
	}

}
