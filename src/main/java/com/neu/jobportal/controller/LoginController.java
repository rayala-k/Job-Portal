package com.neu.jobportal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.neu.jobportal.pojo.Employer;
import com.neu.jobportal.pojo.JobSeeker;
import com.neu.jobportal.pojo.Person;
import com.neu.jobportal.service.PersonService;

@Controller
@SessionAttributes("person")
public class LoginController {



	@Autowired
	PersonService personService;


	@RequestMapping(value="/login.htm",method = RequestMethod.GET)
	public String initializeForm() {

		return "signIn";
	}

	@RequestMapping(value="/login.htm",method = RequestMethod.POST)
	protected String doSubmitAction(@RequestParam("username") String username,
			@RequestParam("password") String password,Model model ) throws Exception {
		
		Person person;
		if (username != null && password != null) {
			person = personService.validatePerson(username, password);
		} else {
			
			return "signIn";
		}

		if (person.getRole().equals("jobseeker")) {
			JobSeeker jobSeeker = personService.getJobSeeker(person.getPersonID());
			model.addAttribute("person", jobSeeker);			
			return "redirect:/jobSeekerHome.htm";

		} else if (person.getRole().equals("employer")) {
			Employer employer = personService.getEmployer(person.getPersonID());
			model.addAttribute("person", employer);
			return "redirect:/employerHome.htm";			
		}
		
		return "signIn";
	}

	@RequestMapping("/logout.htm")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}

}
