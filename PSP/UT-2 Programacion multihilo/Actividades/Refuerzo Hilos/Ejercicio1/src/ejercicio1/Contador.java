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
    
    public int numero = 0;
    
    public synchronized int siguiente() {
        System.out.println(numero);
        return numero++;
    }
    
    public synchronized void esperarPar() throws InterruptedException {
        if (numero % 2 == 0) {
            siguiente();
            notifyAll();
        } else {
            System.out.println("esperarImpar");
            wait();
        }
    }
    
    public synchronized void esperarImpar() throws InterruptedException {
        if (numero % 2 != 0) {
            siguiente();
            notifyAll();
        } else {
            System.out.println("esperarPar");
            wait(50);
        }
    }
    
    @Override
    public void run() {

    }
}
