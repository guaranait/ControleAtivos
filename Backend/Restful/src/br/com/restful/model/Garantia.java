package br.com.restful.model;

import java.util.Date;

public class Garantia {
	private long id;
	private Ativo ativo = new Ativo();
	private String fornecedor;
	private String contato;
	private Date dtValidade;
	private long criadoPor;
	private long modificadoPor;
	private Date dtCriacao;
	private Date dtModificacao;
	
	public Garantia() {
		super();
	}

	public Garantia(long id, Ativo ativo, String fornecedor, String contato, Date dtValidade, long criadoPor, long modificadoPor,
			Date dtCriacao, Date dtModificacao) {
		super();
		this.id = id;
		this.ativo = ativo;
		this.fornecedor = fornecedor;
		this.contato = contato;
		this.dtValidade = dtValidade;
		this.criadoPor = criadoPor;
		this.modificadoPor = modificadoPor;
		this.dtCriacao = dtCriacao;
		this.dtModificacao = dtModificacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Date getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
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
