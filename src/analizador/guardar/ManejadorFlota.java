
package analizador.guardar;

public class ManejadorFlota {
    
    private boolean origen,destino,porcentaje,tipoPlaneta, naves, turnoDistancia,turnoLlegada;
    private boolean completo;
    
    public ManejadorFlota(){
        completo = true;
        origen = false;
        destino = false;
        porcentaje = false;
        tipoPlaneta = false;
        naves = false;
        turnoDistancia = false;
        turnoLlegada = false;
    }

    public void resetear(){
        completo = true;
        origen = false;
        destino = false;
        porcentaje = false;
        tipoPlaneta = false;
        naves = false;
        turnoDistancia = false;
        turnoLlegada = false;
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
                return isOrigen();
            case 2:
                return isDestino();
            case 3:
                return isPorcentaje();
            case 4:
                return isTipoPlaneta();
            case 5:
                return isNaves();
            case 6:
                return isTurnoDistancia();
            case 7:
                return isTurnoLlegada();
            default:
                return true;
        }
    }
    
    public boolean isOrigen(){
        if(!origen){
            origen = true;
            return false;
        }
        completo = false;
        return true;
    }
    
    public boolean isDestino(){
        if(!destino){
            destino = true;
            return false;
        }
        completo = false;
        return true;
    }
    public boolean isPorcentaje(){
        if(!porcentaje){
            porcentaje = true;
            return false;
        }
        completo = false;
        return true;
    }
    public boolean isTipoPlaneta(){
        if(!tipoPlaneta){
            tipoPlaneta = true;
            return false;
        }
        completo = false;
        return true;
    }
    
    public boolean isNaves(){
        if(!naves){
            naves = true;
            return false;
        }
        completo = false;
        return true;
    }
    
    public boolean isTurnoDistancia(){
        if(!turnoDistancia){
            turnoDistancia = true;
            return false;
        }
        completo = false;
        return true;
    }
    
    public boolean isTurnoLlegada(){
        if(!turnoLlegada){
            turnoLlegada = true;
            return false;
        }
        completo = false;
        return true;
    }
    
}
