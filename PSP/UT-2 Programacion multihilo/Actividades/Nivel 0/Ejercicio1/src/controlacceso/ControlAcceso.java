/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacceso;

import java.util.Scanner;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class ControlAcceso extends Thread{
        
    public String nombre;
    public String dia;
    public double hora;
    
    public ControlAcceso() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del empleado : ");
        nombre = sc.next();
        System.out.print("Ingrese el dia : ");
        dia = sc.next();
        System.out.print("Ingrese la hora: ");
        hora = sc.nextDouble();
    }
    
    public ControlAcceso(String nombre, String dia, double hora) {
        this.nombre = nombre;
        this.dia = dia;
        this.hora = hora;
    }
    
    public void run() {        
        if (hora > 8.00) {
            System.out.println(nombre + " llego tarde el día " + dia);
        } else {
            System.out.println(nombre + " llego temprano el día " + dia);
        }        
    }
    
}
