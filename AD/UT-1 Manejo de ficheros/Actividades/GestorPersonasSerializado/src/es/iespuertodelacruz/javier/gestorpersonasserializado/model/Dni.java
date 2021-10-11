/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.gestorpersonasserializado.model;

import java.io.Serializable;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Dni implements Serializable{
    
    private String numero;
    private char letra;
    private boolean valido;

    public Dni() {
    }

    public Dni(String numero, char letra) {
        if (this.valido = validar(numero, letra)) {
            this.numero = numero;
            this.letra = letra;
        }
    }
    
    /**
     * Validar DNI y NIE
     * @param numero del DNI / NIE
     * @param letra de validacion (Ultima letra) DNI / NIE
     * @return true si es valido
     */
    private boolean validar(String numero, char letra) {
        boolean validacion = false;
        String letrasValidacion = "TRWAGMYFPDXBNJZSQVHLCKE";
        
        if (numero.length() == 8) {
            switch (numero.toUpperCase().charAt(0)) {
                case 'X':
                    numero = "0" + numero.substring(1, numero.length() -1);
                    break;
                case 'Y':
                    numero = "1" + numero.substring(1, numero.length() -1);
                    break;
                case 'Z':
                    numero = "2" + numero.substring(1, numero.length() -1);
                    break;
                default:
                    break;
            }    
            try {
                int numeroDni = Integer.parseInt(numero);
        
                char letraOptenida = letrasValidacion.charAt(numeroDni % 23);
                if (letraOptenida == letra) {
                    validacion = true;
                } 
            } catch(Exception e) {
                System.err.println("Existen letras dentro en el numero del DNI");
            }
        }    
        
        return validacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    @Override
    public String toString() {
        return numero + "" + letra;
    }
        
}
