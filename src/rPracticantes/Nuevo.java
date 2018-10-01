/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rPracticantes;

import Conexion.Conector;
import Inicio.Sesion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ChristianArias
 */
public final class Nuevo extends javax.swing.JInternalFrame {

    /**
     * Creates new form Nuevo
     */
    String foto = "";
    int id = 0;
    
    public Nuevo(int sel) {
        initComponents();
        foto = Conexion.Conector.path()+"lib\\Iconos\\default.jpg";
        jComboBox1.setModel(model("SELECT * FROM agencias ORDER BY nombre"));
        jComboBox1.getModel().setSelectedItem(new valor(Sesion.idagencia,Sesion.nombreagencia));
        jComboBox2.setModel(model("SELECT * FROM areas ORDER BY nombre"));
        switch(sel){
            case 0:
                imagen(foto);
                jButton3.setVisible(false);
                jButton4.setVisible(false);
                setTitle("Agregar practicante");
                break;
            default:
                id = sel;
                cargar(sel);
                jButton1.setVisible(false);                
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbimagen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        lbimagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbimagen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbimagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbimagenMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel3.setText("Agencia");

        jComboBox1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel1.setText("* Nombre completo");

        nombre.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N

        jComboBox2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel4.setText("Area");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton4.setText("Eliminar");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton3.setText("Editar");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comentarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 10))); // NOI18N
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbimagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbimagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbimagenMouseClicked
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG,PNG","jpg","png");
        String res = new other.buscarArchivo().f(filtro, foto);
        if(!res.isEmpty() || res != null){
            foto = res;
            imagen(foto);
        }
    }//GEN-LAST:event_lbimagenMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "¿Eliminar este registro?", "titulo", JOptionPane.YES_NO_OPTION);
        if(x == JOptionPane.YES_OPTION){
            eliminar(id);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        actualizar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(nombre.getText().length()!=0){
            agregar();
        }else{
            Logs.emergente.mostrar("Nombre no puede ir vacio", "Alerta");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        if(!Sesion.admin){jComboBox1.setEnabled(false);}
    }//GEN-LAST:event_formInternalFrameActivated

    DefaultComboBoxModel model(String sql){
        Connection cn = Conector.conexion();
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        try{
            ResultSet rs = cn.prepareStatement(sql).executeQuery();
            while(rs.next()){
                m.addElement(new valor(rs.getInt(1),rs.getString(2)));
            }
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        return m;
    }
    
    void imagen(String imagen){
        Image icon = Toolkit.getDefaultToolkit().createImage(imagen);
        ImageIcon img = new ImageIcon(icon);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(125,145, Image.SCALE_SMOOTH));
        lbimagen.setIcon(icono);
    }
    
    void eliminar(int sel){
        Connection cn = Conector.conexion();
        try{
            //DELETE FROM seg_limpieza WHERE id = ?
            String sql = "UPDATE seg_practicantes SET activo = 0 WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, sel);
            int n = pst.executeUpdate();
            if(n>0){
                dispose();
            }
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
    }
    
    void cargar(int sel){
        Connection cn = Conector.conexion();
        try{
            String sql = "SELECT * FROM vistaPracticantes WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, sel);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                nombre.setText(rs.getString("nombre"));
                jTextArea1.setText(rs.getString("comentarios"));
                foto = rs.getString("foto");
                imagen(foto);
                jComboBox1.getModel().setSelectedItem(new valor(rs.getInt("agencia"),rs.getString("_agencia")));
                jComboBox2.getModel().setSelectedItem(new valor(rs.getInt("area"),rs.getString("_area")));
                setTitle("Practicante "+rs.getString("Nombre")+" ("+rs.getString("_area")+")");
            }
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
    }
    
    void actualizar(){
        Connection cn = Conector.conexion();
        try{
            valor agencia   = (valor)jComboBox1.getSelectedItem();
            valor area      = (valor)jComboBox2.getSelectedItem();
            String img = other.copy.copy(
                    Configuraciones.Rutas.practicantes,
                    foto,
                    nombre.getText()
            );
            
            String sql = "UPDATE seg_practicantes SET "
                    + "nombre = ?,Area = ?,comentarios = ?,foto = ?,edito = ?,fechaAct = now(),agencia = ? WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, nombre.getText());//nombre
                pst.setInt(2, area.getID());//area
                pst.setString(3, jTextArea1.getText());//comentarios
                pst.setString(4, img);//imagen
                pst.setInt(5, Inicio.Sesion.id);
                pst.setInt(6, agencia.getID());
                pst.setInt(7, id);
            int n = pst.executeUpdate();
            if( n > 0 ){
                Logs.emergente.mostrar("Se ah actualizado", "Mensaje");
                dispose();
            }
            cn.close();
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
    }
    
    void agregar(){
        Connection cn = Conector.conexion();
        try{
            valor agencia   = (valor)jComboBox1.getSelectedItem();
            valor area      = (valor)jComboBox2.getSelectedItem();
            String img = other.copy.copy(
                    Configuraciones.Rutas.practicantes,
                    foto,
                    nombre.getText()
            );
            String sql = "INSERT INTO seg_practicantes "
                    + "(nombre,area,comentarios,foto,creo,fechaAct,activo,agencia) "
                    + "VALUES (?,?,?,?,?,now(),1,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, nombre.getText());//nombre
                pst.setInt(2, area.getID());//Area
                pst.setString(3, jTextArea1.getText());//comentarios
                pst.setString(4,img);//imagen
                pst.setInt(5, Inicio.Sesion.id);
                pst.setInt(6, agencia.getID());
            int n = pst.executeUpdate();
            if( n > 0 ){
                Logs.emergente.mostrar("Se ah guardado", "Mensaje");
                dispose();
            }
            cn.close();
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbimagen;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
    
    public class valor {
        private final int id ;
        private final String nombre;
  
        public valor(int id,String nombre) {
            this.id         =   id;
            this.nombre     =   nombre;
        }
 
        public int getID(){
            return id ;
        }
 
        @Override
        public String toString() {
            return nombre ;
        }
    }
    
}