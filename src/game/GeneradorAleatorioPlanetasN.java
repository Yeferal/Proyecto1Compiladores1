
package game;

import java.util.ArrayList;
import objetos.Planeta;

public class GeneradorAleatorioPlanetasN {
    
    int na, nb, nc;
    private boolean pos2,pos3;
    
    public ArrayList<Planeta> generarNeutralesAleatorios(int cantidad, boolean mostrarNaves, boolean mostrarEstadistica, int produccion){
        ArrayList<Planeta> listaAleatorios = new ArrayList<>();
        pos2 = true;
        pos3 = false;
        na = 1;
        nb = 1;
        for (int i = 0; i < cantidad; i++) {
            Planeta p = new Planeta();
            p.setNombre(permutarNombre());
            p.setNaves(getAleatorioNaves());
            p.setPorcentajeMuertes(getAleatorioPorcentaje());
            p.setProduccion(produccion);
            p.setTipo(0);
            listaAleatorios.add(p);
        }
        
        return listaAleatorios;
    }
    
    public int getAleatorioNaves(){
        int a = (int) (Math.random()*25);
        return a;
    }
    
    public double getAleatorioPorcentaje(){
        double a = (double) (Math.random());
        a = Math.round(a * 100) / 100d;
        return a;
    }
    public String permutarNombre(){
        String nombre = "N";
        if(pos2){
            if(na<=52){
                nombre+=getLetra(na);
                na++;
            }else{
                na=1;
                pos3 = true;
                nombre+=getLetra(na);
                na++;
            }
            
        }
        if(pos3){
            if(nb<=52){
                nombre+=getLetra(nb);
                nb++;
            }            
        }
        return nombre;
    }
    public String getLetra(int n){
        switch(n){
            case 1:
                return "a";
            case 2:
                return "b";
            case 3:
                return "c";
            case 4:
                return "d";
            case 5:
                return "e";
            case 6:
                return "f";
            case 7:
                return "g";
            case 8:
                return "h";
            case 9:
                return "i";
            case 10:
                return "j";
            case 11:
                return "k";
            case 12:
                return "l";
            case 13:
                return "m";
            case 14:
                return "n";
            case 15:
                return "o";
            case 16:
                return "p";
            case 17:
                return "q";
            case 18:
                return "r";
            case 19:
                return "s";
            case 20:
                return "t";
            case 21:
                return "u";
            case 22:
                return "v";
            case 23:
                return "w";
            case 24:
                return "x";
            case 25:
                return "y";
            case 26:
                return "z";
            case 27:
                return "A";
            case 28:
                return "B";
            case 29:
                return "C";
            case 30:
                return "D";
            case 31:
                return "E";
            case 32:
                return "F";
            case 33:
                return "G";
            case 34:
                return "H";
            case 35:
                return "I";
            case 36:
                return "J";
            case 37:
                return "K";
            case 38:
                return "L";
            case 39:
                return "M";
            case 40:
                return "N";
            case 41:
                return "O";
            case 42:
                return "P";
            case 43:
                return "Q";
            case 44:
                return "R";
            case 45:
                return "S";
            case 46:
                return "T";
            case 47:
                return "U";
            case 48:
                return "V";
            case 49:
                return "W";
            case 50:
                return "X";
            case 51:
                return "Y";
            case 52:
                return "Z";
                default:
                    return "";
        }
    }
}
