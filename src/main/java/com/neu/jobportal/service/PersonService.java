package com.neu.jobportal.service;

import java.util.List;

import com.neu.jobportal.pojo.Employer;
import com.neu.jobportal.pojo.Job;
import com.neu.jobportal.pojo.JobSeeker;
import com.neu.jobportal.pojo.Person;
import com.neu.spring.exception.AdException;

public interface PersonService {

	public JobSeeker addJobSeeker(Person person) throws AdException;	
	
	public Employer addEmployer(Person person) throws AdException;
	
	public Person validatePerson(String username,String Password);
	
	public JobSeeker getJobSeeker(long id);
	
	public Employer getEmployer(long id);
	
	public List<JobSeeker> getAllSubscribedJobSeekers();

	public List<Job> getMessageAlerts(long jobAlertID);
}
