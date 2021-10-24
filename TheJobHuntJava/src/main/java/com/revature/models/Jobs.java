package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Column(name = "saved_job_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int savedJobId;
	
	int userIdFk;
	
	@Column(name = "job_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int jobId;
	
	@Column(name = "applied_for")
	boolean appliedFor;
}
