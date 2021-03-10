package com.Bank.persistence;

import java.util.ArrayList;

import com.Bank.entity.Agencia;

public interface AgenciaInterface {
	Agencia getAgencia();
	ArrayList<Agencia> getAllAgencias();
	
	boolean insertAgencia();
	boolean updateAgencia();
	boolean deleteAgencia();

}
