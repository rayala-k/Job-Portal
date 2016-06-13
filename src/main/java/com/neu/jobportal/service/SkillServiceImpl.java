package com.neu.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.jobportal.dao.SkillDao;
import com.neu.jobportal.pojo.Skill;
import com.neu.spring.exception.AdException;

@Service
public class SkillServiceImpl implements SkillService {
	
	@Autowired 
	SkillDao skillDao;

	@Override
	public Skill addSkill(String name) throws AdException {
		return skillDao.addSkill(name);
	}

	@Override
	public Skill getSkillByName(String name) {
		return skillDao.getSkillByName(name);
	}

}
