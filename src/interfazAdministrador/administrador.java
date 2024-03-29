package interfazAdministrador;

import Reportes.reportes;
import login.login;
import java.awt.Color;

/**
 *
 * @author dylan
 */
public class administrador extends javax.swing.JFrame {

    public administrador() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
                
        jLabelFondo.setBackground(new Color(230,130,30));
        jLabelTitulo.setBackground(new Color(230,130,30));
        
        String titulo = "<html><body>BIENVENIDO<br>¿Que desea hacer hoy?</body></html>";    //Agrega saludo a jlabel con HTML
        jLabelTitulo.setText(titulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        btnUsuarios = new javax.swing.JButton();
        btnRutas = new javax.swing.JButton();
        btnPuntos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUsuarios.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Usuarios.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setBorder(null);
        btnUsuarios.setContentAreaFilled(false);
        btnUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 155, 170));

        btnRutas.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        btnRutas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rutas.png"))); // NOI18N
        btnRutas.setText("Rutas");
        btnRutas.setBorder(null);
        btnRutas.setContentAreaFilled(false);
        btnRutas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRutas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutasActionPerformed(evt);
            }
        });
        getContentPane().add(btnRutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 160, 170));

        btnPuntos.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnPuntos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/puntosControl.png"))); // NOI18N
        btnPuntos.setText("Puntos de Control");
        btnPuntos.setBorder(null);
        btnPuntos.setContentAreaFilled(false);
        btnPuntos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPuntos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuntosActionPerformed(evt);
            }
        });
        getContentPane().add(btnPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 245, 170, 170));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 140, 60));

        jLabelTitulo.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabelTitulo.setOpaque(true);
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 470, 192));

        jLabelFondo.setOpaque(true);
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 470));

        jMenuBar1.setBackground(new java.awt.Color(254, 254, 254));

        jMenu2.setForeground(new java.awt.Color(1, 1, 1));
        jMenu2.setText("Reportes");
        jMenu2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        jMenuItem4.setText("Ver reportes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutasActionPerformed
        new rutas().show();
    }//GEN-LAST:event_btnRutasActionPerformed

    private void btnPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuntosActionPerformed
        new puntosControl().setVisible(true);
    }//GEN-LAST:event_btnPuntosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        new usuarios().setVisible(true);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new login().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       reportes r = new reportes();
       r.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPuntos;
    private javax.swing.JButton btnRutas;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
}
