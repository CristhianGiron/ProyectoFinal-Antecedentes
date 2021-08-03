/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ControlAdminDatos.PersonaDao;
import ControlAdminDatos.RolDao;
import Modelo.Persona;
import Modelo.Rol;
import Vista.Utiles.TablaPersonas.Utilidades;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class ControladorPersona {

    private static Persona pe = null;
    PersonaDao dao = new PersonaDao();
    private ArrayList<Persona> listComun = new ArrayList<>();
    ArrayList<Persona> temp = new ArrayList<>();

    public void newPersona() {
        pe = new Persona();
    }

    public Persona agregarPersona() {
        return pe;
    }

    public void setPersona(Persona p) {
        pe = p;
    }

    public void guardarPersona() {
        dao.create(pe);
    }
    public boolean isCorrect(){ 
        return dao.isValidTransaccion();
        
    }

    public ArrayList<Persona> getListComun() {
        return listComun;
    }
    public ArrayList<Persona> getListTemporal() {
        return temp;
    }

    public void VaciarListComun() {
        listComun = new ArrayList<>();

    }

    public void VaciarTemp() {
        temp = new ArrayList<>();

    }

    public ArrayList<Persona> listaPersonas() {
        PersonaDao pe = new PersonaDao();
        RolDao ro = new RolDao();
        ArrayList<Persona> list = pe.findPersonaEntities();

        ArrayList<Rol> list1 = ro.findRolEntities();
        Long id = 0L;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getTipo().equals("Comun")) {
                id = list1.get(i).getIdRol();
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getIdRol() == id) {
                        listComun.add(list.get(j));
                    }
                }
            }
        }
        return listComun;

    }

    public Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {
        String informacion[][] = new String[temp.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][Utilidades.CEDULA] = temp.get(x).getCedula() + "";
            informacion[x][Utilidades.NOMBRE] = temp.get(x).getNombre() + "";
            informacion[x][Utilidades.APELLIDO] = temp.get(x).getApellido() + "";
            informacion[x][Utilidades.FECHANACIMIENTO] = temp.get(x).getFechaNacimiento() + "";
            informacion[x][Utilidades.DIRECCION] = temp.get(x).getDireccion() + "";
            informacion[x][Utilidades.ESTADOCIVIL] = temp.get(x).getEstadoCivil() + "";
            informacion[x][Utilidades.TELEFONO] = temp.get(x).getTelefono() + "";
            informacion[x][Utilidades.MAIL] = temp.get(x).getMail() + "";
            informacion[x][Utilidades.PERFIL] = "PERFIL";
            informacion[x][Utilidades.EVENTO] = "EVENTO";
        }

        return informacion;
    }

    public void darBaja(Long id) {
        dao.destroy(id);
    }

    public void Editar(Persona p) {
        dao.edit(p);
    }

    public void buscar(String dato, String parametro) {
        if (parametro.equals("CEDULA")) {
            for (int i = 0; i < getListComun().size(); i++) {
                if (getListComun().get(i).getCedula().contains(dato)) {
                    temp.add(getListComun().get(i));
                }
            }
        } else if (parametro.equals("NOMBRE")) {
            for (int i = 0; i < getListComun().size(); i++) {
                if (getListComun().get(i).getNombre().contains(dato)) {
                    temp.add(getListComun().get(i));
                }
            }
        } else if (parametro.equals("ALL")) {
            for (int i = 0; i < getListComun().size(); i++) {
                temp.add(getListComun().get(i));
            }
        }
        {

        }
    }
    
}
