package com.neu.jobportal.service;

import java.sql.Blob;
import java.util.List;

import com.neu.jobportal.pojo.Resume;
import com.neu.jobportal.pojo.Skill;
import com.neu.spring.exception.AdException;

public interface ResumeService {
	public Resume addResume(long personID,double experience,String jobTitle, String qualification, List<Skill> skillSet, String filename, Blob blob, String contenType) throws AdException;	
	
	public Resume updateResume(long personID,double experience,String jobTitle, String qualification, List<Skill> skillSet, String filename, Blob blob, String contenType) throws AdException;	
	
	public Resume getResume(int resumeID);

	public Resume updateResumeWoFile(long personID, double experience,String jobTitle, String qualification,
			List<Skill> skillSet);
}
