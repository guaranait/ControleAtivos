package br.com.restful.resource;

import java.text.ParseException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.restful.controller.AtivoController;
import br.com.restful.controller.FuncionarioController;
import br.com.restful.controller.UsuarioController;
import br.com.restful.controller.UsuarioController;
import br.com.restful.controller.UsuarioController;
import br.com.restful.model.Funcionario;
import br.com.restful.model.Usuario;
import br.com.restful.model.Usuario;
import br.com.restful.model.Usuario;

@Path("/usuario")
public class UsuarioResource {

	@GET
	@Path("/listarUsuarios")
	@Produces("application/json")
	public Response listarUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		UsuarioController usuarioController = new UsuarioController();
		usuarios = usuarioController.listarUsuarios();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String jsonUsuarios = gson.toJson(usuarios);
		
		return Response.status(200).entity(jsonUsuarios).build();
	}
	
	@GET
	@Path("/listarUsuario")
	@Produces("application/json")
	public Response listarUsuario(@QueryParam("id") long id){
		Usuario usuario = null;
		UsuarioController usuarioController = new UsuarioController();
		//usuario = usuarioController.listarUsuario(id);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String jsonUsuario = gson.toJson(usuario);
		return Response.status(200).entity(jsonUsuario).build();
	}
	
	@POST
	@Path("/cadastrarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarUsuario(String usuarioJson) throws ParseException{
		
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy HH:mm:ss").create();
		Usuario usuario = gson.fromJson(usuarioJson, Usuario.class);
		
		UsuarioController usuarioController = new UsuarioController();
		if(usuarioController.cadastrarUsuario(usuario)){
			return Response.ok().build();
		}else{
			return Response.serverError().build();
		}
	}
	
	@POST
	@Path("/alterarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterarUsuario(String usuarioJson) throws ParseException{
		
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy HH:mm:ss").create();
		Usuario usuario = gson.fromJson(usuarioJson, Usuario.class);
		
		UsuarioController usuarioController = new UsuarioController();
		if(usuarioController.alterarUsuario(usuario)){
			return Response.ok().build();
		}else{
			return Response.serverError().build();
		}
	}
	
	@POST
	@Path("/excluirUsuario")
	@Consumes("application/json")
	public Response excluirUsuario(String usuarioJson) throws ParseException{
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Usuario usuario = gson.fromJson(usuarioJson, Usuario.class);
		
		if(usuario.getId() > 0) {
			if(new UsuarioController().excluirUsuario(usuario.getId())){
				return Response.ok().build();
			}else{
				return Response.serverError().build();
			}
		}else {
			return Response.status(400).build();
		}
	}
	
	@POST
	@Path("/login")
	@Consumes("application/json")
	public Response loginUsuario(String usuarioJson) throws ParseException{
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Usuario usuario = gson.fromJson(usuarioJson, Usuario.class);
		
		if(usuario.getId() > 0) {
			if(new UsuarioController().loginUsuario(usuario)){
				return Response.ok().build();
			}else{
				return Response.serverError().build();
			}
		}else {
			return Response.status(400).build();
		}
	}
	
}
