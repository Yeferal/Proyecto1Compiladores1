
package objetos;

public class Planeta {
    
    private String nombre;
    private int naves, produccion, jugador, coordenadaX, coordenadaY;
    private double porcentajeMuertes;
    private int tipo;

    public Planeta(){
        produccion = 0;
        nombre = null;
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNaves() {
        return naves;
    }

    public void setNaves(int naves) {
        this.naves = naves;
    }

    public int getProduccion() {
        return produccion;
    }

    public void setProduccion(int produccion) {
        this.produccion = produccion;
    }

    public double getPorcentajeMuertes() {
        return porcentajeMuertes;
    }

    public void setPorcentajeMuertes(double porcentajeMuertes) {
        this.porcentajeMuertes = porcentajeMuertes;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public int getCoordenadaX(){
        return coordenadaX;
    }
    
    public int getCoordenadaY(){
        return coordenadaY;
    }
    
    public void setCoordenadas(int x, int y){
        this.coordenadaX = x;
        this.coordenadaY = y;
    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }
    
    public void pintar(){
        System.out.println("Nombre: "+nombre+" Naves: "+naves+" Produccion: "+produccion);
    }
    
    
}
