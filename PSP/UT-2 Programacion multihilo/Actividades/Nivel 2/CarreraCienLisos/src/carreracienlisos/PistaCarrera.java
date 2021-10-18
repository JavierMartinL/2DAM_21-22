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
public class PistaCarrera {

    private Atleta a1;
    private Atleta a2;
    private int meta;
    private boolean hayGanador = false;

    public PistaCarrera(int meta) {
        this.meta = meta;
    }

    public int getMeta() {
        return meta;
    }

    public void setCorredores(Atleta a1, Atleta a2) {
        a1.setPista(this);
        a2.setPista(this);
        this.a1 = a1;
        this.a2 = a2;
    }

    public void empezarCarrera() {
        try {
            a1.start();
            a2.start();

            a1.join();
            a2.join();
            System.out.println("Carrera finalizada");
        } catch (InterruptedException ex) { }
    }

    public synchronized void cruzarMeta(Atleta atleta) {
        if(!hayGanador) {
            hayGanador = true;
            System.out.println("Corredor " + atleta.getNombre()+ " es el ganador");
        }
    }
}
