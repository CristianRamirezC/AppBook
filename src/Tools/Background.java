/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Cristian Camilo Ramirez Castellanos
 */
public class Background extends JPanel{
    private Image image;
    
    public Background(String url, Dimension d){
        this.image = new ImageIcon(getClass().getResource(url)).getImage();
        this.setSize(d); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
    
    
    
}
