package br.com.restful.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Categoria;

public class CategoriaDAO {

	private static CategoriaDAO instance;

	public static CategoriaDAO getInstance() {
		if (instance == null)
			instance = new CategoriaDAO();
		return instance;
	}

	public ArrayList<Categoria> listarCategorias() {
		String sql = "SELECT * FROM lu2cas01.CATEGORIA";
		 
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		 
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		 
			while(rs.next()){
				Categoria categoria = new Categoria();

				categoria.setId(rs.getLong("id"));
				categoria.setDescricao(rs.getString("descricao"));
				categoria.setDtModificacao(rs.getDate("dt_depreciacao"));
				categoria.setCriadoPor(rs.getLong("criado_por"));
				categoria.setDtCriacao(rs.getDate("dt_criacao"));
				categoria.setModificadoPor(rs.getLong("modificado_por"));
				categoria.setDtModificacao(rs.getDate("dt_modificacao"));
				
				categorias.add(categoria);
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
		return categorias;
	}

	public Categoria listarCategoria(long id) {
		Categoria categoria = new Categoria();
		
		String sql = "SELECT * FROM lu2cas01.ATIVO WHERE id = ?";
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		 
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			
			pstm.setLong(1, id);
			
			rs = pstm.executeQuery();
		 
			if(rs.next()){
				 
				categoria.setId(rs.getLong("id"));
				categoria.setDescricao(rs.getString("descricao"));
				categoria.setDtModificacao(rs.getDate("dtDepreciacao"));
				categoria.setCriadoPor(rs.getLong("criado_por"));
				categoria.setDtCriacao(rs.getDate("dt_criacao"));
				categoria.setModificadoPor(rs.getLong("modificado_por"));
				categoria.setDtModificacao(rs.getDate("dt_modificacao"));
				
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

		return categoria;
	}

	public Boolean cadastrarCategoria(Categoria categoria) {
		String sql = "INSERT INTO lu2cas01.CATEGORIA(descricao,dt_depreciacao,criado_por,dt_criacao)"
				+ " VALUES(?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean cadastrou = false;
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, categoria.getDescricao());
			pstm.setDate(2, new java.sql.Date(categoria.getDtDepreciacao().getTime()));
			pstm.setLong(3, categoria.getCriadoPor());
			pstm.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			
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

	public Boolean alterarCategoria(Categoria categoria) {
		String sql = "UPDATE lu2cas01.CATEGORIA SET descricao = ?,dt_depreciacao = ?,modificado_por = ?,dt_modificacao = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		boolean alterou = false;
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, categoria.getDescricao());
			pstm.setDate(2, new java.sql.Date(categoria.getDtDepreciacao().getTime()));
			pstm.setLong(3, categoria.getModificadoPor());
			pstm.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			pstm.setLong(6, categoria.getId());

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

	public boolean excluirCategoria(long id) {
		boolean sucesso = false;
		String sql = "DELETE FROM lu2cas01.CATEGORIA WHERE id = ?";

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

}
