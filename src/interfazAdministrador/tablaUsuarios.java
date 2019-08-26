package interfazAdministrador;
import java.sql.*;
import backend.conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dylan
 */
public class tablaUsuarios extends javax.swing.JInternalFrame {
    public static String nombre;
        
    public tablaUsuarios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();

        setClosable(true);

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableUsuarios.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tableUsuarios);
        tableUsuarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

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
            String datos = "SELECT NombreUsuario, Rol, Username, Estado FROM Usuario";                  //Selecciona datos de la tabla usuario 
            PreparedStatement pst = conectar.prepareStatement(datos);                                   //que seran agregados en la tabla para poder ver 
                                                                                                        //cuales son todos los usuarios que laboran en el correo
            ResultSet rs = pst.executeQuery();
            
            tableUsuarios = new JTable(modelo);
            jScrollPane1.setViewportView(tableUsuarios);
            
            modelo.addColumn("Nombre");                                                                 //Se agregan columnas pertinentes a los datos que 
            modelo.addColumn("Rol");                                                                    //seran extraidos de la tabla
            modelo.addColumn("Usuario");
            modelo.addColumn("Estado");
                        
            while(rs.next()){
                Object[] fila = new Object[4];                                                          //obtiene cada dato de cada columna comviertiendo cada
                                                                                                        //una en objetos y posteriormente agregarlos a la lista                                         
                for (int i = 0; i < 4; i++) {                                                           //que los guarda
                    fila[i] = rs.getObject(i +1);
                }
                modelo.addRow(fila);
            }
            conectar.close();
        } catch (SQLException e) {
            System.err.println("Error en nombre de usuario"+e);
            JOptionPane.showMessageDialog(null, "Error, notifique al administrador!!");
        }
        
        tableUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){                                                     //Metodo que ayuda a identificar si una celda de la tabla
                int filaSelec = tableUsuarios.rowAtPoint(e.getPoint());                                 //a sido precionado y habre la ventana actualizar de dicho
                int columnSelec = 2;                                                                    //usuario
                
                if(filaSelec >= 0){
                    nombre = (String)modelo.getValueAt(filaSelec, columnSelec);
                    usuarios user = new usuarios();
                    actualizarUsuario au = new actualizarUsuario(user, true);
                    au.setVisible(true);
                }
            }
        }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tableUsuarios;
    // End of variables declaration//GEN-END:variables
}
