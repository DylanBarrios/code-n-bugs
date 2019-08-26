package interfazOperador;

import backend.conexion;
import java.awt.event.ItemEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import login.login;

public class procesarPaquetes extends javax.swing.JInternalFrame {

    Connection conecta = conexion.conectar();
    int hora,IdPaquete, idPunto;
    
    public procesarPaquetes() {
        initComponents();
        cargarPunto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtHoras = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbxPuntoSalida = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxPuntoLlegada = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxPaquete = new javax.swing.JComboBox<>();

        txtHoras.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtHoras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHorasKeyTyped(evt);
            }
        });

        jLabel1.setText("Horas en este punto:");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel2.setText("Punto de donde sale:");

        cbxPuntoSalida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPuntoSalidaItemStateChanged(evt);
            }
        });

        jLabel3.setText("Punto al que llegará:");

        jLabel4.setText("Paquete que sale:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(cbxPaquete, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addComponent(cbxPuntoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(56, 56, 56)
                                    .addComponent(cbxPuntoLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(13, 13, 13)
                        .addComponent(cbxPuntoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxPuntoLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if(txtHoras.equals(""))
            JOptionPane.showMessageDialog(null, "Por favor establezca la cantidad de horas");
        else
            procesar();
                
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cbxPuntoSalidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPuntoSalidaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cbxPaquete.removeAllItems();
            cbxPuntoLlegada.removeAllItems();
            cargarPaquetes();                                                                               //Al cambiar de punto de control cambia los paquetes
        }
    }//GEN-LAST:event_cbxPuntoSalidaItemStateChanged

    private void txtHorasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHorasKeyTyped
        char c = evt.getKeyChar();                                              //Permite solo escribir numeros
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtHorasKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JComboBox<String> cbxPaquete;
    private javax.swing.JComboBox<String> cbxPuntoLlegada;
    private javax.swing.JComboBox<String> cbxPuntoSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtHoras;
    // End of variables declaration//GEN-END:variables

    public void procesar(){
        IdPaquete = Integer.parseInt(cbxPaquete.getSelectedItem().toString());
        hora = Integer.parseInt(txtHoras.getText().trim());
        String localizacionPaquete = "";
        String para = cbxPuntoLlegada.getSelectedItem().toString();

        try {
            PreparedStatement ps = conecta.prepareStatement("SELECT Localizacion FROM Paquete WHERE IdPaquete=" +IdPaquete);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                localizacionPaquete = rs.getString("Localizacion");
            }
        } catch (SQLException e) {
            System.err.println("Error obtener localizacion " + e);
        }
        try {
            String datos = "UPDATE Paquete SET Localizacion=?,TiempoEnRuta=?,Costo =?WHERE IdPaquete ='"+IdPaquete+"' AND Localizacion='"+localizacionPaquete+"'";
            PreparedStatement ps = conecta.prepareStatement(datos);
            ps.setString(1, para);
            ps.setInt(2, horasEnRuta());
            ps.setDouble(3, costo());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paquete fuera del punto");
        } catch (SQLException e) {
            System.err.println("Error al actulizar paquete " + e);
        }
    }
   
    public void cargarPunto() {                                                                         //Metodo para cargar los puntos que le pertenece 
        String usuarioRigistrado = login.usuarioRegistrado;                                             //al usuario que se registro
        int idUsuario=0;
        ArrayList<String> listaConPuntos = new ArrayList<>();
        try {
            PreparedStatement ps = conecta.prepareStatement("SELECT IdUsuario FROM Usuario WHERE Username='" + usuarioRigistrado + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idUsuario = rs.getInt("IdUsuario");
            }
            String datos = "SELECT NombrePunto FROM PuntoControl WHERE IdUsuario= '" + idUsuario + "'";
            PreparedStatement pst = conecta.prepareStatement(datos);
            rs = pst.executeQuery();
            while (rs.next()) {
                String nombrePunto = rs.getString("NombrePunto");
                listaConPuntos.add(nombrePunto);                                                        //Los puntos de control los guarda en una lista
            }
            if (listaConPuntos.isEmpty())                                                               //Valida si encotro puntos de control
            {
                cbxPuntoSalida.addItem("No tiene puntos de control");
            } else {
                for (int i = 0; i < listaConPuntos.size(); i++) {                                       //Carga los puntos de control
                    cbxPuntoSalida.addItem(listaConPuntos.get(i));                                          //que haya encontrado
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en la conexion de DB con Administrador" + e);
        }
    }

    public void cargarPaquetes() {
        String puntoControl = cbxPuntoSalida.getSelectedItem().toString();
       
        ArrayList<String> listaConPaquetes = new ArrayList<>();
        try {
            String datos = "SELECT IdPaquete FROM Paquete WHERE Localizacion='" + puntoControl + "'";
            PreparedStatement ps = conecta.prepareStatement(datos);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String IdPaquete = String.valueOf(rs.getInt("IdPaquete"));
                listaConPaquetes.add(IdPaquete);
            }
            if (listaConPaquetes.isEmpty()) {
                cbxPaquete.addItem("No hay paquetes");
            } else {
                for (int i = 0; i < listaConPaquetes.size(); i++) {
                    cbxPaquete.addItem(listaConPaquetes.get(i));
                }
                cargarDestino();
            }
        } catch (SQLException e) {
            System.err.println("Error en la conexion al cargar paquetes" + e);
        }
    }

    public void cargarDestino() {
        ArrayList<String> listaConLlegadas = new ArrayList<>();
        String paquete = cbxPaquete.getSelectedItem().toString();
        int idRuta = 0;
        idPunto = 0;
        String nombrePunto = cbxPuntoSalida.getSelectedItem().toString();
        try {
            String datos = "SELECT IdRuta FROM PuntoControl WHERE NombrePunto='" + nombrePunto + "'";   //Obtenemos el id de la ruta a la
            PreparedStatement pst = conecta.prepareStatement(datos);                                       //que pertenece el punto de control
            ResultSet rs = pst.executeQuery();                                                             //que seleccionó
            if (rs.next()) {
                idRuta = rs.getInt("IdRuta");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el id de la ruta " + e);
        }

        try {
            String datos = "SELECT IdPunto FROM PuntoControl WHERE NombrePunto ='"                       //Obtenemos el id del punto de
                            + nombrePunto + "'";                                                           //salida
            PreparedStatement pst = conecta.prepareStatement(datos);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idPunto = rs.getInt("IdPunto");                                                           //Se almacena el id del punto seleccionado
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el id del punto de control " + e);
        }

        try {
            String datos = "SELECT NombrePunto FROM PuntoControl WHERE IdRuta ='"              //Se llaman a los puntos de control
                            +idRuta + "' AND IdPunto>'" + idPunto + "'";                         //donde el id sea mayor al que está
            PreparedStatement ps = conecta.prepareStatement(datos);                               //seleccionado
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombrePuntoLlegada = rs.getString("NombrePunto");                         //Almacena en un listado los puntos
                listaConLlegadas.add(nombrePuntoLlegada);                                         //de control siguientes
            }
            if (!rs.next() && cbxPaquete.getItemCount()!=0) {                                     //Se comprueba si no existen mas puntos de 
                try {                                                                             //control pero aun hay paquetes
                    datos = "SELECT Destino FROM Paquete WHERE IdPaquete='"                      
                            +paquete + "'";                                                       //Se selecciona el destino del paquete
                    ps = conecta.prepareStatement(datos);                                         //que esté seleccionado
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        String destino = rs.getString("Destino");                                 //Se llena el listado que serviria para
                        listaConLlegadas.add(destino);                                            //almacenar los siguientes puntos de control
                    }                                                                             //con el destino ya que pasó por todos los de más
                } catch (SQLException e) {
                    System.err.println("Error al obtener la localizacion " + e);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al jalar nombre del punto" + e);
        }
        for (int i = 0; i < listaConLlegadas.size(); i++) {                                        //Se cargan los puntos de control o destino
            cbxPuntoLlegada.addItem(listaConLlegadas.get(i));                                       //al que el paquete tiene que pasar
        }
    }
    
    public int horasEnRuta(){
        int horasEnRuta =0;
        try {
            String datos = "SELECT TiempoEnRuta FROM Paquete WHERE IdPaquete ="+IdPaquete;
            PreparedStatement pst = conecta.prepareStatement(datos);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                horasEnRuta = rs.getInt("TiempoEnRuta");          
        } catch (SQLException e) {
            System.err.println("Erro al obtener la hora "+e);
        }
        
        horasEnRuta+=hora;
        return horasEnRuta;
    }

    private double costo() {
        double costoTotal=0,costoTmp=0;
        int horas;
        double PrecioHora=0;
        try {
            String datos = "SELECT PrecioHora FROM PuntoControl WHERE IdPunto ="+idPunto;
            PreparedStatement pst = conecta.prepareStatement(datos);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                PrecioHora = rs.getDouble("PrecioHora");          
        } catch (SQLException e) {
            System.err.println("Erro al obtener el Precio por hora "+e);
        }
        
        try {
            String datos = "SELECT Costo FROM Paquete WHERE IdPaquete ="+IdPaquete;
            PreparedStatement pst = conecta.prepareStatement(datos);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                costoTotal = rs.getDouble("Costo");          
        } catch (SQLException e) {
            System.err.println("Erro al obtener el costo del paquete "+e);
        }
        
        horas = Integer.parseInt(txtHoras.getText());
        costoTmp=PrecioHora*horas;
        costoTotal+=costoTmp;
        return costoTotal;
    }

}
