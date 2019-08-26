package interfazAdministrador;

public class usuarios extends javax.swing.JFrame {

    public usuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpUsuarios = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemCrear = new javax.swing.JMenuItem();
        itemVer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equipo.png"))); // NOI18N
        jMenu1.setText("Usuarios");

        itemCrear.setText("Crear nuevo usuario");
        itemCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCrearActionPerformed(evt);
            }
        });
        jMenu1.add(itemCrear);

        itemVer.setText("Ver usuarios");
        itemVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVerActionPerformed(evt);
            }
        });
        jMenu1.add(itemVer);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVerActionPerformed
        dpUsuarios.removeAll();                                                 //Removemos cualquier internalFrame que este 
        dpUsuarios.repaint();                                                   //para poder agregar esta y no tengamos muchas a la vez
        tablaUsuarios tu = new tablaUsuarios();
        this.dpUsuarios.add(tu);                                                //muestra la tabla donde estan resgitrados todos
        tu.rellenarTabla();                                                     //los usuarios
        tu.show();
    }//GEN-LAST:event_itemVerActionPerformed

    private void itemCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCrearActionPerformed
        dpUsuarios.removeAll();
        dpUsuarios.repaint();
        crearUsuario cu = new crearUsuario();                                   //Agregar el Interfanal Frame para crear usuarios nuevos
        dpUsuarios.add(cu);
        cu.show();
    }//GEN-LAST:event_itemCrearActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpUsuarios;
    private javax.swing.JMenuItem itemCrear;
    private javax.swing.JMenuItem itemVer;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
