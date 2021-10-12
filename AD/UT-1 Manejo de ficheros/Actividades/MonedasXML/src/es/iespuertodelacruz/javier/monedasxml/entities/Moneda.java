/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.monedasxml.entities;

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
@XmlRootElement(name="moneda")
@XmlAccessorType(XmlAccessType.FIELD)
public class Moneda implements Serializable{

    Integer idMoneda;
    String nombre;
    String pais;
    
    public ArrayList<Historico> getHistoricos() {
        return historicos;
    }

    
    public void setHistoricos(ArrayList<Historico> historicos) {
        this.historicos = historicos;
    }
    
    @XmlElementWrapper(name="historicos")
    @XmlElement(name="historico")
    ArrayList<Historico> historicos = new ArrayList<Historico>();

    public Moneda(){}
    
    public Moneda(Integer idMoneda, String nombre, String pais) {
        this.idMoneda = idMoneda;
        this.nombre = nombre;
        this.pais = pais;
    }

    public Integer getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    @Override
    public String toString(){
        
        return "" + idMoneda + " " + nombre + " país: " + pais;
    }
    
}
