package com.aciworldwide.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aciworldwide.entities.User;
import com.aciworldwide.services.UserService;

//PRESENTATION LAYER....REQUEST PROCESSING COMPONENT OF SPRING 

@Controller//Decision Layer
public class LoginController {

	//invokes BL
	@Autowired
	private UserService userService;
	
	//request PL
	
	@RequestMapping("/signin")//handler mapping...this is signin url 
	//To map request url with request processing
	public String validateUser(User user,ModelMap map)//method checks for mapping because of the annotations
	{
		//invoking BusinessLogic method of BusinessLayer
		if(userService.isValidUser(user)) {
			map.addAttribute("uname",user.getUsername());
			return"success";	//Logical view names...but it is not in form of .jsp OR .html etc.
			
			
			//here map and the return are the modelandView object
		}
		else
		{
			map.addAttribute("logonerror","Invalid user");//key value pair
			return "login";
		}
	}
	
}
