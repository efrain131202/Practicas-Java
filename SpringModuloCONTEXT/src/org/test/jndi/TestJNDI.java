package org.test.jndi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/*
 *JNDI: VAJA NAMING DIRECTORY INTERFACE:
 *PERMITE BUSCAR OBJETOS Y DB, A TRAVEZ DE UN NOMBRE 
 */

public class TestJNDI {
	
	public static void main(String[] args) {
		try {
			//CONEXION JDNI
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("jdbc/Oracle");
			Connection connection = dataSource.getConnection();
			
			//QUERY
			String sql = "SELECT * FROM S_REGION";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
				while(resultSet.next()) {
					System.out.println(resultSet.getInt("id")+","+resultSet.getString("name"));
				}
		} catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
		}
	}

}
