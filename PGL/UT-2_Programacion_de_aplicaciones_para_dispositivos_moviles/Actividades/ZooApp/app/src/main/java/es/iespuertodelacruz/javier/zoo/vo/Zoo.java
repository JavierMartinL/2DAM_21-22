package es.iespuertodelacruz.javier.zoo.vo;

public class Zoo {

    private String nombre;
    private String ciudad;
    private String pais;
    private int tamanio;
    private double presupuestoAnual;

    public Zoo() { }

    public Zoo(String nombre, String ciudad, String pais, int tamanio, double presupuestoAnual) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.tamanio = tamanio;
        this.presupuestoAnual = presupuestoAnual;
    }
}
