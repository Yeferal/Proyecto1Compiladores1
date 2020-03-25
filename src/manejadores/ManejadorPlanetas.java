
package manejadores;

import analizadores.AnalizadorLexicoNick;
import analizadores.AnalizadorSintacticoNick;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Planeta;

public class ManejadorPlanetas {
    AnalizadorLexicoNick lexico;
    AnalizadorSintacticoNick sintactico;
    
    private boolean nombre, naves, produccion, porcentaje, coordenadaX, coordenadaY, navesEnviadas, jugador;
    private boolean completo;
    
    public ManejadorPlanetas(){
        completo = true;
        nombre = false;
        naves = false;
        porcentaje = false;
        produccion = false;
        coordenadaX = false;
        coordenadaY = false;
        navesEnviadas = false;
        jugador = false;
    }
    
    public boolean isCorrecto(String nombre){
        lexico = new AnalizadorLexicoNick(new StringReader(nombre));
        sintactico = new AnalizadorSintacticoNick(lexico);
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
    
    public boolean isExistPlaneta(ArrayList<Planeta> planetas, Planeta p){
        for (int i = 0; i < planetas.size(); i++) {
            if(p.getNombre()==null || planetas.get(i).getNombre().equals(p.getNombre())){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isProduccion(Planeta p){
        if(p.isIsProduccion()){
            return true;
        }
        return false;
    }
    public void resetear(){
        completo = true;
        nombre = false;
        naves = false;
        produccion = false;
        porcentaje = false;
        coordenadaX = false;
        coordenadaY = false;
        navesEnviadas = false;
        jugador = false;
        System.out.println("Reseteado");
    }

    public boolean isCompleto() {
        System.out.println("CompletoPlanetas: "+completo);
        return completo;
    }
    
    
    public boolean isExiste(int tipo){
        
        switch(tipo){
            case 1:
                return isBNombre();
            case 2:
                return isBNaves();
            case 3:
                return isBProduccion();
            case 4:
                return isBPorcentaje();
            case 5:
                return isBCoodenadaX();
            case 6:
                return isBCoodenadaY();
            case 7:
                return isBNavesEnviadas();
            case 8:
                return isBJugador();
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
    
    public boolean isBNaves(){
        if(!naves){
            
            naves = true;
            return false;
        }
        
        completo = false;
        return true;
    }
    
    public boolean isBProduccion(){
        if(!produccion){
            System.out.println("Produccion: false");
            produccion = true;
            return false;
        }
        System.out.println("Produccion: true");
        completo = false;
        return true;
    }
    
    public boolean isBPorcentaje(){
        if(!porcentaje){
            System.out.println("Porcentaje: false");
            porcentaje = true;
            return false;
        }
        System.out.println("Porcentaje: true");
        completo = false;
        return true;
    }
    public boolean isBCoodenadaX(){
        if(!coordenadaX){
            System.out.println("Coor x: false");
            coordenadaX = true;
            return false;
        }
        System.out.println("Coor x: true");
        completo = false;
        return true;
    }
    public boolean isBCoodenadaY(){
        if(!coordenadaY){
            System.out.println("Coor y: false");
            coordenadaY = true;
            return false;
        }
        System.out.println("Coor y: true");
        completo = false;
        return true;
    }
    
    public boolean isBNavesEnviadas(){
        if(!navesEnviadas){
            navesEnviadas = true;
            return false;
        }
        completo = false;
        return true;
    }
    
    public boolean isBJugador(){
        if(!jugador){
            jugador = true;
            return false;
        }
        //
        completo = false;
        return true;
    }
    
}
