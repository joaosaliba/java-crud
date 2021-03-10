package com.Bank.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Bank.entity.Agencia;
import com.Bank.entity.Conta;

public class ContaDAO {

	public Conta getConta(int id) {
		Connection connection = ConnectionManager.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Conta WHERE  conta_id=" + id);

			if (rs.next()) {

				Conta Conta = new Conta();

				Conta.setId(rs.getInt("conta_id"));
				Conta.setValor(rs.getFloat("valor"));
				Conta.setDono(rs.getString("dono"));

				AgenciaDAO agencia = new AgenciaDAO();
				Conta.setAgencia(agencia.getAgencia(rs.getInt("agencia_fk")));

				connection.close();
				return Conta;

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;

	}

	public ArrayList<Conta> getAllContas() {
		Connection connection = ConnectionManager.getConnection();

		try {

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Conta");

			ArrayList<Conta> Contas = new ArrayList<Conta>();

			while (rs.next()) {
				Conta Conta = new Conta();
				Conta.setId(rs.getInt("conta_id"));
				Conta.setValor(rs.getFloat("valor"));
				Conta.setDono(rs.getString("dono"));
				AgenciaDAO agencia = new AgenciaDAO();
				Conta.setAgencia(agencia.getAgencia(rs.getInt("agencia_fk")));

				Contas.add(Conta);

			}

			connection.close();
			return Contas;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean insertConta(Conta Conta) throws SQLException {
		Connection connection = ConnectionManager.getConnection();
		try {

			PreparedStatement ps = connection.prepareStatement("INSERT INTO Conta VALUES(NULL, ?, ?, ?) ");
			Agencia agencia = Conta.getAgencia();
			ps.setInt(1, agencia.getId());
			ps.setString(2, Conta.getDono());
			ps.setFloat(3, Conta.getValor());
			ps.executeUpdate();
			connection.close();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;

	}

	public boolean updtadeConta(Conta Conta) {
		Connection connection = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE Conta SET agencia_fk=?,dono=?,valor=? where conta_id=? ");
			Agencia agencia = Conta.getAgencia();
			ps.setInt(1, agencia.getId());
			ps.setString(2, Conta.getDono());
			ps.setFloat(3, Conta.getValor());
			ps.setInt(4, Conta.getId());
			ps.executeUpdate();
				connection.close();
				return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;

	}

	public boolean deleteConta(int id) {
		Connection connection = ConnectionManager.getConnection();
		try {

			Statement st = connection.createStatement();

			 st.executeUpdate("DELETE FROM Conta WHERE conta_id =" + id);

				connection.close();
//				if (connection.isClosed() ==true) {
//					System.out.println("Fechado");
				return true;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
