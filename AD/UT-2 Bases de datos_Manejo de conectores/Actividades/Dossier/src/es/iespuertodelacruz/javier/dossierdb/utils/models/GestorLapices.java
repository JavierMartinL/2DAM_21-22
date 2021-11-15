package es.iespuertodelacruz.javier.dossierdb.utils.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.iespuertodelacruz.javier.dossierdb.utils.GestorBaseDatos;

public class GestorLapices {

	GestorBaseDatos gbd;
	
	public GestorLapices(GestorBaseDatos gbd) {
		this.gbd = gbd;
	}
	
	public GestorLapices(String database, String user, String password) {
		this.gbd = new GestorBaseDatos(database, user, password);
	}
	
	public List<Lapiz> getAll() throws SQLException {
		ArrayList<Lapiz> lapices = new ArrayList<Lapiz>();
		String sql = "SELECT idlapiz, marca, numero FROM lapices";
		
		try (
				Connection connection = gbd.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
			) {
			
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				int id = result.getInt("idlapiz");
				String marca = result.getString("marca");
				int numero = result.getInt("numero");
				
				lapices.add(new Lapiz(id, marca, numero));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return lapices;
	}
	
	public Lapiz getById(int identificador) {
		Lapiz lapiz = null;
		String sql = "SELECT idlapiz, marca, numero FROM lapices WHERE idlapiz = ?";
		
		try (
				Connection connection = gbd.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
			) {
			
			ps.setInt(1, identificador);
			
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				int id = result.getInt("idlapiz");
				String marca = result.getString("marca");
				int numero = result.getInt("numero");
				
				lapiz = new Lapiz(id, marca, numero);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return lapiz;
	}
	
	public List<Lapiz> getByMarca(String marcaBusqueda) {
		ArrayList<Lapiz> lapices = new ArrayList<Lapiz>();
		String sql = "SELECT idlapiz, marca, numero FROM lapices WHERE marca like ?";
		
		try (
				Connection connection = gbd.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
			) {
			
			ps.setString(1, marcaBusqueda + "%");
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				int id = result.getInt("idlapiz");
				String marca = result.getString("marca");
				int numero = result.getInt("numero");
				
				lapices.add(new Lapiz(id, marca, numero));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return lapices;
	}
	
	public List<Lapiz> getByNumero(int num) {
		ArrayList<Lapiz> lapices = new ArrayList<Lapiz>();
		String sql = "SELECT idlapiz, marca, numero FROM lapices WHERE numero = ?";
		
		try (
				Connection connection = gbd.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
			) {
			
			ps.setInt(1, num);
			
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				int id = result.getInt("idlapiz");
				String marca = result.getString("marca");
				int numero = result.getInt("numero");
				
				lapices.add(new Lapiz(id, marca, numero));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return lapices;
	}
	
	public Lapiz save(Lapiz lapiz) {
		Lapiz nuevoLapiz = null;
		String sql = "INSERT INTO lapices (idlapiz, marca, numero) VALUES (?, ?, ?)";
		
		if (lapiz.getIdLapiz() < 1) {
			try (
					Connection connection = gbd.getConnection();
					PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				) {
					ps.setInt(1, lapiz.getIdLapiz());
					ps.setString(2, lapiz.getMarca());
					ps.setInt(3, lapiz.getNumero());
					
					ps.executeUpdate();
					
					ResultSet result = ps.getGeneratedKeys();
					
					while (result.next()) {
						nuevoLapiz = new Lapiz(
								result.getInt(1), 
								lapiz.getMarca(), 
								lapiz.getNumero());
					}
					
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		
		return nuevoLapiz;
	}
	
	public boolean actualizar(Lapiz lapiz) {
		String sql = "UPDATE lapices SET marca= ?, numero= ? WHERE idlapiz= ?";
		boolean ok = true;
		try (
				Connection connection = gbd.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
			) {
			ps.setString(1, lapiz.getMarca());
			ps.setInt(2, lapiz.getNumero());
			ps.setInt(3, lapiz.getIdLapiz());
			
			ok = ps.executeUpdate() > 0;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			ok = false;
		}
		return ok;
		
	}
	
	public void borrar(int idlapiz) {
		String sql = "DELETE FROM lapices WHERE idlapiz= ?";
		
		try (
				Connection connection = gbd.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
			) {
			ps.setInt(1, idlapiz);
			
			ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
