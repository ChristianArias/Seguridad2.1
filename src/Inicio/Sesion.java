/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import Conexion.Conector;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ChristianArias
 */
public class Sesion {
    
    public static String nombre = "",usuario = "",contrasena = "",nombreagencia = "";
    public static int id = 0,idagencia = 0;
    public static boolean admin = false;
    
    public void cargar(int sel){
        Connection cn = Conector.conexion();
        try{
            String sql = "SELECT * FROM vistausuarios WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, sel);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
                nombre  = rs.getString("nombre");
                usuario = rs.getString("usuario");
                contrasena = new other.crypt().desencriptar(rs.getString("contrasena"));
                admin = rs.getBoolean("administrador");
                nombreagencia = rs.getString("_agencia");
                idagencia = rs.getInt("agencia");
            }
            accesos(id);
            cn.close();
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
    }
    
    void accesos(int usuario){
        Connection cn = Conector.conexion();
        try{
            String ip = InetAddress.getLocalHost().getHostAddress();
            String sql = "INSERT INTO accesos(id,hora,fecha,ultimaIp)VALUES(?,now(),now(),?)";
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, usuario);
                pst.setString(2, ip);
            int n = pst.executeUpdate();
            if(n>0){
                
            }
        }catch(SQLException | UnknownHostException e){
            new Logs.Error().error(e.getMessage());
        }
        try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
    }
    
    /*public void activo(boolean activo){
        Connection cn = Conector.conexion();
        try{
            String localIpAddress = InetAddress.getLocalHost().getHostAddress();
            String sql = "UPDATE seg_usuario SET enUso = ?,ip = ? WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setBoolean(1, activo);
                pst.setString(2, localIpAddress);//String.valueOf(socket.getLocalAddress()).replace("/", ""));
                pst.setInt(3, id);
            int n = pst.executeUpdate();
            if(n>0){}
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
    }*/
    
}
