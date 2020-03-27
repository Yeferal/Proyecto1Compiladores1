
package replay;

public class ManejadorReplay {
    
    private boolean posicionDestion, posicionOrigen, tipoPlanetaDestino, turnoJugador, turnoNumero;
    private boolean completo, resultado;
    
    public ManejadorReplay(){
        completo = true;
        posicionDestion = false;
        posicionOrigen = false;
        tipoPlanetaDestino = false;
        turnoJugador = false;
        turnoNumero = false;
        resultado = false;
    }

    public void resetear(){
        completo = true;
        posicionDestion = false;
        posicionOrigen = false;
        tipoPlanetaDestino = false;
        turnoJugador = false;
        turnoNumero = false;
        resultado = false;
    }
    
    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }
    
    public boolean isExiste(int tipo){
        
        switch(tipo){
            case 1:
                return isBPosicionOrigen();
            case 2:
                return isBPosicionDestion();
            case 3:
                return isBTipoPlanetaDestino();
            case 4:
                return isBTurnoNumero();
            case 5:
                return isBTurnoJugador();
            case 6:
                return isBResultado();
            default:
                return true;
        }
    }
    
    public boolean isBPosicionDestion(){
        if(!posicionDestion){
            posicionDestion = true;
            return false;
        }
        completo = false;
        return true;
    }
    
    public boolean isBPosicionOrigen(){
        if(!posicionOrigen){
            posicionOrigen = true;
            return false;
        }
        completo = false;
        return true;
    }
    public boolean isBTipoPlanetaDestino(){
        if(!tipoPlanetaDestino){
            tipoPlanetaDestino = true;
            return false;
        }
        completo = false;
        return true;
    }
    public boolean isBTurnoJugador(){
        if(!turnoJugador){
            turnoJugador = true;
            return false;
        }
        completo = false;
        return true;
    }
    
    public boolean isBTurnoNumero(){
        if(!turnoNumero){
            turnoNumero = true;
            return false;
        }
        completo = false;
        return true;
    }
    
    public boolean isBResultado(){
        if(!resultado){
            resultado = true;
            return false;
        }
        completo = false;
        return true;
    }
    
    
}
