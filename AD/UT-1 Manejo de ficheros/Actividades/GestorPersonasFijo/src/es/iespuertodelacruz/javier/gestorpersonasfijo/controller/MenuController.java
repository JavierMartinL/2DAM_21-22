/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.gestorpersonasfijo.controller;

import es.iespuertodelacruz.javier.gestorpersonasfijo.model.GestorFichero;
import es.iespuertodelacruz.javier.gestorpersonasfijo.model.Persona;
import es.iespuertodelacruz.javier.gestorpersonasfijo.view.Menu;
import java.io.IOException;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class MenuController {
    
    Menu menu = new Menu();
    GestorFichero gf = new GestorFichero("ficheroPersonas.txt");
    
    public void iniciar() throws IOException {
        boolean terminar = false;
        
        do {
            int opt = 0;
            try {
                opt = menu.mostrarMenu();
                switch(opt) {
                    case 1: 
                        String[] datos = menu.datosPersona();
                        gf.addPersona(new Persona(
                                datos[0],
                                datos[1],
                                Integer.parseInt(datos[2])
                        ));
                        break;
                    case 2:
                        menu.mostrarPersonas(gf.getAll());                        
                        break;
                    case 3:
                        Persona persona = gf.getPersona(menu.buscarPersona());
                        menu.mostrarPersona(persona);
                        break;
                    case 4:
                        int pos = menu.buscarPersona();
                        String[] modDatos = menu.datosPersona();
                        
                        Persona modPersona = gf.getPersona(pos);
                        modPersona.setNombre(modDatos[0]);
                        modPersona.setApellido(modDatos[1]);
                        modPersona.setEdad(Integer.parseInt(modDatos[2]));
                        
                        gf.sustituir(modPersona, opt);
                        break;
                    case 0:
                        terminar = true;
                        break;
                }
            } catch (Exception e) {}
        
        } while (!terminar);
    }
    
}