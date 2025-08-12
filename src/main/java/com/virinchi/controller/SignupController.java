package com.virinchi.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.mail.SimpleMailMessage;

import com.virinchi.model.UserClass;
import com.virinchi.repository.UserRepository;


@Controller
public class SignupController {

	@Autowired
	private JavaMailSender mailSender;
	
	//@Autowired is a primary exmaple of dependency injection in Spring
		//What it does : It provides all the necessary model and controller
		//and any other class information to the REPOSITORY that helps
		//the repository object to perform its task
	@Autowired //Dependency Injection
	UserRepository uRepo;

	@GetMapping("/signup")
	public String signupPage()
	{
		return "signUp";
	}
	
	@PostMapping("/signup")
	public String signupPagePost(@ModelAttribute UserClass ur)
	{
//@ModelAttribute utilizes the idea of HTTPRequest to
//get the parameters of form data into our controller
//the form data name should be exactly same as the model 
//instance variables
		
String username=ur.getUsername();
String password=ur.getPassword();
String email=ur.getEmail();

String hashPassword= DigestUtils.md5Hex(password.getBytes());

ur.setPassword(hashPassword);

		uRepo.save(ur);
//Sending email to the user based on their email address

SimpleMailMessage message=new SimpleMailMessage();
message.setTo(email);
message.setSubject("Welcome to my Project");
message.setText("CONGRATULATIONS!!! \n YOU HAVE SUCCESSFULLY SIGNED UP");
mailSender.send(message);
		
		return "frontPage";
	}
	
}
