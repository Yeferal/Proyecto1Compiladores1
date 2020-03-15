
package objetos;

import java.util.ArrayList;

public class Jugador {
        
    private String nombre;
    private int tipo;
    private ArrayList<Planeta> planetas = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Planeta> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(ArrayList<Planeta> planetas) {
        this.planetas = planetas;
    }
    
    public void agregarPlaneta(Planeta planeta){
        planetas.add(planeta);
    }
    public Planeta getPlaneta(int i){
        return planetas.get(i);
    }
    
}
