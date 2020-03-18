
package game;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tablero {
     JButton tablero [][];
     
     public JButton[][] getTablero(){
         return tablero;
     }
     public void generarTablero(int x,int y){
         tablero = new JButton[x][y];
         
         for (int i = 0; i < x; i++) {
             for (int j = 0; j < y; j++) {
                 
                JButton boton = new JButton();
                //boton.setBounds(i * 100, j * 100, 100, 100);
                boton.setSize(100 , 100);
                //boton.setToolTipText("<html>"+"Coordenadas: "+i+", "+j+"<br>"+"MI EDAD ES YEFER"+"<br>"+"MI EDAD ES YEFER");
                //boton.setText("Coordenadas: "+i+", "+j);
                boton.setBackground(Color.red);
                //boton.setOpaque(false);
                boton.setContentAreaFilled(false);
                
                //boton.setOpaque(false);
                //boton.setBackground(new Color(0,0,0,0));
                tablero[i][j] = boton;
                 
             }
         }
     }
     
     public Icon getIcono(int tamanioX, int tamanioY){
         Icon icono = null;
         ImageIcon iconoImage = new ImageIcon(definirRutaPlaneta());
         icono = new ImageIcon(iconoImage.getImage().getScaledInstance(tamanioX-50,tamanioY-50 , Image.SCALE_SMOOTH));
         return icono;
     }
     
     
     public String definirRutaPlaneta(){
         int n = (int) (Math.random()*14);
         //System.out.println("src/planetas/p1.png");
         switch(n){
             case 0:
                 System.out.println("src/planetas/p1.png");
                 return "src/planetas/p1.png";
             case 1:
                 System.out.println("src/planetas/p2.png");
                 return "src/planetas/p2.png";
             case 2:
                 System.out.println("src/planetas/p3.png");
                 return "src/planetas/p3.png";
             case 3:
                 System.out.println("src/planetas/p4.png");
                 return "src/planetas/p4.png";
             case 4:
                 System.out.println("src/planetas/p5.png");
                 return "src/planetas/p5.png";
             case 5:
                 System.out.println("src/planetas/p6.png");
                 return "src/planetas/p6.png";
             case 6:
                 System.out.println("src/planetas/p7.png");
                 return "src/planetas/p7.png";
             case 7:
                 System.out.println("src/planetas/p8.png");
                 return "src/planetas/p8.png";
             case 8:
                 System.out.println("src/planetas/p9.png");
                 return "src/planetas/p9.png";
             case 9:
                 System.out.println("src/planetas/p10.png");
                 return "src/planetas/p10.png";
             case 11:
                 System.out.println("src/planetas/p11.png");
                 return "src/planetas/p11.png";
             case 12:
                 System.out.println("src/planetas/p12.png");
                 return "src/planetas/p12.png";
             case 13:
                 System.out.println("src/planetas/p13.png");
                 return "src/planetas/p13.png";
             case 14:
                 System.out.println("src/planetas/p14.png");
                 return "src/planetas/p14.png";
         }
         
         return "src/planetas/p14.png";
     }
     
     
}
