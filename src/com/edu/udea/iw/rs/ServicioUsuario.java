package com.edu.udea.iw.rs;

import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.UsuarioBL;
import com.edu.udea.iw.rs.dto.UsuarioWs;

/**
 * Clase para el manejo de servicios web concernientes a los usuarios
 * @author Camilo Posada Angel -- cposadaa@gmail.com
 *
 */

@Path("ServicioUsuario")
@Component
public class ServicioUsuario {

	@Autowired
	UsuarioBL usuarioBL;
	
	
	
	
	public UsuarioBL getClienteBL() {
		return usuarioBL;
	}




	public void setClienteBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}


	
	

	/**
	 * Metodo para el servicio web de obtener un usuario validando su login y contrasena
	 * @return JSON  con la informacion del nombre y apellido del usuario 
	 * @throws RemoteException en caso de que el usuario no se encuentre o la contraseña sea incorrecta
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("validar")
	public UsuarioWs validarUsuarioContraseña(@QueryParam("login")String login , @QueryParam("contrasena")String contrasena) throws RemoteException{
		UsuarioWs usuarioWs = new UsuarioWs();
		Usuario usuario = null;
		try {
			usuario = usuarioBL.validar(login, contrasena);
			usuarioWs.setNombres(usuario.getNombres());
			usuarioWs.setApellidos(usuario.getApellidos());
		} catch (MyDaoExeption e) {
			throw new RemoteException(e.getMessage(),e);
		}
		
		return usuarioWs;
		
	}
	
	
}
