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
public class MaxRecord {
    
    private int maxValue;
    
    public MaxRecord(int maxValue) {
        this.maxValue = maxValue;
    }
    
    public synchronized int getMax() {
        return maxValue;
    }
    
    public synchronized void setMax(int maxValue) {
        this.maxValue = Math.max(this.maxValue, maxValue);
    }
    
}
