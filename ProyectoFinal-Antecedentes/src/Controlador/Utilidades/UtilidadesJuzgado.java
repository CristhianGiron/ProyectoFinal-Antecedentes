/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Utilidades;

import Modelo.Juzgado;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class UtilidadesJuzgado {
    public static int obtenerJuzgadoContenido(ArrayList<Juzgado> lista, String nombre){
       int pos = -1;
        for (int i = 0; i < lista.size(); i++) {
            Juzgado aux = lista.get(i);
            if (aux.getNombreJuzgado().equalsIgnoreCase(nombre)) {
                pos = i;
                break;
            }
        }
       return pos;
    }
}
