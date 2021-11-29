package com.wdf.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wdf.springmvc.dto.UserDto;
import com.wdf.springmvc.model.User;
import com.wdf.springmvc.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class PasswordChangeController {

	@Autowired
	UserService userService;

	@GetMapping("/password/reset")
	public ModelAndView loadPasswordResetPage() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("password");
		return model;
	}

	@GetMapping("/password/check")
	public ModelAndView loadPasswordUpdatePage() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("updatepassword");
		return model;
	}

	@GetMapping("/forgotPassword")
	public ModelAndView resetPassword(@RequestParam("emailId") String emailId) throws Exception {
		String response = userService.resetPassword(emailId);
		ModelAndView model = new ModelAndView();
		model.setViewName("prelogin");
		model.addObject("response", response);
		return model;
	}

	@PostMapping("/update/password")
	public ModelAndView updatePassword(@ModelAttribute UserDto updateUserDto) throws Exception {
		String response = userService.updatePassword(updateUserDto);
		ModelAndView model = new ModelAndView();
		model.setViewName("updatedetailsuccess");
		model.addObject("response", response);
		return model;
	}
}
