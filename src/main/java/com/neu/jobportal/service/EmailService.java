package com.neu.jobportal.service;

import javax.mail.MessagingException;

import com.neu.jobportal.pojo.Email;

public interface EmailService {
	 public void sendEmail(Email email) throws MessagingException;	
}
