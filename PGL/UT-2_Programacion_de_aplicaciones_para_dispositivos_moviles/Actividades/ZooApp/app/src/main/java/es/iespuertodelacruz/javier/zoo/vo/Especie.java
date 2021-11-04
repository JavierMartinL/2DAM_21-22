package es.iespuertodelacruz.javier.zoo.vo;

import android.content.ContentValues;

import java.util.Objects;

import es.iespuertodelacruz.javier.zoo.model.contract.EspecieContract;
import es.iespuertodelacruz.javier.zoo.model.inteface.IEspecie;

public class Especie implements IEspecie {

    private String nombreCientifico;
    private String nombreVulgar;
    private String familia;
    private boolean peligroExtincion;

    public Especie() { }

    public Especie(String nombreCientifico, String nombreVulgar, String familia, boolean peligroExtincion) {
        this.nombreCientifico = nombreCientifico;
        this.nombreVulgar = nombreVulgar;
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
        values.put(EspecieContract.EspecieEntry.NOMBRE_CIENTIFICO, nombreCientifico);
        values.put(EspecieContract.EspecieEntry.NOMBRE_VULGAR, nombreVulgar);
        values.put(EspecieContract.EspecieEntry.FAMILIA, familia);
        values.put(EspecieContract.EspecieEntry.PELIGRO_EXTINCION, peligroExtincion);
        return values;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreVulgar() {
        return nombreVulgar;
    }

    public void setNombreVulgar(String nombreVulgar) {
        this.nombreVulgar = nombreVulgar;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public boolean isPeligroExtincion() {
        return peligroExtincion;
    }

    public void setPeligroExtincion(boolean peligroExtincion) {
        this.peligroExtincion = peligroExtincion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especie especie = (Especie) o;
        return peligroExtincion == especie.peligroExtincion && Objects.equals(nombreVulgar, especie.nombreVulgar) && Objects.equals(nombreCientifico, especie.nombreCientifico) && Objects.equals(familia, especie.familia);
    }
}
