/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.javierexamenparte2.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class ManejoFichero {
    
    private File file;
    
    public ManejoFichero(String nombre){
        file = new File(nombre);
    }
    
    public boolean agregarTexto(String texto) throws IOException{
        boolean agregadoOK = false;
        
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(),
                StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            writer.write(texto);
            agregadoOK = true;
        } catch (IOException ex) {
            agregadoOK = false;
        }
        
        return agregadoOK;
    }
    
    public boolean borrarYAgregar(String texto){
        boolean agregadoOK = false;
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(),
                StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE)) {
            writer.write(texto);
            agregadoOK = true;
        } catch (IOException ex) {
            agregadoOK = false;
        }
        return agregadoOK;
    }
    
    public String leerTodo() throws IOException{
        String texto = "";
        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            String line;
            while ((line = reader.readLine()) != null)
                texto += line + "\n";
        } catch (IOException e) {
            System.err.println("ERROR: " + e);
        }
        return texto;
    }
}
