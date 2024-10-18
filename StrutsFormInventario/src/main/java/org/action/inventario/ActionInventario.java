package org.action.inventario;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dao.inventario.DaoImpInventario;
import org.dao.inventario.DaoInventario;
import org.modelo.inventario.Inventario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ActionInventario extends ActionSupport implements ModelDriven<Inventario> {
	
	private Inventario inventario = new Inventario();
	private DaoInventario dao = new DaoImpInventario();
	private List<Inventario> inventarios = new ArrayList<Inventario>();
	
	public String execute() {
		return SUCCESS;
	}
	
	public String list() {
		setInventarios(dao.listInventarios());
		return SUCCESS;
	}

	public String add() {
		dao.addInventario(inventario);
		return SUCCESS;
	}
	
	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		inventario = dao.getInventarioById(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String delete() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		dao.deleteInventario(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}
	
	@Override
	public Inventario getModel() {
		return inventario;
	}
	
	public Inventario getInventario() {
		return inventario;
	}
	
	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}
	
	public List<Inventario> getInventarios(){
		return inventarios;
	}
	
	public void setInventarios(List<Inventario> inventarios) {
		this.inventarios = inventarios;
		
	}

}
