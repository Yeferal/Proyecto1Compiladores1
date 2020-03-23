
package game;

import objetos.Planeta;

public class Medicion {
    
    
    public int medirDistancia(Planeta planeta1, Planeta planeta2){
        int total = 0;
        int distanciaX;
        int distanciaY;
        distanciaX = planeta1.getCoordenadaX()-planeta2.getCoordenadaX();
        distanciaY = planeta1.getCoordenadaY()-planeta2.getCoordenadaY();
        distanciaX = verificarPositivo(distanciaX);
        distanciaY = verificarPositivo(distanciaY);
        total = distanciaX+distanciaY;
        return total;
    }
    
    private int verificarPositivo(int num){
        if(num<0){
            num = num*(-1);
        }
        return num;
    }
}
