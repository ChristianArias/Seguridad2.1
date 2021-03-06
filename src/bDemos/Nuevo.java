/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bDemos;

import Conexion.Conector;
import Inicio.Sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ChristianArias
 */
public final class Nuevo extends javax.swing.JInternalFrame {

    /**
     * Creates new form Nuevo
     */    
    int idVehiculo = 0,registro = 0;
    SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
    String entrada = "";
    boolean activo = false;
    
    public Nuevo(int sel) {
        initComponents();
        modelo();
        jTextField5.setEnabled(false);
        jTextField6.setEnabled(false);
        jDateChooser2.setEnabled(false);
        switch(sel){
            case 0:
                jButton4.setVisible(false);
                jDateChooser1.setDate(new other.hora().date());
                jDateChooser2.setDate(new other.hora().date());
                jTextField4.setText(new other.hora().time());
                jTextField5.setText("00:00:00");
                break;
            default:
                jButton1.setEnabled(false);
                jButton2.setEnabled(false);
                cargar(sel);
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField7 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setTitle("Salida de unidad provisional");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel2.setText("* Conducido por");

        jTextField2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel4.setText("Fecha y Hora de salida");

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jDateChooser1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jTextField5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jDateChooser2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jCheckBox1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jCheckBox1.setText("Fecha y Hora de regreso");
        jCheckBox1.setFocusable(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setText("KM final");

        jTextField6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jTextField6.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField5)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(2, 2, 2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButton2.setText("Guardar");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButton4.setText("Actualizar");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel1.setText("KM inicial");

        jTextField3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jTextField3.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
            jTextField5.setEnabled(true);jTextField6.setEnabled(true);jDateChooser2.setEnabled(true);
            jTextField5.setText(new other.hora().time());activo = true;
        }else{
            jTextField5.setEnabled(false);jTextField6.setEnabled(false);jDateChooser2.setEnabled(false);
            jTextField5.setText("00:00:00");activo = false;
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTable1.setModel(cargarAutos());
        Object[] option = {"Aceptar","Cancelar"};
        int x =  JOptionPane.showOptionDialog(this,jPanel2,"Buscar",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,null, option, option[0]);
        if(x==JOptionPane.YES_OPTION){
            int row = jTable1.getSelectedRow();
            if(row!=-1){
                int sel = Integer.parseInt(String.valueOf(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0)));
                cargarInfoAuto(sel);
            }else{
                Logs.emergente.mostrar("No seleccionaste vehiculo", "Mensaje");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        jTable1.setModel(cargarAutos());
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(idVehiculo==0){
            Logs.emergente.mostrar("No has seleccionado un demo", "Mensaje");
        }else{
            if(jTextField2.getText().equals("")){
                Logs.emergente.mostrar("'Conducido por' no puede ir vacio", "Mensaje");
            }else{
                guardar();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        actualizar();
    }//GEN-LAST:event_jButton4ActionPerformed

    void modelo(){
        String titulos[] = {"id","Vehiculo","Serie","Placas"};
        jTable1.setModel(new DefaultTableModel(null,titulos));
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    DefaultTableModel cargarAutos(){
        boolean res = false;
        Connection cn = Conector.conexion();
        DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
        try{
            String sql = "SELECT * FROM vistademos WHERE "
                    + "(vehiculo LIKE ? OR serie LIKE ? OR placas LIKE ?) AND libre != 1 AND _agencia LIKE ?";
            
            String [] registros = new String [jTable1.getColumnCount()];
            int x = 0;
            String aux = null;
            model.setRowCount(0);
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%"+jTextField7.getText()+"%");
                pst.setString(2, "%"+jTextField7.getText()+"%");
                pst.setString(3, "%"+jTextField7.getText()+"%");
                pst.setString(4, "%"+Sesion.nombreagencia+"%");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                res = true;
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("vehiculo");
                registros[2] = rs.getString("serie");
                registros[3] = rs.getString("placas");
                
                model.addRow(registros);
                x = rs.getRow();
                aux = Integer.toString(x);
            }if(!res){
                Logs.emergente.mostrar("Sin vehiculos demos", "Mensaje");
            }
            model.fireTableDataChanged();
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
        return model;
    }
    
    void cargarInfoAuto(int sel){
        Connection cn = Conector.conexion();
        try{
            String sql = "SELECT * FROM seg_autosdemos WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, sel);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                idVehiculo = sel;
                jTextField1.setText(
                        "El vehiculo "+rs.getString("vehiculo")
                                + " serie "+rs.getString("serie")
                                + " placas "+rs.getString("placas"));
                setTitle("Movimiento demo "+rs.getString("vehiculo")+","+rs.getString("placas"));
            }
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
    }
    
    void guardar(){
        Connection cn = Conector.conexion();
        try{
            String sql = "INSERT INTO registrodemos "
                    + "(idDemo,conducido,horaSalida,fechaSalida,horaLlegada,fechaLlegada,kmini,kmfin,activo,creo,fechaAct) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,now())";
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, idVehiculo);
                pst.setString(2, jTextField2.getText());
                pst.setString(3, jTextField4.getText());
                pst.setString(4, String.valueOf(dcn.format(jDateChooser1.getDate())));//fechaEntrada
                pst.setString(5, jTextField5.getText());
                pst.setString(6, String.valueOf(dcn.format(jDateChooser2.getDate())));//fechaEntrada
                pst.setString(7, jTextField3.getText());
                pst.setString(8, jTextField6.getText());
                pst.setBoolean(9, activo);
                pst.setInt(10, Sesion.id);
            int n = pst.executeUpdate();
            if(n>0){
                if(jCheckBox1.isSelected())actEstado(false,idVehiculo); else actEstado(true,idVehiculo);
                dispose();
                Logs.emergente.mostrar("Guardado", "Mensaje");
            }
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
    }
    
    public void actEstado(boolean libre,int demo){
        Connection cn = Conector.conexion();
        try{
            String sql = "UPDATE seg_autosdemos SET libre = ? WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setBoolean(1, libre);
                pst.setInt(2, demo);
            int n = pst.executeUpdate();
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
    }
    
    void cargar(int sel){
        Connection cn = Conector.conexion();
        try{
            String sql = "SELECT * FROM registrodemos WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, sel);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                registro = sel;
                cargarInfoAuto(rs.getInt("idDemo"));
                jTextField2.setText(rs.getString("conducido"));
                jTextField3.setText(rs.getString("kmini"));
                jTextField4.setText(rs.getString("horaSalida"));
                jTextField5.setText(rs.getString("horaLlegada"));
                jTextField6.setText(rs.getString("kmfin"));
                jDateChooser1.setDate(rs.getDate("fechaSalida"));
                jDateChooser2.setDate(rs.getDate("fechaLlegada"));
            }
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
    }
    
    void actualizar(){
        Connection cn = Conector.conexion();
        try{
            String sql = "UPDATE registrodemos SET "
                    + "idDemo = ?,conducido = ?,horaSalida = ?,fechaSalida = ?,horaLlegada = ?,"
                    + "fechaLlegada = ?,kmini = ?,kmfin = ?,activo = ?,edito = ?,fechaAct = now()"
                    + "WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, idVehiculo);
                pst.setString(2, jTextField2.getText());
                pst.setString(3, jTextField4.getText());
                pst.setString(4, String.valueOf(dcn.format(jDateChooser1.getDate())));//fechaEntrada
                pst.setString(5, jTextField5.getText());
                pst.setString(6, String.valueOf(dcn.format(jDateChooser2.getDate())));//fechaEntrada
                pst.setString(7, jTextField3.getText());
                pst.setString(8, jTextField6.getText());
                pst.setBoolean(9, activo);
                pst.setInt(10, Sesion.id);
                pst.setInt(11, registro);
            int n = pst.executeUpdate();
            if(n>0){
                if(jCheckBox1.isSelected())actEstado(false,idVehiculo); else actEstado(true,idVehiculo);
                dispose();
                Logs.emergente.mostrar("Actualizado", "Mensaje");
            }
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
