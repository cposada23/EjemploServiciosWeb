package com.edu.udea.iw.rs;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Responde peticiones web para la funcionalidad de saludar 
 * @author Camilo Posada Angel -- cposadaa@gmail.com
 *
 */

@Path("Saludo")
public class ServicioSaludo {
	
	/**
	 * Return el primer saludo 
	 * @return
	 */
	
	@GET
	@Produces("text/html")
	public String saludar(){
		return "Hola";
	}
	
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("hola/{nombre}")
	public String digameHola(@PathParam("nombre")String nombre){
		return "Holaaaaaaaaaaa " + nombre;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("hola")
	public String digameHolaQuery(@QueryParam("nombre")String nombre , @QueryParam("apellido")String apellido){
		return "Holaaaaaaaaaaa " + nombre+ " " + apellido;
	}
	
}
