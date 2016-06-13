package com.neu.jobportal.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "JobAlerts")
public class JobAlerts {

	@Id
	@GeneratedValue
	@Column(name = "jobAlertID", unique = true, nullable = false)
	private long jobAlertID;
	
	@Column(name="Alert_Name",nullable = false)
	private String alertName;

	@OneToOne(mappedBy = "jobAlerts", cascade = CascadeType.ALL)
	private JobSeeker applicant;
	
	@Column(name="Location")
	private String location;

	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "JobAlert_Keywords", joinColumns = @JoinColumn(name = "jobAlertID"), inverseJoinColumns = @JoinColumn(name = "keywordID"))
	private List<Keyword> keywords = new ArrayList<Keyword>();
	
	public JobAlerts(){
		
	}

	public long getJobAlertID() {
		return jobAlertID;
	}

	public void setJobAlertID(long jobAlertID) {
		this.jobAlertID = jobAlertID;
	}

	public JobSeeker getApplicant() {
		return applicant;
	}

	public void setApplicant(JobSeeker applicant) {
		this.applicant = applicant;
	}

	public List<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}

	public String getAlertName() {
		return alertName;
	}

	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}	
	
}
