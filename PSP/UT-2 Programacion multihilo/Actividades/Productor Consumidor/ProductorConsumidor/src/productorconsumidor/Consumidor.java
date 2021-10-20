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
public class Consumidor extends Thread {
    
    private ControladorBuffer controlador;

    public Consumidor(ControladorBuffer controlador) {
        this.controlador = controlador;
    }
    
    @Override
    public void run() {
        char caracter;
        for (int i = 0; i < 15; i++) {
            caracter = controlador.recogerBuffer();
            System.out.println("Recogido el carácter " + caracter + " del buffer");
            try {
                sleep((int) (Math.random() * 2000));
            } catch (Exception e) {
            }
        }
    }
    
}
