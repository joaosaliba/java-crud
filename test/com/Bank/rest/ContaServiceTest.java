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
	
	
	private static Agencia Agencia = Mockito.mock(Agencia.class);
	private static Conta Conta= Mockito.mock(Conta.class);
	
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
//		Agencia Agencia = new Agencia(Agencia.,2525,"Banco Bom","Rua das pedras","Lazinho");
		Conta Conta= new Conta(1,Agencia,"Felipe", 30000.00f);
		
		Response response = service.ContaCreate(Conta);
		
		assertTrue(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode());
	}
	
	@Test
	void testContaGet() {
		Response response = service.ContaGet(Conta.getId());
		assertTrue(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode());
	}


	@Test
	void testContapdate() {
//		Agencia Agencia = new Agencia(1,3333,"Banco Atualizado","Rua das conchas","Jubiscreu");
		Conta Conta= new Conta(1,Agencia,"Eduardo", 30000.00f);
		Response response = service.ContaUpdate(Conta.getId(), Conta);
		assertTrue(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode());
	}
	
	
	@Test
	void testContaDelete() {
		Response response = service.ContaDelete(Conta.getId());
		assertTrue(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode());
	}

	
}
