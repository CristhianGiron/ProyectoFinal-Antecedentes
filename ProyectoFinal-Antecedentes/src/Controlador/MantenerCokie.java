/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author hp
 */
public class MantenerCokie<T> {

    Cokie cok = new Cokie();

    /**
     * Metodo encargado de almacenar los datos de la persona que ingreso al
     * sistema durante el timpo que este ste activo para luego borrarse
     *
     * @param ruta string ruta
     * @return un generico rol
     */
    public T getCokieValue(String ruta) {
        cok.setREPO(ruta);
        T dato = null;
        try {
            dato = (T) cok.getXtrStream().fromXML(new FileReader(cok.getREPO() + File.separatorChar + ruta + ".json"));

        } catch (Exception e) {
            System.out.println("No se pudo listar " + e);
            e.printStackTrace();
        }
        return dato;
    }

    /**
     * Metodo encargado de guardar los datos del usuario que se a logueado en el
     * sistema
     *
     * @param o generico
     * @param ruta ruta de imagen
     * @throws Exception en caso no se guarde los datos no me detenga la
     * ejecucion del programa.
     */
    public void addCokie(T objeto, String ruta) throws Exception {
        cok.setREPO(ruta);
        File file = new File(ruta + ".json");
        cok.getXtrStream().toXML(objeto, new FileOutputStream(cok.getREPO() + File.separatorChar + ruta + ".json"));

    }

    /**
     * modificar un objeto T
     *
     * @param o T
     * @return boolean
     */
    public Boolean modificar(T o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean RemoveCokie(String ruta) {
        cok.setREPO(ruta);
        File fichero = new File(cok.getREPO() + File.separatorChar +ruta + ".json");
        return fichero.delete();
    }
}
