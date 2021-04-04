package com.projects.onePointFive.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.onePointFive.dao.ReimbursementDao;
import com.projects.onePointFive.model.Reimbursement;

public class ReimbursementService {
	private ReimbursementDao rd;
	private static final Logger LOGGER = Logger.getLogger(ReimbursementService.class);

	public ReimbursementService() {
		rd = new ReimbursementDao();
	}

	public void sendNewReimbursement(Reimbursement r) {
		rd.insert(r);
	}

	public List<Reimbursement> fetchAllReimbursements() {
		return rd.getList();
	}

	public List<Reimbursement> getReimbursementsByUserID(int id) {
		return rd.getByUserId(id);
	}

	public void update(Reimbursement r, int id) { rd.update(r,id); }

	public void deleteReimbursement(int reimbursementID) {
		rd.delete(rd.getById(reimbursementID));
	}
}
