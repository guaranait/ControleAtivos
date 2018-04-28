package br.com.restful.resource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import br.com.restful.controller.AtivoController;
import br.com.restful.model.Ativo;
import com.google.gson.Gson;

@Path("/ativo")
public class AtivoResource {

	@GET
	@Path("/listarAtivos")
	@Produces("application/json")
	public Response listarAtivos(){
		ArrayList<Ativo> ativos = new ArrayList<Ativo>();
		AtivoController ativoController = new AtivoController();
		ativos = ativoController.listarAtivos();
		String json = new Gson().toJson(ativos);
		
		return Response.status(200).entity(json).build();
	}
	
	@GET
	@Path("/listarAtivo")
	@Produces("application/json")
	public Response listarAtivo(@QueryParam("id") long id){
		Ativo ativo = new Ativo();
		AtivoController ativoController = new AtivoController();
		ativo = ativoController.listarAtivo(id);
		return Response.status(200).entity(ativo).build();
	}
	
	@POST
	@Path("/cadastrarAtivo")
	@Consumes("application/json")
	public Response cadastrarAtivo(@QueryParam("descricao") String descricao,
								   @QueryParam("dtCompra") String dtCompra,
								   @QueryParam("fabricante") String fabricante,
								   @QueryParam("vlDepreciado") double vlDepreciado,
								   @QueryParam("vlCompra") double vlCompra,
								   @QueryParam("idStatus") int idStatus) throws ParseException{
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dataCompra = (Date)formatter.parse(dtCompra);
		
		Ativo ativo = new Ativo(0, descricao, fabricante, dataCompra, vlCompra, vlDepreciado, idStatus, 0, 0, null, null);
		System.out.println(ativo.toString());
		
		AtivoController ativoController = new AtivoController();
		ativoController.cadastrarAtivo(ativo);
		
		return Response.status(200).build();
	}
	
	@POST
	@Path("/alterarAtivo")
	@Consumes("application/json")
	public Ativo alterarAtivo(@QueryParam("id") long id,
							  @QueryParam("descricao") String descricao,
							  @QueryParam("dtCompra") String dtCompra,
							  @QueryParam("fabricante") String fabricante,
							  @QueryParam("vlDepreciado") double vlDepreciado,
							  @QueryParam("vlCompra") double vlCompra,
							  @QueryParam("idStatus") int idStatus) throws ParseException{
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dataCompra = (Date)formatter.parse(dtCompra);
		
		Ativo ativo = new Ativo(id, descricao, fabricante, dataCompra, vlCompra, vlDepreciado, idStatus, 0, 0, null, null);
		System.out.println(ativo.toString());
		
		return new AtivoController().alterarAtivo(ativo);
	}
	
	@POST
	@Path("/excluirAtivo")
	@Consumes("application/json")
	public Response excluirAtivo(@QueryParam("id") long id){
		if(new AtivoController().excluirAtivo(id)){
			return Response.ok().build();
		}else{
			return Response.serverError().build();
		}
	}
}
