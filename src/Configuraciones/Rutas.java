/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuraciones;

import java.io.File;
import Conexion.Conector;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 *
 * @author ChristianArias
 */
public class Rutas {
    
    
    public static String limpieza       = "\\\\192.168.1.251\\Compartidos\\Seguridad\\Limpieza\\";
    public static String practicantes   = "\\\\192.168.1.251\\Compartidos\\Seguridad\\Practicantes\\";
    public static String visitantes     = "\\\\192.168.1.251\\Compartidos\\Seguridad\\visitantes\\";
    public static String vehiculosdemo  = "\\\\192.168.1.251\\Compartidos\\Seguridad\\vehiculosdemo\\";
    public static String lavado         = "\\\\192.168.1.251\\Compartidos\\Seguridad\\lavado\\";
    
    public static String demos          = "\\\\192.168.1.251\\Compartidos\\Seguridad\\Demos\\";
    
    String carpetas[] = {limpieza,practicantes,visitantes,vehiculosdemo,lavado};
    File rutas = new File(Conector.path()+"Rutas.conf");
    
    void cargarCarpetas(){
        String linea = "";
        try{//"H:\\Limpieza\\,H:\\Practicantes\\,H:\\visitantes\\,H:\\vehiculosdemo\\,H:\\lavado\\"
            if(!rutas.exists()){
                String def = limpieza+","+practicantes+","+visitantes+","+vehiculosdemo+","+lavado;
                save(def);
                cargarCarpetas();
            }else{
                try(BufferedReader br = new BufferedReader(new FileReader(rutas))){
                    while((linea = br.readLine())!=null){
                        String[] array = linea.split(",");
                        limpieza        = array.length > 0 ? array[0] : "";
                        practicantes    = array.length > 1 ? array[1] : "";
                        visitantes      = array.length > 2 ? array[2] : "";
                        vehiculosdemo   = array.length > 3 ? array[3] : "";
                        lavado          = array.length > 4 ? array[4] : "";
                    }
                }
            }
            //System.out.println(limpieza+" "+practicantes+" "+visitantes+" "+vehiculosdemo+" "+lavado);
        }catch(Exception e){
            new Logs.Error().error(e.getMessage());
        }
    }
    
    public void crearcarpeta(String carpeta){
        try{
            if(new File(carpeta).mkdir()){
                
            }else{
                
            }
        }catch(Exception e){
            new Logs.Error().error(e.getMessage());
        }
    }
    
    public void save(String texto){
        try{
            try(PrintWriter wr = new PrintWriter(new BufferedWriter(new FileWriter(rutas)))){
                wr.write(texto);
            }
        }catch(Exception e){
            new Logs.Error().error(e.getMessage());
        }
    }
    
    public void carpetas(){
        cargarCarpetas();
        for (String carpeta : carpetas) {
            if (new File(carpeta).exists()) {
                //System.out.println("Existe " + carpeta);
            } else {
                new File(carpeta).mkdir();
                new Logs.Error().error("Se creo la carpeta " + carpeta);
            }
        }
    }
    
}
