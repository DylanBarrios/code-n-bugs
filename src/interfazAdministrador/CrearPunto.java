package interfazAdministrador;
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
        operarios();
        rutas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxRuta = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtPrecioHora = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbxOperador = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();

        setClosable(true);

        jLabel1.setText("Ruta a la que pertenece:");

        jLabel3.setText("Precio por hora");

        txtPrecioHora.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N

        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jLabel2.setText("Operador:");

        jLabel4.setText("Estado:");

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
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
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxRuta, 0, 228, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPrecioHora, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbxOperador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtPrecioHora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        if(txtPrecioHora.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Por favor ingre el precio por hora");
        else{
            crearPunto();
            txtPrecioHora.setText("");}
    }//GEN-LAST:event_btnCrearActionPerformed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoActionPerformed

        public void crearPunto(){
        int precioHora = Integer.parseInt(txtPrecioHora.getText());
        String operario = (String) cbxRuta.getSelectedItem();
        
        String datos;
        String nombreRuta = cbxRuta.getSelectedItem().toString();
        String nombreUsuario = cbxOperador.getSelectedItem().toString();
        String stringEstado = "";
        int estado = cbxEstado.getSelectedIndex();
        int IdUsuario = 0;
        int IdRuta = 0;
        
        try {
            //Agrega el Id de l aruta
            datos = "SELECT IdRuta FROM Rutas WHERE NombreRuta = '"+nombreRuta+"'";
            PreparedStatement pst = conecta.prepareStatement(datos);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
            IdRuta = rs.getInt("IdRuta"); 
            }
            //Agrega el Id del usuario 
            datos = "SELECT IdUsuario FROM Usuario WHERE NombreUsuario = '"+nombreUsuario+"'";
            pst = conecta.prepareStatement(datos);
            rs = pst.executeQuery();
            while(rs.next()){
            IdUsuario = rs.getInt("IdUsuario"); 
            }
            //Se llena la base de datos
            datos = "INSERT INTO PuntoControl VALUES(?,?,?,?,?)";
            pst = conecta.prepareStatement(datos);

            if(estado == 0)
                stringEstado = "Activo";
            if(estado == 1)
                stringEstado = "Inactivo";
            
            
            pst.setInt(1, 0);
            pst.setInt(2, IdRuta);
            pst.setInt(3, IdUsuario);
            pst.setString(4, stringEstado);
            pst.setDouble(5, precioHora);
            pst.executeUpdate();
                
            JOptionPane.showMessageDialog(null, "Punto de control establecido");
        
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error "+e);
        }
    }
    
    public void operarios(){
        ArrayList<String> list = new ArrayList<String>();
        String datos = "SELECT Rol, NombreUsuario FROM Usuario";
        
        try {
                PreparedStatement ps = conecta.prepareStatement(datos);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    if(rs.getString("Rol").equals("Operador"))
                    list.add(rs.getString("NombreUsuario"));
                }
                
                for(int i =0; i<list.size(); i++){
                    cbxOperador.addItem(list.get(i));
                }
    
        } catch (SQLException e) {
            System.out.println("Error "+e);
        }    
    }
    
    public void rutas(){
        ArrayList<String> list = new ArrayList<String>();
        String datos = "SELECT NombreRuta FROM Rutas";
        
        try {
                PreparedStatement ps = conecta.prepareStatement(datos);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    list.add(rs.getString("NombreRuta"));
                }
                
                for(int i =0; i<list.size(); i++){
                    cbxRuta.addItem(list.get(i));
                }
    
        } catch (SQLException e) {
            System.out.println("Error "+e);
        }    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxOperador;
    public javax.swing.JComboBox<String> cbxRuta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtPrecioHora;
    // End of variables declaration//GEN-END:variables
}
