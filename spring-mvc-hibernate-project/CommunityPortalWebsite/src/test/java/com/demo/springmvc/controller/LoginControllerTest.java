package com.demo.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.wdf.springmvc.controller.LoginController;
import com.wdf.springmvc.dto.UserDto;
import com.wdf.springmvc.model.User;
import com.wdf.springmvc.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@InjectMocks
	LoginController loginController;

	@Mock
	UserServiceImpl userServiceImpl;

	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpSession session;
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testLoadLoginPage() {
		ModelAndView mav = loginController.loadLoginPage(null);
		Assert.assertEquals("login", mav.getViewName());
	}

	@Test
	public void testNullLoginUser() throws Exception {
		UserDto userDto = new UserDto();
		User user = null;
		//Mockito.when(request.getSession()).thenReturn(session);
		Mockito.when(userServiceImpl.loginUser(userDto)).thenReturn(user);
		ModelAndView mav = loginController.loginUser(userDto, null);
		Assert.assertEquals("failedloginpage", mav.getViewName());
	}
	
	@Test
	public void testAdminLoginUser() throws Exception {
		UserDto userDto = new UserDto();
		User user = new User();
		user.setRole("ADMIN");
		//Mockito.when(request.getSession()).thenReturn(session);
		Mockito.when(userServiceImpl.loginUser(userDto)).thenReturn(user);
		ModelAndView mav = loginController.loginUser(userDto, null);
		Assert.assertEquals("adminhome", mav.getViewName());
	}
	
	@Test
	public void testUserLoginUser() throws Exception {
		UserDto userDto = new UserDto();
		User user = new User();
		user.setRole("USER");
		//Mockito.when(request.getSession()).thenReturn(session);
		Mockito.when(userServiceImpl.loginUser(userDto)).thenReturn(user);
		ModelAndView mav = loginController.loginUser(userDto, null);
		Assert.assertEquals("userhome", mav.getViewName());
	}
	
}
