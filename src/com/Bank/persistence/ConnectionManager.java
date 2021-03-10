package com.Bank.persistence;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
	
	public static final String URL = "jdbc:mysql://localhost:3306/banco";
	public static final String USER = "root";
	public static final String PASS= "password";
	
	
	public static Connection getConnection() {
		try {
			DriverManager.registerDriver(new Driver());
			System.out.println("Conectou ");
			return DriverManager.getConnection(URL, USER, PASS);
		}catch (SQLException ex) {
			System.out.println("não conectou");
			throw new RuntimeException("Erro de conexao com banco",ex);
		}
	}

	
	
//	public static void main(String[] args) {
//		Connection connection = ConnectionManager.getConnection();
//	}
//	
	

}
