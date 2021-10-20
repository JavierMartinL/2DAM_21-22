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
public class Productor extends Thread {
    
    private ControladorBuffer controlador;
    private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Productor(ControladorBuffer controladorBuffer) {
        this.controlador = controladorBuffer;
    }
    
    @Override
    public void run() {
        char caracter;
        
        for (int i = 0; i < 15; i++) {
            caracter = alfabeto.charAt((int) (Math.random() * 26));
            controlador.lanzar(caracter);
            System.out.println("Depositado el carácter " + caracter + " en el buffer");
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) { }
        }
    }
    
}