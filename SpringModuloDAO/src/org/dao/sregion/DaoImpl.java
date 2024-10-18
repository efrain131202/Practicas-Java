package org.dao.sregion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.modelo.sregion.S_Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/*
 * JDBC TEMPLATE: PLANTILLA DE CONSULTAS QUE IMPLEMENTAN SQL.
 */

@Component
public class DaoImpl {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate template = new JdbcTemplate();
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	//REALIZAR INYECCION DE DEPENDENCIAS, ES DECIR, ASIGNAR A TEMPLATE EL DATASOURCE (CONEXION)
	@Autowired
	public void setDataSource(DataSource dataSource) {
		//ASIGNAR DATASOURCE A TEMPLATE
		this.template = new JdbcTemplate(dataSource);
	}
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	//QUERIES: INSERT, UPDATE, DELETE
	public void insertS_Region(S_Region region) {
		String sql = "INSERT INTO S_REGION (ID,NAME) VALUES (?,?)";
		template.update(sql,new Object[] {region.getId(), region.getName()});
	}
	public void updateS_Region(S_Region region) {
		String sql = "UPDATE S_REGION SET NAME = ? WHERE ID = ?";
		template.update(sql,new Object[] {region.getName(), region.getId()});
	}
	public void deleteS_Region(S_Region region) {
		String sql = "DELETE FROM S_REGION WHERE ID = ?";
		template.update(sql,new Object[] {region.getId()});
	}
	
	/*
	 * --------------------------------------------------------------------------------------
	 */
	
	//QUERIES: SELECT ALL, SELECT BY ID
	public static final class S_RegionMapper implements RowMapper<S_Region>{

		@Override
		public S_Region mapRow(ResultSet rs, int row) throws SQLException {
			S_Region region = new S_Region();
			region.setId(rs.getInt("id"));
			region.setName(rs.getString("name"));
			return region;
		}
		
	}
	
	public List<S_Region> selectAllS_Region(){
		String sql = "SELECT * FROM S_REGION";
		return template.query(sql, new S_RegionMapper());
	}
	
	public S_Region selectByIDS_Region(int id) {
		String sql = "SELECT * FROM S_REGION WHERE ID = ?";
		return template.queryForObject(sql, new Object[] {id}, new S_RegionMapper());
	}
	
	//QUERY: CREATE TABLE
	public void createTableSupervisor() {
		String sql = "CREATE TABLE SUPERVISOR("
				+ "ID 			NUMBER (10) NOT NULL,"
				+ "NOMBRE 		VARCHAR2 (55) NOT NULL,"
				+ "FECHA 		DATE,"	
				+ "SALARIO 		FLOAT (120) NOT NULL,"
				+ "COMENTARIO 	VARCHAR2 (255) NOT NULL,"
				+ "CONSTRAINT SUPERVISOR_PK PRIMARY KEY (ID))";
		template.execute(sql);
	}
	
}
