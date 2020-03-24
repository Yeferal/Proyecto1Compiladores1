
package objetos;

import java.util.ArrayList;

public class Jugador {
        
    private String nombre;
    private int tipo, turnos;
    private ArrayList<Planeta> planetas = new ArrayList<>();
    private ArrayList<String> listaPlanetas = new ArrayList<>();
    private ArrayList<Flota> listaFlota = new ArrayList<>();

    public Jugador(){
        nombre=null;
    }

    public ArrayList<Flota> getListaFlota() {
        return listaFlota;
    }
    public void actualizarFlota(){
        ArrayList<Flota> listaFlotaAux = new ArrayList<>();
        for (int i = 0; i < listaFlota.size(); i++) {
            if(!listaFlota.get(i).isAtacado()){
                listaFlotaAux.add(listaFlota.get(i));
            }
        }
        listaFlota = listaFlotaAux;
    }

    public void setListaFlota(ArrayList<Flota> listaFlota) {
        this.listaFlota = listaFlota;
    }
    public void agregarFlora(Flota flota){
        listaFlota.add(flota);
    }
    public void eliminarFlota(int posicion){
        listaFlota.remove(posicion);
        actualizarPosicionesFlota();
    }
    public void actualizarPosicionesFlota(){
        for (int i = 0; i < listaFlota.size(); i++) {
            listaFlota.get(i).setNumero(i+1);
        }
    }
    public void quitarFlota(int index){
        listaFlota.remove(index);
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

    public int getTurnos() {
        return turnos;
    }
    public void sumarTurno(){
        turnos++;
    }
    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }
    
    
    
    public void pintar(){
        System.out.print("Nombre: "+nombre+" tipo: "+tipo+"______________");
        for (int i = 0; i < listaPlanetas.size(); i++) {
            System.out.print((i+1)+" nombre: "+listaPlanetas.get(i)+"  ");
        }
        System.out.println("");
    }
}
