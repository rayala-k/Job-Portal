package com.neu.jobportal.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.neu.jobportal.pojo.Skill;
import com.neu.spring.exception.AdException;

@Repository
public class SkillDaoImpl extends DAO implements SkillDao {

	@Override
	public Skill addSkill(String name) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			Skill skill = new Skill(name);

			getSession().save(skill);

			commit();
			return skill;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating skill: " + e.getMessage());
		}

	}

	@Override
	public Skill getSkillByName(String name) {
		try {
			begin();
			Query q = getSession().createQuery("from Skill where lower(skillName) like :name");
			q.setString("name", name.toLowerCase());			
			Skill skill = (Skill) q.uniqueResult();
			commit();
			return skill;
		} catch (HibernateException e) {
			rollback();
			try {
				throw new AdException("Could not get skill " + name, e);

			} catch (AdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

}
