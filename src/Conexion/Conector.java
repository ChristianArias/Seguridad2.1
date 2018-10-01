package Conexion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * @author Christian Saúl Rojas Arias
 */
public final class Conector {
    

    public static Connection conect = null;        
    public static String s  = "",so = "";
    
    static public String 
        base                =       "seguridad",
        clave               =       "seguridad",
        ip                  =       "localhost:",/*"192.168.1.226",*/
        puerto              =       "3306/",
        usuario             =       "seguridad",
        conector            =       "jdbc:mysql://",
        dateTime            =       "?zeroDateTimeBehavior=convertToNull",
        autoReconnect       =       "&autoReconnect=true",
        ssl                 =       "&useSSL=false";
        
    public static String path(){
        String ubicacion = "";
        so = System.getProperty("os.name");
        try{
            if(so.contains("Windows")){
                s = "\\";
                ubicacion = new File(".").getCanonicalPath()+s;
            }else if(so.contains("Linux")){
                s = "/";
                ubicacion = new File(".").getCanonicalPath()+s;
            }
        }catch(IOException e){
            new Logs.Error().error(e.getMessage());
        }
        return ubicacion;
    }
    
    public static void cargarConexion(){
        try{
            String linea = "";
            File archivo = new File(path()+"seguridad.conexion");
            if(!archivo.exists()){
                String conexion = "seguridad,seguridad,192.168.1.251:,3306/,seguridad";
                try(PrintWriter wr = new PrintWriter(new BufferedWriter(new FileWriter(archivo)))){
                    wr.write(conexion);
                }
                cargarConexion();
            }else{
                try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
                    while((linea = br.readLine())!=null){
                        String[] array = linea.split(",");
                        base    = array.length > 0 ? array[0] : "";
                        clave   = array.length > 1 ? array[1] : "";
                        ip      = array.length > 2 ? array[2] : "";
                        puerto  = array.length > 3 ? array[3] : "";
                        usuario = array.length > 4 ? array[4] : "";
                    }
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static Connection conexion(){
        cargarConexion();
        try{        
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conect = DriverManager.getConnection(
                    conector 
                            + ip 
                            + puerto 
                            + base
                            + dateTime 
                            + autoReconnect 
                            + ssl,
                    usuario,
                    clave);            
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }        
        return conect;        
    }
    
}