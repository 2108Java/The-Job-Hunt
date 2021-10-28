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
		public Information saveUserInfo(Information info) {
				boolean success = false;
					info.setId(-1);
					if(infoDao.save(info).getId()>0) {
						success = true;
					}
				if(success) {
					return info;
				} else {
					return null;
				}
		}
		

		@Override
		public Information updateFirstName(Information info) {
			boolean success = false;
				if(infoDao.updateFirstName(info.getFirstName(), info.getUsers().getId())==1) {
					success = true;
				}
				if(success) {
					return info;
				} else {
					return null;
				}
		}
		

		@Override
		public Information updateLastName(Information info) {
			boolean success = false;
				if(infoDao.updateLastName(info.getLastName(), info.getUsers().getId())==1) {
					success = true;
				}
				if(success) {
					return info;
				} else {
					return null;
				}
		}

		@Override
		public Information updateStreet(Information info) {
			boolean success = false;
				if(infoDao.updateStreet(info.getStreet(), info.getUsers().getId())==1) {
					success = true;
				}
				if(success) {
					return info;
				} else {
					return null;
				}
		}

		@Override
		public Information updateCity(Information info) {
			boolean success = false;
				if(infoDao.updateCity(info.getCity(), info.getUsers().getId())==1) {
					success = true;
				}
				if(success) {
					return info;
				} else {
					return null;
				}		
		}

		@Override
		public Information updateState(Information info) {
			boolean success = false;
				if(infoDao.updateState(info.getState(), info.getUsers().getId())==1) {
					success = true;
				}
				if(success) {
					return info;
				} else {
					return null;
				}
		}

		@Override
		public Information updateZipCode(Information info) {
			boolean success = false;
				if(infoDao.updateZipCode(info.getZip(), info.getUsers().getId())==1) {
					success = true;
				}
				if(success) {
					return info;
				} else {
					return null;
				}
		}


		@Override
		public Information getInfoByUser(User user) {
			Information info = infoDao.getByUsers(user.getId()); 
			if (info != null) {
				return info;
			} else {
				return null;
			}
		}

}