package com.neu.jobportal.service;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.jobportal.dao.ResumeDao;
import com.neu.jobportal.pojo.Resume;
import com.neu.jobportal.pojo.Skill;
import com.neu.spring.exception.AdException;

@Service
public class ResumeServiceImpl implements ResumeService {
	
	@Autowired
	ResumeDao resumeDao;		

	@Override
	public Resume addResume(long personID,double experience,String jobTitle, String qualification, List<Skill> skillSet,String filename, Blob blob, String contenType) throws AdException {
		return resumeDao.addResume(personID, experience,jobTitle, qualification, skillSet, filename, blob, contenType);
	}

	@Override
	public Resume getResume(int resumeID) {
		// TODO Auto-generated method stub
		return resumeDao.getResume(resumeID);
	}

	@Override
	public Resume updateResume(long personID, double experience, String jobTitle, String qualification,
			List<Skill> skillSet, String filename, Blob blob, String contenType) throws AdException {
		return resumeDao.updateResume(personID, experience,jobTitle, qualification, skillSet, filename, blob, contenType);
	}

	@Override
	public Resume updateResumeWoFile(long personID, double experience,String jobTitle, String qualification,
			List<Skill> skillSet) {
		
		return resumeDao.updateResumeWoFile(personID, experience,jobTitle, qualification, skillSet);
	}

}
