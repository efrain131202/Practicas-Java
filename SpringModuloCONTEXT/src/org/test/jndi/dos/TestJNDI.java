package org.test.jndi.dos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJNDI {
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl daoImpl = context.getBean("daoImpl",DaoImpl.class);
			daoImpl.selectAllS_Region();
		} 
		catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
		}
	}
}