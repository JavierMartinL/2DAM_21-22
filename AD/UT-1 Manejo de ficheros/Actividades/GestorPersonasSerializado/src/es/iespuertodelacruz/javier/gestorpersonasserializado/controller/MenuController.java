/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.gestorpersonasserializado.controller;

import es.iespuertodelacruz.javier.gestorpersonasserializado.model.GestorFicheros;
import es.iespuertodelacruz.javier.gestorpersonasserializado.model.Persona;
import es.iespuertodelacruz.javier.gestorpersonasserializado.view.Menu;
import java.io.IOException;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class MenuController {

    Menu menu;
    GestorFicheros gestorFicheros;
    Persona persona;
    
    public MenuController() {
        menu = new Menu();
        gestorFicheros = new GestorFicheros();
        persona = new Persona();
    }
    
    public void iniciar() throws IOException {
        boolean terminar = false;
        
        do {
            int opt = 0;
            try {
                opt = menu.mostrarMenu();
                switch(opt) {
                    case 1: 
                        String[] datos = menu.agregarDatos();
                        String error = persona.guardarPersona(new Persona(
                                datos[0], 
                                datos[1], 
                                datos[2], 
                                Integer.parseInt(datos[3])
                            )
                        );
                        menu.mostrarError(error);
                        break;
                    case 2:
                        gestorFicheros.guardar(persona.getAll());
                        break;
                    case 3:
                        persona.setAll(gestorFicheros.mostrar());
                        menu.mostrarPersonas(persona.getAll());                        
                        break;
                    case 0:
                        terminar = true;
                        break;
                }
            } catch (Exception e) {}
        
        } while (!terminar);
        
    }
    
}
