/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bVehiculosNuevos;

import Conexion.Conector;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ChristianArias
 */
public final class Movimientos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Movimientos
     */
    int id = 0;
    int kmfin = 0,kmini = 0;
    //int sel = 0;
    
    public Movimientos(int sel) {
        initComponents();
        setSize(800,300);
        id = sel;
        modelo();
        setCellRenderer(jTable1);
        ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
            timer.scheduleAtFixedRate(tarea, 1, 80, TimeUnit.SECONDS);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();

        setMaximizable(true);
        setResizable(true);
        setTitle("Movimientos");

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jTable1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
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

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jMenu2.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Agregar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenu3.setText("Exportar");

        jMenuItem3.setText("Excel");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenu2.add(jMenu3);
        jMenu2.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        if(row!=-1){
            try{
                kmfin = Integer.parseInt(String.valueOf(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 4)));
                jTextField2.setText(kmfin+"");
            }catch(NumberFormatException e){
                kmfin = 0;
                jTextField2.setText(kmfin+"");
            }
            int sel = Integer.parseInt(String.valueOf(jTable1.getModel().getValueAt(row, 0)));
            switch(evt.getClickCount()){
                case 2:
                    
                    switch(col){
                        case 8:
                            kmfinal(sel);
                            break;
                        default:
                            new Thread(() -> {new other.mostrarFrame().mostrar(new nuevoMovimiento(sel,0));}).start();
                            break;
                    }
                    break;
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        jTable1.setModel(cargar());
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new Thread(() -> {new other.mostrarFrame().mostrar(new nuevoMovimiento(0,id));}).start();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //javax.swing.JTable[] tablas = {jTable1};
        DefaultTableModel[] tablas = {(DefaultTableModel)jTable1.getModel()};
        new other.exportarTxt().exportar(tablas, getTitle(),"txt");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void setCellRenderer(JTable jTable1) {
        Enumeration<TableColumn> en = jTable1.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new other.CellRenderer());
        }
    }
    
    void modelo(){
        //String titulos[] = {"id","Vehiculo","Nombre","KM","Destino","Comentarios","Fecha"};
        String titulos[] = null ;
        if(Inicio.Sesion.admin){
            titulos = new String[12];
                titulos[0] = "";
                titulos[1] = "Vehiculo";
                titulos[2] = "Nombre";
                titulos[3] = "KM inicial";
                titulos[4] = "KM final";
                titulos[5] = "Destino";
                titulos[6] = "Comentarios";
                titulos[7] = "Fecha de salida";
                titulos[8] = "Fecha de llegada";
                titulos[9] = "Creo";
                titulos[10] = "Actualizo";
                titulos[11] = "Fecha";
        }else{
            titulos = new String[9];
                titulos[0] = "";
                titulos[1] = "Vehiculo";
                titulos[2] = "Nombre";
                titulos[3] = "KM inicial";
                titulos[4] = "KM final";
                titulos[5] = "Destino";
                titulos[6] = "Comentarios";
                titulos[7] = "Fecha de salida";
                titulos[8] = "Fecha de llegada";
        }
        DefaultTableModel model = new DefaultTableModel(null,titulos);
        jTable1.setModel(model);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    DefaultTableModel cargar(){
        int movimientos = 0;
        Connection cn = Conector.conexion();
        DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
        try{//3317505724 Valentin
            String sql = "SELECT * FROM vistavehiculosnuevosmovimientos WHERE idVehiculo = ? AND (nombre LIKE ?)"
                    + "ORDER BY concat(fecha,' ',hora) DESC";
            Object [] registros = new Object [jTable1.getColumnCount()];
            int x = 0;
            String aux = null;
            model.setRowCount(0);
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                pst.setString(2, "%"+jTextField1.getText()+"%");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                setTitle("Movimientos "+rs.getString("tipo"));
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("tipo");
                registros[2] = rs.getString("nombre");
                registros[3] = rs.getString("km");
                registros[4] = rs.getString("kmfinal");
                registros[5] = rs.getString("destino");
                registros[6] = rs.getString("comentarios");
                registros[7] = rs.getString("fecha")+" "+rs.getString("hora");
                registros[8] = rs.getString("llegada");
                if(Inicio.Sesion.admin){
                    registros[9] = rs.getString("creador");
                    registros[10] = rs.getString("editor");
                    registros[11] = rs.getString("fechaAct");
                }
                movimientos += 1;
                model.addRow(registros);
                x = rs.getRow();
                aux = Integer.toString(x);
            }
            model.fireTableDataChanged();
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        /*try{
            if(movimientos == 0){
                dispose();
                Logs.emergente.mostrar("Sin movimientos", "Mensaje");
            }
        }catch(Exception e){
            //new Logs.Error().error(e.getMessage());
        }*/
        try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
        return model;
    }
    
    void kmfinal(int sel){
        Object[] option = {"Aceptar","Cancelar"};
        int x =  JOptionPane.showOptionDialog(null,jTextField2,"Kilometraje final",JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,null, option, option[0]);
        String texto = jTextField2.getText();
        if(x==JOptionPane.YES_OPTION){
            if(texto.isEmpty()){
                Logs.emergente.mostrar("Kilometraje vacio", "Mensaje");
            }else{
                llegada(sel,Integer.parseInt(texto));
            }
        }
    }
    
    public void llegada(int sel,int km){
        Connection cn = Conector.conexion();
        try{
            String sql = "UPDATE vehiculosnuevosmovimientos SET llegada = now(),edito = ?,fechaAct = now(),kmfinal = ? "
                    + "WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, Inicio.Sesion.id);
                pst.setInt(2, km);
                pst.setInt(3, sel);
            int n = pst.executeUpdate();
            if(n>0){
                cargar();
            }
        }catch(SQLException e){
            new Logs.Error().error(e.getMessage());
        }
        try{ cn.close(); }catch(SQLException e){ new Logs.Error().error(e.getMessage()); }
    }
    
    public Runnable tarea = () -> { load(); };
    
    public void load(){ jTable1.setModel(cargar()); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}