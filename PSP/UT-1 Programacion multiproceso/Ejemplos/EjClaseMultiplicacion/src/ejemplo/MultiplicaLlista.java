/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.util.*;
import java.util.concurrent.*;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class MultiplicaLlista {
    
    static class Multiplicacio implements Callable<Integer> {
        
        private int operador1;
        private int operador2;
        
        public Multiplicacio(int operador1, int operador2) {
            this.operador1 = operador1;
            this.operador2 = operador2;
        }
        
        @Override
        public Integer call() throws Exception {
            return operador1 * operador2;
        }
    }
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        // Crear 3 hilos
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        
        // Crear una lista
        List<Multiplicacio> llistaTasques= new ArrayList<Multiplicacio>();
        
        // Rellenar la lista
        for (int i = 0; i < 10; i++) {
            Multiplicacio calcula = new Multiplicacio((int)(Math.random()*10), (int)(Math.random()*10));
            llistaTasques.add(calcula);
        }
        
        List <Future<Integer>> llistaResultats;
        llistaResultats = executor.invokeAll(llistaTasques);
        executor.shutdown();
        
        for (int i = 0; i < llistaResultats.size(); i++) {
            Future<Integer> resultat = llistaResultats.get(i);
            try {
                System.out.println("Resultado de la tarea "+i+ " es:" + resultat.get());
            } catch (InterruptedException | ExecutionException e) {
            }
        }
    }
}
