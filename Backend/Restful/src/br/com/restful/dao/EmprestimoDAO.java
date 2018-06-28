package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Ativo;
import br.com.restful.model.Emprestimo;

public class EmprestimoDAO {

	private static EmprestimoDAO instance;

	public static EmprestimoDAO getInstance() {
		if (instance == null)
			instance = new EmprestimoDAO();
		return instance;
	}

	public ArrayList<Emprestimo> listarEmprestimos() {
		String sql =  " SELECT a.id idAtivo, a.descricao descricao, f.id idFuncionario, f.nome nomeFuncionario, e.dt_emprestimo dtEmprestimo "
					+ " FROM   lu2cas01.EMPRESTIMO e, "
					+ "		   lu2cas01.FUNCIONARIO f, "
					+ "		   lu2cas01.ATIVO a "
					+ " WHERE  e.id_funcionario = f.id "
					+ "   AND  e.id_ativo = a.id ";
		 
		ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		 
			while(rs.next()){
				Emprestimo emprestimo = new Emprestimo();

				emprestimo.getFuncionario().setNome(rs.getString("nomeFuncionario"));
				emprestimo.getAtivo().setId(rs.getLong("idAtivo"));
				emprestimo.getAtivo().setDescricao(rs.getString("descricao"));
				emprestimo.getFuncionario().setId(rs.getLong("idFuncionario"));;
				emprestimo.setDtEmprestimo(rs.getDate("dtEmprestimo"));
				
				emprestimos.add(emprestimo);
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
		return emprestimos;
	}
	
	public ArrayList<Emprestimo> listarEmprestimo(Emprestimo emprestimo) {
		ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		int i = 0;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM lu2cas01.EMPRESTIMO WHERE 1=1 ";
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			
			/*if(ativo.getId() > 0) {
				sql += " and id = ? ";
				i++;
				pstm.setLong(i, ativo.getId());
			}else if(!ativo.getDescricao().isEmpty()) {
				sql += " and descricao = ? ";
				i++;
				pstm.setString(i, ativo.getDescricao());
			}else if(ativo.getDtCompra() != null && !ativo.getDtCompra().equals("")) {
				sql += " and dt_compra = ? ";
				i++;
				pstm.setDate(i, new java.sql.Date(ativo.getDtCompra().getTime()));
			}else if(!ativo.getFabricante().isEmpty()) {
				sql += " and fabricante = ? ";
				i++;
				pstm.setString(i, ativo.getFabricante());
			}else if(ativo.getVlCompra() > 0) {
				sql += " and vl_compra = ? ";
				i++;
				pstm.setDouble(i, ativo.getVlCompra());
			}else if(ativo.getVlDepreciado() > 0) {
				sql += " and vl_depreciado = ? ";
				i++;
				pstm.setDouble(i, ativo.getVlDepreciado());
			}else if(ativo.getIdStatus() > 0) {
				sql += " and id_status = ? ";
				i++;
				pstm.setLong(i, ativo.getIdStatus());
			}else if(!ativo.getObservacao().isEmpty()) {
				sql += " and observacao = ? ";
				i++;
				pstm.setString(i, ativo.getObservacao());
			}else if(ativo.getCategoria().getId() > 0) {
				sql += " and id_categoria = ? ";
				i++;
				pstm.setLong(i, ativo.getCategoria().getId());
			}*/
			
			rs = pstm.executeQuery();
		 
			
			while(rs.next()){
				/*Ativo ati = new Ativo();
				 
				ativo.setId(rs.getLong("id"));
				ativo.setDescricao(rs.getString("descricao")); 
				ativo.setDtCompra(rs.getDate("dt_compra"));
				ativo.setFabricante(rs.getString("fabricante"));
				ativo.setVlCompra(rs.getDouble("vl_compra"));
				ativo.setVlDepreciado(rs.getDouble("vl_depreciado"));
				ativo.setCriadoPor(rs.getLong("criado_por"));
				ativo.setDtCriacao(rs.getDate("dt_criacao"));
				ativo.setIdStatus(rs.getLong("id_status"));
				ativo.setModificadoPor(rs.getLong("modificado_por"));
				ativo.setDtModificacao(rs.getDate("dt_modificacao"));
				ativo.setObservacao(rs.getString("observacao"));
				ativo.getCategoria().setId(rs.getLong("id_categoria"));
				 
				ativos.add(ati);*/
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

		return emprestimos;
	}
	
	public Boolean cadastrarEmprestimo(Emprestimo emprestimo) {
		String sql = "INSERT INTO lu2cas01.GARANTIA(id_ativo,id_funcionario,dt_emprestimo,dt_devolucao,criado_por,dt_criacao)"
				+ " VALUES(?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean cadastrou = false;
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);

			pstm.setLong(1, emprestimo.getAtivo().getId());
			pstm.setLong(2, emprestimo.getFuncionario().getId());
			pstm.setDate(3, new java.sql.Date(emprestimo.getDtEmprestimo().getTime()));
			pstm.setDate(4, new java.sql.Date(emprestimo.getDtDevolucao().getTime()));
			pstm.setLong(5, emprestimo.getCriadoPor());
			pstm.setDate(6, new java.sql.Date(System.currentTimeMillis()));
			
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

	public Boolean alterarEmprestimo(Emprestimo emprestimo) {
		String sql = "UPDATE lu2cas01.GARANTIA SET dt_emprestimo = ?,dt_devolucao = ?,modificado_por = ?,dt_modificacao = ? WHERE id_ativo = ? AND id_funcionario = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		boolean alterou = false;
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			
			pstm.setDate(1, new java.sql.Date(emprestimo.getDtEmprestimo().getTime()));
			pstm.setDate(2, new java.sql.Date(emprestimo.getDtDevolucao().getTime()));
			pstm.setLong(3, emprestimo.getModificadoPor());
			pstm.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			pstm.setLong(5, emprestimo.getAtivo().getId());
			pstm.setLong(6, emprestimo.getFuncionario().getId());
			
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

	public boolean devolverEmprestimo(Emprestimo emprestimo) {
		boolean sucesso = false;
		String sql = "UPDATE lu2cas01.EMPRESTIMO SET dt_devolucao = ?, modificado_por = ?, dt_modificacao = ? WHERE id_ativo = ? AND id_funcionario = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);

			pstm.setDate(1, new java.sql.Date(emprestimo.getDtDevolucao().getTime()));
			pstm.setLong(2, emprestimo.getModificadoPor());
			pstm.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			pstm.setLong(4, emprestimo.getAtivo().getId());
			pstm.setLong(5, emprestimo.getFuncionario().getId());

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
