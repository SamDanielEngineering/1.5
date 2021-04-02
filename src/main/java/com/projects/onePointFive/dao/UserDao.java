package com.projects.onePointFive.dao;

import java.util.ArrayList;
import java.util.List;

import com.projects.onePointFive.model.User;
import com.projects.onePointFive.util.InitializeUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * Purpose of this Dao is to send/retrieve info about a reimbursement
 * to/from the database. It then returns the composed Reimbursement Object.
 */
public class UserDao implements GenericDao <User> {
	private static final Logger LOGGER = Logger.getLogger(UserDao.class);

	private InitializeUtil temp = new InitializeUtil();
	private Session session = temp.init();



	@Override
	public List<User> getList() {
		List<User> l = new ArrayList<User>();

		Transaction tx = session.beginTransaction();
		l = session.createQuery("FROM User").list();
		tx.commit();

		return l;
	}

	@Override
	public User getById(int id) {
		User u = null;

		Transaction tx = session.beginTransaction();
		u = session.get(User.class, id);
		tx.commit();

		return u;
	}

	@Override
	public List<User> getByUserId(int id) {
		List<User> l = new ArrayList<User>();

		Transaction tx = session.beginTransaction();
		l = session.createQuery("FROM User WHERE id=" + id).list();
		tx.commit();

		return l;
	}

	@Override
	public User getByUsername(String username) {
		User u = null;

		Transaction tx = session.beginTransaction();
		u = session.get(User.class, username);
		tx.commit();

		return u;
	}

	@Override
	public void insert(User t) {
		Transaction tx = session.beginTransaction();
		session.save(t);
		tx.commit();
	}

	@Override
	public void delete(User t) {
		Transaction tx = session.beginTransaction();
		session.delete(t);
		tx.commit();
	}
}
