package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.UsuarioDAO;
import br.com.restful.model.Usuario;

public class UsuarioController {
	public ArrayList<Usuario> listarUsuarios(){
		return UsuarioDAO.getInstance().listarUsuarios();
	}
	
}