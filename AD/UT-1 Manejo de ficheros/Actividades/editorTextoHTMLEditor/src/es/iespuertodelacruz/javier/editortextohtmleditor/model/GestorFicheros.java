/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.editortextohtmleditor.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class GestorFicheros {
    
    private File ficheroActual;
    
    /**
     * Se encarga de leer un fichero
     * @param path dirección del fichero
     * @return texto con el contenido del fichero
     */
    public String abrir(Path path) {
        this.ficheroActual = new File(path.toString());
        String texto = "";
        
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            
            // Segun el tipo de fichero se lee de una manera
            if (!extensionHtml()) {
                while ( (line = reader.readLine()) != null )
                    texto += "<p>" + line + "</p>";
                reader.close();
                texto = pasarHtml(texto);
            } else {
                while ( (line = reader.readLine()) != null )
                    texto += line;
                reader.close();
            }
                        
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
        if (!extensionHtml()) {
            texto = pasarTextoPlano(texto);
        }
        
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
     * @param path el nuevo fichero
     * @param texto contenido que vamos a guardar
     */
    public void guardar(Path path, String texto) {
        this.ficheroActual = new File(path.toString());
        guardar(texto);
    }
    
    /**
     * Comprobar el tipo de extension del fichero
     * @return true si es ".html"
     */
    private boolean extensionHtml() {
        String nombre = ficheroActual.getName();
        return nombre.substring(nombre.lastIndexOf(".")).equals(".html");
    }
    
    /**
     * Convertir el texto plano en HTML para que el editor pueda leer los espacios
     * @param texto plano
     * @return texto en formato HTML
     */
    private String pasarHtml(String texto) {
        String html = "<hmtl><head></head><body>";
        html += texto.replaceAll(" ", "&nbsp;");
        html += "</body></html>";
        return html;
    }
    
    /**
     * Convertir el texto HTML en texto plano
     * @param texto html
     * @return texto plano
     */
    private String pasarTextoPlano(String texto) {
        texto = texto.replaceAll("</(h1|h2|h3|h4|h5|h6|p)>", "\n");
        texto = texto.replaceAll("<[^>]*>", "");
        texto = texto.replaceAll("&nbsp;", " ");
        return texto;
    }

    public File getFicheroActual() {
        return ficheroActual;
    }

    public void setFicheroActual(File ficheroActual) {
        this.ficheroActual = ficheroActual;
    }
    
}
