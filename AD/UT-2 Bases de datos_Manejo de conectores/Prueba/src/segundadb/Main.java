package segundadb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import segundadb.utils.GestorBaseDatos;

public class Main {

	public static void main(String[] args) {
		
		GestorBaseDatos gbd = new GestorBaseDatos("oficina", "root", "1q2w3e4r");
		
		Connection conexion = gbd.getConnection();
		try {
			Statement st = conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
