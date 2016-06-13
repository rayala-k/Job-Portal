package com.neu.jobportal;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.jobportal.pojo.Job;
import com.neu.jobportal.service.SearchService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	SearchService searchService;

	int page = 1;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/searchFromHome", method = RequestMethod.GET)
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
		mv.setViewName("searchResultsHome");
		return mv;
	}
}
