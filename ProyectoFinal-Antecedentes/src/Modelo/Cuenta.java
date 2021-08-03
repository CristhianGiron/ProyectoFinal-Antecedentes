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
public class Cuenta {
    Long idCuenta;
    String usuario;
    String clave;
    Long idPersona;

    public Cuenta() {
    }
    
    public Cuenta(Long idCuenta, String usuario, String clave, Long idPersona) {
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.clave = clave;
        this.idPersona = idPersona;
    }
    
    
    public Long getIdCuenta(){
        return idCuenta;
    }
    public void setIdCuenta(Long idCuenta){
        this.idCuenta=idCuenta;
    }
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    public String getClave(){
        return clave;
    }
    public void setClave(String clave){
        this.clave=clave;
    } 
    public Long getIdPersona(){
        return idPersona;
    }
    public void setIdPersona(Long idPersona){
        this.idPersona=idPersona;
    }
}
