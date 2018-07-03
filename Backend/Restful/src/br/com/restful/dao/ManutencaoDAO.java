package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Ativo;
import br.com.restful.model.Funcionario;
import br.com.restful.model.Manutencao;

public class ManutencaoDAO {

	private static ManutencaoDAO instance;

	public static ManutencaoDAO getInstance() {
		if (instance == null)
			instance = new ManutencaoDAO();
		return instance;
	}
	
	public ArrayList<Manutencao> listarManutencoes() {
		String sql = "SELECT a.id,"
				+ "a.descricao, "
				+ "a.fabricante, "
				+ "a.dt_compra, "
				+ "a.vl_compra, "
				+ "a.vl_depreciado, "
				+ "a.id_status, "
				+ "a.observacao, "
				+ "a.id_categoria, "
				+ "a.criado_por, "
				+ "a.modificado_por, "
				+ "a.dt_criacao, "
				+ "a.dt_modificacao, "
				+ "m.id, "
				+ "m.id_ativo, "
				+ "m.descricao, "
				+ "m.dt_conserto, "
				+ "m.criado_por, "
				+ "m.modificado_por, "
				+ "m.dt_criacao, "
				+ "m.dt_modificacao "
				+ "FROM lu2cas01.ATIVO a, lu2cas01.MANUTENCAO m WHERE m.id_ativo = a.id ";
		 
		ArrayList<Manutencao> manutencoes = new ArrayList<Manutencao>();
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		 
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		 
			while(rs.next()){
				Ativo ativo = new Ativo();
				Manutencao manutencao = new Manutencao();
				
				ativo.setId(rs.getLong("a.id"));
				ativo.setDescricao(rs.getString("a.descricao")); 
				ativo.setDtCompra(rs.getDate("a.dt_compra"));
				ativo.setFabricante(rs.getString("a.fabricante"));
				ativo.setVlCompra(rs.getDouble("a.vl_compra"));
				ativo.setVlDepreciado(rs.getDouble("a.vl_depreciado"));
				ativo.setCriadoPor(rs.getLong("a.criado_por"));
				ativo.setDtCriacao(rs.getDate("a.dt_criacao"));
				ativo.setIdStatus(rs.getLong("a.id_status"));
				ativo.setModificadoPor(rs.getLong("a.modificado_por"));
				ativo.setDtModificacao(rs.getDate("a.dt_modificacao"));
				ativo.setObservacao(rs.getString("a.observacao"));
				ativo.getCategoria().setId(rs.getLong("a.id_categoria"));
				
				manutencao.setDescricao(rs.getString("m.descricao"));
				manutencao.setDtConserto(rs.getDate("m.dt_conserto"));
				manutencao.setCriadoPor(rs.getLong("m.criado_por"));
				manutencao.setDtCriacao(rs.getDate("m.dt_criacao"));
				manutencao.setId(rs.getLong("m.id"));
				manutencao.setModificadoPor(rs.getLong("m.modificado_por"));
				manutencao.setDtModificacao(rs.getDate("m.dt_modificacao"));
				
				manutencao.setAtivo(ativo);
				manutencoes.add(manutencao);
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
		return manutencoes;
	}
	
	public Boolean cadastrarManutencao(Manutencao manutencao) {
		String sql = "INSERT INTO lu2cas01.MANUTENCAO(descricao,id_ativo,dt_conserto,dt_entrada,criado_por,dt_criacao)"
				+ " VALUES(?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean cadastrou = false;
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, manutencao.getDescricao());
			pstm.setLong(2, manutencao.getAtivo().getId());
			pstm.setDate(3, new java.sql.Date(System.currentTimeMillis())); //dtConserto
			pstm.setDate(4, new java.sql.Date(System.currentTimeMillis())); //dtConserto
			pstm.setLong(5, manutencao.getCriadoPor());
			pstm.setDate(6, new java.sql.Date(System.currentTimeMillis())); //dtCriacao
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
	
	public Boolean concluirManutencao(Manutencao manutencao) {
		String sql = "UPDATE lu2cas01.MANUTENCAO SET descricao = ?, dt_conserto = ?, modificado_por = ?, dt_modificacao = ? WHERE id_ativo = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean cadastrou = false;
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, manutencao.getDescricao());
			pstm.setDate(2, new java.sql.Date(System.currentTimeMillis())); //dtConserto
			pstm.setLong(3, manutencao.getModificadoPor());
			pstm.setDate(4, new java.sql.Date(System.currentTimeMillis())); //dtCriacao
			pstm.setLong(5, manutencao.getAtivo().getId());
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
	
}
