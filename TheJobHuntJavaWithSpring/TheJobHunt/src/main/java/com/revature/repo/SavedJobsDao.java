package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Jobs;
import com.revature.models.User;

@Repository("savedJobDao")
public interface SavedJobsDao extends JpaRepository<Jobs, Integer>{

	/*
	 * insert job
update applied fors
select saved job
delete job
	 */
	
	@Transactional
	@Modifying
	@Query("update Jobs j set j.appliedFor = ?1 where j.id = ?2")
	int updateAppliedFor(boolean applied, int id);

}
