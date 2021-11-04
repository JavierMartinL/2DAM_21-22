package es.iespuertodelacruz.javier.zoo.vo;

import android.content.ContentValues;

import java.util.Objects;

import es.iespuertodelacruz.javier.zoo.model.contract.ZooContract;
import es.iespuertodelacruz.javier.zoo.model.inteface.IZoo;

public class Zoo implements IZoo {

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

    @Override
    public int isValid() {
        return 0;
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ZooContract.ZooEntry.NOMBRE, nombre);
        values.put(ZooContract.ZooEntry.CIUDAD, ciudad);
        values.put(ZooContract.ZooEntry.PAIS, pais);
        values.put(ZooContract.ZooEntry.TAMANIO, tamanio);
        values.put(ZooContract.ZooEntry.PRESUPUESTO_ANUAL, presupuestoAnual);
        return values;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public double getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(double presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zoo zoo = (Zoo) o;
        return tamanio == zoo.tamanio && Double.compare(zoo.presupuestoAnual, presupuestoAnual) == 0 && Objects.equals(nombre, zoo.nombre) && Objects.equals(ciudad, zoo.ciudad) && Objects.equals(pais, zoo.pais);
    }
}
