package com.revature.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Jobs;
import com.revature.models.User;
@Transactional
public interface SavedJobsDao extends JpaRepository<Jobs, Integer>{

	/*
	 * insert job
update applied for
select saved job
delete job
	 */
	
	
	@Modifying
	@Query("update Jobs j set j.appliedFor = ?1 where j.id = ?2")
	int updateAppliedFor(boolean applied, int id);

	List<Jobs> findByUsers(User user);

}
