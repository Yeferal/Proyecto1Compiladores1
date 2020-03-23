
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import objetos.Planeta;
import ventanas.VentanaJugar;

public class Accion implements ActionListener{
    VentanaJugar ventanaJugar;
    Planeta planeta;
    
    public Accion(VentanaJugar ventanaJugar,Planeta planeta){
        this.ventanaJugar = ventanaJugar;
        this.planeta =  planeta;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(ventanaJugar.opcion==0){
            planeta.pintar();
            ventanaJugar.planeta1= planeta;
            ventanaJugar.setPlanetaSeleccionado(planeta);
            ventanaJugar.opcion++;
            
        }else{
            planeta.pintar();
            ventanaJugar.planeta2= planeta;
            ventanaJugar.setPlanetaSeleccionado(planeta);
            ventanaJugar.opcion=0;
        }
        System.out.println("Coordenadas del Planeta: "+planeta.getCoordenadaX()+", "+planeta.getCoordenadaY());
        System.out.println("Posicion: "+planeta.getJugador());
        
    }
    
}
