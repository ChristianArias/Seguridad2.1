package other;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class ImagenInicial implements Border{

    static String usuario = System.getProperty("user.name");
    public BufferedImage img;
    Image image;
    //public static String imagen = Conexion.Conector.path()+"lib"+Conexion.Conector.s+"Fondo"+Conexion.Conector.s+"logo.jpg";
    
    public ImagenInicial(String imagen) {
        try {
            URL imagePath = new URL("file:///"+imagen);
            img = ImageIO.read(imagePath);
            image = Toolkit.getDefaultToolkit().createImage(imagen);
            //image = Acceso.Data.img();
        } catch (IOException ex) { 
            new Logs.Error().error(ex.getMessage());
        }        
    }
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.red);
        //g.drawImage(image,(x + (width - image.getWidth()))/2,(y + (height - image.getHeight()))/2, null);  
        g.drawImage(image, (x + (width - image.getWidth(null)))/2,(y + (height - image.getHeight(null)))/2, Principal.Escritorio.vPantalla);
        
    }
    
    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }
    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
