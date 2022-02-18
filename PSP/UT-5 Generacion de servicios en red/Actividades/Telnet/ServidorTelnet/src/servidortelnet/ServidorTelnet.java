/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidortelnet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class ServidorTelnet {
    
    private ServerSocket serverSocket = null;
    
    private final int PUERTO = 5000;
    private final ExecutorService executorService = Executors.newFixedThreadPool(120);
    private final String directorio = System.getProperty("user.dir");
    
    private final Logger logger = Logger.getLogger(ServidorTelnet.class.getName());
    
    public ServidorTelnet() { }
    
    public void run() {
        
        try {
            // Creamos el servidor
            serverSocket = new ServerSocket(PUERTO);
            
            logger.info("El servidor esta corriendo en el puerto: " + PUERTO);
            
            // Esperamos a que algun usuario se conecte al servidor
            while (true) {
                Socket socket = serverSocket.accept();
                // Lanzamos un hilo para la nueva conexion
                executorService.execute(new Cliente(socket, directorio));
            }
            
        } catch(Exception ex) {
            logger.log(Level.WARNING, "Apagando el servidor...");
        } finally {
            executorService.shutdown();
        }
        
    }
    
    /**
     * Comprobar que el server esta corriendo
     * @return 
     */
    public boolean isRunning() {
        return !serverSocket.isClosed();
    }
    
    /**
     * Cerrar todas las conexiones y el servidor
     * @throws IOException 
     */
    public void shutDown() throws IOException {
        if (serverSocket != null) {
            serverSocket.close();
        }
    }
    
}
