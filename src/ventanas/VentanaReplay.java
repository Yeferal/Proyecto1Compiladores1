
package ventanas;

import analizador.guardar.AnalizadorLexicoG;
import analizador.guardar.AnalizadorSintacticoG;
import analizadores.AnalizadorLexico;
import analizadores.AnalizadorSintactico;
import archivos.Archivo;
import archivos.GeneradorPartidaGuardar;
import archivos.GuardarArchivo;
import game.Accion;
import game.ActualizacionPlanetas;
import game.Ataques;
import game.GeneradorAcciones;
import game.GeneradorAleatorioPlanetasN;
import game.GeneradorIconos;
import game.JugadorPC;
import game.Medicion;
import game.Tablero;
import game.VerificadorPlaneta;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import objetos.Flota;
import objetos.Juego;
import objetos.Mensaje;
import objetos.Planeta;
import objetos.Error;
import objetos.Repeticion;
import replay.AnalizadorLexicoR;
import replay.AnalizadorSintacticoR;

public class VentanaReplay extends javax.swing.JFrame {

    /*
    VentanaNuevoMapa ventanaNuevoMapa = new VentanaNuevoMapa(this);
    
    
    GeneradorAcciones generadorAcciones = new GeneradorAcciones();
    ActualizacionPlanetas actualizacionPlanetas = new ActualizacionPlanetas();
    VentanaEnviarFlota ventanaEnviarFlota = new VentanaEnviarFlota(this);
    VentanaVerFlota ventanaVerFlota = new VentanaVerFlota(this);
    public Medicion medicion = new Medicion();
    Ataques ataques = new Ataques(this);
    
    VerificadorPlaneta verificadorPlaneta = new VerificadorPlaneta();
    JugadorPC jpc = new JugadorPC(this);
    */
    GeneradorAleatorioPlanetasN generadorAleatorio = new GeneradorAleatorioPlanetasN();
    
    Juego juego;
    Tablero tablero = new Tablero();
    JButton tableroBotones [][];
    Archivo archivo = new Archivo();
    String pathMapa;
    GeneradorIconos generadorIconos = new GeneradorIconos();
    ArrayList<Mensaje> listaMensajes = new ArrayList<>();
    ArrayList<Repeticion> listaRepeticiones = new ArrayList<>();
    public Planeta planeta1;
    public Planeta planeta2;
    public int opcion;
    public int turno, numeroTurno, bandera;
    VentanaJugar ventanaJugar;
    
    
    public VentanaReplay(VentanaJugar ventanaJugar) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaJugar = ventanaJugar;
        panel2.setOpaque(false);
        ImageIcon fondo = new ImageIcon("src/planetas/u2.jpg");
        labelFondo.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void cargarMapa(){
        tablero.generarTablero(juego.getMapa().getTamanioX(), juego.getMapa().getTamanioY());
        tableroBotones = tablero.getTablero();
        
        for (int i = 0; i < juego.getMapa().getTamanioX(); i++) {
            for (int j = 0; j < juego.getMapa().getTamanioY(); j++) {
                //System.out.println(i+", "+j);
                panel2.add(tableroBotones[i][j]);  
            }
        }
        tableroBotones = generadorIconos.generarIconosExistentes(juego, tableroBotones);
        //tableroBotones = generadorAcciones.generarAciones(juego, tableroBotones, this);
        panel2.setLayout(new GridLayout(juego.getMapa().getTamanioX(),juego.getMapa().getTamanioY()));
        panel2.validate();
        panel2.repaint();
        
        opcion=0;
        panelOpciones.setVisible(true);
        panel1.setVisible(true);
        panel3.setVisible(true);
        
        inciciarDatos();
        textoAreaMensajes.setText("TURNO: "+numeroTurno+"");
        pintarDatosJugador();
        
    }
    public void inciciarDatos(){
        turno =1;
        numeroTurno =1;
        bandera=0;
        //listaMensajes = new ArrayList<>();
        //listaRepeticiones = new ArrayList<>();
    }
    
    public void pintarDatosJugador(){
        labelJug.setText(juego.getListaJugadores().get(turno).getNombre());
        labelTun.setText(numeroTurno+"");
        
        
    }
    
