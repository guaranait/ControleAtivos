package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.ContadorAtivo;
import br.com.restful.model.ContadorGarantia;

public class DashboardDAO {

	private static DashboardDAO instance;

	public static DashboardDAO getInstance() {
		if (instance == null)
			instance = new DashboardDAO();
		return instance;
	}

	public ArrayList<ContadorAtivo> contadorAtivos() {
		//String sql = "SELECT s.descricao descricao, count(a.id) total FROM lu2cas01.ATIVO a, lu2cas01.STATUS s WHERE a.id_status = s.id GROUP BY s.descricao";
		String sql = "select " + 
				" (select count(*) " + 
				" from lu2cas01.ATIVO " + 
				" where id_status = 1) DISPONIVEL, " + 
				" (select count(*) " + 
				" from lu2cas01.ATIVO " + 
				" where id_status = 3) EMPRESTADO, " + 
				" (select count(*) " + 
				" from lu2cas01.ATIVO " + 
				" where id_status = 2) MANUTENCAO "; 
		
		ArrayList<ContadorAtivo> contadorAtivoList = new ArrayList<>();
		ContadorAtivo contadorAtivo = new ContadorAtivo();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		 
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		 
			while(rs.next()){
				contadorAtivo.setDisponivel(rs.getLong("DISPONIVEL"));
				contadorAtivo.setEmprestado(rs.getLong("EMPRESTADO"));
				contadorAtivo.setManutencao(rs.getLong("MANUTENCAO"));
				
				contadorAtivoList.add(contadorAtivo);
			}
		 } catch (Exception e) {
			 e.printStackTrace();
		 }finally{
			 try{
				 if(rs != null){
					 rs.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }
		return contadorAtivoList;
	}
	
	public ArrayList<ContadorGarantia> contadorGarantia() {
		//String sql = "SELECT s.descricao descricao, count(a.id) total FROM lu2cas01.ATIVO a, lu2cas01.STATUS s WHERE a.id_status = s.id GROUP BY s.descricao";
		String sql = " SELECT (" + 
				" SELECT COUNT(*) " + 
				" FROM lu2cas01.GARANTIA " + 
				" WHERE MONTH(dt_validade) = MONTH(NOW()) " + 
				" AND YEAR(dt_validade) = YEAR(NOW()) " + 
				" AND DAY(dt_validade) >= DAY(NOW())) venceMes, " + 
				" (SELECT COUNT(*) " + 
				" FROM lu2cas01.GARANTIA " + 
				" WHERE dt_validade < NOW()) vencida, " + 
				" (SELECT (COUNT(*) - venceMes) " + 
				" FROM lu2cas01.GARANTIA " + 
				" WHERE dt_validade >= NOW()) aVencer ";
		
		ArrayList<ContadorGarantia> contadorGarantiaList = new ArrayList<>();
		ContadorGarantia contadorGarantia = new ContadorGarantia();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		 
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		 
			while(rs.next()){
				contadorGarantia.setaVencer(rs.getLong("aVencer"));
				contadorGarantia.setVencida(rs.getLong("vencida"));
				contadorGarantia.setVenceMes(rs.getLong("venceMes"));
				
				contadorGarantiaList.add(contadorGarantia);
			}
		 } catch (Exception e) {
			 e.printStackTrace();
		 }finally{
			 try{
				 if(rs != null){
					 rs.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }
		return contadorGarantiaList;
	}

	public ArrayList<Double> valorPatrimonio() {
		String sql = "SELECT SUM(vl_compra) - SUM(vl_depreciado) valorPatrimonio FROM lu2cas01.ATIVO WHERE ID_STATUS != 3";
		
		double valor = 0.0;
		ArrayList<Double> valorPatrimonio = new ArrayList<>();
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		 
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		 
			if(rs.next()) {
				valor = rs.getDouble("valorPatrimonio");
				valorPatrimonio.add(valor);
			}
			
		 } catch (Exception e) {
			 e.printStackTrace();
		 }finally{
			 try{
				 if(rs != null){
					 rs.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }
		return valorPatrimonio;
	}
	
	
	
}
