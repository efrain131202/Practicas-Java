package org.dao.usercap;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelo.usercap.Usercap;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class DaoUsercap {
	
	@SessionTarget
	private Session session;
	@TransactionTarget
	private Transaction transaction;
	
	public void agregarUsercap(Usercap usercap) {
		try {
			session.save(usercap);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			transaction.rollback();
		}
		
	}

}
