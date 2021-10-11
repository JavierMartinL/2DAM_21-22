/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.gestorpersonasfijo.model;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class ControlPersona {
    
    static int sizeNombre = 50;
    static int sizeApellido = 50;
    static int sizeEdad = 3;
    
    String nombre;
    String apellido;
    String edad;

    public ControlPersona() { }

    public ControlPersona(String nombre, String apellido, int edad) {
        this.nombre = stringToFixedSize(nombre, sizeNombre);
        this.apellido = stringToFixedSize(apellido, sizeApellido);
        this.edad = stringToFixedSize("" + edad, sizeEdad);
    }
    
    public Persona toPersona() {
        return new Persona(
                fixedSizeToString(nombre),
                fixedSizeToString(apellido),
                Integer.parseInt(fixedSizeToString(edad))
        );
    }
    
    /**
     * Convertir un texto con tamaño variable a un texto fijo
     * @param dato texto que vamos a modificar
     * @param longitud tamaño del texto fijo
     * @return un texto fijo
     */
    private String stringToFixedSize(String dato, int longitud) {
        dato += "\0";
        while (dato.length() < longitud) {
            dato += " ";
        }        
        return dato;
    }
    
    /**
     * Convertir un texto fijo en un texto con tamaño variable
     * @param dato texto con tamaño fijo
     * @return texto con tamaño svariable
     */
    private String fixedSizeToString(String dato) {
        String p = "";
        if(dato.contains("\0")) {
            p = dato.split("\0")[0];
        }
        return p;
    }
    
}
