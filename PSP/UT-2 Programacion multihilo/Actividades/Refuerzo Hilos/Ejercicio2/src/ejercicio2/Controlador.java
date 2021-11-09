/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;


/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Controlador extends Thread{
    
    private boolean recurso1 = false;
    private boolean recurso2 = false;
    private boolean recurso3 = false;
    
    public synchronized void ocuparRecurso1() throws InterruptedException {
        while (recurso1) {
            wait();
        }
        System.out.println("Recurso 1 ocupado -> hilo: " + Thread.currentThread().getName());
        recurso1 = true;
    }
    
    public synchronized void ocuparRecurso2Recurso3() throws InterruptedException {
        while (recurso2 || recurso3) {
            wait();
        }
        System.out.println("Recurso 2 y 3 ocupados -> hilo: " + Thread.currentThread().getName());
        recurso2 = true;
        recurso3 = true;
    }
    
    public synchronized void ocuparRecurso1Recurso2Recurso3() throws InterruptedException {
        while (recurso1 || recurso2 || recurso3) {
            wait();
        }
        System.out.println("Recurso 1, 2 y 3 ocupados -> hilo: " + Thread.currentThread().getName());
        recurso1 = true;
        recurso2 = true;
        recurso3 = true;
    }
    
    public synchronized void liberarRecurso1() {
        System.out.println("Recurso 1 liberado -> hilo: " + Thread.currentThread().getName());
        recurso1 = false;
        notifyAll();
    }
    
    public synchronized void liberarRecurso2Recurso3() {
        System.out.println("Recurso 2 y 3 liberados -> hilo: " + Thread.currentThread().getName());
        recurso2 = false;
        recurso3 = false;
        notifyAll();
    }
    
    public synchronized void liberarRecurso1Recurso2Recurso3() {
        System.out.println("Recurso 1, 2 y 3 liberados -> hilo: " + Thread.currentThread().getName());
        recurso1 = false;
        recurso2 = false;
        recurso3 = false;
        notifyAll();
    }
    
    @Override
    public void run() {
        try {
            ocuparRecurso1();
            liberarRecurso1();
            ocuparRecurso2Recurso3();
            liberarRecurso2Recurso3();
            ocuparRecurso1Recurso2Recurso3();
            liberarRecurso1Recurso2Recurso3();
        } catch(InterruptedException ex) { }
    }
}
