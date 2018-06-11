package br.com.restful.model;

import java.util.Date;

public class Emprestimo {
	private Funcionario funcionario;
	private Ativo ativo;
	private Date dt_emprestimo;
	private Date dt_devolucao;
	private long criadoPor;
	private long modificadoPor;
	private Date dtCriacao;
	private Date dtModificacao;
	
	public Emprestimo() {
		super();
	}

	public Emprestimo(Funcionario funcionario, Ativo ativo, Date dt_emprestimo, Date dt_devolucao, long criadoPor,
			long modificadoPor, Date dtCriacao, Date dtModificacao) {
		super();
		this.funcionario = funcionario;
		this.ativo = ativo;
		this.dt_emprestimo = dt_emprestimo;
		this.dt_devolucao = dt_devolucao;
		this.criadoPor = criadoPor;
		this.modificadoPor = modificadoPor;
		this.dtCriacao = dtCriacao;
		this.dtModificacao = dtModificacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	public Date getDt_emprestimo() {
		return dt_emprestimo;
	}

	public void setDt_emprestimo(Date dt_emprestimo) {
		this.dt_emprestimo = dt_emprestimo;
	}

	public Date getDt_devolucao() {
		return dt_devolucao;
	}

	public void setDt_devolucao(Date dt_devolucao) {
		this.dt_devolucao = dt_devolucao;
	}

	public long getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(long criadoPor) {
		this.criadoPor = criadoPor;
	}

	public long getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(long modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Date getDtModificacao() {
		return dtModificacao;
	}

	public void setDtModificacao(Date dtModificacao) {
		this.dtModificacao = dtModificacao;
	}
	
	
	
}
