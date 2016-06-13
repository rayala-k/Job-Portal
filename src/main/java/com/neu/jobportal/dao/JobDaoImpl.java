package com.neu.jobportal.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.neu.jobportal.pojo.AppliedJobs;
import com.neu.jobportal.pojo.Job;
import com.neu.jobportal.pojo.JobAlerts;
import com.neu.jobportal.pojo.JobSeeker;
import com.neu.jobportal.pojo.Keyword;
import com.neu.jobportal.pojo.Skill;
import com.neu.spring.exception.AdException;

@Repository
public class JobDaoImpl extends DAO implements JobDao {

	@Override
	public Job saveJob(Job job) {
		try {
			begin();
			System.out.println("inside DAO");

			getSession().save(job);

			commit();
			return job;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			try {
				throw new AdException("Exception while creating job: " + e.getMessage());
			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return job;
	}

	public List<Job> listAllActiveJobs() {
		try {
			begin();
			Query q = getSession().createQuery("from Job where active = :isActive");
			q.setLong("isActive", 1);

			List<Job> jobs = q.list();
			commit();

			return jobs;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();

			try {
				throw new AdException("Exception while fetching jobs: " + e.getMessage());
			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public Job getJob(int jobID) {
		begin();
		Query q = getSession().createQuery("from Job where jobID = :jobID");
		q.setLong("jobID", jobID);

		Job job = (Job) q.uniqueResult();
		commit();

		return job;
	}

	@Override
	public Job applyJob(int jobID, long personID) {
		begin();
		Query q = getSession().createQuery("from Job where jobID = :jobID");
		q.setLong("jobID", jobID);

		Job job = (Job) q.uniqueResult();

		Query q1 = getSession().createQuery("from JobSeeker where personID = :id");
		q1.setLong("id", personID);

		JobSeeker user = (JobSeeker) q1.uniqueResult();

		AppliedJobs appJob = new AppliedJobs();
		appJob.setJob(job);
		appJob.setJobSeeker(user);
		appJob.setAppliedDate(LocalDateTime.now().toLocalDate());
		appJob.setStatus("New");
		user.getAppliedJobs().add(appJob);

		getSession().update(user);

		commit();

		return job;
	}

	@Override
	public JobAlerts getJobAlerts(int jobSeekerID) {

		begin();
		Query q1 = getSession().createQuery("from JobSeeker where personID = :id");
		q1.setLong("id", jobSeekerID);

		JobSeeker user = (JobSeeker) q1.uniqueResult();
		commit();

		JobAlerts jobAlerts = user.getJobAlerts();

		return jobAlerts;

	}

	@Override
	public Keyword addKeyword(String keyword) {
		try {
			begin();
			System.out.println("inside DAO");
			Keyword keyWord = new Keyword(keyword);

			getSession().save(keyWord);

			commit();
			return keyWord;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			try {
				throw new AdException("Exception while creating skill: " + e.getMessage());
			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public Keyword getKeyWordByName(String keyword) {
		try {
			begin();
			Query q = getSession().createQuery("from Keyword where lower(keyWordName) like :name");
			q.setString("name", keyword.toLowerCase());
			Keyword keyWord = (Keyword) q.uniqueResult();
			commit();
			return keyWord;
		} catch (HibernateException e) {
			rollback();
			try {
				throw new AdException("Could not get keyword " + keyword, e);

			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public JobAlerts createJobAlert(long personID, List<Keyword> keywords, String alertName, String location) {
		try {

			System.out.println("inside DAO");

			begin();

			Query q = getSession().createQuery("from JobSeeker where personID = :personID");
			q.setLong("personID", personID);

			JobSeeker jobSeeker = (JobSeeker) q.uniqueResult();

			JobAlerts jobalert = new JobAlerts();
			jobalert.setApplicant(jobSeeker);
			jobalert.setKeywords(keywords);
			jobalert.setAlertName(alertName);
			jobalert.setLocation(location);

			getSession().save(jobalert);

			jobSeeker.setJobAlerts(jobalert);

			getSession().update(jobSeeker);

			commit();
			return jobalert;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			try {
				throw new AdException("Exception while creating user: " + e.getMessage());
			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean updateJobStatus(String id, String jobStatus, String jobSeekerID) {
		begin();
		Query q = getSession().createQuery("from Job where jobID = :jobID");
		q.setString("jobID", id);

		Job job = (Job) q.uniqueResult();

		Query q1 = getSession().createQuery("from JobSeeker where personID = :id");
		q1.setString("id", jobSeekerID);

		JobSeeker user = (JobSeeker) q1.uniqueResult();

		for (AppliedJobs a : user.getAppliedJobs()) {
			Job j = a.getJob();
			if (j.getJobID() == Long.parseLong(id)) {
				a.setStatus(jobStatus);
				// getSession().update(user);
				getSession().update(a);

				commit();
				return true;
			}
		}
		commit();
		return false;
	}

	@Override
	public Set<AppliedJobs> getAppliedJobs(long personID) {
		begin();
		Query q1 = getSession().createQuery("from JobSeeker where personID = :id");
		q1.setLong("id", personID);

		JobSeeker user = (JobSeeker) q1.uniqueResult();
		Set<AppliedJobs> jobs = user.getAppliedJobs();
		commit();
		return jobs;
	}

	@Override
	public Job updateJob(Job job,List<Skill> skillSet) {
		try {
			begin();
			System.out.println("inside DAO");
			
			
			Query q = getSession().createQuery("from Job where jobID = :jobID");
			q.setLong("jobID", job.getJobID());

			Job editJob = (Job) q.uniqueResult();
			
			
			editJob.setCompanyName(job.getCompanyName());
			editJob.getJobSkills().clear();
			editJob.setJobSkills(skillSet);
			editJob.setEducationRequirements(job.getEducationRequirements());
			editJob.setJobDescription(job.getJobDescription());
			editJob.setJobRequirements(job.getJobRequirements());
			editJob.setJobTitle(job.getJobTitle());
			editJob.setLocation(job.getLocation());
			editJob.setJobType(job.getJobType());
			
			
			getSession().update(editJob);

			commit();
			return job;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			try {
				throw new AdException("Exception while creating job: " + e.getMessage());
				
			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return job;
	}

	@Override
	public Job closeJob(int jobID) {
		try {
			begin();
			System.out.println("inside DAO");			
			
			Query q = getSession().createQuery("from Job where jobID = :jobID");
			q.setLong("jobID", jobID);

			Job job = (Job) q.uniqueResult();
			job.setActive(false);
			
			getSession().update(job);

			commit();
			return job;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			try {
				throw new AdException("Exception while creating job: " + e.getMessage());
				
			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	

}
