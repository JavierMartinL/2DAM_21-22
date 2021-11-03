package es.iespuertodelacruz.javier.zoo.vo;

import android.content.ContentValues;

import es.iespuertodelacruz.javier.zoo.model.contract.EspecieContract;
import es.iespuertodelacruz.javier.zoo.model.inteface.IEspecie;

public class Especie implements IEspecie {

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

    @Override
    public int isValid() {
        return 0;
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(EspecieContract.EspecieEntry.NOMBRE_VULGAR, nombreVulgar);
        values.put(EspecieContract.EspecieEntry.NOMBRE_CIENTIFICO, nombreCientifico);
        values.put(EspecieContract.EspecieEntry.FAMILIA, familia);
        values.put(EspecieContract.EspecieEntry.PELIGRO_EXTINCION, peligroExtincion);
        return values;
    }
}
