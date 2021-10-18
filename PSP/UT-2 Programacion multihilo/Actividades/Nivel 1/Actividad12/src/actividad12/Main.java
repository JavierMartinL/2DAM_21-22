/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad12;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Saludar saludar = new Saludar();
        
        Alumno juan = new Alumno("juan", saludar, false);
        Alumno adrian = new Alumno("adrian", saludar, false);
        Alumno luis = new Alumno("luis", saludar, false);
        Alumno javier = new Alumno("javier", saludar, true);
        
        juan.start();
        adrian.start();
        luis.start();
        javier.start();
        
        try{
            juan.join();
            adrian.join();
            luis.join();
            javier.join();
        }catch(InterruptedException e ){ }
        
    }
    
}
