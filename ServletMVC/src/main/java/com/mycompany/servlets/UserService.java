package com.mycompany.servlets;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDAO userDao;

	public User authenticate(String email, String password) {
		User user = null;
		try {
			user = userDao.findByEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		if (user != null && user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}
	}

	public void register(User user) throws SQLException {
		userDao.save(user);
	}
}
