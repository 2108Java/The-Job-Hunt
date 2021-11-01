package com.revature.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.TheJobHuntApplicationTests;
import com.revature.models.Jobs;
import com.revature.models.User;
import com.revature.repo.SavedJobsDao;

@RunWith(MockitoJUnitRunner.class)
public class SavedJobsServicesTest extends TheJobHuntApplicationTests {

	@MockBean
	private static SavedJobsDao jobDao;

	private static List<Jobs> jobList = new ArrayList<>();

	private static User fakeUser = new User(-1, "fake", "fake");
	private static User realUser = new User(1, "realEmail@hotmail.com", "real");
	private static User secondUser = new User(2, "realEmail@gmail.com", "totallylegit");
	private static Jobs realJob = new Jobs(1, realUser, "", "", "", "", "", "", "", "", "", false);
	private static Jobs fakeJob = new Jobs(-1, fakeUser, "", "", "", "", "", "", "", "", "", false);
	private static Jobs secondJob = new Jobs(1, secondUser, "", "", "", "", "", "", "", "", "", false);

	@Autowired
	@InjectMocks
	private SavedJobsServices jobsServices = new SavedJobsServicesImpl();

	@BeforeClass
	public static void fakeMyDao() {
		MockitoAnnotations.openMocks(jobDao);

	}

	@Test
	public void testCreateJob() {
		when(jobDao.save(realJob)).thenReturn(realJob);
		when(jobDao.save(fakeJob)).thenReturn(null);
		when(jobDao.save(secondJob)).thenReturn(secondJob);

		assertTrue(jobsServices.createJob(realJob));
		assertFalse(jobsServices.createJob(fakeJob));
		assertTrue(jobsServices.createJob(secondJob));

	}

	@Test
	public void testSeclectJob() {
		when(jobDao.getById(1)).thenReturn(realJob);
		when(jobDao.getById(0)).thenReturn(null);
		when(jobDao.getById(2)).thenReturn(secondJob);

		assertNotNull(jobsServices.selectJob(1));
		assertNull(jobsServices.selectJob(0));
		assertNotNull(jobsServices.selectJob(2));

	}

	@Test
	public void testSelectAllJobs() {
		jobList.add(realJob);
		jobList.add(realJob);
		jobList.add(realJob);
		when(jobDao.findByUsers(realUser)).thenReturn(jobList);
		when(jobDao.findByUsers(fakeUser)).thenReturn(null);
		when(jobDao.findByUsers(secondUser)).thenReturn(jobList);

		assertNotNull(jobsServices.selectAllJobs(realUser));
		assertNull(jobsServices.selectAllJobs(fakeUser));
		assertNotNull(jobsServices.selectAllJobs(secondUser));
	}
}
