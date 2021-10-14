/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import java.util.Scanner;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class OperacionBasica extends Thread{
    
    Scanner sc = new Scanner(System.in);
    
    int num1;
    int num2;
    char operador;

    public OperacionBasica() {
        System.out.print("Insertar el primer número: ");
        num1 = sc.nextInt();sc.nextLine();
        System.out.print("Insertar el segundo número: ");
        num2 = sc.nextInt();sc.nextLine();
    }
    
    public void run() {
        boolean fin = true;
        
        do {
            fin = true;
            System.out.print("\nQue operacion quieres realizar:"
                    + "\n\t + Sumar"
                    + "\n\t - Restar"
                    + "\n\t * multiplicacion"
                    + "\n\t / division"
                    + "\n-> ");
            operador = sc.nextLine().charAt(0);
            switch(operador) {
                case '+':
                    int suma = num1 + num2;
                    System.out.println(num1 + " + " + num2 + " = " + suma);
                    break;
                case '-':
                    int resta = num1 - num2;
                    System.out.println(num1 + " - " + num2 + " = " + resta);
                    break;
                case '*':
                    int mult = num1 * num2;
                    System.out.println(num1 + " * " + num2 + " = " + mult);
                    break;
                case '/':
                    int div = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + div);
                    break;
                default:
                    fin = false;
                    System.out.println("\nEl valor introducido no es válido\n");
                    break;
            }
        } while (!fin);
        
    }
    
}
