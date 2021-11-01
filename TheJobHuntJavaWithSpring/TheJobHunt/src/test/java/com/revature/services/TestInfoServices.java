package com.revature.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.TheJobHuntApplicationTests;
import com.revature.models.Information;
import com.revature.models.User;
import com.revature.repo.InfoDao;

@RunWith(MockitoJUnitRunner.class)
public class TestInfoServices extends TheJobHuntApplicationTests {

	@MockBean
	private static InfoDao infoDao;
	
	
	private static User realUser = new User(1,"realEmail@hotmail.com","real");
	private static Information info= new Information(1, realUser, "", "", "", "", "", 66762);
	private static Information info2= new Information();
	private static Information info3= new Information();
	
	
	@Autowired
	@InjectMocks
	private  InfoServices infoService = new InfoServicesImpl();
	
	@BeforeClass
	public static void fakeMyDao() {
		MockitoAnnotations.openMocks(infoDao);
	
	}
	
	
	@Test
	public void testSaveUserInfo() {

		when(infoDao.save(info)).thenReturn(info);
		when(infoDao.save(info2)).thenReturn(null);
		when(infoDao.save(info3)).thenReturn(info3);
		
		assertTrue(infoService.saveUserInfo(info) == info);
		assertFalse(infoService.saveUserInfo(info2) == info2);
		assertTrue(infoService.saveUserInfo(info3) == info3);
		
	}
	
	@Test
	public void testUpdateFirstname() {
		
		when(infoDao.updateFirstName(info.getFirstName(), 1)).thenReturn(1);
		
		assertNotNull(infoService.updateFirstName(info));
	}
	@Test
	public void testUpdateLastName() {
		when(infoDao.updateLastName(info.getLastName(), 1)).thenReturn(1);
		
		assertNotNull(infoService.updateLastName(info));
	}
	@Test
	public void testUpdateStreet() {
		when(infoDao.updateStreet(info.getStreet(), 1)).thenReturn(1);
		
		assertNotNull(infoService.updateStreet(info));
	}
	@Test
	public void testUpdateCity() {
		when(infoDao.updateCity(info.getCity(), 1)).thenReturn(1);
		
		assertNotNull(infoService.updateCity(info));
	}
	@Test
	public void testUpdateState() {
		when(infoDao.updateState(info.getState(), 1)).thenReturn(1);
		
		assertNotNull(infoService.updateState(info));
	}
	@Test
	public void testUpdateZipCode() {
		when(infoDao.updateZipCode(info.getZip(), 1)).thenReturn(1);
		
		assertNotNull(infoService.updateZipCode(info));
	}
	@Test
	public void testGetInfoByUser() {
		when(infoDao.findByUsers(realUser)).thenReturn(info);
		
		assertNotNull(infoService.getInfoByUser(realUser));
		
	}
}
