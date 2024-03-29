package interfazAdministrador;
import agregarPaquetes.cola;
import backend.conexion;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class crearPunto extends javax.swing.JInternalFrame {
    Connection conecta = conexion.conectar();
    int taman,IdRuta = 0;
        
    
    public crearPunto() {
        initComponents();
        operarios();                                                                        //Llena el combobox con los usuarios que sean operarios
        rutas();                                                                            //Carga las rutas que tengamos disponibles
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
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCola = new javax.swing.JTextField();

        setClosable(true);

        jLabel1.setText("Ruta a la que pertenece:");

        jLabel3.setText("Precio por hora");

        txtPrecioHora.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtPrecioHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioHoraKeyTyped(evt);
            }
        });

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

        jLabel5.setText("Nombre Punto de Control");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel6.setText("Cantidad de paquetes:");

        txtCola.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColaKeyTyped(evt);
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
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbxRuta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxOperador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPrecioHora, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtCola))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecioHora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtCola, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        if(txtPrecioHora.getText().equals("") || txtNombre.getText().equals("") || txtCola.getText().equals(ui))
            JOptionPane.showMessageDialog(null, "Por favor llene todo los campos");
        else{
            crearPunto();                                                                   //Metodo que crear un punto de control con todos sus atributos
            txtPrecioHora.setText("");                                                      //y la cola respectiva
            txtNombre.setText("");
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void txtPrecioHoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioHoraKeyTyped
        char c = evt.getKeyChar();                                              //Permite solo escribir numeros
        if (c < '1' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioHoraKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();                                              //Permite solo escribir letras
        if (c < 'a' || c > 'z') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtColaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColaKeyTyped
        char c = evt.getKeyChar();                                              //Permite solo escribir numeros
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtColaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxOperador;
    public javax.swing.JComboBox<String> cbxRuta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCola;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioHora;
    // End of variables declaration//GEN-END:variables

    public void crearCola(){
        taman = Integer.parseInt(txtCola.getText());
        cola colaNueva = new cola(taman);
        String de = txtNombre.getText();
        try {
            PreparedStatement ps = conecta.prepareStatement("SELECT * FROM Paquete WHERE Localizacion <>'Bodega'"           //Verifica en la tabla paquete si los paquetes
                    + "AND Ruta='" + cbxRuta.getSelectedItem().toString() + "'");                                           //No estan en bodega e identifica en que ruta
            ResultSet rs = ps.executeQuery();                                                                               //esta puesto
            if (rs.next()) {                                                                                                //Si hay paquetes que no esten en bodega
            } else {                                                                                                        //No hace nada
                colaNueva.agregarColaNueva(de,para());                                                                      //Si hay paquetes en bodega los jala a una nueva
            }                                                                                                               //cola
        } catch (SQLException e) {
            System.err.println("Error en en la base de datos al crear cola" + e);
        }
    }

    public String para() {
        String para = "";
        
        try {
            PreparedStatement ps = conecta.prepareStatement("SELECT Destino FROM Rutas WHERE IdRuta =" +IdRuta);            //Obtine el destino del paquete 
            ResultSet rs = ps.executeQuery();                                                                               //basada en el Id de la ruta
            if (rs.next()) {
                para = rs.getString("Destino");
            }
        } catch (SQLException ex) {
            System.err.println("Eror al guardar hacia donde va "+ex);
        }
        return para;
    }

    
    public void crearPunto(){
        int precioHora = Integer.parseInt(txtPrecioHora.getText());
        String nombrePunto = txtNombre.getText();
        String operario = (String) cbxRuta.getSelectedItem();
        
        String datos;
        String nombreRuta = cbxRuta.getSelectedItem().toString();
        String nombreUsuario = cbxOperador.getSelectedItem().toString();
        String stringEstado = "";
        int estado = cbxEstado.getSelectedIndex();
        int IdUsuario = 0;

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
            datos = "INSERT INTO PuntoControl VALUES(?,?,?,?,?,?)";
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
            pst.setString(6, nombrePunto);
            pst.executeUpdate();
      
            crearCola();
            JOptionPane.showMessageDialog(null, "Punto de control establecido");
        
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error "+e);
        }
    }
    
    public void operarios(){
        ArrayList<String> list = new ArrayList<String>();
        String datos = "SELECT Rol, NombreUsuario FROM Usuario";
        
        try {
                PreparedStatement ps = conecta.prepareStatement(datos);                                 //Verifica quienes son operarios par asignarle un 
                ResultSet rs = ps.executeQuery();                                                       //punto de control
                
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
                
                while(rs.next()){                                                                        //Busca las rutas que existan y las muestra para que
                    list.add(rs.getString("NombreRuta"));                                                //el nuevo punto de control sea asignado a uno de estos
                }
                
                for(int i =0; i<list.size(); i++){
                    cbxRuta.addItem(list.get(i));
                }
    
        } catch (SQLException e) {
            System.out.println("Error "+e);
        }    
    }
}
