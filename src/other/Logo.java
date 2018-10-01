/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author black
 */
public class Logo {
    public Image imagen(String carpeta,String nombre){
        Image icon = Toolkit.getDefaultToolkit().getImage(
                Conexion.Conector.path()+"lib"+Conexion.Conector.s+carpeta+Conexion.Conector.s+nombre);
        return icon;
    }
}
