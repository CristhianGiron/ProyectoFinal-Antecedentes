/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Persona;
import Modelo.Persona;
import Vista.Utiles.GestionCeldas;
import Vista.Utiles.GestionEncabezadoTabla;
import Vista.Utiles.GestionEvento;
import Vista.Utiles.ModeloTabla;
import Vista.Utiles.TablaPersonas.Utilidades;
import Vista.Utiles.Utiles;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

/**
 *
 * @author hp
 */
public class GestionarPersonas extends javax.swing.JPanel {

    /**
     * Creates new form GestionarPersonas
     */
    private JPanel contentPane;
    private JScrollPane scrollPaneTabla;
    ArrayList<Persona> listaPersonas;//lista que simula la informaci�n de la BD

    ModeloTabla modelo;//modelo definido en la clase ModeloTabla
    private int filasTabla;
    private int columnasTabla;
    Utiles uti = new Utiles();

    public GestionarPersonas() {
        initComponents();
        //tablaSeguimiento.addKeyListener(this)
        construirTabla();
        jScrollPane1.getViewport().setBackground(Color.white);
        //modelo.setRowCount(0);
        
    }

    private void construirTabla() {

        listaPersonas = consultarListaPersonas();

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Cedula");
        titulosList.add("Nombre");
        titulosList.add("Apellido");
        titulosList.add("F.Nacimiento");
        titulosList.add("Dirección");
        titulosList.add("E.Civil");
        titulosList.add("Telefono");
        titulosList.add("E-mail");
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

    private ArrayList<Persona> consultarListaPersonas() {
        ArrayList<Persona> lista = new ArrayList<>();

        lista.add(new Persona(1234L, "1111111", "David ", "Enao", "Ingeniero", "sadh", "dfsfs", "099", "sdgds@", true));
        lista.add(new Persona(1234L, "1111111", "David ", "Enao", "Ingeniero", "sadh", "dfsfs", "xvdxc", "sdgds", true));
        lista.add(new Persona(1234L, "1111111", "David ", "Enao", "Ingeniero", "sadh", "dfsfs", "xvdxc", "sdgds", true));
        lista.add(new Persona(1234L, "1111111", "David ", "Enao", "Ingeniero", "sadh", "dfsfs", "xvdxc", "sdgds", true));

        return lista;
    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

        /*se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los usuarios, mientras que las columnas son estaticas
		 * correspondiendo a las columnas definidas por defecto
         */
        String informacion[][] = new String[listaPersonas.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][Utilidades.CEDULA] = listaPersonas.get(x).getCedula() + "";
            informacion[x][Utilidades.NOMBRE] = listaPersonas.get(x).getNombre() + "";
            informacion[x][Utilidades.APELLIDO] = listaPersonas.get(x).getApellido() + "";
            informacion[x][Utilidades.FECHANACIMIENTO] = listaPersonas.get(x).getFechaNacimiento() + "";
            informacion[x][Utilidades.DIRECCION] = listaPersonas.get(x).getDireccion() + "";
            informacion[x][Utilidades.ESTADOCIVIL] = listaPersonas.get(x).getEstadoCivil() + "";
            informacion[x][Utilidades.TELEFONO] = listaPersonas.get(x).getTelefono() + "";
            informacion[x][Utilidades.MAIL] = listaPersonas.get(x).getMail() + "";

            //se asignan las plabras clave para que en la clase GestionCeldas se use para asignar el icono correspondiente
            informacion[x][Utilidades.PERFIL] = "PERFIL";
            informacion[x][Utilidades.EVENTO] = "EVENTO";
        }

        return informacion;
    }

