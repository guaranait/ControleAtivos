package br.com.restful.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Emprestimo {
	private Funcionario funcionario = new Funcionario();
	private Ativo ativo = new Ativo();
	private Date dtEmprestimo;
	private Date dtDevolucao;
	private long criadoPor;
	private long modificadoPor;
	private Date dtCriacao;
	private Date dtModificacao;
	
	public Emprestimo() {
		super();
	}

	public Emprestimo(Funcionario funcionario, Ativo ativo, Date dtEmprestimo, Date dtDevolucao, long criadoPor,
			long modificadoPor, Date dtCriacao, Date dtModificacao) {
		super();
		this.funcionario = funcionario;
		this.ativo = ativo;
		this.dtEmprestimo = dtEmprestimo;
		this.dtDevolucao = dtDevolucao;
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

	public Date getDtEmprestimo() {
		return dtEmprestimo;
	}

	public void setDtEmprestimo(Date dtEmprestimo) {
		this.dtEmprestimo = dtEmprestimo;
	}

	public Date getDtDevolucao() {
		return dtDevolucao;
	}

	public void setDtDevolucao(Date dtdevolucao) {
		this.dtEmprestimo = dtDevolucao;
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
