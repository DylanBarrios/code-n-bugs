/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import interfazAdministrador.administrador;
import interfazOperador.operador;
import interfazRecepcionista.recepcionista;
import java.sql.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import backend.conexion;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class login extends javax.swing.JFrame {

    public static String usuarioRegistrado;
    public login() {
        initComponents();
        this.setSize(400,540);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        ImageIcon wallpaper_logo = new ImageIcon("src/images/logo.png");
        Icon icono_logo = new ImageIcon(wallpaper_logo.getImage().getScaledInstance(jLabelLogo.getWidth(),jLabelLogo.getHeight(),Image.SCALE_DEFAULT));
        jLabelLogo.setIcon(icono_logo);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabelLogo = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setBackground(new java.awt.Color(254, 254, 254));
        txtUsuario.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 250, 40));

        jLabelUsuario.setFont(new java.awt.Font("URW Bookman L", 1, 18)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(254, 254, 254));
        jLabelUsuario.setText("Usuario:");
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabelPassword.setFont(new java.awt.Font("URW Bookman L", 1, 18)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(254, 254, 254));
        jLabelPassword.setText("contraseña");
        getContentPane().add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        txtPassword.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtPassword.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 250, 40));
        getContentPane().add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 250, 180));

        btnEntrar.setBackground(new java.awt.Color(204, 91, 47));
        btnEntrar.setFont(new java.awt.Font("Pagul", 1, 24)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(254, 254, 254));
        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/descubrir.png"))); // NOI18N
        btnEntrar.setBorder(null);
        btnEntrar.setContentAreaFilled(false);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnEntrarFocusGained(evt);
            }
        });
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
        });
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 110, 80));

        jLabelFondo.setBackground(new java.awt.Color(230, 130, 30));
        jLabelFondo.setOpaque(true);
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        validarUsuario();
        usuarioRegistrado = txtUsuario.getText();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnEntrarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnEntrarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarFocusGained

    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseClicked
        
    }//GEN-LAST:event_btnEntrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public void validarUsuario(){
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();
        
        if (!usuario.equals("")&& !password.equals("")){
            try {
                Connection conec = conexion.conectar();
                PreparedStatement pst = conec.prepareStatement("SELECT Rol, Estado FROM Usuario WHERE Username = '"+usuario+"' AND Password = '"+password+"'");
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                
                    String rol = rs.getString("Rol");
                    String estado = rs.getString("Estado");
                    
                    if (estado.equals("Activo") && rol.equals("Administrador")) {
                        txtPassword.setBackground(Color.green);
                        txtUsuario.setBackground(Color.green);
                        new administrador().setVisible(true);
                        dispose();
                    }           
                    else if(rol.equals("Operador")&&estado.equals("Activo")){
                        txtPassword.setBackground(Color.green);
                        txtUsuario.setBackground(Color.green);
                        new operador().setVisible(true);
                        dispose();
                    }
                    else if(rol.equals("Recepcionista")&&estado.equals("Activo")){
                        txtPassword.setBackground(Color.green);
                        txtUsuario.setBackground(Color.green);
                        new recepcionista().setVisible(true);
                        dispose();
                    }
                    
                }else {
                    JOptionPane.showMessageDialog(null,"Lo siento sus datos son erroneos, porfavor vuelva a escribirlos");
                    txtPassword.setText("");
                }
                
            } catch (SQLException e) {
                System.err.println("Error en login: "+e);
                JOptionPane.showMessageDialog(null, "!Error, notifique al administrador!");
            }
        }else{
            if(txtUsuario.getText().equals(""))
                txtUsuario.setBackground(Color.red);
            else
                txtUsuario.setBackground(Color.WHITE);
            if(txtPassword.getText().equals(""))
                txtPassword.setBackground(Color.red);
            else
                txtPassword.setBackground(Color.WHITE);
            JOptionPane.showMessageDialog(this, "Porfavor rellene los campos en rojo");
            
        }
        
    }


}
