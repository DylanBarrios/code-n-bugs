/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazRecepcionista;

import backend.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class localizarPaquete extends javax.swing.JInternalFrame {

        Connection conectar = conexion.conectar();

    public localizarPaquete() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtLocalizar = new javax.swing.JTextField();
        labelAviso = new javax.swing.JLabel();
        btnLocalizar = new javax.swing.JButton();

        jLabel1.setText("ID del paquete que desea localizar");

        txtLocalizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLocalizarKeyTyped(evt);
            }
        });

        labelAviso.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        btnLocalizar.setText("LOCALIZAR");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(btnLocalizar)))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        localizarPaquetes();
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void txtLocalizarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalizarKeyTyped
        char c=evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();  
    }//GEN-LAST:event_txtLocalizarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelAviso;
    private javax.swing.JTextField txtLocalizar;
    // End of variables declaration//GEN-END:variables

    /*
    //Metodo para saber donde se enceuntra un paquete deacuerdo al id del paquete que se pobtenga
    //del textField obteniendo la localizacion desde la base de datos
    */
    public void localizarPaquetes(){
        String idPaquete = txtLocalizar.getText();
        String localizacion="";
        try {
            String datos = "SELECT Localizacion FROM Paquete WHERE IdPaquete ="+idPaquete; 
            PreparedStatement pst = conectar.prepareStatement(datos); 
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                localizacion = rs.getString("Localizacion");
                labelAviso.setText("El paquete se encuentra en "+localizacion);
            }else{
                JOptionPane.showMessageDialog(null, "No hay ningun paquete con ese ID");
            }
        } catch (SQLException e) {
            System.err.println("Error al llenar combo "+e);
            JOptionPane.showMessageDialog(null, "Error, notifique al administrador!!");
        }
        
    }



}
