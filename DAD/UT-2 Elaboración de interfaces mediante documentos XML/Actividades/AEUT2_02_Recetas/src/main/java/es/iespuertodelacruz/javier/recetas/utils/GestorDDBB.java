/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.recetas.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class GestorDDBB {

    private String database;
    private String user;
    private String password;

    /**
     * Constructor que llama al metodo que carga los drivers de MYSQL e inicializa
     * el nombre de la DDBB y el usuario
     */
    public GestorDDBB() {
        this.database = "receta";
        this.user = "root";
        this.password = "";

        cargarDriverMysql();
    }

    /**
     * Método que carga el driver de MYSQL
     */
    private static void cargarDriverMysql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("no carga el driver");
            System.exit(1);
        }
    }

    /**
     * Método que crea una conexion para poder atacar a la base de datos
     * @return conexión con la DDBB
     */
    public Connection getConnection() {
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/" + database + "?serverTimezone=UTC",
                    user,
                    password
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return conexion;
    }

}
