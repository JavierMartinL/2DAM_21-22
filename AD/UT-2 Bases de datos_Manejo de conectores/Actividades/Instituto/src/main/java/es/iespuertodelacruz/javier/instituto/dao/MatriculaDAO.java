package es.iespuertodelacruz.javier.instituto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.iespuertodelacruz.javier.instituto.contract.MatriculaEntry;
import es.iespuertodelacruz.javier.instituto.model.Alumno;
import es.iespuertodelacruz.javier.instituto.model.Asignatura;
import es.iespuertodelacruz.javier.instituto.model.Matricula;
import es.iespuertodelacruz.javier.instituto.utils.GestorDDBB;

public class MatriculaDAO implements CRUD<Matricula, Integer> {

	GestorDDBB gdb;
	
	public MatriculaDAO(GestorDDBB gdb) {
		this.gdb = gdb;
	}
	
	@Override
	public Matricula findById(Integer id) {
		AlumnoDAO alumnoDao = new AlumnoDAO(gdb);
		AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gdb);
		Matricula matricula = null;

		String sqlMatricula = "SELECT "
				+ MatriculaEntry.COLUMN_ID + ", "
				+ MatriculaEntry.COLUMN_DNI + ", "
				+ MatriculaEntry.COLUMN_YEAR + " FROM "
				+ MatriculaEntry.TABLE_NAME + " WHERE "
				+ MatriculaEntry.COLUMN_ID + " = ?";
		
		String sqlAsignaturaMatricula = "SELECT idasignatura FROM asignatura_matricula WHERE idmatricula = ?";

