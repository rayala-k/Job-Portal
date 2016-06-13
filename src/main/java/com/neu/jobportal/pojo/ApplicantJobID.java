package com.neu.jobportal.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ApplicantJobID implements Serializable {
	
	@ManyToOne(cascade = CascadeType.ALL)
	private JobSeeker jobseeker;
	@ManyToOne(cascade = CascadeType.ALL)	
	private Job job;
	public JobSeeker getJobseeker() {
		return jobseeker;
	}
	public void setJobseeker(JobSeeker jobseeker) {
		this.jobseeker = jobseeker;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	
	
}
