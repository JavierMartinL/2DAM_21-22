package es.iespuertodelacruz.javier.zoo.vo;

import java.util.Date;

public class Animal {

    private int identificador;
    private Especie especie;
    private String sexo;
    private Date nacimiento;
    private String pais;
    private String continente;

    public Animal() { }

    public Animal(int identificador, Especie especie, String sexo, Date nacimiento, String pais, String continente) {
        this.identificador = identificador;
        this.especie = especie;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.pais = pais;
        this.continente = continente;
    }

}
