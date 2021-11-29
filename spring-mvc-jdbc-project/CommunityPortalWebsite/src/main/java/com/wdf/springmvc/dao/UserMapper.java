package com.wdf.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wdf.springmvc.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User user = new User();
		user.setUserId(rs.getInt("user_id"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setGender(rs.getString("gender"));
		user.setMobileNumber(rs.getLong("mobile_number"));
		user.setEmailId(rs.getString("email_id"));
		user.setRole(rs.getString("user_role"));
		user.setPlotNo(rs.getString("plot_no"));
		user.setStreeNo(rs.getString("street_no"));
		user.setColonyName(rs.getString("colony_name"));
		user.setCity(rs.getString("city"));
		user.setState(rs.getString("state"));
		user.setCountry(rs.getString("country"));
		user.setCompanyName(rs.getString("company_name"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}
