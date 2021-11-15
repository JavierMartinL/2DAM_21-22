package es.iespuertodelacruz.javier.dossierdb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorBaseDatos {
	
	private String database;
	private String user;
	private String password;
	
	public GestorBaseDatos(String database, String user, String password) {
		this.database = database;
		this.user = user;
		this.password = password;
		
		cargarDriverMysql();
	}
	
	private static void cargarDriverMysql() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.err.println("no carga el driver");
			System.exit(1);
		}
	}
	
	public Connection getConnection() {
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/" + database + "?serverTimezone=UTC", 
					user, 
					password
					);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return conexion;
	}
	
}
