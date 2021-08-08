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
public class cesion {
    Long idCesion;
    String usuario;
    String clave;
    Long idPersona;
    
    public void cesion(Long idCesion, String usuario, String clave,Long isPersona){
        this.idCesion=idCesion;
        this.usuario=usuario;
        this.clave=clave;
        this.idPersona=idPersona;  
    }
    public Long getIdCesion(){
        return idCesion;
    }
    public void setIdCesion(){
        this.idCesion=idCesion;
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
    public void setIdPersona(){
        this.idPersona=idPersona;
    }
}
