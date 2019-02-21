package com.fatec.sce.model;


import java.sql.Connection;


public class MySQLDAOFactory extends DAOFactory {
	public static Connection createConnection() {
		return (Connection) new FabricaDeConexoes().getConnection();
	}

	@Override
	public LivroDAO getLivroDAO() {
		return new LivroDAO();
	}
}