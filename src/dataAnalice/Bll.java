/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dataAnalice;
import Conexion.Conector;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
/**
 *
 * @author Wilfo Martel S.
 * e-mail:logica_Razon@hotmail.com
 * cel:082502692
 * Usa este código para fines educativos,comerciales ,etc.  pero respeta el autor del código.
 */
public class Bll {

    Conector conector = new Conector();
    static  Connection cn = Conector.conexion();
    
    public static Vector ListarTablas() throws Exception  {
        Vector vec = new Vector();
        try {
            String sql = "SHOW TABLES";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                vec.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vec;
    }
    
    public static ArrayList<Tabla_cls> ListarColumnaTabla(String nomtabla) throws Exception {
        Tabla_cls tabla = null;
        ArrayList<Tabla_cls> lstTabla = new ArrayList<Tabla_cls>();
        try {
            
            String sql = "DESCRIBE " + nomtabla;
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tabla = new Tabla_cls();
                tabla.setField(rs.getString(1));
                tabla.setType(rs.getString(2));
                lstTabla.add(tabla);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lstTabla;
    }

}
