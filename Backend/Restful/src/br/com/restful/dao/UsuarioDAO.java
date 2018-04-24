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
	
	public ArrayList<Usuario> listarUsuarios(){
		/*Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;*/
		ArrayList<Usuario> usuarios = null;
		
		//teste
		usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();
		usuario.setId(01);
		usuario.setNome("Geromel");
		usuario.setCpf("123456789");
		usuario.setCargo("Desenvolvedor iOS");
		usuarios.add(usuario);
		
		/*conexao = criarConexao();
		usuarios = new ArrayList<Usuario>();
		try {
			pstmt = conexao.prepareStatement("select * from usuario order by nome");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setCargo(rs.getString("cargo"));
				
				usuarios.add(usuario);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os usuarios: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}*/
		
		return usuarios;
	}
	
	public Usuario listarUsuario(long id){
		/*Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;*/
		
		//teste
		Usuario usuario = new Usuario();
		usuario.setId(01);
		usuario.setNome("Geromel");
		usuario.setCpf("123456789");
		usuario.setCargo("Desenvolvedor iOS");
		
		/*conexao = criarConexao();
		try {
			pstmt = conexao.prepareStatement("select * from usuario where id = ? order by nome");
			rs = pstmt.executeQuery();
			
			if(rs.hasNext){
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setCargo(rs.getString("cargo"));
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os usuarios: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}*/
		
		return usuario;
	}
	
}
