/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import objetos.Planeta;

/**
 *
 * @author LENOVO-PC
 */
public class VentanaAsignarPlaneta extends javax.swing.JFrame {

    int indexPlaneta;
    boolean seleccion1;
    private VentanaNuevoMapa ventanaNuevoMapa;
    private ArrayList<Planeta> listaPlanetas;
    
    public VentanaAsignarPlaneta(VentanaNuevoMapa ventanaNuevoMapa) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaNuevoMapa = ventanaNuevoMapa;
    }
    
    public void pintar(ArrayList<Planeta> listaPlanetas){
        this.listaPlanetas = listaPlanetas;
        DefaultTableModel modeloNeutrales = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
            };
        
            modeloNeutrales.addColumn("Nombre Planeta");
            modeloNeutrales.addColumn("Numero");
        
            tablaPlanetas.setModel(modeloNeutrales);
            String datos[]= new String[2];
            
            
            for (int i = 0; i < listaPlanetas.size(); i++) {
                if(!listaPlanetas.get(i).isTieneJugador()){
                    datos[0] = i+"";
                    datos[1] = listaPlanetas.get(i).getNombre();
                    modeloNeutrales.addRow(datos);
                }
                
            }
    }

    public ArrayList<Planeta> getListaPlanetas() {
        return listaPlanetas;
    }

    public void setListaPlanetas(ArrayList<Planeta> listaPlanetas) {
        this.listaPlanetas = listaPlanetas;
    }
    public void limpiar(){
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPlanetas = new javax.swing.JTable();
        botonAgregar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaPlanetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaPlanetas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPlanetasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPlanetas);

        botonAgregar.setText("Agregar a Jugador");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(botonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonAgregar)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregar)
                    .addComponent(botonCancelar))
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaPlanetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPlanetasMouseClicked
        int posicion = tablaPlanetas.getSelectedRow();
        System.out.println("Seleccionado: "+tablaPlanetas.getValueAt(posicion, 0));
        indexPlaneta = Integer.parseInt((String) tablaPlanetas.getValueAt(posicion, 0));
        seleccion1=true;
        System.out.println("No: "+indexPlaneta);
    }//GEN-LAST:event_tablaPlanetasMouseClicked

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        if(seleccion1){
            listaPlanetas.get(indexPlaneta).setTieneJugador(true);
            ventanaNuevoMapa.agregarPlanetaJugador(listaPlanetas.get(indexPlaneta).getNombre());
            ventanaNuevoMapa.listaPlanetas = listaPlanetas;
            seleccion1 = false;
            this.setVisible(false);
            ventanaNuevoMapa.setEnabled(true);
            ventanaNuevoMapa.setVisible(true);
        }
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.setVisible(false);
        
            ventanaNuevoMapa.setEnabled(true);
            ventanaNuevoMapa.setVisible(true);
    }//GEN-LAST:event_botonCancelarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPlanetas;
    // End of variables declaration//GEN-END:variables
}
