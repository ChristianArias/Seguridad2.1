/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Conexion.Conector;
import Principal.Escritorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 *
 * @author ChristianArias
 */
public class Menu implements ActionListener{
    
    JMenuBar menu = new JMenuBar();
    int reg = 0,bit = 0,bod = 0,sis = 0,dat = 0;
    
    public JMenuBar menu(){
        
        menu.removeAll();
        menu.repaint();
        
        JMenu registro = new JMenu("Registro");
        JMenu bitacora = new JMenu("Bitacora");
        JMenu bodega = new JMenu("Bodega");
        JMenu sesion = new JMenu(Inicio.Sesion.nombre+" ["+Inicio.Sesion.usuario+"]");
        JMenu sistema = new JMenu("Sistema");
        
        JMenuItem rlimpieza         = new JMenuItem("Limpieza");
        JMenuItem rpracticantes     = new JMenuItem("Practicantes");
        JMenuItem rvisitantes       = new JMenuItem("Visitantes");
        JMenuItem rlavado           = new JMenuItem("Lavado");
        JMenuItem rvehiculosdemos   = new JMenuItem("Vehiculos demo");
        //----------------------------------------------------------------------
        JMenuItem blimpieza         = new JMenuItem("Limpieza.");
        JMenuItem bpracticantes     = new JMenuItem("Practicantes.");
        JMenuItem bvehiculos        = new JMenuItem("Vehiculos");
        JMenuItem bvisitantes       = new JMenuItem("Visitantes.");
        JMenuItem blavado           = new JMenuItem("Lavado.");
        JMenuItem bmovimientos      = new JMenuItem("Movimientos demos");
        //----------------------------------------------------------------------
        JMenuItem boVehiculosnuevos = new JMenuItem("Vehiculos nuevos");
        //----------------------------------------------------------------------
        JMenuItem configuraciones = new JMenuItem("Configuraciones");
        JMenuItem usuarios = new JMenuItem("Usuarios");
        JMenuItem agencias = new JMenuItem("Agencias");
        JMenuItem dataanalice = new JMenuItem("Data analice");
        
//--------- ACTION LISTENER ----------------------------------------------------        
        rlimpieza.addActionListener(this);
        rpracticantes.addActionListener(this);
        rvisitantes.addActionListener(this);
        rlavado.addActionListener(this);
        rvehiculosdemos.addActionListener(this);
        //----------------------------------------------------------------------
        blimpieza.addActionListener(this);
        blavado.addActionListener(this);
        bpracticantes.addActionListener(this);
        bvehiculos.addActionListener(this);
        bvisitantes.addActionListener(this);
        bmovimientos.addActionListener(this);
        //----------------------------------------------------------------------
        boVehiculosnuevos.addActionListener(this);
        //----------------------------------------------------------------------
        configuraciones.addActionListener(this);
        usuarios.addActionListener(this);
        agencias.addActionListener(this);
        dataanalice.addActionListener(this);
        
        JMenuItem contrasena = new JMenuItem("Cambiar contraseña");
            contrasena.addActionListener(this);            
        JMenuItem rmenu = new JMenuItem("Recargar menu");
            rmenu.addActionListener(this);
        JMenuItem salir = new JMenuItem("Salir");
            salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
            salir.addActionListener(this);
        
        try{
            Connection cn = Conector.conexion();
            String sql = "SELECT * FROM seg_usuariopermisos WHERE usuario = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, Inicio.Sesion.id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                if(rs.getBoolean("m0")==true){          registro.add(rlimpieza);        reg += 1;}
                if(rs.getBoolean("m1")==true){          registro.add(rpracticantes);    reg += 1;}
                if(rs.getBoolean("m2")==true){          registro.add(rvisitantes);      reg += 1;}
                if(rs.getBoolean("rLavado")==true){     registro.add(rlavado);          reg += 1;}
                if(rs.getBoolean("m3")==true){          registro.add(rvehiculosdemos);  reg += 1;}
                
                if(rs.getBoolean("m4")==true){          bitacora.add(blimpieza);        bit += 1;}
                if(rs.getBoolean("bLavado")==true){     bitacora.add(blavado);          reg += 1;}
                if(rs.getBoolean("m5")==true){          bitacora.add(bpracticantes);    bit += 1;}
                if(rs.getBoolean("m6")==true){          bitacora.add(bvehiculos);       bit += 1;}
                if(rs.getBoolean("m7")==true){          bitacora.add(bvisitantes);      bit += 1;}
                if(rs.getBoolean("m8")==true){          bitacora.add(bmovimientos);     bit += 1;}
                
                if(rs.getBoolean("m10")==true){ bodega.add(boVehiculosnuevos);          bod += 1;}
                
                if(rs.getBoolean("m11")==true){         sistema.add(configuraciones);   sis += 1;}
                if(rs.getBoolean("m12")==true){         sistema.add(usuarios);          sis += 1;}
                if(rs.getBoolean("agencias")==true){    sistema.add(agencias);          sis += 1;}
                sistema.add(new JSeparator());
                if(rs.getBoolean("dataanalice")==true){    sistema.add(dataanalice);          sis += 1;}
            }
            try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        
        //registro.add(rlavado);
        
        if(sis!=0)sesion.add(sistema);
        sesion.add(contrasena);
        sesion.add(rmenu);
        sesion.add(new JSeparator());
        sesion.add(Escritorio.jMenuItem1);
        sesion.add(salir);
        
        if(reg!=0)menu.add(registro);
        if(bit!=0)menu.add(bitacora);
        if(bod!=0)menu.add(bodega);
        menu.add(sesion);
        
        reg = bit = bod = sis = 0;
        return menu;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Recargar menu":
                menu();
                break;
            case "Salir":
                System.exit(0);
                break;
// REGISTRO --------------------------------------------------------------------
            case "Limpieza":
                new Thread(() -> { new other.mostrarFrame().mostrar(new rLimpieza.Panel()); }).start();
                break;
            case "Practicantes":
                new Thread(() -> { new other.mostrarFrame().mostrar(new rPracticantes.Panel()); }).start();
                break;
            case "Visitantes":
                new Thread(() -> { new other.mostrarFrame().mostrar(new rVisitantes.Panel()); }).start();
                break;
            case "Lavado":
                new Thread(() -> { new other.mostrarFrame().mostrar(new rLavado.Panel()); }).start();
                break;
            case "Vehiculos demo":
                new Thread(() -> { new other.mostrarFrame().mostrar(new rDemos.Panel()); }).start();
                break;
// BITACORA --------------------------------------------------------------------
            case "Limpieza.":
                new Thread(() -> { new other.mostrarFrame().mostrar(new bLimpieza.Lista()); }).start();
                break;
            case "Lavado.":
                new Thread(() -> { new other.mostrarFrame().mostrar(new bLavado.Panel()); }).start();
                break;
            case "Practicantes.":
                new Thread(() -> { new other.mostrarFrame().mostrar(new bPracticantes.Lista()); }).start();
                break;
            case "Vehiculos":
                new Thread(() -> { new other.mostrarFrame().mostrar(new bVehiculosServicio.Lista()); }).start();
                break;
            case "Visitantes.":
                new Thread(() -> { new other.mostrarFrame().mostrar(new bVisitantes.Lista()); }).start();
                break;
            case "Movimientos demos":
                new Thread(() -> { new other.mostrarFrame().mostrar(new bDemos.Lista()); }).start();
                break;
//------------------------------------------------------------------------------
            case "Vehiculos nuevos":
                new Thread(() -> { new other.mostrarFrame().mostrar(new bVehiculosNuevos.Lista()); }).start();
                break;
//------------------------------------------------------------------------------
            case "Configuraciones":
                new Thread(() -> { new other.mostrarFrame().mostrar(new Configuraciones.Configuraciones()); }).start();
                break;
            case "Usuarios":
                new Thread(() -> { new other.mostrarFrame().mostrar(new Usuarios.Lista()); }).start();
                break;
            case "Agencias":
                new Thread(() -> { new other.mostrarFrame().mostrar(new Agencias.Panel()); }).start();
                break;
            case "Cambiar contraseña":
                new Thread(() -> { new other.mostrarFrame().mostrar(new Inicio.contrasena()); }).start();
                break;
            case "Data analice":
                new Thread(() -> { new dataAnalice.Principal().setVisible(true); }).start();
                break;
        }
    }
    
}
