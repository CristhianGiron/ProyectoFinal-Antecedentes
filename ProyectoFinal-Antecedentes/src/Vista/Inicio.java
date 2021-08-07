/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import ControlAdminDatos.PersonaDao;
import Controlador.CondenaDao;
import Controlador.ControladorPersona;
import Controlador.DelitoDao;
import Controlador.JuzgadoDao;
import Controlador.ProcesoDao;
import Controlador.Utilidades.UtilidadesInicio;
import Modelo.Proceso;
import Vista.Utiles.EncabezadoTablaInicio;
import Vista.Utiles.GestionCeldas;
import Vista.Utiles.GestionEncabezadoTabla;
import Vista.Utiles.ModeloTabla;
import Vista.Utiles.TablaAntecedentes.UtilidadesTablaAntecedentes;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

import Controlador.ControladorPersona;
import Controlador.Utilidades.UtilAgreGesAnt;
import Modelo.Condena;
import Modelo.Delito;
import Modelo.Juzgado;
import Modelo.Persona;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import necesario.RSFileChooser;

/**
 *
 * @author hp
 */
public class Inicio extends javax.swing.JPanel {

    /**
     * Creates new form Inicio
     */
    PersonaDao pd = new PersonaDao();
    Persona aux = null;
    ModeloTabla modelo;
    ArrayList<Proceso> listaProcesos = new ArrayList<>();
    ProcesoDao prcd = new ProcesoDao();
    DelitoDao dd = new DelitoDao();
    JuzgadoDao jd = new JuzgadoDao();
    CondenaDao cd = new CondenaDao();
    byte[] auxByte = null;
    File fichero = null;

    public Inicio() {
        initComponents();
        botonDescargar3.setVisible(false);
        cargarLista();
    }

    /**
     * Carga la lista necesaria para llenar la tabla
     */
    public void cargarLista() {
        if (aux != null) {
            listaProcesos = prcd.listaProcesoPersona(aux.getIdPersona(), false);
        }
        construirTabla();
    }

    /**
     * Construye la tabla segun los datos y titulos
     */
    private void construirTabla() {

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add(" ");

        //se asignan las columnas al arreglo para enviarse al momento de construir la tabla
        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        /*obtenemos los datos de la lista y los guardamos en la matriz
		 * que luego se manda a construir la tabla
         */
        Object[][] data = UtilidadesInicio.obtenerMatrizDatos(titulosList, listaProcesos, dd);
        construirTabla(titulos, data);

    }

