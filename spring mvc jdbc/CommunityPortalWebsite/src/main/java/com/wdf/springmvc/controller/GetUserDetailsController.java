package com.wdf.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wdf.springmvc.model.User;
import com.wdf.springmvc.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class GetUserDetailsController {

	@Autowired
	UserService userService;

	@GetMapping("/get/allUsers")
	public ModelAndView getUsers() throws Exception {
		List<User> response = userService.getUsers();
		ModelAndView model = new ModelAndView();
		model.setViewName("userslist");
		model.addObject("user", response);
		return model;
	}

	@GetMapping("/get/profile/{userId}")
	public ModelAndView getUserProfile(@PathVariable("userId") Integer userId) throws Exception {
		User user = userService.getUser(userId);
		ModelAndView model = new ModelAndView();
		model.setViewName("profile");
		model.addObject("user", user);
		return model;
	}
}