/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Utilidades;

import ControlAdminDatos.PersonaDao;
import ControlAdminDatos.Utiles.Utiles;
import Controlador.CondenaDao;
import Controlador.DelitoDao;
import Controlador.JuzgadoDao;
import Modelo.Condena;
import Modelo.Delito;
import Modelo.Juzgado;
import Modelo.Persona;
import Modelo.Proceso;
import Vista.Utiles.TablaAntecedentes.UtilidadesTablaAntecedentes;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import necesario.RSFileChooser;

/**
 *
 * @author ASUS
 */
public class UtilAgreGesAnt {

    /**
     * El siguiente método permite cargar el combo box llamando una ArrayList
     * mediante un dato perteneciente a la clase de un modelo que se desee
     * buscar
     *
     * @param cbx
     * @param lista
     * @param atributoClase
     */
    public static void cargarCombo(JComboBox cbx, ArrayList lista, String atributoClase) {
        cbx.removeAllItems();
        int tamanio = lista.size();
        cbx.addItem("");
        for (int i = 0; i < tamanio; i++) {
            String dato = Utiles.extraccionDato(lista.get(i), atributoClase);
            cbx.addItem(dato);
        }
    }

    /**
     * El siguiente método permite darle valor a un dato llamando una lista
     * ArrayList un dato perteneciente a la clase de un modelo que se desee
     * buscar
     *
     * @param dato
     * @param lista
     * @param atributoClase
     */
    public static Object obtenerEntidad(String dato, ArrayList lista, String atributoClase) {
        Object aux = null;
        for (int i = 0; i < lista.size(); i++) {
            String tmp = Utiles.extraccionDato(lista.get(i), atributoClase);
            if (dato.equalsIgnoreCase(tmp)) {
                aux = lista.get(i);
                break;
            }
        }
        return aux;
    }

    /**
     * El siguiente método permite descargar un archivo pdf
     *
     * @param archivo
     * @param ruta
     */
    public static void descargarArchivo(byte[] archivo, File ruta) {
        try {
            InputStream bais = new ByteArrayInputStream(archivo);
            int tamanioInput = bais.available();
            byte[] datosPDF = new byte[tamanioInput];
            bais.read(datosPDF, 0, tamanioInput);
            OutputStream out = new FileOutputStream(ruta + ".pdf");
            out.write(datosPDF);

            out.close();
            bais.close();
        } catch (Exception e) {
        }
    }
    
    public static ArrayList<Persona> listaPersona(ArrayList<Proceso> listaProceso, PersonaDao pd) throws SQLException{
        ArrayList<Persona> listaPersona = new ArrayList<>();
        for (int i = 0; i < listaProceso.size(); i++) {
            Proceso tmp = listaProceso.get(i);
            String id = tmp.getIdPersona() + "";
            listaPersona.add(pd.obtenerPersona(id, "id"));
        }
        return listaPersona;
    }
    
    public static ArrayList<Delito> listaDelito(ArrayList<Proceso> listaProceso, DelitoDao dd) throws SQLException{
        ArrayList<Delito> listaDelito = new ArrayList<>();
        for (int i = 0; i < listaProceso.size(); i++) {
            Proceso tmp = listaProceso.get(i);
            Long id = tmp.getIdDelito();
            System.out.println(dd.find(id).toString());
            listaDelito.add(dd.find(id));
        }
        return listaDelito;
    }
    
    public static ArrayList<Juzgado> listaJuzgado(ArrayList<Proceso> listaProceso, JuzgadoDao jd) throws SQLException{
        ArrayList<Juzgado> listaJuzgado = new ArrayList<>();
        for (int i = 0; i < listaProceso.size(); i++) {
            Proceso tmp = listaProceso.get(i);
            Long id = tmp.getIdJuzgado();
            listaJuzgado.add(jd.find(id));
        }
        return listaJuzgado;
    }
    
    public static ArrayList<Condena> listaCondena(ArrayList<Proceso> listaProceso, CondenaDao cd) throws SQLException{
        ArrayList<Condena> listaCondena = new ArrayList<>();
        for (int i = 0; i < listaProceso.size(); i++) {
            Proceso tmp = listaProceso.get(i);
            Long id = tmp.getIdCondena();
            listaCondena.add(cd.find(id));
        }
        return listaCondena;
    }
    
    public static Object[][] obtenerMatrizDatos(ArrayList<String> titulosList, ArrayList<Proceso> listaProceso, ArrayList<Juzgado> listaJuzgado, ArrayList<Delito> listaDelito, ArrayList<Condena> listaCondena) {

        /*se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los usuarios, mientras que las columnas son estaticas
		 * correspondiendo a las columnas definidas por defecto
         */
        String informacion[][] = new String[listaJuzgado.size()][titulosList.size()];
        for (int x = 0; x < informacion.length; x++) {

            informacion[x][UtilidadesTablaAntecedentes.DELITO] = listaDelito.get(x).getNombre()+ "";
            informacion[x][UtilidadesTablaAntecedentes.ART] = listaDelito.get(x).getArticulo()+ "";
            informacion[x][UtilidadesTablaAntecedentes.CONDENA] = listaCondena.get(x).getSentencia()+ "";
            informacion[x][UtilidadesTablaAntecedentes.FECHAINICIO] = listaProceso.get(x).getFechaInicio() + "";
            informacion[x][UtilidadesTablaAntecedentes.FECHAFINALIZACION] = listaProceso.get(x).getFechaFinal() + "";
            informacion[x][UtilidadesTablaAntecedentes.JUZGADO] = listaJuzgado.get(x).getNombre( )+ "";
            //se asignan las plabras clave para que en la clase GestionCeldas se use para asignar el icono correspondiente
            informacion[x][UtilidadesTablaAntecedentes.BORRAR] = "PERFIL";
            informacion[x][UtilidadesTablaAntecedentes.EDITAR] = "EVENTO";
        }

        return informacion;
    }
}
