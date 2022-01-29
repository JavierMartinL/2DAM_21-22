package es.system.javier.clinica.vo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;

import java.util.Objects;

import es.system.javier.clinica.model.contract.AnimalContract;

public class Animal {

    private int identificador;
    private String nombre;
    private String raza;
    private int edad;
    private String chip;

    /**
     * Constructor por defecto
     */
    public Animal() { }

    /**
     * Constructor para la entity Animal
     * @param identificador
     * @param nombre
     * @param raza
     * @param edad
     * @param chip
     */
    public Animal(int identificador, String nombre, String raza, int edad, String chip) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.chip = chip;
    }

    @SuppressLint("Range")
    public Animal(Cursor cursor) {
        this.identificador = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.IDENTIFICADOR));
        this.nombre = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.NOMBRE));
        this.raza = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.RAZA));
        this.edad = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.EDAD));
        this.chip = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.CHIP));
    }

    /**
     * Método que crea un ContentValues con todos los atributos en relacion con la tabla
     * @return ContentValues con todos los datos de un animal
     */
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(AnimalContract.AnimalEntry.IDENTIFICADOR, identificador);
        values.put(AnimalContract.AnimalEntry.NOMBRE, nombre);
        values.put(AnimalContract.AnimalEntry.RAZA, raza);
        values.put(AnimalContract.AnimalEntry.EDAD, edad);
        values.put(AnimalContract.AnimalEntry.CHIP, chip);
        return values;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getChip() {
        return getChip();
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return identificador == animal.identificador && Objects.equals(nombre, animal.nombre) && Objects.equals(raza, animal.raza) && Objects.equals(edad, animal.edad) && Objects.equals(chip, animal.chip);
    }
}
