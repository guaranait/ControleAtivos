package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.DashboardDAO;
import br.com.restful.model.ContadorAtivo;
import br.com.restful.model.ContadorGarantia;

public class DashboardController {
	
	public ArrayList<ContadorAtivo> contadorAtivos(){
		return DashboardDAO.getInstance().contadorAtivos();
	}
	
	public ArrayList<ContadorGarantia> contadorGarantia(){
		return DashboardDAO.getInstance().contadorGarantia();
	}
	
	public ArrayList<Double> valorPatrimonio(){
		return DashboardDAO.getInstance().valorPatrimonio();
	}
	
}
