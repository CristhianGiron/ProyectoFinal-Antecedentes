/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorPersona;
import Modelo.Persona;
import java.awt.Color;
import java.io.File;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;

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
        txtCedula = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        foto = new rojerusan.RSPanelCircleImage();
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
        btnBuscarCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarCedulaMousePressed(evt);
            }
        });
        add(btnBuscarCedula);
        btnBuscarCedula.setBounds(380, 90, 20, 30);

        txtCedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 117, 225)));
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        add(txtCedula);
        txtCedula.setBounds(120, 90, 290, 30);

        jLabel10.setForeground(new java.awt.Color(49, 49, 49));
        jLabel10.setText("Cedula");
        add(jLabel10);
        jLabel10.setBounds(120, 70, 290, 10);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(null);

        foto.setBackground(new java.awt.Color(0, 51, 102));
        foto.setColorBorde(new java.awt.Color(0, 51, 102));
        foto.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Vista/Acces/Imagenes/UsuarioImg.png"))); // NOI18N
        jPanel1.add(foto);
        foto.setBounds(0, 0, 150, 150);

        add(jPanel1);
        jPanel1.setBounds(600, 130, 150, 150);

        txtInformacion.setEditable(false);
        txtInformacion.setColumns(20);
        txtInformacion.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        txtInformacion.setRows(5);
        jScrollPane1.setViewportView(txtInformacion);

        add(jScrollPane1);
        jScrollPane1.setBounds(120, 130, 460, 380);

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

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed

    }//GEN-LAST:event_txtCedulaActionPerformed

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0,0,255)));
        jLabel1.setForeground(new Color(0,0,255));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0,0,0)));
        jLabel1.setForeground(new Color(51,51,51));  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseExited
    ControladorPersona ctrp=new ControladorPersona();
    private void btnBuscarCedulaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarCedulaMousePressed
        ctrp.listaPersonas();
        ctrp.VaciarTemp();
        String buscar = txtCedula.getText();
        ctrp.buscar(buscar, "CEDULA");
        String resultado="";
        File file=null;
        System.out.println("Cantidad recibiendo: "+ctrp.getListTemporal().size());
        for (int i = 0; i < ctrp.getListTemporal().size(); i++) {
            Persona p=ctrp.getListTemporal().get(i);
            resultado="Nomnbre: "+p.getNombre()+" "+p.getApellido()+"\n"+
                    "Cedula: "+p.getCedula()+"\n"+
                    "Fecha Nacimiento: "+p.getFechaNacimiento()+"\n"+
                    "Direccion: "+p.getDireccion()+"\n"+
                    "Estado Civil: "+p.getApellido()+"\n"+
                    "Sexo/Genero: "+p.getSexo()+"\n"+
                    "Telefono: "+p.getTelefono()+"\n"+
                    "E-mal: "+p.getMail()+"\n"+
                    "Aqui el resto de datos de procesos";
            file=p.getFile();
        }
        if (file!=null) {
           foto.setImagen(new ImageIcon(file.getAbsolutePath())); 
        }
        txtInformacion.setText(resultado);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarCedulaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LimpiarBuscadorCedula1;
    private javax.swing.JLabel btnBuscarCedula;
    private rojerusan.RSPanelCircleImage foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextArea txtInformacion;
    // End of variables declaration//GEN-END:variables
}
