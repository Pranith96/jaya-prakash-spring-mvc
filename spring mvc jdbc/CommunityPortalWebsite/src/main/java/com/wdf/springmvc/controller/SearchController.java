package com.wdf.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wdf.springmvc.model.User;
import com.wdf.springmvc.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class SearchController {

	@Autowired
	UserService userService;

	@GetMapping("/search")
	public ModelAndView searchUser(@RequestParam("searchValue") String searchValue) throws Exception {
		List<User> userListResponse = userService.searchUsersByKey(searchValue);
		ModelAndView model = new ModelAndView();
		model.setViewName("searchuserlistresponse");
		model.addObject("userlist", userListResponse);
		return model;
	}

	@GetMapping("/view/profile/{userId}")
	public ModelAndView viewUserProfile(@PathVariable("userId") Integer userId) throws Exception {
		User user = userService.getUser(userId);
		ModelAndView model = new ModelAndView();
		model.setViewName("viewsearchuserprofile");
		model.addObject("user", user);
		return model;
	}
}
