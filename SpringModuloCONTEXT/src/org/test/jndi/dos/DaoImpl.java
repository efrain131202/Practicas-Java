package org.test.jndi.dos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 *EJEMPLO: INYECCION DE DEPENDENCIAS POR MEDIO DE LA NOTACION @AUTOWIRED
 *
 * DATASOURCE: FUENTE/ORIGEN DE DATOS (CONEXION A BD) {DRIVER,URL,USER,PASS}
 * 
 * @COMPONENT: CONVIERTE LA CLASE EN UN BEAN
 * 
 */

@Component
public class DaoImpl {

	@Autowired
	private DataSource dataSource;

	//GET AND SET OF DATASOURCE
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void selectAllS_Region() {
		Connection connection = null;
		try {
			//CONECCION A ORACLE
			connection = dataSource.getConnection();
			//QUERY SELECT
			String sql = "SELECT * FROM S_REGION";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rSet = ps.executeQuery();
			while (rSet.next()){
				System.out.println(rSet.getInt("id")+","+rSet.getString("name"));
			}
		} 
		catch (Exception e) {
			System.out.println("Exception: " +e.getMessage());
		}
	}
	
}
