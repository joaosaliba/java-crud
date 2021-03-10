package com.Bank.entity;

public class Conta {
	
	private Integer id;
	private Agencia agencia;
	private String dono;
	private  Float valor;
	

	public Conta() {

	}


	public Conta(Integer id, Agencia agencia, String dono, Float valor) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.dono = dono;
		this.valor = valor;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Agencia getAgencia() {
		return agencia;
	}


	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}


	public String getDono() {
		return dono;
	}


	public void setDono(String dono) {
		this.dono = dono;
	}


	public Float getValor() {
		return valor;
	}


	public void setValor(Float valor) {
		this.valor = valor;
	}
	

	
	
}
