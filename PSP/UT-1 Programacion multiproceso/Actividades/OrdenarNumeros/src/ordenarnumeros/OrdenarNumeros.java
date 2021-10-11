/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenarnumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class OrdenarNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num = 0;
        
        ArrayList<Integer> numeros = new ArrayList<>();
        
        do {           
            System.out.print("Num: ");
            num = sc.nextInt();
            if (num > 0){
              numeros.add(num);  
            } 
        } while (num > 0);
        
        Collections.sort(numeros);
        System.out.println(numeros);
        
    }
    
}
