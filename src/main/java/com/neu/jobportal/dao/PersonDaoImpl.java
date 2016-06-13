package com.neu.jobportal.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.neu.jobportal.pojo.Employer;
import com.neu.jobportal.pojo.Job;
import com.neu.jobportal.pojo.JobAlerts;
import com.neu.jobportal.pojo.JobSeeker;
import com.neu.jobportal.pojo.Keyword;
import com.neu.jobportal.pojo.Person;
import com.neu.spring.exception.AdException;

@Repository
public class PersonDaoImpl extends DAO implements PersonDao {

	@Override
	public JobSeeker addJobSeeker(Person person) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			JobSeeker jobSeeker = new JobSeeker(person);

			getSession().save(jobSeeker);

			commit();
			return jobSeeker;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}

	}

	@Override
	public Person validatePerson(String username, String password) {
		try {
			begin();
			Query q = getSession().createQuery("from Person where userName = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			Person user = (Person) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			try {
				throw new AdException("Could not get user " + username, e);

			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Employer addEmployer(Person person) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			Employer employer = new Employer(person);

			getSession().save(employer);

			commit();
			return employer;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}

	@Override
	public JobSeeker getJobSeeker(long id) {
		try {
			begin();
			Query q = getSession().createQuery("from JobSeeker where personID = :id");
			q.setLong("id", id);
						
			JobSeeker user = (JobSeeker) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			try {
				throw new AdException("Could not get user " + id, e);

			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Employer getEmployer(long id) {
		try {
			begin();
			Query q = getSession().createQuery("from Employer where personID = :id");
			q.setLong("id", id);			
			Employer user = (Employer) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			try {
				throw new AdException("Could not get user " + id, e);

			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	public List<JobSeeker> getAllSubscribedJobSeekers(){
		try {
			begin();
			Query q = getSession().createQuery("from JobSeeker where jobAlerts is not null");
		
						
			List<JobSeeker> jobSeekerList = q.list();
			commit();
			return jobSeekerList;
		} catch (HibernateException e) {
			rollback();
			try {
				throw new AdException("Error in fetching job seekers");

			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
		
	}
	
	public List<Job> getMessageAlerts(long alertID){
		
		try {
			begin();
			Query q1 = getSession().createQuery("from JobAlerts where jobAlertID = :alertID");
			q1.setLong("alertID", alertID);
						
			JobAlerts alerts = (JobAlerts) q1.uniqueResult();
			
			StringBuilder query = new StringBuilder();
		
			List<String> skills = new ArrayList<String>();
			
			for(Keyword s:alerts.getKeywords()){
				skills.add(s.getKeyWordName());
			}

			if (skills.size() > 0) {
				query.append(" and lower(skill.skillName) in(:skills)");

			} else if (alerts.getLocation() != null) {
				query.append(" and lower(j.location) like:location");

			}
			

			Query q = getSession().createQuery(
					"Select distinct j from Job as j inner join j.jobSkills as skill where  j.active = :isActive" + query
							+ " order by postedDate desc");

			if (skills.size() > 0) {
				q.setParameterList("skills", skills);

			} else if (alerts.getLocation() != null) {
				q.setString("location", "%"+alerts.getLocation().toLowerCase()+"%");

			}
			q.setBoolean("isActive", true);
		

			List<Job> jobs = q.list();
			commit();
			return jobs;
			
			
			
		} catch (HibernateException e) {
			rollback();
			try {
				throw new AdException("Could not get user ", e);

			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}


}
