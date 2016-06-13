package com.neu.jobportal.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.jobportal.dao.JobDao;
import com.neu.jobportal.pojo.AppliedJobs;
import com.neu.jobportal.pojo.Job;
import com.neu.jobportal.pojo.JobAlerts;
import com.neu.jobportal.pojo.Keyword;
import com.neu.jobportal.pojo.Skill;
import com.neu.spring.exception.AdException;

@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	JobDao jobDao;

	@Override
	public Job saveJob(Job job) {
		return jobDao.saveJob(job);
	}
	
	public List<Job> listAllActiveJobs(){
		return jobDao.listAllActiveJobs();
	}

	@Override
	public Job getJob(int jobID) {
		return jobDao.getJob(jobID);
	}

	@Override
	public Job applyJob(int jobID, long personID) {
		return jobDao.applyJob(jobID,personID);
	}

	@Override
	public JobAlerts getJobAlerts(int jobSeekerID) {
		return jobDao.getJobAlerts(jobSeekerID);
	}

	@Override
	public Keyword addKeyword(String keyword) {
		return jobDao.addKeyword(keyword);
	}

	@Override
	public Keyword getKeyWordByName(String keyword) {
		return jobDao.getKeyWordByName(keyword);
	}

	@Override
	public JobAlerts createJobAlert(long personID, List<Keyword> keywords, String alertName ,String location) throws AdException {
		return jobDao.createJobAlert(personID, keywords, alertName, location);
	}

	@Override
	public boolean updateJobStatus(String id, String jobStatus, String jobSeekerID) {
		// TODO Auto-generated method stub
		return jobDao.updateJobStatus(id,jobStatus,jobSeekerID);
	}

	@Override
	public Set<AppliedJobs> getAppliedJobs(long personID) {
		// TODO Auto-generated method stub
		return jobDao.getAppliedJobs(personID);
	}

	@Override
	public Job updateJob(Job job,List<Skill> skillSet) {
		return jobDao.updateJob(job,skillSet);
	}

	@Override
	public Job closeJob(int jobID) {
		return jobDao.closeJob(jobID);
	}

}
