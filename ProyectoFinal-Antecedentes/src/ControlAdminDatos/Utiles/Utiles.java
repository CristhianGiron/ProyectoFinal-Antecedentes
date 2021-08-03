/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAdminDatos.Utiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Cris2
 */
public class Utiles {

    /**
     * Metodo que permite realizar la busqueda de imagenes en el directorio de
     * el computador
     *
     * @return Retorna una archivo de tipo imagen
     */
    public File BuscarImagen() {
        File file = null;
        JFileChooser archivo = new JFileChooser();
        archivo.setBackground(new Color(255, 204, 51));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg", "jpeg");
        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        File ruta = new File("C:/Pictures");
        archivo.setCurrentDirectory(ruta);
        int ventana = archivo.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            file = archivo.getSelectedFile();
        }
        return file;
    }

    /**
     * Metodo que permite convertir imagenes de formato Blod a Imagen
     *
     * @param imagen Imagen Blod
     * @param d Dimensiones de la imagen
     * @return Retorna una imagen ImageIcon
     */
    public Image img(Blob imagen, Dimension d) {
        if (imagen != null) {
            Image rpta = null;
            try {
                rpta = javax.imageio.ImageIO.read(imagen.getBinaryStream());
                rpta = rpta.getScaledInstance(d.width, d.height, Image.SCALE_DEFAULT);
                return rpta;
            } catch (SQLException ex) {
                System.err.println("Error: " + ex.getMessage());
            } catch (IOException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }
        return null;

    }
    public Image img(Image imagen, Dimension d) {
        if (imagen != null) {
            Image rpta = imagen;
                rpta = rpta.getScaledInstance(d.width, d.height, Image.SCALE_DEFAULT);
                return rpta;
           
        }
        return null;

    }
    
    public Image img(Blob imagen) {
        if (imagen != null) {
            Image rpta = null;
            try {
                rpta = javax.imageio.ImageIO.read(imagen.getBinaryStream());
               // rpta = rpta.getScaledInstance(d.width, d.height, Image.SCALE_DEFAULT);
                return rpta;
            } catch (SQLException ex) {
                System.err.println("Error: " + ex.getMessage());
            } catch (IOException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }
        return null;

    }

    /**
     * Metodo que permite convertir imagenes de Image a Blod;
     *
     * @param img
     * @return
     */
    public ByteArrayInputStream convertirImagenABlob(Image img) {
        try {
            BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bi.createGraphics();
            g2d.drawImage(img, 0, 0, null);
            g2d.dispose();
            ByteArrayOutputStream baos;
            baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "png", baos);
            
            baos.close();
            
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            return bais;
        } catch (IOException ex) {
            Logger.getLogger(Utiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    /**
     * Metodo que permite obtener la fecha actual
     *
     * @return Fecha y hora actual del sistema año-mes-dia hora:minutos:segundos
     */
    public String fechaActual() {
        String fechaHora = "";
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        System.out.println("Fecha Actual: " + dia + "/" + (mes + 1) + "/" + año);
        System.out.printf("Hora Actual: %02d:%02d:%02d %n", hora, minuto, segundo);
        fechaHora = String.valueOf(año) + "-" + String.valueOf(mes + 1) + "-" + String.valueOf(dia) + " " + String.valueOf(hora) + ":" + String.valueOf(minuto) + ":" + String.valueOf(segundo);
        return fechaHora;
    }

    /**
     * Devuelve un sql con el idDetalle
     *
     * @param idDetalle Long
     * @return String - sql
     */
    public String tr(Long idDetalle) {
        String tr = "SELECT * FROM salidaservicio inner join servicio  using (idsalidaServicio) where idDetalle=" + idDetalle;
        return tr;
    }

    /**
     * retorna una imagen un un tiempo de espera
     *
     * @param lb JLabel
     * @param lb1 JLabel
     * @param ico ImageIcon
     */
    public void retardo(JLabel lb, JLabel lb1, ImageIcon ico[]) {
        Timer timer;
        timer = new Timer();
        TimerTask task = new TimerTask() {
            int tic = 0;
            int cont = 0;

            @Override
            public void run() {
                lb.setIcon(ico[cont]);
                lb1.setText(ico[cont].getDescription());
                cont++;
                if (cont == ico.length) {
                    cont = 0;
                }

            }
        };
        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
        timer.schedule(task, 10, 10000);
    }

    /**
     * Retorna un arreglo de File
     *
     * @return File[]
     */
    public File[] traerDirectorio() {

        String path = "./img/";
        String files;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        System.out.println(listOfFiles.length);
        File img[] = null;
        File imgaux[] = null;
        for (int i = 0; i < listOfFiles.length; i++) {
            //files=listOfFiles[i].getName();
            if (listOfFiles[i].isFile()) {
                files = listOfFiles[i].getName();
                if (files.endsWith(".jpg") || files.endsWith(".png")) {
                    if (img == null) {
                        System.out.println("Porque entra 1");
                        img = new File[1];
                    } else {
                        System.out.println("Porque entra 2");
                        imgaux = img;
                        img = new File[imgaux.length + 1];
                        copiar(img, imgaux);
                        imgaux = null;
                        System.out.println(files);
                    }

                    img[img.length - 1] = listOfFiles[i];
                }
            }

        }
        System.out.println("tm: " + img.length);
        return img;
    }

    /**
     * Clona un File
     *
     * @param uno File[]
     * @param dos File[]
     */
    public static void copiar(File[] uno, File[] dos) {
        for (int i = 0; i < dos.length; i++) {
            uno[i] = dos[i];
        }
    }
    
    /**
     * El siguiente método permite extraer un dato 
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
}
