
package game;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import objetos.Juego;
import objetos.Planeta;
import ventanas.VentanaJugar;

public class GeneradorAcciones {
    VentanaJugar ventanaJugar;
    
    public JButton [][] generarAciones(Juego juego, JButton [][] tableroBotones,VentanaJugar ventanaJugar){
        this.ventanaJugar = ventanaJugar;
        
        for (int i = 0; i < juego.getListaPlanetasNeutrales().size(); i++) {
            Accion acccion = new Accion(ventanaJugar,juego.getListaPlanetasNeutrales().get(i));
            tableroBotones[juego.getListaPlanetasNeutrales().get(i).getCoordenadaX()][juego.getListaPlanetasNeutrales().get(i).getCoordenadaY()].addActionListener(acccion);
            
        }
        
        for (int i = 0; i < juego.getListaPlanetas().size(); i++) {
            Accion acccion = new Accion(ventanaJugar,juego.getListaPlanetas().get(i));
            quitarAccionBoton(juego.getListaPlanetas().get(i).getCoordenadaX(), juego.getListaPlanetas().get(i).getCoordenadaY(), tableroBotones);
            tableroBotones[juego.getListaPlanetas().get(i).getCoordenadaX()][juego.getListaPlanetas().get(i).getCoordenadaY()].addActionListener(acccion);
            
        }
        
        
        
        return tableroBotones;
    }
    
    
    public void quitarAccionBoton(int x,int y,JButton [][] tableroBotones){
        for (ActionListener al : tableroBotones[x][y].getActionListeners()) {
            tableroBotones[x][y].removeActionListener(al);
        }
    }
}
