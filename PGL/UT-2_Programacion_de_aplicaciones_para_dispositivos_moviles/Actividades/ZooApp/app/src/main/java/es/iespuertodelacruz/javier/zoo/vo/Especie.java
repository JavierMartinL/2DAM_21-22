package es.iespuertodelacruz.javier.zoo.vo;

public class Especie {

    private String nombreVulgar;
    private String nombreCientifico;
    private String familia;
    private boolean peligroExtincion;

    public Especie() { }

    public Especie(String nombreVulgar, String nombreCientifico, String familia, boolean peligroExtincion) {
        this.nombreVulgar = nombreVulgar;
        this.nombreCientifico = nombreCientifico;
        this.familia = familia;
        this.peligroExtincion = peligroExtincion;
    }
}
