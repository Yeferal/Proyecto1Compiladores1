/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import analizadores.AnalizadorLexico;
import analizadores.AnalizadorSintactico;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventanas.VentanaInicio;

/**
 *
 * @author yefer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Hola Humano");
        VentanaInicio ventanaInicio = new VentanaInicio();
        ventanaInicio.setVisible(true);
        
//        AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(texto));
//        AnalizadorSintactico sintactico = new AnalizadorSintactico(lexico);
//        try {
//            sintactico.parse();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }
    
}
