package com.neu.jobportal.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.jobportal.pojo.JobSeeker;
import com.neu.jobportal.pojo.Person;
import com.neu.jobportal.pojo.Resume;
import com.neu.jobportal.pojo.Skill;
import com.neu.jobportal.service.PersonService;
import com.neu.jobportal.service.ResumeService;
import com.neu.jobportal.service.SkillService;
import com.neu.spring.exception.AdException;

@Controller
@SessionAttributes("person")
public class ResumeController {

	@Autowired
	PersonService personService;

	@Autowired
	SkillService skillService;

	@Autowired
	ResumeService resumeService;

	@RequestMapping(value = "/resume.htm", method = RequestMethod.GET)
	public String initializeResume() {

		return "jobSeeker\\resume1";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/saveResume.htm", method = RequestMethod.POST)
	public String saveResume(@ModelAttribute("person") Person person, ModelMap modelMap, HttpServletRequest request,
			HttpSession session, @RequestParam("file") MultipartFile file) {

		System.out.println("File:" + file.getName());
		System.out.println("ContentType:" + file.getContentType());
		Blob blob = null;
		try {
			blob = Hibernate.createBlob(file.getInputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Skill> skillSet = new ArrayList<Skill>();

		System.out.println("from mdoel map" + modelMap.get("person"));

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

		try {
			resumeService.addResume(person.getPersonID(), Double.parseDouble(request.getParameter("totalExperience")),
					request.getParameter("jobTitle"), request.getParameter("highestEducationLevel"), skillSet,
					file.getOriginalFilename(), blob, file.getContentType());
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

	@RequestMapping("/download/{resumeId}")
	public String download(@PathVariable("resumeId") Integer resumeID, HttpServletResponse response) {

		Resume resume = resumeService.getResume(resumeID);
		try {
			response.setHeader("Content-Disposition", "inline;filename=\"" + resume.getFilename() + "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType(resume.getContentType());
			try {
				IOUtils.copy(resume.getContent().getBinaryStream(), out);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(value = "/editResume", method = RequestMethod.GET)
	public ModelAndView editResume(@ModelAttribute("person") Person person, ModelMap modelMap) {
		ModelAndView mv = new ModelAndView();

		JobSeeker seeker = personService.getJobSeeker(person.getPersonID());
		Resume resume = seeker.getResume();

		mv.addObject("person", seeker);
		mv.addObject("resume", resume);
		List<String> eduLevels = new ArrayList<String>();
		eduLevels.add("Bachelors");
		eduLevels.add("Masters");
		eduLevels.add("Phd");
		mv.addObject("eduLevels", eduLevels);
	
		mv.setViewName("jobSeeker\\editResume");

		return mv;
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/updateResume.htm", method = RequestMethod.POST)
	public String updateResume(@ModelAttribute("person") Person person, ModelMap modelMap, HttpServletRequest request,
			HttpSession session, @RequestParam("file") MultipartFile file) {

		Blob blob = null;
		if (!file.isEmpty()) {
			System.out.println("File:" + file.getName());
			System.out.println("ContentType:" + file.getContentType());

			try {
				blob = Hibernate.createBlob(file.getInputStream());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		List<Skill> skillSet = new ArrayList<Skill>();

		System.out.println("from mdoel map" + modelMap.get("person"));

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

		try {
			if (!file.isEmpty()) {
				resumeService.updateResume(person.getPersonID(),
						Double.parseDouble(request.getParameter("totalExperience")), request.getParameter("jobTitle"),
						request.getParameter("highestEducationLevel"), skillSet, file.getOriginalFilename(), blob,
						file.getContentType());
			}else{
				resumeService.updateResumeWoFile(person.getPersonID(),
						Double.parseDouble(request.getParameter("totalExperience")), request.getParameter("jobTitle"),
						request.getParameter("highestEducationLevel"), skillSet);
			}
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
