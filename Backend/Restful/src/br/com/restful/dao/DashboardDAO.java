package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Ativo;

public class DashboardDAO {

	private static DashboardDAO instance;

	public static DashboardDAO getInstance() {
		if (instance == null)
			instance = new DashboardDAO();
		return instance;
	}

	public ArrayList<HashMap> contadorAtivos() {
		String sql = "SELECT s.descricao descricao, count(a.id) total FROM lu2cas01.ATIVO a, lu2cas01.STATUS s WHERE a.id_status = s.id GROUP BY s.descricao";
		 
		ArrayList<HashMap> contadorAtivos = new ArrayList<>();
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		 
		try {
			conn = ConnectionFactory.criarConexao();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		 
			while(rs.next()){
				HashMap<String, Long> contador = new HashMap<>();
				 
				contador.put(rs.getString("descricao"), rs.getLong("total"));

				contadorAtivos.add(contador);
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
		return contadorAtivos;
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
