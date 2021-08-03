/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ControlAdminDatos.Dao;
import Controlador.Conexion;
import Modelo.Proceso;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ProcesoDao implements Dao<Proceso> {

    Statement stmt;
    PreparedStatement stmt1;
    Conexion con = new Conexion();
    static Connection cnx;

    public ProcesoDao() {
        cnx = con.getConexion();
    }

    public ArrayList<Proceso> findProcesoEntities(boolean todo) {
        return findEntities(todo, -1, -1);
    }

    public ArrayList<Proceso> findProcesoEntities(int maxResult, int firstResult) {
        return findEntities(false, maxResult, firstResult);
    }

    @Override
    public ArrayList<Proceso> findEntities(boolean all, int maxResult, int firstResult) {
        String query;
        ArrayList<Proceso> lista = new ArrayList<>();

        if (all) {
            query = "SELECT * FROM sistemaco_penal.proceso";
        } else {
            query = "SELECT * FROM sistemaco_penal.proceso where estadoDemanda = 'Activado'";
        }

        try {
            //Cargar la lista de cuentas
            stmt = (Statement) cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                do {
                    lista.add(new Proceso(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getDate(6),
                            rs.getInt(7), rs.getString(8), rs.getBytes(9), rs.getString(10), rs.getString(11), rs.getString(12)));
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println("Error en la extaraccion de los datos de la base de datos "
                    + "detalles de error: " + ex);

        }

        return lista;
    }

    @Override
    public void create(Proceso object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Proceso object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proceso find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
