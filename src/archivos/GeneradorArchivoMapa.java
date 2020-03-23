
package archivos;

import java.util.ArrayList;
import javax.swing.JPanel;
import objetos.Jugador;
import objetos.Mapa;
import objetos.Planeta;

public class GeneradorArchivoMapa {
    
    JPanel panel;
    String texto;
    public GeneradorArchivoMapa(){
        
    }
    
    public void setTexto(String texto){
        this.texto = texto;
    }
    
    public String getTexto(){
        return texto;
    }
    
    public void generar(Mapa mapa,ArrayList<Planeta> listaPlanetas,ArrayList<Planeta> listaPlanetasNeutrales,ArrayList<Jugador> listaJugadores){
        generarTextoMapa(mapa);
        generarPlanetasNetrales(listaPlanetasNeutrales);
        generarPlanetas(listaPlanetas);
        generarJugadores(listaJugadores);
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
        texto+=mapa.getTamanioY()+"\n        },\n" +
"        alAzar: ";
        texto+=mapa.isAlAzar()+",\n" +
"        planetasNeutrales: ";
        texto+=mapa.getPlanetasNeutrales()+",\n" +
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
        texto+=mapa.getFinalizacion()+"\n    },\n" +
"    ";
        
        
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
            texto+=listaPlanetas.get(i).getPorcentajeMuertes()+"\n        }";
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
            texto+=listaPlanetasNeutrales.get(i).getPorcentajeMuertes()+"\n        }";
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
"        planetas: [\n" +
"            ";
             for (int j = 0; j < listaJugadores.get(i).getListaPlanetas().size(); j++) {
                texto+="\""+listaJugadores.get(i).getListaPlanetas().get(j)+"\"";
                if(j!=(listaJugadores.get(i).getListaPlanetas().size()-1)){
                    texto+=",\n" +
"            ";
                }
            }
             texto+="\n        ],\n" +
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
}
