package org.test.app;

import java.util.List;

import org.dao.sregion.DaoImpl;
import org.modelo.sregion.S_Region;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	public static void insertarS_Region() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl daoImpl = context.getBean("daoImpl", DaoImpl.class);
			S_Region region = new S_Region();
			region.setName("CULIACAN");
			daoImpl.addS_Region(region);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}

	}

	public static void eliminarS_Region() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl daoImpl = context.getBean("daoImpl", DaoImpl.class);
			S_Region region = new S_Region();
			region.setId(5);
			daoImpl.deleteS_Region(region);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}

	}

	public static void selectByIdS_Region() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl daoImpl = context.getBean("daoImpl", DaoImpl.class);
			S_Region region = daoImpl.getS_RegionById(3);
			System.out.println(region.getId() + "," + region.getName());
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}

	}

	public static void selectAllS_Region() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl daoImpl = context.getBean("daoImpl", DaoImpl.class);
			List<S_Region> regiones = daoImpl.selectAllS_Region();
			for (S_Region x : regiones) {
				System.out.println(x.getId() + "," + x.getName());
			}
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}

	}

	public static void main(String[] args) {
		// insertarS_Region();
		// eliminarS_Region();
		//selectByIdS_Region();
		selectAllS_Region();
	}
}
