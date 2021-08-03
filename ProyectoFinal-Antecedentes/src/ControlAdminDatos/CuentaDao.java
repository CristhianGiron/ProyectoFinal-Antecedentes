/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAdminDatos;

import ControlAdminDatos.Utiles.Utiles;
import Modelo.Cuenta;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
       
        String query;
        ArrayList<Cuenta> list = new ArrayList<>();
        if (all) {
            query = "SELECT * FROM sistemaco_penal.cuenta";
        } else {
            query = "SELECT * FROM sistemaco_penal.cuenta where idcuenta>='" + firstResult + "' limit " + maxResult;
        }
        try {
            //Cargar la lista de cuentas
            stmt = (Statement) cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                do {
                    list.add(new Cuenta(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4)) );
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println("Error en la extaraccion de los datos de la base de datos "
                    + "detalles de error: " + ex);

        } 
        return list; //To change body of generated methods, choose Tools | Templates.
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
