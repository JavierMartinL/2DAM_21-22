/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Cliente {

    static final String HOST = "localhost";
    static final int PUERTO = 2000;
    
    public Cliente() {
        String datos = "";
        int numero;
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            
            Socket socketCliente = new Socket(HOST, PUERTO);
            
            DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());
            
            datos = entrada.readUTF();
            System.out.println(datos);
            
            do {
                System.out.print("Introduce un número: ");
                try {
                    numero = Integer.parseInt(reader.readLine());
                    salida.writeInt(numero);
                    
                    datos = entrada.readUTF();
                    System.out.println(datos + "\n");
                } catch (Exception ex) {}
                
            } while(!datos.equals("Acertaste!"));
            
            System.out.println("FIN");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Cliente();
    }
    
}
