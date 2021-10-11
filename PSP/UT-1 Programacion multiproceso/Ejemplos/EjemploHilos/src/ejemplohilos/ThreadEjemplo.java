/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplohilos;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class ThreadEjemplo implements Runnable{
    
    // implements Runnable
    
    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println(i + " " + Thread.currentThread().getName());
        System.out.println("Termina thread " + Thread.currentThread().getName());
    }
    
    public static void main(String[] args) {
        new Thread(new ThreadEjemplo(), "Pepe").start();
        new Thread(new ThreadEjemplo(), "Juan").start();
        System.out.println("Termina thread main");
    }
    
    // extends Thread
    
//    public ThreadEjemplo(String str) {
//        super(str);
//    }
//    
//    public void run () {
//        for (int i = 0; i < 10; i++)
//            System.out.println(i + " " + getName());
//        System.out.println("Termina thread " + getName());
//    }
//    
//    public static void main(String[] args) {
//        new ThreadEjemplo("Pepe").start();
//        new ThreadEjemplo("Juan").start();
//        System.out.println("Termina thread main");
//    }
}
