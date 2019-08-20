package interfazAdministrador;

public class rutas extends javax.swing.JFrame {

    public rutas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(950,530);
        dpRutas.setSize(950,530);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpRutas = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemCrear = new javax.swing.JMenuItem();
        itemVer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(dpRutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 700));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rutasPque.png"))); // NOI18N
        jMenu1.setText("Rutas");

        itemCrear.setText("Crear ruta nueva");
        itemCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCrearActionPerformed(evt);
            }
        });
        jMenu1.add(itemCrear);

        itemVer.setText("Ver rutas");
        itemVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVerActionPerformed(evt);
            }
        });
        jMenu1.add(itemVer);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCrearActionPerformed
        dpRutas.removeAll();
        dpRutas.repaint();
        crearRuta cr = new crearRuta();
        this.dpRutas.add(cr);
        cr.show();
    }//GEN-LAST:event_itemCrearActionPerformed

    private void itemVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVerActionPerformed
        dpRutas.removeAll();
        dpRutas.repaint();
        tablaRutas vr = new tablaRutas();
        this.dpRutas.add(vr);
        vr.rellenarTabla();
        vr.show();
    }//GEN-LAST:event_itemVerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpRutas;
    private javax.swing.JMenuItem itemCrear;
    private javax.swing.JMenuItem itemVer;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
