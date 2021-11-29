package com.wdf.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wdf.springmvc.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class DeleteUserDetailsController {

	@Autowired
	UserService userService;

	@RequestMapping("/delete/{userId}")
	public ModelAndView  deleteUserRecord(@PathVariable("userId") Integer userId) throws Exception {
		String response = userService.deleteUserRecord(userId);
		ModelAndView model = new ModelAndView();
		model.setViewName("updatedetailsuccess");
		model.addObject("response", response);
		return model;
	}

}
