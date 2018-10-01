/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.awt.HeadlessException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author black
 */
public class buscarArchivo {
    
    String dir = "";
    
    public String f(FileNameExtensionFilter filtro,String ruta){
        String archivo = "";
        try{
            JFileChooser file = new JFileChooser(ruta);
                FilePreviewer previewer = new FilePreviewer(file);
                file.setFileFilter(filtro);
                file.setAccessory(previewer);
            int resultado = file.showOpenDialog(null);
            if(JFileChooser.APPROVE_OPTION == resultado){
                archivo = file.getSelectedFile().getAbsolutePath();
            }if(JFileChooser.CANCEL_OPTION == resultado){
                archivo = ruta;
            }
        }catch(HeadlessException e){
            new Logs.Error().error(e.getMessage());
        }
        return archivo; 
    }
    
}
