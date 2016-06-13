package com.neu.jobportal.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.neu.jobportal.pojo.Job;

@Repository
public class SearchDaoImpl extends DAO implements SearchDao {

	@Override
	public ModelAndView searchBySkillAndLocation(String jobTitle, String skill, String company, String location,
			int page, int recordsPerPage) {
		StringBuilder query = new StringBuilder();
		begin();

		if (jobTitle != null && jobTitle.length() > 0) {
			query.append(" and lower(j.jobTitle) like:jobTitle");

		} else if (skill != null && skill.length() > 0) {
			query.append(" and lower(skill.skillName) like:skill");

		} else if (location != null && location.length() > 0) {
			query.append(" and lower(j.location) like:location");

		}
		else if (company != null && company.length() > 0) {
			query.append(" and lower(j.companyName) like:company");

		}

		Query q = getSession().createQuery(
				"Select distinct j from Job as j inner join j.jobSkills as skill where  j.active = :isActive" + query
						+ " order by postedDate desc");

		if (jobTitle != null && jobTitle.length() > 0) {
			q.setString("jobTitle", "%"+jobTitle.toLowerCase()+"%");

		} else if (skill != null && skill.length() > 0) {
			q.setString("skill", "%"+skill.toLowerCase()+"%");

		} else if (location != null && location.length() > 0) {
			q.setString("location", "%"+location.toLowerCase()+"%");

		}else if (company != null && company.length() > 0) {
			q.setString("company", "%"+company.toLowerCase()+"%");

		}
		q.setBoolean("isActive", true);
		int totalRecords = q.list().size();
		System.out.println("totRec"+totalRecords);
		q.setFirstResult((page - 1) * recordsPerPage);
		q.setMaxResults(recordsPerPage);

		List<Job> jobs = q.list();
		
		commit();
		ModelAndView model = new ModelAndView();
		model.addObject("jobs", jobs);
		model.addObject("totalRecords", totalRecords);
		return model;
	}

}
