package com.edu.udea.iw.rs;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edu.udea.iw.dto.Cliente;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.ClienteBL;
import com.edu.udea.iw.rs.dto.ClienteWs;

/**
 * Clase para el manejo de servicios web concernientes a los clientes
 * @author Camilo Posada Angel -- cposadaa@gmail.com
 *
 */

@Path("ServicioCliente")
@Component
public class ServicioCliente {
	
	@Autowired
	ClienteBL clienteBL;
	
	
	
	
	public ClienteBL getClienteBL() {
		return clienteBL;
	}




	public void setClienteBL(ClienteBL clienteBL) {
		this.clienteBL = clienteBL;
	}


	
	

	/**
	 * Metodo para el servicio web de obtener todos los clientes
	 * @return JSON  con la informacion de los clientes
	 * @throws RemoteException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteWs> obtener() throws RemoteException{
		List<ClienteWs> resultado = new ArrayList<>();
		List<Cliente> datos = null;
		
		try {
			datos = clienteBL.obtener();
				
			for(Cliente cliente:datos){
				ClienteWs clientews = new ClienteWs(cliente.getNombres(), cliente.getApellidos(), cliente.getCedula(), cliente.getEmail());
				resultado.add(clientews);
			}
			
		} catch (MyDaoExeption e) {
			throw new RemoteException(e.getMessage(),e);
		}
		return resultado;
	}
	
}
