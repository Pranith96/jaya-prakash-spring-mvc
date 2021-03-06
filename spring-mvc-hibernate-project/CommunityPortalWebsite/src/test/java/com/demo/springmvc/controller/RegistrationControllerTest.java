package com.demo.springmvc.controller;

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

import com.wdf.springmvc.controller.RegistrationController;
import com.wdf.springmvc.model.User;
import com.wdf.springmvc.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

	@InjectMocks
	RegistrationController registrationController;

	@Mock
	UserServiceImpl userServiceImpl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLoadLoginPage() {
		ModelAndView mav = registrationController.loadLoginPage();
		Assert.assertEquals("register", mav.getViewName());
	}

	@Test
	public void testCreateUser() {
		User user = new User();
		Mockito.when(userServiceImpl.create(Mockito.any(User.class))).thenReturn(Mockito.anyString());
		ModelAndView mav = registrationController.createUser(user);
		Assert.assertEquals("prelogin", mav.getViewName());
	}
}
