/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paresimpares;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Impares extends Thread{
    
    public void run() {
        
        int contador = 0;
        
        for (int i = 1; i <= 10; i++) {
            
            if(i % 2 != 0) {
                System.out.print(" " + i + "\n");
                contador += i;
            }
            
        }
        
        System.out.print("La suma de los impares es : " + contador + "\n");
        
    }
    
}
