package com.neu.jobportal.dao;

import com.neu.jobportal.pojo.Skill;
import com.neu.spring.exception.AdException;

public interface SkillDao {
	public Skill addSkill(String name) throws AdException;	
	
	public Skill getSkillByName(String name);
}
