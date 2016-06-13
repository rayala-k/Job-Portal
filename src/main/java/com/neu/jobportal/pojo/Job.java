package com.neu.jobportal.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue
	@Column(name = "jobID", unique = true, nullable = false)
	private long jobID;

	@Column(name = "jobTitle", nullable = false)
	private String jobTitle;

	@Column(name = "jobDescription", nullable = false, length = 5000)
	private String jobDescription;

	@Column(name = "jobRequirements", nullable = false, length = 5000)
	private String jobRequirements;

	@Column(name = "location", nullable = false)
	private String location;

	@Column(name = "jobType", nullable = false)
	private String jobType;

	@Column(name = "companyName", nullable = false)
	private String companyName;

	@Column(name = "educationRequirements")
	private String educationRequirements;

	@Column(name = "postedDate", nullable = false)
	private LocalDate postedDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "primaryKey.job", cascade = CascadeType.ALL)
	private Set<AppliedJobs> appliedJobs = new HashSet<AppliedJobs>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Job_Skills", joinColumns = @JoinColumn(name = "jobID"), inverseJoinColumns = @JoinColumn(name = "skillID"))
	private List<Skill> jobSkills = new ArrayList<Skill>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Posted_By", nullable = false)
	private Employer postedBy;

	@Column(name = "isActive")
	private boolean active;

	public Job() {

	}

	public Set<AppliedJobs> getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(Set<AppliedJobs> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}

	public Employer getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(Employer postedBy) {
		this.postedBy = postedBy;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
	}

	public long getJobID() {
		return jobID;
	}

	public void setJobID(long jobID) {
		this.jobID = jobID;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public String getEducationRequirements() {
		return educationRequirements;
	}

	public void setEducationRequirements(String educationRequirements) {
		this.educationRequirements = educationRequirements;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	public List<Skill> getJobSkills() {
		return jobSkills;
	}

	public void setJobSkills(List<Skill> jobSkills) {
		this.jobSkills = jobSkills;
	}

	public String getJobRequirements() {
		return jobRequirements;
	}

	public void setJobRequirements(String jobRequirements) {
		this.jobRequirements = jobRequirements;
	}

}
