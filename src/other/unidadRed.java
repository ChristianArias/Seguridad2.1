/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

/**
 *
 * @author ChristianArias
 */
public class unidadRed {
    
    public void conectar(){
        Runtime aplicacion = Runtime.getRuntime();
        try{
            String bat = Conexion.Conector.path()+"unidad.bat";
            aplicacion.exec("cmd.exe /K "+bat);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
