package org.action.alta;

import org.dao.sreport.DaoSReport;
import org.modelo.sreport.SReport;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ActionAlta extends ActionSupport implements ModelDriven<SReport> {

	private SReport sreport = new SReport();
	private DaoSReport dao = new DaoSReport();

	public String execute() {
		return SUCCESS;
	}

	public String add() {
		dao.agregarSReport(sreport);
		return SUCCESS;
	}

	@Override
	public SReport getModel() {
		// TODO Auto-generated method stub
		return sreport;
	}
}