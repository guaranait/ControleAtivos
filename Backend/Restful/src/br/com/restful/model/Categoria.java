package br.com.restful.model;

import java.util.Date;

public class Categoria {
	private long id;
	private String descricao;
	private Date dtDepreciacao;
	private double prcntDepre;
	private long criadoPor;
	private long modificadoPor;
	private Date dtCriacao;
	private Date dtModificacao;
	
	public Categoria() {
		super();
	}

	public Categoria(long id, String descricao, Date dtDepreciacao, double prcntDepre, long criadoPor, long modificadoPor, Date dtCriacao,
			Date dtModificacao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dtDepreciacao = dtDepreciacao;
		this.prcntDepre = prcntDepre;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDtDepreciacao() {
		return dtDepreciacao;
	}

	public void setDtDepreciacao(Date dtDepreciacao) {
		this.dtDepreciacao = dtDepreciacao;
	}
	
	public double getPrcntDepre() {
		return prcntDepre;
	}

	public void setPrcntDepre(double prcntDepre) {
		this.prcntDepre = prcntDepre;
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
