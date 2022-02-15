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
public class RecetaEntry {
    // Nombre de la tabla
    public static final String TABLE_NAME = "recetas";
    
    // Columnas de la tabla Receta
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_USUARIO = "user";
    public static final String COLUMN_TIPO = "tipo";
    public static final String COLUMN_INGREDIENTES = "ingredientes";
    public static final String COLUMN_PASOS = "pasos";
    public static final String COLUMN_COMENSALES = "comensales";
    public static final String COLUMN_TIEMPO = "tiempo";
    public static final String COLUMN_CALORIAS = "calorias";
    public static final String COLUMN_IMAGEN = "imagen";
}
