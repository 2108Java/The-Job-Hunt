package com.revature.services;

import com.revature.models.Information;
import com.revature.models.User;

public interface InfoServices {

	
	public Information saveUserInfo(Information info);
	public Information updateFirstName(Information info);
	public Information updateLastName(Information info);
	public Information updateStreet(Information info);
	public Information updateCity(Information info);
	public Information updateState(Information info);
	public Information updateZipCode(Information info);
	public Information getInfoByUser(User user);
	
}