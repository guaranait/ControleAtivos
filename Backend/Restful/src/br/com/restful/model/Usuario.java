package br.com.restful.model;

import java.util.Date;

public class Usuario {

	private long id = 0;
	private String nome = "";
	private String cpf = "";
	private long idade = 0;
	private Date dt_nascimento = new Date();
	private String cargo = "";
	
	public Usuario() {
		super();
	}

	public Usuario(long id, String nome, String cpf, long idade, Date dt_nascimento, String cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.dt_nascimento = dt_nascimento;
		this.cargo = cargo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public long getIdade() {
		return idade;
	}

	public void setIdade(long idade) {
		this.idade = idade;
	}

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", dt_nascimento="
				+ dt_nascimento + ", cargo=" + cargo + "]";
	}
	
}
