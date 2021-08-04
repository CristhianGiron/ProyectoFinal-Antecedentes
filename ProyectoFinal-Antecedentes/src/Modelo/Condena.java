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
public class Condena {
   private Long idCondena;
   private String tipoCondena;
   private String sentencia;
   private String estadoCondena;

    public Condena(Long idCondena, String tipoCondena, String sentencia, String estadoCondena) {
        this.idCondena = idCondena;
        this.tipoCondena = tipoCondena;
        this.sentencia = sentencia;
        this.estadoCondena = estadoCondena;
    }

    public Long getIdCondena() {
        return idCondena;
    }

    public void setIdCondena(Long idCondena) {
        this.idCondena = idCondena;
    }

    public String getTipoCondena() {
        return tipoCondena;
    }

    public void setTipoCondena(String tipoCondena) {
        this.tipoCondena = tipoCondena;
    }

    public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }

    public String getEstadoCondena() {
        return estadoCondena;
    }

    public void setEstadoCondena(String estadoCondena) {
        this.estadoCondena = estadoCondena;
    }
}
