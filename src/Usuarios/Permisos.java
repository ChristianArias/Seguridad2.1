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
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author ChristianArias
 */
public final class Permisos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Permisos
     * @param sel
     */
    int id = 0;
    String value = "",update = "",name = "";
    
    public Permisos(int sel) {
        initComponents();
        id = sel;
        cargarModulos(sel);
        cargar(sel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jCheckBox13 = new javax.swing.JCheckBox();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText(" ");
        jTextField1.setFocusable(false);

        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 10))); // NOI18N

        jCheckBox2.setText("Limpieza");
        jCheckBox2.setFocusable(false);
        jCheckBox2.setName("m0"); // NOI18N

        jCheckBox3.setText("Practicantes");
        jCheckBox3.setFocusable(false);
        jCheckBox3.setName("m1"); // NOI18N

        jCheckBox4.setText("Visitantes");
        jCheckBox4.setFocusable(false);
        jCheckBox4.setName("m2"); // NOI18N

        jCheckBox5.setText("Vehiculos demo");
        jCheckBox5.setFocusable(false);
        jCheckBox5.setName("m3"); // NOI18N

        jCheckBox6.setText("Lavado");
        jCheckBox6.setFocusable(false);
        jCheckBox6.setName("rLavado"); // NOI18N

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bitacora", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 10))); // NOI18N

        jCheckBox7.setText("Limpieza");
        jCheckBox7.setFocusable(false);
        jCheckBox7.setName("m4"); // NOI18N

        jCheckBox8.setText("Movimientos demo");
        jCheckBox8.setFocusable(false);
        jCheckBox8.setName("m8"); // NOI18N

        jCheckBox9.setText("Practicantes");
        jCheckBox9.setFocusable(false);
        jCheckBox9.setName("m5"); // NOI18N

        jCheckBox10.setText("Vehiculos");
        jCheckBox10.setFocusable(false);
        jCheckBox10.setName("m6"); // NOI18N

        jCheckBox11.setText("Visitantes");
        jCheckBox11.setFocusable(false);
        jCheckBox11.setName("m7"); // NOI18N

        jCheckBox12.setText("Lavado");
        jCheckBox12.setFocusable(false);
        jCheckBox12.setName("blavado"); // NOI18N

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bodega", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 10))); // NOI18N

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jCheckBox13.setText("Vehiculos nuevos");
        jCheckBox13.setFocusable(false);
        jCheckBox13.setName("m10"); // NOI18N

        jSeparator7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sistema", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 10))); // NOI18N

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jCheckBox14.setText("Configuraciones");
        jCheckBox14.setFocusable(false);
        jCheckBox14.setName("m11"); // NOI18N

        jCheckBox15.setText("Usuarios");
        jCheckBox15.setFocusable(false);
        jCheckBox15.setName("m12"); // NOI18N

        jCheckBox16.setText("Agencias");
        jCheckBox16.setFocusable(false);
        jCheckBox16.setName("agencias"); // NOI18N

        jCheckBox17.setText("DataBase Query");
        jCheckBox17.setFocusable(false);
        jCheckBox17.setName("dataanalice"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jCheckBox6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator3)
                    .addComponent(jCheckBox7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox8, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jCheckBox12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addComponent(jCheckBox13, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7)
                    .addComponent(jCheckBox14, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jCheckBox15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox17)))
                        .addGap(0, 69, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jCheckBox1.setText("Todos");
        jCheckBox1.setFocusable(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
            jCheckBox1.setText("Ninguno");
            seleccionar(jPanel1,true);
        }else{
            jCheckBox1.setText("Todos");
            seleccionar(jPanel1,false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    void seleccionar(JPanel p,boolean bol){
        for(int x = 0; x<p.getComponentCount();x++){
            if(p.getComponent(x)instanceof JCheckBox){
                JCheckBox check = (JCheckBox) p.getComponent(x);
                check.setSelected(bol);
            }
        }
    }
    
    void cargar(int sel){
        try{
            String sql = "SELECT * FROM seg_usuario WHERE id = "+sel;
            ResultSet rs = new Mysql.ResultSet().rs(sql).executeQuery();
            while(rs.next()){
                jTextField1.setText(rs.getString("nombre")+" ["+rs.getString("usuario")+"]");
                setTitle("Permisos a "+rs.getString("usuario"));
            }
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
    }
    
    void obtener(){
        value = name = update = "";
        for(int c = 0; c<jPanel1.getComponentCount();c++){
            if(jPanel1.getComponent(c)instanceof JCheckBox){
                JCheckBox check = (JCheckBox) jPanel1.getComponent(c);
                value   += check.getName()+" = "+check.isSelected()+",";
                name    += check.getName()+",";
                update  += check.isSelected()+",";
            }
        }
        name = name.substring(0, name.length()-1);
        value = value.substring(0, value.length()-1);
        update = update.substring(0, update.length()-1);
    }
    
    void guardar(){
        obtener();
        Connection cn = Conector.conexion();
        try{
            String sql = "INSERT INTO seg_usuariopermisos(usuario,"+name+")"
                    +   "VALUES("+id+","+value+") "
                    +   "ON DUPLICATE KEY UPDATE "+value;
            PreparedStatement  pst = cn.prepareStatement(sql);
            int n = pst.executeUpdate();
            if(n>0){
                Logs.emergente.mostrar("Permisos actualizados", "Mensaje");
                dispose();
            }
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
    }
    
    void cargarModulos(int sel){
        Connection cn = Conector.conexion();
        try{
            String sql = "SELECT * FROM seg_usuariopermisos WHERE usuario = ?";
            PreparedStatement  pst = cn.prepareStatement(sql);
                pst.setInt(1, sel);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                //Registro
                jCheckBox2.setSelected(rs.getBoolean("m0"));//Limpieza          ok
                jCheckBox3.setSelected(rs.getBoolean("m1"));//Practicantes      ok
                jCheckBox4.setSelected(rs.getBoolean("m2"));//Visitantes        ok
                jCheckBox5.setSelected(rs.getBoolean("m3"));//Vehiculos demo    ok
                jCheckBox6.setSelected(rs.getBoolean("rlavado"));//lavado
                //bitacora
                jCheckBox7.setSelected(rs.getBoolean("m4"));//Limpieza          ok
                jCheckBox9.setSelected(rs.getBoolean("m5"));//Practicantes      ok
                jCheckBox10.setSelected(rs.getBoolean("m6"));//Vehiculos        ok
                jCheckBox11.setSelected(rs.getBoolean("m7"));//Visitantes       ok
                jCheckBox8.setSelected(rs.getBoolean("m8"));//Movimientos demo  ok
                jCheckBox12.setSelected(rs.getBoolean("blavado"));//Lavado      ok
                //Bodega
                jCheckBox13.setSelected(rs.getBoolean("m10"));//Vehiculos nuevos    ok
                //Sistema
                jCheckBox14.setSelected(rs.getBoolean("m11"));//Configuraciones ok
                jCheckBox15.setSelected(rs.getBoolean("m12"));//Usuarios        ok
                jCheckBox16.setSelected(rs.getBoolean("agencias"));//Agencias   ok
                jCheckBox17.setSelected(rs.getBoolean("dataanalice"));//DB analice ok
            }
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
