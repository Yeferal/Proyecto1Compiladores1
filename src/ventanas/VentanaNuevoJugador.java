/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import objetos.Jugador;

/**
 *
 * @author LENOVO-PC
 */
public class VentanaNuevoJugador extends javax.swing.JFrame {

    String nombreJ;
    private VentanaNuevoMapa ventanaNuevoMapa;
    
    public VentanaNuevoJugador(VentanaNuevoMapa ventanaNuevoMapa) {
        initComponents();
        this.ventanaNuevoMapa = ventanaNuevoMapa;
        this.setLocationRelativeTo(null);
    }
    
    public void limpiar(){
        textoNombre.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        textoNombre = new javax.swing.JTextField();
        labelTipo = new javax.swing.JLabel();
        comboBoxTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNombre.setText("Nombre");

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        textoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoNombreKeyTyped(evt);
            }
        });

        labelTipo.setText("Tipo");

        comboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Humano", "Facil", "Dificil" }));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonAceptar)
                .addGap(14, 14, 14))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(149, 149, 149)
                            .addComponent(labelNombre))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(labelTipo))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelNombre)
                .addGap(18, 18, 18)
                .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonAceptar))
                .addGap(23, 23, 23))
        );

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNombreKeyTyped
        char car = evt.getKeyChar();
        if(Character.isLetter(car) || Character.isDigit(car)){
            if(textoNombre.getText().length()>9){
                evt.consume();
            }
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_textoNombreKeyTyped

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        if(!textoNombre.getText().isEmpty() && !textoNombre.getText().equals(" ")){
            nombreJ = textoNombre.getText();
            Jugador j = new Jugador();
            j.setNombre(nombreJ);
            j.setTipo(comboBoxTipo.getSelectedIndex());
            ventanaNuevoMapa.agregarJugador(j);
            
            this.setVisible(false);
            ventanaNuevoMapa.setEnabled(true);
            ventanaNuevoMapa.setVisible(true);
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.setVisible(false);
        limpiar();
        ventanaNuevoMapa.setEnabled(true);
        ventanaNuevoMapa.setVisible(true);
    }//GEN-LAST:event_botonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JComboBox<String> comboBoxTipo;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JPanel panel1;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables
}
