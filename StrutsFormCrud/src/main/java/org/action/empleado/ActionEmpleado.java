package org.action.empleado;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dao.empleado.DaoEmpleado;
import org.dao.empleado.DaoImplEmpleado;
import org.modelo.empleado.Empleado;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ActionEmpleado extends ActionSupport implements ModelDriven<Empleado> {

	private Empleado empleado = new Empleado();
	private DaoEmpleado dao = new DaoImplEmpleado();
	private List<Empleado> empleados = new ArrayList<Empleado>();

	public String execute() {
		return SUCCESS;
	}

	public String list() {
		setEmpleados(dao.listEmpleados());
		return SUCCESS;
	}

	public String add() {
		dao.addEmpleado(empleado);
		return SUCCESS;
	}

	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		empleado = dao.getEmpleadoById(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}

	public String delete() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		dao.deleteEmpleado(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}

	@Override
	public Empleado getModel() {
		// TODO Auto-generated method stub
		return empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

}
