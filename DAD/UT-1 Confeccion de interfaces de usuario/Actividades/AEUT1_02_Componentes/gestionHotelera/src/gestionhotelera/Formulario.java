/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotelera;

import javax.swing.JSpinner;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Formulario extends javax.swing.JDialog {

    /**
     * Creates new form Formulario
     */
    public Formulario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();        
        spnFecha.setEditor(new JSpinner.DateEditor(spnFecha, "dd/MM/yyyy"));
        setTitle("Salón Habana");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgrHabitaciones = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        spnFecha = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbCocina = new javax.swing.JComboBox<>();
        spnPersonas = new javax.swing.JSpinner();
        lblJornadas = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        spnJornadas = new javax.swing.JSpinner();
        rdbSi = new javax.swing.JRadioButton();
        rdbNo = new javax.swing.JRadioButton();
        sprSeparador = new javax.swing.JSeparator();
        lblHabitaciones = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        lblDatos = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Datos Contacto");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Datos del Evento");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Nombre");
        jLabel3.setToolTipText("Nombre del contacto");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Teléfono");
        jLabel4.setToolTipText("Telefono del contacto");

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombre.setToolTipText("");

        txtTelefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Fecha");
        jLabel5.setToolTipText("Fecha del evento");

        spnFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        spnFecha.setModel(new javax.swing.SpinnerDateModel());

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("Evento");
        jLabel6.setToolTipText("Tipo de evento");

        cmbTipo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------", "banquete", "jornada", "congreso" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activarComplemento(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setText("Personas");
        jLabel7.setToolTipText("Numero de personas");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setText("Cocina");
        jLabel8.setToolTipText("Tipo de cocina");

        cmbCocina.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cmbCocina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------", "bufé", "carta", "cita con chef", "no precisa" }));

        spnPersonas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        spnPersonas.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        lblJornadas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblJornadas.setText("Jornadas");
        lblJornadas.setToolTipText("Numero de dias");
        lblJornadas.setEnabled(false);

        lblCantidad.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblCantidad.setText("Cantidad");
        lblCantidad.setToolTipText("Cantidad de Habitaciones");
        lblCantidad.setEnabled(false);

        spnJornadas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        spnJornadas.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnJornadas.setEnabled(false);

        btgrHabitaciones.add(rdbSi);
        rdbSi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rdbSi.setText("Si");
        rdbSi.setEnabled(false);
        rdbSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habitaciones(evt);
            }
        });

        btgrHabitaciones.add(rdbNo);
        rdbNo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rdbNo.setSelected(true);
        rdbNo.setText("No");
        rdbNo.setEnabled(false);
        rdbNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habitaciones(evt);
            }
        });

        sprSeparador.setEnabled(false);

        lblHabitaciones.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblHabitaciones.setText("Habitaciones");
        lblHabitaciones.setToolTipText("¿Quieres habitaciones?");
        lblHabitaciones.setEnabled(false);

        spnCantidad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnCantidad.setEnabled(false);

        lblDatos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblDatos.setText("Otros Datos");
        lblDatos.setEnabled(false);

        btnAceptar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aceptar(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrar(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbCocina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spnPersonas)))))
                    .addComponent(jLabel2))
                .addContainerGap(50, Short.MAX_VALUE))
            .addComponent(sprSeparador, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJornadas)
                    .addComponent(spnJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHabitaciones)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(rdbSi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbNo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad))
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDatos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnAceptar)
                        .addGap(54, 54, 54)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(spnPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbCocina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sprSeparador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblJornadas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCantidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptar)
                            .addComponent(btnCancelar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHabitaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbNo)
                            .addComponent(rdbSi))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void activarComplemento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activarComplemento
        
        if (cmbTipo.getSelectedItem().equals("congreso")) {
            sprSeparador.setEnabled(true);
            lblDatos.setEnabled(true);
            lblJornadas.setEnabled(true);
            spnJornadas.setEnabled(true);
            lblHabitaciones.setEnabled(true);
            rdbSi.setEnabled(true);
            rdbNo.setEnabled(true);
        } else {
            rdbNo.setSelected(true);
            sprSeparador.setEnabled(false);
            lblDatos.setEnabled(false);
            lblJornadas.setEnabled(false);
            spnJornadas.setEnabled(false);
            lblHabitaciones.setEnabled(false);
            rdbSi.setEnabled(false);
            rdbNo.setEnabled(false);
            rdbNo.setSelected(true);
            habitaciones(evt);
        }
        
    }//GEN-LAST:event_activarComplemento

    private void habitaciones(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habitaciones
        if (rdbSi.isSelected()) {
            lblCantidad.setEnabled(true);
            spnCantidad.setEnabled(true);
        } else {
            lblCantidad.setEnabled(false);
            spnCantidad.setEnabled(false);
        }
    }//GEN-LAST:event_habitaciones

    private void aceptar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptar
        String info = "DATOS DE CONTACTO "
                + "\n\tNombre: " + txtNombre.getText() 
                + "\n\tTeléfono: " + txtTelefono.getText()
                + "\nDATOS DEL EVENTO "
                + "\n\tFecha: " + spnFecha.getValue()
                + "\n\tEvento: " + cmbTipo.getSelectedItem()
                + "\n\tPersonas: " + spnPersonas.getValue()
                + "\n\tCocina: " + cmbCocina.getSelectedItem();
                
        if (cmbTipo.getSelectedItem().equals("congreso")) {
            info += "\nOTROS DATOS "
                    + "\n\tJornadas: " + spnJornadas.getValue()
                    + "\n\tHabitaciones: " + (rdbSi.isSelected()? "Si" : "No");
            if (rdbSi.isSelected()) {
                info += "\n\tCantidad: " + spnCantidad.getValue();
            }
        }
        System.out.println(info);
        dispose();
    }//GEN-LAST:event_aceptar

    private void cerrar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrar
        dispose();
    }//GEN-LAST:event_cerrar

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Formulario dialog = new Formulario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgrHabitaciones;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cmbCocina;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDatos;
    private javax.swing.JLabel lblHabitaciones;
    private javax.swing.JLabel lblJornadas;
    private javax.swing.JRadioButton rdbNo;
    private javax.swing.JRadioButton rdbSi;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JSpinner spnFecha;
    private javax.swing.JSpinner spnJornadas;
    private javax.swing.JSpinner spnPersonas;
    private javax.swing.JSeparator sprSeparador;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
