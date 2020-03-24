
package game;

import java.util.ArrayList;
import objetos.Flota;
import objetos.Juego;
import objetos.Planeta;
import ventanas.VentanaJugar;

public class JugadorPC {
    int facil, dificil, cantidad;
    private ArrayList<Planeta> listaPlanetaJugador = new ArrayList<>();
    private ArrayList<Planeta> listaPlanetaNeu = new ArrayList<>();
    private ArrayList<Planeta> listaPlanetaContraJugador = new ArrayList<>();
    private VentanaJugar ventanaJugar;
    
    public JugadorPC(VentanaJugar ventanaJugar){
        this.ventanaJugar = ventanaJugar;
    }
    
    public void iaFacil(Juego juego,int turno){
        limpiar();
        setListaPlanetas(juego, turno);
        int planetaAleatorio = (int) (Math.random()*listaPlanetaJugador.size());
        Planeta aux1 = listaPlanetaJugador.get(planetaAleatorio);
        //planetaAleatorio = (int) (Math.random()*listaPlanetaJugador.size());
        //Planeta aux2 = listaPlanetaContraJugador.get(planetaAleatorio);
        int planetaAleatorio100 = (int) (Math.random()*100);
        
        Planeta aux2 = null;
        if(planetaAleatorio100<50){
             planetaAleatorio = (int) (Math.random()*listaPlanetaContraJugador.size());
            aux2 = mejorPlaneta();
        }else{
             planetaAleatorio = (int) (Math.random()*listaPlanetaNeu.size());
            aux2 = planetaElegidoNeutral();
        }
        
        ventanaJugar.planeta1 = aux1;
        ventanaJugar.planeta1 = aux2;
        
        Flota flota = new Flota(aux1.getPosicion(), aux2.getPosicion(), aux1.getNombre(), aux2.getNombre(), aux1.getPorcentajeMuertes(),aux2.getTipo());
        flota.setTurno(ventanaJugar.medicion.medirDistancia(aux1, aux2));
        flota.setPorcetajeMuertes(aux1.getPorcentajeMuertes());
        facil = aux1.getNaves()-aux1.getNavesEnviadas();
        cantidad = (int) (Math.random()*facil);
        /*while (cantidad!=0 || cantidad<facil) {            
            cantidad = (int) (Math.random()*facil);
        }*/
        
        flota.setNavesEnviadas(cantidad);
        flota.setTurnosFaltantes(flota.getTurno());
        flota.setTurnosLlegar(flota.getTurno()+ventanaJugar.numeroTurno);
        ventanaJugar.agregarFlota(flota);
        
    }
    
    public void iaDificil(Juego juego,int turno){
        limpiar();
        setListaPlanetas(juego, turno);
        int planetaAleatorio = (int) (Math.random()*100);
        Planeta aux1 = planetaElegido();
        Planeta aux2 = null;
        if(planetaAleatorio<50){
            aux2 = mejorPlaneta();
        }else{
            aux2 = planetaElegidoNeutral();
        }

        ventanaJugar.planeta1 = aux1;
        ventanaJugar.planeta1 = aux2;
        
        Flota flota = new Flota(aux1.getPosicion(), aux2.getPosicion(), aux1.getNombre(), aux2.getNombre(), aux1.getPorcentajeMuertes(),aux2.getTipo());
        flota.setTurno(ventanaJugar.medicion.medirDistancia(aux1, aux2));
        flota.setPorcetajeMuertes(aux1.getPorcentajeMuertes());
        //ventanaJugar.atacar(aux1, aux2);
        //ventanaJugar.sumarTurno();
        facil = aux1.getNaves()-aux1.getNavesEnviadas();
        cantidad = (int) (Math.random()*facil);
        /*while (cantidad!=0 || cantidad<facil) {            
            cantidad = (int) (Math.random()*facil);
        }*/
        
        flota.setNavesEnviadas(cantidad);
        flota.setTurnosFaltantes(flota.getTurno());
        flota.setTurnosLlegar(flota.getTurno()+ventanaJugar.numeroTurno);
        ventanaJugar.agregarFlota(flota);
        
    }
    
    public void setListaPlanetas(Juego juego,int turno){
        
        for (int i = 0; i < juego.getListaPlanetas().size(); i++) {
            if(juego.getListaPlanetas().get(i).getJugador()==turno){
                listaPlanetaJugador.add(juego.getListaPlanetas().get(i));
            }else{
                listaPlanetaContraJugador.add(juego.getListaPlanetas().get(i));
            }
        }
        
        for (int i = 0; i < juego.getListaPlanetasNeutrales().size(); i++) {
            if(juego.getListaPlanetasNeutrales().get(i).getTipo()==0){
                listaPlanetaNeu.add(juego.getListaPlanetasNeutrales().get(i));
            }
        }
        
    }
    public void limpiar(){
        listaPlanetaContraJugador.clear();
        listaPlanetaJugador.clear();
        listaPlanetaNeu.clear();
    }
    
    public Planeta mejorPlaneta(){
        Planeta p = null;
        int mejor =0;
        for (int i = 0; i < listaPlanetaContraJugador.size(); i++) {
            int actuales = listaPlanetaContraJugador.get(mejor).getNaves()-listaPlanetaContraJugador.get(mejor).getNavesEnviadas();
            int auxActual = listaPlanetaContraJugador.get(i).getNaves()-listaPlanetaContraJugador.get(i).getNavesEnviadas();
            if(actuales>auxActual){
                mejor=i;
            }
        }
        p=listaPlanetaContraJugador.get(mejor);
        return p;
    }
    public Planeta planetaElegido(){
        Planeta p = null;
        int mejor =0;
        for (int i = 0; i < listaPlanetaJugador.size(); i++) {
            int actuales = listaPlanetaJugador.get(mejor).getNaves()-listaPlanetaJugador.get(mejor).getNavesEnviadas();
            int auxActual = listaPlanetaJugador.get(i).getNaves()-listaPlanetaJugador.get(i).getNavesEnviadas();
            if(actuales>auxActual){
                mejor=i;
            }
        }
        p=listaPlanetaJugador.get(mejor);
        return p;
    }
    
    public Planeta planetaElegidoNeutral(){
        Planeta p = null;
        int elegido = (int) (Math.random()*listaPlanetaNeu.size());;
        
        p=listaPlanetaNeu.get(elegido);
        return p;
    }
    
}
