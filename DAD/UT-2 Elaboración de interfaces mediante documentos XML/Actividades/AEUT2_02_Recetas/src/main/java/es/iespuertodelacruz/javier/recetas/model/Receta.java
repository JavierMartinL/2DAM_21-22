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
    private Integer comensales;
    private Integer tiempo;
    private int calorias;
    private String imagen;

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
     * @param imagen de la receta
     */
    public Receta(int id, String nombre, Usuario usuario, String tipo, String ingredientes, String pasos, Integer comensales, Integer tiempo, int calorias, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.tipo = tipo;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
        this.comensales = comensales;
        this.tiempo = tiempo;
        this.calorias = calorias;
        this.imagen = imagen;
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

    public Integer getComensales() {
        return comensales;
    }

    public void setComensales(Integer comensales) {
        this.comensales = comensales;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
