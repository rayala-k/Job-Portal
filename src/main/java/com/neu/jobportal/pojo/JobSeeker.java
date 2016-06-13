package com.neu.jobportal.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "jobseeker")
@PrimaryKeyJoinColumn(name = "personID")
public class JobSeeker extends Person {

	@OneToOne
	private Resume resume;
	
	@OneToOne
	private JobAlerts jobAlerts;

	@OneToMany(mappedBy = "primaryKey.jobseeker", cascade = CascadeType.ALL)
	private Set<AppliedJobs> appliedJobs = new HashSet<AppliedJobs>();

	public JobSeeker() {

	}

	public JobSeeker(Person person) {
        super(person);
		
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Set<AppliedJobs> getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(Set<AppliedJobs> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}

	public JobAlerts getJobAlerts() {
		return jobAlerts;
	}

	public void setJobAlerts(JobAlerts jobAlerts) {
		this.jobAlerts = jobAlerts;
	}
}
