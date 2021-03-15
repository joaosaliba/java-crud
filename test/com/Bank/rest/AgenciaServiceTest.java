package com.Bank.rest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.Bank.entity.Agencia;

public class AgenciaServiceTest {
	
	private static HttpServletRequest request;
	private static AgenciaService service;
	
	
	private static Agencia agencia = Mockito.mock(Agencia.class);
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		request = Mockito.mock(HttpServletRequest.class);
		
		service = new AgenciaService();
		service.setRequest(request);
		
	}
	
	@Test
	void testAgenciaRead() {
		Response response = service.AgenciaRead();
		assertTrue(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode());
	}

	@Test
	void testAgenciaCreate() {
//		Agencia Agencia = new Agencia(id,2525,"Banco Bom","Rua das pedras","Lazinho");
		
		Response response = service.AgenciaCreate(agencia);
		assertTrue(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode());
	}

	@Test
	void testAgenciaUpdate() {
//		Agencia Agencia = new Agencia(id,3333,"Banco Atualizado","Rua das conchas","Jubiscreu");
		Agencia agencia = Mockito.mock(Agencia.class);
		Response response = service.AgenciaUpdate(agencia.getId(), agencia);
		assertTrue(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode());
	}

	@Test
	void testAgenciaDelete() {
		Response response = service.AgenciaDelete(agencia.getId());
		assertTrue(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode());
	}
	
}
