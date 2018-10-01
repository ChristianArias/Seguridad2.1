/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.io.File;

/**
 *
 * @author ChristianArias
 */
public class eliminarArchivo {
    
    public void eliminar(String ruta){
        try{
        File f = new File(ruta);
        File path = new File(f.getCanonicalPath());
            if(path.delete()){
                //System.err.println(f.getAbsolutePath());                
            }
        }catch(Exception e){
            new Logs.Error().error(e.getMessage());
        }
    }
    
}
