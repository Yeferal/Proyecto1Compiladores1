
package objetos;

public class Flota {
    private int numero,turno,turnosLlegar, turnosFaltantes,navesEnviadas,origen, destino,tipoPlaneta;
    private String origenS, destinoS;
    private double porcetajeMuertes;
    private boolean atacado;

    public Flota(int origen, int destino, String origenS, String destinoS, double porcetajeMuertes,int tipoPlaneta) {
        this.origen = origen;
        this.destino = destino;
        this.origenS = origenS;
        this.destinoS = destinoS;
        this.porcetajeMuertes = porcetajeMuertes;
        this.tipoPlaneta = tipoPlaneta;
        atacado=false;
    }
    public Flota(){
        
    }

    public boolean isAtacado() {
        return atacado;
    }

    public void setAtacado(boolean atacado) {
        this.atacado = atacado;
    }
    

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTurnosLlegar() {
        return turnosLlegar;
    }

    public void setTurnosLlegar(int turnosLlegar) {
        this.turnosLlegar = turnosLlegar;
    }

    public int getTurnosFaltantes() {
        return turnosFaltantes;
    }

    public void setTurnosFaltantes(int turnosFaltantes) {
        this.turnosFaltantes = turnosFaltantes;
    }

    public int getNavesEnviadas() {
        return navesEnviadas;
    }

    public void setNavesEnviadas(int navesEnviadas) {
        this.navesEnviadas = navesEnviadas;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public String getOrigenS() {
        return origenS;
    }

    public void setOrigenS(String origenS) {
        this.origenS = origenS;
    }

    public String getDestinoS() {
        return destinoS;
    }

    public void setDestinoS(String destinoS) {
        this.destinoS = destinoS;
    }

    public double getPorcetajeMuertes() {
        return porcetajeMuertes;
    }

    public void setPorcetajeMuertes(double porcetajeMuertes) {
        this.porcetajeMuertes = porcetajeMuertes;
    }

    public int getTipoPlaneta() {
        return tipoPlaneta;
    }

    public void setTipoPlaneta(int tipoPlaneta) {
        this.tipoPlaneta = tipoPlaneta;
    }
    
    
}
