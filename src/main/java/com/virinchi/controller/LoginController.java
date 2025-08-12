package com.virinchi.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.virinchi.model.UserClass;
import com.virinchi.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository uRepo;

	@GetMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	
	@PostMapping("/login")
public String postLoginPage(@ModelAttribute UserClass ur, Model m, HttpSession session)
	{
		String username= ur.getUsername();
		String password= ur.getPassword();
		
String hashPassword =DigestUtils.md5Hex(password.getBytes());

boolean result=	uRepo.existsByUsernameAndPassword(username, hashPassword);
if(result==true)
{
session.setAttribute("activeUser", username);
session.setMaxInactiveInterval(20);
	m.addAttribute("uList", uRepo.findAll());
		return "home";
}
else
{
m.addAttribute("loginerror","Username or Password Incorrect");
	return "login";
}
	}



	@GetMapping("/logout")
	public String logoutPage(HttpSession session)
	{
		session.invalidate();
		return "frontPage";
	}


}
