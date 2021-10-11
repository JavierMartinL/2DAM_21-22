/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacceso;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        ControlAcceso persona1 = new ControlAcceso();
        persona1.start();
        Thread.sleep(3000);
        ControlAcceso persona2 = new ControlAcceso();
        persona2.start();
        
    }
    
}
