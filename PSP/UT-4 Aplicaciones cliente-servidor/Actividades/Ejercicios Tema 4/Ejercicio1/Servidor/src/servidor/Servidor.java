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
public class Servidor {

    static final int PUERTO = 2000;
    
    private int secreto;
    private boolean acertado;
    
    public Servidor() {
        try {
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho en el puerto " + PUERTO);
            
            generarSecreto();
            
            Socket sCliente = skServidor.accept();
            DataInputStream flujo_entrada = new DataInputStream(sCliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(sCliente.getOutputStream());

            while (!acertado) {
                int numero = flujo_entrada.readInt();
                
                String mensaje = comprobarNumero(numero);
                System.out.println(mensaje);
                
                flujo_salida.writeUTF(mensaje);
            }
            
            sCliente.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
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
            mensaje = "Acertaste! El secreto es " + secreto;
            acertado = true;
        }
        
        return mensaje;
    }
    
}
