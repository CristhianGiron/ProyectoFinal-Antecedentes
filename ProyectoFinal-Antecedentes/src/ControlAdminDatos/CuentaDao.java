/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAdminDatos;

import ControlAdminDatos.Utiles.Utiles;
import Modelo.Cuenta;
import Modelo.Cuenta;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class CuentaDao implements Dao<Cuenta> {

    Statement stmt;
    PreparedStatement stmt1;
    Utiles uti = new Utiles();
    static Connection cnx;

    public CuentaDao() {
        cnx = uti.getConexion();

    }

    public ArrayList<Cuenta> findCuentaEntities() {
        return findEntities(true, -1, -1);
    }

    public ArrayList<Cuenta> findCuentaEntities(int maxResult, int firstResult) {
        return findEntities(false, maxResult, firstResult);
    }

    @Override
    public void create(Cuenta cuenta) {
        int i = 0;
        try {
            String insertar = "INSERT INTO sistemaco_penal.cuenta (`idcuenta`, `Usuario`, `Contraseña`, idpersona) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = (PreparedStatement) cnx.prepareStatement(insertar);
            stmt.setLong(1, cuenta.getIdCuenta());
            stmt.setString(2, cuenta.getUsuario());
            stmt.setString(3, cuenta.getClave());
            stmt.setLong(4, cuenta.getIdPersona());
            i = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al guardar en la base de datos: createCuenta " + ex);
        }
    }

    @Override
    public ArrayList<Cuenta> findEntities(boolean all, int maxResult, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Cuenta object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cuenta find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
