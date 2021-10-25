package com.revature.models;
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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users_info")
public class Information {

	@Id
	@Column(name = "user_info_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User users;
	//int userIdFk;
	
	@Column(name = "first_name", nullable = false, unique = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, unique = false)
	private String lastName;
	
	@Column(name = "street", nullable = false, unique = false)
	private String street;
	
	@Column(name = "city", nullable = false, unique = false)
	private String city;
	
	@Column(name = "state", nullable = false, unique = false)
	private String state;
	
	@Column(name = "zip", nullable = false, unique = false)
	private int zip;
}