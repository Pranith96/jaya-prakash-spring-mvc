package com.wdf.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.wdf.springmvc.dto.UserDto;
import com.wdf.springmvc.model.User;
import com.wdf.springmvc.util.Constants;

@Repository
public class UserDaoImplementation implements UserDao {

	@Autowired
	JdbcTemplate template;

	@Override
	public String saveUser(User user) {
		String insertQuery = "Insert into user(first_name,last_name,gender,mobile_number,email_id,user_role,plot_no,street_no,colony_name,city,state,country,company_name,password)  values('"
				+ user.getFirstName() + "','" + user.getLastName() + "','" + user.getGender() + "','"
				+ user.getMobileNumber() + "','" + user.getEmailId() + "','" + user.getRole() + "','" + user.getPlotNo()
				+ "','" + user.getStreeNo() + "','" + user.getColonyName() + "','" + user.getCity() + "','"
				+ user.getState() + "','" + user.getCountry() + "','" + user.getCompanyName() + "','"
				+ user.getPassword() + "');";
		template.update(insertQuery);
		return Constants.USER_DETAILS_SAVED;
	}

	@Override
	public User login(UserDto loginDto) {
		String selectQuery = "Select * from user where email_id = '" + loginDto.getEmailId() + "' and password = '"
				+ loginDto.getPassword() + "';";
		User response = template.query(selectQuery, new ResultSetExtractor<User>() {
			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
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
				return null;
			}

		});
		System.out.println(response);
		return response;
	}

	@Override
	public List<User> fetchAllUsers() {
		String selectQuery = "Select * from user";
		List<User> data = template.query(selectQuery, new UserMapper());
		return data;
	}

	@Override
	public User findUserByEmailId(String emailId) {
		String selectQuery = "Select * from user where email_id = '" + emailId + "';";
		User response = template.query(selectQuery, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
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
				return null;
			}

		});
		return response;
	}

	@Override
	public int updatePassword(String emailId, String newPassword) {
		String updateQuery = "update user set password = '" + newPassword + "' where email_id = '" + emailId + "'";
		int i = template.update(updateQuery);
		return i;
	}

	@Override
	public String updateUser(User user) {
		String updateQuery = "update user set first_name = '" + user.getFirstName() + "', last_name= '"
				+ user.getLastName() + "', gender = '" + user.getGender() + "',mobile_number = '"
				+ user.getMobileNumber() + "',plot_no = '" + user.getPlotNo() + "',street_no = '" + user.getStreeNo()
				+ "',colony_name = '" + user.getColonyName() + "',city = '" + user.getCity() + "',state = '"
				+ user.getState() + "',country = '" + user.getCountry() + "',company_name = '" + user.getCompanyName()
				+ "' where email_id = '" + user.getEmailId() + "'";
		int i = template.update(updateQuery);
		if (i > 0) {
			return Constants.USER_DETAILS_UPDATED;
		}
		return Constants.USER_DETAILS_NOT_UPDATED;
	}

	@Override
	public void deleteUserByEmail(Integer userId) {
		String deleteQuery = "delete from user where user_id='" + userId + "'";
		template.update(deleteQuery);
	}

	@Override
	public User getUserDetails(Integer userId) {
		String selectQuery = "Select * from user where user_id = '" + userId + "';";
		User response = template.query(selectQuery, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
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
				return null;
			}

		});
		return response;
	}

	@Override
	public List<User> searchUsers(String searchValue) {
		String selectQuery = "Select * from user where '" + searchValue
				+ "' IN(first_name, last_name, company_name, city, country, state)";
		List<User> data = template.query(selectQuery, new UserMapper());
		return data;
	}

}
