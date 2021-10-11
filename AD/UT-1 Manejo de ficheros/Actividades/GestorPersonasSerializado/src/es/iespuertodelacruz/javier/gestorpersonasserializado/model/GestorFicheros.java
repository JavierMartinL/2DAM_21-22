/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.gestorpersonasserializado.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class GestorFicheros {
    
    public void guardar(ArrayList<Persona> personas) throws FileNotFoundException, IOException {
        try (
            FileOutputStream fos = new FileOutputStream(new File("personas.txt"));
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            ){
            
            for (Persona persona : personas) {
                oos.writeObject(persona);
            }
            
        }
        
    }
    
    public ArrayList<Persona> mostrar() throws FileNotFoundException, IOException {
        ArrayList<Persona> personas = new ArrayList<>();
        
        try (
                FileInputStream fis = new FileInputStream(new File("personas.txt"));
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
            ){
            boolean finFichero = false;
            Persona p;
            do {                
                try {
                    p = (Persona)ois.readObject();
                    personas.add(p);
                } catch (Exception e) {
                    finFichero = true;
                }
            } while (!finFichero);
        }
        
        return personas;
    }
    
}
