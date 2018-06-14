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

import br.com.restful.controller.CategoriaController;
import br.com.restful.model.Categoria;

@Path("/categoria")
public class CategoriaResource {

	@GET
	@Path("/listarCategorias")
	@Produces("application/json")
	public Response listarCategorias(){
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		CategoriaController categoriaController = new CategoriaController();
		categorias = categoriaController.listarCategorias();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String jsonCategorias = gson.toJson(categorias);
		
		return Response.status(200).entity(jsonCategorias).build();
	}
	
	@GET
	@Path("/listarCategoria")
	@Produces("application/json")
	public Response listarCategoria(@QueryParam("id") long id){
		Categoria categoria = null;
		CategoriaController categoriaController = new CategoriaController();
		categoria = categoriaController.listarCategoria(id);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String jsonCategoria = gson.toJson(categoria);
		return Response.status(200).entity(jsonCategoria).build();
	}
	
	@POST
	@Path("/cadastrarCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarCategoria(String categoriaJson) throws ParseException{
		
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy HH:mm:ss").create();
		Categoria categoria = gson.fromJson(categoriaJson, Categoria.class);
		
		CategoriaController categoriaController = new CategoriaController();
		if(categoriaController.cadastrarCategoria(categoria)){
			return Response.ok().build();
		}else{
			return Response.serverError().build();
		}
		
	}
	
	@POST
	@Path("/alterarCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterarCategoria(String categoriaJson) throws ParseException{
		
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy HH:mm:ss").create();
		Categoria categoria = gson.fromJson(categoriaJson, Categoria.class);
		
		CategoriaController categoriaController = new CategoriaController();
		if(categoriaController.alterarCategoria(categoria)){
			return Response.ok().build();
		}else{
			return Response.serverError().build();
		}
	}
	
	@POST
	@Path("/excluirCategoria")
	@Consumes("application/json")
	public Response excluirCategoria(String categoriaJson) throws ParseException{
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Categoria categoria = gson.fromJson(categoriaJson, Categoria.class);
		
		if(categoria.getId() > 0) {
			if(new CategoriaController().excluirCategoria(categoria.getId())){
				return Response.ok().build();
			}else{
				return Response.serverError().build();
			}
		}else {
			return Response.status(400).build();
		}
	}
}
