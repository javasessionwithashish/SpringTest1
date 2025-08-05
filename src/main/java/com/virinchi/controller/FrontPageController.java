package com.virinchi.controller;

import com.virinchi.model.UserClass;
import com.virinchi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class FrontPageController {
/* 
 * Controller is just like servlet technology
 * It handles all the getter and setter functions
 * with  the help of HTTP protocol
 * 	
 */
	
	//COntroller provides - GetMapping, PostMapping
@Autowired
	private UserRepository uRepo;
	
@GetMapping("/")
public String myFirstPage() {
		return "frontPage";
	}

@GetMapping("/nextpage")//This comes from html
public String nextPage()
{
	return "nextPage";// this will be searched in templates
}
	
	@GetMapping("/home")
	public String homePage(Model m)
	{
		List<UserClass> uList= uRepo.findAll();
m.addAttribute("uList", uList);
		return "home";
	}
	
	

}
