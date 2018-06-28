package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Funcionario;
import br.com.restful.model.Usuario;
import sun.security.util.Password;
import br.com.restful.model.Usuario;

public class UsuarioDAO {
	
	private static UsuarioDAO instance;

	public static UsuarioDAO getInstance(){
		if(instance == null)
			instance = new UsuarioDAO();
		return instance;
	}
	
	public Usuario listarUsuario(long id) {
		Usuario usuario = new Usuario();
		return usuario;
	}
	
	
	public ArrayList<Usuario> listarUsuarios() {
		String sql = "SELECT * FROM lu2cas01.USUARIOS_SISTEMA";
		 
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		 
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				Usuario usuario = new Usuario();

				usuario.setId(rs.getLong("id"));
				usuario.setIdPerfil(rs.getLong("id_perfil"));
				usuario.setUsername(rs.getString("username"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setCriadoPor(rs.getLong("criado_por"));
				usuario.setDtCriacao(rs.getDate("dt_criacao"));
				usuario.setModificadoPor(rs.getLong("modificado_por"));
				usuario.setDtModificacao(rs.getDate("dt_modificacao"));
				
				usuarios.add(usuario);
			}
		 } catch (Exception e) {
			 e.printStackTrace();
		 }finally{
			 try{
				 if(rs != null){
					 rs.close();
				 }
				 if(pstm != null){
					 pstm.close();
				 }
				 if(conn != null){
					 conn.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }
		return usuarios;
	}
	
	
	public Boolean cadastrarUsuario(Usuario usuario) {
		String sql = "INSERT INTO lu2cas01.USUARIOS_SISTEMA(id_perfil,username,senha,criado_por,modificado_por,dt_criacao,dt_modificacao)"
				+ " VALUES(?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean cadastrou = false;
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);

			pstm.setLong(1, usuario.getIdPerfil());
			pstm.setString(2, usuario.getUsername());
			pstm.setString(3, usuario.getSenha());
			pstm.setLong(4, usuario.getCriadoPor());
			pstm.setLong(5, usuario.getModificadoPor());
			pstm.setDate(6, new java.sql.Date(System.currentTimeMillis()));
			pstm.setDate(7, new java.sql.Date(usuario.getDtModificacao().getTime()));
			
			// Executa a sql para inser��o dos dados
			if(pstm.executeUpdate() > 0){
				cadastrou = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conex�es
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cadastrou;
	}

	public Boolean alterarUsuario(Usuario usuario) {
		String sql = "UPDATE lu2cas01.USUARIOS_SISTEMA SET id_perfil = ?,username = ?,senha = ?,criado_por = ?,modificado_por = ?,dt_criacao = ?,dt_modificacao = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		boolean alterou = false;
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			
			pstm.setLong(1, usuario.getIdPerfil());
			pstm.setString(2, usuario.getUsername());
			pstm.setString(3, usuario.getSenha());
			pstm.setLong(4, usuario.getCriadoPor());
			pstm.setLong(5, usuario.getModificadoPor());
			pstm.setDate(6, new java.sql.Date(usuario.getDtCriacao().getTime()));
			pstm.setDate(7, new java.sql.Date(System.currentTimeMillis()));
			pstm.setLong(8, usuario.getId());
			
			// Executa a sql para inser��o dos dados
			if(pstm.executeUpdate() > 0){
				alterou = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conex�es
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return alterou;
	}

	public boolean excluirUsuario(long id) {
		boolean sucesso = false;
		String sql = "DELETE FROM lu2cas01.USUARIOS_SISTEMA WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);

			pstm.setLong(1, id);

			// Executa a sql para inser��o dos dados
			if(pstm.executeUpdate() > 0){
				sucesso = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conex�es
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sucesso;
	}
	
	public boolean loginUsuario(Usuario usuario) {
		boolean fezLogin = false;
		
		String sql = "SELECT count(*) temLogin FROM lu2cas01.USUARIOS_SISTEMA WHERE username = ? AND senha = ? ";
		 
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		 
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		 
			int temLogin = 0;
			if(rs.next()) {
				temLogin = rs.getInt("temLogin");
			}
			if(temLogin > 0) {
				fezLogin = true;
			}
		 } catch (Exception e) {
			 e.printStackTrace();
		 }finally{
			 try{
				 if(rs != null){
					 rs.close();
				 }
				 if(pstm != null){
					 pstm.close();
				 }
				 if(conn != null){
					 conn.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }
		return fezLogin;
	}
	
}
