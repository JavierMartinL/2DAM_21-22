/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.recetas.dao;

import es.iespuertodelacruz.javier.recetas.contract.UsuarioEntry;
import es.iespuertodelacruz.javier.recetas.model.Usuario;
import es.iespuertodelacruz.javier.recetas.utils.GestorDDBB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class UsuarioDAO implements ICrud<Usuario, Integer> {

    private GestorDDBB gestorDDBB;

    /**
     * Constructor con parametros
     * @param gestorDDBB gestor de la DDBB
     */
    public UsuarioDAO(GestorDDBB gestorDDBB) {
        this.gestorDDBB = gestorDDBB;
    }

    /**
     * Método que recoge todos los usuarios de la DDBB
     * @return Lista con todos los Usuarios
     */
    @Override
    public List<Usuario> findAll() {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM " + UsuarioEntry.TABLE_NAME;

        try (Connection connection = gestorDDBB.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(UsuarioEntry.COLUMN_ID);
                String nombre = resultSet.getString(UsuarioEntry.COLUMN_NOMBRE);
                String password = resultSet.getString(UsuarioEntry.COLUMN_PASSWORD);
                String rol = resultSet.getString(UsuarioEntry.COLUMN_ROL);

                usuarios.add(new Usuario(id, nombre, password, rol));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return usuarios;
    }

    /**
     * Método que busca un usuario segun el id
     * @param id del usuario
     * @return Un usuario con todos sus datos
     */
    @Override
    public Usuario findById(Integer id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM " + UsuarioEntry.TABLE_NAME + " WHERE " 
                + UsuarioEntry.COLUMN_ID + " = ?";

        try (Connection connection = gestorDDBB.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            ResultSet resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                int idUser = resultSet.getInt(UsuarioEntry.COLUMN_ID);
                String nombre = resultSet.getString(UsuarioEntry.COLUMN_NOMBRE);
                String password = resultSet.getString(UsuarioEntry.COLUMN_PASSWORD);
                String rol = resultSet.getString(UsuarioEntry.COLUMN_ROL);
                
                usuario = new Usuario(idUser, nombre, password, rol);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return usuario;
    }
    
    /**
     * Método que busca un usuario segun el nombre
     * @param strNombre del usuario
     * @return Un usuario con todos sus datos
     */
    public Usuario findByNombre(String strNombre) {
        Usuario usuario = null;
        String sql = "SELECT * FROM " + UsuarioEntry.TABLE_NAME + " WHERE " 
                + UsuarioEntry.COLUMN_NOMBRE + " = ?";

        try (Connection connection = gestorDDBB.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setString(1, strNombre);
            
            ResultSet resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                int idUser = resultSet.getInt(UsuarioEntry.COLUMN_ID);
                String nombre = resultSet.getString(UsuarioEntry.COLUMN_NOMBRE);
                String password = resultSet.getString(UsuarioEntry.COLUMN_PASSWORD);
                String rol = resultSet.getString(UsuarioEntry.COLUMN_ROL);
                
                usuario = new Usuario(idUser, nombre, password, rol);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return usuario;
    }

    /**
     * Método que almacena un nuevo usuario en la DDBB
     * @param object usuario que queremos almacenar
     * @return Nuevo usuario con todos sus datos
     */
    @Override
    public Usuario save(Usuario object) {
        Usuario usuario = null;
        String sql = "INSERT INTO " + UsuarioEntry.TABLE_NAME + " (" 
                + UsuarioEntry.COLUMN_NOMBRE + ", "
                + UsuarioEntry.COLUMN_PASSWORD + ", "
                + UsuarioEntry.COLUMN_ROL
                + ") VALUES (?, ?, ?)";
        
        try (Connection connection = gestorDDBB.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, object.getNombre());
            ps.setString(2, object.getPassword());
            ps.setString(3, object.getRol());
            
            ps.executeUpdate();
            
            ResultSet resultSet = ps.getGeneratedKeys();
            
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombre = object.getNombre();
                String password = object.getPassword();
                String rol = object.getRol();
                
                usuario = new Usuario(id, nombre, password, rol);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return usuario;
    }

    /**
     * Método que modifica un usuario de la DDBB
     * @param object usuario que queremos modificar
     * @return TRUE si se modifica el usuario, FALSE si no se modifica
     */
    @Override
    public boolean update(Usuario object) {
        String sql = "UPDATE " + UsuarioEntry.TABLE_NAME + " SET "
                + UsuarioEntry.COLUMN_NOMBRE + " = ?, "
                + UsuarioEntry.COLUMN_PASSWORD + " = ?, "
                + UsuarioEntry.COLUMN_ROL + " = ? WHERE "
                + UsuarioEntry.COLUMN_ID + " = ?";
        boolean ok;
        
        try (Connection connection = gestorDDBB.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setString(1, object.getNombre());
            ps.setString(2, object.getPassword());
            ps.setString(3, object.getRol());
            ps.setInt(4, object.getId());
            
            ok = ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ok = false;
        }
        
        return ok;
    }

    /**
     * Método que elimina un usuario de la DDBB
     * @param id del usuario
     * @return TRUE si se elimina el usuario, FALSE si no se elimina
     */
    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM " + UsuarioEntry.TABLE_NAME + " WHERE " 
                + UsuarioEntry.COLUMN_ID + " = ?";
        boolean ok;
        
        try (Connection connection = gestorDDBB.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            ok = ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ok = false;
        }
        
        return ok;
    }
}
