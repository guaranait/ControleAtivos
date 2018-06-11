package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.GarantiaDAO;
import br.com.restful.model.Garantia;
import br.com.restful.model.Manutencao;

public class GarantiaController {
	
	public ArrayList<Garantia> listarGarantias(){
		return GarantiaDAO.getInstance().listarGarantias();
	}
	
	public Boolean cadastrarGarantia(Garantia garantia){
		return GarantiaDAO.getInstance().cadastrarGarantia(garantia);
	}
	
	public Boolean alterarGarantia(Garantia garantia){
		return GarantiaDAO.getInstance().alterarGarantia(garantia);
	}
	
	public boolean excluirGarantia(long id){
		boolean sucesso = false;
		GarantiaDAO garantiaDAO = new GarantiaDAO();
		sucesso = garantiaDAO.excluirGarantia(id);
		return sucesso;
	}
	
	public boolean validador(Garantia garantia) {
		boolean valido = true;
		return valido;
	}
	
}
