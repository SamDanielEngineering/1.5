package com.project1.dao;

import com.project1.model.Reimbursement;
import com.project1.util.InitializeUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Purpose of this Dao is to send/retrieve info about a reimbursement
 * to/from the database. It then returns the composed Reimbursement Object.
 */
public class ReimbursementDao implements GenericDao<Reimbursement> {
	private static final Logger LOGGER = Logger.getLogger(ReimbursementDao.class);
	
	private Reimbursement objectConstructor(ResultSet rs) throws SQLException {
		return new Reimbursement(rs.getInt(1), rs.getFloat(2), rs.getTimestamp(3), rs.getTimestamp(4),
							rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
	}


	@Override
	public List<Reimbursement> getList() {
		List<Reimbursement> l = new ArrayList<Reimbursement>();

		InitializeUtil temp = new InitializeUtil();
		Session session = temp.init();

		Transaction tx = session.beginTransaction();
		l = session.createQuery("FROM Reimbursement").list();
		tx.commit();

		return l;
	}

	@Override
	public Reimbursement getById(int id) {
		Reimbursement r = null;

		InitializeUtil temp = new InitializeUtil();
		Session session = temp.init();

		Transaction tx = session.beginTransaction();
		r = session.get(Reimbursement.class, id);
		tx.commit();

		return r;
	}

	@Override
	public List<Reimbursement> getByUserId(int id) {
		List<Reimbursement> l = new ArrayList<Reimbursement>();

		InitializeUtil temp = new InitializeUtil();
		Session session = temp.init();

		Transaction tx = session.beginTransaction();
		l = session.createQuery("FROM Reimbursement WHERE id=" + id).list();
		tx.commit();

		System.out.println(l.toString());
		return l;
	}

	public Reimbursement getByUsername(String username) {
		//Empty. Reason - No use.

		return null;
	}

	@Override
	public void insert(Reimbursement r) {
		InitializeUtil temp = new InitializeUtil();
		Session session = temp.init();

		Transaction tx = session.beginTransaction();
		session.save(r);
		tx.commit();
	}

	public void updateList(int[][] i, int resolver) {

//		try(Connection c = ConnectionUtil.getInstance().getConnection()) {
//			String aSql = "SELECT acceptarray(?, ?)";
//			String dSql = "SELECT denyarray(?, ?)";
//
//			//Convert both of our int arrays to an Integer object
//			Integer[] a = Arrays.stream(i[0]).boxed().toArray(Integer[]::new);
//			Integer[] d = Arrays.stream(i[1]).boxed().toArray(Integer[]::new);
//
//			//Convert both of our Integer arrays into something useful for SQL.
//			Array aArray = c.createArrayOf("INTEGER", a);
//			Array dArray = c.createArrayOf("INTEGER", d);
//
//			//Perform our SQL calls
//			CallableStatement cs = c.prepareCall(aSql);
//			cs.setArray(1, aArray);
//			cs.setInt(2, resolver);
//			cs.execute();
//			cs.closeOnCompletion();
//
//			cs = c.prepareCall(dSql);
//			cs.setArray(1, dArray);
//			cs.setInt(2, resolver);
//			cs.execute();
//			cs.closeOnCompletion();
//
//			//This section is just for the sake of logging.
//			int totalCount = 0;
//			for(int co = 0; co < a.length; co++) {
//				if (a[co] != -1) {
//					totalCount++;
//				}
//				if (d[co] != -1) {
//					totalCount++;
//				}
//			}
//			LOGGER.debug(totalCount + " reimbursement" + ((totalCount != 1) ? "s" : "") + " modified by user ID " + resolver + ".");
//		} catch (SQLException e) {
//			LOGGER.error("An attempt to accept/deny reimbursements by user ID " + resolver + " from the database failed.");
//			e.printStackTrace();
//		}
	}

	@Override
	public void delete(Reimbursement r) {
		InitializeUtil temp = new InitializeUtil();
		Session session = temp.init();

		Transaction tx = session.beginTransaction();
		session.delete(r);
		tx.commit();
	}
	
}
