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
    private Long idProceso;
    private int instancia;
    private String fechaInicio;
    private String fechaFinal;
    private int nrAudiencias;
    private byte[] text;
    private String nombreDocumento;
    private String estadoVictimario;
    private String estadoDemanda;
    private String estadoProceso;
    private Long idDelito;
    private Long idPersona;
    private Long idCondena;
    private Long idJuzgado;

    public Proceso(Long idProceso, int instancia, String fechaInicio, String fechaFinal, int nrAudiencias, byte[] text, String nombreDocumento, String estadoVictimario, String estadoDemanda, String estadoProceso, Long idDelito, Long idPersona, Long idCondena, Long idJuzgado) {
        this.idProceso = idProceso;
        this.instancia = instancia;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.nrAudiencias = nrAudiencias;
        this.text = text;
        this.nombreDocumento = nombreDocumento;
        this.estadoVictimario = estadoVictimario;
        this.estadoDemanda = estadoDemanda;
        this.estadoProceso = estadoProceso;
        this.idDelito = idDelito;
        this.idPersona = idPersona;
        this.idCondena = idCondena;
        this.idJuzgado = idJuzgado;
    }

    public Long getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Long idProceso) {
        this.idProceso = idProceso;
    }

    public int getInstancia() {
        return instancia;
    }

    public void setInstancia(int instancia) {
        this.instancia = instancia;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getNrAudiencias() {
        return nrAudiencias;
    }

    public void setNrAudiencias(int nrAudiencias) {
        this.nrAudiencias = nrAudiencias;
    }

    public byte[] getText() {
        return text;
    }

    public void setText(byte[] text) {
        this.text = text;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
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

    public String getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(String estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    public Long getIdDelito() {
        return idDelito;
    }

    public void setIdDelito(Long idDelito) {
        this.idDelito = idDelito;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdCondena() {
        return idCondena;
    }

    public void setIdCondena(Long idCondena) {
        this.idCondena = idCondena;
    }

    public Long getIdJuzgado() {
        return idJuzgado;
    }

    public void setIdJuzgado(Long idJuzgado) {
        this.idJuzgado = idJuzgado;
    }
}
