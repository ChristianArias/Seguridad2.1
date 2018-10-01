/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 *
 * @author ChristianArias
 */
public class Error {
    
    Calendar calendario = new GregorianCalendar();
    
    String date = "",hour = "";
    
    public void error(String mensaje){
        
        Date actual = new Date();
        calendario.setTime(actual);
            
        String ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"a.m.":"p.m.";
        SimpleDateFormat reloj = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        
        hour = reloj.format(calendario.getTime())+" "+ampm;
        date = fecha.format(calendario.getTime());
        
        /*try{
            String ruta = Conexion.Conector.path()+"lib"+Conexion.Conector.s+"Logs.jar";
            Process proc = Runtime.getRuntime().exec("java -jar "+ruta+" "+mensaje+"¬Error");
        }catch(Exception e){
        }*/
        emergente.mostrar(mensaje, "Error");
        crearArchivo(mensaje);
    }
    
    void crearArchivo(String mensaje){
        try{
            File f = new File(Conexion.Conector.path()+"seguridad.log");
            if(f.exists()){
                errorEvents(mensaje);
            }else{
                f.createNewFile();
            }
        }catch(IOException e){
            error(e.getMessage());
        }   
    }
    
    void errorEvents(String evento){
        FileWriter fichero = null; 
        PrintWriter pw = null; 
        try{
            fichero = new FileWriter(Conexion.Conector.path()+"seguridad.log",true);
            pw = new PrintWriter(fichero);
            pw.println(date+" "+hour+" "+evento);
        }catch(IOException e){
            
        }finally{
            try {
                if (null != fichero)
                    fichero.close();
            } catch (IOException ex) {
                
            } 
        }
    }
}
