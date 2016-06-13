package com.neu.jobportal.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.neu.jobportal.pojo.Email;

@Service
public class EmailServiceImpl implements EmailService {

	private JavaMailSenderImpl mailSender = null;

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	public void sendEmail(Email email) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setTo(email.getTo());
		helper.setFrom(email.getFrom());
		helper.setSubject(email.getSubject());
		helper.setText(email.getText(), true);


		mailSender.send(mimeMessage);
	}

}
