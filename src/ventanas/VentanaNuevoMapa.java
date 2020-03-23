
package ventanas;

import archivos.GeneradorArchivoMapa;
import archivos.GuardarArchivo;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import manejadores.ManejadorMapa;
import objetos.Juego;
import objetos.Jugador;
import objetos.Mapa;
import objetos.Planeta;

public class VentanaNuevoMapa extends javax.swing.JFrame {

    Juego juego;
    Mapa mapa;
    private VentanaJugar ventanaJugar;
    ManejadorMapa manejadorMapa;
    ArrayList<Planeta> listaPlanetas = new ArrayList<>();
    ArrayList<Planeta> listaPlanetasNeutrales = new ArrayList<>();
    ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private VentanaNuevoPlaneta ventanaNuevoPlaneta = new VentanaNuevoPlaneta(this);
    VentanaNuevoJugador ventanaNuevoJugador = new VentanaNuevoJugador(this);
    private VentanaAsignarPlaneta ventanaAsignarPlaneta = new VentanaAsignarPlaneta(this);
    public int tipo, posicion, posicionJ,posicionP;
    private boolean seleccion1, seleccion2, seleccion3, seleccion4;
    private String nick;
    private GeneradorArchivoMapa generadorArchivoMapa = new GeneradorArchivoMapa();
    
