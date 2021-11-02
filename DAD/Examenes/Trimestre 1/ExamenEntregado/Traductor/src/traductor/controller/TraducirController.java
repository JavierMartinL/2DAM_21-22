/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductor.controller;

import java.awt.Frame;
import traductor.model.Traductor;
import traductor.view.TraducirView;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class TraducirController {

    TraducirView traducirVista;
    Traductor traductor;
    
    public TraducirController() {
    }

    public TraducirController(TraducirView traducirVista, Traductor traductor) {
        this.traducirVista = traducirVista;
        this.traductor = traductor;
        
        this.traducirVista.pnlAniadir.setVisible(false);
        
        // Acciones del Menu
        this.traducirVista.jmnTraducir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarTraductor(evt);
            }
        });     
        
        this.traducirVista.jmnAniadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarAniadir(evt);
            }
        });
        
        // Acciones dentro de Traductor Vista
        this.traducirVista.txaIdiomaPrincipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bloquearSecundario(evt);
            }
        });
        
        this.traducirVista.txaIdiomaSecundario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bloquearPrincipal(evt);
            }
        });
        
        // Boton traducir
        this.traducirVista.btnTraducir.addActionListener(this::traducir);
        // Boton salir
        this.traducirVista.btnSalir.addActionListener(this::cerrarApp);
        
        // Acciones dentro del Añadir Vista
        this.traducirVista.txtEspaniol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                activarBotones(evt);
            }
        });
        
        this.traducirVista.txtFrances.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                activarBotones(evt);
            }
        });
        
        this.traducirVista.txtIngles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                activarBotones(evt);
            }
        });
        
        // Boton Añadir
        this.traducirVista.btnAniadir.addActionListener(this::agregarPalabra);
        // Boton eliminar
        this.traducirVista.btnEliminar.addActionListener(this::eliminarPalabra);
        // Boton salir
        this.traducirVista.btnSalirAniadir.addActionListener(this::cerrarApp);
    }
    
    // Lanzar la parte visual
    public void iniciar() {
        traducirVista.setTitle("Traductor");
        traducirVista.setLocationRelativeTo(null);
        traducirVista.setVisible(true);
    }
    
    // mostrar vista principal
    private void mostrarTraductor(java.awt.event.MouseEvent evt) {
        this.traducirVista.pnlTraductor.setVisible(true);
        this.traducirVista.pnlAniadir.setVisible(false);
        this.traducirVista.txaIdiomaPrincipal.setEnabled(true);
        this.traducirVista.txaIdiomaPrincipal.setText("");
        this.traducirVista.txaIdiomaSecundario.setEnabled(true);
        this.traducirVista.txaIdiomaPrincipal.setText("");
        this.traducirVista.btnTraducir.setEnabled(false);
    }
    
    // mostrar vista añadir
    private void mostrarAniadir(java.awt.event.MouseEvent evt) {
        this.traducirVista.pnlTraductor.setVisible(false);
        this.traducirVista.pnlAniadir.setVisible(true);
        this.traducirVista.txtEspaniol.setText("");
        this.traducirVista.txtFrances.setText("");
        this.traducirVista.txtIngles.setText("");
        this.traducirVista.btnAniadir.setEnabled(false);
        this.traducirVista.btnEliminar.setEnabled(false);
    }
    
    // Bloquear el bloque de texto principal
    private void bloquearPrincipal(java.awt.event.KeyEvent evt) {
        if (!this.traducirVista.txaIdiomaSecundario.getText().equals("")) {
            this.traducirVista.txaIdiomaPrincipal.setEnabled(false);
            this.traducirVista.btnTraducir.setEnabled(true);
        } else {
            this.traducirVista.txaIdiomaPrincipal.setEnabled(true);
            this.traducirVista.btnTraducir.setEnabled(false);
        }
    }
    
    // bloquear el bloque de texto secundario
    private void bloquearSecundario(java.awt.event.KeyEvent evt) {
        if (!this.traducirVista.txaIdiomaPrincipal.getText().equals("")) {
            this.traducirVista.txaIdiomaSecundario.setEnabled(false);
            this.traducirVista.btnTraducir.setEnabled(true);
        } else {
            this.traducirVista.txaIdiomaSecundario.setEnabled(true);
            this.traducirVista.btnTraducir.setEnabled(false);
        }
    }
    
    // Traducir de un textArea al otro
    private void traducir(java.awt.event.ActionEvent evt) {
        if (!this.traducirVista.txaIdiomaPrincipal.getText().equals("")) {
            this.traducirVista.txaIdiomaSecundario.setText(this.traducirVista.txaIdiomaPrincipal.getText());
            this.traducirVista.txaIdiomaSecundario.setEnabled(true);            
            
        } else if (!this.traducirVista.txaIdiomaSecundario.getText().equals("")){
            this.traducirVista.txaIdiomaPrincipal.setText(this.traducirVista.txaIdiomaSecundario.getText());
            this.traducirVista.txaIdiomaPrincipal.setEnabled(true);
        }
        this.traducirVista.btnTraducir.setEnabled(false);
    }
    
    // Si algun campo esta escrito activar los botones de añadir
    private void activarBotones(java.awt.event.KeyEvent evt) {
        this.traducirVista.lblErrorAniadir.setText("");
        if (
            this.traducirVista.txtEspaniol.getText().equals("") &&
            this.traducirVista.txtFrances.getText().equals("") &&
            this.traducirVista.txtIngles.getText().equals("") 
        ) {
            this.traducirVista.btnAniadir.setEnabled(false);
            this.traducirVista.btnEliminar.setEnabled(false);
        } else {
            this.traducirVista.btnAniadir.setEnabled(true);
            this.traducirVista.btnEliminar.setEnabled(true);
        }
    }
    
    // accion del boton para agregar una nueva palabra
    private void agregarPalabra(java.awt.event.ActionEvent evt) {
        String spain = this.traducirVista.txtEspaniol.getText();
        String frances = this.traducirVista.txtFrances.getText();
        String ingles = this.traducirVista.txtIngles.getText();
        
        if (spain.equals("") || frances.equals("") || ingles.equals("")) {
            this.traducirVista.lblErrorAniadir.setText("Faltan campos");
        }
    }
    
    // accion del boton eliminar
    private void eliminarPalabra(java.awt.event.ActionEvent evt) {
        this.traducirVista.lblErrorAniadir.setText("Boton 'Eliminar' no funciona");
    }
    
    // cerrar la aplicacion
    private void cerrarApp(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
}
