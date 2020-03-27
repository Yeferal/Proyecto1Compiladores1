
package objetos;

public class Repeticion {
    
    private int posicionDestion, posicionOrigen, tipoPlanetaDestino, turnoJugador, turnoNumero;
    private boolean resultado;

    public Repeticion(int posicionDestion, int posicionOrigen, int tipoPlanetaDestino, int turnoJugador, int turnoNumero, boolean resultado) {
        this.posicionDestion = posicionDestion;
        this.posicionOrigen = posicionOrigen;
        this.tipoPlanetaDestino = tipoPlanetaDestino;
        this.turnoJugador = turnoJugador;
        this.turnoNumero = turnoNumero;
        this.resultado = resultado;
    }
    
    public Repeticion(){
        
    }
    
    public int getPosicionDestion() {
        return posicionDestion;
    }

    public void setPosicionDestion(int posicionDestion) {
        this.posicionDestion = posicionDestion;
    }

    public int getPosicionOrigen() {
        return posicionOrigen;
    }

    public void setPosicionOrigen(int posicionOrigen) {
        this.posicionOrigen = posicionOrigen;
    }

    public int getTipoPlanetaDestino() {
        return tipoPlanetaDestino;
    }

    public void setTipoPlanetaDestino(int tipoPlanetaDestino) {
        this.tipoPlanetaDestino = tipoPlanetaDestino;
    }

    public int getTurnoJugador() {
        return turnoJugador;
    }

    public void setTurnoJugador(int turnoJugador) {
        this.turnoJugador = turnoJugador;
    }

    public int getTurnoNumero() {
        return turnoNumero;
    }

    public void setTurnoNumero(int turnoNumero) {
        this.turnoNumero = turnoNumero;
    }

    public boolean isResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }
    
    
    
    
}
