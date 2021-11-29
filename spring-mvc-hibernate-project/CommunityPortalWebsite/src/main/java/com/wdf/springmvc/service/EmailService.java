package com.wdf.springmvc.service;

import com.wdf.springmvc.dto.UserDto;
import com.wdf.springmvc.model.User;

public interface EmailService {

	void sendEmail(User user);

	void sendEmailNotification(UserDto updateUserDto);

}
