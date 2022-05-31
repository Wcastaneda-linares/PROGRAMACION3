/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author Wcastañeda
 */
public class pintarDibujos {
    public pintarDibujos(){
        
    }
    //esta clase lo unico que hace es pintat los circulos  y aplicarle diferentes metodos
    public static void pintaCirculo(Graphics g, int x, int y, String n) {
        ((Graphics2D) g).setColor(Color.ORANGE);     //como el color
        ((Graphics2D) g).setStroke(new BasicStroke(3));     //grosor de la linea
        ((Graphics2D) g).fillOval(x, y, 15, 15);    //color de relleno
        ((Graphics2D) g).setColor(Color.BLACK);    //color de borde
        ((Graphics2D) g).drawOval(x, y, 15, 15);    //firma de la figura

        ((Graphics2D) g).setColor(Color.blue);    //color de letra
        Font fuente = new Font("Monospaced", Font.BOLD, 16);    //tamaño de la letra
        g.setFont(fuente);    //le pasamos la fuente
        ((Graphics2D) g).drawString(n, x, y);    //obtenemos la fuente
    }

    public static void pintaLinea(Graphics g, int x1, int y1, int x2, int y2, double tam) {
        int xAux = 0;
        int yAux = 0;
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(1);
        ((Graphics2D) g).setStroke(stroke);
        ((Graphics2D) g).drawLine(x1 + 10, y1 + 10, x2 + 10, y2 + 10);
        if (x1 <= x2) {
            xAux = ((x2 - x1) / 2) + x1;
        }
        if (x1 > x2) {
            xAux = ((x1 - x2) / 2) + x2;
        }
        if (y1 < y2) {
            yAux = ((y2 - y1) / 2) + y1;
        }
        if (y1 >= y2) {
            yAux = ((y1 - y2) / 2) + y2;
        }

        ((Graphics2D) g).setColor(Color.black);//PINTANDO TEXTO DE VERTICES (TAMAÑO)
        Font fuente = new Font("Arial", Font.PLAIN, 12);
        g.setFont(fuente);
        ((Graphics2D) g).drawString(String.valueOf(tam), xAux, yAux);   
    }
    
    public static void pintaCamino(Graphics g, int x1, int y1, int x2, int y2, Color color){
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(2);
        ((Graphics2D) g).setStroke(stroke);
        g.setColor(color);
        g.drawLine(x1 + 10, y1 + 10, x2 + 10, y2 + 10);
    }
    
    public static void seleccionNodo(Graphics g, int x, int y, String n, Color co){
        ((Graphics2D) g).setColor(co);
        ((Graphics2D) g).setStroke(new BasicStroke(3));
        ((Graphics2D) g).fillOval(x, y, 15, 15);
        ((Graphics2D) g).setColor(Color.BLUE);
        ((Graphics2D) g).drawOval(x, y, 15, 15);
    }
}
