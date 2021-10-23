package com.revature.repo;

import com.revature.models.Jobs;
import com.revature.models.User;

public interface SavedJobsDao {
	
	/*
	 * insert job
update applied for
select saved job
delete job
	 */

	
	boolean insertJob(Jobs j);
	boolean updateApplied(Jobs j);
	boolean selectSavedJob(Jobs j);
	boolean delete(Jobs u);
}
