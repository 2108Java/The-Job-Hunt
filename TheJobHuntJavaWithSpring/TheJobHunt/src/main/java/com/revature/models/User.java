package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@Entity
@Table(name = "users")
public class User {
	/*
	 * create table users(
	user_id serial primary key, --primary key _
	user_email varchar(20) unique,
	user_password varchar(20) not null
	);
	
*/

	public User(int id, String userEmail, String userPassword) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	


	@Column(name = "user_email", nullable = false, unique = true)
	private String userEmail;
	
	@Column(name = "user_pwd", nullable = false, unique = false)
	private String userPassword;
//	
//	@OneToMany(mappedBy ="users")
//	private List<Jobs> jobs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userEmail=" + userEmail + ", userPassword=" + userPassword 
				+ "]";
	}
	
	//@OneToOne
	//List<Information> info;
	
	
	
	
}

