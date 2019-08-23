package interfazAdministrador;

import backend.conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class tablaPuntosControl extends javax.swing.JInternalFrame {
    public static String nombrePunto;
    public static int idRuta;
    public static int idUsuario;
    public static int idPunto;
    
    
    public tablaPuntosControl() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePuntos = new javax.swing.JTable();

        setClosable(true);
        setTitle("Listado de rutas");

        tablePuntos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablePuntos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void rellenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            Connection conectar = conexion.conectar();
            String datos;
            PreparedStatement pst;
            ResultSet rs;
            datos = "SELECT IdPunto, NombrePunto, EstadoPunto, PrecioHora, IdRuta, IdUsuario FROM PuntoControl"; 
            pst = conectar.prepareStatement(datos);
            rs = pst.executeQuery();
            
            
            
            tablePuntos = new JTable(modelo);
            jScrollPane1.setViewportView(tablePuntos);
            
            modelo.addColumn("Id punto de control");
            modelo.addColumn("Nombre");
            modelo.addColumn("Estado");
            modelo.addColumn("Precio por hora");
            modelo.addColumn("Id Ruta");
            modelo.addColumn("Id encargado");
                        
            while(rs.next()){
                Object[] fila = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                
                
                modelo.addRow(fila);
            }
            
            
            conectar.close();
        } catch (SQLException e) {
            System.err.println("Error en nombre de usuario"+e);
            JOptionPane.showMessageDialog(null, "Error, notifique al administrador!!");
        }
    
    tablePuntos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int filaSelec = tablePuntos.rowAtPoint(e.getPoint());
                
                if(filaSelec >= 0){
                    idPunto = (int)modelo.getValueAt(filaSelec, 0);
                    nombrePunto = (String)modelo.getValueAt(filaSelec, 1);
                    idRuta = (int)modelo.getValueAt(filaSelec, 4);
                    idUsuario = (int)modelo.getValueAt(filaSelec, 5);
                    
                    
                    puntosControl punto = new puntosControl();
                    actualizarPuntos ap = new actualizarPuntos(punto, true);
                    ap.setVisible(true);
                }
            }
        }
        );
    
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePuntos;
    // End of variables declaration//GEN-END:variables
}
