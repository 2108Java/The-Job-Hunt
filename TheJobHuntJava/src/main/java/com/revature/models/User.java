package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "users")
//@NamedQueries({
//	@NamedQuery( name = "viewAllPlanets", query = "FROM Planet planet"),
//	@NamedQuery( name = "viewPlanetsWithName", query = "FROM Planet planet where planet.name = :name")
//})


public class User {
	/*
	 * create table users(
	user_id serial primary key, --primary key _
	user_email varchar(20) unique,
	user_password varchar(20) not null
	);
	
*/
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int userId;
	
	@Column(name = "user_email", nullable = false, unique = true)
	String userEmail;
	
	@Column(name = "user_password", nullable = false, unique = false)
	String userPassword;
	
	
}
