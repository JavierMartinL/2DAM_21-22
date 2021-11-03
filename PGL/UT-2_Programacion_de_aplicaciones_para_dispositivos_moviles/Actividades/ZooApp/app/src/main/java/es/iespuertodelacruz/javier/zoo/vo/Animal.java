package es.iespuertodelacruz.javier.zoo.vo;

import android.content.ContentValues;

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
}
