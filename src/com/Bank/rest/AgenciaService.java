package com.Bank.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bank.entity.Agencia;
import com.Bank.persistence.AgenciaDAO;

@Path("/Agencia")
public class AgenciaService {
	

	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	private AgenciaDAO dao;
	
	public AgenciaService(){
		dao = new AgenciaDAO();
	}

	protected void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response AgenciaCreate(Agencia Agencia) {
		try {
		
			dao.insertAgencia(Agencia);
			
			return Response.status(200).entity("Cadastrado").build();
			 
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao adicionar novo ").build();
		}
	}

	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response AgenciaRead() {
		ArrayList<Agencia> Agencias = new ArrayList<>();
		try {
			
			Agencias = dao.getAllAgencias();
			
			
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar Agencias").build();
		}

		
		
		return Response.status(Status.OK).entity(Agencias).build();
	}


	
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response AgenciaDelete(@PathParam("id") Integer id) {
		try {
			dao.deleteAgencia(id);
			return Response.status(200).entity(" excluido com Sucesso").build();

		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	@Path("update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	public Response AgenciaUpdate(@PathParam("id") Integer id, Agencia Agencia) {
		try {
			boolean isOk=false;
			Agencia.setId(id);
			isOk = dao.updtadeAgencia(Agencia);
			return Response.status(200).entity(isOk).build();
		}catch (Exception e ) {
			throw new WebApplicationException(500);
		}
	}
	
	@Path("get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response AgenciaGet(@PathParam("id") Integer id) {
		Agencia  agencia = new Agencia();
		try {
			agencia =dao.getAgencia(id);
			return Response.status(200).entity(agencia).build();

		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}


	
	

}
