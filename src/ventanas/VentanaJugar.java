
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

public class VentanaJugar extends javax.swing.JFrame {

    GeneradorAleatorioPlanetasN generadorAleatorio = new GeneradorAleatorioPlanetasN();
    Archivo archivo = new Archivo();
    Juego juego;
    Tablero tablero = new Tablero();
    JButton tableroBotones [][];
    VentanaNuevoMapa ventanaNuevoMapa = new VentanaNuevoMapa(this);
    String pathMapa;
    GeneradorIconos generadorIconos = new GeneradorIconos();
    GeneradorAcciones generadorAcciones = new GeneradorAcciones();
    ActualizacionPlanetas actualizacionPlanetas = new ActualizacionPlanetas();
    VentanaEnviarFlota ventanaEnviarFlota = new VentanaEnviarFlota(this);
    VentanaVerFlota ventanaVerFlota = new VentanaVerFlota(this);
    public Medicion medicion = new Medicion();
    Ataques ataques = new Ataques(this);
    ArrayList<Mensaje> listaMensajes = new ArrayList<>();
    VerificadorPlaneta verificadorPlaneta = new VerificadorPlaneta();
    JugadorPC jpc = new JugadorPC(this);
    public Planeta planeta1;
    public Planeta planeta2;
    public int opcion;
    public int turno, numeroTurno;

