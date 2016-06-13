package com.neu.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.jobportal.dao.PersonDao;
import com.neu.jobportal.pojo.Employer;
import com.neu.jobportal.pojo.Job;
import com.neu.jobportal.pojo.JobAlerts;
import com.neu.jobportal.pojo.JobSeeker;
import com.neu.jobportal.pojo.Person;
import com.neu.spring.exception.AdException;

@Service	
public class PersonServiceImpl implements PersonService {
	
	@Autowired 
	PersonDao personDao;

	@Override
	public JobSeeker addJobSeeker(Person person) throws AdException {
		return personDao.addJobSeeker(person);
	}

	@Override
	public Person validatePerson(String username, String Password) {
		return personDao.validatePerson(username, Password);
	}

	@Override
	public Employer addEmployer(Person person) throws AdException {
		return personDao.addEmployer(person);
	}

	@Override
	public JobSeeker getJobSeeker(long id) {
		return personDao.getJobSeeker(id);
	}

	@Override
	public Employer getEmployer(long id) {
		return personDao.getEmployer(id);
	}

	@Override
	public List<JobSeeker> getAllSubscribedJobSeekers() {
		// TODO Auto-generated method stub
		return personDao.getAllSubscribedJobSeekers();
	}

	@Override
	public List<Job> getMessageAlerts(long jobAlertID) {
		// TODO Auto-generated method stub
		return personDao.getMessageAlerts(jobAlertID);
	}

}
