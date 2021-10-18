/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad13;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Transporte auto = new Transporte("auto", 13);
        Transporte moto = new Transporte("moto", 30);
        Transporte guagua = new Transporte("guagua", 8);
        auto.start();
        moto.start();
        guagua.start();
    }
    
}