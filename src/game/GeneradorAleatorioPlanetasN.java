
package game;

import java.util.ArrayList;
import objetos.Planeta;

public class GeneradorAleatorioPlanetasN {
    
    
    public ArrayList<Planeta> generarNeutralesAleatorios(int cantidad, boolean mostrarNaves, boolean mostrarEstadistica, int produccion){
        ArrayList<Planeta> listaAleatorios = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            Planeta p = new Planeta();
            p.setNombre("N"+i);
            p.setNaves(getAleatorioNaves());
            p.setPorcentajeMuertes(getAleatorioPorcentaje());
            p.setProduccion(produccion);
            p.setTipo(0);
            listaAleatorios.add(p);
        }
        
        return listaAleatorios;
    }
    
    public int getAleatorioNaves(){
        int a = (int) (Math.random()*25);
        return a;
    }
    
    public double getAleatorioPorcentaje(){
        double a = (double) (Math.random());
        a = Math.round(a * 100) / 100d;
        return a;
    }
}
