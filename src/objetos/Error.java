
package objetos;

public class Error {
    
    String lexema, tipo,descripcion;
    int linea,columna;
    //ArrayList<Error> listaErrores = new ArrayList<>();
    
    public Error(String lexema, String tipo, String descripcion, int linea, int columna) {
        this.lexema = lexema;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    }

    public String getLexema() {
        return lexema;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }
    public String toString(){
        return "Error: "+tipo+" "+descripcion+"--------->"+"Linea: "+linea+" Columna: "+columna;
    }
    public String toStringL(){
        return descripcion+"--------->"+"Linea: "+linea+" Columna: "+columna;
    }
}
