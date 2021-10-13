/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

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
            Correr correr = new Correr(pitufo);
            Thread t = new Thread(correr);
            t.start();
        }
    }
    
}
