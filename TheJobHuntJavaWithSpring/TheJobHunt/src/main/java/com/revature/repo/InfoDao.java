package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Information;
import com.revature.models.User;

@Repository("infoDao")
public interface InfoDao extends JpaRepository<Information, Integer>{

	
/*
 * insert info
update info
select info by id
﻿delete info
 */
	
	//void update(Information i);
	//users_info(user_info_id, first_name, last_name, street, city, state, zip, user_id)
	
	@Transactional
	@Modifying
	@Query("update Information i set i.firstName = ?1 where i.users.id = ?2")
	int updateFirstName(String firstName, int userid);
	
	@Transactional
	@Modifying
	@Query("update Information i set i.lastName = ?1 where i.users.id = ?2")
	int updateLastName(String lastName, int userId);
	
	@Transactional
	@Modifying
	@Query("update Information i set i.street = ?1 where i.users.id  = ?2")
	int updateStreet(String street, int userId);
	
	@Transactional
	@Modifying
	@Query("update Information i set i.city = ?1 where i.users.id  = ?2")
	int updateCity(String city, int userId);
	
	@Transactional
	@Modifying
	@Query("update Information i set i.state = ?1 where i.users.id  = ?2")
	int updateState(String state, int userId);
	
	@Transactional
	@Modifying	
	@Query("update Information i set i.zip = ?1 where i.users.id  = ?2")
	int updateZipCode(int zipcode, int userId);

	
}
