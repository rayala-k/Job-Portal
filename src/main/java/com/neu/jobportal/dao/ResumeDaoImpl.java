package com.neu.jobportal.dao;

import java.sql.Blob;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neu.jobportal.pojo.JobSeeker;
import com.neu.jobportal.pojo.Resume;
import com.neu.jobportal.pojo.Skill;
import com.neu.jobportal.service.PersonService;
import com.neu.spring.exception.AdException;

@Repository
public class ResumeDaoImpl extends DAO implements ResumeDao {

	@Autowired
	PersonService personService;

	@Override
	public Resume addResume(long personID, double experience, String jobTitle, String qualification,
			List<Skill> skillSet, String filename, Blob blob, String contenType) throws AdException {
		try {

			System.out.println("inside DAO");

			begin();

			Query q = getSession().createQuery("from JobSeeker where personID = :personID");
			q.setLong("personID", personID);

			JobSeeker jobSeeker = (JobSeeker) q.uniqueResult();

			Resume resume = new Resume();
			resume.setApplicant(jobSeeker);
			resume.setHighestEducationLevel(qualification);
			resume.setTotalExperience(experience);
			resume.setMySkills(skillSet);
			resume.setContent(blob);
			resume.setContentType(contenType);
			resume.setFilename(filename);
			resume.setJobTitle(jobTitle);

			getSession().save(resume);

			jobSeeker.setResume(resume);

			getSession().update(jobSeeker);

			commit();
			return resume;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}

	@Override
	public Resume getResume(int resumeID) {
		try {
			begin();
			Query q = getSession().createQuery("from Resume where resumeID = :id");
			q.setLong("id", resumeID);

			Resume resume = (Resume) q.uniqueResult();
			commit();
			return resume;
		} catch (HibernateException e) {
			rollback();
			try {
				throw new AdException("Could not get user " + resumeID, e);

			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Resume updateResume(long personID, double experience, String jobTitle, String qualification,
			List<Skill> skillSet, String filename, Blob blob, String contenType) {
		try {

			System.out.println("inside DAO");

			begin();

			Query q = getSession().createQuery("from JobSeeker where personID = :personID");
			q.setLong("personID", personID);

			JobSeeker jobSeeker = (JobSeeker) q.uniqueResult();

			Resume resume = jobSeeker.getResume();
			resume.setApplicant(jobSeeker);
			resume.setHighestEducationLevel(qualification);
			resume.setTotalExperience(experience);
			resume.getMySkills().clear();
			resume.setMySkills(skillSet);
			resume.setContent(blob);
			resume.setContentType(contenType);
			resume.setFilename(filename);
			resume.setJobTitle(jobTitle);

			getSession().update(resume);

			// jobSeeker.setResume(resume);

			// getSession().update(jobSeeker);

			commit();
			return resume;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
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
	public Resume updateResumeWoFile(long personID, double experience, String jobTitle, String qualification,
			List<Skill> skillSet) {
		try {

			System.out.println("inside DAO");

			begin();

			Query q = getSession().createQuery("from JobSeeker where personID = :personID");
			q.setLong("personID", personID);

			JobSeeker jobSeeker = (JobSeeker) q.uniqueResult();

			Resume resume = jobSeeker.getResume();
			resume.setApplicant(jobSeeker);
			resume.setHighestEducationLevel(qualification);
			resume.setTotalExperience(experience);
			resume.getMySkills().clear();
			resume.setMySkills(skillSet);
			resume.setJobTitle(jobTitle);

			getSession().update(resume);

			// jobSeeker.setResume(resume);

			// getSession().update(jobSeeker);

			commit();
			return resume;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			try {
				throw new AdException("Exception while creating user: " + e.getMessage());
			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

}
