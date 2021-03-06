/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indicemasacorporal.modelo;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Persona {
    
    private String nombre;
    private String apellidos;
    private int edad;
    private double altura;
    private double peso;
    
    public Persona(String nombre, String apellidos, int edad, double altura, double peso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
    }
    
    public double imc() {
        double imc = 0;
        imc = this.peso / (Math.pow(this.altura, 2));
        return imc;
    }
    
    public String informacion() {
        return "Nombre completo: " + this.nombre + " " + this.apellidos +
                "\nEdad: " + this.edad + " Altura: " + this.altura + " Peso: " + this.peso +  
                "\nIMC: " + imc();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
}
