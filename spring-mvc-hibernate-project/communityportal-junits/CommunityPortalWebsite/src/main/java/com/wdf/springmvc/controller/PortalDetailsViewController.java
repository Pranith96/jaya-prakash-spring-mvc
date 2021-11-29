package com.wdf.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class PortalDetailsViewController {
	
	@GetMapping("/portal/new")
	public ModelAndView loadPortalPageforNewUsers() {
		ModelAndView model = new ModelAndView();
		model.setViewName("portaldetailsbeforelogin");
		return model;
	}
	
	@GetMapping("/portal")
	public ModelAndView loadPortalPageforExistingUsers() {
		ModelAndView model = new ModelAndView();
		model.setViewName("portaldetailsafterlogin");
		return model;
	}
}
