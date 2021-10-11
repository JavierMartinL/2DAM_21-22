/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estaciones;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Estaciones extends Thread{
    
    Scanner sc = new Scanner(System.in);
    String[] estaciones = { "Primavera", "Verano", "Otoño", "Invierno" };
    
    public void run() {
        for (String estacion : estaciones) {
            System.out.println(estacion);
        }
        
        System.out.print("\nIntroduce la estacion: ");
        String estacion = sc.nextLine();
        
        estacion = estacion.toLowerCase();
        
        if (estacion.equals(estaciones[0].toLowerCase())) {
            try {
                System.out.println("\tMarzo");
                Thread.sleep(1000);
                System.out.println("\n\tAbril");
                Thread.sleep(1000);
                System.out.println("\n\tMayo");
            } catch (InterruptedException ex) {}
        } else if (estacion.equals(estaciones[1].toLowerCase())) {
            try {
                System.out.println("\tJunio");
                Thread.sleep(1000);
                System.out.println("\n\tJulio");
                Thread.sleep(1000);
                System.out.println("\n\tAgosto");
            } catch (InterruptedException ex) { }
        } else if (estacion.equals(estaciones[2].toLowerCase())) {
            try {
                System.out.println("\tSeptiembre");
                Thread.sleep(1000);
                System.out.println("\n\tOctubre");
                Thread.sleep(1000);
                System.out.println("\n\tNoviembre");
            } catch (InterruptedException ex) { }
        } else if (estacion.equals(estaciones[3].toLowerCase())) {
            try {
                System.out.println("\tDiciembre");
                Thread.sleep(1000);
                System.out.println("\n\tEnero");
                Thread.sleep(1000);
                System.out.println("\n\tFebrero");
            } catch (InterruptedException ex) { }
        }
    }
    
}
