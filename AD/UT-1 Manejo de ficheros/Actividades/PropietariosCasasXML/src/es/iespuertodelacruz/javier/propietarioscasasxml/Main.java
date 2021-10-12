/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.propietarioscasasxml;

import es.iespuertodelacruz.javier.propietarioscasasxml.entities.Almacen;
import es.iespuertodelacruz.javier.propietarioscasasxml.entities.Casa;
import es.iespuertodelacruz.javier.propietarioscasasxml.entities.Propietario;
import es.iespuertodelacruz.javier.propietarioscasasxml.utils.ManejoFichero;
import es.iespuertodelacruz.javier.propietarioscasasxml.xml.AlmacenXML;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Almacen almacen  = new Almacen();
        ManejoFichero manejoFicheros = new ManejoFichero("propietariosCasa.txt");
        
        Propietario p = new Propietario(0, "Paco");
        Propietario p1 = new Propietario(1, "Ana");
        Propietario p2 = new Propietario(2, "Luis");
        Propietario p3 = new Propietario(3, "Ruben");
        
        Casa c = new Casa(0, "c/San matias", 34);
        Casa c1 = new Casa(1, "c/Marisol", 17);
        
        p.getCasas().add(c);
        p1.getCasas().add(c);
        p.getCasas().add(c1);
        p2.getCasas().add(c1);
        
        c.getPropietarios().add(p);
        c.getPropietarios().add(p1);
        c1.getPropietarios().add(p);
        c1.getPropietarios().add(p2);
        
        almacen.getPropietarios().add(p);
        almacen.getPropietarios().add(p1);
        almacen.getPropietarios().add(p2);
        almacen.getPropietarios().add(p3);
        
        AlmacenXML almacenXML = new AlmacenXML();
        
        String strAlmacen = almacenXML.objToStringXML(almacen);
        System.out.println(strAlmacen);
        
        manejoFicheros.borrarYAgregar(strAlmacen);
                
    }
    
}
