/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Conexion.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

/**
 *
 * @author ChristianArias
 */
public final class UsuariosLista extends javax.swing.JInternalFrame {

    /**
     * Creates new form Permisos2
     * @param texto
     */
    public UsuariosLista(String texto) {
        initComponents();
        jTextField1.setText(texto);
        jList1.setModel(modelo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();

        setTitle("Usuarios(Selecciona un usuario)");

        jList1.setToolTipText("Doble click en algun usuario para continuar");
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        jList1.setModel(modelo());
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if(jList1.getSelectedIndex()!=-1){
            if(evt.getClickCount()==2){
                DefaultListModel model = (DefaultListModel)jList1.getModel();
                valor v = (valor)model.elementAt(jList1.getSelectedIndex());
                new Thread(() -> {new other.mostrarFrame().mostrar(new Usuarios.Permisos(v.getID()));}).start();
            }
        }
    }//GEN-LAST:event_jList1MouseClicked

    DefaultListModel modelo(){
        Connection cn = Conector.conexion();
        DefaultListModel model = new DefaultListModel();//AND id NOT LIKE ? AND usuario NOT LIKE ?
        try{
            String sql = "SELECT * FROM vistausuarios WHERE (nombre LIKE ? OR usuario LIKE ?) "
                    + "AND id NOT LIKE ? AND usuario NOT LIKE ? AND activo != 0";
            
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%"+jTextField1.getText()+"%");
                pst.setString(2, "%"+jTextField1.getText()+"%");
                pst.setInt(3, Inicio.Sesion.id);
                pst.setString(4, "root");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                model.addElement(
                        new valor(
                                rs.getInt("id"),rs.getString("nombre") + 
                                        "("+rs.getString("usuario")+ " - " + rs.getString("_agencia")+ ")",""));
            }
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
        return model;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public class valor {
        private final int id ;
        private final String nombre;
        private final String dato;
  
        public valor(int id,String nombre,String dato) {
            this.id         =   id;
            this.nombre     =   nombre;
            this.dato       =   dato;
        }
 
        public int getID(){
            return id ;
        }
 
        @Override
        public String toString() {
            return nombre ;
        }
        
        public String getDato(){
            return dato;
        }
    }
    
}
