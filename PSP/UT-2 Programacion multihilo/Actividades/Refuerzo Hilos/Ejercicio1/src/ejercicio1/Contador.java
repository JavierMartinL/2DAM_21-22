/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Contador extends Thread{
    
    private int numero = 0;
    
    public synchronized void siguiente() {
        notifyAll();
        numero++;
    }
    
    public synchronized void esperarPar() {
        if (numero % 2 != 0) {
            try {
                wait();
            } catch (InterruptedException ex) { }
        } else {
            System.out.println("Par " + numero);
            siguiente();
        }
    }
    
    public synchronized void esperarImpar() {
        if (numero % 2 == 0) {
            try {
                wait();
            } catch (InterruptedException es) { }
        } else {
            System.out.println("Impar " + numero);
            siguiente();
        }
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            esperarPar();
            esperarImpar();
        }
    }
}
