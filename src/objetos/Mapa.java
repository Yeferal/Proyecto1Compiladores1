
package objetos;

public class Mapa {
    
    private String id;
    private int tamanioX, tamanioY, planetasNeutrales, produccionNeutrales, finalizacion;
    private boolean alAzar, mapaCiego, acumular, mostrarNavesNeutrales, mostrarEstadisticasNeutrales;

    public Mapa(){
        alAzar = false;
        mapaCiego = false;
        acumular = false;
        mostrarNavesNeutrales = false;
        mostrarEstadisticasNeutrales = false;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTamanioX() {
        return tamanioX;
    }

    public void setTamanioX(int tamanioX) {
        this.tamanioX = tamanioX;
    }

    public int getTamanioY() {
        return tamanioY;
    }

    public void setTamanioY(int tamanioY) {
        this.tamanioY = tamanioY;
    }

    public int getPlanetasNeutrales() {
        return planetasNeutrales;
    }

    public void setPlanetasNeutrales(int planetasNeutrales) {
        this.planetasNeutrales = planetasNeutrales;
    }

    public int getProduccionNeutrales() {
        return produccionNeutrales;
    }

    public void setProduccionNeutrales(int produccionNeutrales) {
        this.produccionNeutrales = produccionNeutrales;
    }

    public int getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(int finalizacion) {
        this.finalizacion = finalizacion;
    }

    public boolean isAlAzar() {
        return alAzar;
    }

    public void setAlAzar(boolean alAzar) {
        this.alAzar = alAzar;
    }

    public boolean isMapaCiego() {
        return mapaCiego;
    }

    public void setMapaCiego(boolean mapaCiego) {
        this.mapaCiego = mapaCiego;
    }

    public boolean isAcumular() {
        return acumular;
    }

    public void setAcumular(boolean acumular) {
        this.acumular = acumular;
    }

    public boolean isMostrarNavesNeutrales() {
        return mostrarNavesNeutrales;
    }

    public void setMostrarNavesNeutrales(boolean mostrarNavesNeutrales) {
        this.mostrarNavesNeutrales = mostrarNavesNeutrales;
    }

    public boolean isMostrarEstadisticasNeutrales() {
        return mostrarEstadisticasNeutrales;
    }

    public void setMostrarEstadisticasNeutrales(boolean mostrarEstadisticasNeutrales) {
        this.mostrarEstadisticasNeutrales = mostrarEstadisticasNeutrales;
    }
    
    public void pintar(){
        System.out.println("____________________________________________________________________________________________");
        System.out.println(getId());
        System.out.println(getTamanioX());
        System.out.println(getTamanioY());
        System.out.println(getProduccionNeutrales());
        System.out.println(getFinalizacion());
        System.out.println(isAcumular());
        System.out.println(isAlAzar());
        System.out.println(isMapaCiego());
        System.out.println("____________________________________________________________________________________________");
    }
    
    
}
