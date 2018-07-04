package br.com.restful.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.restful.controller.DashboardController;
import br.com.restful.model.ContadorAtivo;
import br.com.restful.model.ContadorGarantia;

@Path("/dashboard")
public class DashboardResource {
	
	@GET
	@Path("/contadorAtivos")
	@Produces("application/json")
	public Response contadorAtivos(){
		ArrayList<ContadorAtivo> contadorAtivos = new ArrayList<>();
		DashboardController dashboardController = new DashboardController();
		contadorAtivos = dashboardController.contadorAtivos();
		String jsonContadorAtivos = new Gson().toJson(contadorAtivos);
		
		return Response.status(200).entity(jsonContadorAtivos).build();
	}
	
	@GET
	@Path("/contadorGarantia")
	@Produces("application/json")
	public Response contadorGarantia(){
		ArrayList<ContadorGarantia> contadorGarantia = new ArrayList<>();
		DashboardController dashboardController = new DashboardController();
		contadorGarantia = dashboardController.contadorGarantia();
		String jsonContadorGarantia = new Gson().toJson(contadorGarantia);
		
		return Response.status(200).entity(jsonContadorGarantia).build();
	}
	
	@GET
	@Path("/valorPatrimonio")
	@Produces("application/json")
	public Response patrimonio(){
		ArrayList<Double> valorPatrimonio = new ArrayList<>();
		DashboardController dashboardController = new DashboardController();
		valorPatrimonio = dashboardController.valorPatrimonio();
		String jsonValorPatrimonio = new Gson().toJson(valorPatrimonio);
		return Response.status(200).entity(jsonValorPatrimonio).build();
	}

}
