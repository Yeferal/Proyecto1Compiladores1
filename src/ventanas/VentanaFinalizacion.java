
package ventanas;

import javax.swing.JOptionPane;

public class VentanaFinalizacion extends javax.swing.JFrame {

    VentanaJugar ventanaJugar;
    
    public VentanaFinalizacion(VentanaJugar ventanaJugar) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaJugar = ventanaJugar;
    }
    
    public void verificarGanador(){
        for (int i = 0; i < ventanaJugar.juego.getListaJugadores().size(); i++) {
            int n = 0;
            for (int j = 0; j < ventanaJugar.juego.getListaPlanetas().size(); j++) {
                if(ventanaJugar.juego.getListaPlanetas().get(j).getJugador()==i){
                    n++;
                }
            }
            ventanaJugar.juego.getListaJugadores().get(i).setNumeroPlanetas(n);
        }
    }
    
    public void mostrarGandor(){
        int pos = 0;
        
        
        for (int i = 0; i < ventanaJugar.juego.getListaJugadores().size(); i++) {
            int n = 0;
            if(ventanaJugar.juego.getListaJugadores().get(pos).getNumeroPlanetas()<ventanaJugar.juego.getListaJugadores().get(i).getNumeroPlanetas()){
                pos = i;
            }
        }
        
        JOptionPane.showMessageDialog(null, "El ganador de la partida es: "+ventanaJugar.juego.getListaJugadores().get(pos).getNombre()+"\nCon: "+ventanaJugar.juego.getListaJugadores().get(pos).getNumeroPlanetas()+" Planetas");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonFinalizar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonFinalizar.setText("Finalizar Partida");
        botonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinalizarActionPerformed(evt);
            }
        });

        botonGuardar.setText("Guardar Replay");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonGuardar)
                    .addComponent(botonFinalizar))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(botonFinalizar)
                .addGap(63, 63, 63)
                .addComponent(botonGuardar)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        ventanaJugar.guardarReplay();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinalizarActionPerformed
        verificarGanador();
        
        mostrarGandor();
        ventanaJugar.iniciarDatos();
        ventanaJugar.limpiar();
        this.dispose();
    }//GEN-LAST:event_botonFinalizarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonFinalizar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
