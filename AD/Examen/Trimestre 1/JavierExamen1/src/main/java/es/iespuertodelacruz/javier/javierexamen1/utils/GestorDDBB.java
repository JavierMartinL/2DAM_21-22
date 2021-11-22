package es.iespuertodelacruz.javier.javierexamen1.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class GestorDDBB {
	
	private String database;
	private String user;
	private String password;
	
	BasicDataSource basicDataSource;
	
	public GestorDDBB(String database, String user, String password) {
		this.database = "jdbc:mysql://localhost/" + database + "?serverTimezone=UTC";
		this.user = user;
		this.password = password;
		
		cargarDriverMysql();
		
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl(this.database);
		basicDataSource.setUsername(this.user);
		basicDataSource.setPassword(this.password);
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
		
		synchronized (basicDataSource) {
			try {
				conexion = basicDataSource.getConnection();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return conexion;
	}
}
