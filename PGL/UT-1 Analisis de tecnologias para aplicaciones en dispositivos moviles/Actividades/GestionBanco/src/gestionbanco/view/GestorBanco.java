/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbanco.view;

import gestionbanco.controller.Controller;
import java.util.Scanner;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class GestorBanco {
    
    Controller control;
    Scanner sc;
    private boolean login;
    private boolean finalizar;
    
    public GestorBanco() {
        control = new Controller();
        sc = new Scanner(System.in);
        login = finalizar = false;
        lanzarApp();
    }
    
    public void lanzarApp() {
        do {            
            menuInicial();
            if (finalizar) {
                break;
            }
        } while (!login);
    }
    
    public void menuInicial() {
        String textMenu = "Bienvenido!!\n"
                + "\t1) Login\n"
                + "\t2) Registro\n"
                + "\t0) Salir\n"
                + "-> ";
        
        System.out.print(textMenu);
        int opt = sc.nextInt(); sc.nextLine();
        
        switch(opt) {
            case 2:
                registro();
            case 1:
                login();
                break;
            case 0:
                finalizar = true;
        }
    }
    
    private void registro() {
        System.out.print("\nNombre: ");
        control.setNombre(sc.nextLine());
        System.out.print("Apellidos: ");
        control.setApellidos(sc.nextLine());
        System.out.print("Usuario: ");
        control.setUser(sc.nextLine());
        System.out.print("Contraseña: ");
        control.setPass(sc.nextLine());
        
        control.registro();
    }
    
    private void login() {
        System.out.print("\nUsuario: ");
        control.setUser(sc.nextLine());
        System.out.print("Contraseña: ");
        control.setPass(sc.nextLine());
        
        login = control.login();
    }
    
}