/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mysql;

import Conexion.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ChristianArias
 */
public class ResultSet {
    
    public PreparedStatement rs(String sql){
        PreparedStatement pst = null;
        try{
            Connection cn = Conector.conexion();
            pst = cn.prepareStatement(sql);
        }catch(SQLException e){
            new Logs.Error().error(sql);
        }
        return pst;
    }
    
}
