/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.numerosprimosmenores.view;

import java.util.Scanner;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Menu {
    
    Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
    }
    
    public int limitePrimos() {
        System.out.print("Calcular los números primos menores a: "
                + "\n\t1) Introducir limite"
                + "\n\t0) Limite por defecto"
                + "\n->");
        return sc.nextInt();
    }
    
    public int maxNumerosPrimos() {
        System.out.print("\nIntroduce el max"
                + "\n->");
        return sc.nextInt();
    }
    
    public int tipoAlmacenamiento() {
        System.out.print("\nComo almacenar los números primos: "
                + "\n\t1) De uno en uno"
                + "\n\t0) Todos a la vez"
                + "\n->");
        return sc.nextInt();
    }
    
}
