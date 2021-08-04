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
import java.sql.Date;

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
                    lista.add(new Proceso(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6),
                            rs.getBytes(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getLong(11), rs.getLong(12),
                            rs.getLong(13), rs.getLong(14)));
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println("Error en la extaraccion de los datos de la base de datos "
                    + "detalles de error: " + ex);

        }

        return lista;
    }

    @Override
    public void create(Proceso proceso) {
        int i = 0;
        try {
            String insertar = "INSERT INTO sistemaco_penal.proceso (idproceso, tipoProceso, instancia, fechaInicio, fechaFinal, nroAudiencia, documento, nombreDocumento, estadoVictimario, estadoDemanda, idDelito, idPersona, idCondena, idJuzgado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = (PreparedStatement) cnx.prepareStatement(insertar);
            pstmt.setLong(1, proceso.getIdProceso());
            pstmt.setString(2, proceso.getTipoProceso());
            pstmt.setInt(3, proceso.getInstancia());
            pstmt.setString(4, proceso.getFechaInicio());
            pstmt.setString(5, proceso.getFechaFinal());
            pstmt.setInt(6, proceso.getNrAudiencias());
            pstmt.setBytes(7, proceso.getText());
            pstmt.setString(8, proceso.getNombreDocumento());
            pstmt.setString(9, proceso.getEstadoVictimario());
            pstmt.setString(10, proceso.getEstadoDemanda());
            pstmt.setLong(11, proceso.getIdDelito());
            pstmt.setLong(12, proceso.getIdPersona());
            pstmt.setLong(13, proceso.getIdCondena());
            pstmt.setLong(14, proceso.getIdJuzgado());

            i = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al guardar en la base de datos: " + ex);
        }
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

    public ArrayList<Proceso> listaProcesoPersona(Long id) {
        String query;
        ArrayList<Proceso> lista = new ArrayList<>();

        query = "SELECT * FROM sistemaco_penal.proceso where idPersona = " + id;

        try {
            //Cargar la lista de cuentas
            stmt = (Statement) cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                do {
                    lista.add(new Proceso(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6),
                            rs.getBytes(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getLong(11), rs.getLong(12),
                            rs.getLong(13), rs.getLong(14)));
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println("Error en la extaraccion de los datos de la base de datos "
                    + "detalles de error: " + ex);

        }
        return lista;
    }
}
