package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users_information")
public class Information {

	/*
	 * create table users_information(	
	user_id_fk int references users(user_id),
	first_name varchar(20) not null,
	last_name varchar(20) not null,
	street varchar(20),
	city varchar(20),
	state varchar(20),
	zip int not null
	);
	 */
	
	int userIdFk;
	
	@Column(name = "first_name", nullable = false, unique = false)
	String firstName;
	
	@Column(name = "last_name", nullable = false, unique = false)
	String lastName;
	
	@Column(name = "street", nullable = false, unique = false)
	String street;
	
	@Column(name = "city", nullable = false, unique = false)
	String city;
	
	@Column(name = "state", nullable = false, unique = false)
	String state;
	
	@Column(name = "zip", nullable = false, unique = false)
	int zip;
}
