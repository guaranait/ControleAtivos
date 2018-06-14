package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.FuncionarioDAO;
import br.com.restful.dao.ManutencaoDAO;
import br.com.restful.model.Funcionario;
import br.com.restful.model.Manutencao;

public class ManutencaoController {
	
	public ArrayList<Manutencao> listarManutencoes(){
		return ManutencaoDAO.getInstance().listarManutencoes();
	}
	
	public Boolean cadastrarManutencao(Manutencao manutencao){
		return ManutencaoDAO.getInstance().cadastrarManutencao(manutencao);
	}
	
	public Boolean concluirManutencao(Manutencao manutencao){
		return ManutencaoDAO.getInstance().concluirManutencao(manutencao);
	}
	
	public boolean validador(Manutencao manutencao) {
		boolean valido = true;
		return valido;
	}
}
