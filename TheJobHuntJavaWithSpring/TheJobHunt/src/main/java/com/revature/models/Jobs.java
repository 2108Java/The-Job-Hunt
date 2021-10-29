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

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
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
	
	@Column(name = "MatchedObjectId")
	private int MatchedObjectId;
	
	@Column(name = "PositionTitle")
	private String PositionTitle;
	
	@Column(name = "PostionLocationDisplay")
	private String PostionLocationDisplay;
	
	@Column(name = "AgencyMarketingStatement")
	private String AgencyMarketingStatement;
	
	@Column(name = "Evaluations")
	private String Evaluations;
	
	@Column(name = "JobSummary")
	private String JobSummary;
	
	@Column(name = "OtherInformation")
	private String OtherInformation;
	
	@Column(name = "Requirements")
	private String Requirements;
	
	
	
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
		return MatchedObjectId;
	}

	public void setJobId(int jobId) {
		this.MatchedObjectId = jobId;
	}

	public boolean isAppliedFor() {
		return appliedFor;
	}

	public void setAppliedFor(boolean appliedFor) {
		this.appliedFor = appliedFor;
	}

	@Override
	public String toString() {
		return "Jobs [Id=" + Id + ", users=" + users + ", jobId=" + MatchedObjectId + ", appliedFor=" + appliedFor + "]";
	}
	
	
}
