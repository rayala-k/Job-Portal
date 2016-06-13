package com.neu.jobportal.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.neu.jobportal.pojo.AppliedJobs;
import com.neu.jobportal.pojo.Employer;
import com.neu.jobportal.pojo.Job;
import com.neu.jobportal.pojo.Person;
import com.neu.jobportal.pojo.Skill;
import com.neu.jobportal.service.JobService;
import com.neu.jobportal.service.PersonService;
import com.neu.jobportal.service.SkillService;
import com.neu.spring.exception.AdException;

@Controller
@SessionAttributes("person")
public class EmployerController {

	@Autowired
	JobService jobService;

	@Autowired
	PersonService personService;

	@Autowired
	SkillService skillService;

	@RequestMapping(value = "/employerHome.htm", method = RequestMethod.GET)
	public String employerHome() {

		return "employer\\employerHome";
	}

	@RequestMapping(value = "/addJob.htm", method = RequestMethod.GET)
	public String initializeJob(@ModelAttribute("job") Job job, BindingResult result) {

		return "employer\\addJob";
	}

	@RequestMapping(value = "/saveJob.htm", method = RequestMethod.POST)
	public String saveJob(@ModelAttribute("job") Job job, BindingResult result, ModelMap modelmap,
			@ModelAttribute("person") Person person, HttpServletRequest request, HttpSession session) {
		Employer employer = (Employer) person;

		List<Skill> skillSet = new ArrayList<Skill>();

		if (request.getParameterValues("addedSkills") != null) {
			for (String s : request.getParameterValues("addedSkills")) {
				Skill skill = skillService.getSkillByName(s);
				if (skill == null) {
					try {
						System.out.println("new skill" + s);
						skill = skillService.addSkill(s);
						skillSet.add(skill);
					} catch (AdException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("existing skill" + s);
					skillSet.add(skill);
				}
				System.out.println(s);
			}
		}

		job.setJobSkills(skillSet);
		job.setPostedBy(employer);
		job.setPostedDate(LocalDateTime.now().toLocalDate());
		job.setActive(true);
		jobService.saveJob(job);

		Employer emp = (Employer) personService.getEmployer(person.getPersonID());
		modelmap.replace("person", emp);

		return "redirect:/employerHome.htm";
	}

	@RequestMapping(value = "/viewApplicants/{jobID}", method = RequestMethod.GET)
	public ModelAndView viewApplicants(@PathVariable("jobID") Integer jobID) {
		ModelAndView mv = new ModelAndView();
		Job job = jobService.getJob(jobID);
		Set<AppliedJobs> appliedJobs = job.getAppliedJobs();
		mv.addObject("job", job);
		mv.addObject("applicants", appliedJobs);
		mv.setViewName("employer\\viewApplicants");
		return mv;
	}

	@RequestMapping(value = "/updateStatus.htm", method = RequestMethod.POST)
	public String updateJobStatus(String id, String jobStatus, String jobSeekerID) {
		// ModelAndView mv = new ModelAndView();
		System.out.println(id + ":::" + jobStatus + ":::" + jobSeekerID);

		jobService.updateJobStatus(id, jobStatus, jobSeekerID);

		return "redirect:/viewApplicants/" + id;
	}

	@RequestMapping(value = "/viewJob/{jobID}", method = RequestMethod.GET)
	public ModelAndView getJob(@PathVariable("jobID") Integer jobID, @ModelAttribute("person") Person person) {
		ModelAndView mv = new ModelAndView();
		Job job = jobService.getJob(jobID);

		mv.addObject("job", job);
		mv.setViewName("employer\\viewJob");
		return mv;
	}

	@RequestMapping(value = "/editJob/{jobID}", method = RequestMethod.GET)
	public ModelAndView editJob(@PathVariable("jobID") Integer jobID, @ModelAttribute("job") Job job,
			BindingResult result, ModelMap modelmap, @ModelAttribute("person") Person person,
			HttpServletRequest request, HttpSession session) {
		// Employer employer = (Employer) person;
		// Employer emp = (Employer)
		// personService.getEmployer(person.getPersonID());

		job = jobService.getJob(jobID);

		ModelAndView mv = new ModelAndView();

		List<String> eduLevels = new ArrayList<String>();
		eduLevels.add("Bachelors");
		eduLevels.add("Masters");
		eduLevels.add("Phd");
		mv.addObject("eduLevels", eduLevels);

		List<String> jobtypes = new ArrayList<String>();
		jobtypes.add("Full-Time");
		jobtypes.add("Part-Time");
		jobtypes.add("InternShip");
		mv.addObject("jobtypes", jobtypes);

		mv.addObject("job", job);
		mv.setViewName("employer\\editJob");

		return mv;
	}

	@RequestMapping(value = "/updateJob", method = RequestMethod.POST)
	public String updateJob(@ModelAttribute("job") Job job, BindingResult result, ModelMap modelmap,
			@ModelAttribute("person") Person person, HttpServletRequest request, HttpSession session) {

		

		List<Skill> skillSet = new ArrayList<Skill>();
		if (request.getParameterValues("addedSkills") != null) {
			for (String s : request.getParameterValues("addedSkills")) {
				Skill skill = skillService.getSkillByName(s);
				if (skill == null) {
					try {
						System.out.println("new skill" + s);
						skill = skillService.addSkill(s);
						skillSet.add(skill);
					} catch (AdException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("existing skill" + s);
					skillSet.add(skill);
				}
				System.out.println(s);
			}
		}

	//	job.setJobSkills(skillSet);

		jobService.updateJob(job,skillSet);

		Employer emp = (Employer) personService.getEmployer(person.getPersonID());
		modelmap.replace("person", emp);

		return "redirect:/viewJob/" + job.getJobID();
		
	}
	
	@RequestMapping(value="/closeJob/{jobID}",method=RequestMethod.GET)	
	public String closeJob(@PathVariable("jobID") Integer jobID){
		
		Job job = jobService.closeJob(jobID);
		return "redirect:/viewJob/" + jobID;
		
	}
}
