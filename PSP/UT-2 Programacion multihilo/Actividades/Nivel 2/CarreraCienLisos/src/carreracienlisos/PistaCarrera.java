/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreracienlisos;

import java.util.ArrayList;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class PistaCarrera {

    private ArrayList<Atleta> atletas;
    private int meta;
    private boolean hayGanador = false;

    public PistaCarrera(int meta) {
        this.meta = meta;
    }

    public int getMeta() {
        return meta;
    }

    public void setCorredores(ArrayList<Atleta> atletas) {
        for (Atleta atleta : atletas) {
            atleta.setPista(this);
        }
        this.atletas = atletas;
    }

    public void empezarCarrera() {
        try {
            for (Atleta atleta : atletas) {
                atleta.start();
            }
            for (Atleta atleta : atletas) {
                atleta.join();
            }
            System.out.println("Carrera finalizada");
        } catch (InterruptedException ex) { }
    }

    public synchronized void cruzarMeta(Atleta atleta) {
        if(!hayGanador) {
            hayGanador = true;
            System.out.println("\n*************************************");
            System.out.println("Corredor " + atleta.getNombre()+ " es el ganador");
            System.out.println("*************************************\n");
        }
    }
}
