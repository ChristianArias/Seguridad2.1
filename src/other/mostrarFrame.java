/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author ChristianArias
 */
public class mostrarFrame {
    
    public void mostrar(JInternalFrame f){
        String clas = String.valueOf(f.getClass());
        //System.err.println(clas);
        switch(clas){
            case "class Limpieza.Lista":
                verificar(f);
                break;
            case "class Practicantes.Lista":
                verificar(f);
                break;
            case "class Provedores.Lista":
                verificar(f);
                break;
            case "class bitacoraLimpieza.Lista":
                verificar(f);
                break;
            case "class bitacoraPracticantes.Lista":
                verificar(f);
                break;
            case "class registroVehiculosServicio.Lista":
                verificar(f);
                break;
            case "class registroVisitantes.Lista":
                verificar(f);
                break;
            case "class Configuracion.configuraciones":
                verificar(f);
                break;
            case "class Usuarios.Lista":
                verificar(f);
                break;
            case "class Usuarios.Permisos":
                verificar(f);
                break;
            case "class Inicio.contrasena":
                verificar(f);
                break;
            case "class registroVehiculosNuevos.Lista":
                verificar(f);
                break;
            case "class registroVehiculosNuevos.ListaMovimientos":
                verificar(f);
                break;
            case "class registroDemos.Lista":
                verificar(f);
                break;
            case "class registroDemos.listarMovimientos":
                verificar(f);
                break;
            case "class Demos.Lista":
                verificar(f);
                break;
            default:
                lanzar(f);
                break;
        }
        System.gc();
    }
    
    void verificar(JInternalFrame f){
        boolean mostrar =   true;
        //String nombre   =   f.getTitle();
        JInternalFrame[] activos = Principal.Escritorio.vPantalla.getAllFrames();
        for (int a=0;a<activos.length;a++){
            if( f.getClass().isInstance( activos[a] )){
                mostrar = false;
                Logs.emergente.mostrar(f.getTitle()+" ya esta visible", "Mensaje");
                activos[a].pack();
                activos[a].moveToFront();
                if(activos[a].isIconifiable()){
                    activos[a].setVisible(true);
                }
            }else{
                
            }
        }if(mostrar){
            lanzar(f);
        }
    }
    
    void lanzar(JInternalFrame f){        
        Dimension p = Principal.Escritorio.vPantalla.getSize();        
        Dimension v = f.getSize();
        f.setClosable(true);
        f.setIconifiable(true);
        f.setLocation((p.width - v.width)/2, (p.height - v.height)/2);
        Principal.Escritorio.vPantalla.add(f).setVisible(true);
    }
}