package com.neu.jobportal.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employer")
@PrimaryKeyJoinColumn(name = "personID")
public class Employer extends Person {

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "postedBy")
	private List<Job> postedJobs = new ArrayList<Job>();

	public Employer() {

	}

	public Employer(Person person) {
		super(person);
	}

	public List<Job> getPostedJobs() {
		return postedJobs;
	}

	public void setPostedJobs(List<Job> postedJobs) {
		this.postedJobs = postedJobs;
	}

}
