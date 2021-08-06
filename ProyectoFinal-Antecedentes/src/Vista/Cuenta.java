/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import ControlAdminDatos.Utiles.Utiles;
import Controlador.MantenerCokie;
import Modelo.Persona;
import java.awt.ComponentOrientation;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.plaf.LabelUI;

/**
 *
 * @author hp
 */
public class Cuenta extends javax.swing.JPanel {

    /**
     * Creates new form Cuenta
     */
    Utiles uti=new Utiles();
    public Cuenta() {
        initComponents();
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Ghandi.png"));
        lblp.setIcon(new ImageIcon(uti.img(img, lblp.getSize())));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fotop = new rojerusan.RSPanelCircleImage();
        txtApellidos = new javax.swing.JLabel();
        txtNombres = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSexo = new javax.swing.JLabel();
        txtCedula = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JLabel();
        txtMail = new javax.swing.JLabel();
        panelDerecho = new javax.swing.JPanel();
        lblp = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 610));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(null);

        fotop.setColorBorde(new java.awt.Color(0, 0, 51));
        fotop.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Vista/Acces/Imagenes/UsuarioImg.png"))); // NOI18N
        jPanel1.add(fotop);
        fotop.setBounds(10, 10, 160, 160);

        txtApellidos.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtApellidos.setForeground(new java.awt.Color(255, 255, 255));
        txtApellidos.setText("Apellidos");
        jPanel1.add(txtApellidos);
        txtApellidos.setBounds(190, 80, 280, 40);

        txtNombres.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(255, 255, 255));
        txtNombres.setText("Nombres");
        jPanel1.add(txtNombres);
        txtNombres.setBounds(190, 30, 280, 40);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 550, 190);

        jLabel1.setText("Sexo: ");
        add(jLabel1);
        jLabel1.setBounds(20, 450, 50, 30);

        jLabel3.setText("E-Mail:");
        add(jLabel3);
        jLabel3.setBounds(20, 400, 50, 30);

        jLabel4.setText("Cedula:");
        add(jLabel4);
        jLabel4.setBounds(20, 250, 50, 30);

        jLabel5.setText("Dirección:");
        add(jLabel5);
        jLabel5.setBounds(20, 300, 50, 30);

        jLabel6.setText("Cell.");
        add(jLabel6);
        jLabel6.setBounds(20, 350, 50, 30);
        add(txtSexo);
        txtSexo.setBounds(90, 450, 330, 30);
        add(txtCedula);
        txtCedula.setBounds(90, 250, 330, 30);
        add(txtDireccion);
        txtDireccion.setBounds(90, 300, 330, 30);
        add(txtTelefono);
        txtTelefono.setBounds(90, 350, 330, 30);
        add(txtMail);
        txtMail.setBounds(90, 400, 330, 30);

        panelDerecho.setBackground(new java.awt.Color(51, 51, 51));
        panelDerecho.setLayout(null);
        panelDerecho.add(lblp);
        lblp.setBounds(30, 50, 390, 120);

        add(panelDerecho);
        panelDerecho.setBounds(550, 0, 450, 610);
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained
    public void actualizarPantalla(){
        MantenerCokie<Persona> cok = new MantenerCokie<>();
        Persona persona=cok.getCokieValue("Cesion"); 
        txtNombres.setText(persona.getNombre());
        txtApellidos.setText(persona.getApellido());
        txtCedula.setText(persona.getCedula());
        txtDireccion.setText(persona.getDireccion());
        txtTelefono.setText(persona.getTelefono());
        txtMail.setText(persona.getMail());
        txtSexo.setText(persona.getSexo());
        fotop.setImagen(new ImageIcon(persona.getFile().getAbsolutePath()));
    }
    public void BorrarPantalla(){
        
        txtNombres.setText("");
        txtApellidos.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtMail.setText("");
        txtSexo.setText("");
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Vista/Acces/Imagenes/UsuarioImg.png"));
        fotop.setImagen(new ImageIcon(uti.img(img, fotop.getSize())));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSPanelCircleImage fotop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblp;
    private javax.swing.JPanel panelDerecho;
    private javax.swing.JLabel txtApellidos;
    private javax.swing.JLabel txtCedula;
    private javax.swing.JLabel txtDireccion;
    private javax.swing.JLabel txtMail;
    private javax.swing.JLabel txtNombres;
    private javax.swing.JLabel txtSexo;
    private javax.swing.JLabel txtTelefono;
    // End of variables declaration//GEN-END:variables
}
