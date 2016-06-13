package com.neu.jobportal.pojo;

import java.time.LocalDate;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Applied_Jobs")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.jobseeker",
        joinColumns = @JoinColumn(name = "Job_Seeker_ID")),
    @AssociationOverride(name = "primaryKey.job",
        joinColumns = @JoinColumn(name = "Job_ID")) })
public class AppliedJobs {

	@EmbeddedId
	private ApplicantJobID primaryKey = new ApplicantJobID();
	
	@Column(name="Applied_Date")
	private LocalDate appliedDate;
	
	@Column(name="Status")
	private String status;
	
	public AppliedJobs(){
		
	}
	
	public ApplicantJobID getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(ApplicantJobID primaryKey) {
		this.primaryKey = primaryKey;
	}
	public LocalDate getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Transient
	public Job getJob(){
		return getPrimaryKey().getJob();
	}
	
	public void setJob(Job job){
		getPrimaryKey().setJob(job);
	}
	
	@Transient
	public JobSeeker getJobSeeker(){
		return getPrimaryKey().getJobseeker();
	}
	
	public void setJobSeeker(JobSeeker jobSeeker){
		getPrimaryKey().setJobseeker(jobSeeker);
	}
		
	
}