    private void construirTabla(String[] titulos, Object[][] data) {
        modelo = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        tablaPersonas.setModel(modelo);

        filasTabla = tablaPersonas.getRowCount();
        columnasTabla = tablaPersonas.getColumnCount();
        tablaPersonas.getColumnModel().getColumn(Utilidades.PERFIL).setCellRenderer(new GestionCeldas("icono"));
        tablaPersonas.getColumnModel().getColumn(Utilidades.EVENTO).setCellRenderer(new GestionCeldas("icono"));

        //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
        for (int i = 0; i < titulos.length - 2; i++) {//se resta 7 porque las ultimas 7 columnas se definen arriba
            tablaPersonas.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
        }

        tablaPersonas.getTableHeader().setReorderingAllowed(false);
        tablaPersonas.setRowHeight(25);//tamano de las celdas
        tablaPersonas.setGridColor(new java.awt.Color(0, 0, 0));
        //Se define el tama�o de largo para cada columna y su contenido
        tablaPersonas.getColumnModel().getColumn(Utilidades.CEDULA).setPreferredWidth(130);//documento
        tablaPersonas.getColumnModel().getColumn(Utilidades.NOMBRE).setPreferredWidth(380);//nombre
        tablaPersonas.getColumnModel().getColumn(Utilidades.APELLIDO).setPreferredWidth(350);//direccion
        tablaPersonas.getColumnModel().getColumn(Utilidades.FECHANACIMIENTO).setPreferredWidth(130);//telefono
        tablaPersonas.getColumnModel().getColumn(Utilidades.DIRECCION).setPreferredWidth(280);//profesion
        tablaPersonas.getColumnModel().getColumn(Utilidades.ESTADOCIVIL).setPreferredWidth(80);//edad
        tablaPersonas.getColumnModel().getColumn(Utilidades.TELEFONO).setPreferredWidth(100);//nota1
        tablaPersonas.getColumnModel().getColumn(Utilidades.MAIL).setPreferredWidth(100);//nota2
        tablaPersonas.getColumnModel().getColumn(Utilidades.PERFIL).setPreferredWidth(35);//accion perfil
        tablaPersonas.getColumnModel().getColumn(Utilidades.EVENTO).setPreferredWidth(35);//accion evento

        //personaliza el encabezado
        JTableHeader jtableHeader = tablaPersonas.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tablaPersonas.setTableHeader(jtableHeader);

    }

