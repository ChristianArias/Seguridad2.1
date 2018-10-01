/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author black
 */
public class crearIcono {
    
    public Icon imagen(String imagen,int height,int width){
        ImageIcon img = new ImageIcon(Toolkit.getDefaultToolkit().createImage(imagen));
        return new ImageIcon(img.getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH));
    }
    
}
