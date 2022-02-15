/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.recetas.contract;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class UsuarioEntry {
    // Nombre de la tabla
    public static final String TABLE_NAME = "users";
    
    // Columnas de la tabla Usuario
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "user";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_ROL = "rol";
}
