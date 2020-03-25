/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

public class Mensaje {
    private String planeta,Jugador,resultadoS;
    private boolean resultado;
    private int turno;
    
    public Mensaje(String planeta, String Jugador,boolean resultado, int turno) {
        this.planeta = planeta;
        this.Jugador = Jugador;
        this.resultado = resultado;
        this.turno = turno;
        setResultadoS();
    }

    public Mensaje() {
    }
    

    public void setResultadoS(){
        if (resultado) {
            resultadoS = " ha Caido contra un ataque de ";
        }else{
            resultadoS = " se ha Defendido contra un ataque de ";
        }
    }
    
    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public String getJugador() {
        return Jugador;
    }

    public void setJugador(String Jugador) {
        this.Jugador = Jugador;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    public String toString(){
        return "El planeta "+planeta+resultadoS+Jugador;
    }

    public boolean isResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }
    
    
}
