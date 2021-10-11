/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.gestorpersonasfijo.view;

import es.iespuertodelacruz.javier.gestorpersonasfijo.model.Persona;
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
                + "\n\t2) Mostrar todas las Personas"
                + "\n\t3) Buscar una Persona"
                + "\n\t4) Sustituir una Persona"
                + "\n\t0) Salir"
                + "\n-> ");
        int opt;
        try {
            opt = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            opt = 1000000;
            sc.nextLine();
        }
        return opt;
    }
    
    public String[] datosPersona() {
        String[] datos = new String[4];
        
        System.out.print("\nDatos:"
                + "\n\tNombre: ");
        datos[0] = sc.nextLine();
        
        System.out.print("\tApellidos: ");
        datos[1] = sc.nextLine();
        
        System.out.print("\tEdad: ");
        datos[2] = sc.nextLine();
        
        return datos;
    }
    
    public void mostrarPersona(Persona persona) {
        System.out.println(persona);
    }
    
    public void mostrarPersonas(ArrayList<Persona> lista) {
        System.out.println("Personas guardadas en el fichero");
        int pos = 1;
        for (Persona persona : lista) {
            System.out.println("Num " + pos++ + ": " + persona + "\n");
        }
    }
    
    public int buscarPersona() {
        System.out.println("Indica la posición de la persona que buscas");
        System.out.print("-> ");
        int pos = sc.nextInt(); sc.nextLine();
        return pos;
    }
    
}
