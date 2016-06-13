package com.neu.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.jobportal.pojo.Person;
import com.neu.jobportal.service.PersonService;
import com.neu.spring.exception.AdException;



@Controller
@RequestMapping("/register.htm")
public class RegisterUserController {


	@Autowired
	PersonService personService;


	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {

		return "signUp";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("person") Person person, BindingResult result, Model model) throws Exception {
	
		if (result.hasErrors()) {
			System.out.println("error");
			return "signUp";
		}
		
		if(person.getRole().equals("jobseeker")){
			try {			
				personService.addJobSeeker(person);
			} catch (AdException e) {
				System.out.println("Exception: " + e.getMessage());
			}
			model.addAttribute("registrationSuccess", "true");
			return "signIn";
		}
		else{
			try {			
				personService.addEmployer(person);
			} catch (AdException e) {
				System.out.println("Exception: " + e.getMessage());
			}
			model.addAttribute("registrationSuccess", "true");
			return "signIn";
		}		
	}
		
}
