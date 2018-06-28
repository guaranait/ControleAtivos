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
import br.com.restful.controller.EmprestimoController;
import br.com.restful.model.Ativo;
import br.com.restful.model.Emprestimo;

@Path("/emprestimo")
public class EmprestimoResource {

	@GET
	@Path("/listarEmprestimos")
	@Produces("application/json")
	public Response listarEmprestimos(){
		ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		EmprestimoController emprestimoController = new EmprestimoController();
		emprestimos = emprestimoController.listarEmprestimos();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String jsonEmprestimos = gson.toJson(emprestimos);
		
		return Response.status(200).entity(jsonEmprestimos).build();
	}
	
	@GET
	@Path("/listarEmprestimo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarEmprestimo(String emprestimoJson){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Emprestimo emprestimo = gson.fromJson(emprestimoJson, Emprestimo.class);
		
		ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		EmprestimoController emprestimoController = new EmprestimoController();
		
		emprestimos = emprestimoController.listarEmprestimo(emprestimo);
		
		String jsonEmprestimo = gson.toJson(emprestimo);
		return Response.status(200).entity(jsonEmprestimo).build();
	}
	
	@POST
	@Path("/cadastrarEmprestimo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarEmprestimo(String emprestimoJson) throws ParseException{
		
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy HH:mm:ss").create();
		Emprestimo emprestimo = gson.fromJson(emprestimoJson, Emprestimo.class);
		
		EmprestimoController emprestimoController = new EmprestimoController();
		if(emprestimoController.cadastrarEmprestimo(emprestimo)){
			return Response.ok().build();
		}else{
			return Response.serverError().build();
		}
		
	}
	
	@POST
	@Path("/alterarEmprestimo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterarEmprestimo(String emprestimoJson) throws ParseException{
		
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy HH:mm:ss").create();
		Emprestimo emprestimo = gson.fromJson(emprestimoJson, Emprestimo.class);
		
		EmprestimoController emprestimoController = new EmprestimoController();
		if(emprestimoController.alterarEmprestimo(emprestimo)){
			return Response.ok().build();
		}else{
			return Response.serverError().build();
		}
	}
	
	@POST
	@Path("/devolverEmprestimo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response devolverEmprestimo(String emprestimoJson) throws ParseException{
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Emprestimo emprestimo = gson.fromJson(emprestimoJson, Emprestimo.class);
		
		if(emprestimo.getAtivo().getId() > 0 && emprestimo.getFuncionario().getId() > 0) {
			if(new EmprestimoController().devolverEmprestimo(emprestimo)){
				return Response.ok().build();
			}else{
				return Response.serverError().build();
			}
		}else {
			return Response.status(400).build();
		}
	}
}
