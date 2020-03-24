
package game;

import java.util.ArrayList;
import objetos.Juego;
import objetos.Jugador;
import objetos.Planeta;

public class VerificadorPlaneta {
    
    
    
    public boolean verificarSiTienePlanetas(Juego juego , int turno){
        //Jugador j = juego.getListaJugadores().get(turno);
        ArrayList<Planeta> lista = juego.getListaPlanetas();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getJugador()==turno){
                return true;
            }
        }
        return false;
    }
    
    public boolean verificarGanador(Juego juego){
        
        ArrayList<Planeta> lista = juego.getListaPlanetas();
        //ArrayList<Jugador> listaJ = juego.getListaJugadores();
        int ganador = lista.get(0).getJugador();
        for (int i = 0; i < lista.size(); i++) {
            
            if(ganador!= lista.get(i).getJugador()){
                System.out.println("Hay alguien mal");
                return false;
            }
        }
        return true;
    }
    public boolean verificarPlanetasNeutrales(Juego juego){
        ArrayList<Planeta> lista = juego.getListaPlanetasNeutrales();
        
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getTipo()==0){
                System.out.println("Hay un Neutral mal");
                return false;
            }
        }
        
        return true;
    }
    
    
    public Juego asignarProduccion(Juego juego){
        Juego j = juego;
        
            ArrayList<Planeta> listaPlaneta = juego.getListaPlanetas();
            ArrayList<Planeta> listaPlanetaNeutrales = juego.getListaPlanetasNeutrales();
            int sumar= 0;
            int masU = sumarUno(j);
            for (int i = 0; i < listaPlaneta.size(); i++) {
                sumar = listaPlaneta.get(i).getProduccion() + masU;
                sumar += listaPlaneta.get(i).getNaves();
                listaPlaneta.get(i).setNaves(sumar);
                
            }
            juego.setListaPlanetas(listaPlaneta);

            for (int i = 0; i < listaPlanetaNeutrales.size(); i++) {
                if(listaPlanetaNeutrales.get(i).isIsProduccion()){
                    sumar = listaPlanetaNeutrales.get(i).getProduccion() + masU;
                    sumar += listaPlanetaNeutrales.get(i).getNaves();
                    listaPlanetaNeutrales.get(i).setNaves(sumar);
                }else{
                    sumar = juego.getMapa().getProduccionNeutrales() + masU;
                    sumar += listaPlanetaNeutrales.get(i).getNaves();
                    listaPlanetaNeutrales.get(i).setNaves(sumar);
                    
                }
            }
            juego.setListaPlanetasNeutrales(listaPlanetaNeutrales);
        
        
        return j;
    }
    
    public int sumarUno(Juego j){
        if(j.getMapa().isAcumular()){
            return 1;
        }
        return 0;
        
    }
    
}
