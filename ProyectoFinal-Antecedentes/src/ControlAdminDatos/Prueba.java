/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAdminDatos;

import Modelo.Persona;
import Modelo.Rol;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaDao pe = new PersonaDao();
        RolDao ro = new RolDao();
        ArrayList<Persona> list = pe.findPersonaEntities();
        ArrayList<Rol> list1 = ro.findRolEntities();
        Long id = 0L;
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("Roles: " + list1.get(i).getTipo());
            if (list1.get(i).getTipo().equals("Comun")) {
                id = list1.get(i).getIdRol();
                System.out.println("idRol: "+ id );
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getIdRol()==id) {
                        System.out.println("Datos: " + list.get(j).getNombre());
                    }
                }
            }
        }
        try {
            System.out.println("Cantidad: " + pe.find(76L).getEstado());
        } catch (NullPointerException ex) {
            System.out.println("Datos erroneos la base de datos devueve 0 rows y 0 columns");
        }
        pe.destroy(2L);
        pe.destroy(3L);
        pe.destroy(4L);
        pe.destroy(5L);
        pe.destroy(6L);
        pe.create(new Persona(0L, "11123", "Julia", "alarcon", "2021-4-5", "Shiris", "Casado", "099874", "asfasf", Boolean.TRUE, 1L));
        // TODO code application logic here
    }

}
