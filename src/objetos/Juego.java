
package objetos;

import java.util.ArrayList;
import manejadores.ManejadorMapa;

public class Juego {
    
    Mapa mapa;
    ManejadorMapa manejadorMapa;
    ArrayList<Planeta> listaPlanetas;
    ArrayList<Planeta> listaPlanetasNeutrales;
    ArrayList<Jugador> listaJugadores;

    public Juego(Mapa mapa, ManejadorMapa manejadorMapa, ArrayList<Planeta> listaPlanetas, ArrayList<Planeta> listaPlanetasNeutrales, ArrayList<Jugador> listaJugadores) {
        this.mapa = mapa;
        this.manejadorMapa = manejadorMapa;
        this.listaPlanetas = listaPlanetas;
        this.listaPlanetasNeutrales = listaPlanetasNeutrales;
        this.listaJugadores = listaJugadores;
    }
    
    public void agregarPlaneta(Planeta p){
        listaPlanetas.add(p);
    }
    
    public void agregarPlanetaNeutrales(Planeta p){
        listaPlanetasNeutrales.add(p);
    }
    
    public void agregarJugador(Jugador j){
        listaJugadores.add(j);
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public ManejadorMapa getManejadorMapa() {
        return manejadorMapa;
    }

    public void setManejadorMapa(ManejadorMapa manejadorMapa) {
        this.manejadorMapa = manejadorMapa;
    }

    public ArrayList<Planeta> getListaPlanetas() {
        return listaPlanetas;
    }

    public void setListaPlanetas(ArrayList<Planeta> listaPlanetas) {
        this.listaPlanetas = listaPlanetas;
    }

    public ArrayList<Planeta> getListaPlanetasNeutrales() {
        return listaPlanetasNeutrales;
    }

    public void setListaPlanetasNeutrales(ArrayList<Planeta> listaPlanetasNeutrales) {
        this.listaPlanetasNeutrales = listaPlanetasNeutrales;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }
    
    
}