    /**
     * Este metodo simularia el proceso o la acci�n que se quiere realizar si se
     * presiona alguno de los botones o iconos de la tabla
     *
     * @param fila
     */
    private void validarSeleccionMouse(int fila) {
        Utilidades.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la informaci�n
        Persona miPersona = new Persona();
        miPersona.setCedula(tablaPersonas.getValueAt(fila, Utilidades.CEDULA).toString());
        miPersona.setNombre(tablaPersonas.getValueAt(fila, Utilidades.NOMBRE).toString());

        String info = "INFO PERSONA\n";
        info += "Documento: " + miPersona.getCedula() + "\n";
        info += "Nombre: " + miPersona.getNombre() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }
    //versiones
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscarCedula = new javax.swing.JLabel();
        LimpiarBuscadorCedula1 = new javax.swing.JLabel();
        LimpiarBuscadorNombre = new javax.swing.JLabel();
        btnBuscarNombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonas = new javax.swing.JTable();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbEstadoCivil = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        rSFotoCircle1 = new rojerusan.RSFotoCircle();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 610));
        setPreferredSize(new java.awt.Dimension(1000, 610));
        setLayout(null);

        btnBuscarCedula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscarCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/IconoBuscar2.png"))); // NOI18N
        btnBuscarCedula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnBuscarCedula);
        btnBuscarCedula.setBounds(290, 80, 20, 30);

        LimpiarBuscadorCedula1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LimpiarBuscadorCedula1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LimpiarBuscadorCedula1.setText("X");
        LimpiarBuscadorCedula1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(LimpiarBuscadorCedula1);
        LimpiarBuscadorCedula1.setBounds(265, 80, 20, 30);

        LimpiarBuscadorNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LimpiarBuscadorNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LimpiarBuscadorNombre.setText("X");
        LimpiarBuscadorNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(LimpiarBuscadorNombre);
        LimpiarBuscadorNombre.setBounds(670, 80, 20, 30);

        btnBuscarNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscarNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Iconos/IconoBuscar2.png"))); // NOI18N
        btnBuscarNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnBuscarNombre);
        btnBuscarNombre.setBounds(695, 80, 20, 30);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPersonasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablaPersonasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tablaPersonasMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPersonas);

        add(jScrollPane1);
        jScrollPane1.setBounds(26, 124, 956, 200);

        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        add(jTextField5);
        jTextField5.setBounds(30, 390, 290, 30);

        jLabel6.setForeground(new java.awt.Color(49, 49, 49));
        jLabel6.setText("E-mail");
        add(jLabel6);
        jLabel6.setBounds(30, 370, 290, 14);

        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        add(jTextField6);
        jTextField6.setBounds(30, 450, 290, 30);

        jLabel7.setForeground(new java.awt.Color(49, 49, 49));
        jLabel7.setText("Cell");
        add(jLabel7);
        jLabel7.setBounds(30, 430, 290, 14);

        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        add(jTextField7);
        jTextField7.setBounds(30, 510, 290, 30);

        jLabel8.setForeground(new java.awt.Color(49, 49, 49));
        jLabel8.setText("Dirección");
        add(jLabel8);
        jLabel8.setBounds(30, 490, 290, 14);
        add(jLabel1);
        jLabel1.setBounds(80, 340, 240, 20);

        jLabel2.setText("Nombre: ");
        add(jLabel2);
        jLabel2.setBounds(30, 340, 50, 20);
        add(jLabel3);
        jLabel3.setBounds(390, 340, 240, 20);

        jLabel4.setText("Cedula:");
        add(jLabel4);
        jLabel4.setBounds(340, 340, 50, 20);

        cbEstadoCivil.setBackground(new java.awt.Color(240, 240, 240));
        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado Civil" }));
        add(cbEstadoCivil);
        cbEstadoCivil.setBounds(550, 390, 190, 30);

        jLabel5.setForeground(new java.awt.Color(49, 49, 49));
        jLabel5.setText("Estado Civil");
        add(jLabel5);
        jLabel5.setBounds(550, 370, 290, 14);

        rSFotoCircle1.setColorBorde(new java.awt.Color(204, 204, 204));
        add(rSFotoCircle1);
        rSFotoCircle1.setBounds(370, 410, 130, 130);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setText("Gestionar Personas");
        add(jLabel9);
        jLabel9.setBounds(70, 10, 320, 40);
        add(jSeparator1);
        jSeparator1.setBounds(10, 50, 980, 10);

        jLabel10.setForeground(new java.awt.Color(49, 49, 49));
        jLabel10.setText("Cedula");
        add(jLabel10);
        jLabel10.setBounds(25, 65, 290, 10);

        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 117, 225)));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        add(jTextField8);
        jTextField8.setBounds(25, 80, 290, 30);

        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 117, 225)));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        add(jTextField9);
        jTextField9.setBounds(430, 80, 290, 30);

        jLabel11.setForeground(new java.awt.Color(49, 49, 49));
        jLabel11.setText("Nombre");
        add(jLabel11);
        jLabel11.setBounds(430, 65, 290, 10);

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
        add(btnGuardar);
        btnGuardar.setBounds(620, 500, 120, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPersonasMouseClicked
        System.out.println("*****Ejecutando evento");
        //capturo fila o columna dependiendo de mi necesidad
        int fila = tablaPersonas.rowAtPoint(evt.getPoint());
        int columna = tablaPersonas.columnAtPoint(evt.getPoint());

        /*uso la columna para valiar si corresponde a la columna de perfil garantizando
		 * que solo se produzca algo si selecciono una fila de esa columna
         */
        if (columna == Utilidades.PERFIL) {
            //sabiendo que corresponde a la columna de perfil, envio la posicion de la fila seleccionada
            validarSeleccionMouse(fila);
        } else if (columna == Utilidades.EVENTO) {//se valida que sea la columna del otro evento
            JOptionPane.showMessageDialog(null, "Evento del otro icono");
        }
    }//GEN-LAST:event_tablaPersonasMouseClicked

    private void tablaPersonasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPersonasMouseEntered

    }//GEN-LAST:event_tablaPersonasMouseEntered

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed

    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed

    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed

    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed

    }//GEN-LAST:event_jTextField9ActionPerformed

    private void tablaPersonasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPersonasMouseExited

    }//GEN-LAST:event_tablaPersonasMouseExited

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        btnGuardar.setBackground(new Color(18,79,82));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        btnGuardar.setBackground(new Color(18,44,82));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed

    }//GEN-LAST:event_btnGuardarMousePressed

//vista en desarrollo
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LimpiarBuscadorCedula1;
    private javax.swing.JLabel LimpiarBuscadorNombre;
    private javax.swing.JLabel btnBuscarCedula;
    private javax.swing.JLabel btnBuscarNombre;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JComboBox<String> cbEstadoCivil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private rojerusan.RSFotoCircle rSFotoCircle1;
    private javax.swing.JTable tablaPersonas;
    // End of variables declaration//GEN-END:variables

}
