/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

import java.util.Scanner;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Notas extends Thread{
    
    Scanner sc = new Scanner(System.in);
    
    public void run(){
        int cantNotas = 5;
        int sumNotas = 0;
        System.out.println("PROMEDIO DE NOTAS");
        for (int i = 1; i <= cantNotas; i++) {
            System.out.print("Ingrese nota " + i + ": ");
            sumNotas += sc.nextInt();
        }
        System.out.println("El promedio es : "+ (sumNotas / cantNotas));
    }
    
}
