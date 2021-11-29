package com.wdf.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.wdf.springmvc.dto.UserDto;
import com.wdf.springmvc.model.User;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(User user) {
		String fromEmail = "ramannagaripranith96@gmail.com";
		String toEmail = user.getEmailId();
		String subject = "Registration Confirmation for " + user.getFirstName();
		String messageBody = "Hi " + user.getFirstName() + "...!!" + "\r\n\n";
		messageBody += "Thanks for Registering." + "\r\n";
		messageBody += "Please Login to Community Portal using your email: " + user.getEmailId() + " and password is: "
				+ user.getPassword() + "\r\n\n";

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(fromEmail);
		simpleMailMessage.setTo(toEmail);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(messageBody);
		try {
			mailSender.send(simpleMailMessage);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't send message");
		}
	}

	@Override
	public void sendEmailNotification(UserDto updateUserDto) {

		String fromEmail = "ramannagaripranith96@gmail.com";
		String toEmail = updateUserDto.getEmailId();
		String subject = "Application Password changed";
		String messageBody = "Your Application Password has been changed successfully." + "\r\n\n";
		messageBody += "Please Login to Community Portal using your email: " + updateUserDto.getEmailId()
				+ " and new password is: " + updateUserDto.getPassword() + "\r\n\n";

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(fromEmail);
		simpleMailMessage.setTo(toEmail);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(messageBody);
		try {
			mailSender.send(simpleMailMessage);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't send message");
		}
	}

}