    public void correrCambio(){
        if(listaMensajes.size()!=bandera){
            if(numeroTurno==listaMensajes.get(bandera).getTurno()){
            if(listaMensajes.size()!=bandera){
                listaMensajes.get(bandera).setResultadoS();
                textoAreaMensajes.setText(textoAreaMensajes.getText()+"\n"+listaMensajes.get(bandera).toString());
                
                if(listaRepeticiones.get(bandera).isResultado()){
                
                    Planeta p1 = getPlanetaSeleccionado(listaRepeticiones.get(bandera).getPosicionOrigen(), 1);
                    Planeta p2 = getPlanetaSeleccionado(listaRepeticiones.get(bandera).getPosicionDestion(), listaRepeticiones.get(bandera).getTipoPlanetaDestino());
                    
                    cambiarPlaneta(juego, listaRepeticiones.get(bandera).getPosicionDestion(), p1.getJugador(), listaRepeticiones.get(bandera).getTipoPlanetaDestino());
                    cambiarTextoBoton(p2.getCoordenadaX(), p2.getCoordenadaY(), p2);
                }else{
                    System.out.println("NO ENTRO EN REPETICION");
                }
                    bandera = bandera +1;


                }else{
                    JOptionPane.showMessageDialog(null, "Se termino la partida");
                }


            }else{
                sumarTurno();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Se termino la partida");
        }
        
        
        System.out.println("Bandera: "+bandera);
        
        
    }
    
    public Planeta getPlanetaSeleccionado(int posicion, int tipo){
        if(tipo==1){
            return juego.getListaPlanetas().get(posicion);
        }
        return juego.getListaPlanetasNeutrales().get(posicion);
    }
    
    public void sumarTurno(){
        
        
        if(turno==(juego.getListaJugadores().size()-1)){
            
            turno=0;
            
            numeroTurno++;
            textoAreaMensajes.setText(textoAreaMensajes.getText()+"\n\nTURNO: "+numeroTurno+"");
            
        }else{
            turno++;
           
        }
        
        pintarDatosJugador();
        
    }
    
    
    public void cambiarTextoBoton(int x,int y,Planeta p){
        tableroBotones[x][y].setText("<html><b>N :</b>"+p.getNombre()+"<br>"+"<b>J: </b>"+juego.getListaJugadores().get(p.getJugador()).getNombre()+"<html>");
        String texto = "<html><b>J: </b>"+juego.getListaJugadores().get(p.getJugador()).getNombre()+"<br><b>Nombre: </b>"+p.getNombre()+"<br>";
                        texto += "<b>Naves: </b>"+p.getNaves()+"<br>";
                        texto += "<b>Produccion: </b>"+p.getProduccion()+"<br>";
                        texto += "<b>Porcentaje: </b>"+p.getPorcentajeMuertes()+"<br>";
                        texto += "<html>";
                        tableroBotones[x][y].setToolTipText(texto);
                    
    }
    
    public void cambiarPlaneta(Juego juego,int numeroPlaneta, int jugador, int tipo){
        int tipoPla = 0;
        if(tipo==1){
            tipoPla = 1;
            juego.getListaPlanetas().get(numeroPlaneta).setJugador(jugador);
        }else{
            tipoPla = 0;
            juego.getListaPlanetasNeutrales().get(numeroPlaneta).setJugador(jugador);
            juego.getListaPlanetasNeutrales().get(numeroPlaneta).setTipo(1);
            Planeta pl = juego.getListaPlanetasNeutrales().get(numeroPlaneta);
            pl.setPosicion(juego.getListaPlanetas().size());
            juego.getListaPlanetas().add(pl);
            //juego.getListaPlanetasNeutrales().get(numeroPlaneta).setTipo(1);
        }
    }
    
    public void mostrarErrores(ArrayList<Error> listaErroresSintactico, ArrayList<Error> listaErroresLexico){
        ventanaJugar.ventanaErrores.setActualizar(listaErroresSintactico, listaErroresLexico);
        ventanaJugar.ventanaErrores.actualizarListados();
        ventanaJugar.ventanaErrores.setVisible(true);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        botonRegresar = new javax.swing.JButton();
        labelJugador = new javax.swing.JLabel();
        labelTurno = new javax.swing.JLabel();
        labelJug = new javax.swing.JLabel();
        labelTun = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        panel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoAreaMensajes = new javax.swing.JTextArea();
        labelFondo = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        botonSiguiente = new javax.swing.JButton();
        labelPlaneta1 = new javax.swing.JLabel();
        labelPlaneta2 = new javax.swing.JLabel();
        labelFlecha = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuJugar = new javax.swing.JMenu();
        menuItemReplay = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new java.awt.Color(0, 0, 0));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonRegresar.setText("Regresar Ventana Principal");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        panel1.add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        labelJugador.setForeground(new java.awt.Color(204, 0, 0));
        labelJugador.setText("Jugador:");
        panel1.add(labelJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        labelTurno.setForeground(new java.awt.Color(204, 0, 0));
        labelTurno.setText("Turno:");
        panel1.add(labelTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        labelJug.setForeground(new java.awt.Color(255, 255, 0));
        panel1.add(labelJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 100, 20));

        labelTun.setForeground(new java.awt.Color(0, 204, 0));
        panel1.add(labelTun, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 90, 20));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 60));

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

        textoAreaMensajes.setEditable(false);
        textoAreaMensajes.setBackground(new java.awt.Color(0, 0, 0));
        textoAreaMensajes.setColumns(20);
        textoAreaMensajes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textoAreaMensajes.setForeground(new java.awt.Color(255, 0, 0));
        textoAreaMensajes.setRows(5);
        jScrollPane1.setViewportView(textoAreaMensajes);

        panel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 160));

        getContentPane().add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1010, 160));
        getContentPane().add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, 1010, 600));

        panelOpciones.setBackground(new java.awt.Color(0, 0, 0));

        botonSiguiente.setText("Siguiente Movimiento");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        labelPlaneta1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        labelPlaneta1.setForeground(new java.awt.Color(255, 0, 51));

        labelPlaneta2.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        labelPlaneta2.setForeground(new java.awt.Color(0, 0, 255));

        labelFlecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFlecha.setText("==========>");

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(labelPlaneta1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPlaneta2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(botonSiguiente)
                .addGap(72, 72, 72))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelPlaneta1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPlaneta2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelFlecha))
                    .addComponent(botonSiguiente))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 550, 60));

        menuJugar.setText("Jugar");
        menuJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuJugarMouseClicked(evt);
            }
        });

        menuItemReplay.setText("Cargar Replay");
        menuItemReplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemReplayActionPerformed(evt);
            }
        });
        menuJugar.add(menuItemReplay);

        menuBar.add(menuJugar);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        
        ventanaJugar.setVisible(true);
        this.setVisible(false);
        /*ventanaVerFlota.limpiar();
        System.out.println("Tamnio flota: "+juego.getListaJugadores().get(turno).getListaFlota().size());
        ventanaVerFlota.pintar(juego.getListaJugadores().get(turno).getListaFlota());
        ventanaVerFlota.setVisible(true);*/
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
       correrCambio();
    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void menuJugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuJugarMouseClicked

    }//GEN-LAST:event_menuJugarMouseClicked

    private void menuItemReplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemReplayActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        String ruta = "";
        AnalizadorSintacticoR sintacitico = null ;
        AnalizadorLexicoR lexico = null;
        if(file!=null){
            try {
                ruta = file.getPath();
                pathMapa = ruta;
                lexico = new AnalizadorLexicoR(new StringReader(archivo.leerArchivo(ruta)));
                sintacitico = new AnalizadorSintacticoR(lexico);
                
                sintacitico.parse();
                if(sintacitico.isCorrecto()){
                    juego = sintacitico.getJuego();
                    listaMensajes = sintacitico.getListaMensajes();
                    listaRepeticiones = sintacitico.getListaRepeticiones();
                    panel2.removeAll();
                    //turno = juego.getMapa().getTurno();
                    //numeroTurno = juego.getMapa().getNumeroTurno();
                    cargarMapa();
                }else{
                    JOptionPane.showMessageDialog(null, "El archivo de entrada no es correcto");
                    mostrarErrores(sintacitico.getListaErrores(), lexico.getListaErrores());
                }
                
            } catch (Exception ex) {
                //ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "El archivo de entrada no es correcto");
                mostrarErrores(sintacitico.getListaErrores(), lexico.getListaErrores());
            }
        }
    }//GEN-LAST:event_menuItemReplayActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFlecha;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel labelJug;
    private javax.swing.JLabel labelJugador;
    private javax.swing.JLabel labelPlaneta1;
    private javax.swing.JLabel labelPlaneta2;
    private javax.swing.JLabel labelTun;
    private javax.swing.JLabel labelTurno;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemReplay;
    private javax.swing.JMenu menuJugar;
    public javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    public javax.swing.JPanel panel3;
    public javax.swing.JPanel panelOpciones;
    private javax.swing.JTextArea textoAreaMensajes;
    // End of variables declaration//GEN-END:variables
}
