/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.numerosprimosmenores.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class GestorFichero {
    
    public void escribirTodo(ArrayList<Integer> primos) {
        BufferedWriter bw = null;
        
        try {
            bw = new BufferedWriter(new FileWriter("info.txt"));
            for (Integer numero : primos) {
                bw.write(Integer.toString(numero));
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException ex) { }
        }
        
    }
    
    public void escribirUnoAUno(ArrayList<Integer> primos) {
        BufferedWriter bw = null;
        
        try {            
            for (Integer numero : primos) {
                bw = new BufferedWriter(new FileWriter("info2.txt", true));
                bw.write(Integer.toString(numero));
                bw.newLine();
                bw.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
