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

public class tablaRutas extends javax.swing.JInternalFrame {

    public static String nombre;
    
    public tablaRutas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableRutas = new javax.swing.JTable();

        setClosable(true);
        setTitle("Listado de rutas");

        jScrollPane1.setViewportView(tableRutas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void rellenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            Connection conectar = conexion.conectar();
            String datos = "SELECT NombreRuta, Destino, EstadoRuta FROM Rutas"; 
            PreparedStatement pst = conectar.prepareStatement(datos);
            
            ResultSet rs = pst.executeQuery();
            
            tableRutas = new JTable(modelo);                                                    //Obtiene los datos de Rutas para llenar la tabla
            jScrollPane1.setViewportView(tableRutas);                                           //donde se podran ver las rutas creadas
            
            modelo.addColumn("Nombre");
            modelo.addColumn("Destino");
            modelo.addColumn("Estado");
                        
            while(rs.next()){
                Object[] fila = new Object[3];
                
                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i +1);
                }
                modelo.addRow(fila);
            }
            conectar.close();
        } catch (SQLException e) {
            System.err.println("Error en nombre de usuario"+e);
            JOptionPane.showMessageDialog(null, "Error, notifique al administrador!!");
        }
        
        tableRutas.addMouseListener(new MouseAdapter() {                                          //Metodo que ayuda a identificar si una celda de la tabla
            @Override                                                                             //a sido precionado y habre la ventana para actualizar 
            public void mouseClicked(MouseEvent e){                                               //o modificar los datos del punto de control
                int filaSelec = tableRutas.rowAtPoint(e.getPoint());                
                        
                if(filaSelec >=0){
                    nombre = (String)modelo.getValueAt(filaSelec, 0);
                    rutas ruta = new rutas();
                    actualizarRuta ar = new actualizarRuta(ruta, true);
                    ar.setVisible(true);
                }
            }
        });
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRutas;
    // End of variables declaration//GEN-END:variables
}
