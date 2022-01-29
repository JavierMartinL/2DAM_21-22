package es.system.javier.ong.model;

import android.content.ContentValues;

import es.system.javier.ong.database.contract.MascotaContract;

public class Mascota {

    private String identificador;
    private String nombre;
    private long fechaNacimiento;
    private String raza;

    /**
     * Constructor por defecto
     */
    public Mascota() {
    }

    /**
     * Constructor de la clase Mascota con parametros
     * @param identificador de la Mascota
     * @param nombre de la Mascota
     * @param fechaNacimiento de la Mascota
     * @param raza de la Mascota
     */
    public Mascota(String identificador, String nombre, long fechaNacimiento, String raza) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.raza = raza;
    }

    /**
     * Getters - Setters
     */

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(long fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * Método que recoge todo los valores de la mascota y lo convierte en un ContentValues
     * @return ContentValues con los datos de la Mascota
     */
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(MascotaContract.MascotaEntry._ID, this.identificador);
        values.put(MascotaContract.MascotaEntry.COLUMN_NOMBRE, this.nombre);
        values.put(MascotaContract.MascotaEntry.COLUMN_FECHA_NACIMIENTO, this.fechaNacimiento);
        values.put(MascotaContract.MascotaEntry.COLUMN_RAZA, this.raza);
        return  values;
    }
}
