package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.AtivoDAO;
import br.com.restful.model.Ativo;

public class AtivoController {
	
	public ArrayList<Ativo> listarAtivos(){
		return AtivoDAO.getInstance().listarAtivos();
	}
	
	public Ativo listarAtivo(long id){
		return AtivoDAO.getInstance().listarAtivo(id);
	}
	
	public Ativo cadastrarAtivo(Ativo ativo){
		return AtivoDAO.getInstance().cadastrarAtivo(ativo);
	}
	
	public Ativo alterarAtivo(Ativo ativo){
		return AtivoDAO.getInstance().alterarAtivo(ativo);
	}
	
	public boolean excluirAtivo(long id){
		boolean sucesso = false;
		AtivoDAO ativoDAO = new AtivoDAO();
		sucesso = ativoDAO.excluirAtivo(id);
		return sucesso;
	}
	
}
