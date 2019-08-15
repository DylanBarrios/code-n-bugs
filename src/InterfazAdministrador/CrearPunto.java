package InterfazAdministrador;
import backend.conexion;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class CrearPunto extends javax.swing.JInternalFrame {
    Connection conecta = conexion.conectar();
    
    public CrearPunto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxOperario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtPrecioHora = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();

        jLabel1.setText("Operario");

        jLabel3.setText("Precio por hora");

        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPrecioHora, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrecioHora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        crearPunto();
    }//GEN-LAST:event_btnCrearActionPerformed

        public void crearPunto(){
        int precioHora = Integer.parseInt(txtPrecioHora.getText());
         String operario = (String) cbxOperario.getSelectedItem();

        try {
            String datos =  "INSERT INTO PuntoControl VALUES(?,?,?,?)";
           
            PreparedStatement pst = conecta.prepareStatement(datos);

                pst.setInt(1, 0);
                pst.setBoolean(2, true);
                pst.setString(3, operario);
                pst.setInt(4, precioHora);
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Punto de control establecido");
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error "+e);
        }
    }
    
    public ArrayList<String> operarios(){
        ArrayList<String> list = new ArrayList<String>();
        String datos = "SELECT Rol, Nombre FROM Usuarios";
        
        try {
                PreparedStatement ps = conecta.prepareStatement(datos);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    if(rs.getString("Rol").equals("Operador"))
                    list.add(rs.getString("Nombre"));
                }
        } catch (SQLException e) {
        }
    return list;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    public javax.swing.JComboBox<String> cbxOperario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtPrecioHora;
    // End of variables declaration//GEN-END:variables
}
