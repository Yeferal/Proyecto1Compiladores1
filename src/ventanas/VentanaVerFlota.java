
package ventanas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import objetos.Flota;
import objetos.Jugador;

public class VentanaVerFlota extends javax.swing.JFrame {

    private VentanaJugar ventanaJugar;
    Jugador jugador;
    int seleccionN;
    boolean seleccion;
    
    public VentanaVerFlota(VentanaJugar ventanaJugar) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaJugar = ventanaJugar;
        
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    public void limpiar(){
        seleccion = false;
        seleccionN = 0;
        botonCancelarEnvio.setVisible(false);
        labelEnvio.setText("");
        labelEnvio.setVisible(false);
        labelFlota.setVisible(false);
    }
    
    public void quitarFlota(int n){
        ventanaJugar.juego.getListaJugadores().get(ventanaJugar.turno).eliminarFlota(n);
        pintar(ventanaJugar.juego.getListaJugadores().get(ventanaJugar.turno).getListaFlota());
    }
    public void pintar(ArrayList<Flota> f){
        ArrayList<Flota> lista = f;
        DefaultTableModel modeloNeutrales = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
            };
        
            //modeloNeutrales.addColumn("Llego");
            modeloNeutrales.addColumn("No. Flota");
            modeloNeutrales.addColumn("Origen");
            modeloNeutrales.addColumn("Destino");
            modeloNeutrales.addColumn("Naves");
            modeloNeutrales.addColumn("% muertes");
            modeloNeutrales.addColumn("Turno de llegada");
            modeloNeutrales.addColumn("LLEGO");
            //modeloNeutrales.addColumn("Destino");
        
            tabla.setModel(modeloNeutrales);
            String datos[]= new String[7];
            
            
            for (int i = 0; i < lista.size(); i++) {
                datos[0] = lista.get(i).getNumero()+"";
                datos[1] = lista.get(i).getOrigenS();
                datos[2] = lista.get(i).getDestinoS();
                datos[3] = lista.get(i).getNavesEnviadas()+"";
                datos[4] = lista.get(i).getPorcetajeMuertes()+"";
                datos[5] = lista.get(i).getTurnosLlegar()+"";
                if(lista.get(i).isAtacado()){
                    datos[6] = "SI";
                }else{
                    datos[6] = "EN CAMINO";
                }
                modeloNeutrales.addRow(datos);
            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        botonCancelarEnvio = new javax.swing.JButton();
        botonCerrar = new javax.swing.JButton();
        labelFlota = new javax.swing.JLabel();
        labelEnvio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        botonCancelarEnvio.setText("Cancelar Envio");
        botonCancelarEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarEnvioActionPerformed(evt);
            }
        });

        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        labelFlota.setText("No. Envio");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(botonCancelarEnvio))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelFlota, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCerrar)
                        .addGap(19, 19, 19))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(labelFlota, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelarEnvio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCerrar)))
                .addGap(27, 27, 27))
        );

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int fila = tabla.getSelectedRow();
        seleccionN=fila;
        seleccion=true;
        labelEnvio.setText((fila+1)+"");
        labelEnvio.setVisible(true);
        labelFlota.setVisible(true);
        botonCancelarEnvio.setVisible(true);
    }//GEN-LAST:event_tablaMouseClicked

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        limpiar();
        this.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void botonCancelarEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarEnvioActionPerformed
        if(seleccion){
            quitarFlota(seleccionN);
            limpiar();
        }
    }//GEN-LAST:event_botonCancelarEnvioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelarEnvio;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelEnvio;
    private javax.swing.JLabel labelFlota;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
