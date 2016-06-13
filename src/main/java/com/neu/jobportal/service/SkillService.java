package com.neu.jobportal.service;

import com.neu.jobportal.pojo.Skill;
import com.neu.spring.exception.AdException;

public interface SkillService {
	public Skill addSkill(String name) throws AdException;	
	
	public Skill getSkillByName(String name);
}
