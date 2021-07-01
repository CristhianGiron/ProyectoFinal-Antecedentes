/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Proceso {
    int idProceso;
    String tipoProceso;
    String delito;
    int instancia;
    Date fechaInicio;
    Date fechaFinal;
    int nrAudiencias;
    String duracion;
    File text;
    String estadoVictimario;
    String estadoDemanda;

    public Proceso(int idProceso, String tipoProceso, String delito, int instancia, Date fechaInicio, Date fechaFinal, int nrAudiencias, String duracion, File text, String estadoVictimario, String estadoDemanda) {
        this.idProceso = idProceso;
        this.tipoProceso = tipoProceso;
        this.delito = delito;
        this.instancia = instancia;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.nrAudiencias = nrAudiencias;
        this.duracion = duracion;
        this.text = text;
        this.estadoVictimario = estadoVictimario;
        this.estadoDemanda = estadoDemanda;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    public String getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(String tipoProceso) {
        this.tipoProceso = tipoProceso;
    }

    public String getDelito() {
        return delito;
    }

    public void setDelito(String delito) {
        this.delito = delito;
    }

    public int getInstancia() {
        return instancia;
    }

    public void setInstancia(int instancia) {
        this.instancia = instancia;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getNrAudiencias() {
        return nrAudiencias;
    }

    public void setNrAudiencias(int nrAudiencias) {
        this.nrAudiencias = nrAudiencias;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public File getText() {
        return text;
    }

    public void setText(File text) {
        this.text = text;
    }

    public String getEstadoVictimario() {
        return estadoVictimario;
    }

    public void setEstadoVictimario(String estadoVictimario) {
        this.estadoVictimario = estadoVictimario;
    }

    public String getEstadoDemanda() {
        return estadoDemanda;
    }

    public void setEstadoDemanda(String estadoDemanda) {
        this.estadoDemanda = estadoDemanda;
    }
}
