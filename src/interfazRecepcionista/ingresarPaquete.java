package interfazRecepcionista;

import java.sql.*;
import backend.conexion;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author dylan
 */
public class ingresarPaquete extends javax.swing.JInternalFrame {

    Connection conecta = conexion.conectar();
    public static int horasEnRuta = 0;
    public static String localizacion;
    DefaultTableModel modelo = new DefaultTableModel();
    String ruta="";

    public ingresarPaquete() {
        initComponents();
        btnFactura.setEnabled(false);
        rutas();
        crearTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxDestino = new javax.swing.JComboBox<>();
        btnIngresar = new javax.swing.JButton();
        btnFactura = new javax.swing.JButton();
        txtNit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxPrioridad = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAgregados = new javax.swing.JTable();
        dateFecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setText("NIT cliente");

        jLabel2.setText("Peso:");

        jLabel3.setText("Destino:");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnFactura.setText("Generar factura");
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });

        jLabel4.setText("Priorizado:");

        cbxPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Si" }));

        tableAgregados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableAgregados);

        dateFecha.setDateFormatString("yyyy/MM/dd HH:mm:ss");

        jLabel5.setText("Fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxDestino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxPrioridad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(cbxPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        btnFactura.setEnabled(true);
        agregarPaquete();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed
        generarFactura();
        limpiar();
    }//GEN-LAST:event_btnFacturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox<String> cbxDestino;
    private javax.swing.JComboBox<String> cbxPrioridad;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAgregados;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables

    public void rutas() {
        ArrayList<String> list = new ArrayList<String>();
        String datos = "SELECT Destino FROM Rutas WHERE EstadoRuta = 'Activo'";

        try {
            PreparedStatement ps = conecta.prepareStatement(datos);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getString("Destino"));
            }

            for (int i = 0; i < list.size(); i++) {
                cbxDestino.addItem(list.get(i));
            }

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }

    public String total() {
        int total;
        String stringTotal;
        total = Integer.parseInt(txtPeso.getText()) * 5;
        stringTotal = String.valueOf(total);
        return stringTotal;
    }

    public void agregarPaquete() {
        String nit = txtNit.getText();
        String fecha = ((JTextField) dateFecha.getDateEditor().getUiComponent()).getText();
        String destino = cbxDestino.getSelectedItem().toString();
        String priorizacion = cbxPrioridad.getSelectedItem().toString();
        String datos;
        PreparedStatement pst;
        ResultSet rs;
        boolean booleanpriorizacion = false;
        float peso = Float.parseFloat(txtPeso.getText());
        localizacion = "Bodega";

        if (priorizacion.equals("No")) {
            booleanpriorizacion = false;
        } else if (priorizacion.equals("Si")) {
            booleanpriorizacion = true;
        }
        
         try {
            datos = "SELECT NitCliente FROM Clientes WHERE NitCliente = '"+nit+"'";
            pst = conecta.prepareStatement(datos);
            rs = pst.executeQuery();

            if (rs.next()) {
                datos = "INSERT INTO Paquete VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                pst = conecta.prepareStatement(datos);

                pst.setInt(1, 0);
                pst.setString(2, nit);
                pst.setFloat(3, peso);
                pst.setString(4, destino);
                pst.setBoolean(5, booleanpriorizacion);
                pst.setBoolean(6, false);
                pst.setDouble(7, cobro());
                pst.setInt(8, horasEnRuta);
                pst.setString(9, localizacion);
                pst.setString(10, fecha);
                pst.setString(11, obtenerRuta());
                pst.setDouble(12, 0); 
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Paquete agregado Le cobraran " + cobro());
                llenarTabla(fecha);
                txtNit.setEnabled(false);
                txtPeso.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "El cliente no está registrado, porfavor registrelo");
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }

    public void llenarTabla(String fecha) {
        try {
            Connection conectar = conexion.conectar();
            String datos = "SELECT IdPaquete, NitCliente, Peso, Destino, Prioridad, Costo, Fecha FROM Paquete WHERE Fecha = '" + fecha + "'";
            PreparedStatement pst = conectar.prepareStatement(datos);

            ResultSet rs = pst.executeQuery();
            Object[] fila = new Object[7];
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
            }
            modelo.addRow(fila);
            conectar.close();
        } catch (SQLException e) {
            System.err.println("Error" + e);
            JOptionPane.showMessageDialog(null, "Error, notifique al administrador!!");
        }
    }

    private Double cobro() {
        Double precioDestino = null, precioLibra = null, precioPriorizacion = null, costoPaquete = null;
        String destino = cbxDestino.getSelectedItem().toString();
        String datos;
        PreparedStatement pst;
        ResultSet rs;
        double peso = Double.parseDouble(txtPeso.getText());

        try {
            datos = "SELECT PrecioDestino, PrecioLibra, PrecioPriorizacion FROM Rutas WHERE Destino = '" + destino + "'";
            pst = conecta.prepareStatement(datos);
            rs = pst.executeQuery();

            if (rs.next()) {
                precioDestino = rs.getDouble("PrecioDestino");
                precioLibra = rs.getDouble("PrecioLibra");
                if (cbxPrioridad.getSelectedIndex() == 0) {
                    precioPriorizacion = 0.0;
                } else {
                    precioPriorizacion = rs.getDouble("PrecioPriorizacion");
                }
            }

            costoPaquete = (precioLibra * peso) + precioDestino + precioPriorizacion;

        } catch (SQLException e) {
        }
        return costoPaquete;
    }

    public void limpiar() {
        txtNit.setEnabled(true);
        txtNit.setText("");
        txtPeso.setText("");
        dateFecha.setDate(null);
        tableAgregados.removeAll();
    }

    private void generarFactura() {
        String datos = "";
        PreparedStatement pst;
        ResultSet rs;
        Document factura = new Document();
        String nit = txtNit.getText();

        System.out.println(nit);
        try {
            datos = "SELECT NitCliente FROM Clientes WHERE NitCliente = '" + nit + "'";
            pst = conecta.prepareStatement(datos);
            rs = pst.executeQuery();

            if (rs.next()) {
                try {
                    String ruta = System.getProperty("user.home");
                    PdfWriter.getInstance(factura, new FileOutputStream(ruta + "/NetBeansProjects/Code 'n Bugs/Facturas/FacturaDe" + nit + ".pdf"));
                    factura.open();

                    PdfPTable tabla = new PdfPTable(7);
                    tabla.addCell("Id paquete");
                    tabla.addCell("Nit del cliente");
                    tabla.addCell("Peso");
                    tabla.addCell("Destino");
                    tabla.addCell("Prioridad");
                    tabla.addCell("Costo");
                    tabla.addCell("Fecha de ingreso");

                    try {
                        datos = "SELECT IdPaquete, NitCliente, Peso, Destino, Prioridad, Costo, Fecha FROM Paquete WHERE NitCliente = '" + txtNit.getText() + "'"
                                + " AND Fecha = '" + ((JTextField) dateFecha.getDateEditor().getUiComponent()).getText() + "'";
                        pst = conecta.prepareStatement(datos);
                        rs = pst.executeQuery();

                        if (rs.next()) {
                            do {
                                tabla.addCell(rs.getString(1));
                                tabla.addCell(rs.getString(2));
                                tabla.addCell(rs.getString(3));
                                tabla.addCell(rs.getString(4));
                                tabla.addCell(rs.getString(5));
                                tabla.addCell(rs.getString(6));
                                tabla.addCell(rs.getString(7));

                            } while (rs.next());
                            factura.add(tabla);
                        } else {
                            System.out.println("No hay paquetes");
                        }

                    } catch (SQLException e) {
                    }
                    factura.close();
                    JOptionPane.showMessageDialog(null, "Facturado");
                } catch (DocumentException | FileNotFoundException e) {
                }
            }else{
                JOptionPane.showMessageDialog(null, "El cliente no existe porvafor agreguelo");
            }
        } catch (SQLException e) {
        }
    }
    
    public void crearTabla(){
        JTable tablePaquetes = new JTable(modelo);
            jScrollPane1.setViewportView(tablePaquetes);

            modelo.addColumn("Id paquete");
            modelo.addColumn("Nit del cliente");
            modelo.addColumn("Peso");
            modelo.addColumn("Destino");
            modelo.addColumn("Prioridad");
            modelo.addColumn("Costo");
            modelo.addColumn("Fecha de ingreso");

    }
    
    public String obtenerRuta(){
    try{
        PreparedStatement ps= conecta.prepareStatement("SELECT NombreRuta FROM Rutas WHERE Destino ='"+cbxDestino.getSelectedItem().toString()+"'");
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
        ruta=rs.getString("NombreRuta");
        }
    }catch(SQLException e){
        System.err.println("Error al jalar la ruta " +e);
    }
    return ruta;
    }
    
}
