package com.wdf.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wdf.springmvc.dto.UserDto;
import com.wdf.springmvc.model.User;
import com.wdf.springmvc.service.UserService;
import com.wdf.springmvc.util.Constants;

@Controller
@RequestMapping(value = "/user")
public class LoginController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public ModelAndView loadLoginPage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		UserDto user = new UserDto();
		model.addObject("user", user);
		model.setViewName("login");
		return model;
	}

	@PostMapping("/login/check")
	public ModelAndView loginUser(@ModelAttribute UserDto loginDto, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User userResponse = userService.loginUser(loginDto);
		if (null == userResponse) {
			ModelAndView model = new ModelAndView();
			UserDto user = new UserDto();
			model.addObject("user", user);
			model.addObject("response", Constants.USER_LOGIN_FAILED);
			model.setViewName("failedloginpage");
			return model;
		}
		if (userResponse.getRole().equals(Constants.USER_ROLE)) {
			ModelAndView model = new ModelAndView();
			String response = "Welcome " + userResponse.getFirstName() + "..!!";
			model.addObject("response", response);
			model.setViewName("userhome");
			session.setAttribute("userId", userResponse.getUserId());
			session.setAttribute("role", userResponse.getRole());
			session.setAttribute("email", userResponse.getEmailId());
			return model;
		} else {
			ModelAndView model = new ModelAndView();
			String response = "Welcome " + userResponse.getFirstName() + "..!!";
			model.addObject("response", response);
			model.setViewName("adminhome");
			session.setAttribute("userId", userResponse.getUserId());
			session.setAttribute("role", userResponse.getRole());
			session.setAttribute("email", userResponse.getEmailId());
			return model;
		}

	}

}
