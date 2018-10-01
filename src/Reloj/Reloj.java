/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reloj;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Timer;

/**
 *
 * @author Christian
 */
public class Reloj {
    
    public static String hour_12,fecha_larga,ampm;
    public static String hour_24,fecha_corta;
    SimpleDateFormat reloj_12 = new SimpleDateFormat("hh:mm:ss");
    SimpleDateFormat reloj_24 = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat fecha = new SimpleDateFormat("EEEE, dd"+"' de '"+"MMMM"+" 'del' "+"yyyy");
    SimpleDateFormat day = new SimpleDateFormat("EEEE");
    SimpleDateFormat fechasimple = new SimpleDateFormat("dd/MM/yyyy");
    String servidor = "time.windows.com";
    
    public void reloj(){
        
        java.util.Calendar calendario = new java.util.GregorianCalendar(); 
        
        Timer timer = new Timer(1000, (ActionEvent e) -> {
            //Date actual = new Date();
            //calendario.setTime(actual);
            new Thread(() -> { calendario.setTime(new Obtener().obtener()); }).start();
            
            ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"a.m.":"p.m.";
            
            fecha_larga     = upper(fecha.format(calendario.getTime()));
            fecha_corta     = fechasimple.format(calendario.getTime());
            hour_12         = reloj_12.format(calendario.getTime());
            hour_24         = reloj_24.format(calendario.getTime());
            
            Principal.Escritorio.Tiempo.setText(upper(fecha.format(calendario.getTime()))+","+hour_12+" "+ampm);
            Principal.Escritorio.Tiempo.setToolTipText( upper(fecha.format(calendario.getTime())));
            
        });
        timer.start();
    }
    
    String upper(String cadena){
        char[] c = cadena.toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        for (int i = 0; i < cadena.length()- 2; i++)
            if (c[i] == ' ' || c[i] == '.' || c[i] == ',')
                c[i + 1] = Character.toUpperCase(c[i + 1]);
        return new String(c);
    }
    
}
