package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "saved_jobs")
public class Jobs {

	
	/*
	 * create table saved_jobs(
	saved_job_id serial primary key,
	user_id_fk int references users(user_id), --primary key _
	job_id serial unique,
	applied_for boolean not null
	);
	 */
	
	@Id
	@Column(name = "sjob_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	//@ManyToOne(mappedBy="saved_jobs", cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User users;
	//int userIdFk;
	
	@Column(name = "job_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jobId;
	
	@Column(name = "applied_for")
	private boolean appliedFor;

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

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public boolean isAppliedFor() {
		return appliedFor;
	}

	public void setAppliedFor(boolean appliedFor) {
		this.appliedFor = appliedFor;
	}

	@Override
	public String toString() {
		return "Jobs [Id=" + Id + ", users=" + users + ", jobId=" + jobId + ", appliedFor=" + appliedFor + "]";
	}
	
	
}
