/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.gestorpersonas.controller;

import es.iespuertodelacruz.javier.gestorpersonas.model.Persona;
import es.iespuertodelacruz.javier.gestorpersonas.model.RegistroPersona;
import es.iespuertodelacruz.javier.gestorpersonas.view.Menu;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class MenuController {
    
    Menu menu;
    RegistroPersona registroPersona;
    Persona persona;

    public MenuController() {
        this.menu = new Menu();
        this.registroPersona = new RegistroPersona();
        this.persona = new Persona();
    }
    
    public void iniciar() {
        boolean terminar = false;
        
        do {
            int opt = 0;
            try {
                opt = menu.mostrarMenu();
                switch(opt) {
                    case 1: 
                        String[] datos = menu.agregarDatos();
                        registroPersona.addPersona(new Persona(
                                datos[0], 
                                datos[1], 
                                datos[2], 
                                Integer.parseInt(datos[3])
                            )
                        );
                        break;
                    case 2:
                        menu.mostrarPersonas(registroPersona.getAll());                        
                        break;
                    case 0:
                        terminar = true;
                        break;
                }
            } catch (Exception e) {}
        
        } while (!terminar);
    }
    
}
