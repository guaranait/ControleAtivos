package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.UsuarioDAO;
import br.com.restful.model.Usuario;

public class UsuarioController {
	public Usuario getUsuario(long id){
		return UsuarioDAO.getInstance().getUsuario(id);
	}
	
}