package com.wdf.springmvc.service;

import java.util.List;

import com.wdf.springmvc.dto.UserDto;
import com.wdf.springmvc.dto.UserRequestDto;
import com.wdf.springmvc.model.User;

public interface UserService {

	String create(User user);

	User loginUser(UserDto loginDto) throws Exception;

	List<User> getUsers() throws Exception;

	String resetPassword(String emailId) throws Exception;

	String updateUser(UserRequestDto updateUserDto) throws Exception;

	String deleteUserRecord(Integer userId) throws Exception;

	String updatePassword(UserDto updateUserDto) throws Exception;

	User getUser(Integer userId) throws Exception;

	List<User> searchUsersByKey(String searchValue);

}
