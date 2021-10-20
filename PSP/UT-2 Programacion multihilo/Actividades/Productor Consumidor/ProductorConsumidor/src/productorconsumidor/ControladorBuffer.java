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
    
    // Creación del buffer y asginamos el tamaño
    private char buffer[] = new char[6];
    // Ultima posición del buffer
    private int posUltimo = 0;
    
    // Controla si el buffer esta lleno
    private boolean bufferLleno = false;
    // Controla si el buffer esta vacio
    private boolean bufferVacio = true;
    
    public synchronized void guardarBuffer(char caracter) {
        // Si el buffer esta lleno hay que esperar
        if (bufferLleno) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        
        // Guardo el valor dentro del buffer
        buffer[posUltimo] = caracter;
        posUltimo++;
        
        if (posUltimo == 6) {
            bufferLleno = true;
        }
        bufferVacio = false;
        notify();
    }
    
    public synchronized char recogerBuffer() {
        // Si el buffer esta vacio hay que esperar
        if (bufferVacio) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        
        posUltimo--;
        if (posUltimo == 0) {
            bufferVacio = true;
        }
        bufferLleno = false;
        notify();
        return buffer[posUltimo]; 
    }
    
}
