package com.wdf.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wdf.springmvc.model.User;
import com.wdf.springmvc.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class RegistrationController {

	@Autowired
	UserService userService;

	@GetMapping("/register")
	public ModelAndView loadLoginPage() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("register");
		return model;
	}

	@PostMapping("/add")
	public ModelAndView createUser(@ModelAttribute User user) {
		String response = userService.create(user);
		ModelAndView model = new ModelAndView();
		model.addObject("response", response);
		model.setViewName("prelogin");
		return model;
	}
}
