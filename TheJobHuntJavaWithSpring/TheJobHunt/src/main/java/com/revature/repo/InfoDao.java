package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.revature.models.Information;
import com.revature.models.User;

public interface InfoDao extends JpaRepository<Information, Integer>{

	
/*
 * insert info
update info
select info by id
﻿delete info
 */
	//void update(Information i);
	//users_info(user_info_id, first_name, last_name, street, city, state, zip, user_id)
	
	
	@Modifying
	@Query("update Information i set i.firstName = ?1 where i.users.id = ?2")
	void updateFirstName(String firstName, int userid);
	
	@Modifying
	@Query("update Information i set i.lastName = ?1 where i.users.id = ?2")
	void updateLastName(String lastName, int userId);
	
	@Modifying
	@Query("update Information i set i.street = ?1 where i.users.id  = ?2")
	void updateStreet(String street, int userId);
	
	@Modifying
	@Query("update Information i set i.city = ?1 where i.users.id  = ?2")
	void updateCity(String city, int userId);
		
	@Modifying
	@Query("update Information i set i.state = ?1 where i.users.id  = ?2")
	void updateState(String state, int userId);
	
	@Modifying	
	@Query("update Information i set i.zip = ?1 where i.users.id  = ?2")
	void updateZipCode(int zipcode, int userId);

	
}
