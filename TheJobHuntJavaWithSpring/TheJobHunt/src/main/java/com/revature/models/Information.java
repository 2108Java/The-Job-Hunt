package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
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

	
	
	
	public Information(int id, User users, String firstName, String lastName, String street, String city, String state,
			int zip) {
		super();
		Id = id;
		this.users = users;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	
	
	public Information() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Information [Id=" + Id + ", users=" + users + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}

}
