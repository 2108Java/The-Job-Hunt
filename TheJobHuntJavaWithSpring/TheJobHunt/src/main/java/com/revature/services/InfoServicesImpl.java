package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Information;
import com.revature.models.User;
import com.revature.repo.InfoDao;
import com.revature.repo.UserDao;


@Service("InfoService")
public class InfoServicesImpl implements InfoServices {


		@Autowired
		private InfoDao infoDao;

		@Override
		public boolean saveUserInfo(Information info) {
				boolean success = false;
					if(infoDao.save(info)) {
						success = true;
					}
				return success;
		}
		

		@Override
		public boolean updateFirstName(Information info) {
			boolean success = false;
				if(infoDao.updateFirstName(info.firstName, info.users.id)) {
					success = true;
				}
			return success;
		}

		@Override
		public boolean updateLastName(Information info) {
			boolean success = false;
				if(infoDao.updateLastName(info.lastName, info.users.id)) {
					success = true;
				}
			return success;
		}

		@Override
		public boolean updateStreet(Information info) {
			boolean success = false;
				if(infoDao.updateStreet(info.street, info.users.id)) {
					success = true;
				}
			return success;
		}

		@Override
		public boolean updateCity(Information info) {
			boolean success = false;
				if(infoDao.updateCity(info.city, info.users.id)) {
					success = true;
				}
			return success;
		}

		@Override
		public boolean updateState(Information info) {
			boolean success = false;
				if(infoDao.updateState(info.state, info.users.id)) {
					success = true;
				}
			return success;
		}

		@Override
		public boolean updateZipCode(Information info) {
			boolean success = false;
				if(infoDao.updateZipCode(info.zip, info.users.id)) {
					success = true;
				}
			return success;
		}

		


}