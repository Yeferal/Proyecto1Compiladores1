
package manejadores;

import analizadores.AnalizadorLexicoJugador;
import analizadores.AnalizadorSintacticoJugador;
import java.io.StringReader;
import java.util.ArrayList;
import objetos.Jugador;

public class ManejadorJugador {
    AnalizadorLexicoJugador lexico;
    AnalizadorSintacticoJugador sintactico;
    
    public boolean nombre,tipo, completo;
    
    public ManejadorJugador(){
        completo = true;
        nombre = false;
        tipo = false;
    }
    
    public boolean isCorrecto(String nombre){
        lexico = new AnalizadorLexicoJugador(new StringReader(nombre));
        sintactico = new AnalizadorSintacticoJugador(lexico);
        try {
            sintactico.parse();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("El error es tipo: "+sintactico.getCompleto());
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
    
    public void resetear(){
        completo = true;
        nombre = false;
        tipo = false;
    }
    public boolean isExiste(int tipo){
        
        switch(tipo){
            case 1:
                return isBNombre();
            case 2:
                return isBTipo();
            default:
                return true;
        }
    }
    
    public boolean isBNombre(){
        if(!nombre){
                
            nombre = true;
            return false;
        }
        
        completo = false;
        return true;
    }
    public boolean isBTipo(){
        if(!tipo){
            
            tipo = true;
            return false;
        }
        
        completo = false;
        return true;
    }

    public boolean isCompleto() {
        
        return completo;
    }
    
    
}
