/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Servidor {
    
    static final int PUERTO = 1500;
    
    public Servidor() {
        try {
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho en el puerto " + PUERTO);
                        
            Socket sCliente = skServidor.accept();
            DataInputStream flujo_entrada = new DataInputStream(sCliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(sCliente.getOutputStream());
            
            String ruta = flujo_entrada.readUTF();
            
            File fichero = new File(ruta);
            
            String mensaje;
            if (fichero.exists()){
                mensaje = leerFichero(fichero);
                
                if (mensaje.trim().isEmpty()) {
                    mensaje = "El fichero esta vacio";
                }
                
            } else {
                mensaje = "El fichero no existe";
            }
            
            flujo_salida.writeUTF(mensaje);
            
            sCliente.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public String leerFichero(File fichero) {
        String texto = "";
        
        try (BufferedReader reader = Files.newBufferedReader(fichero.toPath()) ){ 
            String line;
            while ( (line = reader.readLine ()) != null )
                texto += line + "\n";
        } catch (IOException e) {
            System.err.println ("ERROR: " + e);
            texto = "Error al acceder";
        }
        
        return texto;
    }
    
    public static void main(String[] args) {
        new Servidor();
    }
}
