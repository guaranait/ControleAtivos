package br.com.restful.dao;

import java.util.ArrayList;

import br.com.restful.model.Usuario;

public class UsuarioDAO {
	
	private static UsuarioDAO instance;

	public static UsuarioDAO getInstance(){
		if(instance == null)
			instance = new UsuarioDAO();
		return instance;
	}
	
	
	public Usuario getUsuario(long id){
		Usuario usuario = new Usuario();
		return usuario;
	}
	
}
