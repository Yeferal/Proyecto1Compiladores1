
package archivos;

import java.util.ArrayList;
import javax.swing.JPanel;
import objetos.Flota;
import objetos.Jugador;
import objetos.Mapa;
import objetos.Mensaje;
import objetos.Planeta;

public class GeneradorPartidaGuardar {
    
    JPanel panel;
    String texto;
    public GeneradorPartidaGuardar(){
        
    }
    
    public void setTexto(String texto){
        this.texto = texto;
    }
    
    public String getTexto(){
        return texto;
    }
    
    public void generar(Mapa mapa,ArrayList<Planeta> listaPlanetas,ArrayList<Planeta> listaPlanetasNeutrales,ArrayList<Jugador> listaJugadores, ArrayList<Mensaje> listaMenssaje){
        generarTextoMapa(mapa);
        generarPlanetasNetrales(listaPlanetasNeutrales);
        generarPlanetas(listaPlanetas);
        generarJugadores(listaJugadores);
        generarFlotas(listaJugadores);
        generarMensajes(listaMenssaje);
    }
    
    public void generarTextoMapa(Mapa mapa){
        texto = "{\n" +
"    MAPA:{\n" +
"        id: \"";
        texto+=mapa.getId()+"\",\n";
        texto+="        tamaño: {\n" +
"            filas: ";
        texto+=mapa.getTamanioX()+",\n" +
"            columnas: ";
        texto+=mapa.getTamanioY()+"\n        },\n"+
"        mapaCiego: ";
        texto+=mapa.isMapaCiego()+",\n" +
"        acumular: ";
        texto+=mapa.isAcumular()+",\n" +
"        NEUTRALES: {\n" +
"            mostrarNaves: ";
        texto+=mapa.isMostrarNavesNeutrales()+",\n" +
"            mostrarEstadisticas: ";
        texto+=mapa.isMostrarEstadisticasNeutrales()+",\n" +
"            produccion: ";
        texto+=mapa.getProduccionNeutrales()+"\n        },\n" +
"        finalizacion: ";
        texto+=mapa.getFinalizacion()+",\n" +
"	turno: ";
        texto+=mapa.getTurno()+",\n" +
"	turnoNumero: ";
        texto+=mapa.getNumeroTurno()+"\n    },\n";
        
    }
    public void generarPlanetas(ArrayList<Planeta> listaPlanetas){
        texto+="PLANETAS: [\n" +
"        ";
        for (int i = 0; i < listaPlanetas.size(); i++) {
            texto+="{\n" +
"        nombre: \"";
            texto+=listaPlanetas.get(i).getNombre()+"\",\n" +
"        naves: ";
            texto+=listaPlanetas.get(i).getNaves()+",\n" +
"        produccion: ";
            texto+=listaPlanetas.get(i).getProduccion()+",\n" +
"        porcentajeMuertes: ";
            texto+=listaPlanetas.get(i).getPorcentajeMuertes()+",\n" +
"	 coordenadaX: ";
            texto+=listaPlanetas.get(i).getCoordenadaX()+ ",\n" +
"	 coordenadaY: ";
            texto+=listaPlanetas.get(i).getCoordenadaY()+",\n" +
"	 navesEnviadas: ";
            if(listaPlanetas.get(i).getNavesEnviadas()<0){
                int na = listaPlanetas.get(i).getNavesEnviadas()*(-1);
               texto+=na+",\n" +
"	jugadorPlaneta: "; 
            }else{
                texto+=listaPlanetas.get(i).getNavesEnviadas()+",\n" +
"	jugadorPlaneta: ";
            }
            
            
            texto+= listaPlanetas.get(i).getJugador()+"\n        }";
            
            
            if(i!=(listaPlanetas.size()-1)){
                texto+=",\n        ";
            }
            
        }
        texto+="\n    ],\n" +
"    ";
    }
    
