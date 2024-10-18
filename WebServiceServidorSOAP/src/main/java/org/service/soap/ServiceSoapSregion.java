package org.service.soap;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ServiceSoapSregion {
	
	static Connection connection;
    static String driver = "oracle.jdbc.driver.OracleDriver";
    static String URL = "jdbc:oracle:thin:@localhost:1521:xe";

    @WebMethod
    public static void connectDataBase() throws IOException, SQLException {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(URL);
            System.out.println("Cargo driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        }
    }

    @WebMethod
    public static String agregarS_Region(int id, String name) throws IOException, SQLException {
        try {
            connectDataBase();
            String sql = "INSERT INTO S_REGION (ID, NAME) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
            System.out.println("Agrego el registro: " + id + "," + name);
        } catch (SQLException e) {
            System.out.println("Error al agregar: " + e.getMessage());
        }
		return name;
    }

    @WebMethod
    public static String actualizar_region(String name, int id) throws IOException, SQLException{
        try {
            connectDataBase();
            String sql = "UPDATE S_REGION SET NAME = ? WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Modifico los datos: " + id + "," + name);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
		return name;
    }

    @WebMethod
    public static String eliminar_Region(int id) throws IOException, SQLException {
        try {
            connectDataBase();
            String sql = "DELETE FROM S_REGION WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Elimino el registro: " + id);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
		return URL;
    }

    @WebMethod
    public static String selectById_region(int id) throws IOException, SQLException {
        try {
            connectDataBase();
            String sql = "SELECT * FROM S_REGION WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getInt("id") + "," + rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
		return URL;
    }

}
