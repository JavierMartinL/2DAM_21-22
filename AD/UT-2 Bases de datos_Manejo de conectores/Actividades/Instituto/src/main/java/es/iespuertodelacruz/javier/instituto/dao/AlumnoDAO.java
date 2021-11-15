package es.iespuertodelacruz.javier.instituto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.iespuertodelacruz.javier.instituto.contract.AlumnoEntry;
import es.iespuertodelacruz.javier.instituto.model.Alumno;
import es.iespuertodelacruz.javier.instituto.utils.GestorDDBB;
import jdk.internal.org.objectweb.asm.Type;

public class AlumnoDAO implements CRUD<Alumno, String> {

	GestorDDBB gdb;
	
	public AlumnoDAO(GestorDDBB gdb) {
		this.gdb = gdb;
	}

	@Override
	public Alumno findById(String id) {
		Alumno alumno = null;

		String sql = "SELECT "
				+ AlumnoEntry.COLUMN_DNI + ", "
				+ AlumnoEntry.COLUMN_NOMBRE + ", "
				+ AlumnoEntry.COLUMN_APELLIDOS + ", "
				+ AlumnoEntry.COLUMN_FECHA_NACIMIENTO + " FROM "
				+ AlumnoEntry.TABLE_NAME + " WHERE "
				+ AlumnoEntry.COLUMN_DNI + " = ?";
		
		try (
				Connection conexion = gdb.getConnection();
				PreparedStatement ps = conexion.prepareStatement(sql)
			) {
			ps.setString(1, id);
			
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				String dni = result.getString(AlumnoEntry.COLUMN_DNI);
				String nombre = result.getString(AlumnoEntry.COLUMN_NOMBRE);
				String apellidos = result.getString(AlumnoEntry.COLUMN_APELLIDOS);
				Long fecha = result.getLong(AlumnoEntry.COLUMN_FECHA_NACIMIENTO);

				alumno = new Alumno();
				alumno.setDni(dni);
				alumno.setNombre(nombre);
				alumno.setApellidos(apellidos);

				if (fecha > 0) {
					Date fechaNacimiento = new Date(fecha);
					alumno.setFechaNacimiento(fechaNacimiento);
				}

			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return alumno;
	}

	public List<Alumno> findByName(String nombreBusqueda) {
		ArrayList<Alumno> alumnos = new ArrayList<>();

		String sql = "SELECT "
				+ AlumnoEntry.COLUMN_DNI + ", "
				+ AlumnoEntry.COLUMN_NOMBRE + ", "
				+ AlumnoEntry.COLUMN_APELLIDOS + ", "
				+ AlumnoEntry.COLUMN_FECHA_NACIMIENTO + " FROM "
				+ AlumnoEntry.TABLE_NAME + " WHERE "
				+ AlumnoEntry.COLUMN_NOMBRE + " LIKE ?";

		try (
				Connection conexion = gdb.getConnection();
				PreparedStatement ps = conexion.prepareStatement(sql)
			) {
			ps.setString(1, "%" + nombreBusqueda + "%");

			ResultSet result = ps.executeQuery();

			while (result.next()) {
				String dni = result.getString(AlumnoEntry.COLUMN_DNI);
				String nombre = result.getString(AlumnoEntry.COLUMN_NOMBRE);
				String apellidos = result.getString(AlumnoEntry.COLUMN_APELLIDOS);
				Long fecha = result.getLong(AlumnoEntry.COLUMN_FECHA_NACIMIENTO);

				Alumno alumno = new Alumno();
				alumno.setDni(dni);
				alumno.setNombre(nombre);
				alumno.setApellidos(apellidos);

				if (fecha > 0) {
					Date fechaNacimiento = new Date(fecha);
					alumno.setFechaNacimiento(fechaNacimiento);
				}

				alumnos.add(alumno);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return alumnos;
	}

	public List<Alumno> findByAsignaturaAnio(Integer idAsignatura, int anio) {
		ArrayList<Alumno> alumnos = new ArrayList<>();

		String sql = "SELECT alumnos.dni, alumnos.nombre, alumnos.apellidos, alumnos.fechanacimiento FROM alumnos " +
				"INNER JOIN matriculas ON alumnos.dni = matriculas.dni " +
				"INNER JOIN asignatura_matricula on matriculas.idmatricula = asignatura_matricula.idmatricula " +
				"INNER JOIN asignaturas on asignatura_matricula.idasignatura = asignaturas.idasignatura " +
				"WHERE matriculas.year = ? AND asignaturas.idasignatura = ?";

		try (
				Connection conexion = gdb.getConnection();
				PreparedStatement ps = conexion.prepareStatement(sql)
			) {
			ps.setInt(1, anio);
			ps.setInt(2, idAsignatura);

			ResultSet result = ps.executeQuery();

			while (result.next()) {
				String dni = result.getString("alumnos.dni");
				String nombre = result.getString("alumnos.nombre");
				String apellidos = result.getString("alumnos.apellidos");
				Long fecha = result.getLong("alumnos.fechanacimiento");

				Alumno alumno = new Alumno();
				alumno.setDni(dni);
				alumno.setNombre(nombre);
				alumno.setApellidos(apellidos);

				if (fecha > 0) {
					Date fechaNacimiento = new Date(fecha);
					alumno.setFechaNacimiento(fechaNacimiento);
				}

				alumnos.add(alumno);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return alumnos;
	}

	@Override
	public List<Alumno> findAll() {
		ArrayList<Alumno> alumnos = new ArrayList<>();

		String sql = "SELECT "
				+ AlumnoEntry.COLUMN_DNI + ", "
				+ AlumnoEntry.COLUMN_NOMBRE + ", "
				+ AlumnoEntry.COLUMN_APELLIDOS + ", "
				+ AlumnoEntry.COLUMN_FECHA_NACIMIENTO + " FROM "
				+ AlumnoEntry.TABLE_NAME;
		
		try (
				Connection conexion = gdb.getConnection();
				PreparedStatement ps = conexion.prepareStatement(sql)
			) {
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				String dni = result.getString(AlumnoEntry.COLUMN_DNI);
				String nombre = result.getString(AlumnoEntry.COLUMN_NOMBRE);
				String apellidos = result.getString(AlumnoEntry.COLUMN_APELLIDOS);
				Long fecha = result.getLong(AlumnoEntry.COLUMN_FECHA_NACIMIENTO);

				Alumno alumno = new Alumno();
				alumno.setDni(dni);
				alumno.setNombre(nombre);
				alumno.setApellidos(apellidos);

				if (fecha > 0) {
					Date fechaNacimiento = new Date(fecha);
					new Date();
					alumno.setFechaNacimiento(fechaNacimiento);
				}

				alumnos.add(alumno);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return alumnos;
	}

	@Override
	public Alumno save(Alumno obj) {
		Alumno alumno = null;

		String sql = "INSERT INTO "
				+ AlumnoEntry.TABLE_NAME + " ("
				+ AlumnoEntry.COLUMN_DNI + ", "
				+ AlumnoEntry.COLUMN_NOMBRE + ", "
				+ AlumnoEntry.COLUMN_APELLIDOS + ", "
				+ AlumnoEntry.COLUMN_FECHA_NACIMIENTO + ") " +
				"VALUES (?, ?, ?, ?)";

	    try (
				Connection conexion = gdb.getConnection();
				PreparedStatement ps = conexion.prepareStatement(sql)
			) {
			ps.setString(1, obj.getDni());
			ps.setString(2, obj.getNombre());
			ps.setString(3, obj.getApellidos());

			if (obj.getFechaNacimiento() != null) {
				ps.setLong(4, obj.getFechaNacimiento().getTime());
			} else {
				ps.setNull(4, Type.LONG);
			}

			boolean agregarOK = ps.executeUpdate() > 0;

			if (agregarOK) {
				alumno = obj;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return alumno;
	}

	@Override
	public boolean update(Alumno obj) {
		boolean updateOK;

		String sql = "UPDATE "
				+ AlumnoEntry.TABLE_NAME + " SET "
				+ AlumnoEntry.COLUMN_NOMBRE + " = ?, "
				+ AlumnoEntry.COLUMN_APELLIDOS + " = ?, "
				+ AlumnoEntry.COLUMN_FECHA_NACIMIENTO + " = ? WHERE "
				+ AlumnoEntry.COLUMN_DNI + " = ?";

		try (
				Connection conexion = gdb.getConnection();
				PreparedStatement ps = conexion.prepareStatement(sql)
			){
			ps.setString(1, obj.getNombre());
			ps.setString(2, obj.getApellidos());

			if (obj.getFechaNacimiento() != null) {
				ps.setLong(3, obj.getFechaNacimiento().getTime());
			} else {
				ps.setNull(3, Type.LONG);
			}

			ps.setString(4, obj.getDni());

			updateOK = ps.executeUpdate() > 0;

		} catch (SQLException ex) {
			ex.printStackTrace();
			updateOK = false;
		}

		return updateOK;
	}

	@Override
	public boolean delete(String id) {
		boolean deleteOK;

		String sql = "DELETE FROM "
				+ AlumnoEntry.TABLE_NAME + " WHERE "
				+ AlumnoEntry.COLUMN_DNI + " = ?";

		try (
				Connection conexion = gdb.getConnection();
				PreparedStatement ps = conexion.prepareStatement(sql)
		){
			ps.setString(1, id);

			deleteOK = ps.executeUpdate() > 0;

		} catch (SQLException ex) {
			ex.printStackTrace();
			deleteOK = false;
		}

		return deleteOK;
	}

}
