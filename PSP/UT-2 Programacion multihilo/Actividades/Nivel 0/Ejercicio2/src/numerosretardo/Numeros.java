/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerosretardo;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Numeros extends Thread{
    
    private int limite;
    
    public Numeros() {
        this(20);
    }
    
    public Numeros(int limite) {
        this.limite = limite;
    }
    
    public void run() {
        for (int numero = 1; numero <= limite; numero++) {
            System.out.print(" " + numero + " ");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) { }
        }
    }
    
}
