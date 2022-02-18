/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidortelnet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Cliente implements Runnable {

    private String usuario;
    
    private final Socket socket;
    private String directorio;
    private boolean salir;
    
    private final Logger logger = Logger.getLogger(Cliente.class.getName());
    
    /**
     * Constructor con parametros
     * @param socket del usuario que se conecta
     * @param directorio directorio principal de servidor
     */
    public Cliente(final Socket socket, String directorio) {
        this.socket = socket;
        this.directorio = directorio;
        salir = false;
    }
    
    @Override
    public void run() {
        
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            // Login
            out.println("Usuario: ");
            usuario = reader.readLine();
            
            out.println("Contraseña: ");
            reader.readLine();
            
            logger.info("Usuario conectado: " + usuario);
            
            while(!salir) {
                out.println(listaComandos());
                String comando = reader.readLine();
                logger.info("Comando de " + usuario + " es: " + comando);
                
                String respuesta = lanzarComando(comando);
                out.println(respuesta);
            }
            
        } catch (IOException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                socket.close();
                logger.info(usuario + " se ha desconectado!");
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Fallo al cerrar el Socket", ex);
            }
        }
        
    }
    
    /**
     * Método que crea el menu que le mostraremos al usuario
     * @return String con el menu del servidor
     */
    private String listaComandos() {
        String cr = System.getProperty("os.name").matches("(W|w)indows.*") ? "\r\n" : "\n";
        StringBuilder builder = new StringBuilder();
        builder.append(cr);
        builder.append("Lista de comandos: ");
        builder.append(cr);
        builder.append(cr);
        builder.append("ls: listar el directorio");
        builder.append(cr);
        builder.append("more : [ more prueba.txt ]");
        builder.append(cr);
        builder.append("exit : terminar ejecucion");
        builder.append(cr);
        return builder.toString();
    }
    
    /**
     * Método que controla que comando lanza un usuario
     * @param comando lanzado por el usuario
     * @return respuesta con la informacion del comando
     */
    private String lanzarComando(String comando) {
        String respuesta = "";
        if (comando.matches("^ls.*")) {
            respuesta = mostrarDirectorio();
        } else if (comando.matches("^more .*")) {
            respuesta = mostrarFichero(comando);
        } else if (comando.equalsIgnoreCase("exit")) {
            salir = true;
            respuesta = "Adios, Hasta pronto!!!";
        } else {
            respuesta = "El comando introducido [ " + comando + " ] no es valido";
            logger.log(Level.WARNING, "[" + comando + "] es un comando incorrecto");
        }
        return respuesta;
    }
    
    /**
     * Método que muestra el contenido del directorio actual
     * @return Mensaje con los datos del directorio
     */
    private String mostrarDirectorio() {
        String cr = System.getProperty("os.name").matches("(W|w)indows.*") ? "\r\n" : "\n";
        StringBuilder builder = new StringBuilder();
        builder.append(cr);
        for (String file : new File(directorio).list()) {
            builder.append(new File(directorio + File.separator + file).isDirectory() ? "d - " + file : "f - " + file);
            builder.append(cr);
        }
        return builder.toString();
    }
    
    /**
     * Método que muestra el contenido del fichero en concreto
     * @param comando con la ruta del fichero
     * @return contenido del fichero
     */
    private String mostrarFichero(String comando) {
        
        String cr = System.getProperty("os.name").matches("(W|w)indows.*") ? "\r\n" : "\n";
        StringBuilder builder = new StringBuilder();
        builder.append(cr);
        
        String nombreFichero = comando.split(" ", 2)[1];
        
        File fichero = new File(nombreFichero);
        
        try (BufferedReader reader = Files.newBufferedReader(fichero.toPath()) ){ 
            logger.info("Leyendo el fichero: " + nombreFichero);
            String line;
            while ( (line = reader.readLine ()) != null ){
                builder.append(line);
                builder.append(cr);
            }
            reader.close();
        } catch (IOException e) {
            logger.log(Level.WARNING, "No se encuentra el fichero " + nombreFichero);
            builder.append("No se encuentra el fichero que quieres mostrar");
            builder.append(cr);
        }
        return builder.toString();
    }
    
}
