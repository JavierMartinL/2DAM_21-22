/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.numerosprimosbinarios.modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class GestorFicherosBinarios {
    
    File fichero = new File("PrimosBinario.out");
    
    public void guargar(ArrayList<Integer> primos) {
        try {
            FileOutputStream fos = new FileOutputStream(fichero);
            DataOutputStream dos = new DataOutputStream(fos);
            for (Integer primo : primos) {
                dos.writeInt(primo);
            }
            dos.close();
        } catch(FileNotFoundException e){
            System.out.println("No se encontro el archivo");
        }
        catch(IOException e){
            System.out.println("Error al escribir");
        }
    }
    
    public void leer() {
        try {
            FileInputStream fis = new FileInputStream(fichero);
            DataInputStream dis = new DataInputStream(fis);
            int numero;
            for (int i = 0; i < 100; i++) {
                numero = dis.readInt();
                System.out.println("Pos " + i + " => " + numero);
            }
            dis.close();
        } catch(FileNotFoundException e){
            System.out.println("No se encontra el archivo");
        } catch(IOException e){
            System.out.println("Error al leer");
        }
    } 
    
}
