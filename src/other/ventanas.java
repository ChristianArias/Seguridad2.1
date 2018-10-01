/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import javax.swing.JInternalFrame;
import static Principal.Escritorio.vPantalla;
import static Principal.Escritorio.vBarra;
import java.awt.Dimension;
import java.awt.Rectangle;

/**
 *
 * @author ChristianArias
 */
public class ventanas {
    
    public void minimizar(){
        JInternalFrame[] frames = vPantalla.getAllFrames();
        for(JInternalFrame frame : frames){
            frame.setVisible(false);
            frame.setIconifiable(true);
            System.gc();
        }
    }
    
    public void cerrar(){
        JInternalFrame[] v = vPantalla.getAllFrames();
        for(int i = 0;i<v.length;i++){
            v[i].dispose();
        }
        vBarra.removeAll();
        vPantalla.repaint();
        vBarra.repaint();
        System.gc();
    }
    
    public void centrar(){
        Dimension p = vPantalla.getSize();
        JInternalFrame[] frames = vPantalla.getAllFrames();
        for(JInternalFrame frame : frames){
            Dimension v = frame.getSize();
            frame.setLocation((p.width - v.width)/2, (p.height - v.height)/2);
            System.gc();
        }
    }
    
    public void cascada(){
        Rectangle d = vPantalla.getBounds();
        JInternalFrame[] v = vPantalla.getAllFrames();
        int s = 5;
        if(v.length == 0){
            
        }else{
            for(int i = v.length-1;i>= 0;i--){
                v[i].setBounds(
                        s   +   d.x +   i   *   s   ,
                        s   +   d.y +   i   *   s   ,
                        v[i].getWidth(),
                        v[i].getHeight()
                        );
            }
        }
        System.gc();
    }
    
}
