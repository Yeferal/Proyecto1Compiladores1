
package game;

import java.awt.Font;
import javax.swing.JButton;
import objetos.Juego;

public class GeneradorIconos {
    
    Tablero tablero = new Tablero();
    
    public JButton [][] generarIconos(Juego juego, JButton [][] tableroBotones){
        int x;
        int y;
        //recirre los planetas neutrales
        for(int i =0; i<juego.getListaPlanetasNeutrales().size();i++){
            boolean vacio = true;
            do {
                x = (int) (Math.random()*juego.getMapa().getTamanioX());
                y = (int) (Math.random()*juego.getMapa().getTamanioY());
                
                if(tableroBotones[x][y].getIcon()==null){
                    
                    tableroBotones[x][y].setIcon(tablero.getIcono(tableroBotones[x][y].getWidth(),tableroBotones[x][y].getHeight()));
                    juego.getListaPlanetasNeutrales().get(i).setCoordenadas(x, y);
                    juego.getListaPlanetasNeutrales().get(i).setPosicion(i);
                    String texto = "<html><b>Nombre: </b>"+juego.getListaPlanetasNeutrales().get(i).getNombre()+"<br>";
                    if(juego.getMapa().isMostrarNavesNeutrales()){
                        texto += "<b>Naves: </b>"+juego.getListaPlanetasNeutrales().get(i).getNaves()+"<br>";
                    }
                    
                    if(juego.getMapa().isMostrarEstadisticasNeutrales()){
                        texto += "<b>Produccion: </b>"+juego.getListaPlanetasNeutrales().get(i).getProduccion()+"<br>";
                        texto += "<b>Porcentaje: </b>"+juego.getListaPlanetasNeutrales().get(i).getPorcentajeMuertes()+"<br>";
                    }
                    texto += "<html>";
                    tableroBotones[x][y].setToolTipText(texto);
                    vacio = false;
                }
            } while (vacio);
        }
        //recorre los planetas de jugador
        for(int i =0; i<juego.getListaPlanetas().size();i++){
            boolean vacio = true;
            do {
                x = (int) (Math.random()*juego.getMapa().getTamanioX());
                y = (int) (Math.random()*juego.getMapa().getTamanioY());
                
                if(tableroBotones[x][y].getIcon()==null){
                    
                    tableroBotones[x][y].setIcon(tablero.getIcono(tableroBotones[x][y].getWidth(),tableroBotones[x][y].getHeight()));
                    //tableroBotones[x][y].setBackground(new Color(i, i, i));
                    juego.getListaPlanetas().get(i).setCoordenadas(x, y);
                    juego.getListaPlanetas().get(i).setPosicion(i);
                    tableroBotones[x][y].setText("<html><b>N :</b>"+juego.getListaPlanetas().get(i).getNombre()+"<br>"+"<b>J: </b>"+juego.getListaJugadores().get(juego.getListaPlanetas().get(i).getJugador()).getNombre()+"<html>");
                    //tableroBotones[x][y].setFont(new Font("Dialog", 2, 5));
                    String texto = "<html><b>J: </b>"+juego.getListaJugadores().get(juego.getListaPlanetas().get(i).getJugador()).getNombre()+"<br><b>Nombre: </b>"+juego.getListaPlanetas().get(i).getNombre()+"<br>";
                    if(!juego.getMapa().isMapaCiego()){
                        
                        texto += "<b>Naves: </b>"+juego.getListaPlanetas().get(i).getNaves()+"<br>";
                        texto += "<b>Produccion: </b>"+juego.getListaPlanetas().get(i).getProduccion()+"<br>";
                        texto += "<b>Porcentaje: </b>"+juego.getListaPlanetas().get(i).getPorcentajeMuertes()+"<br>";
                        texto += "<html>";
                        tableroBotones[x][y].setToolTipText(texto);
                    }
                    
                    vacio = false;
                }
            } while (vacio);
        }
        return tableroBotones;
    }
    
    
    public JButton [][] generarIconosExistentes(Juego juego, JButton [][] tableroBotones){
        int x;
        int y;
        //recirre los planetas neutrales
        for(int i =0; i<juego.getListaPlanetasNeutrales().size();i++){
           
                    
                    x = juego.getListaPlanetasNeutrales().get(i).getCoordenadaX();
                    y = juego.getListaPlanetasNeutrales().get(i).getCoordenadaY();
                    
                    tableroBotones[x][y].setIcon(tablero.getIcono(tableroBotones[x][y].getWidth(),tableroBotones[x][y].getHeight()));
                    juego.getListaPlanetasNeutrales().get(i).setCoordenadas(x, y);
                    juego.getListaPlanetasNeutrales().get(i).setPosicion(i);
                    String texto = "<html><b>Nombre: </b>"+juego.getListaPlanetasNeutrales().get(i).getNombre()+"<br>";
                    if(juego.getMapa().isMostrarNavesNeutrales()){
                        texto += "<b>Naves: </b>"+juego.getListaPlanetasNeutrales().get(i).getNaves()+"<br>";
                    }
                    
                    if(juego.getMapa().isMostrarEstadisticasNeutrales()){
                        texto += "<b>Produccion: </b>"+juego.getListaPlanetasNeutrales().get(i).getProduccion()+"<br>";
                        texto += "<b>Porcentaje: </b>"+juego.getListaPlanetasNeutrales().get(i).getPorcentajeMuertes()+"<br>";
                    }
                    texto += "<html>";
                    tableroBotones[x][y].setToolTipText(texto);
        }
        //recorre los planetas de jugador
        for(int i =0; i<juego.getListaPlanetas().size();i++){
                    x = juego.getListaPlanetas().get(i).getCoordenadaX();
                    y = juego.getListaPlanetas().get(i).getCoordenadaY();
                    
                    tableroBotones[x][y].setIcon(tablero.getIcono(tableroBotones[x][y].getWidth(),tableroBotones[x][y].getHeight()));
                    //tableroBotones[x][y].setBackground(new Color(i, i, i));
                    juego.getListaPlanetas().get(i).setCoordenadas(x, y);
                    juego.getListaPlanetas().get(i).setPosicion(i);
                    tableroBotones[x][y].setText("<html><b>N :</b>"+juego.getListaPlanetas().get(i).getNombre()+"<br>"+"<b>J: </b>"+juego.getListaJugadores().get(juego.getListaPlanetas().get(i).getJugador()).getNombre()+"<html>");
                    //tableroBotones[x][y].setFont(new Font("Dialog", 2, 5));
                    String texto = "<html><b>J: </b>"+juego.getListaJugadores().get(juego.getListaPlanetas().get(i).getJugador()).getNombre()+"<br><b>Nombre: </b>"+juego.getListaPlanetas().get(i).getNombre()+"<br>";
                    if(!juego.getMapa().isMapaCiego()){
                        
                        texto += "<b>Naves: </b>"+juego.getListaPlanetas().get(i).getNaves()+"<br>";
                        texto += "<b>Produccion: </b>"+juego.getListaPlanetas().get(i).getProduccion()+"<br>";
                        texto += "<b>Porcentaje: </b>"+juego.getListaPlanetas().get(i).getPorcentajeMuertes()+"<br>";
                        texto += "<html>";
                        tableroBotones[x][y].setToolTipText(texto);
                    }
                    
        }
        return tableroBotones;
    }
}
