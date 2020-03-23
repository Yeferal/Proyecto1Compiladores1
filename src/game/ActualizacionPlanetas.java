
package game;

import java.util.ArrayList;
import objetos.Juego;
import objetos.Planeta;

public class ActualizacionPlanetas {
    
    
    public Juego actualizarPlanetas(Juego juego){
        
        for (int i = 0; i < juego.getListaJugadores().size(); i++) {
            ArrayList<String> lista = juego.getListaJugadores().get(i).getListaPlanetas();
            for (int j = 0; j < lista.size(); j++) {
                ArrayList<Planeta> listaPla = juego.getListaPlanetas();
                for (int k = 0; k < listaPla.size(); k++) {
                    if(lista.get(j).equals(listaPla.get(k).getNombre())){
                        juego.getListaPlanetas().get(k).setJugador(i);
                        juego.getListaPlanetas().get(k).setTieneJugador(true);
                        break;
                    }
                }
            }
        }
        return juego;
    }
}
