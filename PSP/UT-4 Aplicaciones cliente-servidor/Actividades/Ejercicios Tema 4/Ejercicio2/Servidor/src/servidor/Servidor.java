/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Servidor extends Thread {
    
    Socket socketCliente;
    static final int PUERTO = 1500;
    
    public Servidor(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("Escucho en el puerto " + PUERTO);
            
            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("\nCliente Conectado");
                new Servidor(cliente).start();
            }
            
        } catch (Exception e) { }
    }
    
    public void run() {
        try {
            
            DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());
            
            String fichero = entrada.readUTF();
            String strLinea;
            System.out.println("\tEl cliente quiere leer el fichero: " + fichero);
            
            try {
                FileInputStream fstream = new FileInputStream(fichero);
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
                while ((strLinea = br.readLine()) != null) {
                    salida.writeUTF(strLinea);
                }
                
                in.close();
                
                System.out.println("\tFichero enviado correctamente");
                salida.writeUTF("EOF");
                
            } catch (Exception e) {
                salida.writeUTF("Error, el fichero no existe");
                System.out.println("\tError, el fichero no existe");
                salida.writeUTF("EOF");
            }
            
            strLinea = entrada.readUTF();
            
            socketCliente.close();
            System.out.println("Cliente Desconectado");
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
