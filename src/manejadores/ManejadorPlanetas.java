
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
        if(p.getProduccion()!=0){
            return true;
        }
        return false;
    }
    
}
