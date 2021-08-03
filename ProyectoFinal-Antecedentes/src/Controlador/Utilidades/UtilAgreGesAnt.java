/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Utilidades;

import ControlAdminDatos.Utiles.Utiles;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
     * El siguiente método permite extraer un dato
     *
     * @param obj
     * @param atributoClase
     * @return
     */
    public static String extraccionDato(Object obj, String atributoClase) {
        Class clase = obj.getClass();
        Field atributo = null;
        Object informacion = null;
        for (Field f : clase.getDeclaredFields()) {
            if (f.getName().toString().equalsIgnoreCase(atributoClase)) {
                atributo = f;
            }
        }
        if (atributo != null) {
            //  Method metodo = null;
            for (Method metodoAux : clase.getMethods()) {
                if (metodoAux.getName().startsWith("get")) {
                    if (metodoAux.getName().toLowerCase().endsWith(atributo.getName())) {
                        try {
                            informacion = metodoAux.invoke(obj);

                            break;
                        } catch (Exception e) {
                            System.out.println("Error de metodo " + e);
                        }
                    }
                }
            }
        }
        return (informacion != null) ? informacion.toString() : null;
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
}
