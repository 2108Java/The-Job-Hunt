package com.revature.services;

import com.revature.models.Information;

public interface InfoServices {

	
	public boolean saveUserInfo(Information info);
	public boolean updateFirstName(Information info);
	public boolean updateLastName(Information info);
	public boolean updateStreet(Information info);
	public boolean updateCity(Information info);
	public boolean updateState(Information info);
	public boolean updateZipCode(Information info);
	
}
