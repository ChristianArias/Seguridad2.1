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
 * @author black
 */
public class copiarArchivo {
    
    public String copiarArchivo(File cargar,String destino){
        String resultado = "";
        if(cargar.exists()){
            try {
                String origen   = cargar.getAbsolutePath();
                Path origenPath = FileSystems.getDefault().getPath(origen);
                Path destinoPath = FileSystems.getDefault().getPath(destino);
                
                Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
                resultado = destino;
                
            } catch (IOException e) {
                new Logs.Error().error(e.getMessage());
            }
        }else{
            resultado = "";
        }
        return resultado;
    }
    
    public String moverArchivo(File cargar,String destino){
        String resultado = "";
        if(cargar.exists()){
            try {
                String origen   = cargar.getAbsolutePath();
                Path origenPath = FileSystems.getDefault().getPath(origen);
                Path destinoPath = FileSystems.getDefault().getPath(destino);
                
                Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
                resultado = destino;
                
            } catch (IOException e) {
                new Logs.Error().error(e.getMessage());
            }
        }else{
            resultado = "";
        }
        return resultado;
    }
    
}
