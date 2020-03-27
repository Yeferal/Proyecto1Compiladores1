
package ventanas;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import objetos.Error;

public class VentanaErrores extends javax.swing.JFrame {

    ArrayList<Error> listaErroresSintactico = new ArrayList<>();
    ArrayList<Error> listaErroresLexico = new ArrayList<>();
    
    public VentanaErrores() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void setActualizar(ArrayList<Error> listaErroresSintactico, ArrayList<Error> listaErroresLexico){
        setListaErroresSintactico(listaErroresSintactico);
        setListaErroresLexico(listaErroresLexico);
    }

    public ArrayList<Error> getListaErroresSintactico() {
        return listaErroresSintactico;
    }

    public void setListaErroresSintactico(ArrayList<Error> listaErroresSintactico) {
        this.listaErroresSintactico = listaErroresSintactico;
    }

    public ArrayList<Error> getListaErroresLexico() {
        return listaErroresLexico;
    }

    public void setListaErroresLexico(ArrayList<Error> listaErroresLexico) {
        this.listaErroresLexico = listaErroresLexico;
    }
    
    
    public void actualizarListados(){
        DefaultListModel model = new DefaultListModel<>();
        DefaultListModel model2 = new DefaultListModel<>();
        
        for (int i = 0; i < listaErroresSintactico.size(); i++) {
            //listaSintactico.add
            model.addElement(listaErroresSintactico.get(i).toStringL());
        }
        
        for (int i = 0; i < listaErroresLexico.size(); i++) {
            //listaSintactico.add
            model2.addElement(listaErroresLexico.get(i).toString());
        }
        
        listaSintactico.setModel(model);
        listaLexico.setModel(model2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaLexico = new javax.swing.JList<>();
        jSeparator1 = new javax.swing.JSeparator();
        panel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaSintactico = new javax.swing.JList<>();
        botonCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(listaLexico);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 480));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, 480));

        jScrollPane2.setViewportView(listaSintactico);

        botonCerrar.setText("Cerrar");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonCerrar)
                .addGap(19, 19, 19))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(botonCerrar)
                .addContainerGap())
        );

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 420, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> listaLexico;
    private javax.swing.JList<String> listaSintactico;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    // End of variables declaration//GEN-END:variables
}
