package org.dao.sreport;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelo.sreport.SReport;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class DaoSReport {

	@SessionTarget
	private Session session;
	@TransactionTarget
	private Transaction transaction;

	public void agregarSReport(SReport sreport) {
		try {
			session.save(sreport);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			transaction.rollback();
		}

	}

}