    /**
     * Construye la tabla segun los datos y botones
     *
     * @param titulos
     * @param data
     */
    private void construirTabla(String[] titulos, Object[][] data) {
        modelo = new ModeloTabla(data, titulos);
        modelo.setRowCount(0);
        modelo = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        tablaAntecedentes.setModel(modelo);

        //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
        for (int i = 0; i < titulos.length; i++) {//se resta 1 porque las ultimas 1 columnas se definen arriba
            tablaAntecedentes.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
        }

        tablaAntecedentes.getTableHeader().setReorderingAllowed(false);
        tablaAntecedentes.setRowHeight(25);//tamano de las celdas
        tablaAntecedentes.setGridColor(new java.awt.Color(0, 0, 0));
        //Se define el tamaño de largo para cada columna y su contenido
        tablaAntecedentes.getColumnModel().getColumn(UtilidadesTablaAntecedentes.DELITO).setPreferredWidth(500);

        //personaliza el encabezado
        JTableHeader jtableHeader = tablaAntecedentes.getTableHeader();
        jtableHeader.setDefaultRenderer(new EncabezadoTablaInicio());
        tablaAntecedentes.setTableHeader(jtableHeader);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        PanelComponentes = new javax.swing.JPanel();
        txtNombreApellido = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        foto = new rojerusan.RSPanelCircleImage();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lbNombreApellido = new javax.swing.JLabel();
        lbCedula = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAntecedentes = new javax.swing.JTable();
        botonBuscar = new javax.swing.JPanel();
        IconoBuscar1 = new javax.swing.JLabel();
        lbBuscar1 = new javax.swing.JLabel();
        panelInformacion = new javax.swing.JPanel();
        lbTEsJui = new javax.swing.JLabel();
        lbTCon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taCondena = new javax.swing.JTextArea();
        lbTJuz = new javax.swing.JLabel();
        lbTDoc = new javax.swing.JLabel();
        botonDescargar3 = new javax.swing.JPanel();
        lbBuscar5 = new javax.swing.JLabel();
        lbJuzgado = new javax.swing.JLabel();
        lbEstJui = new javax.swing.JLabel();
        lbDelito = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 610));
        setLayout(null);

        jScrollPane6.setPreferredSize(new java.awt.Dimension(1072, 600));

        PanelComponentes.setBackground(new java.awt.Color(255, 255, 255));
        PanelComponentes.setPreferredSize(new java.awt.Dimension(600, 850));
        PanelComponentes.setVerifyInputWhenFocusTarget(false);
        PanelComponentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelComponentesMouseExited(evt);
            }
        });
        PanelComponentes.setLayout(null);

        txtNombreApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 117, 225)));
        txtNombreApellido.setEnabled(false);
        txtNombreApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreApellidoActionPerformed(evt);
            }
        });
        txtNombreApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreApellidoKeyReleased(evt);
            }
        });
        PanelComponentes.add(txtNombreApellido);
        txtNombreApellido.setBounds(490, 90, 290, 30);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(null);

        foto.setBackground(new java.awt.Color(0, 51, 102));
        foto.setColorBorde(new java.awt.Color(0, 51, 102));
        foto.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Vista/Acces/Imagenes/UsuarioImg.png"))); // NOI18N
        jPanel1.add(foto);
        foto.setBounds(0, 0, 150, 150);

        PanelComponentes.add(jPanel1);
        jPanel1.setBounds(720, 200, 150, 150);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setText("CONSULTAS");
        PanelComponentes.add(jLabel9);
        jLabel9.setBounds(50, 10, 320, 40);
        PanelComponentes.add(jSeparator1);
        jSeparator1.setBounds(10, 50, 980, 10);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Acerca de");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        PanelComponentes.add(jLabel1);
        jLabel1.setBounds(910, 20, 70, 20);

        txtCedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 117, 225)));
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulaKeyReleased(evt);
            }
        });
        PanelComponentes.add(txtCedula);
        txtCedula.setBounds(120, 90, 290, 30);

        lbNombreApellido.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbNombreApellido.setText("Nombre y Apellido");
        lbNombreApellido.setToolTipText("");
        PanelComponentes.add(lbNombreApellido);
        lbNombreApellido.setBounds(490, 60, 114, 20);

        lbCedula.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbCedula.setText("Cédula");
        lbCedula.setToolTipText("");
        PanelComponentes.add(lbCedula);
        lbCedula.setBounds(120, 60, 42, 20);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        PanelComponentes.add(jSeparator2);
        jSeparator2.setBounds(10, 180, 980, 10);

        tablaAntecedentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaAntecedentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAntecedentesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaAntecedentes);

        PanelComponentes.add(jScrollPane2);
        jScrollPane2.setBounds(20, 200, 630, 220);

        botonBuscar.setBackground(new java.awt.Color(204, 204, 204));
        botonBuscar.setPreferredSize(new java.awt.Dimension(140, 46));
        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBuscarMouseClicked(evt);
            }
        });

        IconoBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/IconoBuscar2.png"))); // NOI18N

        lbBuscar1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 16)); // NOI18N
        lbBuscar1.setText("Buscar");

        javax.swing.GroupLayout botonBuscarLayout = new javax.swing.GroupLayout(botonBuscar);
        botonBuscar.setLayout(botonBuscarLayout);
        botonBuscarLayout.setHorizontalGroup(
            botonBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonBuscarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbBuscar1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IconoBuscar1)
                .addContainerGap())
        );
        botonBuscarLayout.setVerticalGroup(
            botonBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonBuscarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(botonBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(IconoBuscar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbBuscar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        PanelComponentes.add(botonBuscar);
        botonBuscar.setBounds(400, 150, 105, 22);

        panelInformacion.setBackground(new java.awt.Color(255, 255, 255));

        lbTEsJui.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbTEsJui.setText("Estado del Juicio:");

        lbTCon.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbTCon.setText("Condena:");

        taCondena.setColumns(20);
        taCondena.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        taCondena.setRows(5);
        taCondena.setEnabled(false);
        taCondena.setFocusable(false);
        jScrollPane1.setViewportView(taCondena);

        lbTJuz.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbTJuz.setText("Juzgado:");

        lbTDoc.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbTDoc.setText("Documento del Jucio:");

        botonDescargar3.setBackground(new java.awt.Color(204, 204, 204));
        botonDescargar3.setPreferredSize(new java.awt.Dimension(140, 46));
        botonDescargar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonDescargarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonDescargar3MouseEntered(evt);
            }
        });

        lbBuscar5.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 16)); // NOI18N
        lbBuscar5.setText("Descargar");

        javax.swing.GroupLayout botonDescargar3Layout = new javax.swing.GroupLayout(botonDescargar3);
        botonDescargar3.setLayout(botonDescargar3Layout);
        botonDescargar3Layout.setHorizontalGroup(
            botonDescargar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonDescargar3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbBuscar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
        botonDescargar3Layout.setVerticalGroup(
            botonDescargar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonDescargar3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbBuscar5)
                .addGap(0, 0, 0))
        );

        lbJuzgado.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N

        lbEstJui.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N

        lbDelito.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 24)); // NOI18N

        javax.swing.GroupLayout panelInformacionLayout = new javax.swing.GroupLayout(panelInformacion);
        panelInformacion.setLayout(panelInformacionLayout);
        panelInformacionLayout.setHorizontalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addComponent(lbTEsJui, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbEstJui, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addComponent(lbTCon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addComponent(lbTJuz, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbJuzgado, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(lbTDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(botonDescargar3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbDelito, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        panelInformacionLayout.setVerticalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDelito, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTEsJui, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEstJui, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTCon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTJuz, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbJuzgado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botonDescargar3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        PanelComponentes.add(panelInformacion);
        panelInformacion.setBounds(20, 430, 950, 410);

        jScrollPane6.setViewportView(PanelComponentes);

        add(jScrollPane6);
        jScrollPane6.setBounds(0, 0, 1000, 610);
    }// </editor-fold>//GEN-END:initComponents

    ControladorPersona ctrp = new ControladorPersona();

    /**
     * Busca los datos de la persona ingresada
     */
    public void buscar() {
        aux = null;

        try {
            aux = pd.obtenerPersona(txtCedula.getText(), "cedula");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se a encontrado a la persona con la cedula \n" + txtCedula.getText());
        }
        if (aux != null) {
            txtNombreApellido.setText(aux.getNombre() + " " + aux.getApellido());
            File file = null;
            file = aux.getFile();
            if (file != null) {
                foto.setImagen(new ImageIcon("Perfiles/" + file.getPath()));
            }
            cargarLista();
        }
    }

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        Runtime r = Runtime.getRuntime();
        Process p = null;

        String comando[] = {"/C:/Program Files/Google/Chrome/Application/chrome.exe/", "/Ayuda/index.html"};
        try {
            p = r.exec(comando);
        } catch (Exception e) {
            String comando1[] = {"/C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe", "/Ayuda/index.html"};
            try {
                p = r.exec(comando1);

            } catch (Exception ex) {
                String comando2[] = {"/C:/Program Files/Mozilla Firefox/firefox.exe", "/Ayuda/index.html"};
                try {
                    p = r.exec(comando2);

                } catch (Exception ex1) {

                }
            }
        }
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jLabel1.setForeground(new Color(51, 51, 51));  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)));
        jLabel1.setForeground(new Color(0, 0, 255));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered
    /**
     * Llama al metodo buscar()
     *
     * @param evt
     */
    private void txtNombreApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreApellidoKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscar();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreApellidoKeyReleased

    private void txtNombreApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreApellidoActionPerformed

    }//GEN-LAST:event_txtNombreApellidoActionPerformed
    /**
     * Llama al metodo buscar()
     *
     * @param evt
     */
    private void botonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBuscarMouseClicked
        if (txtCedula.getText().length() > 0) {
            buscar();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese la Cedula");
        }
    }//GEN-LAST:event_botonBuscarMouseClicked

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed
    /**
     * Muestra la informacion del delito por el cual es acusado la persona al
     * seleccionar dicho delito
     *
     * @param evt
     */
    private void tablaAntecedentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAntecedentesMouseClicked
        int fila = tablaAntecedentes.rowAtPoint(evt.getPoint());
        Proceso tmpPr = listaProcesos.get(fila);
        if (tmpPr != null) {
            botonDescargar3.setVisible(true);
            Delito tmpDe = dd.find(tmpPr.getIdDelito());
            Condena tmpCo = cd.find(tmpPr.getIdCondena());
            Juzgado tmpJu = jd.find(tmpPr.getIdJuzgado());
            lbDelito.setText(tmpDe.getNombre());
            lbEstJui.setText(tmpPr.getEstadoDemanda());
            taCondena.setText(tmpCo.getSentencia());
            lbJuzgado.setText(tmpJu.getNombre());
            auxByte = tmpPr.getText();
        }
    }//GEN-LAST:event_tablaAntecedentesMouseClicked

    private void PanelComponentesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelComponentesMouseExited
        txtNombreApellido.setFocusable(true);        // TODO add your handling code here:
    }//GEN-LAST:event_PanelComponentesMouseExited
    /**
     * Permite descargar el archivo
     *
     * @param evt
     */
    private void botonDescargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonDescargarMouseClicked
        if (auxByte != null) {
            necesario.RSFileChooser guardar = new RSFileChooser();
            guardar.showSaveDialog(null);
            guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            File archivo = guardar.getSelectedFile();
            UtilAgreGesAnt.descargarArchivo(auxByte, archivo);
        }
    }//GEN-LAST:event_botonDescargarMouseClicked

    private void botonDescargar3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonDescargar3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_botonDescargar3MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconoBuscar1;
    private javax.swing.JPanel PanelComponentes;
    private javax.swing.JPanel botonBuscar;
    private javax.swing.JPanel botonDescargar;
    private javax.swing.JPanel botonDescargar2;
    private javax.swing.JPanel botonDescargar3;
    private rojerusan.RSPanelCircleImage foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbBuscar;
    private javax.swing.JLabel lbBuscar1;
    private javax.swing.JLabel lbBuscar4;
    private javax.swing.JLabel lbBuscar5;
    private javax.swing.JLabel lbCedula;
    private javax.swing.JLabel lbDelito;
    private javax.swing.JLabel lbEstJui;
    private javax.swing.JLabel lbJuzgado;
    private javax.swing.JLabel lbNombreApellido;
    private javax.swing.JLabel lbTCon;
    private javax.swing.JLabel lbTDoc;
    private javax.swing.JLabel lbTEsJui;
    private javax.swing.JLabel lbTJuz;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JTextArea taCondena;
    private javax.swing.JTable tablaAntecedentes;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombreApellido;
    // End of variables declaration//GEN-END:variables
}
