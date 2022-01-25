/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Servidor extends Thread {
    
    Socket socketCliente;
    static final int PUERTO = 2000;
    
    private int secreto;
    private boolean acertado;
    
    public Servidor(Socket socketCliente) {
        this.socketCliente = socketCliente;
        generarSecreto();
    }
    
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
            
            salida.writeUTF("Tienes que adivinar un número del 0 al 100");
            
            while (!acertado) {
                int numero = entrada.readInt();
                
                String mensaje = comprobarNumero(numero);
                System.out.println(mensaje);
                
                salida.writeUTF(mensaje);
            }
            
            socketCliente.close();
            System.out.println("Cliente Desconectado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void generarSecreto() {
        secreto = (int) (Math.random() * 101);
        acertado = false;
    }
    
    private String comprobarNumero(int numero) {
        String mensaje;
        
        if (numero > secreto) {
            mensaje = numero + " es mayor que el secreto";
        } else if (numero < secreto) {
            mensaje = numero + " es mas pequeño que el secreto";
        } else {
            mensaje = "Acertaste!";
            acertado = true;
        }
        
        return mensaje;
    }
    
}
