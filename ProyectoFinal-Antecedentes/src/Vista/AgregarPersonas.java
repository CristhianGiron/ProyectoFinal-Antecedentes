/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import ControlAdminDatos.Utiles.Utiles;
import Controlador.ControladorPersona;
import Vista.Utiles.TablaPersonas.ConvertirEnums;
import Vista.Utiles.TablaPersonas.EstadoCivil;
import Vista.Utiles.TablaPersonas.Sexo;
import Vista.Utiles.UtilesFecha;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.SecureRandom;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class AgregarPersonas extends javax.swing.JPanel {

    /**
     * Creates new form AgregarPersonas
     */
    UtilesFecha fech = new UtilesFecha();
    Utiles uti = new Utiles();
    
    public AgregarPersonas() {
        initComponents();
        ConvertirEnums enums = new ConvertirEnums();
        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(enums.convertEstadoCivil(EstadoCivil.values())));
        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(enums.convertSexo(Sexo.values())));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dcFechaN = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        cbEstadoCivil = new javax.swing.JComboBox<>();
        cbSexo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        foto = new rojerusan.RSPanelCircleImage();
        botonluna = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 610));
        setPreferredSize(new java.awt.Dimension(1000, 610));
        setLayout(null);
        add(jSeparator1);
        jSeparator1.setBounds(10, 50, 980, 10);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Agregar Personas");
        add(jLabel1);
        jLabel1.setBounds(50, 10, 320, 40);

        txtApellidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });
        add(txtApellidos);
        txtApellidos.setBounds(150, 150, 290, 30);

        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        add(txtTelefono);
        txtTelefono.setBounds(150, 330, 290, 30);

        txtNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombresKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });
        add(txtNombres);
        txtNombres.setBounds(150, 90, 290, 30);

        jLabel2.setForeground(new java.awt.Color(49, 49, 49));
        jLabel2.setText("Telefono");
        add(jLabel2);
        jLabel2.setBounds(150, 310, 290, 14);

        jLabel3.setForeground(new java.awt.Color(49, 49, 49));
        jLabel3.setText("Estado Civil");
        add(jLabel3);
        jLabel3.setBounds(530, 130, 290, 14);

        jLabel4.setForeground(new java.awt.Color(49, 49, 49));
        jLabel4.setText("Apellidos");
        add(jLabel4);
        jLabel4.setBounds(150, 130, 290, 14);

        dcFechaN.setBackground(new java.awt.Color(255, 255, 255));
        dcFechaN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        dcFechaN.setDateFormatString("dd/MM/yyyy");
        dcFechaN.setIcon(new ImageIcon(getClass().getResource("/Vista/Iconos/IconoCalendario2.png")));
        add(dcFechaN);
        dcFechaN.setBounds(150, 210, 290, 30);

        jLabel5.setForeground(new java.awt.Color(49, 49, 49));
        jLabel5.setText("Fecha de nacimiento");
        add(jLabel5);
        jLabel5.setBounds(150, 190, 290, 14);

        txtMail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailActionPerformed(evt);
            }
        });
        txtMail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMailKeyReleased(evt);
            }
        });
        add(txtMail);
        txtMail.setBounds(150, 270, 290, 30);

        jLabel6.setForeground(new java.awt.Color(49, 49, 49));
        jLabel6.setText("E-mail");
        add(jLabel6);
        jLabel6.setBounds(150, 250, 290, 14);

        jLabel7.setForeground(new java.awt.Color(49, 49, 49));
        jLabel7.setText("Dirección");
        add(jLabel7);
        jLabel7.setBounds(150, 370, 290, 14);

        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
        });
        add(txtDireccion);
        txtDireccion.setBounds(150, 390, 290, 30);

        jLabel8.setForeground(new java.awt.Color(49, 49, 49));
        jLabel8.setText("Cedula");
        add(jLabel8);
        jLabel8.setBounds(150, 430, 290, 14);

        txtCedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        add(txtCedula);
        txtCedula.setBounds(150, 450, 290, 30);

        cbEstadoCivil.setBackground(new java.awt.Color(240, 240, 240));
        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado Civil" }));
        add(cbEstadoCivil);
        cbEstadoCivil.setBounds(530, 150, 290, 30);

        cbSexo.setBackground(new java.awt.Color(240, 240, 240));
        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sexo" }));
        add(cbSexo);
        cbSexo.setBounds(530, 90, 290, 30);

        jLabel9.setForeground(new java.awt.Color(49, 49, 49));
        jLabel9.setText("Nombres");
        add(jLabel9);
        jLabel9.setBounds(150, 70, 290, 14);

        jLabel10.setForeground(new java.awt.Color(49, 49, 49));
        jLabel10.setText("Sexo");
        add(jLabel10);
        jLabel10.setBounds(530, 70, 290, 14);

        btnGuardar.setBackground(new java.awt.Color(18, 44, 82));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setOpaque(true);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnGuardarKeyReleased(evt);
            }
        });
        add(btnGuardar);
        btnGuardar.setBounds(620, 460, 120, 40);

        lblCedula.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        add(lblCedula);
        lblCedula.setBounds(150, 480, 160, 15);

        lblApellido.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        add(lblApellido);
        lblApellido.setBounds(150, 180, 160, 15);

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        add(lblNombre);
        lblNombre.setBounds(150, 120, 160, 15);

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        add(lblEmail);
        lblEmail.setBounds(150, 300, 160, 15);

        lblTelefono.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        add(lblTelefono);
        lblTelefono.setBounds(150, 360, 160, 15);

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        add(lblDireccion);
        lblDireccion.setBounds(150, 420, 160, 15);

        foto.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Vista/Acces/Imagenes/UsuarioImg.png"))); // NOI18N
        foto.setLayout(null);

        botonluna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/botonluna.png"))); // NOI18N
        botonluna.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonluna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonlunaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonlunaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonlunaMousePressed(evt);
            }
        });
        foto.add(botonluna);
        botonluna.setBounds(0, 100, 150, 60);

        add(foto);
        foto.setBounds(590, 200, 150, 150);
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed

    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed

    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailActionPerformed

    }//GEN-LAST:event_txtMailActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed

    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed

    }//GEN-LAST:event_txtCedulaActionPerformed

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        btnGuardar.setBackground(new Color(18, 79, 82));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        btnGuardar.setBackground(new Color(18, 44, 82));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        guardar();
        

    }//GEN-LAST:event_btnGuardarMousePressed
    public void guardar(){
                if (validaCampoCedula && validaCampoEmail && telefonoValido && validaNombre && validaApellido && validaDireccion && dcFechaN.getDate() != null && cbSexo.getSelectedItem() != null && cbEstadoCivil.getSelectedItem() != null) {
            
            ControladorPersona ctr = new ControladorPersona();
            ctr.newPersona();
            SecureRandom sc = new SecureRandom();
            Integer secure = sc.nextInt(1000000000);
            Long generator = secure.longValue();
            ctr.agregarPersona().setIdPersona(generator);
            ctr.agregarPersona().setCedula(txtCedula.getText());
            ctr.agregarPersona().setNombre(txtNombres.getText());
            ctr.agregarPersona().setApellido(txtApellidos.getText());
            ctr.agregarPersona().setFechaNacimiento(fech.getFecha(dcFechaN));
            ctr.agregarPersona().setDireccion(txtDireccion.getText());
            ctr.agregarPersona().setEstadoCivil(cbEstadoCivil.getSelectedItem().toString());
            ctr.agregarPersona().setSexo(cbSexo.getSelectedItem().toString());
            ctr.agregarPersona().setTelefono(txtTelefono.getText());
            ctr.agregarPersona().setMail(txtMail.getText());
            ctr.agregarPersona().setFile(file);
            ctr.agregarPersona().setEstado(Boolean.TRUE);
            ctr.agregarPersona().setIdRol(2L);
            ctr.guardarPersona();
            
            if (ctr.isCorrect()) {
                txtApellidos.setText("");
                txtCedula.setText("");
                txtDireccion.setText("");
                txtMail.setText("");
                txtNombres.setText("");
                txtTelefono.setText("");
                lblApellido.setText("");
                lblCedula.setText("");
                lblDireccion.setText("");
                lblEmail.setText("");
                lblNombre.setText("");
                lblTelefono.setText("");
                Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Vista/Acces/Imagenes/UsuarioImg.png"));
                foto.setImagen(new ImageIcon(uti.img(img, foto.getSize())));
                JOptionPane.showMessageDialog(null, "Persona agregada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "A sucedido un error mientras intentaba guardar revise la informacion e intente nuevamente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Datos faltantes o erroneos");
        }
    }
    boolean validaCampoCedula;
    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
        
        validaCampoCedula = uti.isEcuadorianDocumentValid(txtCedula.getText());
        
        if (validaCampoCedula) {
            lblCedula.setText("CI. Valido");
            lblCedula.setForeground(Color.green);
        } else {
            lblCedula.setText("CI. Invalido");
            lblCedula.setForeground(Color.red);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Caracteres invalidos solo puede ingresar numeros");
            // ignorar el evento de teclado
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaKeyTyped
    boolean validaCampoEmail;
    private void txtMailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailKeyReleased
        validaCampoEmail = uti.validarDireccionCorreoElectronico(txtMail.getText());
        if (validaCampoEmail) {
            lblEmail.setText("Correo. Valido");
            lblEmail.setForeground(Color.green);
        } else {
            lblEmail.setText("Correo. Invalido");
            lblEmail.setForeground(Color.red);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailKeyReleased

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito

        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Caracteres invalidos solo puede ingresar numeros");
            // ignorar el evento de teclado
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        if (!Character.isLetter(evt.getKeyChar()) && !(evt.getKeyChar() == KeyEvent.VK_SPACE) && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Caracteres invalidos no se permiten numeros en el Nombre");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        if (!Character.isLetter(evt.getKeyChar()) && !(evt.getKeyChar() == KeyEvent.VK_SPACE) && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Caracteres invalidos no se permiten numeros en el Apellido");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosKeyTyped
    boolean telefonoValido;
    boolean validaNombre;
    private void txtNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyReleased
        if (txtNombres.getText().length() > 7 && txtNombres.getText().contains(" ")) {
            validaNombre = true;
            lblNombre.setText("Nombre. Valido");
            lblNombre.setForeground(Color.green);
        } else {
            validaNombre = false;
            lblNombre.setText("Nombre. Invalido");
            lblNombre.setForeground(Color.red);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresKeyReleased
    boolean validaApellido;
    private void txtApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyReleased
        if (txtApellidos.getText().length() > 7 && txtApellidos.getText().contains(" ")) {
            validaApellido = true;
            lblApellido.setText("Apellido. Valido");
            lblApellido.setForeground(Color.green);
        } else {
            validaApellido = false;
            lblApellido.setText("Apellido. Invalido");
            lblApellido.setForeground(Color.red);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosKeyReleased
    boolean validaDireccion;
    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        if (txtDireccion.getText().length() > 4) {
            validaDireccion = true;
            lblDireccion.setText("Dirección. Valida");
            lblDireccion.setForeground(Color.green);
        } else {
            validaDireccion = false;
            lblDireccion.setText("Dirección. Invalida");
            lblDireccion.setForeground(Color.red);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        System.out.println("Que??");
        if (txtTelefono.getText().length() == 10) {
            telefonoValido = true;
            lblTelefono.setText("Telefono. Valido");
            lblTelefono.setForeground(Color.green);
        } else {
            telefonoValido = false;
            lblTelefono.setText("Telefono. Invalido");
            lblTelefono.setForeground(Color.red);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void botonlunaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonlunaMouseEntered
        botonluna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/botonluna2.png"))); // TODO add your handling code here:
    }//GEN-LAST:event_botonlunaMouseEntered

    private void botonlunaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonlunaMouseExited
        botonluna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/botonluna.png")));// TODO add your handling code here:
    }//GEN-LAST:event_botonlunaMouseExited
    File file = null;
    private void botonlunaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonlunaMousePressed
        file = uti.BuscarImagen();
        if (file != null) {
            ImageIcon ico = new ImageIcon(file.getAbsolutePath());
            foto.setImagen(ico);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_botonlunaMousePressed

    private void btnGuardarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            guardar();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botonluna;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JComboBox<String> cbEstadoCivil;
    private javax.swing.JComboBox<String> cbSexo;
    private com.toedter.calendar.JDateChooser dcFechaN;
    private rojerusan.RSPanelCircleImage foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
