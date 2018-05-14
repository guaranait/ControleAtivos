package br.com.restful.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.restful.controller.UsuarioController;
import br.com.restful.model.Usuario;

@Path("/usuario")
public class UsuarioResource {

	@GET
	@Path("/listarUsuarios")
	@Produces("application/json")
	public Usuario listarUsuarios(long id){
		//long id = Long.parseLong(idString);
		return new UsuarioController().getUsuario(id);
	}
}
