/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Correr extends Thread{
    
    private String nombrePitufo;
    private String nombreCazador;

    public Correr(String nombre) {
        this.nombrePitufo = nombre;
        this.nombreCazador = "Azrael";
    }
    
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(nombrePitufo + " corre");
        }
        System.out.println("\n"+ nombreCazador +" atrapa a "+ nombrePitufo + "\n");
    }
}