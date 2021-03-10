package com.Bank.entity;

public class Agencia {
	
	private Integer id;
	private Integer num_agencia;
	private String razao_social;
	private String endereco;
	private String gerente;
	
	

	
	public Agencia() {

	}
	
	public Agencia(Integer id, Integer num_agencia,String razao_social, String endereco, String gerente) {
		this.id = id;
		this.num_agencia = num_agencia;
		this.razao_social = razao_social;
		this.endereco = endereco;
		this.gerente = gerente;
	}
	


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getNum_agencia() {
		return num_agencia;
	}

	public void setNum_agencia(Integer num_agencia) {
		this.num_agencia = num_agencia;
	}
	public String getRazao_social() {
		return razao_social;
	}
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getGerente() {
		return gerente;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	

}
