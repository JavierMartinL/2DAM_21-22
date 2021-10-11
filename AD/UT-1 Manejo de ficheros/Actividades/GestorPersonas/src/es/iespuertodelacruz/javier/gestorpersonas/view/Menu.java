/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.gestorpersonas.view;

import es.iespuertodelacruz.javier.gestorpersonas.model.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Menu {
    
    Scanner sc = new Scanner(System.in);
    
    public int mostrarMenu() {
        System.out.print("\nMenu:"
                + "\n\t1) Crear Persona"
                + "\n\t2) Mostrar Personas del fichero"
                + "\n\t0) Salir"
                + "\n-> ");
        int opt;
        try {
            opt = sc.nextInt();
        } catch (Exception e) {
            opt = 1000000;
            sc.next();
        }
        return opt;
    }
    
    public String[] agregarDatos() {
        sc.nextLine();
        String[] datos = new String[4];
        
        System.out.print("\nDatos:"
                + "\n\tNombre: ");
        datos[0] = sc.nextLine();
        
        System.out.print("\tApellidos: ");
        datos[1] = sc.nextLine();
        
        System.out.print("\tDNI: ");
        datos[2] = sc.nextLine();
        
        System.out.print("\tEdad: ");
        datos[3] = sc.nextLine();
        
        return datos;
    }
    
    public void mostrarPersonas(ArrayList<Persona> lista) {
        System.out.println("Personas guardadas en el fichero");
        for (Persona persona : lista) {
            System.out.println(persona + "\n");
        }
    }
    
}
