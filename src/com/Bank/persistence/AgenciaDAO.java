package com.Bank.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Bank.entity.Agencia;

public class AgenciaDAO {

	public Agencia getAgencia(int id)  {
		Connection connection = ConnectionManager.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Agencia WHERE  agencia_id=" + id);

			if (rs.next()) {
				Agencia agencia = new Agencia();

				agencia.setId(rs.getInt("agencia_id"));
				agencia.setNum_agencia(rs.getInt("num_agencia"));
				agencia.setEndereco(rs.getString("endereco"));
				agencia.setRazao_social(rs.getString("razao_social"));
				agencia.setGerente(rs.getString("gerente"));

				return agencia;

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
		return null;
	}

	public ArrayList<Agencia> getAllAgencias() {
		Connection connection = ConnectionManager.getConnection();
		ArrayList<Agencia> agencias = new ArrayList<Agencia>();

		try {

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Agencia");

			

			while (rs.next()) {
				Agencia agencia = new Agencia();
				agencia.setId(rs.getInt("agencia_id"));
				agencia.setNum_agencia(rs.getInt("num_agencia"));
				agencia.setRazao_social(rs.getString("razao_social"));
				agencia.setEndereco(rs.getString("endereco"));
				agencia.setGerente(rs.getString("gerente"));

				agencias.add(agencia);
				

			}
		

		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
		return agencias;
	}

	public boolean insertAgencia(Agencia agencia)  {
		Connection connection = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Agencia VALUES(NULL, ?, ?, ?, ?) ");
			ps.setInt(1, agencia.getNum_agencia());
			ps.setString(2, agencia.getRazao_social());
			ps.setString(3, agencia.getEndereco());
			ps.setString(4, agencia.getGerente());
			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
		return false;

	}

	public boolean updtadeAgencia(Agencia agencia) {
		Connection connection = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE Agencia SET num_agencia=?,razao_social=?,endereco=?,gerente=? where agencia_id=? ");
			ps.setInt(1,agencia.getNum_agencia());
			ps.setString(2, agencia.getRazao_social());
			ps.setString(3, agencia.getEndereco());
			ps.setString(4, agencia.getGerente());
			ps.setInt(5, agencia.getId());
			int i = ps.executeUpdate();
			if(i ==1) {
				return true;
			}
			
		}catch( SQLException ex){
			ex.printStackTrace();
		}
		return false;
		
	}

	public boolean deleteAgencia(int id)  {
		Connection connection = ConnectionManager.getConnection();
		try {
			Statement st = connection.createStatement();
			int i = st.executeUpdate("DELETE FROM Agencia WHERE agencia_id =" + id);
			if (i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
		return false;
	}
}
