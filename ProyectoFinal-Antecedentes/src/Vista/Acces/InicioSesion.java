/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Acces;

import Controlador.ControladorCuenta;
import Controlador.MantenerCokie;
import Modelo.Cuenta;
import Modelo.Persona;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class InicioSesion extends javax.swing.JPanel {

    /**
     * Creates new form InicioCesion
     */
    ControladorCuenta ctrc = new ControladorCuenta();

    public InicioSesion(MouseListener aL, MouseListener aM) {
        initComponents();
        btnRegistrar.addMouseListener(aL);
        btnOk.addMouseListener(aM);
        jLabel7.addMouseListener(aM);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnOk = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(609, 400));
        setMinimumSize(new java.awt.Dimension(609, 400));
        setPreferredSize(new java.awt.Dimension(609, 400));
        setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Acces/Imagenes/juridicalogin.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 293, 400);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Welcome");
        add(jLabel2);
        jLabel2.setBounds(310, 10, 250, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Contraseña");
        add(jLabel3);
        jLabel3.setBounds(310, 210, 170, 15);

        txtContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        add(txtContraseña);
        txtContraseña.setBounds(310, 230, 280, 40);

        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        add(txtUsuario);
        txtUsuario.setBounds(310, 130, 280, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Pleace login to your account");
        add(jLabel4);
        jLabel4.setBounds(310, 60, 170, 14);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Usuario");
        add(jLabel5);
        jLabel5.setBounds(310, 110, 170, 15);

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Acces/Imagenes/btn.png"))); // NOI18N
        btnOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOkMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOkMousePressed(evt);
            }
        });
        add(btnOk);
        btnOk.setBounds(480, 330, 110, 40);

        btnRegistrar.setForeground(new java.awt.Color(0, 0, 255));
        btnRegistrar.setText("Registrate");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRegistrarMousePressed(evt);
            }
        });
        add(btnRegistrar);
        btnRegistrar.setBounds(420, 300, 60, 12);

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("¿No tienes cuenta?");
        add(jLabel8);
        jLabel8.setBounds(310, 300, 110, 12);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Acces/Imagenes/btn2.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });
        add(jLabel7);
        jLabel7.setBounds(310, 330, 110, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseEntered
        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Acces/Imagenes/btn1.png"))); // TODO add your handling code here:
    }//GEN-LAST:event_btnOkMouseEntered

    private void btnOkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseExited
        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Acces/Imagenes/btn.png")));// TODO add your handling code here:
    }//GEN-LAST:event_btnOkMouseExited
 // posible idea

    private void btnOkMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMousePressed
        try {
            //System.out.println("true: "+ ctrc.buscarCuenta(txtUsuario.getText(), ctrc.encriptar(txtContraseña.getPassword())));
            ctrc.buscarCuenta(txtUsuario.getText(), ctrc.encriptar(txtContraseña.getPassword()));
            System.out.println("Pase: "+ctrc.getBuscarPersonaCuenta());
            if (ctrc.getBuscarPersonaCuenta()) {
                MantenerCokie<Persona> ctr=new MantenerCokie<>();
                ctr.addCokie(ctrc.buscarPersonaCuenta(ctrc.agregarCuenta().getIdPersona()),"Cesion");
                txtContraseña.setText("");
                txtUsuario.setText("");
            }
            
        } catch (GeneralSecurityException ex) {
            JOptionPane.showMessageDialog(null, "Error durante la validacion de credenciales");

            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error durante la validacion de credenciales");

            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnOkMousePressed

    private void btnRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseEntered
        btnRegistrar.setForeground(new Color(102, 102, 102));
        btnRegistrar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
    }//GEN-LAST:event_btnRegistrarMouseEntered

    private void btnRegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseExited
        btnRegistrar.setForeground(new Color(0, 0, 255));
        btnRegistrar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
    }//GEN-LAST:event_btnRegistrarMouseExited

    private void btnRegistrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMousePressed

    }//GEN-LAST:event_btnRegistrarMousePressed

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Acces/Imagenes/btn3.png")));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Acces/Imagenes/btn2.png")));
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed

    }//GEN-LAST:event_jLabel7MousePressed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed

    }//GEN-LAST:event_txtContraseñaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnOk;
    private javax.swing.JLabel btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
