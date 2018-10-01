/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reloj;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

/**
 *
 * @author black
 */
public class Obtener {
    
    String servidor = "time.windows.com";
    
    public Date obtener(){
        Date fechaRecibida = null;
        NTPUDPClient cliente = new NTPUDPClient();
        cliente.setDefaultTimeout(5000);
        try {
            InetAddress hostAddr = InetAddress.getByName(servidor);
            TimeInfo fecha = cliente.getTime(hostAddr); 
            fechaRecibida = new Date(fecha.getMessage().getTransmitTimeStamp().getTime());
        } catch (IOException e) {
            //Error al recibir hora-fecha
        }
        cliente.close();
        return fechaRecibida == null ? new Date() : fechaRecibida ;
    }
    
}
