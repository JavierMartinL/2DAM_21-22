/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperaturas;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        int[] arrayTemperatura = new int[3650];
        for (int i = 0; i < arrayTemperatura.length; i++) {
            arrayTemperatura[i] = (int) (Math.random() * (51 - (-30)))+ (-30);
            //System.out.println(i + " -> " + arrayTemperatura[i]);
        }
        int nt = 10;
        /*if (args.length == 1) {
            nt = Integer.parseInt(args[0]);
        }
        
        if (nt <= 0) {
            nt = 4;
        }*/
        
        MaxRecord maxRecord = new MaxRecord(arrayTemperatura[0]);
        Encontrar[] hilos = new Encontrar[nt];
        
        int rango = 1024 / nt;
        int limitSup, limitInf = 0;
        for (int i = 0; i < nt - 1; i++) {
            limitSup = limitInf + rango - 1;
            hilos[i] = new Encontrar(arrayTemperatura, limitInf, limitSup, maxRecord);
            limitInf = limitSup + 1;
        }
        
        hilos[nt - 1] = new Encontrar(arrayTemperatura, limitInf, 1023, maxRecord);
        for (int i = 0; i < nt; i++) {
            hilos[i].start();
        }
        for (int i = 0; i < nt; i++) {
            hilos[i].join();
        }
        System.out.println("Temperatura máxima = " + maxRecord.getMax() + "ºC");
    }
    
}
