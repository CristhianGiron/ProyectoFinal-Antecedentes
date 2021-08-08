/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ControlAdminDatos.PersonaDao;
import Modelo.Persona;

/**
 *
 * @author hp
 */
public class ControladorPersona {
    private static Persona pe=null;
    PersonaDao dao=new PersonaDao();
    public void newPersona(){
        pe=new Persona(); 
    }
    public Persona agregarPersona(){     
        return pe;   
    }
    public void guardarPersona(){
        dao.create(pe);
    }
}
