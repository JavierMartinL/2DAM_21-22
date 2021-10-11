/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atleta;

import java.util.Scanner;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Atleta extends Thread{
    
    Scanner sc = new Scanner(System.in);
    private int km;
    private String nombre;

    public Atleta() {
        this(30);
    }
    
    public Atleta(int km) {
        this.km = km;
    }
    
    public void run() {
        System.out.print("Nombre del atleta: ");
        nombre = sc.nextLine();
        
        for (int i = 1; i <= km; i++) {
            try {
                Thread.sleep(3500);
            } catch(InterruptedException e) { }
            System.out.print(" " + i + "km ");
        }
    }
    
}
