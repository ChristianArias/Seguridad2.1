/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rLimpieza;

import Conexion.Conector;
import Inicio.Sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ChristianArias
 */
public final class Panel extends javax.swing.JInternalFrame {

    /**
     * Creates new form Panel
     */
    public Panel() {
        initComponents();
        modelo();
        setCellRenderer(jTable1);
        jTable1.setModel(cargar());
        setTitle("Personal limpieza "+Sesion.nombreagencia);
        jLabel1.setText(Sesion.nombreagencia);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setTitle("Personal limpieza");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("jLabel1");

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new Thread(() -> { new other.mostrarFrame().mostrar(new Nuevo(0)); }).start();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        cargar();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        if(row!=-1){
            int sel = Integer.parseInt(String.valueOf(jTable1.getModel().getValueAt(row, 0)));
            switch(evt.getClickCount()){
                case 2:
                    new Thread(() -> { new other.mostrarFrame().mostrar(new Nuevo(sel)); }).start();
                    break;
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    public void setCellRenderer(JTable jTable1) {
        Enumeration<TableColumn> en = jTable1.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new other.CellRenderer());
        }
    }
    
    void modelo(){
        String titulos[] = null ;
        if(Inicio.Sesion.admin){
            titulos = new String[8];
                titulos[0] = "";
                titulos[1] = "Nombre";
                titulos[2] = "Agencia";
                titulos[3] = "Contacto";
                titulos[4] = "Comentarios";
                titulos[5] = "Creo";
                titulos[6] = "Actualizo";
                titulos[7] = "Fecha";
        }else{
            titulos = new String[5];
                titulos[0] = "";
                titulos[1] = "Nombre";
                titulos[2] = "Agencia";
                titulos[3] = "Contacto";
                titulos[4] = "Comentarios";
        }
        jTable1.setModel(new DefaultTableModel(null,titulos));
        if(!Inicio.Sesion.admin){
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        }
    }
    
    DefaultTableModel cargar(){
        Connection cn = Conector.conexion();
        
        DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
        try{
            String sql = "SELECT * FROM vistalimpieza WHERE (nombre LIKE ?) AND _agencia LIKE ?";
            
            String [] registros = new String [jTable1.getColumnCount()];
            int x = 0;
            String aux = null;
            model.setRowCount(0);
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%"+jTextField1.getText()+"%");
                pst.setString(2, "%"+Sesion.nombreagencia+"%");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("_agencia");
                registros[3] = rs.getString("contacto");
                registros[4] = rs.getString("comentarios");
                if(Inicio.Sesion.admin){
                    registros[5] = rs.getString("creador");
                    registros[6] = rs.getString("editor");
                    registros[7] = rs.getString("fechaAct");
                }
                model.addRow(registros);
                x = rs.getRow();
                aux = Integer.toString(x);
            }
            model.fireTableDataChanged();
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        return model;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
