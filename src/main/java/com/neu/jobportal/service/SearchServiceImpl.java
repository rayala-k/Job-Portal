package com.neu.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.neu.jobportal.dao.SearchDao;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	SearchDao searchDao;

	@Override
	public ModelAndView searchBySkillAndLocation(String jobTitle,String skill,String company,String location, int page,int recordsPerPage) {
		return searchDao.searchBySkillAndLocation(jobTitle,skill,company,location, page,recordsPerPage);
	}

}
