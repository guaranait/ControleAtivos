package br.com.restful.controller;

import java.text.ParseException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.restful.dao.AtivoDAO;
import br.com.restful.model.Ativo;
import br.com.restful.resource.AtivoResource;

@Path("/ativo")
public class AtivoController {
	private AtivoResource ativoResource;

	@GET
	@Path("/listarAtivos")
	@Produces("application/json")
	public Response listarAtivos() {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		String jsonAtivos = gson.toJson(ativoResource.listarAtivos());
		return Response.status(200).entity(jsonAtivos).build();
	}

	public ArrayList<Ativo> listarAtivosDisponiveis() {
		return AtivoDAO.getInstance().listarAtivosDisponiveis();
	}

	public ArrayList<Ativo> listarAtivosEmprestados() {
		return AtivoDAO.getInstance().listarAtivosEmprestados();
	}

	public ArrayList<Ativo> listarAtivosManutencao() {
		return AtivoDAO.getInstance().listarAtivosManutencao();
	}

	public ArrayList<Ativo> listarAtivo(Ativo ativo) {
		return AtivoDAO.getInstance().listarAtivo(ativo);
	}

	public Boolean cadastrarAtivo(Ativo ativo) {
		return AtivoDAO.getInstance().cadastrarAtivo(ativo);
	}

	@POST
	@Path("/alterarAtivo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterarAtivo(String ativoJson) throws ParseException {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Ativo ativo = gson.fromJson(ativoJson, Ativo.class);
		if (ativoResource.alterarAtivo(ativo)) {
			return Response.ok().build();
		} else {
			return Response.serverError().build();
		}
	}

	@POST
	@Path("/excluirAtivo")
	@Consumes("application/json")
	public Response excluirAtivo(String ativoJson) throws ParseException {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		Ativo ativo = gson.fromJson(ativoJson, Ativo.class);
		if (ativoResource.excluirAtivo(ativo)) {
			return Response.ok().build();
		} else {
			return Response.serverError().build();
		}
	}

	public boolean excluirAtivo(long id) {
		boolean sucesso = false;
		AtivoDAO ativoDAO = new AtivoDAO();
		sucesso = ativoDAO.excluirAtivo(id);
		return sucesso;
	}

	public boolean setManutencao(Ativo ativo) {
		return AtivoDAO.getInstance().setStatus(ativo);
	}

	public boolean validador(Ativo ativo) throws ParseException {
		boolean valido = false;
		if (ativo.getDescricao().isEmpty()
				|| (ativo.getDtCompra() == null || ativo.getDtCompra().equals(
						"")) || ativo.getFabricante().isEmpty()
				|| ativo.getIdStatus() <= 0 || ativo.getVlCompra() <= 0
				|| ativo.getVlDepreciado() <= 0) {
			return valido;
		} else {
			valido = true;
			return valido;
		}
	}

}
