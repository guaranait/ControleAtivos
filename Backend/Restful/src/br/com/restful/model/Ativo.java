package br.com.restful.model;

import java.util.Date;

public class Ativo {

	private long id = 0;
	private String descricao = "";
	private String fabricante = "";
	private Date dtCompra = new Date();
	private double vlCompra = 0.0;
	private double vlDepreciado = 0.0;
	private long idStatus = 0;
	private long criadoPor = 0;
	private long modificadoPor = 0;
	private Date dtCriacao = new Date();
	private Date dtModificacao = new Date();

	public Ativo(long id, String descricao, String fabricante, Date dtCompra, double vlCompra, double vlDepreciado,
			long idStatus, long criadoPor, long modificadoPor, Date dtCriacao, Date dtModificacao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.fabricante = fabricante;
		this.dtCompra = dtCompra;
		this.vlCompra = vlCompra;
		this.vlDepreciado = vlDepreciado;
		this.idStatus = idStatus;
		this.criadoPor = criadoPor;
		this.modificadoPor = modificadoPor;
		this.dtCriacao = dtCriacao;
		this.dtModificacao = dtModificacao;
	}

	public Ativo() {
		super();
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

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Date getDtCompra() {
		return dtCompra;
	}

	public void setDtCompra(Date dtCompra) {
		this.dtCompra = dtCompra;
	}

	public double getVlCompra() {
		return vlCompra;
	}

	public void setVlCompra(double vlCompra) {
		this.vlCompra = vlCompra;
	}

	public double getVlDepreciado() {
		return vlDepreciado;
	}

	public void setVlDepreciado(double vlDepreciado) {
		this.vlDepreciado = vlDepreciado;
	}

	public long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(long idStatus) {
		this.idStatus = idStatus;
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

	@Override
	public String toString() {
		return "Ativo [id=" + id + ", descricao=" + descricao + ", fabricante=" + fabricante + ", dtCompra=" + dtCompra
				+ ", vlCompra=" + vlCompra + ", vlDepreciado=" + vlDepreciado + ", idStatus=" + idStatus
				+ ", criadoPor=" + criadoPor + ", modificadoPor=" + modificadoPor + ", dtCriacao=" + dtCriacao
				+ ", dtModificacao=" + dtModificacao + "]";
	}

}
