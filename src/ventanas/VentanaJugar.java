
package ventanas;

import analizadores.AnalizadorLexico;
import analizadores.AnalizadorSintactico;
import archivos.Archivo;
import game.Tablero;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import objetos.Juego;

public class VentanaJugar extends javax.swing.JFrame {

    Archivo archivo = new Archivo();
    Juego juego;
    Tablero tablero = new Tablero();
    JButton tableroBotones [][];

    public VentanaJugar() {
        initComponents();
        this.setLocationRelativeTo(null);
        panel2.setOpaque(false);
        ImageIcon fondo = new ImageIcon("src/planetas/u2.jpg");
        labelFondo.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_SMOOTH)));
        
    }
    
    public void pintar(){
        System.out.println("MAPAPAPA");
        juego.getMapa().pintar();
        System.out.println("Lista planetas");
        for (int i = 0; i < juego.getListaPlanetas().size(); i++) {
            juego.getListaPlanetas().get(i).pintar();
        }
        System.out.println("Lista planetas neutrales");
        for (int i = 0; i < juego.getListaPlanetasNeutrales().size(); i++) {
            juego.getListaPlanetasNeutrales().get(i).pintar();
        }
        System.out.println("Lista Jugadores");
        for (int i = 0; i < juego.getListaJugadores().size(); i++) {
            juego.getListaJugadores().get(i).pintar();
        }
        tablero.generarTablero(juego.getMapa().getTamanioX(), juego.getMapa().getTamanioY());
        tableroBotones = tablero.getTablero();
        
        
        for (int i = 0; i < juego.getMapa().getTamanioX(); i++) {
            for (int j = 0; j < juego.getMapa().getTamanioY(); j++) {
                //System.out.println(i+", "+j);
                panel2.add(tableroBotones[i][j]);
                
                
            }
        }
        generarIconos();
        panel2.setLayout(new GridLayout(juego.getMapa().getTamanioX(),juego.getMapa().getTamanioY()));
        panel2.validate();
        panel2.repaint();
        
    }
    
    public void generarIconos(){
        int x;
        int y;
        for(int i =0; i<juego.getListaPlanetasNeutrales().size();i++){
            boolean vacio = true;
            do {
                x = (int) (Math.random()*juego.getMapa().getTamanioX());
                y = (int) (Math.random()*juego.getMapa().getTamanioY());
                if(tableroBotones[x][y].getIcon()==null){
                    tableroBotones[x][y].setIcon(tablero.getIcono(tableroBotones[x][y].getWidth(),tableroBotones[x][y].getHeight()));
                    vacio = false;
                }
            } while (vacio);
        }
        
        for(int i =0; i<juego.getListaPlanetas().size();i++){
            boolean vacio = true;
            do {
                x = (int) (Math.random()*juego.getMapa().getTamanioX());
                y = (int) (Math.random()*juego.getMapa().getTamanioY());
                if(tableroBotones[x][y].getIcon()==null){
                    tableroBotones[x][y].setIcon(tablero.getIcono(tableroBotones[x][y].getWidth(),tableroBotones[x][y].getHeight()));
                    vacio = false;
                }
            } while (vacio);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        panel3 = new javax.swing.JPanel();
        labelFondo = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuJugar = new javax.swing.JMenu();
        menuItemNuevoJuego = new javax.swing.JMenuItem();
        menuItemLeer = new javax.swing.JMenuItem();
        menuItemCargarPartida = new javax.swing.JMenuItem();
        menuItemGuardaPartida = new javax.swing.JMenuItem();
        menuItemReplay = new javax.swing.JMenuItem();
        menuItemPVP = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Consultar Flota");
        panel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton2.setText("jButton2");
        panel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 710, 590));

        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1010, 110));
        getContentPane().add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, 1010, 600));

        menuJugar.setText("Jugar");
        menuJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuJugarMouseClicked(evt);
            }
        });

        menuItemNuevoJuego.setText("Nuevo Juego");
        menuItemNuevoJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuItemNuevoJuegoMouseClicked(evt);
            }
        });
        menuJugar.add(menuItemNuevoJuego);

        menuItemLeer.setText("Leer Mapa");
        menuItemLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLeerActionPerformed(evt);
            }
        });
        menuJugar.add(menuItemLeer);

        menuItemCargarPartida.setText("Cargar Partida");
        menuJugar.add(menuItemCargarPartida);

        menuItemGuardaPartida.setText("Guardar Partida");
        menuJugar.add(menuItemGuardaPartida);

        menuItemReplay.setText("Replay");
        menuJugar.add(menuItemReplay);

        menuItemPVP.setText("PC vs PC");
        menuJugar.add(menuItemPVP);

        menuBar.add(menuJugar);

        jMenu2.setText("Edit");
        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemNuevoJuegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemNuevoJuegoMouseClicked
        
        
        
    }//GEN-LAST:event_menuItemNuevoJuegoMouseClicked

    private void menuJugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuJugarMouseClicked
        
        
        
    }//GEN-LAST:event_menuJugarMouseClicked

    private void menuItemLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLeerActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        String ruta = "";
        if(file!=null){
            try {
                ruta = file.getPath();
                AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(archivo.leerArchivo(ruta)));
                AnalizadorSintactico sintacitico = new AnalizadorSintactico(lexico);
                
                sintacitico.parse();
                juego = sintacitico.getJuego();
                pintar();
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_menuItemLeerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemCargarPartida;
    private javax.swing.JMenuItem menuItemGuardaPartida;
    private javax.swing.JMenuItem menuItemLeer;
    private javax.swing.JMenuItem menuItemNuevoJuego;
    private javax.swing.JMenuItem menuItemPVP;
    private javax.swing.JMenuItem menuItemReplay;
    private javax.swing.JMenu menuJugar;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    // End of variables declaration//GEN-END:variables
}
