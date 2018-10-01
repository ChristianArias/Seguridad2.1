/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author christian
 */
public class exportarTxt {
    
    String ruta = "",archivo = "";
    
    public void exportar(DefaultTableModel[] tablas,String titulo,String tipo){
        String s = Conexion.Conector.s;
        ruta = "C:"+s+"Users"+s+System.getProperty("user.name")+s+"desktop";
        
        JFileChooser seleccionar = new JFileChooser(ruta);
            seleccionar.setSelectedFile(new File(titulo));
            
        if(seleccionar.showDialog(null, "Exportar a Excel") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionar.getSelectedFile().getAbsolutePath()+"."+tipo;
            for (DefaultTableModel tabla : tablas) {
                guardar(archivo,tabla,titulo);
            }            
        }
    }
    
    void guardar(String archivo,DefaultTableModel model,String titulo){
        try{
            try (BufferedWriter bfw = new BufferedWriter(new FileWriter(archivo))) {
                for(int r = 0;r<model.getRowCount();r++){
                    for(int c = 1;c<model.getColumnCount();c++){
                        bfw.write(String.valueOf(model.getValueAt(r, c)));
                        if(c<model.getColumnCount()-1){
                            bfw.write(",");
                        }
                    }
                    bfw.newLine();
                }
            }
            
            String nuevo = renombrar(archivo);
            Logs.emergente.mostrar("Termino de exportar "+titulo, "Exportar");
            
            Object[] option = {"Abrir archivo","Aceptar"};
            int x =  JOptionPane.showOptionDialog(null,"Se agregaron valores al archivo "+titulo,
                    "Seleccionar opcion",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,
                    null, option, option[0]);
            
            if(x == JOptionPane.YES_OPTION){
                new Thread(() -> {
                    try {
                        Desktop.getDesktop().open(new File(nuevo));
                    } catch (IOException ex) {
                        new Logs.Error().error(ex.getMessage());
                    }
                }).start();
            }
        }catch(IOException e){
            new Logs.Error().error(e.getMessage());
        }
    }
    
    String renombrar(String archivo){        
        String nuevo = archivo.substring(0,archivo.lastIndexOf("."))+".csv";
        boolean res = new File(archivo).renameTo(new File(nuevo));
        return nuevo;
    }
    
    /*
    String ext = "";
        String nombre = new File(archivo).getName();
        int i = nombre.lastIndexOf('.');
        if (i > 0) {
            ext = nombre.substring(i+1);
        }
    */
    
}