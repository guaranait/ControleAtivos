package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.UsuarioDAO;
import br.com.restful.dao.UsuarioDAO;
import br.com.restful.model.Usuario;
import br.com.restful.model.Usuario;

public class UsuarioController {
	public Usuario getUsuario(long id){
		return UsuarioDAO.getInstance().getUsuario(id);
	}
	
	public Boolean cadastrarUsuario(Usuario usuario){
		return UsuarioDAO.getInstance().cadastrarUsuario(usuario);
	}
	
	public Boolean alterarUsuario(Usuario usuario){
		return UsuarioDAO.getInstance().alterarUsuario(usuario);
	}
	
	public boolean excluirUsuario(long id){
		boolean sucesso = false;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		sucesso = usuarioDAO.excluirUsuario(id);
		return sucesso;
	}
	
}