/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbanco.controller;

import gestionbanco.model.Cliente;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Controller {
    
    private String nombre;
    private String apellidos;
    private String user;
    private String pass;
    private Cliente client;
    
    public void registro() {
        System.out.println(client = new Cliente(nombre, apellidos, user, pass));
    }
    
    public boolean login() {
        if (client.login(user, pass)) {
            System.out.println("Bienvenido " + client.getNombre());
            return true;
        } else {
            System.out.println("Error!!!!");
            return false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
