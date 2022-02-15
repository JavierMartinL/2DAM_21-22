/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.recetas.model;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Receta {
    
    private int id;
    private String nombre;
    private Usuario usuario;
    private String tipo;
    private String ingredientes;
    private String pasos;
    private int comensales;
    private int tiempo;
    private int calorias;
    private String imgane;

    /**
     * Constructor por defecto
     */
    public Receta() {
    }

    /**
     * Contructor con parametros
     * @param id de la receta
     * @param nombre de la receta
     * @param usuario que crea la receta
     * @param tipo de receta
     * @param ingredientes de la receta
     * @param pasos de la receta
     * @param comensales de la receta
     * @param tiempo de la receta
     * @param calorias de la receta
     * @param imgane de la receta
     */
    public Receta(int id, String nombre, Usuario usuario, String tipo, String ingredientes, String pasos, int comensales, int tiempo, int calorias, String imgane) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.tipo = tipo;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
        this.comensales = comensales;
        this.tiempo = tiempo;
        this.calorias = calorias;
        this.imgane = imgane;
    }
    
    // Getters y Setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public int getComensales() {
        return comensales;
    }

    public void setComensales(int comensales) {
        this.comensales = comensales;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public String getImgane() {
        return imgane;
    }

    public void setImgane(String imgane) {
        this.imgane = imgane;
    }
    
}
