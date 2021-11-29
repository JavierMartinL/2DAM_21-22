/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.javierexamenparte2.model;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
@XmlRootElement(name="movimiento")
public class Movimiento implements Serializable{
    
    private int cuantia;
    private String asunto;
    private String tipoMovimiento;
    private Date fecha;

    public Movimiento() { }

    public Movimiento(int cuantia, String asunto, String tipoMovimiento, Date fecha) {
        this.cuantia = cuantia;
        this.asunto = asunto;
        this.tipoMovimiento = tipoMovimiento;
        this.fecha = fecha;
    }

    public int getCuantia() {
        return cuantia;
    }

    public void setCuantia(int cuantia) {
        this.cuantia = cuantia;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "cuantia=" + cuantia + ", asunto=" + asunto + ", tipoMovimiento=" + tipoMovimiento + ", fecha=" + fecha + '}';
    }
    
}
