package com.neu.jobportal.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.neu.jobportal.pojo.Email;
import com.neu.jobportal.pojo.Job;
import com.neu.jobportal.pojo.JobAlerts;
import com.neu.jobportal.pojo.JobSeeker;
import com.neu.jobportal.service.EmailService;
import com.neu.jobportal.service.PersonService;

public class SendJobAlertMailJob extends QuartzJobBean {

	private EmailService emailService;

	private PersonService personService;

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {

		
		List<JobSeeker> jobSeekerList = personService.getAllSubscribedJobSeekers();

		for (JobSeeker seeker : jobSeekerList) {
			JobAlerts alert = seeker.getJobAlerts();
			
			
			List<Job> jobs = personService.getMessageAlerts(alert.getJobAlertID());
			StringBuilder message = new StringBuilder();
			message.append("Dear "+seeker.getFirstName()+","+"<br/>Finr the search results for ur Job Alerts<br/>");
			for(Job j:jobs){
				message.append("<p>"+j.getJobTitle()+"</p><p>"+j.getLocation()+"</p><br/><br/>");
			}
			
			
			Email email = new Email();
			email.setFrom("karthiknagtaurus@gmail.com");
			email.setSubject("Job Alerts");
			email.setTo(seeker.getEmail());
	
			email.setText(message.toString());	
			
			try {
				emailService.sendEmail(email);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
