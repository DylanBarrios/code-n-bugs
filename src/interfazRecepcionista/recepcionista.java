/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazRecepcionista;

import backend.conexion;
import interfaz.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dylan
 */
public class recepcionista extends javax.swing.JFrame {

    /**
     * Creates new form Recepcionista
     */
    public recepcionista() {
        initComponents();
        this.setLocationRelativeTo(null);
        tablaPaquetes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        labelBuscar = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePaquetes = new javax.swing.JTable();
        dpPaquetes = new javax.swing.JDesktopPane();
        dpPaquetesPorEntregar = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemIngresar = new javax.swing.JMenuItem();
        itemEntregar = new javax.swing.JMenuItem();
        itemLocalizar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 200, 40));

        labelBuscar.setText("Nit Cliente");
        getContentPane().add(labelBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 0, 80, 60));

        tablePaquetes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablePaquetes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 58, 750, 490));
        getContentPane().add(dpPaquetes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 742, 600));
        getContentPane().add(dpPaquetesPorEntregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 0, 760, 600));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/orden.png"))); // NOI18N
        jMenu1.setText("Paquetes");

        itemIngresar.setText("Ingeresar paquete");
        itemIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIngresarActionPerformed(evt);
            }
        });
        jMenu1.add(itemIngresar);

        itemEntregar.setText("Entregar un paquete");
        jMenu1.add(itemEntregar);

        itemLocalizar.setText("Localizar paquete");
        itemLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLocalizarActionPerformed(evt);
            }
        });
        jMenu1.add(itemLocalizar);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clientes.png"))); // NOI18N
        jMenu2.setText("Clientes");

        jMenuItem1.setText("Crear cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Ver paquetes sin entregar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIngresarActionPerformed
        dpPaquetes.removeAll();
        dpPaquetes.repaint();
        ingresarPaquete ip = new ingresarPaquete();
        dpPaquetes.add(ip);
        ip.show();
    }//GEN-LAST:event_itemIngresarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        crearCliente();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        tablaPaquetes();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void itemLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLocalizarActionPerformed
        
    }//GEN-LAST:event_itemLocalizarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            Connection conectar = conexion.conectar();
            String datos = "SELECT IdPaquete, NitCLiente, Destino, Costo FROM Paquete WHERE NitCLiente LIKE '%"+txtBuscar.getText()+"%'"; 
            PreparedStatement pst = conectar.prepareStatement(datos);
            
            ResultSet rs = pst.executeQuery();
            
            tablePaquetes = new JTable(modelo);
            jScrollPane1.setViewportView(tablePaquetes);
            
            modelo.addColumn("Id paquete");
            modelo.addColumn("Nit del cliente");
            modelo.addColumn("Destino");
            modelo.addColumn("Costo");
            modelo.addColumn("Tiempo en ruta");
            modelo.addColumn("Localizacion");
            
                        
            while(rs.next()){
                Object[] fila = new Object[4];
                
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i +1);
                }
                modelo.addRow(fila);
            }
            conectar.close();
        } catch (SQLException e) {
            System.err.println("Error"+e);
            JOptionPane.showMessageDialog(null, "Error, notifique al administrador!!");
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        new login().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void crearCliente(){
        dpPaquetesPorEntregar.removeAll();
        dpPaquetesPorEntregar.repaint();
        tablePaquetes.setVisible(false);
        jScrollPane1.setVisible(false);
        labelBuscar.setVisible(false);
        txtBuscar.setVisible(false);
       
        
        CrearCliente cc = new CrearCliente();
        dpPaquetesPorEntregar.add(cc);
        cc.show();
    }
    
    
    public void tablaPaquetes(){
        dpPaquetesPorEntregar.removeAll();
        tablePaquetes.setVisible(true);
        jScrollPane1.setVisible(true);
        labelBuscar.setVisible(true);
        txtBuscar.setVisible(true);
        dpPaquetesPorEntregar.repaint();
        
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            Connection conectar = conexion.conectar();
            String datos = "SELECT IdPaquete, NitCLiente, Destino, Costo, TiempoEnRuta,"
                    + "Localizacion FROM Paquete WHERE EstadoPaquete = 0"; 
            PreparedStatement pst = conectar.prepareStatement(datos);
            
            ResultSet rs = pst.executeQuery();
            
            tablePaquetes = new JTable(modelo);
            jScrollPane1.setViewportView(tablePaquetes);
            
            modelo.addColumn("Id paquete");
            modelo.addColumn("Nit del cliente");
            modelo.addColumn("Destino");
            modelo.addColumn("Costo");
            modelo.addColumn("Tiempo en ruta (horas)");
            modelo.addColumn("Localizacion");
            
                        
            while(rs.next()){
                Object[] fila = new Object[6];
                
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i +1);
                }
                modelo.addRow(fila);
            }
            conectar.close();
        } catch (SQLException e) {
            System.err.println("Error"+e);
            JOptionPane.showMessageDialog(null, "Error, notifique al administrador!!");
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpPaquetes;
    public javax.swing.JDesktopPane dpPaquetesPorEntregar;
    private javax.swing.JMenuItem itemEntregar;
    private javax.swing.JMenuItem itemIngresar;
    private javax.swing.JMenuItem itemLocalizar;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JTable tablePaquetes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
