package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.CategoriaDAO;
import br.com.restful.model.Categoria;

public class CategoriaController {
	
	public ArrayList<Categoria> listarCategorias(){
		return CategoriaDAO.getInstance().listarCategorias();
	}
	
	public Categoria listarCategoria(long id){
		return CategoriaDAO.getInstance().listarCategoria(id);
	}
	
	public Boolean cadastrarCategoria(Categoria categoria){
		return CategoriaDAO.getInstance().cadastrarCategoria(categoria);
	}
	
	public Boolean alterarCategoria(Categoria categoria){
		return CategoriaDAO.getInstance().alterarCategoria(categoria);
	}
	
	public boolean excluirCategoria(long id){
		boolean sucesso = false;
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		sucesso = categoriaDAO.excluirCategoria(id);
		return sucesso;
	}
	
}
