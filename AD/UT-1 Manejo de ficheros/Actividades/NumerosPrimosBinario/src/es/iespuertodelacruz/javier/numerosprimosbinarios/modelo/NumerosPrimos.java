/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.numerosprimosbinarios.modelo;

import java.util.ArrayList;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class NumerosPrimos {

    private int limite;
    private ArrayList<Integer> primosTotales;
    
    public NumerosPrimos() {
        this(10000000);
    }

    public NumerosPrimos(int limite) {
        this.limite = limite;
        this.primosTotales = new ArrayList<>();
    }
    
    public ArrayList<Integer> generarPrimos() {
        primosTotales.add(2);
        
        for (int posiblePrimo = 3; posiblePrimo < limite; posiblePrimo += 2) {
            boolean esPrimo = true;
            for (int i = 0; i < primosTotales.size(); i++) {
                if (posiblePrimo % primosTotales.get(i) == 0) {
                    esPrimo = false;
                } else if (primosTotales.get(i) * primosTotales.get(i) > posiblePrimo) {
                    break;
                }
            }
            if (esPrimo) {
                primosTotales.add(posiblePrimo);
            }
        }
        return primosTotales;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }
    
}
