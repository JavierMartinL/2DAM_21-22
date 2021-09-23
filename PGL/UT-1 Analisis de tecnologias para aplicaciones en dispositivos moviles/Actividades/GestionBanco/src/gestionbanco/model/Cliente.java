/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbanco.model;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Cliente {
    
    private String nombre;
    private String apellidos;
    private String user;
    private String pass;
    private Cuenta cuenta;
    
    public Cliente(String nombre, String apellidos, String user, String pass) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.user = user;
        this.pass = pass;
    }
    
    public boolean login(String user, String pass) {
        if (user.equals(nombre)) {
            if (pass.equals(this.pass)) {
                return true;
            }
        }
        return false;
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

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", user=" + user + ", pass=" + pass + ", cuenta=" + cuenta + '}';
    }
    
}
