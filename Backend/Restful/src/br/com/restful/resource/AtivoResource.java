package br.com.restful.resource;

import java.text.ParseException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.restful.controller.AtivoController;
import br.com.restful.dao.AtivoDAO;
import br.com.restful.model.Ativo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/ativo")
public class AtivoResource {
	AtivoDAO ativoDAO = new AtivoDAO();
	
	public AtivoDAO getAtivoDAO() {
		return ativoDAO;
	}

	public void setAtivoDAO(AtivoDAO ativoDAO) {
		this.ativoDAO = ativoDAO;
	}

	public ArrayList<Ativo> listarAtivos(){
		return AtivoDAO.getInstance().listarAtivos();
	}
	
	@GET
	@Path("/listarAtivosDisponiveis")
	@Produces("application/json")
	public Response listarAtivosDisponiveis(){
		ArrayList<Ativo> ativos = new ArrayList<Ativo>();
		AtivoController ativoController = new AtivoController();
		ativos = ativoController.listarAtivosDisponiveis();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String jsonAtivos = gson.toJson(ativos);
		
		return Response.status(200).entity(jsonAtivos).build();
	}
	
	@GET
	@Path("/listarAtivosEmprestados")
	@Produces("application/json")
	public Response listarAtivosEmprestados(){
		ArrayList<Ativo> ativos = new ArrayList<Ativo>();
		AtivoController ativoController = new AtivoController();
		ativos = ativoController.listarAtivosEmprestados();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String jsonAtivos = gson.toJson(ativos);
		
		return Response.status(200).entity(jsonAtivos).build();
	}
	
	@GET
	@Path("/listarAtivosManutencao")
	@Produces("application/json")
	public Response listarAtivosManutencao(){
		ArrayList<Ativo> ativos = new ArrayList<Ativo>();
		AtivoController ativoController = new AtivoController();
		ativos = ativoController.listarAtivosManutencao();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String jsonAtivos = gson.toJson(ativos);
		
		return Response.status(200).entity(jsonAtivos).build();
	}
	
	@GET
	@Path("/listarAtivo")
	@Produces("application/json")
	public Response listarAtivo(String ativoJson){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Ativo ativo = gson.fromJson(ativoJson, Ativo.class);
		
		ArrayList<Ativo> ativos = new ArrayList<Ativo>();
		AtivoController ativoController = new AtivoController();
		
		ativos = ativoController.listarAtivo(ativo);
		
		String jsonAtivo = new Gson().toJson(ativos);
		return Response.status(200).entity(jsonAtivo).build();
	}
	
	@POST
	@Path("/cadastrarAtivo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarAtivo(String ativoJson) throws ParseException{
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Ativo ativo = gson.fromJson(ativoJson, Ativo.class);
		
		AtivoController ativoController = new AtivoController();
		if(ativoController.validador(ativo)) {
			if(ativoController.cadastrarAtivo(ativo)){
				return Response.ok().build();
			}else{
				return Response.serverError().build();
			}
		}else {
			return Response.status(400).build();
		}
		
	}
	
	@POST
	@Path("/alterarAtivo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterarAtivo(String ativoJson) throws ParseException{
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Ativo ativo = gson.fromJson(ativoJson, Ativo.class);
		
		AtivoController ativoController = new AtivoController();
		if(ativoController.validador(ativo)) {
			if(ativoController.alterarAtivo(ativo)){
				return Response.ok().build();
			}else{
				return Response.serverError().build();
			}
		}else {
			return Response.status(400).build();
		}
	}
	
	public boolean excluirAtivo(Ativo ativo) throws ParseException{
		if(ativo.getId() < 0 || !ativoDAO.excluirAtivo(ativo.getId())) {
			return false;
		}else {
			return true;
		}
	}
}
