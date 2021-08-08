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
    private Long idJuzgado;
    private String nombreJuzgado;
    private String direccionJuzgado;
    private String estadoJuzgado;

    public Juzgado(Long idJuzgado, String nombreJuzgado, String direccionJuzgado, String estadoJuzgado) {
        this.idJuzgado = idJuzgado;
        this.nombreJuzgado = nombreJuzgado;
        this.direccionJuzgado = direccionJuzgado;
        this.estadoJuzgado = estadoJuzgado;
    }

    public Juzgado() {
    }

    public Long getIdJuzgado() {
        return idJuzgado;
    }

    public void setIdJuzgado(Long idJuzgado) {
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

    public String getEstadoJuzgado() {
        return estadoJuzgado;
    }

    public void setEstadoJuzgado(String estadoJuzgado) {
        this.estadoJuzgado = estadoJuzgado;
    }

    @Override
    public String toString() {
        return "Juzgado{" + "idJuzgado=" + idJuzgado + ", nombreJuzgado=" + nombreJuzgado + ", direccionJuzgado=" + direccionJuzgado + ", estadoJuzgado=" + estadoJuzgado + '}';
    }
}
