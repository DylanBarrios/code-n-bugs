package interfazRecepcionista;

import backend.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class entregarPaquete extends javax.swing.JInternalFrame {
    Connection conectar = conexion.conectar();

    public entregarPaquete() {
        initComponents();
        agregarPaquetes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbxPaquetes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jButton1.setText("Entregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Paquetes a entregar:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setText("ENTREGA DE PAQUETES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(cbxPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbxPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        entregar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxPaquetes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables


    public void agregarPaquetes(){
        String idPaquete;
        try {
            String datos = "SELECT Localizacion,Destino,IdPaquete FROM Paquete WHERE Destino = Localizacion AND EstadoPaquete=0"; 
            PreparedStatement pst = conectar.prepareStatement(datos);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                idPaquete = rs.getString("IdPaquete");
                cbxPaquetes.addItem(idPaquete);
            }
        } catch (SQLException e) {
            System.err.println("Error al llenar combo "+e);
            JOptionPane.showMessageDialog(null, "Error, notifique al administrador!!");
        }
        
    }
    
    public void entregar(){
        boolean estado;
        int idPaquete = Integer.parseInt(cbxPaquetes.getSelectedItem().toString());
        try {
            String datos = "UPDATE Paquete SET EstadoPaquete=1 WHERE IdPaquete ="+idPaquete; 
            PreparedStatement pst = conectar.prepareStatement(datos);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paquete entregado");
        } catch (SQLException e) {
            System.err.println("Error al llenar entregar "+e);
            JOptionPane.showMessageDialog(null, "Error, notifique al administrador!!");
        }
    }

}
