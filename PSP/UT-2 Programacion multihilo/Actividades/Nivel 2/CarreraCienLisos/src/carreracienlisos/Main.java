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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Atleta> atletas = new ArrayList<>();
        atletas.add(new Atleta("Ernesto"));
        atletas.add(new Atleta("Juan"));
        atletas.add(new Atleta("Adrian"));
        atletas.add(new Atleta("Luis"));
        atletas.add(new Atleta("Paco"));
        atletas.add(new Atleta("Marcos"));
        atletas.add(new Atleta("Angel"));
        atletas.add(new Atleta("Jose"));

        PistaCarrera pista = new PistaCarrera(100);
        pista.setCorredores(atletas);
        pista.empezarCarrera();
    }
    
}
