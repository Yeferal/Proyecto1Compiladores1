
package analizador.guardar;

public class ManejadorMensaje {
    private boolean planeta, jugador,resultado,turno,completo;
    
    public ManejadorMensaje(){
        completo = true;
        planeta = false;
        jugador = false;
        resultado = false;
        turno = false;
    }
    
    public boolean isExiste(int tipo){
        
        switch(tipo){
            case 1:
                return isPlaneta();
            case 2:
                return isJugador();
            case 3:
                return isResultado();
            case 4:
                return isTurno();
            default:
                return true;
        }
    }

    public boolean isCompleto() {
        return completo;
    }
    
    public void resetear(){
        completo = true;
        planeta = false;
        jugador = false;
        resultado = false;
        turno = false;
    }
    
    public boolean isPlaneta(){
        if(!planeta){
            planeta = true;
            return false;
        }
        completo = false;
        return true;
    }
    
    public boolean isJugador(){
        if(!jugador){
            jugador = true;
            return false;
        }
        completo = false;
        return true;
    }
    public boolean isResultado(){
        if(!resultado){
            resultado = true;
            return false;
        }
        completo = false;
        return true;
    }
    public boolean isTurno(){
        if(!turno){
            jugador = true;
            return false;
        }
        completo = false;
        return true;
    }
}
