/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad13;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Transporte extends Thread{

    int recorrido;
    
    public Transporte(String nombre, int recorrido) {
        super(nombre);
        this.recorrido = recorrido;
    }
    
    
    public void run() {
        for (int i = 1; i < recorrido; i++) {
            System.out.println(getName() + " ha recorrido " + i + " km");
        }
        System.out.println(" ");
    }
    
}
