package com.demo.springmvc.service;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.wdf.springmvc.dao.UserDaoImpl;
import com.wdf.springmvc.dto.UserDto;
import com.wdf.springmvc.model.User;
import com.wdf.springmvc.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	UserDaoImpl userDao;

	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Before
	public void setUp() {
		userDao = mock(UserDaoImpl.class);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetUsers() throws Exception {
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setUserId(1);
		user.setEmailId("ramannagaripranith96@gmail.com");
		user.setFirstName("Test");
		user.setPassword("Test");
		users.add(user);
		Mockito.when(userDao.fetchAllUsers()).thenReturn(users);
		List<User> userslist = userServiceImpl.getUsers();
		Assert.assertEquals(1, userslist.size());
	}

	@Test
	public void testLogin() throws Exception {
		User user = new User();
		user.setUserId(1);
		user.setEmailId("ramannagaripranith96@gmail.com");
		user.setFirstName("Test");
		user.setPassword("Test");
		UserDto userDto = new UserDto();
		userDto.setEmailId("ramannagaripranith96@gmail.com");
		userDto.setPassword("Test");
		Mockito.when(userDao.login(userDto)).thenReturn(Optional.of(user));
		User result = userServiceImpl.loginUser(userDto);
		Assert.assertEquals(user.getUserId(), result.getUserId());
	}

	@Test
	public void testGetUser() throws Exception {
		User user = new User();
		user.setUserId(1);
		user.setEmailId("ramannagaripranith96@gmail.com");
		user.setFirstName("Test");
		user.setPassword("Test");
		Mockito.when(userDao.getUserDetails(1)).thenReturn(Optional.of(user));
		User result = userServiceImpl.getUser(1);
		Assert.assertEquals(user.getUserId(), result.getUserId());
	}

	@Test
	public void testSearchUsersByKey() throws Exception {
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setUserId(1);
		user.setEmailId("ramannagaripranith96@gmail.com");
		user.setFirstName("Test");
		user.setPassword("Test");
		users.add(user);
		Mockito.when(userDao.searchUsers(Mockito.anyString())).thenReturn(users);
		List<User> result = userServiceImpl.searchUsersByKey("");
		Assert.assertEquals(1, result.size());
	}

}
