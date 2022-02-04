/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.*;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    private static Logger logger;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        logger = crearLogger();
        
        String usuario;
        String fichero;
        
        do {
            System.out.print("Introduce el nombre del usuario: ");
            usuario = sc.nextLine();
        } while (!validarUsuario(usuario));
        
        System.out.println("\nPuedes porbar con \"prueba.txt\"\n");
        
        do {
            System.out.print("Introduce el nombre del fichero: ");
            fichero = sc.nextLine();
        } while (!validarFichero(fichero));
        
        mostrarFichero(fichero);
    }

    /**
     * Metodo que valida si el nombre de Usuario introducido contiene 8 caracteres
     * compuesto por letras minusculas
     * @param nombre nombre del Usuario
     * @return True si es valido | False si no es valido
     */
    private static boolean validarUsuario(String nombre) {
        Pattern pat = Pattern.compile("[a-z]{8}");
        Matcher mat = pat.matcher(nombre);
        
        if (mat.matches()) {
            return true;
        } else {
            logger.log(
                    Level.WARNING, 
                    "El nombre de Usuario debe tener 8 caracteres entre la a y la z");
            return false;
        }
    }
    
    /**
     * Metodo que valida si el nombre del Fichero introducido contiene un maximo
     * de 8 caracteres y con una extension de 3 caracteres
     * @param nombreFichero nombre del Fichero
     * @return True si es valido | False si no es valido
     */
    private static boolean validarFichero(String nombreFichero) {
        Pattern pat = Pattern.compile("[a-zA-z0-9]{1,8}[.][a-zA-Z]{3}");
        Matcher mat = pat.matcher(nombreFichero);
        
        if (mat.matches()) {
            return true;
        } else {
            logger.log(
                    Level.WARNING, 
                    "El nombre del Fichero debe tener como máximo 8 caracteres y una extensión de 3 caracteres");
            return false;
        }
    }
    
    /**
     * Metodo que muestra por consola el contenido de un fichero
     * @param nombreFichero nombre del fichero que queremos mostrar
     */
    private static void mostrarFichero(String nombreFichero) {
        File fichero = new File(nombreFichero);
        String texto = "\t*** Contenido del Fichero ***\n\n";
        
        try (BufferedReader reader = Files.newBufferedReader(fichero.toPath()) ){ 
            String line;
            while ( (line = reader.readLine ()) != null )
                texto += line + "\n";
            reader.close();
            System.out.println("\n" + texto);
        } catch (IOException e) {
            logger.log(
                    Level.WARNING,
                    "Error al intentar leer el fichero \"" + nombreFichero + "\" puede ser que no exista");
        }
    }
    
    /**
     * Metodo encargado de crear el Logger y el fichero donde almacenamos los datos
     * @throws IOException 
     */
    private static Logger crearLogger() throws IOException {
        Logger logger = Logger.getLogger("FicheroLog");
        FileHandler fh = new FileHandler("FicheroLog.log", true);
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
        logger.setLevel(Level.ALL);
        
        return logger;
    }

}
