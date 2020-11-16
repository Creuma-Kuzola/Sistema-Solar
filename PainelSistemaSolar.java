/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

/**
 *
 * @author creuma
 */
public class PainelSistemaSolar extends JPanel implements Runnable {
    
    private final Thread thread;
    private int terraAngulo = 0;
    private int luaAngulo = 0;
    
    public PainelSistemaSolar(){
    
        thread = new Thread(this);
        thread.start();
        
    }
    
     @Override
     public void paintComponent(Graphics g){
        
        super.paintComponent(g); // Faz a limpeza das figuras
        Graphics2D g2d = (Graphics2D) g;
      
        this.setBackground(new Color(0,0,0));
        
        Ellipse2D sol = new Ellipse2D.Double(280, 130, 80, 80);
        // Posição da terra é o final da posição do sol + 30.
        Ellipse2D terra = new Ellipse2D.Double(390, 210, 40, 40);
        // Posição do sol é o final da posição da terra + 80
        Ellipse2D lua = new Ellipse2D.Double(430, 250, 10, 10);
        
        //Sol
        g2d.setPaint(new Color(235,210,29));
        g2d.fill(sol);
        
        // Terra
        g2d.setPaint(new Color(192,192,192));
        // 320 e 170 são os valores do centro da terra.
        g2d.rotate(Math.toRadians(terraAngulo), 320,170);
        g2d.fill(terra);
        
        // Lua
        g2d.setPaint(new Color(255,255,255));
        g2d.rotate(Math.toRadians(luaAngulo), terra.getCenterX(), terra.getCenterY());
        g2d.fill(lua);
     
    }

    @Override
    public void run() {
        
        try {
            
            while(true)
            {

                this.terraAngulo = (int) (this.terraAngulo >= 360 ? 0 : 1 + this.terraAngulo);
                this.luaAngulo = (int) (this.luaAngulo >= 360 ? 0 : 1 + this.luaAngulo);
                Thread.sleep(10);
                super.repaint();
            
            }
        } catch (InterruptedException ex) {
            System.out.println("ERRO");
        }
                
    }
    
}
