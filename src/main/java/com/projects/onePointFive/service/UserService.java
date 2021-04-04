package com.projects.onePointFive.service;

import com.projects.onePointFive.dao.UserDao;
import com.projects.onePointFive.model.User;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserService {
	private UserDao ud;
	private static final Logger LOGGER = Logger.getLogger(UserService.class);

	public UserService() {
		ud = new UserDao();
	}

	public List<User> fetchAllUsers() {
		return ud.getList();
	}

	public User getUserById(int id) {
		return ud.getById(id);
	}

	public boolean createUser(User u){
		if (u != null){
			ud.insert(u);
			return true;
		}

		return false;
	}

	public User getUserByUsername(String username) {
		User u = ud.getByUsername(username);
		return null;
	}

	public User getUserByLogin(String user, String pass) {
		User u = ud.getByUsernameAndPassword(user, pass);
		return u;
	}

	public void deleteUser(int userID){
		ud.delete(getUserById(userID));
	}
}
