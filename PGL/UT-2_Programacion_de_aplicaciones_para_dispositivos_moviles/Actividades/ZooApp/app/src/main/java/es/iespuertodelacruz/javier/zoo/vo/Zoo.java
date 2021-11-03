package es.iespuertodelacruz.javier.zoo.vo;

import android.content.ContentValues;

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
}
