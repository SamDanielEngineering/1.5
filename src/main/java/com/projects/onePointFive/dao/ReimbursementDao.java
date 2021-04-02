package com.projects.onePointFive.dao;

import com.projects.onePointFive.model.Reimbursement;
import com.projects.onePointFive.util.InitializeUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Purpose of this Dao is to send/retrieve info about a reimbursement
 * to/from the database. It then returns the composed Reimbursement Object.
 */
public class ReimbursementDao implements GenericDao<Reimbursement> {
	private static final Logger LOGGER = Logger.getLogger(ReimbursementDao.class);

	private InitializeUtil temp = new InitializeUtil();
	private Session session = temp.init();

	private Reimbursement objectConstructor(ResultSet rs) throws SQLException {
		return new Reimbursement(rs.getInt(1), rs.getFloat(2), rs.getTimestamp(3), rs.getTimestamp(4),
							rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
	}


	@Override
	public List<Reimbursement> getList() {
		List<Reimbursement> l = new ArrayList<Reimbursement>();

		Transaction tx = session.beginTransaction();
		l = session.createQuery("FROM Reimbursement").list();
		tx.commit();

		return l;
	}

	@Override
	public Reimbursement getById(int id) {
		Reimbursement r = null;

		Transaction tx = session.beginTransaction();
		r = session.get(Reimbursement.class, id);
		tx.commit();

		return r;
	}

	@Override
	public List<Reimbursement> getByUserId(int resolver) {
		List<Reimbursement> l = new ArrayList<Reimbursement>();

		Transaction tx = session.beginTransaction();
		l = session.createQuery("FROM Reimbursement WHERE resolver=" + resolver).list();
		tx.commit();

		System.out.println(l.toString());
		return l;
	}

	@Override
	@Deprecated
	public Reimbursement getByUsername(String username) {
		//NULL, USERS CAN MORE THAN ONE REIMBURSEMENT, THIS METHOD IS DEPRECATED.
		return null;
	}

	@Override
	public void insert(Reimbursement r) {
		Transaction tx = session.beginTransaction();
		session.save(r);
		tx.commit();
	}

	//TODO delete this?
	public void updateList(int[][] i, int resolver) {
		List<Integer> a = Arrays.stream(i[0]).boxed().collect( Collectors.toList());
		List<Integer> d = Arrays.stream(i[1]).boxed().collect( Collectors.toList());

		// not sure having accepted and denied their own arrays is necessary when
		// Reimbursement objects come with status codes

	}
	public void update(Reimbursement r, int resolver) {

		Transaction tx = session.beginTransaction();
		session.saveOrUpdate("FROM Reimbursement WHERE resolver=" + resolver + "AND id=" + r.getId());
		tx.commit();
	}

	@Override
	public void delete(Reimbursement r) {
		Transaction tx = session.beginTransaction();
		session.delete(r);
		tx.commit();
	}
	
}
