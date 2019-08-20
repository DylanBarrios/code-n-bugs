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

        setClosable(true);
        setTitle("Creacion de nueva ruta");

        txtNombre.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        CrearRuta.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        CrearRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mas.png"))); // NOI18N
        CrearRuta.setBorder(null);
        CrearRuta.setContentAreaFilled(false);
        CrearRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearRutaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre de la ruta:");

        jLabel1.setText("Destino de la ruta");

        jLabel4.setText("Estado de la ruta:");

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(CrearRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxEstado, 0, 200, Short.MAX_VALUE)
                            .addComponent(txtDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CrearRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearRutaActionPerformed
        if(txtDestino.getText().equals("") || txtNombre.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos");
        else{
            crearRuta();
            limpiar();}
    }//GEN-LAST:event_CrearRutaActionPerformed

  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CrearRuta;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

      public void crearRuta(){
        String nombre = txtNombre.getText();
        String destino = txtDestino.getText();
        String stringEstado = "";
        int estado = cbxEstado.getSelectedIndex();
            
        if(estado == 0)
            stringEstado = "Activo";
        else if(estado == 1)
            stringEstado = "Inactivo";
        
        
        try {
            Connection conectar = conexion.conectar();
            
            String datos = "INSERT INTO Rutas VALUES(?,?,?,?)";
            
            PreparedStatement pst = conectar.prepareStatement(datos);
            
            pst.setInt(1, 0);
            pst.setString(2, nombre);
            pst.setString(3, destino);
            pst.setString(4, stringEstado);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Ruta nueva creada");
            
        } catch (SQLException e) {
            System.out.println("error "+e);
        }
        
    }
      
    public void limpiar(){
        txtDestino.setText("");
        txtNombre.setText("");
    }
}
