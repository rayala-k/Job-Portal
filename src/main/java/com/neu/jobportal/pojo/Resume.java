package com.neu.jobportal.pojo;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Resume")
public class Resume {

	@Id
	@GeneratedValue
	@Column(name = "resumeID", unique = true, nullable = false)
	private long resumeID;

	@OneToOne(mappedBy = "resume", cascade = CascadeType.ALL)
	private JobSeeker applicant;
	
	@Column(name="jobTitle", nullable=false)
	private String jobTitle;

	@Column(name = "highestEducationLevel")
	private String highestEducationLevel;

	@Column(name = "totalExperience")
	private double totalExperience;

	@Column(name = "filename")
	private String filename;

	@Column(name = "content")
	@Lob
	private Blob content;

	@Column(name = "content_type")
	private String contentType;


	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Resume_Skills", joinColumns = @JoinColumn(name = "resumeID"), inverseJoinColumns = @JoinColumn(name = "skillID"))
	private List<Skill> mySkills = new ArrayList<Skill>();

	public Resume() {

	}

	public long getResumeID() {
		return resumeID;
	}

	public void setResumeID(long resumeID) {
		this.resumeID = resumeID;
	}

	public JobSeeker getApplicant() {
		return applicant;
	}

	public void setApplicant(JobSeeker applicant) {
		this.applicant = applicant;
	}

	public List<Skill> getMySkills() {
		return mySkills;
	}

	public void setMySkills(List<Skill> mySkills) {
		this.mySkills = mySkills;
	}

	public String getHighestEducationLevel() {
		return highestEducationLevel;
	}

	public void setHighestEducationLevel(String highestEducationLevel) {
		this.highestEducationLevel = highestEducationLevel;
	}

	public double getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(double totalExperience) {
		this.totalExperience = totalExperience;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}	
	
	

}
