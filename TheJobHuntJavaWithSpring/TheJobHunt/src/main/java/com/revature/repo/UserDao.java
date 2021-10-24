package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.revature.models.User;

public interface UserDao extends JpaRepository<User, Integer>{
	/*
	boolean insertUser(User u);
	boolean updatePassword(User u);
	boolean updateEmail(User u);
	User selectUser(User u);
*/
	
	//User save(User u);
	//User getById(int id);
	//void updatePassword(User u);
	//void updateEmail(User u);
	@Modifying
	@Query("update User u set u.userPassword = ?1 where u.id = ?2")
	void updatePassword(String password, int id);
	
	@Modifying
	@Query("update User u set u.userEmail = ?1 where u.id = ?2")
	void updateEmail(String email, int id);
	
}
