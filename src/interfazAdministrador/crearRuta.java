package interfazAdministrador;
import backend.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class crearRuta extends javax.swing.JInternalFrame {

    public crearRuta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        CrearRuta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtPrecioPriorizacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecioDestino = new javax.swing.JTextField();
        txtPrecioLibra = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Creacion de nueva ruta");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 36, 200, 40));

        CrearRuta.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        CrearRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mas.png"))); // NOI18N
        CrearRuta.setBorder(null);
        CrearRuta.setContentAreaFilled(false);
        CrearRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearRutaActionPerformed(evt);
            }
        });
        getContentPane().add(CrearRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 179, 65));

        jLabel3.setText("Nombre de la ruta:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        jLabel1.setText("Destino de la ruta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 83, -1, -1));
        getContentPane().add(txtDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 106, 200, 40));

        jLabel4.setText("Estado de la ruta:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 154, -1, -1));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 178, 180, 40));

        jLabel2.setText("Precio de priorizacion:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 82, -1, -1));
        getContentPane().add(txtPrecioPriorizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 102, 180, 40));

        jLabel5.setText("Precio del destino");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 154, -1, -1));

        jLabel6.setText("Precio por libra:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 12, -1, -1));
        getContentPane().add(txtPrecioDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 178, 200, 40));
        getContentPane().add(txtPrecioLibra, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 180, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearRutaActionPerformed
        if(txtDestino.getText().equals("") || txtNombre.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos");
        else{
            crearRuta();
            limpiar();
        }
    }//GEN-LAST:event_CrearRutaActionPerformed

  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CrearRuta;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioDestino;
    private javax.swing.JTextField txtPrecioLibra;
    private javax.swing.JTextField txtPrecioPriorizacion;
    // End of variables declaration//GEN-END:variables

      public void crearRuta(){
        String nombre = txtNombre.getText();
        String destino = txtDestino.getText();
        float precioDestino = Float.parseFloat(txtPrecioDestino.getText());
        float precioLibra = Float.parseFloat(txtPrecioLibra.getText());
        float precioPriorizacion = Float.parseFloat(txtPrecioPriorizacion.getText());
        
        
        String stringEstado = "";
        int estado = cbxEstado.getSelectedIndex();
            
        if(estado == 0)
            stringEstado = "Activo";
        else if(estado == 1)
            stringEstado = "Inactivo";
        
        
        try {
            Connection conectar = conexion.conectar();
            
            String datos = "INSERT INTO Rutas VALUES(?,?,?,?,?,?,?)";
            
            PreparedStatement pst = conectar.prepareStatement(datos);
            
            pst.setInt(1, 0);
            pst.setString(2, nombre);
            pst.setString(3, destino);
            pst.setString(4, stringEstado);
            pst.setFloat(5, precioDestino);
            pst.setFloat(6, precioLibra);
            pst.setFloat(7, precioPriorizacion);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Ruta nueva creada");
            
        } catch (SQLException e) {
            System.out.println("error "+e);
        }
        
    }
      
    public void limpiar(){
        txtDestino.setText("");
        txtNombre.setText("");
        txtPrecioLibra.setText("");
        txtPrecioDestino.setText("");
        txtPrecioPriorizacion.setText("");
    }
}
