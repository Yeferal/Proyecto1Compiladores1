
package ventanas;

import javax.swing.JOptionPane;
import objetos.Flota;

public class VentanaEnviarFlota extends javax.swing.JFrame {

    private VentanaJugar ventanaJugar;
    private Flota flotaAux;
    private int naves,navesEnviadas;
    
    public VentanaEnviarFlota(VentanaJugar ventanaJugar) {
        initComponents();
        this.ventanaJugar = ventanaJugar;
        this.setLocationRelativeTo(null);
    }

    public Flota getFlotaAux() {
        return flotaAux;
    }

    public void setFlotaAux(Flota flotaAux) {
        this.flotaAux = flotaAux;
    }
    
    public void setDatos(){
        labelPlaneta1.setText(flotaAux.getOrigenS());
        labelPlaneta2.setText(flotaAux.getDestinoS());
    }
    
    public void limpiar(){
        labelPlaneta1.setText("");
        labelPlaneta2.setText("");
        spinnerNave.setValue(1);
    }
    public void setLabelCantidad(int cantidad){
        labelCantidadDisponible.setText(cantidad+"");
    }
    public void actualizarNaves(int naves,int navesEnviadas){
        this.naves = naves;
        this.navesEnviadas = navesEnviadas;
    }
    
    public boolean verificarTamanios(){
        if((naves-navesEnviadas)>=((int) spinnerNave.getValue())){
            return true;
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        labelFlecha = new javax.swing.JLabel();
        labelPlaneta1 = new javax.swing.JLabel();
        labelPlaneta2 = new javax.swing.JLabel();
        spinnerNave = new javax.swing.JSpinner();
        labelNaves = new javax.swing.JLabel();
        botonEnviar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        labelDisponibles = new javax.swing.JLabel();
        labelCantidadDisponible = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelFlecha.setForeground(new java.awt.Color(0, 0, 0));
        labelFlecha.setText("==========>");

        labelPlaneta1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        labelPlaneta1.setForeground(new java.awt.Color(255, 0, 51));

        labelPlaneta2.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        labelPlaneta2.setForeground(new java.awt.Color(0, 0, 255));

        spinnerNave.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        labelNaves.setText("No. Naves: ");

        botonEnviar.setText("Enviar Naves");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        labelDisponibles.setText("Naves Disponibles: ");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(labelPlaneta1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPlaneta2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(labelNaves)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerNave, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonEnviar)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(labelDisponibles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCantidadDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPlaneta1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPlaneta2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFlecha))
                .addGap(15, 15, 15)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNaves)
                    .addComponent(spinnerNave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEnviar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCantidadDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonCancelar)
                        .addComponent(labelDisponibles)))
                .addContainerGap())
        );

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        ventanaJugar.setEnabled(true);
        ventanaJugar.setVisible(true);
        this.setVisible(false);
        setFlotaAux(null);
        limpiar();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        if(verificarTamanios()){
            flotaAux.setNavesEnviadas((int) spinnerNave.getValue());
            flotaAux.setTurnosFaltantes(flotaAux.getTurno());
            flotaAux.setTurnosLlegar(flotaAux.getTurno()+ventanaJugar.numeroTurno);

            //ventanaJugar.planeta1.setNavesEnviadas( ventanaJugar.planeta1.getNavesEnviadas()+flotaAux.getNavesEnviadas());
            ventanaJugar.agregarFlota(flotaAux);
            limpiar();
            this.setVisible(false);
            
            JOptionPane.showMessageDialog(null, "Neves enviadas");
            
        }else{
            JOptionPane.showMessageDialog(null, "Es este planeta no tiene naves sufucientes");
        }
        
        
    }//GEN-LAST:event_botonEnviarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JLabel labelCantidadDisponible;
    private javax.swing.JLabel labelDisponibles;
    private javax.swing.JLabel labelFlecha;
    private javax.swing.JLabel labelNaves;
    private javax.swing.JLabel labelPlaneta1;
    private javax.swing.JLabel labelPlaneta2;
    private javax.swing.JPanel panel;
    private javax.swing.JSpinner spinnerNave;
    // End of variables declaration//GEN-END:variables

}
