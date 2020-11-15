/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author creuma
 */
public class PainelSistemaSolar extends JPanel implements Runnable {
    
    private final Thread thread;
    private float earthDegree = 0;
    
    public PainelSistemaSolar(){
    
        thread = new Thread(this, "Rotate Scare");
        thread.start();
        
    }
    
     @Override
     public void paintComponent(Graphics g){
        
        super.paintComponent(g); // Faz a limpeza das figuras
        Graphics2D g2d = (Graphics2D) g;
      
        this.setBackground(new Color(0,0,0));
        Ellipse2D sol = new Ellipse2D.Double(280, 130, 80, 80);
        Ellipse2D terra = new Ellipse2D.Double(390, 180, 40, 40);
        Ellipse2D lua = new Ellipse2D.Double(440,230, 10, 10);
        
        g2d.setPaint(new Color(235,210,29));
        g2d.fill(sol);
        
       
       // g2d.rotate(Math.PI / 8, 280/2, 130/2);
        g2d.setPaint(new Color(255,255,255));
        g2d.rotate(Math.toRadians(earthDegree), 140, 65);
        g2d.fill(terra);
       // g2d.fill(lua);
        
        
      //  AffineTransform at = new AffineTransform();
        //at.setToRotation(Math.PI / 6, 100,100);
       // at.translate(100, 0);
    
       
    }

    @Override
    public void run() {
        
        try {
            
            this.earthDegree = (float) (this.earthDegree >= 360 ? 0 : 0.02 + this.earthDegree);
            Thread.sleep(22);
            super.repaint();
            
        } catch (InterruptedException ex) {
            System.out.println("Bla bla bla");
        }
                
    }
    
}
