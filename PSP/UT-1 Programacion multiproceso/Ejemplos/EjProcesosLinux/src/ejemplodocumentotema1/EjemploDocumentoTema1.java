/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplodocumentotema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class EjemploDocumentoTema1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         System.out.println("Ejemplo de uso de System");
        System.out.println("Listado del directorio actual y envío a un fichero");
        
        
   try {
           Process p = Runtime.getRuntime().exec ("ls -la /home/dama");
           // Se obtiene el stream de salida del programa
            InputStream is = p.getInputStream();
            
            /* Se prepara un bufferedReader para poder leer la salida más comodamente. */
            BufferedReader br = new BufferedReader (new InputStreamReader (is));
            
            // Se lee la primera linea
            String aux = br.readLine();
            
            // Mientras se haya leido alguna linea
            while (aux!=null)
            {
                // Se escribe la linea en pantalla
                System.out.println (aux);
                
                // y se lee la siguiente.
                aux = br.readLine();
            }
           //long pid = ProcessHandle.current().pid();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
