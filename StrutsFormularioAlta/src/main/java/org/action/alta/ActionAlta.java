package org.action.alta;

import org.dao.usercap.DaoUsercap;
import org.modelo.usercap.Usercap;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ActionAlta extends ActionSupport implements ModelDriven<Usercap> {

	private Usercap usercap = new Usercap();
	private DaoUsercap dao = new DaoUsercap();

	public String execute() {
		return SUCCESS;
	}

	public String add() {
		dao.agregarUsercap(usercap);
		return SUCCESS;
	}

	@Override
	public Usercap getModel() {
		// TODO Auto-generated method stub
		return usercap;
	}

}
