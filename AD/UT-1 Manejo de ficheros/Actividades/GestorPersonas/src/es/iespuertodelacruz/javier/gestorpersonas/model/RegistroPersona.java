/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.gestorpersonas.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class RegistroPersona {
    
    Path path = Paths.get("personas.txt");
    
    public RegistroPersona() { }
    
    public RegistroPersona(String nombreFichero) {
        path = Paths.get(nombreFichero);
    }
    
    public void addPersona(Persona p) throws IOException {
        
        boolean ok = true;
        Persona paux = getPersona(p.getDni());
        
        ok = paux == null;
        
        if (ok) {
            try (
                PrintWriter pw = new PrintWriter(
                    new BufferedWriter(
                        new FileWriter(path.toFile(), true)
                    )
                )
            ) {

                //la linea formato: nombre, apellidos, dni, edad, altura, peso
                String registro = p.getNombre() + ";" +
                        p.getDni() + ";" +
                        p.getEdad();
                pw.println(registro);

            } catch (IOException ex) { }
        }        
        
    }
    
    public Persona getPersona(String dni) throws IOException {
        Persona persona = null;
        
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String strPersona = "";
            
            while ((strPersona = reader.readLine()) != null) {
                
                String arrpersona[] = strPersona.split(";");
//                if (arrpersona[2].toUpperCase(dni)) {
//                    
//                }
                
            }
            
//            reader.lines()
//                    .forEach( p -> {
//                        String[] arrypersona = p.split(";");
//                        if (arrypersona[1].equals(dni)) {
//                            persona = new Persona(arrypersona[0], arrypersona[1], Integer.parseInt(arrypersona[2]));
//                        }
//                    });
        }
        return persona;
    }
    
    public ArrayList<Persona> getAll() throws IOException {
        ArrayList<Persona> personas = new ArrayList<>();
        
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.lines()
                    .forEach( p -> {
                        String[] persona = p.split(";");
                        personas.add(new Persona(
                                persona[0], 
                                persona[1], 
                                Integer.parseInt(persona[2]))
                        );
                    });
        } 
        
        return personas;
    }
    
}
