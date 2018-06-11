package br.com.restful.controller;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.restful.dao.DashboardDAO;

public class DashboardController {
	
	public ArrayList<HashMap> contadorAtivos(){
		return DashboardDAO.getInstance().contadorAtivos();
	}
	
	public ArrayList<Double> valorPatrimonio(){
		return DashboardDAO.getInstance().valorPatrimonio();
	}
	
}
