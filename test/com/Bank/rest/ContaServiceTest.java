package com.Bank.rest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.Bank.entity.Agencia;
import com.Bank.entity.Conta;

public class ContaServiceTest {
	
	private static HttpServletRequest request;
	private static ContaService service;
	
	
	private static Integer id_conta = 2;
	private static Integer id_agencia =1;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		request = Mockito.mock(HttpServletRequest.class);
		
		service = new ContaService();
		service.setRequest(request);
		
	}
	
	@Test
	void testContaRead() {
		Response response = service.ContaRead();
		assertTrue(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode());
	}
	
	
	@Test
	void testContaCreate() {
		Agencia Agencia = new Agencia(id_agencia,2525,"Banco Bom","Rua das pedras","Lazinho");
		Conta Conta= new Conta(id_conta,Agencia,"Felipe", 30000.00f);
		
		Response response = service.ContaCreate(Conta);
		
		assertTrue(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode());
	}
	
	@Test
	void testContaGet() {
		Response response = service.ContaGet(id_conta);
		assertTrue(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode());
	}


	@Test
	void testContapdate() {
		Agencia Agencia = new Agencia(id_agencia,3333,"Banco Atualizado","Rua das conchas","Jubiscreu");
		Conta Conta= new Conta(id_conta,Agencia,"Eduardo", 30000.00f);
		Response response = service.ContaUpdate(id_conta, Conta);
		assertTrue(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode());
	}
	
	
	@Test
	void testContaDelete() {
		Response response = service.ContaDelete(id_conta);
		assertTrue(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode());
	}

	
}