    public VentanaJugar() {
        initComponents();
        this.setLocationRelativeTo(null);
        panel2.setOpaque(false);
        ImageIcon fondo = new ImageIcon("src/planetas/u2.jpg");
        labelFondo.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_SMOOTH)));
        //botonFinTurno.doClick();
    }
    
    public void iniciarMapa(){
        if(juego.getMapa().isAlAzar()){
            if(juego.getMapa().getNumeroCuadros()>=(juego.getMapa().getPlanetasNeutrales()+juego.getListaPlanetas().size())){
                //Generar Nutrales aleatorios
                juego.setListaPlanetasNeutrales(generadorAleatorio.generarNeutralesAleatorios(juego.getMapa().getPlanetasNeutrales(), juego.getMapa().isMostrarNavesNeutrales(), juego.getMapa().isMostrarEstadisticasNeutrales(), juego.getMapa().getProduccionNeutrales()));
                juego = actualizacionPlanetas.actualizarPlanetas(juego);
                pintar();
            }else{
                JOptionPane.showMessageDialog(null, "EL NUMERO DE CASILLAS ES MENOR AL NUMERO DE PLANETAS");
            }
        }else{
            if(juego.getMapa().getNumeroCuadros()>=(juego.getListaPlanetasNeutrales().size()+juego.getListaPlanetas().size())){
                juego = actualizacionPlanetas.actualizarPlanetas(juego);
                pintar();

            }else{
                JOptionPane.showMessageDialog(null, "EL NUMERO DE CASILLAS ES MENOR AL NUMERO DE PLANETAS");
            }
        }
    }
    
    public void pintar(){
        tablero.generarTablero(juego.getMapa().getTamanioX(), juego.getMapa().getTamanioY());
        tableroBotones = tablero.getTablero();
        
        
        for (int i = 0; i < juego.getMapa().getTamanioX(); i++) {
            for (int j = 0; j < juego.getMapa().getTamanioY(); j++) {
                //System.out.println(i+", "+j);
                panel2.add(tableroBotones[i][j]);  
            }
        }
        tableroBotones = generadorIconos.generarIconos(juego, tableroBotones);
        tableroBotones = generadorAcciones.generarAciones(juego, tableroBotones, this);
        panel2.setLayout(new GridLayout(juego.getMapa().getTamanioX(),juego.getMapa().getTamanioY()));
        panel2.validate();
        panel2.repaint();
        opcion=0;
        panelOpciones.setVisible(true);
        panel1.setVisible(true);
        panel3.setVisible(true);
        iniciarDatos();
        pintarDatosJugador();
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
        tableroBotones = generadorAcciones.generarAciones(juego, tableroBotones, this);
        panel2.setLayout(new GridLayout(juego.getMapa().getTamanioX(),juego.getMapa().getTamanioY()));
        panel2.validate();
        panel2.repaint();
        
        opcion=0;
        panelOpciones.setVisible(true);
        panel1.setVisible(true);
        panel3.setVisible(true);
        textoAreaMensajes.setText("TURNO: "+numeroTurno+"");
        pintarDatosJugador();
        
    }
    public void setPlanetaSeleccionado(Planeta planeta){
        Planeta aux = isTipoPlaneta(planeta.getPosicion(), planeta.getTipo());
        if(opcion==0){
            labelPlaneta1.setText(aux.getNombre());
            panelOpciones.setVisible(true);
            System.out.println("Funciona");
        }else{
            labelPlaneta2.setText(aux.getNombre());
        }
    }
    private Planeta isTipoPlaneta(int posicion, int tipo){
        if(tipo==1){
            return juego.getListaPlanetas().get(posicion);
        }
        return juego.getListaPlanetasNeutrales().get(posicion);
    }
    public void medirDistancia(){
        if(planeta1!=null && planeta2!=null){
            Planeta aux1 = isTipoPlaneta(planeta1.getPosicion(), planeta1.getTipo());
            Planeta aux2 = isTipoPlaneta(planeta2.getPosicion(), planeta2.getTipo());
            JOptionPane.showMessageDialog(null,medicion.medirDistancia(aux1, aux2) );
            
        }
    }
    public void enviarFlota(){
        if(planeta1!=null && planeta2!=null){
            Planeta aux1 = isTipoPlaneta(planeta1.getPosicion(), planeta1.getTipo());
            Planeta aux2 = isTipoPlaneta(planeta2.getPosicion(), planeta2.getTipo());
            if(aux1.getJugador()==turno){
                if(planeta1.getTipo()==1 && aux1.getJugador()!=aux2.getJugador()){
                    System.out.println("Bien atacaste");
                    atacar(aux1, aux2);

                }else if(planeta1.getTipo()==1 && planeta2.getTipo()==0){
                    System.out.println("Bien atacaste");
                    atacar(aux1, aux2);
                }else{
                    JOptionPane.showMessageDialog(null, "Los planetas seleccionados le pertenecen a el mismo jugador");
                } 
            }else{
                JOptionPane.showMessageDialog(null, "El Primer planeta \nNo pertenece al jugador en turno");
            }
            
        }
    }
    public void atacar(Planeta aux1, Planeta aux2){
        Flota flota = new Flota(aux1.getPosicion(), aux2.getPosicion(), aux1.getNombre(), aux2.getNombre(), aux1.getPorcentajeMuertes(),aux2.getTipo());
                flota.setTurno(medicion.medirDistancia(aux1, aux2));
                flota.setPorcetajeMuertes(aux1.getPorcentajeMuertes());
                ventanaEnviarFlota.setFlotaAux(flota);
                ventanaEnviarFlota.setLabelCantidad(aux1.getNaves()-aux1.getNavesEnviadas());
                ventanaEnviarFlota.actualizarNaves(aux1.getNaves(), aux1.getNavesEnviadas());
                ventanaEnviarFlota.setDatos();
                ventanaEnviarFlota.setVisible(true);
                this.setEnabled(false);
                
                
    }
    
    public void agregarFlota(Flota flotaA){
        flotaA.setNumero( juego.getListaJugadores().get(turno).getListaFlota().size()+1);
        juego.getListaJugadores().get(turno).agregarFlora(flotaA);
        int navesA = juego.getListaPlanetas().get(planeta1.getPosicion()).getNavesEnviadas();
        juego.getListaPlanetas().get(planeta1.getPosicion()).setNavesEnviadas(navesA+flotaA.getNavesEnviadas());
        //juego.getListaJugadores().get(planeta1.getJugador()).agregarFlora(flotaA);
        planeta1=null;
        planeta2=null;
        labelPlaneta1.setText("");
        labelPlaneta2.setText("");
        this.setEnabled(true);
    }
    public void iniciarDatos(){
        turno=0;
        numeroTurno=1;
        textoAreaMensajes.setText("TURNO: "+numeroTurno+"");
    }
    public void pintarDatosJugador(){
        labelJug.setText(juego.getListaJugadores().get(turno).getNombre());
        labelTun.setText(numeroTurno+"");
    }
    public void agregarMensaje(Mensaje mensaje){
        listaMensajes.add(mensaje);
        textoAreaMensajes.setText(textoAreaMensajes.getText()+"\n"+mensaje.toString());
    }
    
    public void actualizarBoton(int x,int y,Planeta p){
        p.toString();
        quitarAccionBoton(x, y);
        Accion ac = new Accion(this, p);
        tableroBotones[x][y].addActionListener(ac);
        cambiarTextoBoton(x, y, p);
    }
    public void quitarAccionBoton(int x,int y){
        for (ActionListener al : tableroBotones[x][y].getActionListeners()) {
            tableroBotones[x][y].removeActionListener(al);
        }
    }
    public void verificarGanador(){
        if(verificadorPlaneta.verificarPlanetasNeutrales(juego) && verificadorPlaneta.verificarGanador(juego)){
            JOptionPane.showMessageDialog(null, "Hay un Ganador");
        }
    }
    public void cambiarTextoBoton(int x,int y,Planeta p){
        tableroBotones[x][y].setText("<html><b>N :</b>"+p.getNombre()+"<br>"+"<b>J: </b>"+juego.getListaJugadores().get(p.getJugador()).getNombre()+"<html>");
        String texto = "<html><b>J: </b>"+juego.getListaJugadores().get(p.getJugador()).getNombre()+"<br><b>Nombre: </b>"+p.getNombre()+"<br>";
                    if(!juego.getMapa().isMapaCiego()){
                        
                        texto += "<b>Naves: </b>"+p.getNaves()+"<br>";
                        texto += "<b>Produccion: </b>"+p.getProduccion()+"<br>";
                        texto += "<b>Porcentaje: </b>"+p.getPorcentajeMuertes()+"<br>";
                        texto += "<html>";
                        tableroBotones[x][y].setToolTipText(texto);
                    }
    }
    
    public void bloquear(boolean opci){
        botonConsultarFlota.setEnabled(opci);
        botonEnviarNaves.setEnabled(opci);
        botonFinTurno.setEnabled(opci);
        botonMedirDistancia.setEnabled(opci);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        botonConsultarFlota = new javax.swing.JButton();
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
        botonEnviarNaves = new javax.swing.JButton();
        botonMedirDistancia = new javax.swing.JButton();
        botonFinTurno = new javax.swing.JButton();
        labelPlaneta1 = new javax.swing.JLabel();
        labelPlaneta2 = new javax.swing.JLabel();
        labelFlecha = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuJugar = new javax.swing.JMenu();
        menuItemNuevoJuego = new javax.swing.JMenuItem();
        menuItemLeer = new javax.swing.JMenuItem();
        menuItemCargarPartida = new javax.swing.JMenuItem();
        menuItemGuardaPartida = new javax.swing.JMenuItem();
        menuItemReplay = new javax.swing.JMenuItem();
        menuItemPVP = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenu();
        menuItemEditarMapa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new java.awt.Color(0, 0, 0));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonConsultarFlota.setText("Consultar Flota");
        botonConsultarFlota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarFlotaActionPerformed(evt);
            }
        });
        panel1.add(botonConsultarFlota, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        labelJugador.setForeground(new java.awt.Color(204, 0, 0));
        labelJugador.setText("Jugador:");
        panel1.add(labelJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        labelTurno.setForeground(new java.awt.Color(204, 0, 0));
        labelTurno.setText("Turno:");
        panel1.add(labelTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        labelJug.setForeground(new java.awt.Color(255, 255, 0));
        panel1.add(labelJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 100, 20));

        labelTun.setForeground(new java.awt.Color(0, 204, 0));
        panel1.add(labelTun, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 90, 20));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 60));

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

        botonEnviarNaves.setText("Enviar Naves");
        botonEnviarNaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarNavesActionPerformed(evt);
            }
        });

        botonMedirDistancia.setText("Medir Distancia");
        botonMedirDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMedirDistanciaActionPerformed(evt);
            }
        });

        botonFinTurno.setText("Fin Turno");
        botonFinTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinTurnoActionPerformed(evt);
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
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(labelPlaneta1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPlaneta2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(botonMedirDistancia)
                .addGap(18, 18, 18)
                .addComponent(botonEnviarNaves)
                .addGap(18, 18, 18)
                .addComponent(botonFinTurno)
                .addContainerGap())
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonFinTurno)
                    .addComponent(botonEnviarNaves)
                    .addComponent(botonMedirDistancia)
                    .addComponent(labelPlaneta1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPlaneta2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFlecha))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 650, 60));

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
        menuItemNuevoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNuevoJuegoActionPerformed(evt);
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
        menuItemCargarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCargarPartidaActionPerformed(evt);
            }
        });
        menuJugar.add(menuItemCargarPartida);

        menuItemGuardaPartida.setText("Guardar Partida");
        menuItemGuardaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGuardaPartidaActionPerformed(evt);
            }
        });
        menuJugar.add(menuItemGuardaPartida);

        menuItemReplay.setText("Replay");
        menuJugar.add(menuItemReplay);

        menuItemPVP.setText("GuardarReplay");
        menuJugar.add(menuItemPVP);

        menuBar.add(menuJugar);

        menuEditar.setText("Edit");

        menuItemEditarMapa.setText("Editar Mapa");
        menuEditar.add(menuItemEditarMapa);

        menuBar.add(menuEditar);

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
                pathMapa = ruta;
                AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(archivo.leerArchivo(ruta)));
                AnalizadorSintactico sintacitico = new AnalizadorSintactico(lexico);
                
                sintacitico.parse();
                juego = sintacitico.getJuego();
                panel2.removeAll();
                //pintar();
                if(juego.getManejadorMapa().isCompleto()){
                    iniciarMapa();
                }else{
                    JOptionPane.showMessageDialog(null, "El Archivo de Entrada no es Correcto");
                    //mostrar errores
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "El archivo de entrada no es correcto");
            }
        }
    }//GEN-LAST:event_menuItemLeerActionPerformed

    public void sumarTurno(){
        ataques.verificarAtaques(juego, turno, numeroTurno);
        
        if(turno==(juego.getListaJugadores().size()-1)){
            juego = verificadorPlaneta.asignarProduccion(juego);
            turno=0;
            //turnatPc();
            numeroTurno++;
            textoAreaMensajes.setText(textoAreaMensajes.getText()+"\n\nTURNO: "+numeroTurno+"");
            //ataques.verificarAtaques(juego, turno, numeroTurno);
        }else{
            turno++;
            //turnatPc();
            //ataques.verificarAtaques(juego, turno, numeroTurno);
        }
        if(!verificadorPlaneta.verificarSiTienePlanetas(juego, turno)){
                sumarTurno();
                System.out.println("Ya no tiene planetas");
            }
        verificarGanador();
        
        pintarDatosJugador();
        turnatPc();
    }
    public void turnatPc(){
        if(juego.getListaJugadores().get(turno).getTipo()==1){
            JOptionPane.showMessageDialog(null, "Turno de Facil");
            bloquear(false);
            jpc.iaFacil(juego, turno);
            bloquear(true);
            sumarTurno();
        }else if(juego.getListaJugadores().get(turno).getTipo()==2){
            JOptionPane.showMessageDialog(null, "Turno de Dificil");
            bloquear(false);
            jpc.iaDificil(juego, turno);
            jpc.iaDificil(juego, turno);
            jpc.iaDificil(juego, turno);
            bloquear(true);
            sumarTurno();
        }
    }
    
    private void menuItemNuevoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNuevoJuegoActionPerformed
        ventanaNuevoMapa.setVisible(true);
        ventanaNuevoMapa.limpiar();
        this.setVisible(false);
    }//GEN-LAST:event_menuItemNuevoJuegoActionPerformed

    private void botonMedirDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMedirDistanciaActionPerformed
        medirDistancia();
    }//GEN-LAST:event_botonMedirDistanciaActionPerformed

    private void botonEnviarNavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarNavesActionPerformed
        enviarFlota();
    }//GEN-LAST:event_botonEnviarNavesActionPerformed

    private void botonFinTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinTurnoActionPerformed
        ataques.verificarAtaques(juego, turno, numeroTurno);
        
        if(turno==(juego.getListaJugadores().size()-1)){
            juego = verificadorPlaneta.asignarProduccion(juego);
            turno=0;
            //turnatPc();
            numeroTurno++;
            textoAreaMensajes.setText(textoAreaMensajes.getText()+"\n\nTURNO: "+numeroTurno+"");
            //ataques.verificarAtaques(juego, turno, numeroTurno);
        }else{
            turno++;
            //turnatPc();
            //ataques.verificarAtaques(juego, turno, numeroTurno);
        }
        if(!verificadorPlaneta.verificarSiTienePlanetas(juego, turno)){
                sumarTurno();
                System.out.println("Ya no tiene planetas");
            }
        verificarGanador();
        
        pintarDatosJugador();
        turnatPc();
    }//GEN-LAST:event_botonFinTurnoActionPerformed

    private void botonConsultarFlotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarFlotaActionPerformed
        ventanaVerFlota.limpiar();
        System.out.println("Tamnio flota: "+juego.getListaJugadores().get(turno).getListaFlota().size());
        ventanaVerFlota.pintar(juego.getListaJugadores().get(turno).getListaFlota());
        ventanaVerFlota.setVisible(true);
    }//GEN-LAST:event_botonConsultarFlotaActionPerformed

    public void escribirArchivo(String texto){
        GuardarArchivo guardarArchivo = new GuardarArchivo();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        
        String ruta = "";
        if(file!=null){
            ruta = file.getPath();
            String nombreProyecto = JOptionPane.showInputDialog("Escriba el nombre de la Partida");
            guardarArchivo.crearJSON(nombreProyecto, ruta, texto);
            JOptionPane.showMessageDialog(null, "Se guardo ls Partida");
        }
    }
    
    private void menuItemGuardaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGuardaPartidaActionPerformed
        //Codigo para guardar xD
        juego.getMapa().setTurno(turno);
        juego.getMapa().setNumeroTurno(numeroTurno);
        GeneradorPartidaGuardar generadorPartidaGuardar = new GeneradorPartidaGuardar();
        generadorPartidaGuardar.generar(juego.getMapa(), juego.getListaPlanetas(), juego.getListaPlanetasNeutrales(), juego.getListaJugadores(), listaMensajes);
        escribirArchivo(generadorPartidaGuardar.getTexto());
    }//GEN-LAST:event_menuItemGuardaPartidaActionPerformed

    private void menuItemCargarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCargarPartidaActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        String ruta = "";
        AnalizadorSintacticoG sintacitico = null ;
        if(file!=null){
            try {
                ruta = file.getPath();
                pathMapa = ruta;
                AnalizadorLexicoG lexico = new AnalizadorLexicoG(new StringReader(archivo.leerArchivo(ruta)));
                sintacitico = new AnalizadorSintacticoG(lexico);
                
                sintacitico.parse();
                if(sintacitico.isCorrecto()){
                    juego = sintacitico.getJuego();
                    listaMensajes = sintacitico.getListaMensajes();
                    panel2.removeAll();
                    turno = juego.getMapa().getTurno();
                    numeroTurno = juego.getMapa().getNumeroTurno();
                    cargarMapa();
                }else{
                    JOptionPane.showMessageDialog(null, "El archivo de entrada no es correcto");
                }
                
            } catch (Exception ex) {
                //ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "El archivo de entrada no es correcto");
                ArrayList<Error> listaErrores = sintacitico.getListaErrores();
                for (int i = 0; i < listaErrores.size(); i++) {
                    System.out.println(listaErrores.get(i).toString());
                }
            }
        }
        
        
        
    }//GEN-LAST:event_menuItemCargarPartidaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConsultarFlota;
    private javax.swing.JButton botonEnviarNaves;
    private javax.swing.JButton botonFinTurno;
    private javax.swing.JButton botonMedirDistancia;
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
    private javax.swing.JMenu menuEditar;
    private javax.swing.JMenuItem menuItemCargarPartida;
    private javax.swing.JMenuItem menuItemEditarMapa;
    private javax.swing.JMenuItem menuItemGuardaPartida;
    private javax.swing.JMenuItem menuItemLeer;
    private javax.swing.JMenuItem menuItemNuevoJuego;
    private javax.swing.JMenuItem menuItemPVP;
    private javax.swing.JMenuItem menuItemReplay;
    private javax.swing.JMenu menuJugar;
    public javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    public javax.swing.JPanel panel3;
    public javax.swing.JPanel panelOpciones;
    private javax.swing.JTextArea textoAreaMensajes;
    // End of variables declaration//GEN-END:variables
}
