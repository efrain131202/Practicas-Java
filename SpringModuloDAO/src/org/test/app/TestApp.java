package org.test.app;

import java.util.List;

import org.dao.sregion.DaoImpl;
import org.modelo.sregion.S_Region;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	public static void insertS_Region() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
			dao.insertS_Region(new S_Region(25,"TAMAULIPAS"));
		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
		}
	}
	
	public static void updateS_Region() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
			dao.updateS_Region(new S_Region("TAMAULIPAS MX",25));
		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
		}
	}
	
	public static void deleteS_Region() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
			dao.deleteS_Region(new S_Region(25));
		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
		}
	}
	
	public static void selectAllS_Region() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
			List<S_Region> list = dao.selectAllS_Region();
			for(S_Region x : list) {
				System.out.println(x.getId()+","+x.getName());
			}
		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
		}
	}
	
	public static void selectByIdS_Region() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
			S_Region region = dao.selectByIDS_Region(7);
			System.out.println(region.getId()+","+region.getName());
		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
		}
	}
	
	public static void createTableSupervisor() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl dao = context.getBean("daoImpl",DaoImpl.class);
			dao.createTableSupervisor();
		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		//insertS_Region();
		//updateS_Region();
		//deleteS_Region();
		//selectAllS_Region();
		//selectByIdS_Region();
		createTableSupervisor();
	}
	
}
