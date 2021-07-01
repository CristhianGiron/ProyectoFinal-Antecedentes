/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author hp
 */
public class Juzgado {
    int idJuzgado;
    String nombreJuzgado;
    String direccionJuzgado;

    public Juzgado(int idJuzgado, String nombreJuzgado, String direccionJuzgado) {
        this.idJuzgado = idJuzgado;
        this.nombreJuzgado = nombreJuzgado;
        this.direccionJuzgado = direccionJuzgado;
    }

    public int getIdJuzgado() {
        return idJuzgado;
    }

    public void setIdJuzgado(int idJuzgado) {
        this.idJuzgado = idJuzgado;
    }

    public String getNombreJuzgado() {
        return nombreJuzgado;
    }

    public void setNombreJuzgado(String nombreJuzgado) {
        this.nombreJuzgado = nombreJuzgado;
    }

    public String getDireccionJuzgado() {
        return direccionJuzgado;
    }

    public void setDireccionJuzgado(String direccionJuzgado) {
        this.direccionJuzgado = direccionJuzgado;
    }
}
