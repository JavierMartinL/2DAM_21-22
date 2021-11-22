package es.iespuertodelacruz.javier.javierexamen1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import es.iespuertodelacruz.javier.javierexamen1.contract.EmpleadoEntry;
import es.iespuertodelacruz.javier.javierexamen1.model.Empleado;
import es.iespuertodelacruz.javier.javierexamen1.utils.GestorDDBB;

public class EmpleadoDAO implements CRUD<Empleado, Integer> {

	GestorDDBB gdb;
	
	public EmpleadoDAO(GestorDDBB gdb) {
		this.gdb = gdb;
	}
	
	@Override
	public List<Empleado> findAll() {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>(); 
		
		String sql = "SELECT * FROM empleados";
		
		try (
				Connection conexion = gdb.getConnection();
				PreparedStatement ps = conexion.prepareStatement(sql)
			) {
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				int id = result.getInt(EmpleadoEntry.COLUMN_ID);
				String nombre = result.getString(EmpleadoEntry.COLUMN_NOMBRE);
				String apellidos = result.getString(EmpleadoEntry.COLUMN_APELLIDOS);
				Date fechaContrato = new Date(result.getLong(EmpleadoEntry.COLUMN_FECHA_CONTRATO));
				int idJefe = result.getInt(EmpleadoEntry.COLUMN_JEFE);
				int numero = result.getInt(EmpleadoEntry.COLUMN_NUMERO);
				String calle = result.getString(EmpleadoEntry.COLUMN_CALLE);
				String municipio = result.getString(EmpleadoEntry.COLUMN_MUNICIPIO);
				
				Empleado jefe = findById(idJefe);
				
				Empleado empleado = new Empleado(id, nombre, apellidos, fechaContrato, numero, calle, municipio, jefe);
				
				empleados.add(empleado);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}			
		
		return empleados;
	}

	@Override
	public Empleado findById(Integer id) {
		Empleado empleado = null;

		String sql = "SELECT * FROM empleados WHERE id = ?";
		
		try (
				Connection conexion = gdb.getConnection();
				PreparedStatement ps = conexion.prepareStatement(sql)
			) {
			ps.setInt(1, id);
			
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				int idEmpleado = result.getInt(EmpleadoEntry.COLUMN_ID);
				String nombre = result.getString(EmpleadoEntry.COLUMN_NOMBRE);
				String apellidos = result.getString(EmpleadoEntry.COLUMN_APELLIDOS);
				Date fechaContrato = new Date(result.getLong(EmpleadoEntry.COLUMN_FECHA_CONTRATO));
				int idJefe = result.getInt(EmpleadoEntry.COLUMN_JEFE);
				int numero = result.getInt(EmpleadoEntry.COLUMN_NUMERO);
				String calle = result.getString(EmpleadoEntry.COLUMN_CALLE);
				String municipio = result.getString(EmpleadoEntry.COLUMN_MUNICIPIO);
				
				Empleado jefe = findById(idJefe);
				
				empleado = new Empleado(idEmpleado, nombre, apellidos, fechaContrato, numero, calle, municipio, jefe);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return empleado;
	}

	@Override
	public Empleado save(Empleado obj) {
		Empleado empleado = null;
		Empleado jefe = findById(obj.getJefe().getId());
		
		if (jefe != null) {
			String sql = "INSERT INTO empleados(id, nombre, apellidos, fecha_contrato, jefe, numero, calle, municipio) "
					+ "VALUES (?,?,?,?,?,?,?,?)";
			
			try (
					Connection conexion = gdb.getConnection();
					PreparedStatement ps = conexion.prepareStatement(sql)
				) {
				ps.setInt(1, obj.getId());
				ps.setString(2, obj.getNombre());
				ps.setString(3, obj.getApellidos());
				ps.setLong(4, obj.getFecha_contrato().getTime());
				ps.setInt(5, jefe.getId());
				ps.setInt(6, obj.getNumero());
				ps.setString(7, obj.getCalle());
				ps.setString(8, obj.getMunicipio());
				
				boolean saveOk = ps.executeUpdate() > 0;
				
				if (saveOk) {
					empleado = new Empleado(obj.getId(), obj.getNombre(), obj.getApellidos(), obj.getFecha_contrato(), obj.getNumero(), obj.getCalle(), obj.getMunicipio(), jefe);
				}
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			
		}
		
		return empleado;
	}

	@Override
	public boolean update(Empleado obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}