package Modelo;

import java.io.File;


public class Persona {
	private Long idPersona;
	private String cedula;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String direccion;
	private String estadoCivil;
	private String telefono;
	private String mail;
        private Boolean estado;
        private File imagen;
        private Long idRol;
        
    public Persona(){
        
    }
    public Persona(Long idPersona, String cedula, String nombre, String apellido, String fechaNacimiento, String direccion, String estadoCivil, String telefono, String mail, Boolean estado, File imagen,Long idRol) {
        this.idPersona = idPersona;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.telefono = telefono;
        this.mail = mail;
        this.estado = estado;
        this.imagen = imagen;
        this.idRol=idRol;
    }
    public Persona(Long idPersona, String cedula, String nombre, String apellido, String fechaNacimiento, String direccion, String estadoCivil, String telefono, String mail, Boolean estado,Long idRol) {
        this.idPersona = idPersona;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.telefono = telefono;
        this.mail = mail;
        this.estado = estado;
        this.idRol=idRol;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public File getFile() {
        return imagen;
    }

    public void setFile(File imagen) {
        this.imagen = imagen;
    }
    public Long getIdRol(){
        return idRol;
    }
    public void setIdRol(Long idRol){
       this.idRol=idRol; 
    }
    
	
	
	

}
