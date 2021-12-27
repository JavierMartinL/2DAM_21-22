/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Factorial extends Thread {
    
    public static int cantidad = 1;
    private int numero;

    public Factorial(int numero) {
        this.numero = numero;
    }
    
    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {}
        
        cantidad *= numero;
        if (numero > 1) {
            System.out.print(numero + " * ");
        } else {
            System.out.println(numero + " = " + cantidad);
        }
    }
    
}
