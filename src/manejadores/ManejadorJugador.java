
package manejadores;

import analizadores.AnalizadorLexicoJugador;
import analizadores.AnalizadorSintacticoJugador;
import java.io.StringReader;
import java.util.ArrayList;
import objetos.Jugador;

public class ManejadorJugador {
    AnalizadorLexicoJugador lexico;
    AnalizadorSintacticoJugador sintactico;
    
    public boolean isCorrecto(String nombre){
        lexico = new AnalizadorLexicoJugador(new StringReader(nombre));
        sintactico = new AnalizadorSintacticoJugador(lexico);
        try {
            sintactico.parse();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        if(sintactico.getCompleto()){
            return true;
        }
        return false;
    }
    
    public boolean isExistJugador(ArrayList<Jugador> jugadores, Jugador jugador){
        for (int i = 0; i < jugadores.size(); i++) {
            if(jugador.getNombre()==null || jugadores.get(i).getNombre().equals(jugador.getNombre())){
                return false;
            }
        }
        
        return true;
    }
}
