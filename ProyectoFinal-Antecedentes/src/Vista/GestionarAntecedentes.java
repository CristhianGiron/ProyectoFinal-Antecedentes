/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Condena;
import Modelo.Juzgado;
import Modelo.Proceso;
import Vista.Utiles.GestionCeldas;
import Vista.Utiles.GestionEncabezadoTabla;
import Vista.Utiles.TablaAntecedentes.UtilidadesTablaAntecedentes;
import Vista.Utiles.ModeloTabla;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

/**
 *
 * @author hp
 */
public class GestionarAntecedentes extends javax.swing.JPanel {
    /**
     * Creates new form GestionarAntecedentes
     */
    
    File fichero;
    ArrayList<Proceso> listaProceso;
    ArrayList<Condena> listaCondena;
    ArrayList<Juzgado> listaJuzgado;
    ModeloTabla modelo;
    private int filasTabla;
    private int columnasTabla;
    
    public GestionarAntecedentes() {
        initComponents();
        IconoBorrarArchivo.setVisible(false);
        lbIconoArchivo.setVisible(false);
        lbNombreArchivo.setVisible(false);
        rbEnProceso.setEnabled(false);
        rbEnProceso.setSelected(true);
        //construirTabla();
    }

    private void construirTabla() {

        listaProceso = consultarListaProcesos();
        listaCondena = consultarListaCondena();
        listaJuzgado = consultarListaJuzgado();

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Delito");
        titulosList.add("Art.");
        titulosList.add("Condena");
        titulosList.add("Fecha de Inicio");
        titulosList.add("Fecha de Finalización");
        titulosList.add("Juzgado");
        titulosList.add(" ");
        titulosList.add(" ");

        //se asignan las columnas al arreglo para enviarse al momento de construir la tabla
        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        /*obtenemos los datos de la lista y los guardamos en la matriz
		 * que luego se manda a construir la tabla
         */
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);

    }
    
    private ArrayList<Proceso> consultarListaProcesos(){
        ArrayList<Proceso> lista = new ArrayList<>();
        lista.add(new Proceso(111, "Ejecutivo", "Peculado", 1, pasarStringDate("12-01-2021"), null , 9, "4 meses", null, "si", "no"));
        lista.add(new Proceso(222, "Ejecutivo", "Peculado", 1, pasarStringDate("12-01-2021"), null , 9, "4 meses", null, "si", "no"));
        lista.add(new Proceso(333, "Ejecutivo", "Peculado", 1, pasarStringDate("12-01-2021"), null , 9, "4 meses", null, "si", "no"));
        lista.add(new Proceso(333, "Ejecutivo", "Peculado", 1, pasarStringDate("12-01-2021"), null , 9, "4 meses", null, "si", "no"));

        return lista;
    }
    
    public Date pasarStringDate(String s){
        Date fecha = null;
        try {
            SimpleDateFormat aux = new SimpleDateFormat("dd-MM-yyyy");            
            fecha = aux.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return fecha;
    }
    
    private ArrayList<Condena> consultarListaCondena(){
        ArrayList<Condena> lista = new ArrayList<>();
        lista.add(new Condena(111, "Monetaria", "Que pague mil triños de berris", "si"));
        lista.add(new Condena(222, "Monetaria", "Que pague mil triños de berris", "si"));
        lista.add(new Condena(333, "Monetaria", "Que pague mil triños de berris", "si"));
        lista.add(new Condena(333, "Monetaria", "Que pague mil triños de berris", "si"));

        return lista;
    }
    
    private ArrayList<Juzgado> consultarListaJuzgado(){
        ArrayList<Juzgado> lista = new ArrayList<>();
        

        return lista;
    }
    
    private void construirTabla(String[] titulos, Object[][] data) {
        modelo = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        tablaAntecedentes.setModel(modelo);

        filasTabla = tablaAntecedentes.getRowCount();
        columnasTabla = tablaAntecedentes.getColumnCount();

        //se asigna el tipo de dato que tendrón las celdas de cada columna definida respectivamente para validar su personalización;
        tablaAntecedentes.getColumnModel().getColumn(UtilidadesTablaAntecedentes.PERFIL).setCellRenderer(new GestionCeldas("icono"));
        tablaAntecedentes.getColumnModel().getColumn(UtilidadesTablaAntecedentes.EVENTO).setCellRenderer(new GestionCeldas("icono"));

        //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
        for (int i = 0; i < titulos.length - 2; i++) {//se resta 2 porque las ultimas 2 columnas se definen arriba
            tablaAntecedentes.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
        }

        tablaAntecedentes.getTableHeader().setReorderingAllowed(false);
        tablaAntecedentes.setRowHeight(25);//tamano de las celdas
        tablaAntecedentes.setGridColor(new java.awt.Color(0, 0, 0));
        //Se define el tamaño de largo para cada columna y su contenido
        tablaAntecedentes.getColumnModel().getColumn(UtilidadesTablaAntecedentes.DELITO).setPreferredWidth(130);
        tablaAntecedentes.getColumnModel().getColumn(UtilidadesTablaAntecedentes.CONDENA).setPreferredWidth(450);
        tablaAntecedentes.getColumnModel().getColumn(UtilidadesTablaAntecedentes.FECHAINICIO).setPreferredWidth(100);
        tablaAntecedentes.getColumnModel().getColumn(UtilidadesTablaAntecedentes.FECHAFINALIZACION).setPreferredWidth(100);
        tablaAntecedentes.getColumnModel().getColumn(UtilidadesTablaAntecedentes.JUZGADO).setPreferredWidth(180);
        tablaAntecedentes.getColumnModel().getColumn(UtilidadesTablaAntecedentes.PERFIL).setPreferredWidth(35);
        tablaAntecedentes.getColumnModel().getColumn(UtilidadesTablaAntecedentes.EVENTO).setPreferredWidth(35);
        

        //personaliza el encabezado
        JTableHeader jtableHeader = tablaAntecedentes.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tablaAntecedentes.setTableHeader(jtableHeader);

    }
    
    
    
    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

        /*se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los usuarios, mientras que las columnas son estaticas
		 * correspondiendo a las columnas definidas por defecto
         */
        String informacion[][] = new String[listaProceso.size()][titulosList.size()];
        for (int x = 0; x < informacion.length ; x++) {

            informacion[x][UtilidadesTablaAntecedentes.DELITO] = listaProceso.get(x).getDelito()+ "";
            informacion[x][UtilidadesTablaAntecedentes.CONDENA] = listaCondena.get(x).getSentencia()+ "";
            informacion[x][UtilidadesTablaAntecedentes.FECHAINICIO] = (new SimpleDateFormat("dd-MM-yyyy").format(listaProceso.get(x).getFechaInicio())) + "";
            String ff = (listaProceso.get(x).getFechaFinal() != null)?(new SimpleDateFormat("dd-MM-yyyy").format(listaProceso.get(x).getFechaFinal())):"Sin fecha";
            informacion[x][UtilidadesTablaAntecedentes.FECHAFINALIZACION] =  ff + "";
            informacion[x][UtilidadesTablaAntecedentes.JUZGADO] = listaJuzgado.get(x).getNombreJuzgado()+ "";
            //se asignan las plabras clave para que en la clase GestionCeldas se use para asignar el icono correspondiente
            informacion[x][UtilidadesTablaAntecedentes.PERFIL] = "PERFIL";
            informacion[x][UtilidadesTablaAntecedentes.EVENTO] = "EVENTO";
        }
        
        return informacion;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        PanelComponentes = new javax.swing.JPanel();
        LabelTitulo = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombreApellido = new javax.swing.JTextField();
        lbLinea = new javax.swing.JLabel();
        lbNombreApellido = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbCedula = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbFechaInicioAudiencia1 = new javax.swing.JLabel();
        dcFechaFinalizacionAudiencia = new com.toedter.calendar.JDateChooser();
        lbDuracionAudiencia = new javax.swing.JLabel();
        txDuracionAudiencia = new javax.swing.JTextField();
        lbIntancia = new javax.swing.JLabel();
        txtIntancia = new javax.swing.JTextField();
        lbNrAudiencia = new javax.swing.JLabel();
        txtNrAudiencia = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        rbEnProceso = new javax.swing.JRadioButton();
        rbFinalizado = new javax.swing.JRadioButton();
        lbEstadoProceso = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbTipoCondena = new javax.swing.JLabel();
        cbxTipoCondena = new javax.swing.JComboBox<>();
        lbSentencia = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSentencia = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        lbNombreArchivo = new javax.swing.JLabel();
        lbIconoArchivo = new javax.swing.JLabel();
        IconoBorrarArchivo = new javax.swing.JLabel();
        botonSubir = new javax.swing.JPanel();
        lbIconoSubir = new javax.swing.JLabel();
        lbSubirArchivo = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JPanel();
        IconoBuscar = new javax.swing.JLabel();
        lbBuscar = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JPanel();
        lbIconoGuardar = new javax.swing.JLabel();
        lbGuardar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAntecedentes = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1000, 610));
        setLayout(null);

        jScrollPane4.setPreferredSize(new java.awt.Dimension(1072, 600));

        PanelComponentes.setBackground(new java.awt.Color(255, 255, 255));
        PanelComponentes.setPreferredSize(new java.awt.Dimension(600, 1090));
        PanelComponentes.setVerifyInputWhenFocusTarget(false);
        PanelComponentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelComponentesMouseExited(evt);
            }
        });
        PanelComponentes.setLayout(null);

        LabelTitulo.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        LabelTitulo.setText("AGREGAR ANTECEDENTES");
        LabelTitulo.setToolTipText("");
        PanelComponentes.add(LabelTitulo);
        LabelTitulo.setBounds(233, 11, 274, 32);

        txtCedula.setBackground(new java.awt.Color(240, 240, 240));
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        PanelComponentes.add(txtCedula);
        txtCedula.setBounds(50, 90, 219, 30);

        txtNombreApellido.setBackground(new java.awt.Color(240, 240, 240));
        txtNombreApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreApellidoActionPerformed(evt);
            }
        });
        PanelComponentes.add(txtNombreApellido);
        txtNombreApellido.setBounds(465, 90, 319, 30);

        lbLinea.setText("___________________________________________________________________________________________________________________");
        lbLinea.setMaximumSize(new java.awt.Dimension(600, 14));
        lbLinea.setPreferredSize(new java.awt.Dimension(600, 14));
        PanelComponentes.add(lbLinea);
        lbLinea.setBounds(0, 190, 971, 20);

        lbNombreApellido.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbNombreApellido.setText("Nombre y Apellido");
        lbNombreApellido.setToolTipText("");
        PanelComponentes.add(lbNombreApellido);
        lbNombreApellido.setBounds(465, 50, 114, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("*");
        PanelComponentes.add(jLabel5);
        jLabel5.setBounds(451, 52, 8, 17);

        lbCedula.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbCedula.setText("Cédula");
        lbCedula.setToolTipText("");
        PanelComponentes.add(lbCedula);
        lbCedula.setBounds(50, 50, 42, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("*");
        PanelComponentes.add(jLabel11);
        jLabel11.setBounds(40, 50, 10, 17);

        lbFechaInicioAudiencia1.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbFechaInicioAudiencia1.setText("Fecha de Finalización de la Audiencia:");
        lbFechaInicioAudiencia1.setToolTipText("");
        PanelComponentes.add(lbFechaInicioAudiencia1);
        lbFechaInicioAudiencia1.setBounds(76, 534, 226, 20);

        dcFechaFinalizacionAudiencia.setDateFormatString("dd/MM/yyyy");
        dcFechaFinalizacionAudiencia.setIcon(new ImageIcon(getClass().getResource("/Vista/Iconos/IconoCalendario2.png")));
        PanelComponentes.add(dcFechaFinalizacionAudiencia);
        dcFechaFinalizacionAudiencia.setBounds(320, 524, 130, 30);

        lbDuracionAudiencia.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbDuracionAudiencia.setText("Duración:");
        lbDuracionAudiencia.setToolTipText("");
        PanelComponentes.add(lbDuracionAudiencia);
        lbDuracionAudiencia.setBounds(497, 534, 58, 20);

        txDuracionAudiencia.setText("N");
        txDuracionAudiencia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txDuracionAudiencia.setEnabled(false);
        txDuracionAudiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDuracionAudienciaActionPerformed(evt);
            }
        });
        PanelComponentes.add(txDuracionAudiencia);
        txDuracionAudiencia.setBounds(573, 524, 49, 30);

        lbIntancia.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbIntancia.setText("Intancia:");
        lbIntancia.setToolTipText("");
        PanelComponentes.add(lbIntancia);
        lbIntancia.setBounds(76, 575, 49, 20);

        txtIntancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIntanciaActionPerformed(evt);
            }
        });
        PanelComponentes.add(txtIntancia);
        txtIntancia.setBounds(143, 572, 66, 30);

        lbNrAudiencia.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbNrAudiencia.setText("Nr Audiencia:");
        lbNrAudiencia.setToolTipText("");
        PanelComponentes.add(lbNrAudiencia);
        lbNrAudiencia.setBounds(320, 575, 81, 20);

        txtNrAudiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNrAudienciaActionPerformed(evt);
            }
        });
        PanelComponentes.add(txtNrAudiencia);
        txtNrAudiencia.setBounds(419, 572, 66, 30);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setText("*");
        PanelComponentes.add(jLabel21);
        jLabel21.setBounds(60, 577, 10, 17);

        rbEnProceso.setBackground(new java.awt.Color(255, 255, 255));
        rbEnProceso.setSelected(true);
        rbEnProceso.setText("En Proceso");
        rbEnProceso.setFocusPainted(false);
        rbEnProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEnProcesoActionPerformed(evt);
            }
        });
        PanelComponentes.add(rbEnProceso);
        rbEnProceso.setBounds(211, 621, 78, 22);

        rbFinalizado.setBackground(new java.awt.Color(255, 255, 255));
        rbFinalizado.setText("Finalizado");
        rbFinalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFinalizadoActionPerformed(evt);
            }
        });
        PanelComponentes.add(rbFinalizado);
        rbFinalizado.setBounds(307, 621, 73, 23);

        lbEstadoProceso.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbEstadoProceso.setText("Estado del Proceso:");
        lbEstadoProceso.setToolTipText("");
        PanelComponentes.add(lbEstadoProceso);
        lbEstadoProceso.setBounds(76, 620, 117, 20);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 0, 0));
        jLabel22.setText("*");
        PanelComponentes.add(jLabel22);
        jLabel22.setBounds(200, 840, 10, 17);

        lbTipoCondena.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbTipoCondena.setText("Tipo de Condena:");
        lbTipoCondena.setToolTipText("");
        PanelComponentes.add(lbTipoCondena);
        lbTipoCondena.setBounds(76, 665, 107, 20);

        cbxTipoCondena.setBackground(new java.awt.Color(240, 240, 240));
        cbxTipoCondena.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        PanelComponentes.add(cbxTipoCondena);
        cbxTipoCondena.setBounds(201, 662, 210, 30);

        lbSentencia.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbSentencia.setText("Sentencia:");
        lbSentencia.setToolTipText("");
        PanelComponentes.add(lbSentencia);
        lbSentencia.setBounds(76, 710, 60, 20);

        txtSentencia.setColumns(20);
        txtSentencia.setRows(5);
        jScrollPane3.setViewportView(txtSentencia);

        PanelComponentes.add(jScrollPane3);
        jScrollPane3.setBounds(76, 741, 335, 76);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNombreArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lbNombreArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 317, 21));

        lbIconoArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/PDF file icon_page-0001.png"))); // NOI18N
        jPanel3.add(lbIconoArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        IconoBorrarArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/IconoCerrar.png"))); // NOI18N
        IconoBorrarArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IconoBorrarArchivoMouseClicked(evt);
            }
        });
        jPanel3.add(IconoBorrarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 20, -1));

        PanelComponentes.add(jPanel3);
        jPanel3.setBounds(224, 840, 331, 131);

        botonSubir.setBackground(new java.awt.Color(18, 44, 82));
        botonSubir.setPreferredSize(new java.awt.Dimension(140, 46));
        botonSubir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSubirMouseClicked(evt);
            }
        });

        lbIconoSubir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/IconoSubir.png"))); // NOI18N

        lbSubirArchivo.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 16)); // NOI18N
        lbSubirArchivo.setForeground(new java.awt.Color(204, 206, 223));
        lbSubirArchivo.setText("Subir Archivo");

        javax.swing.GroupLayout botonSubirLayout = new javax.swing.GroupLayout(botonSubir);
        botonSubir.setLayout(botonSubirLayout);
        botonSubirLayout.setHorizontalGroup(
            botonSubirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonSubirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSubirArchivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(lbIconoSubir)
                .addContainerGap())
        );
        botonSubirLayout.setVerticalGroup(
            botonSubirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonSubirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(botonSubirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbIconoSubir)
                    .addComponent(lbSubirArchivo))
                .addGap(0, 0, 0))
        );

        PanelComponentes.add(botonSubir);
        botonSubir.setBounds(309, 989, 147, 22);

        botonBuscar.setBackground(new java.awt.Color(18, 44, 82));
        botonBuscar.setPreferredSize(new java.awt.Dimension(140, 46));
        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBuscarMouseClicked(evt);
            }
        });

        IconoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/IconoBuscar1.png"))); // NOI18N

        lbBuscar.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 16)); // NOI18N
        lbBuscar.setForeground(new java.awt.Color(204, 206, 223));
        lbBuscar.setText("Buscar");

        javax.swing.GroupLayout botonBuscarLayout = new javax.swing.GroupLayout(botonBuscar);
        botonBuscar.setLayout(botonBuscarLayout);
        botonBuscarLayout.setHorizontalGroup(
            botonBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(IconoBuscar)
                .addContainerGap())
        );
        botonBuscarLayout.setVerticalGroup(
            botonBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonBuscarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(botonBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(IconoBuscar)
                    .addComponent(lbBuscar))
                .addGap(0, 0, 0))
        );

        PanelComponentes.add(botonBuscar);
        botonBuscar.setBounds(327, 163, 105, 22);

        botonGuardar.setBackground(new java.awt.Color(18, 44, 82));
        botonGuardar.setPreferredSize(new java.awt.Dimension(140, 46));
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarMouseClicked(evt);
            }
        });

        lbIconoGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/IconoGuardar.png"))); // NOI18N
        lbIconoGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIconoGuardarMouseClicked(evt);
            }
        });

        lbGuardar.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 16)); // NOI18N
        lbGuardar.setForeground(new java.awt.Color(204, 206, 223));
        lbGuardar.setText("Guardar");

        javax.swing.GroupLayout botonGuardarLayout = new javax.swing.GroupLayout(botonGuardar);
        botonGuardar.setLayout(botonGuardarLayout);
        botonGuardarLayout.setHorizontalGroup(
            botonGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonGuardarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(lbIconoGuardar)
                .addContainerGap())
        );
        botonGuardarLayout.setVerticalGroup(
            botonGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonGuardarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(botonGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbIconoGuardar)
                    .addComponent(lbGuardar))
                .addGap(0, 0, 0))
        );

        PanelComponentes.add(botonGuardar);
        botonGuardar.setBounds(328, 1057, 114, 22);

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
        jScrollPane1.setViewportView(tablaAntecedentes);

        PanelComponentes.add(jScrollPane1);
        jScrollPane1.setBounds(10, 220, 960, 280);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 0, 0));
        jLabel23.setText("*");
        PanelComponentes.add(jLabel23);
        jLabel23.setBounds(60, 622, 10, 17);

        jScrollPane4.setViewportView(PanelComponentes);

        add(jScrollPane4);
        jScrollPane4.setBounds(0, 0, 1000, 610);
    }// </editor-fold>//GEN-END:initComponents

    private void PanelComponentesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelComponentesMouseExited
        txtNombreApellido.setFocusable(true);        // TODO add your handling code here:
    }//GEN-LAST:event_PanelComponentesMouseExited

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
        JOptionPane.showMessageDialog(null, "Se ha guardado con éxito");
    }//GEN-LAST:event_botonGuardarMouseClicked

    private void botonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBuscarMouseClicked

    }//GEN-LAST:event_botonBuscarMouseClicked

    private void botonSubirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSubirMouseClicked
        necesario.RSFileChooser fc = new necesario.RSFileChooser();//Creamos el objeto JFileChooser
        int seleccion = fc.showOpenDialog(this);//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
        if (seleccion == JFileChooser.APPROVE_OPTION) { //Si el usuario selecciona aceptar
            IconoBorrarArchivo.setVisible(true);
            lbIconoArchivo.setVisible(true);
            fichero = fc.getSelectedFile();//Seleccionamos el fichero
            lbNombreArchivo.setVisible(true);
            lbNombreArchivo.setText(fichero.getName());//Escribimos el nombre del archivo
        }
    }//GEN-LAST:event_botonSubirMouseClicked

    private void IconoBorrarArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IconoBorrarArchivoMouseClicked
        IconoBorrarArchivo.setVisible(false);
        lbIconoArchivo.setVisible(false);
        lbNombreArchivo.setVisible(false);
        lbNombreArchivo.setText("");
        fichero = null;
    }//GEN-LAST:event_IconoBorrarArchivoMouseClicked

    private void rbFinalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFinalizadoActionPerformed
        if (rbFinalizado.isSelected()) {
            rbFinalizado.setEnabled(false);
            rbEnProceso.setEnabled(true);
            rbEnProceso.setSelected(false);
        }
    }//GEN-LAST:event_rbFinalizadoActionPerformed

    private void rbEnProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEnProcesoActionPerformed
        if (rbEnProceso.isSelected()) {
            rbEnProceso.setEnabled(false);
            rbFinalizado.setEnabled(true);
            rbFinalizado.setSelected(false);
        }
    }//GEN-LAST:event_rbEnProcesoActionPerformed

    private void txtNrAudienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNrAudienciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNrAudienciaActionPerformed

    private void txtIntanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIntanciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIntanciaActionPerformed

    private void txDuracionAudienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDuracionAudienciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDuracionAudienciaActionPerformed

    private void txtNombreApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreApellidoActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void tablaAntecedentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAntecedentesMouseClicked
        System.out.println("*****Ejecutando evento");
        //capturo fila o columna dependiendo de mi necesidad
        int fila = tablaAntecedentes.rowAtPoint(evt.getPoint());
        int columna = tablaAntecedentes.columnAtPoint(evt.getPoint());

        /*uso la columna para valiar si corresponde a la columna de perfil garantizando
		 * que solo se produzca algo si selecciono una fila de esa columna
         */
        if (columna == UtilidadesTablaAntecedentes.PERFIL) {
            //sabiendo que corresponde a la columna de perfil, envio la posicion de la fila seleccionada
            validarSeleccionMouse(fila);
        } else if (columna == UtilidadesTablaAntecedentes.EVENTO) {//se valida que sea la columna del otro evento
            JOptionPane.showMessageDialog(null, "Evento del otro icono");
        }
    }//GEN-LAST:event_tablaAntecedentesMouseClicked

    private void lbIconoGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIconoGuardarMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Se ha editado con éxito");
    }//GEN-LAST:event_lbIconoGuardarMouseClicked

    private void validarSeleccionMouse(int fila) {
        /*UtilidadesTablaAntecedentes.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
        Persona miPersona = new Persona();
        miPersona.setCedula(tablaPersonas.getValueAt(fila, Utilidades.CEDULA).toString());
        miPersona.setNombre(tablaPersonas.getValueAt(fila, Utilidades.NOMBRE).toString());

        String info = "INFO PERSONA\n";
        info += "Documento: " + miPersona.getCedula() + "\n";
        info += "Nombre: " + miPersona.getNombre() + "\n";

        JOptionPane.showMessageDialog(null, info);*/
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconoBorrarArchivo;
    private javax.swing.JLabel IconoBuscar;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel PanelComponentes;
    private javax.swing.JPanel botonBuscar;
    private javax.swing.JPanel botonGuardar;
    private javax.swing.JPanel botonSubir;
    private javax.swing.JComboBox<String> cbxTipoCondena;
    private com.toedter.calendar.JDateChooser dcFechaFinalizacionAudiencia;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbBuscar;
    private javax.swing.JLabel lbCedula;
    private javax.swing.JLabel lbDuracionAudiencia;
    private javax.swing.JLabel lbEstadoProceso;
    private javax.swing.JLabel lbFechaInicioAudiencia1;
    private javax.swing.JLabel lbGuardar;
    private javax.swing.JLabel lbIconoArchivo;
    private javax.swing.JLabel lbIconoGuardar;
    private javax.swing.JLabel lbIconoSubir;
    private javax.swing.JLabel lbIntancia;
    private javax.swing.JLabel lbLinea;
    private javax.swing.JLabel lbNombreApellido;
    private javax.swing.JLabel lbNombreArchivo;
    private javax.swing.JLabel lbNrAudiencia;
    private javax.swing.JLabel lbSentencia;
    private javax.swing.JLabel lbSubirArchivo;
    private javax.swing.JLabel lbTipoCondena;
    private javax.swing.JRadioButton rbEnProceso;
    private javax.swing.JRadioButton rbFinalizado;
    private javax.swing.JTable tablaAntecedentes;
    private javax.swing.JTextField txDuracionAudiencia;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtIntancia;
    private javax.swing.JTextField txtNombreApellido;
    private javax.swing.JTextField txtNrAudiencia;
    private javax.swing.JTextArea txtSentencia;
    // End of variables declaration//GEN-END:variables
}
