package com.edu.udea.iw.rs.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioWs {

	private String nombres;
	private String apellidos;
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
}
