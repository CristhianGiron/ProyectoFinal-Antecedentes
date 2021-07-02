/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Juzgado;
import Vista.Utiles.GestionCeldas;
import Vista.Utiles.GestionEncabezadoTabla;
import Vista.Utiles.ModeloTabla;
import Vista.Utiles.TablaJuzgados.UtilidadesTablaJuzgado;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

/**
 *
 * @author hp
 */
public class GestionarJuzgados extends javax.swing.JPanel {

    /**
     * Creates new form AgregarJuzgados
     */
    
    ArrayList<Juzgado> listaJuzgado;
    ModeloTabla modelo;
    private int filasTabla;
    private int columnasTabla;
    
    public GestionarJuzgados() {
        initComponents();
        construirTabla();
    }
    
    private ArrayList<Juzgado> consultarListaJuzgado(){
        ArrayList<Juzgado> lista = new ArrayList<>();
        lista.add(new Juzgado(123, "n1", "d1"));
        lista.add(new Juzgado(234, "n2", "d3"));
        lista.add(new Juzgado(345, "n3", "d4"));
        lista.add(new Juzgado(456, "n4", "d5"));

        return lista;
    }
    
    private void construirTabla() {

        listaJuzgado = consultarListaJuzgado();

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Nombre");
        titulosList.add("Dirección");
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
    
    private void construirTabla(String[] titulos, Object[][] data) {
        modelo = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        tablaJuzgados.setModel(modelo);

        filasTabla = tablaJuzgados.getRowCount();
        columnasTabla = tablaJuzgados.getColumnCount();

        //se asigna el tipo de dato que tendrón las celdas de cada columna definida respectivamente para validar su personalización;
        tablaJuzgados.getColumnModel().getColumn(UtilidadesTablaJuzgado.PERFIL).setCellRenderer(new GestionCeldas("icono"));
        tablaJuzgados.getColumnModel().getColumn(UtilidadesTablaJuzgado.EVENTO).setCellRenderer(new GestionCeldas("icono"));

        //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
        for (int i = 0; i < titulos.length - 2; i++) {//se resta 2 porque las ultimas 2 columnas se definen arriba
            tablaJuzgados.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
        }

        tablaJuzgados.getTableHeader().setReorderingAllowed(false);
        tablaJuzgados.setRowHeight(25);//tamano de las celdas
        tablaJuzgados.setGridColor(new java.awt.Color(0, 0, 0));
        //Se define el tamaño de largo para cada columna y su contenido
        tablaJuzgados.getColumnModel().getColumn(UtilidadesTablaJuzgado.NOMBRE).setPreferredWidth(250);
        tablaJuzgados.getColumnModel().getColumn(UtilidadesTablaJuzgado.DIRECCION).setPreferredWidth(250);
        tablaJuzgados.getColumnModel().getColumn(UtilidadesTablaJuzgado.PERFIL).setPreferredWidth(35);
        tablaJuzgados.getColumnModel().getColumn(UtilidadesTablaJuzgado.EVENTO).setPreferredWidth(35);
        

        //personaliza el encabezado
        JTableHeader jtableHeader = tablaJuzgados.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tablaJuzgados.setTableHeader(jtableHeader);

    }
    
    
    
    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

        /*se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los usuarios, mientras que las columnas son estaticas
		 * correspondiendo a las columnas definidas por defecto
         */
        String informacion[][] = new String[listaJuzgado.size()][titulosList.size()];
        for (int x = 0; x < informacion.length ; x++) {

            informacion[x][UtilidadesTablaJuzgado.NOMBRE] = listaJuzgado.get(x).getNombreJuzgado()+ "";
            informacion[x][UtilidadesTablaJuzgado.DIRECCION] = listaJuzgado.get(x).getDireccionJuzgado()+ "";
            //se asignan las plabras clave para que en la clase GestionCeldas se use para asignar el icono correspondiente
            informacion[x][UtilidadesTablaJuzgado.PERFIL] = "PERFIL";
            informacion[x][UtilidadesTablaJuzgado.EVENTO] = "EVENTO";
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        LabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJuzgados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNombreJuzgado = new javax.swing.JTextField();
        lbNombreJuzgado = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JPanel();
        IconoBuscar = new javax.swing.JLabel();
        lbBuscar = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JPanel();
        lbIconoGuardar = new javax.swing.JLabel();
        lbGuardar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(190, 190, 190));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));

        LabelTitulo.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        LabelTitulo.setText("ADMINISTAR ANTECEDENTES");
        LabelTitulo.setToolTipText("");

        tablaJuzgados.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaJuzgados.setPreferredSize(new java.awt.Dimension(200, 100));
        jScrollPane1.setViewportView(tablaJuzgados);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/IconoJuzgados2.png"))); // NOI18N

        txtNombreJuzgado.setBackground(new java.awt.Color(240, 240, 240));
        txtNombreJuzgado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreJuzgadoActionPerformed(evt);
            }
        });

        lbNombreJuzgado.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbNombreJuzgado.setText("Nombre:");
        lbNombreJuzgado.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("*");

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

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("*");

        lbDireccion.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbDireccion.setText("Dirección:");
        lbDireccion.setToolTipText("");

        txtDireccion.setBackground(new java.awt.Color(240, 240, 240));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        botonGuardar.setBackground(new java.awt.Color(18, 44, 82));
        botonGuardar.setPreferredSize(new java.awt.Dimension(140, 46));
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarMouseClicked(evt);
            }
        });

        lbIconoGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/IconoGuardar.png"))); // NOI18N

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(LabelTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbDireccion)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombreJuzgado, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbNombreJuzgado))))
                                .addGap(61, 61, 61)
                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNombreJuzgado)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreJuzgado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDireccion)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jScrollPane2.setViewportView(jPanel1);

        add(jScrollPane2);
        jScrollPane2.setBounds(0, 0, 810, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreJuzgadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreJuzgadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreJuzgadoActionPerformed

    private void botonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBuscarMouseClicked

    }//GEN-LAST:event_botonBuscarMouseClicked

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
        JOptionPane.showMessageDialog(null, "Se ha guardado con éxito");
    }//GEN-LAST:event_botonGuardarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconoBuscar;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel botonBuscar;
    private javax.swing.JPanel botonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbBuscar;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbGuardar;
    private javax.swing.JLabel lbIconoGuardar;
    private javax.swing.JLabel lbNombreJuzgado;
    private javax.swing.JTable tablaJuzgados;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombreJuzgado;
    // End of variables declaration//GEN-END:variables
}
