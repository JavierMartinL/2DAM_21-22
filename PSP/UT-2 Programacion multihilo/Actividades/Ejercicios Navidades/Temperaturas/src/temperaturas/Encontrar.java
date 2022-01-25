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
public class Encontrar extends Thread {
    
    private int limitMax, limitInf, limitSup;
    private int inc;
    private int[] array;
    private MaxRecord maxRecord;
    
    public Encontrar(int[] array, int limitInf, int limitSup, MaxRecord maxRecord) {
        this.array = array;
        this.limitInf = limitInf + 1;
        this.limitSup = limitSup;
        this.limitMax = array[1];
        this.maxRecord = maxRecord;
        this.inc = 10;
    }
    
    public void run() {
        try {
            while (limitInf < limitSup) {
                int n = Math.min(inc, limitSup - limitInf);
                for (int i = limitInf; i <= limitInf + n; i++) {
                    limitMax = Math.max(limitMax, array[i]);
                }
                sleep(5);
                limitInf += n;
            }
        } catch (Exception e) {
            return;
        }
        maxRecord.setMax(limitMax);
    }
    
}
