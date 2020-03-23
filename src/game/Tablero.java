
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
                //boton.setBackground(new Color(i*25, j*25, i));
                //boton.setOpaque(false);
                boton.setContentAreaFilled(false);
                boton.setForeground(Color.WHITE);
                //boton.setOpaque(true);
                //boton.setBackground(new Color(0,0,0,0));
                tablero[i][j] = boton;
                 
             }
         }
     }
     
     public Icon getIcono(int tamanioX, int tamanioY){
         Icon icono = null;
         ImageIcon iconoImage = new ImageIcon(definirRutaPlaneta());
         tamanioX=(int)(tamanioX*0.30);
         tamanioY=(int)(tamanioY*0.30);
         icono = new ImageIcon(iconoImage.getImage().getScaledInstance(tamanioX,tamanioY , Image.SCALE_SMOOTH));
         return icono;
     }
     
     
     public String definirRutaPlaneta(){
         int n = (int) (Math.random()*14);
         //System.out.println("src/planetas/p1.png");
         switch(n){
             case 0:
                 return "src/planetas/p1.png";
             case 1:
                 return "src/planetas/p2.png";
             case 2:
                 return "src/planetas/p3.png";
             case 3:
                 return "src/planetas/p4.png";
             case 4:
                 return "src/planetas/p5.png";
             case 5:
                 return "src/planetas/p6.png";
             case 6:
                 return "src/planetas/p7.png";
             case 7:
                 return "src/planetas/p8.png";
             case 8:
                 return "src/planetas/p9.png";
             case 9:
                 return "src/planetas/p10.png";
             case 11:
                 return "src/planetas/p11.png";
             case 12:
                 return "src/planetas/p12.png";
             case 13:
                 return "src/planetas/p13.png";
             case 14:
                 return "src/planetas/p14.png";
         }
         
         return "src/planetas/p14.png";
     }
     
     
}