    public VentanaNuevoMapa(VentanaJugar ventanaJugar) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaJugar = ventanaJugar;
    }
    
    public void limpiar(){
        textFieldNombreMapa.setText("");
        spinnerFila.setValue((int) 2);
        spinnerColumnas.setValue((int) 2);
        spinnerNoPlanetasN.setValue((int) 0);
        spinnerFinalizacion.setValue((int) 0);
        spinnerProduccion.setValue((int) 0);
        checkBoxAlAzar.setSelected(false);
        checkBoxAcumular.setSelected(false);
        checkBoxMapaCiego.setSelected(false);
        checkBoxMostrarEstadisticas.setSelected(false);
        checkBoxMostrarNaves.setSelected(false);
        listaJugadores.clear();
        listaPlanetas.clear();
        listaPlanetasNeutrales.clear();
        tablaJugadores.removeAll();
        tablaNeutrales.removeAll();
        tablaPlanetas.removeAll();
        tablaPlanetasJugador.removeAll();
        //tablaJugadores.setModel(null);
        seleccion1 = false;
        seleccion2 = false;
        seleccion3 = false;
        seleccion4 = false;
    }
    public void pintarPlanetasNeutrales(){
        DefaultTableModel modeloNeutrales = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
            };
        
            modeloNeutrales.addColumn("Nombre");
            modeloNeutrales.addColumn("Naves");
            modeloNeutrales.addColumn("% Muerte");
            modeloNeutrales.addColumn("Produccion");
        
            tablaNeutrales.setModel(modeloNeutrales);
            String datos[]= new String[4];
            
            
            for (int i = 0; i < listaPlanetasNeutrales.size(); i++) {
                datos[0] = listaPlanetasNeutrales.get(i).getNombre();
                datos[1] = listaPlanetasNeutrales.get(i).getNaves()+"";
                datos[2] = listaPlanetasNeutrales.get(i).getPorcentajeMuertes()+"";
                datos[3] = listaPlanetasNeutrales.get(i).getProduccion()+"";
                modeloNeutrales.addRow(datos);
            }

    }
    public void pintarPlanetas(){
        DefaultTableModel modeloPlanetas = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
            };
        
            modeloPlanetas.addColumn("Nombre");
            modeloPlanetas.addColumn("Naves");
            modeloPlanetas.addColumn("% Muerte");
            modeloPlanetas.addColumn("Produccion");
        
            tablaPlanetas.setModel(modeloPlanetas);
            String datos[]= new String[4];
            
            
            for (int i = 0; i < listaPlanetas.size(); i++) {
                datos[0] = listaPlanetas.get(i).getNombre();
                datos[1] = listaPlanetas.get(i).getNaves()+"";
                datos[2] = listaPlanetas.get(i).getPorcentajeMuertes()+"";
                datos[3] = listaPlanetas.get(i).getProduccion()+"";
                modeloPlanetas.addRow(datos);
            }

    }
    public void pintarJugadores(){
        DefaultTableModel modeloJugadores = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
            };
        
            modeloJugadores.addColumn("Nombre");
            modeloJugadores.addColumn("Tipo");
        
            tablaJugadores.setModel(modeloJugadores);
            String datos[]= new String[2];
            
            
            for (int i = 0; i < listaJugadores.size(); i++) {
                datos[0] = listaJugadores.get(i).getNombre();
                switch(listaJugadores.get(i).getTipo()){
                    case 0:
                        datos[1] = "Humano";
                        break;
                    case 1:
                        datos[1] = "Facil";
                        break;
                    case 2:
                        datos[1] = "Dificil";
                        break;
                }
                modeloJugadores.addRow(datos);
            }

    }
    
    public void pintarPlanetasJugador(int index){
        DefaultTableModel modeloJugadoresP = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
            };
        
            modeloJugadoresP.addColumn("Planeta");
        
            tablaPlanetasJugador.setModel(modeloJugadoresP);
            String datos[]= new String[1];
            
            
            for (int i = 0; i < listaJugadores.get(index).getListaPlanetas().size(); i++) {
                datos[0] = listaJugadores.get(index).getListaPlanetas().get(i);
                modeloJugadoresP.addRow(datos);
            }

    }
    
    
    
    public void agregarNuevoPlanetaNeutral(){
        listaPlanetasNeutrales.add(ventanaNuevoPlaneta.getPlaneta());
        
        ventanaNuevoPlaneta.limpiar();
        pintarPlanetasNeutrales();
    }
    
    public void agregarNuevoPlaneta(){
        listaPlanetas.add(ventanaNuevoPlaneta.getPlaneta());
        
        ventanaNuevoPlaneta.limpiar();
        pintarPlanetas();
    }
    public void agregarJugador(Jugador j){
        listaJugadores.add(j);
        ventanaNuevoJugador.limpiar();
        pintarJugadores();
    }
    public void agregarPlanetaJugador(String nickName){
        listaJugadores.get(posicionJ).insertarPlaneta(nickName);
        pintarPlanetasJugador(posicionJ);
        seleccion4 = false;
    }
    
    public void escribirArchivo(String texto){
        GuardarArchivo guardarArchivo = new GuardarArchivo();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        
        String ruta = "";
        if(file!=null){
            ruta = file.getPath();
            String nombreProyecto = JOptionPane.showInputDialog("Escriba el nombre del Mapa");
            guardarArchivo.crearJSON(nombreProyecto, ruta, texto);
            JOptionPane.showMessageDialog(null, "Se guardo el mapa");
        }
    }
    
    public Mapa setMapa(){
        Mapa mapa = new Mapa();
        mapa.setId(textFieldNombreMapa.getText());
        mapa.setTamanioX((int) spinnerFila.getValue());
        mapa.setTamanioY((int) spinnerColumnas.getValue());
        mapa.setAlAzar(checkBoxAlAzar.isSelected());
        mapa.setPlanetasNeutrales((int) spinnerNoPlanetasN.getValue());
        mapa.setMapaCiego(checkBoxMapaCiego.isSelected());
        mapa.setAcumular(checkBoxAcumular.isSelected());
        mapa.setMostrarNavesNeutrales(checkBoxMostrarNaves.isSelected());
        mapa.setMostrarEstadisticasNeutrales(checkBoxMostrarEstadisticas.isSelected());
        mapa.setProduccionNeutrales((int) spinnerProduccion.getValue());
        mapa.setFinalizacion((int) spinnerFinalizacion.getValue());
        return mapa;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        textFieldNombreMapa = new javax.swing.JTextField();
        labelNombreMapa = new javax.swing.JLabel();
        spinnerFila = new javax.swing.JSpinner();
        labelFilas = new javax.swing.JLabel();
        labelColumnas = new javax.swing.JLabel();
        spinnerColumnas = new javax.swing.JSpinner();
        labelNoPlanetasN = new javax.swing.JLabel();
        labelNeutrales = new javax.swing.JLabel();
        labelFinalizacion = new javax.swing.JLabel();
        checkBoxAlAzar = new javax.swing.JCheckBox();
        checkBoxMostrarEstadisticas = new javax.swing.JCheckBox();
        checkBoxMapaCiego = new javax.swing.JCheckBox();
        checkBoxMostrarNaves = new javax.swing.JCheckBox();
        checkBoxAcumular = new javax.swing.JCheckBox();
        spinnerFinalizacion = new javax.swing.JSpinner();
        spinnerNoPlanetasN = new javax.swing.JSpinner();
        labelProduccion = new javax.swing.JLabel();
        spinnerProduccion = new javax.swing.JSpinner();
        jSeparator1 = new javax.swing.JSeparator();
        botonCancelar = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        botonAniadirPN = new javax.swing.JButton();
        botonQuitarPN = new javax.swing.JButton();
        labelTituloPN = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPlanetas = new javax.swing.JTable();
        labelPlanetas = new javax.swing.JLabel();
        botonAniadirP = new javax.swing.JButton();
        botonQuitarP = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaNeutrales = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();
        botonAniadirJugador = new javax.swing.JButton();
        botonQuitarJugador = new javax.swing.JButton();
        labelJugadores = new javax.swing.JLabel();
        botonQuitarPJugador = new javax.swing.JButton();
        botonAniadirPJugador = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaPlanetasJugador = new javax.swing.JTable();
        labelTituloPJugador = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        labelFlecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNombreMapa.setText("Nombre Mapa:");

        spinnerFila.setModel(new javax.swing.SpinnerNumberModel(2, 2, null, 1));

        labelFilas.setText("Filas: ");

        labelColumnas.setText("Columnas: ");

        spinnerColumnas.setModel(new javax.swing.SpinnerNumberModel(2, 2, null, 1));

        labelNoPlanetasN.setText("No. Planetas Neutrales: ");

        labelNeutrales.setText("NEUTRALES");

        labelFinalizacion.setText("Finalizacion: ");

        checkBoxAlAzar.setText("Al Azar");

        checkBoxMostrarEstadisticas.setText("Mostrar Estadisticas");

        checkBoxMapaCiego.setText("Mapa Ciego: ");

        checkBoxMostrarNaves.setText("Mostrar Naves");

        checkBoxAcumular.setText("Acumular");

        spinnerFinalizacion.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinnerNoPlanetasN.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        labelProduccion.setText("Produccion: ");

        spinnerProduccion.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(checkBoxMostrarNaves)
                                    .addComponent(checkBoxMostrarEstadisticas)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(labelNeutrales))
                                    .addComponent(checkBoxAcumular)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(labelFilas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinnerFila, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelColumnas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinnerColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(labelNombreMapa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldNombreMapa))
                                    .addComponent(checkBoxMapaCiego)
                                    .addComponent(checkBoxAlAzar)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(labelNoPlanetasN)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinnerNoPlanetasN, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(labelFinalizacion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinnerFinalizacion))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(labelProduccion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinnerProduccion))))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(botonCancelar)))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreMapa)
                    .addComponent(textFieldNombreMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFilas)
                    .addComponent(spinnerFila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelColumnas)
                    .addComponent(spinnerColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(checkBoxAlAzar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(checkBoxMapaCiego)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxAcumular)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelNoPlanetasN)
                            .addComponent(spinnerNoPlanetasN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(labelFinalizacion))
                    .addComponent(spinnerFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(labelNeutrales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxMostrarNaves)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxMostrarEstadisticas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinnerProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelProduccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                .addComponent(botonCancelar)
                .addContainerGap())
        );

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 770));

        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonAniadirPN.setText("Añadir");
        botonAniadirPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadirPNActionPerformed(evt);
            }
        });
        panel2.add(botonAniadirPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        botonQuitarPN.setText("Quitar");
        botonQuitarPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarPNActionPerformed(evt);
            }
        });
        panel2.add(botonQuitarPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

        labelTituloPN.setText("PLANETAS NEUTRALES");
        panel2.add(labelTituloPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

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
        jScrollPane2.setViewportView(tablaPlanetas);

        panel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 359, 220));

        labelPlanetas.setText("PLANETAS ");
        panel2.add(labelPlanetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        botonAniadirP.setText("Añadir");
        botonAniadirP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadirPActionPerformed(evt);
            }
        });
        panel2.add(botonAniadirP, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, -1, 30));

        botonQuitarP.setText("Quitar");
        botonQuitarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarPActionPerformed(evt);
            }
        });
        panel2.add(botonQuitarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, -1, -1));

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        panel2.add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 730, -1, -1));

        tablaNeutrales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaNeutrales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaNeutralesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaNeutrales);

        panel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 360, 220));

        tablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaJugadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaJugadoresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaJugadores);

        panel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 360, 220));

        botonAniadirJugador.setText("Añadir");
        botonAniadirJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadirJugadorActionPerformed(evt);
            }
        });
        panel2.add(botonAniadirJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 620, -1, -1));

        botonQuitarJugador.setText("Quitar");
        botonQuitarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarJugadorActionPerformed(evt);
            }
        });
        panel2.add(botonQuitarJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 620, -1, -1));

        labelJugadores.setText("JUGADORES");
        panel2.add(labelJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        botonQuitarPJugador.setText("Quitar");
        botonQuitarPJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarPJugadorActionPerformed(evt);
            }
        });
        panel2.add(botonQuitarPJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 620, -1, -1));

        botonAniadirPJugador.setText("Añadir");
        botonAniadirPJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadirPJugadorActionPerformed(evt);
            }
        });
        panel2.add(botonAniadirPJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 620, -1, 30));

        tablaPlanetasJugador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaPlanetasJugador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPlanetasJugadorMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaPlanetasJugador);

        panel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 359, 220));

        labelTituloPJugador.setText("PLANETAS DE JUGADOR");
        panel2.add(labelTituloPJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, -1, -1));
        panel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 920, 10));

        labelFlecha.setText("==========>");
        panel2.add(labelFlecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 480, 80, -1));

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 920, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonQuitarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarPActionPerformed
        if(seleccion2){
            listaPlanetas.remove(posicion);
            pintarPlanetas();
            seleccion2 = false;
        }
    }//GEN-LAST:event_botonQuitarPActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if(!textFieldNombreMapa.getText().isEmpty() && !textFieldNombreMapa.getText().equals(" ")){
            if(listaJugadores.size()!=0 && listaPlanetasNeutrales.size()!=0 && listaPlanetas.size()!=0){
                generadorArchivoMapa.generar(setMapa(), listaPlanetas, listaPlanetasNeutrales, listaJugadores);
                System.out.println(generadorArchivoMapa.getTexto());
                escribirArchivo(generadorArchivoMapa.getTexto());
            }else{
                JOptionPane.showMessageDialog(null, "Una de las tablas es vacia");
            }
        }else{
            JOptionPane.showMessageDialog(null, "El nombre del Mapa no es correcto");
        }
        
        
        
        
        
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonQuitarPJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarPJugadorActionPerformed
        if(seleccion4 && seleccion3){
            for (int i = 0; i < listaPlanetas.size(); i++) {
                if(nick.equals(listaPlanetas.get(i).getNombre())){
                    listaPlanetas.get(i).setTieneJugador(false);
                }
            }
            listaJugadores.get(posicionJ).getListaPlanetas().remove(posicionP);
            pintarPlanetasJugador(posicionJ);
            seleccion4 = false;
            
        }
    }//GEN-LAST:event_botonQuitarPJugadorActionPerformed

    private void botonAniadirPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadirPNActionPerformed
        ventanaNuevoPlaneta.limpiar();
        ventanaNuevoPlaneta.setVisible(true);
        tipo = 0;
        this.setEnabled(false);
    }//GEN-LAST:event_botonAniadirPNActionPerformed

    private void tablaNeutralesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaNeutralesMouseClicked
        posicion = tablaNeutrales.getSelectedRow();
        System.out.println(posicion);
        seleccion1=true;
    }//GEN-LAST:event_tablaNeutralesMouseClicked

    private void botonAniadirPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadirPActionPerformed
        ventanaNuevoPlaneta.limpiar();
        ventanaNuevoPlaneta.setVisible(true);
        tipo = 1;
        this.setEnabled(false);
    }//GEN-LAST:event_botonAniadirPActionPerformed

    private void tablaPlanetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPlanetasMouseClicked
        posicion = tablaPlanetas.getSelectedRow();
        System.out.println(posicion);
        seleccion2=true;
    }//GEN-LAST:event_tablaPlanetasMouseClicked

    private void botonQuitarPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarPNActionPerformed
        if(seleccion1){
            listaPlanetasNeutrales.remove(posicion);
            pintarPlanetasNeutrales();
            seleccion1 = false;
        }
    }//GEN-LAST:event_botonQuitarPNActionPerformed

    private void botonAniadirJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadirJugadorActionPerformed
        ventanaNuevoJugador.limpiar();
        ventanaNuevoJugador.setVisible(true);
        this.setEnabled(false);
        
    }//GEN-LAST:event_botonAniadirJugadorActionPerformed

    private void tablaJugadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaJugadoresMouseClicked
        posicionJ = tablaJugadores.getSelectedRow();
        System.out.println(posicionJ);
        seleccion3 = true;
        pintarPlanetasJugador(posicionJ);
        
        
    }//GEN-LAST:event_tablaJugadoresMouseClicked

    private void botonQuitarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarJugadorActionPerformed
        if(seleccion3){
            listaJugadores.remove(posicion);
            pintarJugadores();
            seleccion3 = false;
        }
    }//GEN-LAST:event_botonQuitarJugadorActionPerformed

    private void botonAniadirPJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadirPJugadorActionPerformed
        if(seleccion3){
            ventanaAsignarPlaneta.setVisible(true);
            ventanaAsignarPlaneta.pintar(listaPlanetas);
            this.setEnabled(false);
        }
    }//GEN-LAST:event_botonAniadirPJugadorActionPerformed

    private void tablaPlanetasJugadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPlanetasJugadorMouseClicked
        posicionP = tablaPlanetasJugador.getSelectedRow();
        System.out.println("Seleccionado: "+tablaPlanetasJugador.getValueAt(posicion, 0));
        nick =(String) tablaPlanetasJugador.getValueAt(posicion, 0);
        seleccion4=true;
        System.out.println("No: "+posicionP);
        
    }//GEN-LAST:event_tablaPlanetasJugadorMouseClicked

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.setVisible(false);
        limpiar();
        ventanaJugar.setVisible(true);
    }//GEN-LAST:event_botonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAniadirJugador;
    private javax.swing.JButton botonAniadirP;
    private javax.swing.JButton botonAniadirPJugador;
    private javax.swing.JButton botonAniadirPN;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonQuitarJugador;
    private javax.swing.JButton botonQuitarP;
    private javax.swing.JButton botonQuitarPJugador;
    private javax.swing.JButton botonQuitarPN;
    private javax.swing.JCheckBox checkBoxAcumular;
    private javax.swing.JCheckBox checkBoxAlAzar;
    private javax.swing.JCheckBox checkBoxMapaCiego;
    private javax.swing.JCheckBox checkBoxMostrarEstadisticas;
    private javax.swing.JCheckBox checkBoxMostrarNaves;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelColumnas;
    private javax.swing.JLabel labelFilas;
    private javax.swing.JLabel labelFinalizacion;
    private javax.swing.JLabel labelFlecha;
    private javax.swing.JLabel labelJugadores;
    private javax.swing.JLabel labelNeutrales;
    private javax.swing.JLabel labelNoPlanetasN;
    private javax.swing.JLabel labelNombreMapa;
    private javax.swing.JLabel labelPlanetas;
    private javax.swing.JLabel labelProduccion;
    private javax.swing.JLabel labelTituloPJugador;
    private javax.swing.JLabel labelTituloPN;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JSpinner spinnerColumnas;
    private javax.swing.JSpinner spinnerFila;
    private javax.swing.JSpinner spinnerFinalizacion;
    private javax.swing.JSpinner spinnerNoPlanetasN;
    private javax.swing.JSpinner spinnerProduccion;
    private javax.swing.JTable tablaJugadores;
    private javax.swing.JTable tablaNeutrales;
    private javax.swing.JTable tablaPlanetas;
    private javax.swing.JTable tablaPlanetasJugador;
    private javax.swing.JTextField textFieldNombreMapa;
    // End of variables declaration//GEN-END:variables
}
