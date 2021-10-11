/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreraanimales;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Animal animal1 = new Animal("Perro");
        Animal animal2 = new Animal("Gato");
        Animal animal3 = new Animal("Tigre");
        animal1.start();
        animal2.start();
        animal3.start();
    }
    
}
