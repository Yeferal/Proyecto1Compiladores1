
package manejadores;

public class ManejadorMapa {
    
    private boolean bId, bTamanio, bAlAzar, bPlanet, bMapaC, bAcumular, bNutrales, bFinalizacion;
    private boolean completo;
    
    public ManejadorMapa(){
        completo = true;
        bId = false;
        bTamanio = false;
        bAlAzar = false;
        bPlanet = false;
        bMapaC = false;
        bAcumular = false;
        bNutrales = false;
        bFinalizacion = false;
    }
    
    
    public boolean isExiste(int tipo){
        
        switch(tipo){
            case 1:
                return isBId();
            case 2:
                return isBTamanio();
            case 3:
                return isBAlazar();
            case 4:
                return isBPlanet();
            case 5:
                return isBMapaC();
            case 6:
                return isBAcumular();
            case 7:
                return isBNeutrales();
            case 8:
                return isBFinalizacion();
            default:
                return true;
        }
    }
    
    public boolean isBId(){
        if(!bId){
            bId = true;
            return false;
        }
        completo = false;
        return true;
    }
    
    public boolean isBTamanio(){
        if(!bTamanio){
            bTamanio = true;
            return false;
        }
        completo = false;
        return true;
    }
    
    public boolean isBAlazar(){
        if(!bAlAzar){
            bAlAzar = true;
            return false;
        }
        //
        completo = false;
        return true;
    }
    
    public boolean isBPlanet(){
        if(!bPlanet){
            bPlanet = true;
            return false;
        }
        completo = false;
        return true;
    }
    public boolean isBMapaC(){
        if(!bMapaC){
            bMapaC = true;
            return false;
        }
        //
        completo = false;
        return true;
    }
    public boolean isBAcumular(){
        if(!bAcumular){
            bAcumular = true;
            return false;
        }
        //
        completo = false;
        return true;
    }
    
    public boolean isBNeutrales(){
        if(!bNutrales){
            bNutrales = true;
            return false;
        }
        completo = false;
        return true;
    }
    
    public boolean isBFinalizacion(){
        if(!bFinalizacion){
            bFinalizacion = true;
            return false;
        }
        //
        completo = false;
        return true;
    }

    public boolean isbId() {
        return bId;
    }

    public boolean isbTamanio() {
        return bTamanio;
    }

    public boolean isbAlAzar() {
        return bAlAzar;
    }

    public boolean isbPlanet() {
        return bPlanet;
    }

    public boolean isbMapaC() {
        return bMapaC;
    }

    public boolean isbAcumular() {
        return bAcumular;
    }

    public boolean isbNutrales() {
        return bNutrales;
    }

    public boolean isbFinalizacion() {
        return bFinalizacion;
    }

    public boolean isCompleto() {
        return completo;
    }
    
    
}
