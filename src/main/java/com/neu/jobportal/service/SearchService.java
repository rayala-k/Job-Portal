package com.neu.jobportal.service;

import org.springframework.web.servlet.ModelAndView;

public interface SearchService {
	
	public ModelAndView searchBySkillAndLocation(String jobTitle,String skill,String company,String location,int page,int recordsPerPage);

}
