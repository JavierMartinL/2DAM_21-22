/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontareasavanzado.model;

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
public class GestorFichero {

    File fichero;
        
    public GestorFichero() throws IOException {
        fichero = new File("tareasSerializadas.txt");
    }
    
    /**
     * Método que almacena en el fichero todas las tareas
     * @param tareas Lista de tareas
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void guardar(ArrayList<Tarea> tareas) throws FileNotFoundException, IOException {
        try (
                FileOutputStream fos = new FileOutputStream(fichero);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos);
            ) {
            
            for (Tarea tarea : tareas) {
                oos.writeObject(tarea);
            }
            
        }
    }
    
    /**
     * Método que recoge todas las tareas del fichero
     * @return Lista de Tareas
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public ArrayList<Tarea> mostrar() throws FileNotFoundException, IOException {
        ArrayList<Tarea> tareas = new ArrayList<>();
        
        try (
                FileInputStream fis = new FileInputStream(fichero);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
            ){
            boolean finFichero = false;
            Tarea t;
            do {                
                try {
                    t = (Tarea)ois.readObject();
                    tareas.add(t);
                } catch (Exception e) {
                    finFichero = true;
                }
            } while (!finFichero);
        }
        
        return tareas;
    }
    
}
