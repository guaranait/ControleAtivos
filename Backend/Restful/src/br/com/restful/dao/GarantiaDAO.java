package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Garantia;

public class GarantiaDAO {

	private static GarantiaDAO instance;

	public static GarantiaDAO getInstance() {
		if (instance == null)
			instance = new GarantiaDAO();
		return instance;
	}

	public ArrayList<Garantia> listarGarantias() {
		String sql = "SELECT * FROM lu2cas01.GARANTIA";
		 
		ArrayList<Garantia> garantias = new ArrayList<Garantia>();
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		 
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		 
			while(rs.next()){
				Garantia garantia = new Garantia();

				garantia.setId(rs.getLong("id"));
				garantia.getAtivo().setId(rs.getLong("id_ativo"));
				garantia.setFornecedor(rs.getString("fornecedor"));
				garantia.setContato(rs.getString("contato"));
				garantia.setCriadoPor(rs.getLong("criado_por"));
				garantia.setDtCriacao(rs.getDate("dt_criacao"));
				garantia.setModificadoPor(rs.getLong("modificado_por"));
				garantia.setDtModificacao(rs.getDate("dt_modificacao"));
				
				garantias.add(garantia);
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
		return garantias;
	}
	
	
	public Boolean cadastrarGarantia(Garantia garantia) {
		String sql = "INSERT INTO lu2cas01.GARANTIA(id_ativo,fornecedor,contato,criado_por,dt_criacao)"
				+ " VALUES(?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean cadastrou = false;
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);

			pstm.setLong(1, garantia.getAtivo().getId());
			pstm.setString(2, garantia.getFornecedor());
			pstm.setString(3, garantia.getContato());
			pstm.setLong(4, garantia.getCriadoPor());
			pstm.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			
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

	public Boolean alterarGarantia(Garantia garantia) {
		String sql = "UPDATE lu2cas01.GARANTIA SET id_ativo = ?,fornecedor = ?,contato = ?,criado_por = ?,modificado_por = ?,dt_modificacao = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		boolean alterou = false;
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			
			pstm.setLong(1, garantia.getAtivo().getId());
			pstm.setString(2, garantia.getFornecedor());
			pstm.setString(3, garantia.getContato());
			pstm.setLong(4, garantia.getModificadoPor());
			pstm.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			pstm.setLong(6, garantia.getId());
			
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

	public boolean excluirGarantia(long id) {
		boolean sucesso = false;
		String sql = "DELETE FROM lu2cas01.GARANTIA WHERE id = ?";

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
