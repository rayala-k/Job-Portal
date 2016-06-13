package com.neu.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.neu.jobportal.service.JobService;
import com.neu.jobportal.service.PersonService;
import com.neu.jobportal.service.SkillService;

@Controller
@SessionAttributes("person")
public class JobController {
	
	/*@Autowired
	JobService jobService;
	
	@Autowired
	PersonService personService;
	
	@Autowired
	SkillService skillService;

	*/
}
