package com.wdf.springmvc.dao;

import java.util.List;

import com.wdf.springmvc.dto.UserDto;
import com.wdf.springmvc.model.User;

public interface UserDao {

	String saveUser(User user);

	User login(UserDto loginDto);

	List<User> fetchAllUsers();

	User findUserByEmailId(String emailId);

	int updatePassword(String emailId, String newPassword);

	String updateUser(User user);

	void deleteUserByEmail(Integer userId);

	User getUserDetails(Integer userId);

	List<User> searchUsers(String searchValue);

}
