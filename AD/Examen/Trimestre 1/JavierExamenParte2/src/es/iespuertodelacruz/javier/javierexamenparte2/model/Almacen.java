/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.javierexamenparte2.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
@XmlRootElement(name="movimientos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Almacen implements Serializable {
    
    @XmlElement(name="movimiento")
    private ArrayList<Movimiento> movientos = new ArrayList<>();

    public Almacen() { }

    public ArrayList<Movimiento> getMovientos() {
        return movientos;
    }

    public void setMovientos(ArrayList<Movimiento> movientos) {
        this.movientos = movientos;
    }
    
}