    public void generarPlanetasNetrales(ArrayList<Planeta> listaPlanetasNeutrales){
        texto+="PLANETAS_NEUTRALES: [\n" +
"        ";
        for (int i = 0; i < listaPlanetasNeutrales.size(); i++) {
            texto+="{\n" +
"        nombre: \"";
            texto+=listaPlanetasNeutrales.get(i).getNombre()+"\",\n" +
"        naves: ";
            texto+=listaPlanetasNeutrales.get(i).getNaves()+",\n" +
"        produccion: ";
            texto+=listaPlanetasNeutrales.get(i).getProduccion()+",\n" +
"        porcentajeMuertes: ";
            texto+=listaPlanetasNeutrales.get(i).getPorcentajeMuertes()+",\n" +
"	 coordenadaX: ";
            texto+=listaPlanetasNeutrales.get(i).getCoordenadaX()+ ",\n" +
"	 coordenadaY: ";
            texto+=listaPlanetasNeutrales.get(i).getCoordenadaY()+",\n" +
"	 navesEnviadas: ";
            texto+=listaPlanetasNeutrales.get(i).getNavesEnviadas()+"\n        }";
            if(i!=(listaPlanetasNeutrales.size()-1)){
                texto+=",\n        ";
            }
            
        }
        texto+="    ],\n" +
"    ";
    }
    public void generarJugadores(ArrayList<Jugador> listaJugadores){
        texto+="JUGADORES: [\n" +
"        ";
        for (int i = 0; i < listaJugadores.size(); i++) {
             texto+="{\n" +
"        nombre: \"";
             texto+=listaJugadores.get(i).getNombre()+"\",\n" +
"        tipo: ";
             switch(listaJugadores.get(i).getTipo()){
                 case 0:
                     texto+="HUMANO"+"\n        }";
                     break;
                 case 1:
                     texto+="FACIL"+"\n        }";
                     break;
                 case 2:
                     texto+="DIFICIL"+"\n        }";
                     break;
             }
             
             
             if(i!=(listaJugadores.size()-1)){
                 texto+=",\n" +
"        ";
             }
        }
        
        texto+="\n    ]\n" +
"    \n" +
"}";
        
    }
    
    public void generarFlotas(ArrayList<Jugador> listaJugadores){
        texto += "{\n" +
"    FLOTAS:[\n";
        
            ArrayList<Flota> listaFlota = getListaF(listaJugadores);
            for (int j = 0; j < listaFlota.size(); j++) {
                texto+="        {\n" +
"        origen: "+listaFlota.get(j).getOrigen()+",\n" +
"	 destino: "+listaFlota.get(j).getDestino()+",\n" +
"	 porcentajeMuertes: "+listaFlota.get(j).getPorcetajeMuertes()+",\n" +
"	 tipoPlaneta: "+listaFlota.get(j).getTipoPlaneta()+",\n" +
"	 naves: "+listaFlota.get(j).getNavesEnviadas()+",\n" +
"	 turnoDistancia: "+listaFlota.get(j).getTurno()+",\n" +
"	 turnoLlegada: "+listaFlota.get(j).getTurnosLlegar()+"\n	}";
                if(j!=(listaFlota.size()-1)){
                    texto+=",\n";
                }
            }
        
        texto+="\n    ],\n" +
"    ";
    }
    
    public void generarMensajes(ArrayList<Mensaje> listaMensajes){
        texto+="	MENSAJES:[\n";
        for (int i = 0; i < listaMensajes.size(); i++) {
            texto += "{\n" +
"	 nombre: \"";
            texto += listaMensajes.get(i).getPlaneta()+"\",\n" +
"	nombreJugador: \"";
             texto += listaMensajes.get(i).getJugador()+"\",\n" +
"	resultado: "+listaMensajes.get(i).isResultado()+",\n" +
"	turno: ";
             texto += listaMensajes.get(i).getTurno()+"\n	}";
             if(i!=(listaMensajes.size()-1)){
                    texto+=",\n        ";
                }
             
        }
        texto+="\n    ]\n" +
"    \n" +
"}";
    }
    
    public ArrayList<Flota> getListaF(ArrayList<Jugador> listaJugadores){
        ArrayList<Flota> listaFlota = new ArrayList<>();
        for (int i = 0; i < listaJugadores.size(); i++) {
            for (int j = 0; j < listaJugadores.get(i).getListaFlota().size(); j++) {
                listaFlota.add(listaJugadores.get(i).getListaFlota().get(j));
            }
        }
        
        return listaFlota;
    }
}
