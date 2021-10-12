/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.propietarioscasasxml.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
@XmlRootElement(name="propietario")
@XmlAccessorType(XmlAccessType.FIELD)
public class Propietario implements Serializable{
    
    private int idPropietario;
    private String nombre;
    
    @XmlElementWrapper(name="casas")
    @XmlElement(name="casa")
    ArrayList<Casa> casas = new ArrayList<>();

    public Propietario() { }

    public Propietario(int idPropietario, String nombre) {
        this.idPropietario = idPropietario;
        this.nombre = nombre;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public void setCasas(ArrayList<Casa> casas) {
        this.casas = casas;
    }
}
