package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository("userDao")
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
	
	@Transactional
	@Modifying
	@Query("update User u set u.userPassword = ?1 where u.id = ?2")
	int updatePassword(String password, int id);
	
	@Transactional
	@Modifying
	@Query("update User u set u.userEmail = ?1 where u.id = ?2")
	int updateEmail(String email, int id);
	
//	@Modifying
//	@Query("from User u where u.userEmail = ?1")
	
	User getByUserEmail(String email);
	

	
}
