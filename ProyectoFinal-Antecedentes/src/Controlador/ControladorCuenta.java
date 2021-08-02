/*
 * To change this license header, choose License Headers in Project Procerties.
 * To change this template file, choose Tools | Templates
 * and ocen the template in the editor.
 */
package Controlador;

import ControlAdminDatos.CuentaDao;
import ControlAdminDatos.PersonaDao;
import static Controlador.ControladorDeEncriptado.createSecretKey;
import static Controlador.ControladorDeEncriptado.decrypt;
import static Controlador.ControladorDeEncriptado.encrypt;
import Modelo.Cuenta;
import Modelo.Persona;
import Vista.Acces.InicioSesion;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author hp
 */
public class ControladorCuenta {

    private static Cuenta ce = null;
    CuentaDao dao = new CuentaDao();
    private ArrayList<Cuenta> listCuenta = new ArrayList<>();

    public void newCuenta() {
        ce = new Cuenta();
    }

    public Cuenta agregarCuenta() {
        return ce;
    }

    public void setCuenta(Cuenta c) {
        ce = c;
    }

    public void guardarCuenta() {
        dao.create(ce);
    }

    public ArrayList<Cuenta> getListCuenta() {
        return listCuenta;
    }

    public void VaciarListCuenta() {
        listCuenta = new ArrayList<>();

    }

    public ArrayList<Cuenta> listaCuentas() {
        ArrayList<Cuenta> list = dao.findCuentaEntities();

        for (int j = 0; j < list.size(); j++) {
            listCuenta.add(list.get(j));
        }
        return listCuenta;

    }

    public void darBaja(Long id) {
        dao.destroy(id);
    }

    public void Editar(Cuenta p) {
        dao.edit(p);
    }

    public Boolean buscarCuenta(String Usuario, String Clave) {

        for (int i = 0; i < getListCuenta().size(); i++) {
            if (getListCuenta().get(i).getUsuario().equals(Usuario) && getListCuenta().get(i).getClave().equals(Clave)) {
                ce = getListCuenta().get(i);
                return true;
            } else {
                return false;
            }
        }
        return false;

    }

    public Persona buscarPersonaCuenta(Long idPersona) {
        PersonaDao dao = new PersonaDao();
        return dao.find(idPersona);

    }

    public String encriptar(char[] pasword) throws GeneralSecurityException {
        try {
            String clave = null;
            for (int i = 0; i < pasword.length; i++) {
                clave += String.valueOf(pasword[i]);
            }
            return encrypt(clave);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ControladorCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
