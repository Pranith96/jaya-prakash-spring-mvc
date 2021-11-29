package com.wdf.springmvc.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdf.springmvc.dao.UserDao;
import com.wdf.springmvc.dto.UserDto;
import com.wdf.springmvc.dto.UserRequestDto;
import com.wdf.springmvc.model.User;
import com.wdf.springmvc.util.Constants;
import com.wdf.springmvc.util.PasswordGenerator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	EmailService emailService;

	@Override
	public String create(User user) {
		String password = PasswordGenerator.passwordGenerator();
		user.setPassword(password);
		String response = userDao.saveUser(user);
		sendEmailToUser(user);
		return response;
	}

	private void sendEmailToUser(User user) {
		emailService.sendEmail(user);
	}

	@Override
	public User loginUser(UserDto loginDto) throws Exception {
		Optional<User> user = userDao.login(loginDto);
		if (!user.isPresent()) {
			return null;
		}
		return user.get();
	}

	@Override
	public List<User> getUsers() throws Exception {
		List<User> users = userDao.fetchAllUsers();
		if (null == users || users.isEmpty()) {
			throw new Exception("No Users found");
		}
		return users;
	}

	@Override
	public String resetPassword(String emailId) throws Exception {
		Optional<User> userResponse = userDao.findUserByEmailId(emailId);
		if (!userResponse.isPresent()) {
			throw new Exception("Email id is invalid");
		}

		String newPassword = PasswordGenerator.passwordGenerator();
		int response = userDao.updatePassword(userResponse.get().getEmailId(), newPassword);
		if (response < 0) {
			return Constants.PASSWORD_NOT_UPDATED;
		}

		UserDto userdto = new UserDto();
		userdto.setEmailId(emailId);
		userdto.setPassword(newPassword);
		emailService.sendEmailNotification(userdto);
		return Constants.PASSWORD_CHANGED;
	}

	@Override
	public String updateUser(UserRequestDto updateUserDto) throws Exception {
		Optional<User> userResponse = userDao.findUserByEmailId(updateUserDto.getEmailId());
		if (!userResponse.isPresent()) {
			return "Email id cannot be updated";
		}
		User user = updateUserRequest(updateUserDto, userResponse.get());
		String response = userDao.updateUser(user);
		return response;
	}

	private User updateUserRequest(UserRequestDto updateUserDto, User user) {

		if (updateUserDto.getFirstName() != null) {
			user.setFirstName(updateUserDto.getFirstName());
		}
		if (updateUserDto.getLastName() != null) {
			user.setLastName(updateUserDto.getLastName());
		}
		if (updateUserDto.getMobileNumber() != null) {
			user.setMobileNumber(updateUserDto.getMobileNumber());
		}

		if (updateUserDto.getEmailId() != null) {
			user.setEmailId(updateUserDto.getEmailId());
		}
		if (updateUserDto.getGender() != null) {
			user.setGender(updateUserDto.getGender());
		}
		if (updateUserDto.getCompanyName() != null) {
			user.setCompanyName(updateUserDto.getCompanyName());
		}
		if (updateUserDto.getCity() != null) {
			user.setCity(updateUserDto.getCity());
		}
		if (updateUserDto.getColonyName() != null) {
			user.setColonyName(updateUserDto.getColonyName());
		}
		if (updateUserDto.getCountry() != null) {
			user.setCountry(updateUserDto.getCountry());
		}
		if (updateUserDto.getPlotNo() != null) {
			user.setPlotNo(updateUserDto.getPlotNo());
		}
		if (updateUserDto.getState() != null) {
			user.setState(updateUserDto.getState());
		}
		if (updateUserDto.getStreeNo() != null) {
			user.setStreeNo(updateUserDto.getStreeNo());
		}
		return user;
	}

	@Override
	public String deleteUserRecord(Integer userId) throws Exception {
		userDao.deleteUserByEmail(userId);
		return Constants.USER_DETAILS_DELETED;
	}

	@Override
	public String updatePassword(UserDto updateUserDto) throws Exception {
		int response = userDao.updatePassword(updateUserDto.getEmailId(), updateUserDto.getPassword());
		if (response < 0) {
			return Constants.PASSWORD_NOT_UPDATED;
		}
		emailService.sendEmailNotification(updateUserDto);
		return Constants.PASSWORD_CHANGED;
	}

	@Override
	public User getUser(Integer userId) throws Exception {
		Optional<User> response = userDao.getUserDetails(userId);
		return response.get();
	}

	@Override
	public List<User> searchUsersByKey(String searchValue) {
		List<User> users = userDao.searchUsers(searchValue);
		System.out.println(users);
		return users;
	}

}
