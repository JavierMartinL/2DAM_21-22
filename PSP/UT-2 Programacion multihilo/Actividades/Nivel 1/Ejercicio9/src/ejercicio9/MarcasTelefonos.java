/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class MarcasTelefonos extends Thread{

    public MarcasTelefonos(String marca) {
        super(marca);
    }
    
    public void run() {
       int contador = 1;
       while(contador <= 5) {
           try {
               sleep((long)(Math.random()*1000));
               System.out.println(contador + " " + getName());
           } catch (InterruptedException e) {
               System.err.println("Error con el proceso");
           }
           contador++;
       }
        System.out.println("\n*******************");
        System.out.println(getName() + " ha completado toda las llamadas");
        System.out.println("*******************\n");
    }
    
}