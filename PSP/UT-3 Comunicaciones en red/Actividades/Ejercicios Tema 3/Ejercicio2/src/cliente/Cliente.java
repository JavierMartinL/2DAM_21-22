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
    static final int PUERTO = 1500;
    
    public Cliente() {
        try {
            Socket sCliente = new Socket(HOST, PUERTO);
            
            Scanner sc = new Scanner(System.in);
            DataInputStream flujo_entrada = new DataInputStream(sCliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(sCliente.getOutputStream());
            
            System.out.print("Introduce la ruta del fichero: ");
            flujo_salida.writeUTF(sc.nextLine());
            
            System.out.println(flujo_entrada.readUTF());
            
            sCliente.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Cliente();
    }
}
