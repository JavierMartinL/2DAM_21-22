/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.editortextotextarea.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class GestorFicheros {
    
    private File ficheroActual;
    
    /**
     * Se encarga de leer un fichero
     * @param fichero que queremos leer
     * @return el contenido del fichero
     */
    public String abrir(File fichero) {
        // Guardar el fichero con el que vamos a trabajar
        this.ficheroActual = fichero;
        String texto = "";
        
        try (BufferedReader reader = Files.newBufferedReader(fichero.toPath()) ){ 
            String line;
            while ( (line = reader.readLine ()) != null )
                texto += line + "\n";
            reader.close();
            return texto;
        } catch (IOException e) {
            System.err.println ("ERROR: " + e);
        }
        
        return texto;
    }
    
    /**
     * Se encarga de guardar el texto que recibimos dentro de un fichero
     * @param texto contenido que vamos a guardar
     */
    public void guardar(String texto) {        
        try {
            FileWriter fileWriter = new FileWriter(this.ficheroActual);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(texto);
            writer.close();
        } catch (IOException e) {
            System.err.println ("ERROR: " + e);
        }        
    }
    
    /**
     * Se encarga de guardar el texto que recibimos dentro de un nuevo fichero
     * @param fichero el nuevo fichero
     * @param texto contenido que vamos a guardar
     */
    public void guardar(File fichero, String texto) {
        this.ficheroActual = fichero;
        guardar(texto);
    }
    
    /**
     * Comprobar si existe cambios en fichero con el que estamos trabajando
     * @param texto contenido que vamos a comprobar
     * @return si hay cambios o no
     */
    public boolean comprobarCambios(String texto) {
        String textoFichero = abrir(ficheroActual);        
        return !texto.equals(textoFichero);
    }

    public File getFichero() {
        return ficheroActual;
    }

    public void setFichero(File fichero) {
        this.ficheroActual = fichero;
    }
    
}
