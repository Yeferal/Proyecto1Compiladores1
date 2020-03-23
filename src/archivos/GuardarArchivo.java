
package archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuardarArchivo {
    
    
    public void escribir(String texto, String ruta){
        try {
            PrintWriter salida = new PrintWriter(
            new BufferedWriter(new FileWriter(ruta, true)));
                
            salida.print(texto);
            salida.close();
            System.out.println("Escribe");
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
    
    public void crearJSON(String nombre,String ruta,String texto){
        File file = new File(ruta+"\\"+nombre+".json");
        
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.close();
        } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
