/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import java.util.Scanner;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce el nuemero para realizar el factorial");
        System.out.print("-> ");
        int numero = sc.nextInt();
        
        Factorial[] factoriales = new Factorial[numero];
        
        for (int i = 0; i < factoriales.length; i++) {
            factoriales[i] = new Factorial(i + 1);
        }
        
        for (int i = factoriales.length - 1; i >= 0; i--) {
            factoriales[i].start();
        }
    }
    
}
