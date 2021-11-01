package com.revature.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Information;
import com.revature.models.User;
import com.revature.repo.InfoDao;
import com.revature.repo.UserDao;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Service("InfoService")
public class InfoServicesImpl implements InfoServices {


		@Autowired
		private InfoDao infoDao;
		
		private static final Logger loggy = Logger.getLogger(InfoServices.class);

		@Override
		public Information saveUserInfo(Information info) {
			ObjectMapper objectMapper = new ObjectMapper();
		    objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);	
			boolean success = false;
					info.setId(-1);
				loggy.info("saving user information");
				if(infoDao.save(info)!=null) {
						success = true;
					}
				if(success) {
					
					loggy.info("user information successfully saved");
					return info;
				} else {
					loggy.warn("user information unsuccessfully saved");
					return null;
				}
		}
		

		@Override
		public Information updateFirstName(Information info) {
			ObjectMapper objectMapper = new ObjectMapper();
		    objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			boolean success = false;
			loggy.info("updating user information");
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
			ObjectMapper objectMapper = new ObjectMapper();
		    objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			boolean success = false;
			loggy.info("updating user information");
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
			ObjectMapper objectMapper = new ObjectMapper();
		    objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			boolean success = false;
			loggy.info("updating user information");
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
			ObjectMapper objectMapper = new ObjectMapper();
		    objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			boolean success = false;
			loggy.info("updating user information");
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
			ObjectMapper objectMapper = new ObjectMapper();
		    objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			boolean success = false;
			loggy.info("updating user information");
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
			ObjectMapper objectMapper = new ObjectMapper();
		    objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			boolean success = false;
			loggy.info("updating user information");
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
			ObjectMapper objectMapper = new ObjectMapper();
		    objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		    loggy.info("getting user information");
			Information info = infoDao.findByUsers(user); 
			if (info != null) {
				return info;
			} else {
				 loggy.warn("unsuccessfully getting user information");
				return null;
			}
		}

}