		try (
				Connection conexion = gdb.getConnection();
				PreparedStatement psMatricula = conexion.prepareStatement(sqlMatricula);
				PreparedStatement psAsignaturaMatricula = conexion.prepareStatement(sqlAsignaturaMatricula);
		) {
			psMatricula.setInt(1, id);

			ResultSet result = psMatricula.executeQuery();

			while (result.next()) {
				int idmatricula = result.getInt(MatriculaEntry.COLUMN_ID);
				Alumno alumno = alumnoDao.findById(result.getString(MatriculaEntry.COLUMN_DNI));
				int year = result.getInt(MatriculaEntry.COLUMN_YEAR);

				ArrayList<Asignatura> asignaturas = new ArrayList<>();
				
				psAsignaturaMatricula.setInt(1, id);
				ResultSet resultAsignatura = psAsignaturaMatricula.executeQuery();
				
				while (resultAsignatura.next()) {
					asignaturas.add(asignaturaDAO.findById(resultAsignatura.getInt("idasignatura")));
				}
				
				matricula = new Matricula();
				matricula.setIdMatricula(idmatricula);
				matricula.setAlumno(alumno);
				matricula.setYear(year);
				matricula.setAsignaturas(asignaturas);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return matricula;
	}

	public List<Matricula> findByYear(int yearBusqueda) {
		AlumnoDAO alumnoDao = new AlumnoDAO(gdb);
		AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gdb);
		ArrayList<Matricula> matriculas = new ArrayList<>();

		String sqlMatricula = "SELECT "
				+ MatriculaEntry.COLUMN_ID + ", "
				+ MatriculaEntry.COLUMN_DNI + ", "
				+ MatriculaEntry.COLUMN_YEAR + " FROM "
				+ MatriculaEntry.TABLE_NAME + " WHERE "
				+ MatriculaEntry.COLUMN_YEAR + " = ?";

		String sqlAsignaturaMatricula = "SELECT idasignatura FROM asignatura_matricula WHERE idmatricula = ?";

		try (
				Connection conexion = gdb.getConnection();
				PreparedStatement psMatricula = conexion.prepareStatement(sqlMatricula);
				PreparedStatement psAsignaturaMatricula = conexion.prepareStatement(sqlAsignaturaMatricula)
			) {
			psMatricula.setInt(1, yearBusqueda);

			ResultSet result = psMatricula.executeQuery();

			while (result.next()) {
	            int idmatricula = result.getInt(MatriculaEntry.COLUMN_ID);
				Alumno alumno = alumnoDao.findById(result.getString(MatriculaEntry.COLUMN_DNI));
				int year = result.getInt(MatriculaEntry.COLUMN_YEAR);

				ArrayList<Asignatura> asignaturas = new ArrayList<>();

				psAsignaturaMatricula.setInt(1, idmatricula);
				ResultSet resultAsignatura = psAsignaturaMatricula.executeQuery();

				while (resultAsignatura.next()) {
					asignaturas.add(asignaturaDAO.findById(resultAsignatura.getInt("idasignatura")));
				}

				Matricula matricula = new Matricula(idmatricula, alumno, year, asignaturas);

				matriculas.add(matricula);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return matriculas;
	}

	public List<Matricula> findByDNI(String dni) {
		AlumnoDAO alumnoDao = new AlumnoDAO(gdb);
		AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gdb);
		ArrayList<Matricula> matriculas = new ArrayList<>();

		String sqlMatricula = "SELECT "
				+ MatriculaEntry.COLUMN_ID + ", "
				+ MatriculaEntry.COLUMN_DNI + ", "
				+ MatriculaEntry.COLUMN_YEAR + " FROM "
				+ MatriculaEntry.TABLE_NAME + " WHERE "
				+ MatriculaEntry.COLUMN_DNI + " = ?";

		String sqlAsignaturaMatricula = "SELECT idasignatura FROM asignatura_matricula WHERE idmatricula = ?";

		try (
				Connection conexion = gdb.getConnection();
				PreparedStatement psMatricula = conexion.prepareStatement(sqlMatricula);
				PreparedStatement psAsignaturaMatricula = conexion.prepareStatement(sqlAsignaturaMatricula);
		) {
			psMatricula.setString(1, dni);

			ResultSet result = psMatricula.executeQuery();

			while (result.next()) {
				int idmatricula = result.getInt(MatriculaEntry.COLUMN_ID);
				Alumno alumno = alumnoDao.findById(result.getString(MatriculaEntry.COLUMN_DNI));
				int year = result.getInt(MatriculaEntry.COLUMN_YEAR);

				ArrayList<Asignatura> asignaturas = new ArrayList<>();

				psAsignaturaMatricula.setInt(1, idmatricula);
				ResultSet resultAsignatura = psAsignaturaMatricula.executeQuery();

				while (resultAsignatura.next()) {
					asignaturas.add(asignaturaDAO.findById(resultAsignatura.getInt("idasignatura")));
				}

				Matricula matricula = new Matricula(idmatricula, alumno, year, asignaturas);

				matriculas.add(matricula);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return matriculas;
	}

	@Override
	public List<Matricula> findAll() {
		AlumnoDAO alumnoDao = new AlumnoDAO(gdb);
		AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gdb);
		ArrayList<Matricula> matriculas = new ArrayList<>();

		String sqlMatricula = "SELECT "
				+ MatriculaEntry.COLUMN_ID + ", "
				+ MatriculaEntry.COLUMN_DNI + ", "
				+ MatriculaEntry.COLUMN_YEAR + " FROM "
				+ MatriculaEntry.TABLE_NAME;
		
		String sqlAsignaturaMatricula = "SELECT idasignatura FROM asignatura_matricula WHERE idmatricula = ?";

		try (
				Connection conexion = gdb.getConnection();
				PreparedStatement psMatricula = conexion.prepareStatement(sqlMatricula);
				PreparedStatement psAsignaturaMatricula = conexion.prepareStatement(sqlAsignaturaMatricula);
		) {
			ResultSet result = psMatricula.executeQuery();

			while (result.next()) {
				int idmatricula = result.getInt(MatriculaEntry.COLUMN_ID);
				Alumno alumno = alumnoDao.findById(result.getString(MatriculaEntry.COLUMN_DNI));
				int year = result.getInt(MatriculaEntry.COLUMN_YEAR);

				ArrayList<Asignatura> asignaturas = new ArrayList<>();
				
				psAsignaturaMatricula.setInt(1, idmatricula);
				ResultSet resultAsignatura = psAsignaturaMatricula.executeQuery();
				
				while (resultAsignatura.next()) {
					asignaturas.add(asignaturaDAO.findById(resultAsignatura.getInt("idasignatura")));
				}
				
				Matricula matricula = new Matricula();
				matricula.setIdMatricula(idmatricula);
				matricula.setAlumno(alumno);
				matricula.setYear(year);
				matricula.setAsignaturas(asignaturas);

				matriculas.add(matricula);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return matriculas;
	}

	@Override
	public Matricula save(Matricula obj) {
		AlumnoDAO alumnoDAO = new AlumnoDAO(gdb);
		AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gdb);
		Matricula matricula = null;
		Alumno alumno = alumnoDAO.findById(obj.getAlumno().getDni());

		if (alumno != null) {

			String sqlMatricula = "INSERT INTO "
					+ MatriculaEntry.TABLE_NAME + " ("
					+ MatriculaEntry.COLUMN_DNI + ", "
					+ MatriculaEntry.COLUMN_YEAR + ") VALUES (?, ?)";

			String sqlMatriculaAsignatura = "INSERT INTO asignatura_matricula (idmatricula, idasignatura) VALUES (?, ?)";


			try (
					Connection conexion = gdb.getConnection();
					PreparedStatement psMatricula = conexion.prepareStatement(sqlMatricula, PreparedStatement.RETURN_GENERATED_KEYS);
					PreparedStatement psAsignaturaMatricula = conexion.prepareStatement(sqlMatriculaAsignatura);
				) {
				conexion.setAutoCommit(false);

				psMatricula.setString(1, alumno.getDni());
				psMatricula.setInt(2, obj.getYear());

				psMatricula.executeUpdate();

				ResultSet result = psMatricula.getGeneratedKeys();

				if (result.next()) {
					int idMatricula = result.getInt(1);
					matricula = new Matricula(idMatricula, alumno, obj.getYear());
				}

				if (matricula != null) {
					boolean respuesta = false;
					if (obj.getAsignaturas() != null) {
						ArrayList<Asignatura> asignaturas = new ArrayList<>();
						for (Asignatura asignatura : obj.getAsignaturas()) {
							if (asignatura != null) {
								Asignatura asignaturaFindName = asignaturaDAO.findByName(asignatura.getNombre());
								if (asignaturaFindName != null) {
									psAsignaturaMatricula.setInt(1, matricula.getIdMatricula());
									psAsignaturaMatricula.setInt(2, asignaturaFindName.getIdAsignatura());

									respuesta = psAsignaturaMatricula.executeUpdate() > 0;

									if (respuesta) {
										asignaturas.add(asignaturaFindName);
									}
								} else {
									conexion.rollback();
									matricula = null;
								}
							}
						}

						if (matricula != null) {
							matricula.setAsignaturas(asignaturas);
						}
					}

					if (respuesta) {
						conexion.commit();
					} else {
						conexion.rollback();
					}

				} else {
					conexion.rollback();
				}
				conexion.setAutoCommit(true);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

		return matricula;
	}

	@Override
	public boolean update(Matricula obj) {
		boolean updateOk = false;

		AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gdb);

		String sqlDelete = "DELETE FROM asignatura_matricula WHERE idmatricula = ? ";
		String sqlUpdate = "UPDATE "
				+ MatriculaEntry.TABLE_NAME + " SET "
				+ MatriculaEntry.COLUMN_DNI + " = ?, "
				+ MatriculaEntry.COLUMN_YEAR + " = ? WHERE "
				+ MatriculaEntry.COLUMN_ID + " = ? ";
		String sqlInsert = "INSERT INTO asignatura_matricula(idmatricula, idasignatura) VALUES(?, ?) ";
		
		try ( 
				Connection conexion = gdb.getConnection();
		 
				PreparedStatement psDelete = conexion.prepareStatement(sqlDelete);
				PreparedStatement psUpdate = conexion.prepareStatement(sqlUpdate);
				PreparedStatement psInsert = conexion.prepareStatement(sqlInsert);
			){
			conexion.setAutoCommit(false);
		 
			psDelete.setInt(1, obj.getIdMatricula());
			int respuesta = psDelete.executeUpdate();
			
			psUpdate.setString(1, obj.getAlumno().getDni());
			psUpdate.setInt(2, obj.getYear());
			psUpdate.setInt(3, obj.getIdMatricula());
			
			respuesta = psUpdate.executeUpdate();
			boolean ok = respuesta > 0;
			if(ok) {
				if (obj.getAsignaturas() != null) {
					for (Asignatura asignatura : obj.getAsignaturas()) {
						if (asignatura != null) {
							Asignatura asignaturaFindName = asignaturaDAO.findByName(asignatura.getNombre());
							if (asignaturaFindName != null) {
								psInsert.setInt(1, obj.getIdMatricula());
								psInsert.setInt(2,asignaturaFindName.getIdAsignatura());

								respuesta = psInsert.executeUpdate();
							} else {
								conexion.rollback();
							}
						}
					}
				}
				if (respuesta > 0) {
					conexion.commit();
					updateOk = true;
				} else {
					conexion.rollback();
				}
			}else{
				conexion.rollback();
			}
			conexion.setAutoCommit(true);
		} catch (SQLException ex) {
			ex.printStackTrace();
			updateOk = false;
		}

		return updateOk;
	}

	@Override
	public boolean delete(Integer id) {
		boolean deleteOK;

		String sqlAsignatura = "DELETE FROM asignatura_matricula WHERE idmatricula = ? ";
		String sqlMatricula = "DELETE FROM "
				+ MatriculaEntry.TABLE_NAME + " WHERE "
				+ MatriculaEntry.COLUMN_ID + " = ?";

		try (
				Connection conexion = gdb.getConnection();
				PreparedStatement psAsignatura = conexion.prepareStatement(sqlAsignatura);
				PreparedStatement psMatricula = conexion.prepareStatement(sqlMatricula)
			) {
			psAsignatura.setInt(1, id);
			psAsignatura.executeUpdate();

			psMatricula.setInt(1, id);
			deleteOK = psMatricula.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			deleteOK = false;
		}
		return deleteOK;
	}

}
