package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			 String usuario = "SA";
			 String senha = "";
			 String PathBase = "base\\cadastro";
			 String URL = "jdbc:hsqldb:file:" + PathBase + ";";

			return DriverManager.getConnection(URL, usuario, senha);
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
}
