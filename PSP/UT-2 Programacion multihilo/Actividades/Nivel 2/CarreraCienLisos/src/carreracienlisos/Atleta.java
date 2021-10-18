/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreracienlisos;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Atleta extends Thread {
    
    private int distancia;
    private String nombre;
    private PistaCarrera pista;

    public Atleta(String nombre) {
        this.distancia = 0;
        this.nombre = nombre;
    }  
    
    public void run() {
        while(true) {
            int random = (int) Math.floor(Math.random() * (1 - (10 + 1)) + (10));
            distancia += random;
            System.out.println("[" + nombre + "] Ditancia = " + distancia + " m");
            if(distancia > pista.getMeta()) {
                pista.cruzarMeta(this);
                break;
            }
            try {
                sleep(800);
            } catch (InterruptedException ex) { }
        }
    }
    
    public int getDistanciaRecorrida() {
        return this.distancia;
    }

    public String getNombre() {
        return nombre;
    }

    void setPista(PistaCarrera pista) {
        this.pista = pista;
    }
    
}
