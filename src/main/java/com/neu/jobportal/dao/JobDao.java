package com.neu.jobportal.dao;

import java.util.List;
import java.util.Set;

import com.neu.jobportal.pojo.AppliedJobs;
import com.neu.jobportal.pojo.Job;
import com.neu.jobportal.pojo.JobAlerts;
import com.neu.jobportal.pojo.Keyword;
import com.neu.jobportal.pojo.Skill;

public interface JobDao {
	public Job saveJob(Job job);	
	
	public List<Job> listAllActiveJobs();
	
	public Job getJob(int jobID);
	
	public Job applyJob(int jobID,long personID);

	public JobAlerts getJobAlerts(int jobSeekerID);

	public Keyword addKeyword(String keyword);

	public Keyword getKeyWordByName(String keyword);

	public JobAlerts createJobAlert(long personID, List<Keyword> keywords, String alertName, String location);

	public boolean updateJobStatus(String id, String jobStatus, String jobSeekerID);

	public Set<AppliedJobs> getAppliedJobs(long personID);

	public Job updateJob(Job job,List<Skill> skillSet);

	public Job closeJob(int jobID);
}
