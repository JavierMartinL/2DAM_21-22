package es.iespuertodelacruz.javier.instituto.dao;

import es.iespuertodelacruz.javier.instituto.contract.AsignaturaEntry;
import es.iespuertodelacruz.javier.instituto.model.Asignatura;
import es.iespuertodelacruz.javier.instituto.utils.GestorDDBB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaDAO implements CRUD<Asignatura, Integer> {

    GestorDDBB gdb;

    public AsignaturaDAO(GestorDDBB gdb) {
        this.gdb = gdb;
    }

    @Override
    public Asignatura findById(Integer id) {
        Asignatura asignatura = null;

        String sql = "SELECT "
                + AsignaturaEntry.COLUMN_ID + ", "
                + AsignaturaEntry.COLUMN_NOMBRE + ", "
                + AsignaturaEntry.COLUMN_CURSO + " FROM "
                + AsignaturaEntry.TABLE_NAME + " WHERE "
                + AsignaturaEntry.COLUMN_ID + " = ?";


        try (
                Connection conexion = gdb.getConnection();
                PreparedStatement ps = conexion.prepareStatement(sql);
            ) {
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                int idAsignatura = result.getInt(AsignaturaEntry.COLUMN_ID);
                String nombre = result.getString(AsignaturaEntry.COLUMN_NOMBRE);
                String curso = result.getString(AsignaturaEntry.COLUMN_CURSO);

                asignatura = new Asignatura();
                asignatura.setIdAsignatura(idAsignatura);
                asignatura.setNombre(nombre);
                asignatura.setCurso(curso);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return asignatura;
    }

    public Asignatura findByName(String nombreBusqueda) {
        Asignatura asignatura = null;

        String sql = "SELECT "
                + AsignaturaEntry.COLUMN_ID + ", "
                + AsignaturaEntry.COLUMN_NOMBRE + ", "
                + AsignaturaEntry.COLUMN_CURSO + " FROM "
                + AsignaturaEntry.TABLE_NAME + " WHERE "
                + AsignaturaEntry.COLUMN_NOMBRE + " LIKE ?";

        try (
                Connection conexion = gdb.getConnection();
                PreparedStatement ps = conexion.prepareStatement(sql);
            ) {
            ps.setString(1, nombreBusqueda);

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                int idAsignatura = result.getInt(AsignaturaEntry.COLUMN_ID);
                String nombre = result.getString(AsignaturaEntry.COLUMN_NOMBRE);
                String curso = result.getString(AsignaturaEntry.COLUMN_CURSO);

                asignatura = new Asignatura(idAsignatura, nombre, curso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return asignatura;
    }

    public List<Asignatura> findByCurso(String cursoBuscar) {
        ArrayList<Asignatura> asignaturas = new ArrayList<>();

        String sql = "SELECT "
                + AsignaturaEntry.COLUMN_ID + ", "
                + AsignaturaEntry.COLUMN_NOMBRE + ", "
                + AsignaturaEntry.COLUMN_CURSO + " FROM "
                + AsignaturaEntry.TABLE_NAME + " WHERE "
                + AsignaturaEntry.COLUMN_CURSO + " LIKE ?";

        try (
                Connection conexion = gdb.getConnection();
                PreparedStatement ps = conexion.prepareStatement(sql);
            ) {
            ps.setString(1, "%" + cursoBuscar + "%");

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                int idAsignatura = result.getInt(AsignaturaEntry.COLUMN_ID);
                String nombre = result.getString(AsignaturaEntry.COLUMN_NOMBRE);
                String curso = result.getString(AsignaturaEntry.COLUMN_CURSO);

                Asignatura asignatura = new Asignatura(idAsignatura, nombre, curso);

                asignaturas.add(asignatura);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return asignaturas;
    }

    @Override
    public List<Asignatura> findAll() {
        ArrayList<Asignatura> asignaturas = new ArrayList<>();

        String sql = "SELECT "
                + AsignaturaEntry.COLUMN_ID + ", "
                + AsignaturaEntry.COLUMN_NOMBRE + ", "
                + AsignaturaEntry.COLUMN_CURSO + " FROM "
                + AsignaturaEntry.TABLE_NAME;

        try (
                Connection conexion = gdb.getConnection();
                PreparedStatement ps = conexion.prepareStatement(sql);
            ) {
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                int idAsignatura = result.getInt(AsignaturaEntry.COLUMN_ID);
                String nombre = result.getString(AsignaturaEntry.COLUMN_NOMBRE);
                String curso = result.getString(AsignaturaEntry.COLUMN_CURSO);

                Asignatura asignatura = new Asignatura();
                asignatura.setIdAsignatura(idAsignatura);
                asignatura.setNombre(nombre);
                asignatura.setCurso(curso);

                asignaturas.add(asignatura);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return asignaturas;
    }

    @Override
    public Asignatura save(Asignatura obj) {
        Asignatura asignatura = null;

        String sql = "INSERT INTO "
                + AsignaturaEntry.TABLE_NAME + " ("
                + AsignaturaEntry.COLUMN_NOMBRE + ", "
                + AsignaturaEntry.COLUMN_CURSO + ") VALUES (?, ?)";

        try (
                Connection conexion = gdb.getConnection();
                PreparedStatement ps = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ) {
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getCurso());

            ps.executeUpdate();

            ResultSet result = ps.getGeneratedKeys();

            while (result.next()) {
                asignatura = new Asignatura(
                        result.getInt(1),
                        obj.getNombre(),
                        obj.getCurso()
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return asignatura;
    }

    @Override
    public boolean update(Asignatura obj) {
        boolean updatedOk;

        String sql = "UPDATE "
                + AsignaturaEntry.TABLE_NAME + " SET "
                + AsignaturaEntry.COLUMN_NOMBRE + " = ?, "
                + AsignaturaEntry.COLUMN_CURSO + " = ? WHERE "
                + AsignaturaEntry.COLUMN_ID + " = ?";

        try (
                Connection conexion = gdb.getConnection();
                PreparedStatement ps = conexion.prepareStatement(sql);
            ) {
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getCurso());
            ps.setInt(3, obj.getIdAsignatura());

            updatedOk = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            updatedOk = false;
        }
        return updatedOk;
    }

    @Override
    public boolean delete(Integer id) {
        boolean deletedOk;

        String sql = "DELETE FROM "
                + AsignaturaEntry.TABLE_NAME + " WHERE "
                + AsignaturaEntry.COLUMN_ID + " = ?";

        try (
                Connection conexion = gdb.getConnection();
                PreparedStatement ps = conexion.prepareStatement(sql);
            ) {
            ps.setInt(1, id);

            deletedOk = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            deletedOk = false;
        }

        return deletedOk;
    }
}
