package interfazAdministrador;
import backend.conexion;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class actualizarRuta extends javax.swing.JDialog {

    String nombre = tablaRutas.nombre;
    public actualizarRuta(rutas ruta, boolean modal) {
        super(ruta, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        rellenar();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        CrearRuta.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        CrearRuta.setText("ACTUALIZAR");
        CrearRuta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CrearRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearRutaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre de la ruta:");

        jLabel1.setText("Destino de la ruta");

        txtDestino.setEditable(false);
        txtDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDestinoKeyTyped(evt);
            }
        });

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
                .addContainerGap(24, Short.MAX_VALUE))
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
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearRutaActionPerformed
        actualizar();
        this.setVisible(false);
    }//GEN-LAST:event_CrearRutaActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();                                              //Permite solo escribir letras
        if (c < 'a' || c > 'z') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDestinoKeyTyped
        char c = evt.getKeyChar();                                              //Permite solo escribir letras
        if (c < 'a' || c > 'z') {
            evt.consume();
        }
    }//GEN-LAST:event_txtDestinoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CrearRuta;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public void rellenar(){
        
        try{
            Connection conecta = conexion.conectar();
        
            String datos = "SELECT NombreRuta, Destino, EstadoRuta FROM Rutas WHERE NombreRuta = '"+nombre+"'";
            PreparedStatement pst = conecta.prepareStatement(datos);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                txtDestino.setText(rs.getString("Destino"));
                txtNombre.setText(rs.getString("NombreRuta"));
                cbxEstado.setSelectedItem(rs.getString("EstadoRuta"));
            }
            
        }catch(SQLException e){
            
        }
    }

    private void actualizar() {
        String stringEstado = "";
        int estado = cbxEstado.getSelectedIndex();
        
        if(estado == 0)
            stringEstado = "Activo";
        else if(estado == 1)
            stringEstado = "Inactivo";
        
        
        try {
            Connection conecta = conexion.conectar();
            String datos = "UPDATE Rutas SET EstadoRuta = ? WHERE NombreRuta = '"+nombre+"'";
            PreparedStatement pst = conecta.prepareStatement(datos);
            
            pst.setString(1, stringEstado);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Ruta actualizada");
            
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error "+e);
        }
    }



}