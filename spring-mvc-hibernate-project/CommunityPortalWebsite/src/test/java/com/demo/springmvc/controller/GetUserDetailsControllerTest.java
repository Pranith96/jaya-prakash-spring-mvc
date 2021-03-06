package com.demo.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.wdf.springmvc.controller.GetUserDetailsController;
import com.wdf.springmvc.model.User;
import com.wdf.springmvc.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class GetUserDetailsControllerTest {

	@InjectMocks
	GetUserDetailsController getUserDetailsController;

	@Mock
	UserServiceImpl userServiceImpl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetUsers() throws Exception {
		List<User> user = new ArrayList<>();
		Mockito.when(userServiceImpl.getUsers()).thenReturn(user);
		ModelAndView mav = getUserDetailsController.getUsers();
		Assert.assertEquals("userslist", mav.getViewName());
	}

	@Test
	public void testGetUserProfile() throws Exception {
		User user = new User();
		user.setUserId(1);
		Mockito.when(userServiceImpl.getUser(Mockito.anyInt())).thenReturn(user);
		ModelAndView mav = getUserDetailsController.getUserProfile(user.getUserId());
		Assert.assertEquals("profile", mav.getViewName());
	}
}
