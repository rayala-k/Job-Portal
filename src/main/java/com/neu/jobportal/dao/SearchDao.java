package com.neu.jobportal.dao;

import org.springframework.web.servlet.ModelAndView;

public interface SearchDao {

	public ModelAndView searchBySkillAndLocation(String jobTitle,String skill,String company,String location,int page,int recordsPerPage);
}
