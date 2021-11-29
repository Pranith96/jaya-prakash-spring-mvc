package com.wdf.springmvc.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wdf.springmvc.dto.UserDto;
import com.wdf.springmvc.model.User;
import com.wdf.springmvc.util.Constants;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String saveUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.save(user);
		t.commit();
		return Constants.USER_DETAILS_SAVED;
	}

	@Override
	public Optional<User> login(UserDto loginDto) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from User where emailId = :emailId and password = :password");
		query.setParameter("emailId", loginDto.getEmailId());
		query.setParameter("password", loginDto.getPassword());
		Optional<User> user = query.uniqueResultOptional();
		t.commit();
		session.close();
		return user;
	}

	@Override
	public List<User> fetchAllUsers() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> users = query.list();
		t.commit();
		session.close();
		return users;
	}

	@Override
	public Optional<User> findUserByEmailId(String emailId) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from User where emailId = :emailId");
		query.setParameter("emailId", emailId);
		Optional<User> user = query.uniqueResultOptional();
		t.commit();
		session.close();
		return user;
	}

	@Override
	public int updatePassword(String emailId, String newPassword) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("update User set password=:password where emailId = :emailId");
		query.setParameter("password", newPassword);
		query.setParameter("emailId", emailId);
		int i = query.executeUpdate();
		t.commit();
		session.close();
		return i;
	}

	@Override
	public String updateUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.saveOrUpdate(user);
		t.commit();
		return Constants.USER_DETAILS_UPDATED;
	}

	@Override
	public void deleteUserByEmail(Integer userId) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		User user = session.load(User.class, new Integer(userId));
		if (user != null) {
			session.delete(user);
		}
		t.commit();
		session.close();
	}

	@Override
	public Optional<User> getUserDetails(Integer userId) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from User where userId = :userId");
		query.setParameter("userId", userId);
		Optional<User> user = query.uniqueResultOptional();
		t.commit();
		session.close();
		return user;
	}

	@Override
	public List<User> searchUsers(String searchValue) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery(
				"from User where :searchValue IN( firstName, lastName, companyName, city, country, state)");
		query.setParameter("searchValue", searchValue);
		List<User> users = query.list();
		t.commit();
		session.close();
		return users;
	}
}
