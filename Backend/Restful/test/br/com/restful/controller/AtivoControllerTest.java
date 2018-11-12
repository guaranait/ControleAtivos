package br.com.restful.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.restful.dao.AtivoDAO;
import br.com.restful.model.Ativo;
import br.com.restful.resource.AtivoResource;

public class AtivoControllerTest {
	AtivoController ativoController;
	
	@Before
	public void setup(){
		this.ativoController = new AtivoController();
	}

	@Test(expected = NullPointerException.class)
	public void testAtivoVazio() throws ParseException {
		Ativo ativo = new Ativo();
		assertFalse(ativoController.validador(ativo));
	}
	
	@Test
	public void testAtivoComDescricaoNaoPreenchida() throws ParseException {
		Ativo ativo = new Ativo();
		ativo.setDescricao("");
		assertFalse(ativoController.validador(ativo));
	}
	
	@Test
	public void testAtivoComDescricaoPreenchidaSemDtCompra() throws ParseException {
		Ativo ativo = new Ativo();
		ativo.setDescricao("Teste");
		assertFalse(ativoController.validador(ativo));
	}
	
	@Test
	public void testAtivoComDescrPreenchidaDtCompraSemFabricante() throws ParseException {
		Ativo ativo = new Ativo();
		ativo.setDescricao("Teste");
		ativo.setDtCompra(new Date());
		ativo.setFabricante("");
		assertFalse(ativoController.validador(ativo));
	}
	
	@Test
	public void testAtivoComDescrPreenchidaDtCompraComFabricante() throws ParseException {
		Ativo ativo = new Ativo();
		ativo.setDescricao("Teste");
		ativo.setDtCompra(new Date());
		ativo.setFabricante("Fabricante");
		assertFalse(ativoController.validador(ativo));
	}
	
	@Test
	public void testAtivoComDescrPreenchidaDtCompraSemFabricanteSemIdStatus() throws ParseException {
		Ativo ativo = new Ativo();
		ativo.setDescricao("Teste");
		ativo.setDtCompra(new Date());
		ativo.setFabricante("Fabricante");
		ativo.setIdStatus(-1);
		assertFalse(ativoController.validador(ativo));
	}
	
	@Test
	public void testAtivoComDescrPreenchidaDtCompraSemFabricanteComIdStatus() throws ParseException {
		Ativo ativo = new Ativo();
		ativo.setDescricao("Teste");
		ativo.setDtCompra(new Date());
		ativo.setFabricante("Fabricante");
		ativo.setIdStatus(10);
		assertFalse(ativoController.validador(ativo));
	}
	
	@Test
	public void testAtivoComDescrPreenchidaDtCompraSemFabricanteSemIdStatusSemVlCompra() throws ParseException {
		Ativo ativo = new Ativo();
		ativo.setDescricao("Teste");
		ativo.setDtCompra(new Date());
		ativo.setFabricante("Fabricante");
		ativo.setIdStatus(-1);
		ativo.setVlCompra(-1);
		assertFalse(ativoController.validador(ativo));
	}
	
	@Test
	public void testAtivoComDescrPreenchidaDtCompraSemFabricanteComIdStatusComVlCompra() throws ParseException {
		Ativo ativo = new Ativo();
		ativo.setDescricao("Teste");
		ativo.setDtCompra(new Date());
		ativo.setFabricante("Fabricante");
		ativo.setIdStatus(10);
		ativo.setVlCompra(10);
		assertFalse(ativoController.validador(ativo));
	}
	
	@Test
	public void testAtivoComDescrPreenchidaDtCompraSemFabricanteSemIdStatusSemVlCompraSemVlDepreciado() throws ParseException {
		Ativo ativo = new Ativo();
		ativo.setDescricao("Teste");
		ativo.setDtCompra(new Date());
		ativo.setFabricante("Fabricante");
		ativo.setIdStatus(-1);
		ativo.setVlCompra(-1);
		ativo.setVlDepreciado(-1);
		assertFalse(ativoController.validador(ativo));
	}
	
	@Test
	public void testAtivoComDescrPreenchidaDtCompraSemFabricanteComIdStatusComVlCompraComVlDepreciado() throws ParseException {
		Ativo ativo = new Ativo();
		ativo.setDescricao("Teste");
		ativo.setDtCompra(new Date());
		ativo.setFabricante("Fabricante");
		ativo.setIdStatus(10);
		ativo.setVlCompra(10);
		ativo.setVlDepreciado(10);
		assertTrue(ativoController.validador(ativo));
	}
	
	@Test
	public void testListarTodos()  {
		AtivoController ativoController = mock(AtivoController.class);
		Ativo ativoResult = new Ativo();
		ativoResult.setId(1l);
		ArrayList<Ativo> listResult = new ArrayList<>(); 
		listResult.add(ativoResult);
		
		Ativo ativo = new Ativo();
		ativo.setId(1l);
		when(ativoController.listarAtivo(ativo)).thenReturn(listResult);

		assertEquals(1, ativoController.listarAtivo(ativo).size());
	}
	
	@Test
	public void testExcluirAtivoComIdInvalido() throws ParseException  {
		Ativo ativo = new Ativo();
		ativo.setId(-1l);

		assertEquals(false, new AtivoResource().excluirAtivo(ativo));
	}
	
	@Test
	public void testExcluirAtivoComDaoRetornandoOk() throws ParseException  {
		AtivoResource ativoResource = new AtivoResource();
		AtivoDAO dao = mock(AtivoDAO.class);
		
		ativoResource.setAtivoDAO(dao);
		
		Ativo ativo = new Ativo();
		ativo.setId(1l);
		when(dao.excluirAtivo(ativo.getId())).thenReturn(true);
		assertEquals(true, ativoResource.excluirAtivo(ativo));
	}
	
	@Test
	public void testAlteraAtivoComDaoRetornandoOkSemAtivoPreenchido() throws ParseException  {
		AtivoResource ativoResource = new AtivoResource();
		AtivoDAO dao = mock(AtivoDAO.class);
		
		ativoResource.setAtivoDAO(dao);
		
		Ativo ativo = new Ativo();
		ativo.setId(1l);
		ativo.setDescricao("");
		when(dao.alterarAtivo(ativo)).thenReturn(true);
		assertEquals(false, ativoResource.alterarAtivo(ativo));
	}
	
	@Test
	public void testAlteraAtivoComDaoRetornandoOkComAtivoPreenchido() throws ParseException  {
		AtivoResource ativoResource = new AtivoResource();
		AtivoDAO dao = mock(AtivoDAO.class);
		
		
		
		Ativo ativo = new Ativo();
		ativo.setDescricao("Teste");
		ativo.setDtCompra(new Date());
		ativo.setFabricante("Fabricante");
		ativo.setIdStatus(10);
		ativo.setVlCompra(10);
		ativo.setVlDepreciado(10);
		
		when(dao.alterarAtivo(ativo)).thenReturn(true);
		ativoResource.setAtivoDAO(dao);
		assertEquals(true, ativoResource.alterarAtivo(ativo));
	}
}

