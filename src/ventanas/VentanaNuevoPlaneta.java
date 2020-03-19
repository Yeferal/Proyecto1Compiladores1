/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javax.swing.JOptionPane;
import objetos.Planeta;

public class VentanaNuevoPlaneta extends javax.swing.JFrame {

    Planeta planeta;
    private VentanaNuevoMapa ventanaNuevoMapa;
    
    public VentanaNuevoPlaneta(VentanaNuevoMapa ventanaNuevoMapa) {
        initComponents();
        this.ventanaNuevoMapa = ventanaNuevoMapa;
        this.setLocationRelativeTo(null);
    }
    
    public void limpiar(){
        planeta = null;
        textoNombre.setText("");
        spinnerNaves.setValue((int) 0);
        spinnerPorcentaje.setValue((int) 0);
        spinnerProduccion.setValue((int) 0);
    }
    
    public Planeta getPlaneta(){
        return planeta;
    }
    
    public void agregar(){
        if (ventanaNuevoMapa.tipo==0) {
            ventanaNuevoMapa.agregarNuevoPlanetaNeutral();
        }else{
            ventanaNuevoMapa.agregarNuevoPlaneta();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelNaves = new javax.swing.JLabel();
        labelProduccion = new javax.swing.JLabel();
        labelPorcentaje = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        spinnerNaves = new javax.swing.JSpinner();
        spinnerProduccion = new javax.swing.JSpinner();
        spinnerPorcentaje = new javax.swing.JSpinner();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNombre.setText("Nombre: ");

        labelNaves.setText("# Naves: ");

        labelProduccion.setText("Produccion:");

        labelPorcentaje.setText("Porcentaje Muertes:");

        textoNombre.setToolTipText("SOLO SE PERMITEN LETRAS");
        textoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoNombreKeyTyped(evt);
            }
        });

        spinnerNaves.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinnerProduccion.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinnerPorcentaje.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0d, 0.01d));

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPorcentaje)
                            .addComponent(labelProduccion)
                            .addComponent(labelNaves)
                            .addComponent(labelNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoNombre)
                            .addComponent(spinnerNaves, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(spinnerProduccion)
                            .addComponent(spinnerPorcentaje))
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAceptar)
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelNombre))
                                .addGap(18, 18, 18)
                                .addComponent(labelNaves))
                            .addComponent(spinnerNaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(labelProduccion))
                    .addComponent(spinnerProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelPorcentaje)
                    .addComponent(spinnerPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addGap(52, 52, 52))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        planeta = new Planeta();
        if(!textoNombre.getText().isEmpty() && !textoNombre.getText().equals(" ")){
            planeta.setNombre(textoNombre.getText());
            planeta.setNaves((int) spinnerNaves.getValue());
            planeta.setProduccion((int) spinnerProduccion.getValue());
            double valor = Double.parseDouble(spinnerPorcentaje.getValue()+"");
            planeta.setPorcentajeMuertes(valor); 
            agregar();
            this.setVisible(false);
            ventanaNuevoMapa.setEnabled(true);
            ventanaNuevoMapa.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "El nombre no es correcto");
        }
        
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void textoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNombreKeyTyped
        if(textoNombre.getText().length()>2){
            evt.consume();
        }else{
            char car = evt.getKeyChar();
            if(Character.isLetter(car)){

            }else{
                evt.consume();
                //getToolkit().beep();
            }
        }
    }//GEN-LAST:event_textoNombreKeyTyped

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.setVisible(false);
        limpiar();
        ventanaNuevoMapa.setEnabled(true);
        ventanaNuevoMapa.setVisible(true);
    }//GEN-LAST:event_botonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNaves;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPorcentaje;
    private javax.swing.JLabel labelProduccion;
    private javax.swing.JSpinner spinnerNaves;
    private javax.swing.JSpinner spinnerPorcentaje;
    private javax.swing.JSpinner spinnerProduccion;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables
}
