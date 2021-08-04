/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ControlAdminDatos.Dao;
import Modelo.Condena;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class CondenaDao implements Dao<Condena> {

    Statement stmt;
    PreparedStatement stmt1;
    Conexion con = new Conexion();
    static Connection cnx;
    boolean seGuardo;

    public CondenaDao() {
        cnx = con.getConexion();
    }
    
    public boolean isSeGuardo() {
        return seGuardo;
    }

    public ArrayList<Condena> findCondenaEntities(boolean todo) {
        return findEntities(todo, -1, -1);
    }

    public ArrayList<Condena> findCondenaEntities(int maxResult, int firstResult) {
        return findEntities(false, maxResult, firstResult);
    }

    @Override
    public ArrayList<Condena> findEntities(boolean all, int maxResult, int firstResult) {
        String query;
        ArrayList<Condena> lista = new ArrayList<>();

        if (all) {
            query = "SELECT * FROM sistemaco_penal.condena";
        } else {
            query = "SELECT * FROM sistemaco_penal.condena where estadoCondena = 'Dictada'";
        }

        try {
            //Cargar la lista de cuentas
            stmt = (Statement) cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                do {
                    lista.add(new Condena(rs.getLong(1), rs.getString(2), rs.getString(3)));
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println("Error en la extaraccion de los datos de la base de datos "
                    + "detalles de error: " + ex);

        }

        return lista;
    }

    @Override
    public void create(Condena condena) {
        int i = 0;
        try {
            String insertar = "INSERT INTO sistemaco_penal.condena (idCondena, sentencia, estadoCondena) VALUES (?, ?, ?)";
            PreparedStatement pstmt = (PreparedStatement) cnx.prepareStatement(insertar);
            pstmt.setLong(1, condena.getIdCondena());
            pstmt.setString(2, condena.getSentencia());
            pstmt.setString(3, condena.getEstadoCondena());
            i = pstmt.executeUpdate();
            seGuardo = true; 
        } catch (SQLException ex) {
            System.out.println("Error al guardar en la base de datos: " + ex);
            seGuardo = false; 
        }
    }

    @Override
    public void edit(Condena condena) {
        int i = 0;
        try {
            Long id = condena.getIdCondena();
            String insertar = "UPDATE sistemaco_penal.condena SET sentencia = ?, estadoCondena = ? WHERE idCondena =" + id;
            PreparedStatement pstmt = (PreparedStatement) cnx.prepareStatement(insertar);
            pstmt.setString(1, condena.getSentencia());
            pstmt.setString(2, condena.getEstadoCondena());
            i = pstmt.executeUpdate();
            seGuardo = true;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar en la base de datos: " + ex);
            seGuardo = false;
        }
    }

    @Override
    public void destroy(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Condena find(Long id) {
        Condena condena = null;
        try {
            //Cargar la lista de cuentas
            stmt = (Statement) cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sistemaco_penal.condena where idCondena = " + id);
            if (rs.next()) {
                condena = new Condena(rs.getLong(1), rs.getString(2), rs.getString(3));
                return condena;
            }
        } catch (SQLException ex) {
            System.out.println("Error relizando la busqueda en la base de datos: " + ex);
        }
        return condena;
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
