package com.revature.services;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.TheJobHuntApplicationTests;
import com.revature.models.User;
import com.revature.repo.UserDao;

@RunWith(MockitoJUnitRunner.class)
public class TestUserServices extends TheJobHuntApplicationTests{
	
	@MockBean
	private static UserDao userDao;
	
	
	private static User fakeUser = new User(-1,"fake","fake");
	private static User realUser = new User(1,"realEmail@hotmail.com","real");
	private static User secondUser = new User(2,"realEmail@gmail.com","totallylegit");
	
	@Autowired
	@InjectMocks
	private UserServices userServices =new UserServiceImpl();
	
	@BeforeClass
	public static void fakeMyDao() {
		MockitoAnnotations.openMocks(userDao);
	
	}
	
	
	@Test
	public void testUserExists() {

		when(userDao.getByUserEmail("realEmail@gmail.com")).thenReturn(secondUser);
		when(userDao.getByUserEmail("realEmail@hotmail.com")).thenReturn(realUser);
		when(userDao.getByUserEmail("fake")).thenReturn(null);
		assertTrue(userServices.userExists(realUser)!=null);
		assertNull(userServices.userExists(fakeUser));
		assertNotNull(userServices.userExists(secondUser));
	}
	
	@Test
	public void testInsertUser() {
		when(userDao.save(secondUser)).thenReturn(secondUser);
		when(userDao.save(realUser)).thenReturn(realUser);
		when(userDao.save(fakeUser)).thenReturn(null);
		assertNull(userServices.insertUser(fakeUser));
		assertNotNull(userServices.insertUser(realUser));
		assertNotNull(userServices.insertUser(secondUser));
	}
	
	@Test
	public void testUpdateUserPassword() {
		
	}

	@Test
	public void testLoginUser() {
		when(userDao.getByUserEmail("realEmail@gmail.com")).thenReturn(secondUser);
		when(userDao.getByUserEmail("realEmail@hotmail.com")).thenReturn(realUser);
		when(userDao.getByUserEmail("fake")).thenReturn(null);
		assertTrue(userServices.loginUser(realUser)!=null);
	}

	@Test
	public void testUpdateUserEmail() {
		
	}
}
