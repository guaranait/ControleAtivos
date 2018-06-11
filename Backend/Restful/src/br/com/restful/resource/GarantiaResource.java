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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.restful.controller.GarantiaController;
import br.com.restful.controller.GarantiaController;
import br.com.restful.model.Garantia;
import br.com.restful.model.Garantia;

@Path("/garantia")
public class GarantiaResource {

	@GET
	@Path("/listarGarantias")
	@Produces("application/json")
	public Response listarGarantias(){
		ArrayList<Garantia> garantias = new ArrayList<Garantia>();
		GarantiaController garantiaController = new GarantiaController();
		garantias = garantiaController.listarGarantias();
		String jsonGarantias = new Gson().toJson(garantias);
		
		return Response.status(200).entity(jsonGarantias).build();
	}
	
	/*@GET
	@Path("/listarGarantia")
	@Produces("application/json")
	public Response listarGarantia(@QueryParam("id") long id){
		Garantia garantia = null;
		GarantiaController garantiaController = new GarantiaController();
		garantia = garantiaController.listarGarantia(id);
		
		String jsonGarantia = new Gson().toJson(garantia);
		return Response.status(200).entity(jsonGarantia).build();
	}*/
	
	@POST
	@Path("/cadastrarGarantia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarGarantia(String garantiaJson) throws ParseException{
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Garantia garantia = gson.fromJson(garantiaJson, Garantia.class);
		
		GarantiaController garantiaController = new GarantiaController();
		if(garantiaController.validador(garantia)) {
			if(garantiaController.cadastrarGarantia(garantia)){
				return Response.ok().build();
			}else{
				return Response.serverError().build();
			}
		}else {
			return Response.status(400).build();
		}
		
	}
	
	@POST
	@Path("/alterarGarantia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterarGarantia(String garantiaJson) throws ParseException{
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Garantia garantia = gson.fromJson(garantiaJson, Garantia.class);
		
		GarantiaController garantiaController = new GarantiaController();
		if(garantiaController.validador(garantia)) {
			if(garantiaController.alterarGarantia(garantia)){
				return Response.ok().build();
			}else{
				return Response.serverError().build();
			}
		}else {
			return Response.status(400).build();
		}
	}
	
	@POST
	@Path("/excluirGarantia")
	@Consumes("application/json")
	public Response excluirGarantia(String garantiaJson) throws ParseException{
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Garantia garantia = gson.fromJson(garantiaJson, Garantia.class);
		
		if(garantia.getId() > 0) {
			if(new GarantiaController().excluirGarantia(garantia.getId())){
				return Response.ok().build();
			}else{
				return Response.serverError().build();
			}
		}else {
			return Response.status(400).build();
		}
	}
}
