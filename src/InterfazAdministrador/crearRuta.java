package InterfazAdministrador;
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

        txtLibra = new javax.swing.JTextField();
        txtPrioridad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CrearRuta = new javax.swing.JButton();

        setClosable(true);
        setTitle("Creacion de nueva ruta");

        txtLibra.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N

        txtPrioridad.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N
        jLabel1.setText("Precio de prioridad");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N
        jLabel2.setText("Precio por libra");

        CrearRuta.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        CrearRuta.setText("CREAR");
        CrearRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearRutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLibra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(CrearRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLibra, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CrearRuta, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearRutaActionPerformed
        crearRuta();
    }//GEN-LAST:event_CrearRutaActionPerformed

    public void crearRuta(){
        int precioPrioridad = Integer.parseInt(txtPrioridad.getText());
        int precioLibra = Integer.parseInt(txtLibra.getText());
            
        try {
            Connection conectar = conexion.conectar();
            
            String datos = "INSERT INTO Rutas VALUES(?,?,?)";
            
            PreparedStatement pst = conectar.prepareStatement(datos);
            
            pst.setInt(1, precioPrioridad);
            pst.setBoolean(2, true);
            pst.setInt(3, precioLibra);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Ruta nueva creada");
            
        } catch (SQLException e) {
            System.out.println("error "+e);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CrearRuta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtLibra;
    private javax.swing.JTextField txtPrioridad;
    // End of variables declaration//GEN-END:variables
}
