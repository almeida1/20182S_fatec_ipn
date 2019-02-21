package com.fatec.sce.model;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
	private String url = "jdbc:mysql://localhost:3306/biblioteca";
	private String driver = "com.mysql.jdbc.Driver";
	private String usuario = "root";
	private String senha = "alunofatec";
	Logger logger = Logger.getLogger(FabricaDeConexoes.class);

	public FabricaDeConexoes(ConfiguraDB configura) {
		this.url = configura.getUrl();
		this.driver = configura.getDriver();
		this.usuario = configura.getUsuario();
		this.senha = configura.getSenha();
	}

	public FabricaDeConexoes() {
	}

	public Connection getConnection() {
		try {
			Class.forName(driver);
			return (Connection) DriverManager.getConnection(url, usuario, senha);
		
		} catch (SQLException e) {
			logger.info("Exceção geral causa SQLException: " + e.getMessage());
			throw new RuntimeException(e);
		} catch (Exception e) {
			logger.info("Exceçãoo geral causa: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
}