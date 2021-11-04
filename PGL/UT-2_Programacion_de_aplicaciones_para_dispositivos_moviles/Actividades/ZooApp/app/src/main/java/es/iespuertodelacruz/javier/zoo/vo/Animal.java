package es.iespuertodelacruz.javier.zoo.vo;

import android.content.ContentValues;

import java.util.Objects;

import es.iespuertodelacruz.javier.zoo.model.contract.AnimalContract;
import es.iespuertodelacruz.javier.zoo.model.inteface.IAnimal;

public class Animal implements IAnimal {

    private int identificador;
    private String especie;
    private String sexo;
    private String nacimiento;
    private String pais;
    private String continente;

    public Animal() { }

    public Animal(int identificador, String especie, String sexo, String nacimiento, String pais, String continente) {
        this.identificador = identificador;
        this.especie = especie;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.pais = pais;
        this.continente = continente;
    }

    @Override
    public int isValid() {
        return 0;
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(AnimalContract.AnimalEntry.IDENTIFICADOR, identificador);
        values.put(AnimalContract.AnimalEntry.ESPECIE, especie);
        values.put(AnimalContract.AnimalEntry.SEXO, sexo);
        values.put(AnimalContract.AnimalEntry.NACIMIENTO, nacimiento);
        values.put(AnimalContract.AnimalEntry.PAIS, pais);
        values.put(AnimalContract.AnimalEntry.CONTINENTE, continente);
        return values;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return identificador == animal.identificador && Objects.equals(especie, animal.especie) && Objects.equals(sexo, animal.sexo) && Objects.equals(nacimiento, animal.nacimiento) && Objects.equals(pais, animal.pais) && Objects.equals(continente, animal.continente);
    }
}
