/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortextotextarea.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class GestorFicheros {
    
    private File ficheroActual;
    
    public String abrir(File fichero) {
        this.ficheroActual = fichero;
        String texto = "";
        
        try (BufferedReader reader = Files.newBufferedReader(fichero.toPath()) ){ 
            String line;
            while ( (line = reader.readLine ()) != null )
                texto += line + "\n";
            return texto;
        } catch (IOException e) {
            System.err.println ("ERROR: " + e);
        }
        
        return texto;
    }
    
    public void guardar(String texto) {
        
    }
    
    public void guardarComo(File fichero, String texto) {
        this.ficheroActual = fichero;
        System.out.println(this.ficheroActual);
        System.out.println(fichero.compareTo(this.ficheroActual));
    }
    
    public boolean comprobarCambios(String texto) {
        try {
            String text = "";
            Scanner scn = new Scanner(ficheroActual);
                while (scn.hasNext()) {
                    text += scn.nextLine() + "\n";
//                    txaInformacion.insert(scn.nextLine() + "\n", txaInformacion.getText().length());
                }
                if (!text.equals(texto)){
                    return true;
                }
                } catch (FileNotFoundException ex) {
            //Logger.getLogger(PrimeraInterfazJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public File getFichero() {
        return ficheroActual;
    }

    public void setFichero(File fichero) {
        this.ficheroActual = fichero;
    }
    
}
