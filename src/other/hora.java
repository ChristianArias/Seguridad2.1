/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ChristianArias
 */
public class hora {
    
    public String hora(){
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        java.util.Calendar calendario = new java.util.GregorianCalendar(); 
        Date actual = new Date();
        calendario.setTime(actual);
        return formato.format(calendario.getTime());
        //return Reloj.Reloj.hour_24;
    }
    
    public Date date(){
        return new Reloj.Obtener().obtener();
    }
    
    public String time(){
        return Reloj.Reloj.hour_24;
    }
    
}
