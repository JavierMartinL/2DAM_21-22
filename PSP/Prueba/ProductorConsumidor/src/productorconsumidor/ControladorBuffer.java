/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class ControladorBuffer {

    private char buffer[] = new char[6];
    private int siguiente = 0;
    
    private boolean estaLleno = false;
    private boolean estaVacio = true;
    
    public synchronized char recoger() {
        while (estaVacio == true) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        siguiente--;
        if (siguiente == 0)
            estaVacio = true;
        estaLleno = false;
        notify();
        return buffer[siguiente];
    }
    
    public synchronized void lanzar(char caracter) {
        while(estaLleno == true) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        buffer[siguiente] = caracter;
        siguiente++;
        if (siguiente == 6)
            estaLleno = true;
        estaVacio = false;
        notify();
    }
}