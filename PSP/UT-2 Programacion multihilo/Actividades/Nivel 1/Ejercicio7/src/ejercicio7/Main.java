/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] pitufos = {
            "Papa pitufo", "Pitufina", 
            "Romantico", "Dormilón", 
            "Filósofo", "Tímido", 
            "Bromista", "Gruñón", 
            "Pintor", "Rey"
        };
        
        for (String pitufo : pitufos) {
            Pitufos p = new Pitufos(pitufo);
            Thread thread = new Thread(p);
            thread.start();
        }
        
    }
    
}
