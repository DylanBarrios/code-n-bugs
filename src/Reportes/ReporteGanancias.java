package Reportes;

import backend.conexion;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReporteGanancias extends javax.swing.JInternalFrame {

    Connection conecta = conexion.conectar();
    
    public ReporteGanancias() {
        initComponents();
        rutas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPaquetes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        labelGanancias = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxRuta = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        tablaPaquetes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaPaquetes);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Ganancias");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Seleccione una ruta:");

        jButton1.setText("Ver ganancias");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelGanancias, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addComponent(cbxRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jButton1)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelGanancias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(cbxRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        labelGanancias.setText("");
        tableGanancias();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxRuta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelGanancias;
    private javax.swing.JTable tablaPaquetes;
    // End of variables declaration//GEN-END:variables

public void tableGanancias() {
    DefaultTableModel model = new DefaultTableModel();
        float ganancia, costoT=0, precioT=0;
        try {
            String datos = "SELECT Ruta, Costo, Precio FROM Paquete WHERE Destino=Localizacion AND Ruta='"+cbxRuta.getSelectedItem().toString()+"'";
            PreparedStatement ps = conecta.prepareStatement(datos);
            ResultSet rs = ps.executeQuery();
            tablaPaquetes = new JTable(model);
            jScrollPane1.setViewportView(tablaPaquetes);
            model.addColumn("Ruta");
            model.addColumn("Costo");
            model.addColumn("Ingreso");

            while (rs.next()) {
                Object[] ob = new Object[3];
                for (int i = 0; i < ob.length; i++) {
                    ob[i] = rs.getObject(i + 1);
                }
                model.addRow(ob);
            }
        } catch (SQLException e) {
            System.err.println("Error al rellenar la tabla");
        }
        try {
            PreparedStatement ps = conecta.prepareStatement("SELECT SUM(costo) as total FROM Paquete WHERE destino=localizacion");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                costoT=rs.getFloat("total");               
                System.out.println(costoT);
            }
        } catch (SQLException e) {
            System.err.println("Error al jalar costo total " +e);
        }
        try {
            PreparedStatement ps = conecta.prepareStatement("SELECT SUM(precio) as total FROM Paquete WHERE destino=localizacion");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                precioT=rs.getFloat("total");               
                System.out.println(precioT);
            }
        } catch (SQLException e) {
            System.err.println("Error al jalar precio total " +e);
        }
        ganancia=precioT-costoT;
        labelGanancias.setText(String.valueOf(ganancia));
    }

    public void rutas() {
        ArrayList<String> list = new ArrayList<String>();
        String datos = "SELECT NombreRuta FROM Rutas";

        try {
            PreparedStatement ps = conecta.prepareStatement(datos);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {                                                                        //Busca las rutas que existan y las muestra para que
                list.add(rs.getString("NombreRuta"));                                                //el nuevo punto de control sea asignado a uno de estos
            }

            for (int i = 0; i < list.size(); i++) {
                cbxRuta.addItem(list.get(i));
            }

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }
}
