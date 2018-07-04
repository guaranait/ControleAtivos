package br.com.restful.model;

public class ContadorAtivo {
	private long disponivel = 0;
	private long emprestado = 0;
	private long manutencao = 0;
	
	public ContadorAtivo(long disponivel, long emprestado, long manutencao) {
		super();
		this.disponivel = disponivel;
		this.emprestado = emprestado;
		this.manutencao = manutencao;
	}

	public ContadorAtivo() {
		super();
	}

	public long getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(long disponivel) {
		this.disponivel = disponivel;
	}

	public long getEmprestado() {
		return emprestado;
	}

	public void setEmprestado(long emprestado) {
		this.emprestado = emprestado;
	}

	public long getManutencao() {
		return manutencao;
	}

	public void setManutencao(long manutencao) {
		this.manutencao = manutencao;
	}
	

}
