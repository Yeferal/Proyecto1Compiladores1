
package analizador.guardar;

public class ManejadorJuego {
    private boolean mapa, planetas,planetasNeutrales,jugadores, flota, mensaje;
    private boolean completo;
    
    public ManejadorJuego(){
        completo = true;
        mapa = false;
        planetas = false;
        planetasNeutrales = false;
        jugadores = false;
        flota = false;
        mensaje = false;
    }
    
    public boolean isExiste(int tipo){
        
        switch(tipo){
            case 1:
                return isBMapa();
            case 2:
                return isBPlaneta();
            case 3:
                return isBPlanetasNeutrales();
            case 4:
                return isBJugadores();
            case 5:
                return isBFlota();
            case 6:
                return isBMensaje();
            default:
                return true;
        }
    }
    
    public boolean isBMapa(){
        if(!mapa){
            mapa = true;
            return false;
        }
        completo = false;
        return true;
    }
    public boolean isBPlaneta(){
        if(!planetas){
            planetas = true;
            return false;
        }
        completo = false;
        return true;
    }
    public boolean isBPlanetasNeutrales(){
        if(!planetasNeutrales){
            planetasNeutrales = true;
            return false;
        }
        completo = false;
        return true;
    }
    public boolean isBJugadores(){
        if(!jugadores){
            jugadores = true;
            return false;
        }
        completo = false;
        return true;
    }
    public boolean isBFlota(){
        if(!flota){
            flota = true;
            return false;
        }
        completo = false;
        return true;
    }
    public boolean isBMensaje(){
        if(!mensaje){
            mensaje = true;
            return false;
        }
        completo = false;
        return true;
    }

    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }
    
    
}
