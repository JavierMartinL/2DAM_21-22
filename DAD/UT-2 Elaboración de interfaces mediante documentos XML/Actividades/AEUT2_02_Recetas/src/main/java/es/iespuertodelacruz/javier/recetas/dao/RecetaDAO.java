/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.recetas.dao;

import es.iespuertodelacruz.javier.recetas.contract.RecetaEntry;
import es.iespuertodelacruz.javier.recetas.model.Receta;
import es.iespuertodelacruz.javier.recetas.model.Usuario;
import es.iespuertodelacruz.javier.recetas.utils.GestorDDBB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class RecetaDAO implements ICrud<Receta, Integer>{    

    private GestorDDBB gestorDDBB;
    private UsuarioDAO usuarioDAO;
    
    /**
     * Constructor con parametros
     * @param gestorDDBB gestor de la DDBB
     */
    public RecetaDAO(GestorDDBB gestorDDBB) {
        this.gestorDDBB = gestorDDBB;
        this.usuarioDAO = new UsuarioDAO(gestorDDBB);
    }
    
    /**
     * Método que recoge todos las recetas de la DDBB
     * @return Lista con todas las recetas
     */
    @Override
    public List<Receta> findAll() {
        ArrayList<Receta> recetas = new ArrayList<>();

        String sql = "SELECT * FROM " + RecetaEntry.TABLE_NAME;

        try (Connection connection = gestorDDBB.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(RecetaEntry.COLUMN_ID);
                String nombre = resultSet.getString(RecetaEntry.COLUMN_NOMBRE);
                int usuarioId = resultSet.getInt(RecetaEntry.COLUMN_USUARIO);
                String tipo = resultSet.getString(RecetaEntry.COLUMN_TIPO);
                String ingredientes = resultSet.getString(RecetaEntry.COLUMN_INGREDIENTES);
                String pasos = resultSet.getString(RecetaEntry.COLUMN_PASOS);
                Integer comensales = resultSet.getInt(RecetaEntry.COLUMN_COMENSALES);
                Integer tiempo = resultSet.getInt(RecetaEntry.COLUMN_TIEMPO);
                int calorias = resultSet.getInt(RecetaEntry.COLUMN_CALORIAS);
                String imagen = resultSet.getString(RecetaEntry.COLUMN_IMAGEN);

                Usuario usuario = usuarioDAO.findById(usuarioId);
                
                recetas.add(new Receta(id, nombre, usuario, tipo, ingredientes,
                        pasos, comensales, tiempo, calorias, imagen));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return recetas;
    }

    /**
     * Método que busca una receta segun el id
     * @param id de la receta
     * @return Una receta con todos sus datos
     */
    @Override
    public Receta findById(Integer id) {
        Receta receta = null;
        String sql = "SELECT * FROM " + RecetaEntry.TABLE_NAME + " WHERE " 
                + RecetaEntry.COLUMN_ID + " = ?";

        try (Connection connection = gestorDDBB.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            ResultSet resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                int recetaId = resultSet.getInt(RecetaEntry.COLUMN_ID);
                String nombre = resultSet.getString(RecetaEntry.COLUMN_NOMBRE);
                int usuarioId = resultSet.getInt(RecetaEntry.COLUMN_USUARIO);
                String tipo = resultSet.getString(RecetaEntry.COLUMN_TIPO);
                String ingredientes = resultSet.getString(RecetaEntry.COLUMN_INGREDIENTES);
                String pasos = resultSet.getString(RecetaEntry.COLUMN_PASOS);
                Integer comensales = resultSet.getInt(RecetaEntry.COLUMN_COMENSALES);
                Integer tiempo = resultSet.getInt(RecetaEntry.COLUMN_TIEMPO);
                int calorias = resultSet.getInt(RecetaEntry.COLUMN_CALORIAS);
                String imagen = resultSet.getString(RecetaEntry.COLUMN_IMAGEN);

                Usuario usuario = usuarioDAO.findById(usuarioId);
                
                receta = new Receta(recetaId, nombre, usuario, tipo, ingredientes,
                        pasos, comensales, tiempo, calorias, imagen);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return receta;
    }
    
    /**
     * Método que recoge todos los tipos de Receta y cuantas veces aparece
     * @return Lista con el tipo y la cantidad
     */
    public HashMap<String, Integer> findDistinctTipo() {
        HashMap<String, Integer> tipos = new HashMap<String, Integer>();
        
        String sql = "SELECT DISTINCT(" + RecetaEntry.COLUMN_TIPO + "),"
                + " COUNT(" + RecetaEntry.COLUMN_TIPO + ") FROM " + RecetaEntry.TABLE_NAME
                + " GROUP BY " + RecetaEntry.COLUMN_TIPO;

        try (Connection connection = gestorDDBB.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                tipos.put(
                        resultSet.getString(RecetaEntry.COLUMN_TIPO),
                        resultSet.getInt(2));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tipos;
    }

    /**
     * Método que almacena una nueva receta en la DDBB
     * @param object receta que queremos almacenar
     * @return Nueva receta con todos los datos
     */
    @Override
    public Receta save(Receta object) {
        Receta receta = null;
        String sql = "INSERT INTO " + RecetaEntry.TABLE_NAME + " (" 
                + RecetaEntry.COLUMN_NOMBRE + ", "
                + RecetaEntry.COLUMN_USUARIO + ", "
                + RecetaEntry.COLUMN_TIPO + ", "
                + RecetaEntry.COLUMN_INGREDIENTES + ", "
                + RecetaEntry.COLUMN_PASOS + ", "
                + RecetaEntry.COLUMN_COMENSALES + ", "
                + RecetaEntry.COLUMN_TIEMPO + ", "
                + RecetaEntry.COLUMN_CALORIAS + ", "
                + RecetaEntry.COLUMN_IMAGEN
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = gestorDDBB.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, object.getNombre());
            ps.setInt(2, object.getUsuario().getId());
            ps.setString(3, object.getTipo());
            ps.setString(4, object.getIngredientes());
            ps.setString(5, object.getPasos());
            ps.setInt(6, object.getComensales());
            ps.setInt(7, object.getTiempo());
            ps.setInt(8, object.getCalorias());
            ps.setString(9, object.getImagen());
            
            ps.executeUpdate();
            
            ResultSet resultSet = ps.getGeneratedKeys();
            
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombre = object.getNombre();
                Usuario usuario = object.getUsuario();
                String tipo = object.getTipo();
                String ingredientes = object.getIngredientes();
                String pasos = object.getPasos();
                Integer comensales = object.getComensales();
                Integer tiempo = object.getTiempo();
                int calorias = object.getCalorias();
                String imagen = object.getImagen();
                
                receta = new Receta(id, nombre, usuario, tipo, ingredientes, pasos,
                        comensales, tiempo, calorias, imagen);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return receta;
    }

    /**
     * Método que modifica una receta de la DDBB
     * @param object receta que queremos almacenar
     * @return Nueva receta con todos sus datos
     */
    @Override
    public boolean update(Receta object) {
        String sql = "UPDATE " + RecetaEntry.TABLE_NAME + " SET "
                + RecetaEntry.COLUMN_NOMBRE + " = ?, "
                + RecetaEntry.COLUMN_USUARIO + " = ?, "
                + RecetaEntry.COLUMN_TIPO + " = ?, "
                + RecetaEntry.COLUMN_INGREDIENTES + " = ?, "
                + RecetaEntry.COLUMN_PASOS + " = ?, "
                + RecetaEntry.COLUMN_COMENSALES + " = ?, "
                + RecetaEntry.COLUMN_TIEMPO + " = ?, "
                + RecetaEntry.COLUMN_CALORIAS + " = ?, "
                + RecetaEntry.COLUMN_IMAGEN + " = ? WHERE"
                + RecetaEntry.COLUMN_ID + " = ?";
        boolean ok;
        
        try (Connection connection = gestorDDBB.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setString(1, object.getNombre());
            ps.setInt(2, object.getUsuario().getId());
            ps.setString(3, object.getTipo());
            ps.setString(4, object.getIngredientes());
            ps.setString(5, object.getPasos());
            ps.setInt(6, object.getComensales());
            ps.setInt(7, object.getTiempo());
            ps.setInt(8, object.getCalorias());
            ps.setString(9, object.getImagen());
            ps.setInt(10, object.getId());
            
            ok = ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ok = false;
        }
        
        return ok;
    }

    /**
     * Método que elimina una receta de la DDBB
     * @param id de la receta
     * @return TRUE si se elimina la receta, FALSE si no se elimina
     */
    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM " + RecetaEntry.TABLE_NAME + " WHERE " 
                + RecetaEntry.COLUMN_ID + " = ?";
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
