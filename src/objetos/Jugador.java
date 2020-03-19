
package objetos;

import java.util.ArrayList;

public class Jugador {
        
    private String nombre;
    private int tipo;
    private ArrayList<Planeta> planetas = new ArrayList<>();
    private ArrayList<String> listaPlanetas = new ArrayList<>();

    public Jugador(){
        nombre=null;
    }
    
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
    
    public void insertarPlaneta(String nombre){
        listaPlanetas.add(nombre);
    }

    public ArrayList<String> getListaPlanetas() {
        return listaPlanetas;
    }

    public void setListaPlanetas(ArrayList<String> listaPlanetas) {
        this.listaPlanetas = listaPlanetas;
    }
    
    
    
    public void pintar(){
        System.out.print("Nombre: "+nombre+" tipo: "+tipo+"______________");
        for (int i = 0; i < listaPlanetas.size(); i++) {
            System.out.print((i+1)+" nombre: "+listaPlanetas.get(i)+"  ");
        }
        System.out.println("");
    }
}
