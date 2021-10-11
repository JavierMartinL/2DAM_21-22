/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.gestorpersonasserializado.view;

import es.iespuertodelacruz.javier.gestorpersonasserializado.model.Persona;
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
                + "\n\t1) Agregar Persona"
                + "\n\t2) Guardar Personas en el fichero"
                + "\n\t3) Mostrar Personas del fichero"
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
        for (Persona persona : lista) {
            System.out.println(persona);
        }
    }
    
    public void mostrarError(String error) {
        if (!error.equals("")) {
            String informacion = "";
            switch (error) {
                case "Usuario_Repetido":
                    informacion = "Ya existe una persona con este DNI";
                    break;
                case "DNI_Nulo":
                    informacion = "El DNI introducido no es válido";
                    break;
            }
            System.out.println(informacion);
        }        
    }
    
}
