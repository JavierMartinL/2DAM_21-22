/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.gestorpersonasfijo.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class GestorFichero {
    
    private final int SIZECHAR = 2;
    
    File fichero;

    public GestorFichero() { }
    
    public GestorFichero(String fichero) {
        this.fichero = new File(fichero);
    }
    
    /**
     * Buscar todas las personas que han sido guardadas en el fichero
     * @return Lista de Personas dentro del fichero
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public ArrayList<Persona> getAll() throws FileNotFoundException, IOException {
        ArrayList<Persona> personas = new ArrayList<>();
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
            int numPersonas = (int) (raf.length() / (ControlPersona.sizeNombre + ControlPersona.sizeApellido + ControlPersona.sizeEdad)) / SIZECHAR;
        
            for (int i = 1; i <= numPersonas; i++) {
                personas.add(getPersona(i));
            }
        }
        
        return personas;
    }
    
    /**
     * Buscar una persona dentro del fichero
     * @param numPersona Posicion de la persona
     * @return una Persona
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public Persona getPersona(int numPersona) throws FileNotFoundException, IOException {
        ControlPersona cp = new ControlPersona();
        
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
            long pos = (numPersona - 1) * ((ControlPersona.sizeNombre + ControlPersona.sizeApellido + ControlPersona.sizeEdad) * SIZECHAR);
        
            if (raf.length() > pos && pos >= 0) {
                cp.nombre = readString(raf, pos, ControlPersona.sizeNombre);
                pos += ControlPersona.sizeNombre * SIZECHAR;
                cp.apellido = readString(raf, pos, ControlPersona.sizeApellido);
                pos += ControlPersona.sizeApellido * SIZECHAR;
                cp.edad = readString(raf, pos, ControlPersona.sizeEdad);
                return cp.toPersona();
            }
        }
        
        return null;
    }
    
    /**
     * Guardar una nueva persona dentro del fichero
     * @param persona Persona que vamos a gardar
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void addPersona(Persona persona) throws FileNotFoundException, IOException {
        ControlPersona controlPersona = new ControlPersona(
                persona.getNombre(),
                persona.getApellido(),
                persona.getEdad()
        );
        
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rwd")) {
            guardarRegistro(raf, controlPersona, raf.length());
        }
    }
    
    /**
     * Cambiar los datos de una persona que existe dentro del fichero
     * @param persona Datos de la persona que vamos a guardar
     * @param numPersona Posicion de la persona que vamos a modificar
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void sustituir(Persona persona, int numPersona) throws FileNotFoundException, IOException {
        ControlPersona controlPersona = new ControlPersona(
                persona.getNombre(),
                persona.getApellido(),
                persona.getEdad()
        );
        
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rwd")) {
            long pos = (numPersona - 1) * ((ControlPersona.sizeNombre + ControlPersona.sizeApellido + ControlPersona.sizeEdad) * SIZECHAR);
            guardarRegistro(raf, controlPersona, pos);
        }
    }
    
    private String readString (RandomAccessFile raf, long comienzo, int cantidad) throws IOException {
        raf.seek(comienzo);
        char campo[] = new char[cantidad];
        for (int i = 0; i < cantidad; i++) {
            campo[i] = raf.readChar();
        }
        
        return new String(campo);
    }
    
    private boolean guardarRegistro(RandomAccessFile raf, ControlPersona cp, long posicion) throws FileNotFoundException, IOException {
        boolean guardadoOk = false;
        
        if (raf.length() >= posicion) {
            raf.seek(posicion);
            raf.writeChars(cp.nombre);
            raf.writeChars(cp.apellido);
            raf.writeChars(cp.edad);
            raf.close();
            guardadoOk = true;
        } 
        return guardadoOk;
    }
   
}
