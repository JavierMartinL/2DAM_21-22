/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Cliente {
    
    static final String HOST = "localhost";
    static final int PUERTO = 2000;
    
    public Cliente() {
        try {
            Socket sCliente = new Socket(HOST, PUERTO);
            
            DataInputStream flujo_entrada = new DataInputStream(sCliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(sCliente.getOutputStream());
            
            boolean acertado = false;
            System.out.println("Busca el número secreto entre 0 y 100");
            do {
                Scanner sc = new Scanner(System.in);
                System.out.print("Introduce un número: ");
                flujo_salida.writeInt(sc.nextInt());
                
                String mensaje = flujo_entrada.readUTF();
                System.out.println(mensaje);
                
                if (mensaje.contains("Acertaste")) {
                    acertado = true;
                }
            } while(!acertado);
            
            sCliente.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Cliente();
    }
}
