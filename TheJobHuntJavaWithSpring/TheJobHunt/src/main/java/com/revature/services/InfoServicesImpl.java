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
					if(infoDao.save(info).getId()>0) {
						success = true;
					}
				return success;
		}
		

		@Override
		public boolean updateFirstName(Information info) {
			boolean success = false;
				if(infoDao.updateFirstName(info.getFirstName(), info.getUsers().getId())==1) {
					success = true;
				}
			return success;
		}

		@Override
		public boolean updateLastName(Information info) {
			boolean success = false;
				if(infoDao.updateLastName(info.getLastName(), info.getUsers().getId())==1) {
					success = true;
				}
			return success;
		}

		@Override
		public boolean updateStreet(Information info) {
			boolean success = false;
				if(infoDao.updateStreet(info.getStreet(), info.getUsers().getId())==1) {
					success = true;
				}
			return success;
		}

		@Override
		public boolean updateCity(Information info) {
			boolean success = false;
				if(infoDao.updateCity(info.getCity(), info.getUsers().getId())==1) {
					success = true;
				}
			return success;
		}

		@Override
		public boolean updateState(Information info) {
			boolean success = false;
				if(infoDao.updateState(info.getState(), info.getUsers().getId())==1) {
					success = true;
				}
			return success;
		}

		@Override
		public boolean updateZipCode(Information info) {
			boolean success = false;
				if(infoDao.updateZipCode(info.getZip(), info.getUsers().getId())==1) {
					success = true;
				}
			return success;
		}

		


}