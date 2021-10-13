/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Ejercicio9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MarcasTelefonos samsung, xiaomi, sony, apple;
        samsung = new MarcasTelefonos("samsung");
        xiaomi = new MarcasTelefonos("xiaomi");
        sony = new MarcasTelefonos("sony");
        apple = new MarcasTelefonos("apple");
        
        System.out.println("Listado de llamadas");
        
        samsung.start();
        xiaomi.start();
        sony.start();
        apple.start();
    }
    
}
