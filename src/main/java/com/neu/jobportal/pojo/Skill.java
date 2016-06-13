package com.neu.jobportal.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Skill")
public class Skill {

	@Id
	@GeneratedValue
	@Column(name = "skillID", unique = true, nullable = false)
	private long skillID;

	@Column(name = "skillName", unique = true, nullable = false)
	private String skillName;

	public Skill() {

	}

	public Skill(String name) {
		this.skillName = name;
	}

	public long getSkillID() {
		return skillID;
	}

	public void setSkillID(long skillID) {
		this.skillID = skillID;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

}
