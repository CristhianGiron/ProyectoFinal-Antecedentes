/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;

/**
 *
 * @author hp
 */
public class Inicio extends javax.swing.JPanel {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LimpiarBuscadorCedula1 = new javax.swing.JLabel();
        btnBuscarCedula = new javax.swing.JLabel();
        LimpiarBuscadorNombre = new javax.swing.JLabel();
        btnBuscarNombre = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInformacion = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 610));
        setLayout(null);

        LimpiarBuscadorCedula1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LimpiarBuscadorCedula1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LimpiarBuscadorCedula1.setText("X");
        LimpiarBuscadorCedula1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(LimpiarBuscadorCedula1);
        LimpiarBuscadorCedula1.setBounds(360, 90, 20, 30);

        btnBuscarCedula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscarCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/IconoBuscar2.png"))); // NOI18N
        btnBuscarCedula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnBuscarCedula);
        btnBuscarCedula.setBounds(380, 90, 20, 30);

        LimpiarBuscadorNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LimpiarBuscadorNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LimpiarBuscadorNombre.setText("X");
        LimpiarBuscadorNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(LimpiarBuscadorNombre);
        LimpiarBuscadorNombre.setBounds(770, 90, 20, 30);

        btnBuscarNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscarNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/IconoBuscar2.png"))); // NOI18N
        btnBuscarNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnBuscarNombre);
        btnBuscarNombre.setBounds(790, 90, 20, 30);

        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 117, 225)));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        add(jTextField8);
        jTextField8.setBounds(120, 90, 290, 30);

        jLabel10.setForeground(new java.awt.Color(49, 49, 49));
        jLabel10.setText("Cedula");
        add(jLabel10);
        jLabel10.setBounds(120, 70, 290, 10);

        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 117, 225)));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        add(jTextField9);
        jTextField9.setBounds(530, 90, 290, 30);

        jLabel11.setForeground(new java.awt.Color(49, 49, 49));
        jLabel11.setText("Nombre");
        add(jLabel11);
        jLabel11.setBounds(530, 70, 290, 10);

        txtInformacion.setColumns(20);
        txtInformacion.setRows(5);
        jScrollPane1.setViewportView(txtInformacion);

        add(jScrollPane1);
        jScrollPane1.setBounds(120, 130, 700, 380);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setText("CONSULTAS");
        add(jLabel9);
        jLabel9.setBounds(50, 10, 320, 40);
        add(jSeparator1);
        jSeparator1.setBounds(10, 50, 980, 10);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Ayuda");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        add(jLabel1);
        jLabel1.setBounds(930, 20, 50, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed

    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
 
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0,0,255)));
        jLabel1.setForeground(new Color(0,0,255));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0,0,0)));
        jLabel1.setForeground(new Color(51,51,51));  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LimpiarBuscadorCedula1;
    private javax.swing.JLabel LimpiarBuscadorNombre;
    private javax.swing.JLabel btnBuscarCedula;
    private javax.swing.JLabel btnBuscarNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextArea txtInformacion;
    // End of variables declaration//GEN-END:variables
}
