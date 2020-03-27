
package archivos;

import java.util.ArrayList;
import objetos.Flota;
import objetos.Jugador;
import objetos.Mapa;
import objetos.Mensaje;
import objetos.Planeta;
import objetos.Repeticion;

public class GeneradorReplay {
    
    
    String texto;
    public GeneradorReplay(){
        
    }
    
    public void setTexto(String texto){
        this.texto = texto;
    }
    
    public String getTexto(){
        return texto;
    }
    
    public void generar(Mapa mapa,ArrayList<Planeta> listaPlanetas,ArrayList<Planeta> listaPlanetasNeutrales,ArrayList<Jugador> listaJugadores, ArrayList<Repeticion> listaRepeticions, ArrayList<Mensaje> listaMenssaje){
        generarTextoMapa(mapa);
        generarPlanetasNetrales(listaPlanetasNeutrales);
        generarPlanetas(listaPlanetas);
        generarJugadores(listaJugadores);
        generarRepetecion(listaRepeticions);
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
"        NEUTRALES: {\n" +
"            mostrarNaves: ";
        texto+=mapa.isMostrarNavesNeutrales()+",\n" +
"            mostrarEstadisticas: ";
        texto+=mapa.isMostrarEstadisticasNeutrales()+"\n        }\n" +
"    },\n";
        
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
"	coordenadaX: ";
            texto+=listaPlanetas.get(i).getCoordenadaX()+ ",\n" +
"	coordenadaY: ";
            texto+=listaPlanetas.get(i).getCoordenadaY()+",\n" +
"	jugadorPlaneta: "; 
            texto+= listaPlanetas.get(i).getJugador()+"\n        }";
            
            
            if(i!=(listaPlanetas.size()-1)){
                texto+=",\n        ";
            }
            
        }
        texto+="\n    ],\n" +
"    ";
    }
    
    public void generarPlanetasNetrales(ArrayList<Planeta> listaPlanetasNeutrales){
        texto+="    PLANETAS_NEUTRALES: [\n" +
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
"	coordenadaX: ";
            texto+=listaPlanetasNeutrales.get(i).getCoordenadaX()+ ",\n" +
"	coordenadaY: ";
            texto+=listaPlanetasNeutrales.get(i).getCoordenadaY()+"\n" +
"        }";
            if(i!=(listaPlanetasNeutrales.size()-1)){
                texto+=",\n        ";
            }
            
        }
        texto+="\n    ],\n" +
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
    
    public void generarRepetecion(ArrayList<Repeticion> listaRepeticions){
        texto += "{\n" +
"    REPETICION:[\n	";
        for (int i = 0; i < listaRepeticions.size(); i++) {
            texto += "{\n" +
"	origen: ";
            texto+= listaRepeticions.get(i).getPosicionOrigen()+",\n" +
"	destino: ";
            texto+= listaRepeticions.get(i).getPosicionDestion()+",\n" +
"	tipoPlaneta: ";
            texto+= listaRepeticions.get(i).getTipoPlanetaDestino()+",\n" +
"	turno: ";
            texto+= listaRepeticions.get(i).getTurnoJugador()+",\n" +
"	turnoJugador: ";
            texto+= listaRepeticions.get(i).getTurnoNumero()+",\n" +
"	resultado: ";
            texto+= listaRepeticions.get(i).isResultado()+"\n	}";
            
            if(i!=(listaRepeticions.size()-1)){
                 texto+=",\n" +
"        ";
             }
        }
        texto+="\n    ],\n" +
"    ";
    }
    
    public void generarMensajes(ArrayList<Mensaje> listaMensajes){
        texto+="	MENSAJES:[\n	";
        for (int i = 0; i < listaMensajes.size(); i++) {
            texto += "{\n" +
"	nombre: \"";
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
    
}
