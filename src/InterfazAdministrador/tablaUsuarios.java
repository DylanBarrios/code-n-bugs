package InterfazAdministrador;
import java.sql.*;
import backend.conexion;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dylan
 */
public class tablaUsuarios extends javax.swing.JInternalFrame {

    
    
    public tablaUsuarios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();

        jScrollPane1.setViewportView(tableUsuarios);
        if (tableUsuarios.getColumnModel().getColumnCount() > 0) {
            tableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(100);
            tableUsuarios.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void rellenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            Connection conectar = conexion.conectar();
            String datos = "SELECT CuiUsuario, Nombre, Rol, Telefono,  Direccion, Usuario, Estado FROM Usuarios"; 
            PreparedStatement pst = conectar.prepareStatement(datos);
            
            ResultSet rs = pst.executeQuery();
            
            tableUsuarios = new JTable(modelo);
            jScrollPane1.setViewportView(tableUsuarios);
            
            modelo.addColumn("Cui Usuario");
            modelo.addColumn("Nombre");
            modelo.addColumn("Rol");
            modelo.addColumn("Telefono");
            modelo.addColumn("Direccion");
            modelo.addColumn("Usuario");
            modelo.addColumn("Estado");
                        
            while(rs.next()){
                Object[] fila = new Object[7];
                
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i +1);
                }
                modelo.addRow(fila);
            }
            conectar.close();
        } catch (SQLException e) {
            System.err.println("Error en nombre de usuario"+e);
            JOptionPane.showMessageDialog(null, "Error, notifique al administrador!!");
        }
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tableUsuarios;
    // End of variables declaration//GEN-END:variables
}
