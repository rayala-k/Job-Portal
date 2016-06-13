package com.neu.jobportal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.neu.jobportal.pojo.AppliedJobs;
import com.neu.jobportal.pojo.Job;
import com.neu.jobportal.pojo.Person;
import com.neu.jobportal.service.JobService;
import com.neu.jobportal.service.PersonService;
import com.neu.jobportal.service.SearchService;

@Controller	
@SessionAttributes("person")
public class JobSeekerController {
	
	@Autowired
	JobService jobService;
	
	@Autowired
	SearchService searchService;	
	

	
	int page = 0;

	
	@RequestMapping(value="/jobSeekerHome.htm",method = RequestMethod.GET)
	public String jobSeekerHome() {

		return "jobSeeker\\jobSeekerHome";
	}
	
	@RequestMapping(value="/availableJobs.htm",method = RequestMethod.GET)
	public ModelAndView listAvailableJobs(){
		ModelAndView mv = new ModelAndView();
		List<Job> jobs = new ArrayList<Job>();
		jobs = jobService.listAllActiveJobs();
		mv.addObject("jobs", jobs);
		mv.setViewName("jobSeeker\\availableJobs");
		return mv;
	}
	
	@RequestMapping(value="/getJob/{jobID}",method = RequestMethod.GET)
	public ModelAndView getJob(@PathVariable("jobID") Integer jobID,@ModelAttribute("person") Person person){
		ModelAndView mv = new ModelAndView();
		Job job = jobService.getJob(jobID);
		
		Set<AppliedJobs> jobs = jobService.getAppliedJobs(person.getPersonID());
		
		for(AppliedJobs j:jobs){
			if(j.getJob().getJobID() == job.getJobID()){
				mv.addObject("applied", "applied");
				break;
			}
		}
		
		mv.addObject("job", job);
		mv.setViewName("jobSeeker\\viewJob");
		return mv;
	}
	
	@RequestMapping(value="/applyJob/{jobID}",method = RequestMethod.GET)
	public ModelAndView applyJob(@PathVariable("jobID") Integer jobID,@ModelAttribute("person") Person person){
		ModelAndView mv = new ModelAndView();
		mv.addObject("job", jobService.applyJob(jobID, person.getPersonID()));
		mv.setViewName("jobSeeker\\viewJob");
		return mv;
	}
	
	@RequestMapping(value = "/searchByCandidate", method = RequestMethod.GET)
	public ModelAndView searchFromHome(HttpServletRequest request, HttpSession session) {
		String jobTitle = "";
		String skill = "";
		String company = "";
		String location = "";
		int recordsPerPage = 1;
		

		if (request.getParameter("page") == null || request.getParameter("check") !=null) {
			page = 1;
			jobTitle = request.getParameter("jobTitle");
			skill = request.getParameter("skill");
			company = request.getParameter("companyName");
			location = request.getParameter("location");
			session.setAttribute("jobTitle", jobTitle);
			session.setAttribute("skill", skill);
			session.setAttribute("company", company);
			session.setAttribute("location", location);
		} else if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			jobTitle = (String) session.getAttribute("jobTitle");
			skill = (String) session.getAttribute("skill");	
			company = (String) session.getAttribute("companyName");
			location = (String) session.getAttribute("location");
		}
		
		System.out.println(jobTitle + "::" + skill+"::"+company + "::" + location);

		ModelAndView mod = searchService.searchBySkillAndLocation(jobTitle, skill,company,location, page, recordsPerPage);
		List<Job> jobs = (List<Job>) mod.getModelMap().get("jobs");
		int noOfRecords = (Integer) mod.getModelMap().get("totalRecords");
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		ModelAndView mv = new ModelAndView();
		mv.addObject("jobs", jobs);
		mv.addObject("noOfPages", noOfPages);
		mv.addObject("currentPage", page);
		mv.setViewName("jobSeeker\\searchAvailableJobs");
		return mv;
	}
	
	@RequestMapping(value="/getAppliedJobs",method=RequestMethod.GET)
	public ModelAndView getAppliedJobs(@ModelAttribute("person") Person person){
		ModelAndView mv =new ModelAndView();
		Set<AppliedJobs> appliedJobs = jobService.getAppliedJobs(person.getPersonID());
		//List<Job> jobs = new ArrayList<Job>();
		//for(AppliedJobs j:appliedJobs){
			//jobs.add(j.getJob());
		//}
		
		mv.addObject("appliedJobs", appliedJobs);
		mv.setViewName("jobSeeker\\viewAppliedJobs");
		return mv;

	}
	
	
}
