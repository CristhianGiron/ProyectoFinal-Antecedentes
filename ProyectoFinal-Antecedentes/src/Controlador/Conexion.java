/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author ASUS
 */
public class Conexion {
    static Connection conexion;
    static boolean estado=true;
    public Conexion() {
        if (estado) {
            IniciarConexion();
            estado=false;
        }
        
    }

    /**
     * Metodo get estatico que permite establecer conexion con la base de datos
     *
     * @return Retiorna una conexion de BDD
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * Inicia o establece la coneccion con la base de datos
     */
    private void IniciarConexion() {
        Connection con = null;
        String Driver = "com.mysql.cj.jdbc.Driver";
        String Usuario = "root";
        String Contraseña = "12345";
        String NombreDB = "sistemaco_penal";
        String Puerto = "3306";
        String TimeZone = "?useUnicode=true&use"
                + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false"
                + "&serverTimezone=UTC";
        try {
            Class.forName(Driver);
            con = DriverManager.getConnection("jdbc:mysql://localhost:" + Puerto + "/" + NombreDB + TimeZone, Usuario, Contraseña);
            System.out.println("Conexion establecida correctamente con la base de datos: " + NombreDB);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error estableciendo conexion con la base de datos: " + NombreDB
                    + "\nDetalles del error: \n" + e.getMessage());
        }
        conexion = con;

    }
}
