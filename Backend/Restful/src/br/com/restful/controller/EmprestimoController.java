package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.AtivoDAO;
import br.com.restful.dao.EmprestimoDAO;
import br.com.restful.model.Ativo;
import br.com.restful.model.Emprestimo;
import br.com.restful.model.Manutencao;

public class EmprestimoController {
	
	public ArrayList<Emprestimo> listarEmprestimos(){
		return EmprestimoDAO.getInstance().listarEmprestimos();
	}
	
	public ArrayList<Emprestimo> listarEmprestimo(Emprestimo emprestimo){
		return EmprestimoDAO.getInstance().listarEmprestimo(emprestimo);
	}
	
	public Boolean cadastrarEmprestimo(Emprestimo emprestimo){
		return EmprestimoDAO.getInstance().cadastrarEmprestimo(emprestimo);
	}
	
	public Boolean alterarEmprestimo(Emprestimo emprestimo){
		return EmprestimoDAO.getInstance().alterarEmprestimo(emprestimo);
	}
	
	public boolean excluirEmprestimo(Emprestimo emprestimo){
		boolean sucesso = false;
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		sucesso = emprestimoDAO.excluirEmprestimo(emprestimo);
		return sucesso;
	}
	
	public boolean validador(Emprestimo emprestimo) {
		boolean valido = true;
		return valido;
	}
	
}
