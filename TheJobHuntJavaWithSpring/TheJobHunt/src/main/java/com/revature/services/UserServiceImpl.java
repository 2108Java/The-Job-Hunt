package com.revature.services;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repo.UserDao;

@Service("UserService")
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserDao userDao;

	@Override
	public User userExists(User user) {

		User userExists = userDao.getByUserEmail(user.getUserEmail());
		if (userExists != null)
			return userExists;
		else {
			return null;
		}
	}

	@Override
	public User loginUser(User user) {

		boolean success = false;
		User testUser = userExists(user);

		if (testUser != null) {
			testUser.setUserPassword(decryptPassword(testUser.getUserPassword()));
			if (user.getUserPassword().equals(testUser.getUserPassword())) {
				success = true;
			}
		}
		if (success) {
			return testUser;
		} else {
			return null;
		}

	}

	@Override
	public User insertUser(User user) {
		String randomPassword = generateRandomPassword();
		System.out.println(randomPassword);
		sendEmail(user.getUserEmail(), randomPassword);
		String encryptedPassword = encryptPassword(randomPassword);
		user.setUserPassword(encryptedPassword);
//		createUser(user);
		user = userDao.save(user);

		return user;
	}

	private static String generateRandomPassword() {
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 15; i++) {
			int randomIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randomIndex));
		}

		return sb.toString();
	}

	private String encryptPassword(String password) {
		String encodedString = Base64.getEncoder().encodeToString(password.getBytes());
		return encodedString;

	}

	private String decryptPassword(String password) {
		byte[] decodedBytes = Base64.getDecoder().decode(password);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}

	@Override
	public boolean updateUserEmail(User user) {

		userDao.updateEmail(user.getUserEmail(), user.getId());

		return false;
	}

	@Override
	public boolean updateUserPassword(User user) {

		userDao.updatePassword(user.getUserPassword(), user.getId());

		return false;
	}

	private void sendEmail(String email, String password) {

		String to = email;
		String from = "thejobhuntnoreply@gmail.com";
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "P455w0rd123!");
			}
		});

		session.setDebug(true);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Welcome to The Job Hunt!");
			message.setContent("<h1>Thank's for Registering !</h1>" + "<h3>Your temporary password is " + password
					+ "</h3><h3>Don't forget to update it next time you login!</h3>", "text/html");
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}
}
