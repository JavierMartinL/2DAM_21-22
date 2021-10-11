/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreraanimales;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Animal extends Thread{
    
    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }
    
    public void run() {
        for (int i = 1; i <= 30; i++) {
            System.out.print(" " + i + "m ");
        }
        System.out.println("\n" + nombre + " llego a la meta");
    }
    
}
