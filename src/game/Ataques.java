
package game;

import java.util.ArrayList;
import objetos.Flota;
import objetos.Juego;
import objetos.Mensaje;
import objetos.Planeta;
import ventanas.VentanaJugar;

public class Ataques {
//    private ArrayList<Jugador>
    private VentanaJugar ventanaJugar;
    
    public Ataques(VentanaJugar ventanaJugar){
        this.ventanaJugar = ventanaJugar;
    }
    
    public Juego verificarAtaques(Juego juego,int turno,int numeroTurno){
        Mensaje m = null;
        for (int i = 0; i < juego.getListaJugadores().get(turno).getListaFlota().size(); i++) {
            
            if(!juego.getListaJugadores().get(turno).getListaFlota().get(i).isAtacado()){
                //verificar ataque
                if(juego.getListaJugadores().get(turno).getListaFlota().get(i).getTurnosLlegar()==numeroTurno){
                 //realizar ataque
                    m = realizarAtaque(juego, turno, numeroTurno, juego.getListaJugadores().get(turno).getListaFlota().get(i));
                    ventanaJugar.agregarMensaje(m);
                    juego.getListaJugadores().get(turno).getListaFlota().get(i).setAtacado(true);
                }
            }
        }
        juego.getListaJugadores().get(turno).actualizarFlota();
        return juego;
    }
    
    public Mensaje realizarAtaque(Juego juego,int turno,int numeroTurno,Flota flota){
        Mensaje m = null;
        if (flota.getTipoPlaneta()==1) {
            
            if(batallar(flota, juego.getListaPlanetas().get(flota.getDestino()))){
                m = new Mensaje(juego.getListaPlanetas().get(flota.getDestino()).getNombre(), juego.getListaJugadores().get(turno).getNombre(),true, turno);
                cambiarPlaneta(juego, flota.getDestino(),turno, 1);
                ventanaJugar.actualizarBoton(juego.getListaPlanetas().get(flota.getDestino()).getCoordenadaX(), juego.getListaPlanetas().get(flota.getDestino()).getCoordenadaY(), juego.getListaPlanetas().get(flota.getDestino()));
            }else{
                m = new Mensaje(juego.getListaPlanetas().get(flota.getDestino()).getNombre(), juego.getListaJugadores().get(turno).getNombre(),false, turno);
            }
            
        }else{
            
            if(batallar(flota, juego.getListaPlanetasNeutrales().get(flota.getDestino()))){
                m = new Mensaje(juego.getListaPlanetasNeutrales().get(flota.getDestino()).getNombre(), juego.getListaJugadores().get(turno).getNombre(),true, turno);
                cambiarPlaneta(juego, flota.getDestino(),turno, 0);
                ventanaJugar.actualizarBoton(juego.getListaPlanetasNeutrales().get(flota.getDestino()).getCoordenadaX(), juego.getListaPlanetasNeutrales().get(flota.getDestino()).getCoordenadaY(), juego.getListaPlanetas().get(juego.getListaPlanetas().size()-1));
            }else{
                m = new Mensaje(juego.getListaPlanetasNeutrales().get(flota.getDestino()).getNombre(), juego.getListaJugadores().get(turno).getNombre(),false, turno);
            }
            
        }
        regresarNaves(juego, flota.getOrigen(), flota.getNavesEnviadas());
        return m;
    }
    
    public boolean batallar(Flota flota, Planeta p2){
        double cantidadAtaqueP1;
        double cantidadAtaqueP2;
        cantidadAtaqueP1 = flota.getPorcetajeMuertes()*flota.getNavesEnviadas();
        cantidadAtaqueP2 = (p2.getNaves()-p2.getNavesEnviadas())*p2.getPorcentajeMuertes();
        //int aleatorio = (int) (Math.random()*());
        if(cantidadAtaqueP1>cantidadAtaqueP2){
            return true;
        }
        return false;
    }
    
    public void regresarNaves(Juego juego,int numeroPlaneta,int numeroNaves){
        int navesEn = juego.getListaPlanetas().get(numeroPlaneta).getNavesEnviadas();
        navesEn = navesEn-numeroNaves;
        juego.getListaPlanetas().get(numeroPlaneta).setNavesEnviadas(navesEn);
    }
    public void cambiarPlaneta(Juego juego,int numeroPlaneta, int jugador, int tipo){
        if(tipo==1){
            juego.getListaPlanetas().get(numeroPlaneta).setJugador(jugador);
        }else{
            juego.getListaPlanetasNeutrales().get(numeroPlaneta).setJugador(jugador);
            juego.getListaPlanetasNeutrales().get(numeroPlaneta).setTipo(1);
            Planeta pl = juego.getListaPlanetasNeutrales().get(numeroPlaneta);
            pl.setPosicion(juego.getListaPlanetas().size());
            juego.getListaPlanetas().add(pl);
            //juego.getListaPlanetasNeutrales().get(numeroPlaneta).setTipo(1);
        }
    }
    
    
    
}
