package com.wdf.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wdf.springmvc.util.Constants;

@Controller
@RequestMapping("/user")
public class HomeController {

	@GetMapping("/home")
	public ModelAndView loadHomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;
	}

	@GetMapping("/redirect/home")
	public ModelAndView loadLoginHomePage(HttpSession session) {
		String userRole = (String) session.getAttribute("role");
		if (userRole.equals(Constants.USER_ROLE)) {
			ModelAndView model = new ModelAndView();
			model.setViewName("userhome");
			return model;
		} else {
			ModelAndView model = new ModelAndView();
			model.setViewName("adminhome");
			return model;
		}

	}

}
