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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Atleta atleta1 = new Atleta("Ernesto");
        Atleta atleta2 = new Atleta("Jesus");

        PistaCarrera pista = new PistaCarrera(20);
        pista.setCorredores(atleta1, atleta2);
        pista.empezarCarrera();
    }
    
}
