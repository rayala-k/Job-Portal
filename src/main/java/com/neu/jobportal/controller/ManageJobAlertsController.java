package com.neu.jobportal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.neu.jobportal.pojo.JobAlerts;
import com.neu.jobportal.pojo.JobSeeker;
import com.neu.jobportal.pojo.Keyword;
import com.neu.jobportal.pojo.Person;
import com.neu.jobportal.service.JobService;
import com.neu.jobportal.service.PersonService;
import com.neu.spring.exception.AdException;

@Controller
@SessionAttributes("person")
public class ManageJobAlertsController {
	
	@Autowired
	JobService jobService;

	@Autowired
	PersonService personService;

	
	@RequestMapping(value="/manageJobAlerts.htm",method=RequestMethod.GET)
	public String manageJobAlerts(@ModelAttribute("person") Person person){
		
		int jobSeekerID = (int) person.getPersonID();
		JobAlerts jobAlerts = jobService.getJobAlerts(jobSeekerID);
		
		if(jobAlerts == null){
			return "jobSeeker\\manageJobAlerts";
		}else{
			return "redirect:/editJobAlert.htm";
		}
	}
	
	@RequestMapping(value="/createJobAlert.htm",method=RequestMethod.POST)
	public String createJobAlert(@ModelAttribute("person") Person person, ModelMap modelMap, HttpServletRequest request,
			HttpSession session){
		//return "jobSeeker\\manageJobAlerts";
		
		String alertName = request.getParameter("alertName");
		
		String location = request.getParameter("location");
		

		List<Keyword> skillSet = new ArrayList<Keyword>();
		
		for (String s : request.getParameterValues("addedSkills")) {
			Keyword keyword = jobService.getKeyWordByName(s);
			if (keyword == null) {
				System.out.println("new keyword" + s);
				keyword = jobService.addKeyword(s);
				skillSet.add(keyword);
			} else {
				System.out.println("existing keyword" + s);
				skillSet.add(keyword);
			}
			System.out.println(s);
		}
		
		try {
			jobService.createJobAlert(person.getPersonID(), skillSet, alertName,location);
					
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		JobSeeker jobSeeker = personService.getJobSeeker(person.getPersonID());

		modelMap.replace("person", jobSeeker);
		
		return "redirect:/jobSeekerHome.htm";
	}
	
}
