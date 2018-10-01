/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author ChristianArias
 */
public class copy {
    
    public static String copy(String destino,String origen,String name){
        
        File f = new File(origen);
        String ext = ext(f.getName());
        String nuevoDestino = destino+name+"."+ext;
                
        Path origenPath = FileSystems.getDefault().getPath(origen);
        Path destinoPath = FileSystems.getDefault().getPath(nuevoDestino);
        
        try {
            if(!destino.equals(nuevoDestino)){
                Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            new Logs.Error().error("copy "+e.getMessage());
        }
        
        return nuevoDestino;
    }
    
    static String ext(String fileName){
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i >= 0) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }
    
}
