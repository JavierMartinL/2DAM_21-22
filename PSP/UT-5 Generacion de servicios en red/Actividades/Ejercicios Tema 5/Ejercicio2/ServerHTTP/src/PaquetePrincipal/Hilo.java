 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaquetePrincipal;

import java.net.Socket;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Hilo extends Thread {
    
    private Socket socketCliente;
    
    public Hilo(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }
    
    public void run() {
        try {
            ServidorHTTP.procesaPeticion(socketCliente);
            
            socketCliente.close();
            System.out.println("Cliente atendido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
