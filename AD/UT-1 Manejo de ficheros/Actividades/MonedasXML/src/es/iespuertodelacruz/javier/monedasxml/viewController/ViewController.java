/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.monedasxml.viewController;

import es.iespuertodelacruz.javier.monedasxml.entities.Almacen;
import es.iespuertodelacruz.javier.monedasxml.entities.Historico;
import es.iespuertodelacruz.javier.monedasxml.entities.Moneda;
import es.iespuertodelacruz.javier.monedasxml.utils.ManejoFichero;
import es.iespuertodelacruz.javier.monedasxml.xml.AlmacenXML;
import es.iespuertodelacruz.javier.monedasxml.xml.MonedaXML;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class ViewController {
    
    Almacen almacen;
    AlmacenXML almacenXML;
    MonedaXML monedaXML;
    ManejoFichero manejoFichero;
    Scanner sc;    

    public ViewController() {
        almacen = new Almacen();
        almacenXML = new AlmacenXML();
        monedaXML = new MonedaXML();
        manejoFichero = new ManejoFichero("mixml.txt");
        sc = new Scanner(System.in);
    }
    
    public void iniciar() throws IOException {
        boolean terminar = false;
        cargarFichero();
        do {
            int opt = mostrarMenu();
            switch(opt) {
                case 1:
                    Moneda nuevaMoneda = crearNuevaMoneda();
                    almacen.getMonedas().add(nuevaMoneda);
                    manejoFichero.borrarYAgregar(almacenXML.objToStringXML(almacen));
                    break;
                case 2:
                    crearHistorico();
                    manejoFichero.borrarYAgregar(almacenXML.objToStringXML(almacen));
                    break;
                case 3:
                    mostrarMonedas();
                    break;
                case 4:
                    mostrarMoneda();
                    break;
                case 5:
                    mostrarMonedaXML();
                    break;
                case 6:
                    System.out.println(manejoFichero.leerTodo());
                    break;
                case 0:
                    terminar = true;
                    break;
            }
        } while (!terminar);
    }
    
    private void cargarFichero() throws IOException {
        String datos = manejoFichero.leerTodo();
        if (!datos.equals("")) {
            almacen.setMonedas(almacenXML.stringXMLToObj(datos).getMonedas());
        } else {
            manejoFichero.agregarTexto(almacenXML.objToStringXML(almacen));
        }
    }
    
    private int mostrarMenu() {
        System.out.print("\nMenu:"
                + "\n\t1) Agregar nueva Moneda"
                + "\n\t2) Agregar Hstorico a una Moneda"
                + "\n\t3) Mostrar todas las Monedas"
                + "\n\t4) Mostrar datos de una Moneda"
                + "\n\t5) Mostrar XML de una Moneda"
                + "\n\t6) Mostrar el fichero"
                + "\n\t0) Salir"
                + "\n-> ");
        int opt = sc.nextInt();sc.nextLine();
        return opt;
    }
    
    private Moneda crearNuevaMoneda() {
        System.out.print("Datos de la nueva Moneda: "
                + "\n\tNombre: ");
        String nombre = sc.nextLine();
        System.out.print("\tPais: ");
        String pais = sc.nextLine();
        return new Moneda(almacen.getMonedas().size(), nombre, pais);
    }
    
    private void mostrarMonedas() {
        System.out.println("Listado de Monedas: ");
        for (Moneda moneda : almacen.getMonedas()) {
            System.out.println("\t" + moneda);
        }
    }
    
    private void mostrarMoneda() {
        System.out.print("Id de la Moneda: ");
        int id = sc.nextInt();sc.nextLine();
        if (id < almacen.getMonedas().size()) {
            Moneda monedaElegida = almacen.getMonedas().get(id);
            System.out.println(monedaElegida);
            if (monedaElegida.getHistoricos().size() > 0) {
                System.out.println("Historicos: ");
                for (Historico historico : monedaElegida.getHistoricos()) {
                    System.out.println("\t" + historico);
                }
            } else {
                System.out.println("Esta Moneda no tiene historicos");
            }
        } else {
            System.out.println("No existe una moneda con ese ID");
        }   
    }
    
    private void mostrarMonedaXML() {
        System.out.print("Id de la Moneda: ");
        int id = sc.nextInt();sc.nextLine();
        if (id < almacen.getMonedas().size()) {
            System.out.println(
                    "\n" +
                    monedaXML.objToStringXML(
                            almacen.getMonedas().get(id)
                    )
            );
        } else {
            System.out.println("No existe una moneda con ese ID");
        }     
    }
    
    private void crearHistorico() {
        System.out.print("Id de la Moneda: ");
        int id = sc.nextInt();sc.nextLine();
        if (id < almacen.getMonedas().size()) {
            System.out.print("Equivalencia en Euros: ");
            double euros = sc.nextDouble();sc.nextLine();
            Moneda monedaElegida = almacen.getMonedas().get(id);
            monedaElegida.getHistoricos().add(
                    new Historico(
                            monedaElegida.getHistoricos().size(), 
                            monedaElegida, 
                            new Date(), 
                            euros
                    )
            );
        } else {
            System.out.println("No existe una moneda con ese ID");
        }
    }
}
