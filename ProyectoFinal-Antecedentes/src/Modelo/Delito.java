/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ASUS
 */
public class Delito {
    private Long idDelito;
    private String nombre;
    private String articulo;
    private String descripcion;
    private String tipoSancion;
    private String estadoDelito;

    public Delito() {
    }

    public Delito(Long idDelito, String nombre, String articulo, String descripcion, String tipoSancion, String estadoDelito) {
        this.idDelito = idDelito;
        this.nombre = nombre;
        this.articulo = articulo;
        this.descripcion = descripcion;
        this.tipoSancion = tipoSancion;
        this.estadoDelito = estadoDelito;
    }

    public Long getIdDelito() {
        return idDelito;
    }

    public void setIdDelito(Long idDelito) {
        this.idDelito = idDelito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoSancion() {
        return tipoSancion;
    }

    public void setTipoSancion(String tipoSancion) {
        this.tipoSancion = tipoSancion;
    }

    public String getEstadoDelito() {
        return estadoDelito;
    }

    public void setEstadoDelito(String estadoDelito) {
        this.estadoDelito = estadoDelito;
    }

    @Override
    public String toString() {
        return "Delito{" + "idDelito=" + idDelito + ", nombre=" + nombre + ", articulo=" + articulo + ", descripcion=" + descripcion + ", tipoSancion=" + tipoSancion + ", estadoDelito=" + estadoDelito + '}';
    }
}
