package segundadb.utils.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import segundadb.utils.GestorBaseDatos;

public class GestorLapices {
	
	GestorBaseDatos gbd;
	
	public GestorLapices(String database, String user, String password) {
		this.gbd = new GestorBaseDatos(database, user, password);
	}
	
	public GestorLapices(GestorBaseDatos gbd) {
		this.gbd = gbd;
	}
	
	public List<Lapiz> leerTodo()  {
		ArrayList<Lapiz> lapices = new ArrayList<Lapiz>();
		
		try (Connection connection = gbd.getConnection()) {
			
			Statement statement = connection.createStatement();
			String sql = "SELECT idlapiz, marca, numero FROM lapices";
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				
				int id = result.getInt("idlapiz");
				String marca = result.getString("marca");
				int numero = result.getInt("numero");
				
				lapices.add(new Lapiz(id, marca, numero));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lapices;
	}
	
}
