/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.monedasxml.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
@XmlRootElement(name="monedas")
public class Almacen implements Serializable{

    ArrayList<Moneda> monedas;

    public ArrayList<Moneda> getMonedas() {
        return monedas;
    }

    public void setMonedas(ArrayList<Moneda> monedas) {
        this.monedas = monedas;
    }
}
