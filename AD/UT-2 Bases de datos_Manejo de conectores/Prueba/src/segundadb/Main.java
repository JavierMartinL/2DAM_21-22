package segundadb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import segundadb.utils.GestorBaseDatos;
import segundadb.utils.models.GestorLapices;
import segundadb.utils.models.Lapiz;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		GestorBaseDatos gbd = new GestorBaseDatos("oficina", "root", "1q2w3e4r");
		
		GestorLapices gl = new GestorLapices(gbd);
		
		
		ArrayList<Lapiz> lapices = (ArrayList<Lapiz>) gl.leerTodo();
		
		lapices.forEach(System.out::println);
		
		ArrayList<Lapiz> lapices2 = (ArrayList<Lapiz>) gl.readByName("alpino");
		
		lapices2.forEach(System.out::println);
		
	}
}
