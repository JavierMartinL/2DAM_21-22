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
        notifyAll();
        return numero++;
    }
    
    public synchronized void esperarPar() {
        while (numero % 2 != 0)
            esperar("Par");
        System.out.println(numero);
    }
    
    public synchronized void esperarImpar() {
        while (numero % 2 == 0)
            esperar("Impar");
        System.out.println(numero);
    }
    
    private void esperar(String numero) {
        try {
            System.out.println("Esperando un numero " + numero + " -> hilo: " + Thread.currentThread().getName());
            wait();
        } catch (InterruptedException ex) { }
    }
    
    @Override
    public void run() {
        
        for (int i = 0; numero < 10; i++) {
            siguiente();
            if (numero % 2 == 0) {
                esperarImpar();
            }else {
                esperarPar();
            }
            if (numero == 10){
                System.exit(0);
            }
        }
        
    }
}
