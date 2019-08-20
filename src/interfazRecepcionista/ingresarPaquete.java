package interfazRecepcionista;
import java.sql.*;
import backend.conexion;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class ingresarPaquete extends javax.swing.JInternalFrame {

    Connection conecta = conexion.conectar();
    
    public ingresarPaquete() {
        initComponents();
        rutas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxDestino = new javax.swing.JComboBox<>();
        labelTotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtNit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxPrioridad = new javax.swing.JComboBox<>();

        jLabel1.setText("NIT cliente");

        jLabel2.setText("Peso:");

        jLabel3.setText("Destino:");

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Generar factura");

        jLabel4.setText("Priorizado:");

        cbxPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Si" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbxPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPeso)
                                            .addComponent(cbxDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel3))))
                    .addComponent(cbxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregarPaquete();        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxDestino;
    private javax.swing.JComboBox<String> cbxPrioridad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables


    public void rutas(){
        ArrayList<String> list = new ArrayList<String>();
        String datos = "SELECT Destino FROM Rutas WHERE EstadoRuta = 'Activo'";
        
        try {
                PreparedStatement ps = conecta.prepareStatement(datos);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    list.add(rs.getString("Destino"));
                }
                
                for(int i =0; i<list.size(); i++){
                    cbxDestino.addItem(list.get(i));
                }
    
        } catch (SQLException e) {
            System.out.println("Error "+e);
        }    
    }   
    
    public String total(){
        int total;
        String stringTotal;
        total =  Integer.parseInt(txtPeso.getText()) * 5;
        stringTotal = String.valueOf(total);
        return stringTotal;
    }
    
    public void agregarPaquete(){
        String nit = txtNit.getText();
        int peso = Integer.parseInt(txtPeso.getText());
        String destino = cbxDestino.getSelectedItem().toString();
        String priorizacion = cbxPrioridad.getSelectedItem().toString();
        boolean booleanpriorizacion = false;
        
        if(priorizacion.equals("No"))
            booleanpriorizacion = false;
        else if(priorizacion.equals("Si"))
            booleanpriorizacion = true;
        
        try {
            String datos = "SELECT NitCliente FROM Clientes WHERE NitCliente = '"+nit+"'";
            PreparedStatement pst = conecta.prepareStatement(datos);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                datos = "INSERT INTO Paquete VALUES(?,?,?,?,?,?,?,?,?,?)";
                pst = conecta.prepareStatement(datos);
                
                pst.setInt(1, 0);
                pst.setString(2, nit);
                pst.setFloat(3, peso);
                pst.setString(4, destino);
                pst.setBoolean(5, booleanpriorizacion);
                pst.setBoolean(6, false);
                pst.setFloat(7, peso);
                pst.setFloat(8, 10);
                pst.setInt(9,0);
                pst.setString(10, "Bodega");
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Paquete agregado");
            }
                
            else{
                JOptionPane.showMessageDialog(null,"El cliente no está registrado, porfavor registrelo");
            }            
        }catch (SQLException e) {
            System.out.println("Error "+e);
        }
    }

}
