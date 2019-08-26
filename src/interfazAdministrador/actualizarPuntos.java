package interfazAdministrador;

import backend.conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class actualizarPuntos extends javax.swing.JDialog {

    Connection conecta = conexion.conectar();
    String nombrePunto = tablaPuntosControl.nombrePunto;
    int idRuta = tablaPuntosControl.idRuta;
    int idUsuario = tablaPuntosControl.idUsuario;
    int IdPunto = tablaPuntosControl.idPunto;

    /*
    //Constructor con dos parametros los cuales son necesario añadir por ser un JDialog
    //este bloqueara la interfaz que se encuentre debajo
    */
    public actualizarPuntos(puntosControl puntos, boolean modal) {
        super(puntos, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        operarios();
        llenarInfo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPrecioHora = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbxOperador = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Precio por hora");

        txtPrecioHora.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtPrecioHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioHoraKeyTyped(evt);
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

        jLabel5.setText("Nombre Punto de Control");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel6.setText("Ruta a la que pertenece:");

        txtRuta.setEditable(false);
        txtRuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRutaKeyTyped(evt);
            }
        });

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                                .addGap(101, 101, 101)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 3, Short.MAX_VALUE)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxOperador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRuta)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecioHora, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRuta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(53, 53, 53)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecioHora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed

    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        actualizarPunto();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        eliminarPunto();
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtRutaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutaKeyTyped
        char c = evt.getKeyChar();                                              //Permite solo escribir letras
        if (c < 'a' || c > 'z') {
            evt.consume();
        }
    }//GEN-LAST:event_txtRutaKeyTyped

    private void txtPrecioHoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioHoraKeyTyped
        char c = evt.getKeyChar();                                              //Permite solo escribir numeros
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioHoraKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();                                              //Permite solo escribir letras
        if (c < 'a' || c > 'z') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxOperador;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioHora;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables

    private void llenarInfo() {
        try {
            String datos = "SELECT EstadoPunto, NombrePunto, PrecioHora FROM PuntoControl WHERE IdPunto = '" + IdPunto + "'";   //Valida si en la tabla punto de control
            PreparedStatement pst = conecta.prepareStatement(datos);                                                            //existe el Id que presionaron en la tabla
            ResultSet rs = pst.executeQuery();                                                                                  //anterior

            if (rs.next()) {
                String precio = String.valueOf(rs.getDouble("PrecioHora"));
                txtPrecioHora.setText(precio);
                txtNombre.setText(rs.getString("NombrePunto"));
                cbxEstado.setSelectedItem(rs.getString("EstadoPunto"));
            }

            datos = "SELECT NombreRuta FROM Rutas WHERE IdRuta = '" + idRuta + "'";                                             //Verifica en la tabla de rutas si existe
            pst = conecta.prepareStatement(datos);                                                                              //un punto de control que tenga el id de la
            rs = pst.executeQuery();                                                                                            //ruta de la celda que presionaron en la tabla
            if (rs.next()) {
                txtRuta.setText(rs.getString("NombreRuta"));
            }

            datos = "SELECT NombreUsuario FROM Usuario WHERE IdUsuario = '" + idUsuario + "'";                                  //Verifica si en la tabla de usuarios existe
            pst = conecta.prepareStatement(datos);                                                                              //un usuario con ese id y lo agrega al combo
            rs = pst.executeQuery();
            if (rs.next()) {
                cbxOperador.setSelectedItem(rs.getString("NombreUsuario"));
            }

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }

    public void operarios() {
        ArrayList<String> listaOperarios = new ArrayList<String>();                                              //Lista para guardar a todos los usuarios con cargo
        String datos = "SELECT Rol, NombreUsuario FROM Usuario";                                                 //de operarios

        try {
            PreparedStatement ps = conecta.prepareStatement(datos);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString("Rol").equals("Operador")) {                                                    //Se valida si el usuario es un operador para 
                    listaOperarios.add(rs.getString("NombreUsuario"));                                           //agregarlo a la lista
                }
            }

            for (int i = 0; i < listaOperarios.size(); i++) {
                cbxOperador.addItem(listaOperarios.get(i));                                                     //Se agrega la lista al combo para poder elegir
            }                                                                                                   //a alguno para poder modificarñp

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }

    public void actualizarPunto() {
        double precioHora = Double.parseDouble(txtPrecioHora.getText());
        String nombrePunto = txtNombre.getText();
        String operario = cbxOperador.getSelectedItem().toString();
        PreparedStatement pst;

        String datos;
        String stringEstado = "";
        String nombreUsuario = cbxOperador.getSelectedItem().toString();
        int estado = cbxEstado.getSelectedIndex();

        if (estado == 0) {                                                                                              
            stringEstado = "Activo";
        } else if (estado == 1) {
            stringEstado = "Inactivo";
        }

        int idUsuarioN = 0;
        try {
            datos = "SELECT IdUsuario FROM Usuario WHERE NombreUsuario = '" + nombreUsuario + "'";                          //Se obtiene el id del usuario a partir
            pst = conecta.prepareStatement(datos);                                                                          //de su nombre para poder actualizar
            ResultSet rs = pst.executeQuery();                                                                              //su informacion
            if (rs.next()) {
                idUsuarioN = rs.getInt("IdUsuario");
            }

        } catch (SQLException e) {
        }

        try {
            datos = "UPDATE PuntoControl SET IdUsuario = ?, EstadoPunto = ?, PrecioHora = ?, NombrePunto = ? WHERE IdPunto = '" + IdPunto + "'";
            pst = conecta.prepareStatement(datos);

            pst.setInt(1, idUsuarioN);                                                                                      //Se llena la tabla usuarios con 
            pst.setString(2, stringEstado);                                                                                 //los datos que se hayan modificado
            pst.setDouble(3, precioHora);
            pst.setString(4, nombrePunto);
            pst.executeUpdate();                                                                                            //Se actualiza la tabla para guardar
                                                                                                                            //los cambios
            JOptionPane.showMessageDialog(null, "Punto de control Actualizado");

        } catch (HeadlessException | SQLException e) {
            System.out.println("Error " + e);
        }
    }

    private void eliminarPunto() {

        try {
            String datos = "DELETE FROM PuntoControl WHERE IdPunto = '" + IdPunto + "'";
            PreparedStatement pst = conecta.prepareStatement(datos);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Punto de control eliminado");
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

}
