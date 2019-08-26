package Reportes;

import backend.conexion;
import java.awt.event.ItemEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class reporteRutas extends javax.swing.JInternalFrame {

    Connection conecta = conexion.conectar();

    public reporteRutas() {
        initComponents();
        rutas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labeltexto1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxRuta = new javax.swing.JComboBox<>();
        labelEnRuta = new javax.swing.JLabel();
        labelFueraRuta = new javax.swing.JLabel();
        labeltexto2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);

        labeltexto1.setText("Paquetes que estan en Ruta:");

        jLabel2.setText("Ruta de la que desea saber:");

        cbxRuta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxRutaItemStateChanged(evt);
            }
        });

        labeltexto2.setText("Paquetes ya entregados:");

        jButton1.setText("Exportar HTML");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labeltexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)
                        .addComponent(cbxRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labeltexto2)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelEnRuta, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(labelFueraRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEnRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labeltexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(labeltexto2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(labelFueraRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxRutaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxRutaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            paquetesFueraRuta();                                                                             //Al cambiar de punto de control cambia los paquetes
            paquetesEnRuta();
        }
    }//GEN-LAST:event_cbxRutaItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        crearHTML();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxRuta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelEnRuta;
    private javax.swing.JLabel labelFueraRuta;
    private javax.swing.JLabel labeltexto1;
    private javax.swing.JLabel labeltexto2;
    // End of variables declaration//GEN-END:variables

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

    public void paquetesFueraRuta() {
        String datos = "SELECT COUNT(*) as total FROM Paquete WHERE Localizacion=Destino AND Ruta='" + cbxRuta.getSelectedItem().toString() + "'";
        String cantRegistros;
        try {
            PreparedStatement ps = conecta.prepareStatement(datos);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {                                                                        //Busca las rutas que existan y las muestra para que
                cantRegistros = rs.getString("total");                                                //el nuevo punto de control sea asignado a uno de estos
                labelFueraRuta.setText(cantRegistros);
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }

    public void paquetesEnRuta() {
        String datos = "SELECT COUNT(*) as total FROM Paquete WHERE Localizacion<>Destino AND Ruta='" + cbxRuta.getSelectedItem().toString() + "'";
        String cantRegistros;
        try {
            PreparedStatement ps = conecta.prepareStatement(datos);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {                                                                        //Busca las rutas que existan y las muestra para que
                cantRegistros = rs.getString("total");                                                //el nuevo punto de control sea asignado a uno de estos
                labelEnRuta.setText(cantRegistros);
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }

    private void crearHTML() {
        String cad = labeltexto1.getText();
        String cad2 = labeltexto2.getText();
        String enRuta = labelEnRuta.getText();
        String fueraRuta = labelFueraRuta.getText();
        

        FileWriter filewriter = null;
        PrintWriter printw = null;

        try {
            filewriter = new FileWriter("/home/dylan/NetBeansProjects/Code'nBugs/html's/"+cbxRuta.getSelectedItem().toString()+".html");
            printw = new PrintWriter(filewriter);

            printw.println("<html>");
            printw.println("<head><title>Reporte Paquetes</title></head>");
            printw.println("<body bgcolor=\"#99CC99\">");

            printw.println("<center><h1><font color=\"navy\">" + cad +" "+enRuta+ "</font></h1></center>");
            printw.println("<center><h1><font color=\"navy\">" + cad2 + " "+fueraRuta+ "</font></h1></center>");

            printw.println("</body>");
            printw.println("</html>");

            printw.close();

            System.out.println("Generado exitosamente");
        }catch(IOException e){
            System.err.println("Erro al crear HTML "+e);
        }
        
    }
    
}
